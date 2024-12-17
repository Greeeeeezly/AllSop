@echo off
set MAVEN_HOME=%~dp0\.mvn\wrapper\maven-wrapper.jar
java -jar %MAVEN_HOME% %*
