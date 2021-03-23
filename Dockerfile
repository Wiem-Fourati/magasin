FROM tomcat:9
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} /usr/local/tomcat/webapps/app.war
EXPOSE 8080
