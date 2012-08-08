cd /d %~dp0
set MAVEN_BATCH_PAUSE=on
set MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8001,suspend=n,server=y -Xms256m -Xmx512m -XX:MaxPermSize=128m
mvn tomcat:run