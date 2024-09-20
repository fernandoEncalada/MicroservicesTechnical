FROM openjdk:17.0.2

EXPOSE 8761

COPY ./target/eureka-microservice-0.0.1-SNAPSHOT.jar eureka-server.jar

ENTRYPOINT ["java","-jar","eureka-server.jar"]

#WORKDIR /app
#
#COPY ./pom.xml /app
#COPY ./.mvn /app/.mvn
#COPY ./mvnw /app
#
#RUN ./mvnw dependency:go-offline
#
#COPY ./src /app/src
#
#RUN ./mvnw clean install -DskipTests
#
#ENTRYPOINT ["java","-jar","/app/target/eureka-microservice-0.0.1-SNAPSHOT.jar"]