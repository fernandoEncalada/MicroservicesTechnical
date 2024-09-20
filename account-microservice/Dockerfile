FROM openjdk:17.0.2

EXPOSE 8083

COPY target/account-microservice-0.0.1-SNAPSHOT.jar app.jar

#ENV EUREKA_SERVER=http://eureka-server:8761/eureka
#ENV DB_CLIENT_HOST=account-db
#ENV DB_CLIENT_USER=test
#ENV DB_CLIENT_PASSWORD=test
#ENV RABBITMQ_HOST=rabbit
#ENV RABBITMQ_USER=guest
#ENV RABBITMQ_PASSWORD=guest

ENTRYPOINT ["java","-jar","/app.jar"]


#FROM openjdk:17.0.2
#
#EXPOSE 8083
#
#WORKDIR /app
#
## COPIAR Y PEGAR ARCHIVOS DENTRO DEL CONTENEDOR
#COPY ./pom.xml /app
#COPY ./.mvn /app/.mvn
#COPY ./mvnw /app
#
## DESCARGAR LAS DEPENDENCIAS
#RUN ./mvnw dependency:go-offline
#
## COPIAR EL CODIGO FUENTE DENTRO DEL CONTENEDOR
#COPY ./src /app/src
#
## CONSTRUIR NUESTRA APLICACION
#RUN ./mvnw clean install -DskipTests
#
## LEVANTAR NUESTRA APLICACION CUANDO EL CONTENEDOR INICIE
#ENTRYPOINT ["java","-jar","/app/target/account-microservice-0.0.1-SNAPSHOT.jar"]