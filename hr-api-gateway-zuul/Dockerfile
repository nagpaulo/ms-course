FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
COPY --from=build /app/target/hr-api-gateway-zuul-0.0.1-SNAPSHOT.jar hr-api-gateway-zuul.jar
EXPOSE 8765
ENTRYPOINT ["java","-jar","/hr-api-gateway-zuul.jar"]

