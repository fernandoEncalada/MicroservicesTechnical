FROM openjdk:17.0.2

EXPOSE 8082

COPY target/client-microservice-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]