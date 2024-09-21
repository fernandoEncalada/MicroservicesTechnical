FROM openjdk:17.0.2

EXPOSE 8761

COPY ./target/eureka-microservice-0.0.1-SNAPSHOT.jar eureka-server.jar

ENTRYPOINT ["java","-jar","eureka-server.jar"]