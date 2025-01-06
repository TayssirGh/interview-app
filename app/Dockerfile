FROM openjdk:17-jdk AS build
WORKDIR /app

COPY settings.xml /root/.m2/settings.xml

COPY pom.xml mvnw ./
COPY .mvn .mvn

COPY src src

RUN chmod +x mvnw
RUN ./mvnw clean install -DskipTests -Dmaven.test.skip=true -DargLine="-Xmx2048m"

FROM openjdk:17-jdk-slim
WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/application-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
