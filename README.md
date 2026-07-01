# CRUD Projetos

Primeiro projeto feito com Spring Boot para praticar conceitos iniciais de API REST, padrao MVC com camada de service, endpoints HTTP, persistencia com Spring Data JPA e banco MySQL.

A aplicacao permite cadastrar alunos, projetos, tarefas e vinculos entre alunos e projetos.

## Tecnologias

- Java 21
- Spring Boot 4.0.6
- Spring Web MVC
- Spring Data JPA
- MySQL 8
- Docker Compose
- Maven Wrapper
- Postman para testes manuais dos endpoints
- Springdoc OpenAPI/Swagger disponível no projeto para documentação da API


## Estrutura

```text
src/main/java/com/gestaoProjetos/crud
├── controller   # Endpoints REST
├── entities     # Entidades JPA
├── repository   # Interfaces do Spring Data JPA
└── service      # Regras/operacoes entre controller e repository
```

## Variaveis de ambiente

O projeto carrega variaveis a partir de um arquivo `.env`, porque o `application.properties` usa:

```properties
spring.config.import=optional:file:.env[.properties]
```

Crie um arquivo `.env` na raiz do projeto usando o `.env.example` como base:

```env
DB_URL=jdbc:mysql://localhost:3306/crudProjetos
DB_USER=root
DB_PASSWORD=sua_senha_aqui
```

O arquivo `.env.example` deve conter somente exemplos, sem senhas reais:

```env
DB_URL=jdbc:mysql://localhost:3306/crudProjetos
DB_USER=root
DB_PASSWORD=troque_esta_senha
```

## Requisitos

### Linux

- Java JDK 21 instalado
- Docker e Docker Compose instalados
- Permissao para executar o Maven Wrapper

Verifique:

```bash
java -version
docker --version
docker compose version
```

Se necessario, libere execucao do wrapper:

```bash
chmod +x mvnw
```

### Windows

- Java JDK 21 instalado
- Docker Desktop instalado e aberto
- Terminal PowerShell ou CMD

Verifique:

```powershell
java -version
docker --version
docker compose version
```

## Como rodar

### 1. Configure o `.env`

Linux:

```bash
cp .env.example .env
```

Windows PowerShell:

```powershell
Copy-Item .env.example .env
```

Depois edite o `.env` e defina a senha desejada.

### 2. Suba o MySQL com Docker

Linux ou Windows:

```bash
docker compose up -d
```

O `docker-compose.yml` cria um MySQL local com:

- host: `localhost`
- porta: `3306`
- database: `crudProjetos`
- usuario: `root`
- senha: valor de `DB_PASSWORD`

### 3. Rode a aplicacao

Linux:

```bash
./mvnw spring-boot:run
```

Windows PowerShell:

```powershell
.\mvnw.cmd spring-boot:run
```

A API fica disponivel em:

```text
http://localhost:8080
```

Swagger/OpenAPI:

```text
http://localhost:8080/swagger-ui.html
```

ou:

```text
http://localhost:8080/swagger-ui/index.html
```

## Endpoints

### Alunos

Base:

```text
/alunos
```

Criar aluno:

```bash
curl -X POST http://localhost:8080/alunos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Ana Souza",
    "email": "ana.souza@email.com"
  }'
```

Listar alunos:

```bash
curl http://localhost:8080/alunos
```

Buscar por id:

```bash
curl http://localhost:8080/alunos/1
```

Atualizar:

```bash
curl -X PUT http://localhost:8080/alunos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Ana Souza Silva",
    "email": "ana.silva@email.com"
  }'
```

Excluir:

```bash
curl -X DELETE http://localhost:8080/alunos/1
```

### Projetos

Base:

```text
/projetos
```

Criar projeto:

```bash
curl -X POST http://localhost:8080/projetos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Sistema de Gestao",
    "descricao": "API para gerenciar alunos, projetos e tarefas"
  }'
```

Listar projetos:

```bash
curl http://localhost:8080/projetos
```

Buscar por id:

```bash
curl http://localhost:8080/projetos/1
```

