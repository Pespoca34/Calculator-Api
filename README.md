# Calculator API

Multi-module Maven project with two main parts:
- `calculator-rest` — Spring Boot REST API (endpoints: /sum, /sub, /div, /mult)
- `calculator-service` — module that contains the calculation logic

Build requirements
- Java 17
- Maven (the project includes the wrapper `mvnw` / `mvnw.cmd`)
- Docker & Docker Compose (to run Kafka with the compose file)

How to build

From Windows PowerShell (project root):

```powershell
# Compile and package both modules
cd C:\Users\pedro\Java\calculator
.\mvnw.cmd -DskipTests package -pl calculator-service,calculator-rest -am
```

How to run locally (without Docker)

```powershell
# Run the REST application (from the calculator-rest module)
cd C:\Users\pedro\Java\calculator\calculator-rest
java -jar target\calculator-rest-0.0.1-SNAPSHOT.jar
# The API will be available by default at http://localhost:8080
```

How to run with Docker Compose (includes Kafka)

```powershell
cd C:\Users\pedro\Java\calculator
# Start Zookeeper, Kafka and the application (the image will be built from the Dockerfile)
docker-compose up --build
```

Request examples

Sum:
```powershell
curl "http://localhost:8080/sum?a=3&b=2"
```

Division (division by zero is handled and returns an error):
```powershell
curl "http://localhost:8080/div?a=10&b=2"
```

---
Made by: Pedro Julião
