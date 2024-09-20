FROM openjdk:17.0.2

EXPOSE 8082

COPY target/client-microservice-0.0.1-SNAPSHOT.jar app.jar

#ENV EUREKA_SERVER=http://eureka-server:8761/eureka
#ENV DB_CLIENT_HOST=client-db
#ENV DB_CLIENT_USER=test
#ENV DB_CLIENT_PASSWORD=test
#ENV RABBITMQ_HOST=rabbit
#ENV RABBITMQ_USER=guest
#ENV RABBITMQ_PASSWORD=guest

ENTRYPOINT ["java","-jar","/app.jar"]