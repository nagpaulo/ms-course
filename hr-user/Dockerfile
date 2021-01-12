FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=build /app/target/hruser-0.0.1-SNAPSHOT.jar hruser.jar
ENTRYPOINT ["java","-jar","/hruser.jar"]