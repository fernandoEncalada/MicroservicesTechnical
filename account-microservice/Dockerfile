FROM openjdk:17.0.2

WORKDIR /app

COPY ./target/account-microservice-0.0.1-SNAPSHOT.jar .

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "account-microservice-0.0.1-SNAPSHOT.jar"]