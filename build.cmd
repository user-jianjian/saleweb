cls
@echo off
CLS
color 0a
cd/D %~dp0

REM ������Ϊ�����̹���ģʽ
REM =========���忪ʼ=========
for %%i in ("%cd%") do set pname=%%~ni
set title=���̱���/����
set c1=eclipse
set c2=release
REM =========�������=========

Title %pname%%title%

goto choose
:choose
echo %title%
echo ========================
echo   1�����̱���
echo   2�����̷���
echo   e����   ��
echo ========================
set /p choice= ��ѡ����Ӧѡ�Ȼ�󰴻س�������ֱ�Ӱ��س����б���:
echo.
if /i "%choice%"=="" goto eclipse
if /i "%choice%"=="1" goto eclipse
if /i "%choice%"=="2" goto release
if /i "%choice%"=="e" goto EX

echo.
echo              ѡ����Ч������������
echo.
echo.
goto choose

:EX
exit

:eclipse
echo ��ʼ����%pname%...
call gradle/gradlew.bat cleanfiles copyfiles compileJava eclipse clean
goto choose

:release
echo ��ʼ����%pname%...
call gradle/gradlew.bat clean copyfiles build -x test release
goto choose