# Java Application with PostgreSQL Docker Setup

This repository contains a Java application that interacts with PostgreSQL running in Docker containers. Follow the steps below to set up and run the application.

## Prerequisites

- Docker installed on your machine

## Steps to Run

### 1. Build Docker Image for Java Application

Build the Docker image for the Java application:

```bash
docker build -t java-postgres-app .
```

### 2. Run PostgreSQL Container

Run the PostgreSQL container with environment variables for user, password, and database:

```bash
docker run --name postgres -e POSTGRES_USER=testuser -e POSTGRES_PASSWORD=testpassword -e POSTGRES_DB=testdb -p 5432:5432 -d postgres
```

### 3. Connect to PostgreSQL

Connect to PostgreSQL using psql to verify and create necessary tables:

```bash
psql -h localhost -p 5432 -U testuser -d testdb
```

### 4. Create Table in Database

Inside psql shell, create a table (`test_table`) in the testdb database:

```bash
CREATE TABLE test_table (id int, name varchar(50));
```

### 5. Run Java Application Container

Run the Docker container for the Java application, linking it to the PostgreSQL container:

```bash
docker run --name java-postgres-app --link postgres:postgres java-postgres-app
```