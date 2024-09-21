FROM openjdk:17.0.2

EXPOSE 8083

COPY target/account-microservice-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]