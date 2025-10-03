# Calculator API

Projeto multi-módulo (Maven) com duas partes principais:
- `calculator-rest` — API REST baseada em Spring Boot (endpoints: /sum, /sub, /div, /mult)
- `calculator-service` — módulo com a lógica de cálculo

Requisitos de build
- Java 17
- Maven (o projeto inclui o wrapper `mvnw`/`mvnw.cmd`)
- Docker & Docker Compose (para rodar com Kafka via compose)

Como construir

No Windows PowerShell (na raiz do projeto):

```powershell
# Compilar e empacotar ambos os módulos
cd C:\Users\pedro\Java\calculator
.\mvnw.cmd -DskipTests package -pl calculator-service,calculator-rest -am
```

Como rodar localmente (sem Docker)

```powershell
# Rodar a aplicação REST (a partir do módulo calculator-rest)
cd C:\Users\pedro\Java\calculator\calculator-rest
java -jar target\calculator-rest-0.0.1-SNAPSHOT.jar
# A API estará disponível por padrão em http://localhost:8080
```

Como rodar com Docker Compose (inclui Kafka)

```powershell
cd C:\Users\pedro\Java\calculator
# Subir Zookeeper, Kafka e a aplicação (imagem será construída a partir do Dockerfile)
docker-compose up --build
```
Exemplos de requisições

Sum:
```powershell
curl "http://localhost:8080/sum?a=3&b=2"
```

Division (tratamento de divisão por zero lança erro no servidor):
```powershell
curl "http://localhost:8080/div?a=10&b=2"
```
---
Feito por: 
