FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY . .
RUN mvn clean package -B -P server -DskipTests

FROM openjdk:11
RUN GITHUB_USER=nagpaulo GITHUB_PASS= export GITHUB_USER export GITHUB_PASS
COPY --from=build /app/target/hr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/hr-config-server.jar"]

