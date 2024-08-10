FROM maven:3.8.7-openjdk-17-slim as builder
WORKDIR /src
COPY ./pom.xml .
COPY ./src ./src
RUN mvn clean install 
RUN ls /src/target/




FROM openjdk:17 as runner
COPY --from=builder /src/target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
WORKDIR /app
# RUN sh -c 'demo-0.0.1-SNAPSHOT.jar'
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]
