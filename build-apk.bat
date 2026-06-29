@echo off
setlocal EnableExtensions

cd /d "%~dp0"

set "OUT_DIR=%~dp0build-output\apk"

if not defined ANDROID_HOME if exist "%LOCALAPPDATA%\Android\Sdk" set "ANDROID_HOME=%LOCALAPPDATA%\Android\Sdk"
if not defined ANDROID_SDK_ROOT if defined ANDROID_HOME set "ANDROID_SDK_ROOT=%ANDROID_HOME%"

echo.
echo [APK] Building Android debug and release APK...
set "GRADLE_CMD=gradle"
if exist "%~dp0gradlew.bat" set "GRADLE_CMD=%~dp0gradlew.bat"
if not exist "%~dp0gradlew.bat" if exist "%~dp0..\gradlew.bat" set "GRADLE_CMD=%~dp0..\gradlew.bat"
call "%GRADLE_CMD%" :packageApk
if errorlevel 1 goto fail

if exist "%OUT_DIR%\LangLaBang-debug.apk" copy /Y "%OUT_DIR%\LangLaBang-debug.apk" "%OUT_DIR%\LangLaBang-install.apk" >nul

(
    echo LangLaBang Android build
    echo.
    echo LangLaBang-install.apk: file de gui user cai thu, da duoc ky bang debug key.
    echo LangLaBang-debug.apk: ban debug goc.
    echo LangLaBang-release-unsigned.apk: ban release chua ky, can keystore rieng neu dua len store hoac phat hanh chinh thuc.
) > "%OUT_DIR%\README-APK.txt"

echo.
echo [APK] DONE.
echo [APK] Output folder: "%OUT_DIR%"
if exist "%OUT_DIR%" dir /b "%OUT_DIR%\*.apk"
exit /b 0

:fail
echo.
echo [APK] BUILD FAILED.
exit /b 1
