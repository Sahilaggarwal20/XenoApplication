FROM eclipse-temurin:17-jdk-focal
RUN apt-get update
Run apt-get install openjdk-17-jdk -y


COPY .mvn/ .mvn
COPY mvnw pom.xml ./

FROM openjdk:17-jdk-slim
Expose 8080
COPY --from-build/build/libs/xeno.jar app.jar
RUN ./mvnw dependency:go-offline
ENTRYPOINT ["java","-jar","app.jar"]
