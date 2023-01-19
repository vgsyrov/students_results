#
# Build
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY pom.xml /home/app/pom.xml
WORKDIR /home/app
RUN mvn dependency:resolve

COPY src src
RUN mvn -f /home/app/pom.xml -DskipTests=true -B clean package


#
# Create container
#
FROM openjdk:11-jre-slim
ARG JAR_FILE=/home/app/target/*.jar
COPY --from=build ${JAR_FILE} app.jar
#EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]