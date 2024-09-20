FROM openjdk:17.0.2

EXPOSE 8080

COPY target/gateway-microservice-0.0.1-SNAPSHOT.jar app.jar

#ENV EUREKA_SERVER=http://eureka-server:8761/eureka

ENTRYPOINT ["java","-jar","/app.jar"]

#FROM openjdk:17.0.2
#
#EXPOSE 8080
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
#ENTRYPOINT ["java","-jar","/app/target/gateway-microservice-0.0.1-SNAPSHOT.jar"]