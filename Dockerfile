FROM maven:3.8.6-jdk-11 as builder

WORKDIR /app

COPY src src
COPY pom.xml .
COPY data.txt .
COPY config.yml .

RUN mvn -f ./pom.xml clean package

FROM openjdk:11-jre-slim

COPY --from=builder /app/target/sa54somik-1.0-SNAPSHOT.jar /usr/app/sa54somik-1.0-SNAPSHOT.jar

COPY --from=builder /app/data.txt /usr/app/data.txt
COPY --from=builder /app/config.yml /usr/app/config.yml

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/usr/app/sa54somik-1.0-SNAPSHOT.jar","server","/usr/app/config.yml"]
