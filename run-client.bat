@echo off
setlocal
cd /d "%~dp0"
set "GRADLE_CMD=gradle"
if exist "%~dp0gradlew.bat" set "GRADLE_CMD=%~dp0gradlew.bat"
if not exist "%~dp0gradlew.bat" if exist "%~dp0..\gradlew.bat" set "GRADLE_CMD=%~dp0..\gradlew.bat"
call "%GRADLE_CMD%" :client:run
