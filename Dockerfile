FROM tomcat:9
ARG JAR_FILE=target/*.war
COPY ${JAR_FILE} /usr/local/tomcat/webapps/app.war
#CMD [“catalina.sh”, “run”]
EXPOSE 8080
