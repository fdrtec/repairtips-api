## Perfil: Arquiteto / Desenvolvedor Sênior — Java 21 · Spring Boot

Objetivo: diretrizes práticas e não-ambíguas para arquitetar, desenvolver e operar backends Java 21 com Spring Boot.

1) Não negociáveis (resumo)
- Construtor para injeção de dependência; nada de field injection.
- Nunca expor entidades JPA em contratos de API; use DTOs/Projections.
- FetchType = LAZY por padrão; justificar EAGER por escrito (ADR).
- Migrations com Flyway; `spring.jpa.hibernate.ddl-auto=validate` em produção.

2) Princípios de arquitetura (curtos)
- Camadas claras: Controller → Service → Repository → Domain.
- Domain-driven design quando o domínio justificar; definir bounded contexts.
- Serviços devem ser stateless; externalizar estado compartilhado para cache/DB.
- Priorize design para observabilidade e operações (SLOs, runbooks).

3) JPA / Persistência (essenciais)
- PKs: `SEQUENCE` para performance em batch; UUIDs como IDs públicos quando necessário.
- Relacionamentos: declare o lado dono (`@JoinColumn`); `orphanRemoval=true` quando aplicável.
- Evitar `@ManyToMany` direto; modelar entidade de junção para comportamento rico.
- Consultas: preferir `interface-based projections` e `JOIN FETCH`/`@EntityGraph` para evitar N+1.

4) Transações e concorrência
- `@Transactional` na camada de Service. `readOnly=true` em leituras.
- Use `@Version` para optimistic locking; trate `OptimisticLockException` com retry/erro 409.

5) Performance, caching e paginação
- Use keyset pagination para listas grandes; evite offset alto.
- Cache L2 com critério: apenas para entidades com alta leitura e baixa mutabilidade.
- Meça antes de otimizar: metrics + CPU/heap profiling.

6) Segurança e qualidade
- Validação centralizada (jakarta.validation) nas bordas e sanitização de inputs.
- Não logar segredos; aplicar principle of least privilege para acessos a DB e serviços.
- SCA (dependabot/Snyk) em CI e análise de SBOM quando aplicável.

7) CI/CD, ADRs e Observability
- ADRs: mantenha em `docs/adr/` (contexto, alternativas, decisão, data, autor).
- CI: lint, build, unit, integration (Testcontainers), contract tests e SCA.
- CD: canary/blue-green quando possível; deploys imutáveis e rollbacks automáticos.
- Observability: traces (OpenTelemetry), métricas (Prometheus) e logs estruturados (JSON).

8) Checklist de Code Review (rápido)
- Arquitetura: há ADR ou justificativa? Bounded context respeitado?
- Design: SRP, nomes claros, limites de métodos e coerência de API.
- Persistência: risco de N+1? Projections adequadas? Transação correta?
- Testes: unit + integration (Testcontainers) para integração com infra.
- Segurança: validação, não exposição de dados sensíveis, secrets ok?
- Migrations: alterações de schema acompanhadas de script Flyway.

9) Mentoria e cultura
- PRs como oportunidade de ensino; prefira feedback orientado a design.
- Pair programming para decisões arquiteturais e onboarding.
- Documente runbooks e playbooks para incidentes.

Onde colocar artefatos
- ADRs: `docs/adr/`
- Migrations: `src/main/resources/db/migration/` (padrão Flyway)
- Runbooks/Playbooks: `docs/runbooks/`

Se desejar, crio um template de ADR e um `docs/adr/0001-template.md` para começar.

