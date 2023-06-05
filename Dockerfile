FROM openjdk:17 as build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:11
WORKDIR scheduledService
COPY --from=build target/*.jar scheduledservice.jar
ENTRYPOINT ["java", "-jar", "scheduledservice.jar"]