#FROM openjdk:17-jdk-alpine
#COPY target/bookhouse-0.0.1-SNAPSHOT.jar java-app.jar
#ENTRYPOINT ["java", "-jar", "java-app.jar"]

FROM openjdk:17-jdk-slim
RUN apt-get update && \
    apt-get install -y maven && \
    rm -rf /var/lib/apt/lists/*
COPY pom.xml /usr/src/myapp/
COPY src /usr/src/myapp/src
WORKDIR /usr/src/myapp
RUN mvn clean install -DskipTests
CMD ["java", "-jar", "target/bookhouse-0.0.1-SNAPSHOT.jar"]