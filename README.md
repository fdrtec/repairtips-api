# Repair Tips API

API para gerenciamento de dicas de reparo e peças, desenvolvida com abordagem API First usando SpringDoc OpenAPI e interfaces manuais.

## Tecnologias

- Java 25
- Spring Boot 4.0.6
- Maven 3.9.15
- H2 Database (em memória)
- JPA/Hibernate
- SpringDoc OpenAPI
- Lombok

## Estrutura do Projeto

```
src/
├── main/
│   ├── java/br/com/fdrdev/repairtipsapi/
│   │   ├── RepairTipsApiApplication.java          # Classe principal
│   │   ├── api/                                    # Interfaces de API com anotações OpenAPI
│   │   │   ├── BaseApi.java                        # Interface base para operações comuns
│   │   │   └── PartApi.java                        # Interface específica para Parts
│   │   ├── controller/                             # Controllers REST
│   │   │   └── PartController.java                 # Controller que implementa PartApi
│   │   ├── service/                                # Serviços de negócio
│   │   │   ├── BaseService.java                    # Interface base para serviços
│   │   │   └── PartService.java                    # Serviço para Parts
│   │   └── model/                                  # Modelos de dados (Records)
│   │       └── PartRepresentation.java             # Record para representação de Part
│   └── resources/
│       ├── application.yml                          # Configurações Spring Boot
│       └── openapi/
│           └── repair-tips-api.yaml                # Especificação OpenAPI (contrato)
└── test/
    └── java/br/com/fdrdev/repairtipsapi/
        └── RepairTipsApiApplicationTests.java      # Testes unitários
```

## Arquitetura

- **API First**: Especificação OpenAPI define o contrato antes da implementação.
- **Camadas**: Controller → Service → Model.
- **Interfaces**: Separam contrato (anotações OpenAPI) da implementação.
- **Records**: Modelos imutáveis para DTOs.
- **Generics**: Interfaces base suportam diferentes tipos de dados.

## Como Usar

### 1. Desenvolver API First

1. Edite a especificação OpenAPI em `src/main/resources/openapi/repair-tips-api.yaml`
2. Crie interfaces em `api/` com anotações OpenAPI (ex.: `@Operation`, `@Tag`)
3. Implemente controllers e services baseados nas interfaces

### 2. Executar a Aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:
- **API**: http://localhost:8080
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/v3/api-docs
- **H2 Console**: http://localhost:8080/h2-console (JDBC URL: `jdbc:h2:mem:repairtipsdb`)

### 3. Endpoints Disponíveis

- `GET /health` - Verificação de saúde
- `GET /api/parts` - Lista todas as peças

## Desenvolvimento

### Adicionar Novo Recurso

1. Defina o schema no `repair-tips-api.yaml`
2. Crie o record em `model/`
3. Crie a interface em `api/` estendendo `BaseApi<T>`
4. Implemente o service estendendo `BaseService<T>`
5. Crie o controller implementando a interface específica

Exemplo para Tips:
- `TipRepresentation.java`
- `TipApi.java` (extends `BaseApi<TipRepresentation>`)
- `TipService.java` (implements `BaseService<TipRepresentation>`)
- `TipController.java` (implements `TipApi`)
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