Atualizar:

```bash
curl -X PUT http://localhost:8080/projetos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Sistema de Gestao de Projetos",
    "descricao": "CRUD com Spring Boot e MySQL"
  }'
```

Excluir:

```bash
curl -X DELETE http://localhost:8080/projetos/1
```

### Tarefas

Atualmente o `TodoController` nao possui `@RequestMapping`, entao as rotas de tarefas ficam direto na raiz da API.

Base atual:

```text
/
```

Criar tarefa:

```bash
curl -X POST http://localhost:8080/ \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Criar controllers",
    "descricao": "Implementar endpoints REST do projeto",
    "status": "pendente",
    "prioridade": "alta",
    "aluno": {
      "id": 1
    },
    "projeto": {
      "id": 1
    }
  }'
```

Listar tarefas:

```bash
curl http://localhost:8080/
```

Buscar por id:

```bash
curl http://localhost:8080/1
```

Atualizar tarefa:

```bash
curl -X PUT http://localhost:8080/1 \
  -H "Content-Type: application/json" \
  -d '{
    "descricao": "Implementar endpoints e testar no Swagger",
    "prioridade": "media"
  }'
```

Excluir:

```bash
curl -X DELETE http://localhost:8080/1
```

Observacao: no service atual, o update de tarefa altera apenas `descricao` e `prioridade`.

### Vinculo entre aluno e projeto

Base:

```text
/aluno-projetos
```

Criar vinculo:

```bash
curl -X POST http://localhost:8080/aluno-projetos \
  -H "Content-Type: application/json" \
  -d '{
    "funcao": "Desenvolvedor backend",
    "aluno": {
      "id": 1
    },
    "projeto": {
      "id": 1
    }
  }'
```

Listar vinculos:

```bash
curl http://localhost:8080/aluno-projetos
```

Buscar por id:

```bash
curl http://localhost:8080/aluno-projetos/1
```

Atualizar vinculo:

```bash
curl -X PUT http://localhost:8080/aluno-projetos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "funcao": "Lider tecnico",
    "aluno": {
      "id": 1
    },
    "projeto": {
      "id": 1
    }
  }'
```

Excluir:

```bash
curl -X DELETE http://localhost:8080/aluno-projetos/1
```

Observacao: o metodo `create` de `AlunoProjetoController` nao possui `@RequestBody` no parametro, entao o envio por JSON pode nao funcionar como esperado nesse endpoint ate isso ser ajustado.

## Build e testes

Rodar testes:

Linux:

```bash
./mvnw test
```

Windows:

```powershell
.\mvnw.cmd test
```

Gerar build:

Linux:

```bash
./mvnw clean package
```

Windows:

```powershell
.\mvnw.cmd clean package
```

## Pontos de atencao

- O arquivo `.env` contem dados sensiveis e nao deve ser commitado. Ele ja esta listado no `.gitignore`.
- Nao use senha real no `.env.example`; deixe apenas valores de exemplo.
- A aplicacao nao possui autenticacao/autorizacao. Qualquer pessoa com acesso ao servidor pode chamar os endpoints.
- Nao ha validacao de entrada com Bean Validation, como `@NotBlank`, `@Email` ou `@Valid`.
- `spring.jpa.hibernate.ddl-auto=update` e pratico para estudo, mas em producao o ideal seria usar migrations, como Flyway ou Liquibase.
- O `TodoController` esta sem rota base, o que deixa endpoints como `GET /` e `GET /{id}`. Uma rota como `/todos` evitaria conflito e deixaria a API mais padronizada.
- O `AlunoProjetoController.create` esta sem `@RequestBody`, entao o corpo JSON pode nao ser lido corretamente.
- Algumas operacoes retornam a lista inteira apos criar/atualizar/excluir. Para uma API REST mais comum, seria melhor retornar o item criado/atualizado, status HTTP adequado ou `204 No Content` no delete.

## Parar o banco

Para parar o container:

```bash
docker compose down
```

Para remover tambem os dados salvos no volume:

```bash
docker compose down -v
```
