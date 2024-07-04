# Use an appropriate base image with JDK and PostgreSQL client libraries
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /usr/src/app

# Copy the Java application and PostgreSQL JDBC driver JAR into the container
COPY Main.java .
COPY lib/postgresql-42.7.3.jar ./postgresql-42.7.3.jar

# Compile Java application
RUN javac Main.java

# Set the classpath for running the Java application
ENV CLASSPATH=".:/usr/src/app/postgresql-42.7.3.jar"

# Run the Java application when the container starts
CMD ["java", "Main"]
