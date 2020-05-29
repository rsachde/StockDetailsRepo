FROM openjdk:latest
EXPOSE 8080
COPY ./target/stockdetails-0.0.1-SNAPSHOT-spring-boot.jar webapp.jar
CMD ["java", "-jar", "webapp.jar"]