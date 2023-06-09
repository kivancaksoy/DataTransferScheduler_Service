FROM openjdk:17 as build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17
WORKDIR scheduledService
COPY --from=build target/*.jar scheduledservice.jar
ENTRYPOINT ["java", "-jar", "scheduledservice.jar", "--spring.datasource.url=jdbc:postgresql://host.docker.internal:5432/BaseDB"]