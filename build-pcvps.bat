@echo off
setlocal EnableExtensions EnableDelayedExpansion

cd /d "%~dp0"

set "APP_NAME=LangLaBang"
set "MAIN_CLASS=com.beatdz.langlalau.DesktopLauncher"
set "MAIN_JAR=client-1.0-SNAPSHOT.jar"
set "CLIENT_INSTALL=%~dp0srcClientdetu\build\install\LangLaNam-PC"
set "CLIENT_LIB=%CLIENT_INSTALL%\lib"
set "OUT_ROOT=%~dp0build-output\pcvps"
set "APP_IMAGE=%OUT_ROOT%\%APP_NAME%"
set "ICON_FILE=%~dp0platforms\pc\LangLaBang.ico"
set "VPS_JRE_CACHE=%~dp0runtime\jre-vps"
if not defined VPS_JRE_SOURCE set "VPS_JRE_SOURCE=C:\Users\Thuy\Downloads\langlabase_vps (1)\langlabase_vps\jre"

echo.
echo [PCVPS] Building desktop client...
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
    echo [PCVPS] ERROR: Khong tim thay jpackage.exe.
    echo [PCVPS] Hay cai JDK 17+ va set JAVA_HOME toi thu muc JDK, vi JRE thuong khong co jpackage.
    goto fail
)

if not exist "%CLIENT_LIB%" (
    echo.
    echo [PCVPS] ERROR: Khong thay thu muc lib sau khi build: "%CLIENT_LIB%"
    goto fail
)

if not exist "%CLIENT_LIB%\%MAIN_JAR%" (
    echo.
    echo [PCVPS] ERROR: Khong thay main jar: "%CLIENT_LIB%\%MAIN_JAR%"
    echo [PCVPS] Hay kiem tra lai ten file jar trong thu muc "%CLIENT_LIB%".
    goto fail
)

if not exist "%VPS_JRE_CACHE%\bin\java.exe" (
    echo.
    echo [PCVPS] Chua co JRE VPS cache, dang copy tu:
    echo [PCVPS] "%VPS_JRE_SOURCE%"
    if not exist "%VPS_JRE_SOURCE%\bin\java.exe" (
        echo.
        echo [PCVPS] ERROR: Khong thay JRE VPS source.
        echo [PCVPS] Dat bien VPS_JRE_SOURCE toi thu muc JRE co bin\java.exe, hoac copy JRE vao:
        echo [PCVPS] "%VPS_JRE_CACHE%"
        goto fail
    )
    if not exist "%~dp0runtime" mkdir "%~dp0runtime"
    robocopy "%VPS_JRE_SOURCE%" "%VPS_JRE_CACHE%" /MIR /NFL /NDL /NJH /NJS /NP
    if errorlevel 8 goto fail
) else (
    echo.
    echo [PCVPS] Using cached VPS JRE:
    echo [PCVPS] "%VPS_JRE_CACHE%"
)

if not exist "%VPS_JRE_CACHE%\bin\awt.dll" echo [PCVPS] WARN: Khong thay bin\awt.dll trong JRE VPS.
if not exist "%VPS_JRE_CACHE%\bin\fontmanager.dll" echo [PCVPS] WARN: Khong thay bin\fontmanager.dll trong JRE VPS.
if not exist "%VPS_JRE_CACHE%\bin\freetype.dll" echo [PCVPS] WARN: Khong thay bin\freetype.dll trong JRE VPS.
if not exist "%VPS_JRE_CACHE%\jmods\java.desktop.jmod" echo [PCVPS] WARN: Khong thay jmods\java.desktop.jmod trong JRE VPS.

echo.
echo [PCVPS] Cleaning old output...
if exist "%APP_IMAGE%" rmdir /s /q "%APP_IMAGE%"
if exist "%OUT_ROOT%\%APP_NAME%-PCVPS-portable.zip" del /q "%OUT_ROOT%\%APP_NAME%-PCVPS-portable.zip"
if not exist "%OUT_ROOT%" mkdir "%OUT_ROOT%"

echo.
echo [PCVPS] Creating portable EXE...
"%JPACKAGE%" ^
  --type app-image ^
  --dest "%OUT_ROOT%" ^
  --name "%APP_NAME%" ^
  --input "%CLIENT_LIB%" ^
  --main-jar "%MAIN_JAR%" ^
  --main-class "%MAIN_CLASS%" ^
  --icon "%ICON_FILE%" ^
  --java-options "-Dfile.encoding=UTF-8"
if errorlevel 1 goto fail

echo.
echo [PCVPS] Replacing app runtime with VPS JRE...
if exist "%APP_IMAGE%\runtime" rmdir /s /q "%APP_IMAGE%\runtime"
robocopy "%VPS_JRE_CACHE%" "%APP_IMAGE%\runtime" /MIR /NFL /NDL /NJH /NJS /NP
if errorlevel 8 goto fail

echo.
echo [PCVPS] Removing loose asset/cache folders; startup assets are already inside core jar...
powershell.exe -NoProfile -ExecutionPolicy Bypass -Command ^
  "$paths = @('%APP_IMAGE%\Langla_data','%APP_IMAGE%\app\Langla_data','%APP_IMAGE%\animesoft','%APP_IMAGE%\app\animesoft','%APP_IMAGE%\path.txt','%APP_IMAGE%\app\path.txt','%APP_IMAGE%\%APP_NAME%.ico'); foreach ($p in $paths) { if (Test-Path -LiteralPath $p) { Remove-Item -LiteralPath $p -Recurse -Force } }"
if errorlevel 1 goto fail

echo.
echo [PCVPS] Writing helper files...
(
    echo @echo off
    echo cd /d "%%~dp0"
    echo start "" "%APP_NAME%.exe"
) > "%APP_IMAGE%\Run-%APP_NAME%.bat"

(
    echo %APP_NAME% PC VPS portable build
    echo.
    echo Gui nguyen thu muc "%APP_NAME%" nay cho VPS Windows.
    echo User chay "%APP_NAME%.exe" hoac "Run-%APP_NAME%.bat".
    echo Runtime da duoc thay bang JRE VPS rieng tu "client\runtime\jre-vps".
    echo JRE nay co java.desktop, AWT, fontmanager, freetype, javajpeg, lcms de render anh/font.
) > "%APP_IMAGE%\README-PCVPS.txt"

powershell.exe -NoProfile -ExecutionPolicy Bypass -Command "Compress-Archive -Path '%APP_IMAGE%' -DestinationPath '%OUT_ROOT%\%APP_NAME%-PCVPS-portable.zip' -Force"
if errorlevel 1 goto fail

echo.
echo [PCVPS] DONE.
echo [PCVPS] Folder: "%APP_IMAGE%"
echo [PCVPS] Zip:    "%OUT_ROOT%\%APP_NAME%-PCVPS-portable.zip"
echo [PCVPS] JRE:    "%VPS_JRE_CACHE%"
exit /b 0

:fail
echo.
echo [PCVPS] BUILD FAILED.
exit /b 1
