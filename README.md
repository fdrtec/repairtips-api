# Repair Tips API

API para gerenciamento de dicas de reparo, desenvolvida com abordagem API First usando OpenAPI Generator.

## Tecnologias

- Java 25
- Spring Boot 4.0.6
- Maven 3.9.15
- H2 Database (em memória)
- JPA/Hibernate
- OpenAPI Generator 7.10.0

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/com/fdrdev/repairtipsapi/
│   │   ├── RepairTipsApiApplication.java
│   │   ├── api/          # Interfaces geradas pelo OpenAPI Generator
│   │   └── model/        # Modelos gerados pelo OpenAPI Generator
│   └── resources/
│       ├── application.yml
│       └── openapi/
│           └── repair-tips-api.yaml  # Especificação OpenAPI
└── test/
    └── java/br/com/fdrdev/repairtipsapi/
        └── RepairTipsApiApplicationTests.java
```

## Como Usar

### 1. Desenvolver API First

1. Edite a especificação OpenAPI em `src/main/resources/openapi/repair-tips-api.yaml`
2. Gere o código das interfaces e modelos:
   ```bash
   ./mvnw clean compile -Pgenerate-api
   ```
3. Implemente os controllers baseados nas interfaces geradas em `br.com.fdrdev.repairtipsapi.api.*`

### 2. Executar a Aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:
- **API**: http://localhost:8080
- **H2 Console**: http://localhost:8080/h2-console
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs

### 3. Banco de Dados H2

- **URL**: jdbc:h2:mem:repairtipsdb
- **User**: sa
- **Password**: (vazio)

## Comandos Úteis

- **Gerar código da API**: `./mvnw clean compile -Pgenerate-api`
- **Executar testes**: `./mvnw test`
- **Executar aplicação**: `./mvnw spring-boot:run`
- **Limpar e compilar**: `./mvnw clean compile`

## Configuração OpenAPI Generator

O plugin está configurado na profile `generate-api` do `pom.xml` com:
- Generator: `spring`
- Pacote API: `br.com.fdrdev.repairtipsapi.api`
- Pacote Model: `br.com.fdrdev.repairtipsapi.model`
- Interface Only: `true` (gera apenas interfaces)
- Spring Boot 3: `true`
- Delegate Pattern: `true`
