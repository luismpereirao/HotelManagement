FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/hotel_management-0.0.1.jar
COPY ${JAR_FILE} hotel_management_app.jar
EXPOSE 3000
ENTRYPOINT ["java", "-jar", "hotel_management_app.jar"]