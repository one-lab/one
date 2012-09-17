@echo off
echo [INFO] Generate source code from entity (according templates) to the 'generate.code.dir' property in config.properties file.
echo [INFO] JDK must 6 or later.

if exist .\lib\jdk1.6.0_32 (
    set JAVA_HOME=lib\jdk1.6.0_32
    set CLASSPATH=lib\jdk1.6.0_32\lib\dt.jar;lib\jdk1.6.0_32\lib\tools.jar.
    echo [INFO] Use inside JDK
) else (
    echo [INFO] no inside JDK, Please ensure JAVA_HOME and CLASSPATH is JDK6
)

call tools\apache-ant-1.8.4\bin\ant generate.code
call tools\apache-ant-1.8.4\bin\ant compile
call tools\apache-ant-1.8.4\bin\ant move
call tools\apache-ant-1.8.4\bin\ant deletetemp

echo [INFO] Artifacts will generate  in 'generate.code.dir'.
pause