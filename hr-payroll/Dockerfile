FROM maven:3.6.0-jdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:resolve
COPY . .
RUN mvn clean package -B -P server -DskipTests

FROM openjdk:11
COPY --from=build /app/target/hr-payroll-0.0.1-SNAPSHOT.jar hr-payroll.jar
ENTRYPOINT ["java","-jar","/hr-payroll.jar"]