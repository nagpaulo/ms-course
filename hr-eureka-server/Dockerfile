FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY . .
RUN mvn clean package -B -P server -DskipTests

FROM openjdk:11
COPY --from=build /app/target/hr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/hr-eureka-server.jar"]