FROM openjdk:17-jdk-alpine
COPY target/sample-service*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
