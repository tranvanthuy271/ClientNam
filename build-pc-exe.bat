@echo off
setlocal EnableExtensions EnableDelayedExpansion

cd /d "%~dp0"

set "APP_NAME=LangLaNam"
set "MAIN_CLASS=com.beatdz.langlalau.DesktopLauncher"
set "MAIN_JAR=client-1.0-SNAPSHOT.jar"
set "CLIENT_INSTALL=%~dp0srcClientdetu\build\install\LangLaNam-PC"
set "CLIENT_LIB=%CLIENT_INSTALL%\lib"
set "OUT_ROOT=%~dp0build-output\pc"
set "APP_IMAGE=%OUT_ROOT%\%APP_NAME%"
set "DATA_DIR=%~dp0srcClientdetu\Langla_data"

echo.
echo [PC] Building desktop client...
set "GRADLE_CMD=gradle"
if exist "%~dp0gradlew.bat" set "GRADLE_CMD=%~dp0gradlew.bat"
if not exist "%~dp0gradlew.bat" if exist "%~dp0..\gradlew.bat" set "GRADLE_CMD=%~dp0..\gradlew.bat"
call "%GRADLE_CMD%" :client:installDist
if errorlevel 1 goto fail

set "JPACKAGE="
if defined JAVA_HOME if exist "%JAVA_HOME%\bin\jpackage.exe" set "JPACKAGE=%JAVA_HOME%\bin\jpackage.exe"
if not defined JPACKAGE (
    for /f "delims=" %%I in ('where jpackage.exe 2^>nul') do (
        if not defined JPACKAGE set "JPACKAGE=%%I"
    )
)
if not defined JPACKAGE (
    if exist "%ProgramFiles%\Java" (
        for /r "%ProgramFiles%\Java" %%I in (jpackage.exe) do (
            if not defined JPACKAGE if exist "%%I" set "JPACKAGE=%%I"
        )
    )
)
if not defined JPACKAGE (
    if exist "%ProgramFiles%\Eclipse Adoptium" (
        for /r "%ProgramFiles%\Eclipse Adoptium" %%I in (jpackage.exe) do (
            if not defined JPACKAGE if exist "%%I" set "JPACKAGE=%%I"
        )
    )
)
if not defined JPACKAGE (
    if exist "%ProgramFiles%\Microsoft" (
        for /r "%ProgramFiles%\Microsoft" %%I in (jpackage.exe) do (
            if not defined JPACKAGE if exist "%%I" set "JPACKAGE=%%I"
        )
    )
)

if not defined JPACKAGE (
    echo.
    echo [PC] ERROR: Khong tim thay jpackage.exe.
    echo [PC] Hay cai JDK 17+ va set JAVA_HOME toi thu muc JDK, vi JRE thuong khong co jpackage.
    goto fail
)

if not exist "%CLIENT_LIB%" (
    echo.
    echo [PC] ERROR: Khong thay thu muc lib sau khi build: "%CLIENT_LIB%"
    goto fail
)

if not exist "%CLIENT_LIB%\%MAIN_JAR%" (
    echo.
    echo [PC] ERROR: Khong thay main jar: "%CLIENT_LIB%\%MAIN_JAR%"
    echo [PC] Hay kiem tra lai ten file jar trong thu muc "%CLIENT_LIB%".
    goto fail
)

echo.
echo [PC] Cleaning old output...
if exist "%APP_IMAGE%" rmdir /s /q "%APP_IMAGE%"
if exist "%OUT_ROOT%\%APP_NAME%-PC-portable.zip" del /q "%OUT_ROOT%\%APP_NAME%-PC-portable.zip"
if not exist "%OUT_ROOT%" mkdir "%OUT_ROOT%"

echo.
echo [PC] Creating portable EXE with bundled runtime...
"%JPACKAGE%" ^
  --type app-image ^
  --dest "%OUT_ROOT%" ^
  --name "%APP_NAME%" ^
  --input "%CLIENT_LIB%" ^
  --main-jar "%MAIN_JAR%" ^
  --main-class "%MAIN_CLASS%" ^
  --java-options "-Dfile.encoding=UTF-8"
if errorlevel 1 goto fail

echo.
echo [PC] Copying game data next to EXE...
if exist "%DATA_DIR%" (
    robocopy "%DATA_DIR%" "%APP_IMAGE%\Langla_data" /E /NFL /NDL /NJH /NJS /NP >nul
    if errorlevel 8 goto fail
    robocopy "%DATA_DIR%" "%APP_IMAGE%\app\Langla_data" /E /NFL /NDL /NJH /NJS /NP >nul
    if errorlevel 8 goto fail
) else (
    echo [PC] WARNING: Khong thay data: "%DATA_DIR%"
)

if exist "%~dp0srcClientdetu\path.txt" copy /Y "%~dp0srcClientdetu\path.txt" "%APP_IMAGE%\path.txt" >nul
if exist "%~dp0srcClientdetu\path.txt" copy /Y "%~dp0srcClientdetu\path.txt" "%APP_IMAGE%\app\path.txt" >nul
if exist "%~dp0srcClientdetu\animesoft" robocopy "%~dp0srcClientdetu\animesoft" "%APP_IMAGE%\animesoft" /E /NFL /NDL /NJH /NJS /NP >nul
if errorlevel 8 goto fail

echo.
echo [PC] Writing helper files...
(
    echo @echo off
    echo cd /d "%%~dp0"
    echo start "" "%APP_NAME%.exe"
) > "%APP_IMAGE%\Run-%APP_NAME%.bat"

(
    echo %APP_NAME% PC portable build
    echo.
    echo Gui nguyen thu muc "%APP_NAME%" nay cho user.
    echo User chay "%APP_NAME%.exe" hoac "Run-%APP_NAME%.bat".
    echo Thu muc runtime la JRE da duoc dong goi kem, khong can cai Java rieng.
) > "%APP_IMAGE%\README-PC.txt"

powershell.exe -NoProfile -ExecutionPolicy Bypass -Command "Compress-Archive -Path '%APP_IMAGE%' -DestinationPath '%OUT_ROOT%\%APP_NAME%-PC-portable.zip' -Force"
if errorlevel 1 goto fail

echo.
echo [PC] DONE.
echo [PC] Folder: "%APP_IMAGE%"
echo [PC] Zip:    "%OUT_ROOT%\%APP_NAME%-PC-portable.zip"
exit /b 0

:fail
echo.
echo [PC] BUILD FAILED.
exit /b 1
