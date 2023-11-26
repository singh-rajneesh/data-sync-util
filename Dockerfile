# Use an existing image as the base image
FROM openjdk:11

# Set the working directory to /app
WORKDIR /app

# Copy the jar file to the working directory
COPY target/lead-management-service-*.jar /app/lead-management-service.jar

EXPOSE 8058

# Specify the command to run when the container starts
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "lead-management-service.jar"]

CMD ["echo", "Build Successfuly Completed!"]