# The leightweight java image
FROM eclipse-temurin:21-jdk-alpine

# Create a working directory
WORKDIR /app

#Notes
LABEL maintainer="oduorfrancis134@gmail.com"

#Copy the jar file into the image
COPY target/EmployeeSample-0.0.1-SNAPSHOT.jar app.jar

#expose the app

EXPOSE 8080

#Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
