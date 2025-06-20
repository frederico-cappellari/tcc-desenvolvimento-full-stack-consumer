# Gestão Financeira - Nota Fiscal Consumer

## Finalidade do Projeto

Este projeto tem como objetivo gerenciar e consumir informações de notas fiscais eletrônicas, integrando funcionalidades de controle financeiro, categorias, transações, listas de compras e usuários. Ele foi desenvolvido utilizando o framework Quarkus, proporcionando alta performance e facilidade de integração com bancos de dados relacionais e mensageria (RabbitMQ).

## Tecnologias Utilizadas
- Java 21
- Quarkus 3.22.1
- PostgreSQL
- RabbitMQ
- Maven

## Pré-requisitos
- Java 21 instalado
- Maven instalado
- Docker (opcional, para banco de dados e RabbitMQ)
- PostgreSQL em execução (local ou via Docker)
- RabbitMQ em execução (local ou via Docker)

## Instalação e Execução

### 1. Clone o repositório

### 2. Configure o banco de dados e RabbitMQ
Você pode utilizar Docker para subir rapidamente os serviços necessários:

#### Subindo PostgreSQL e RabbitMQ com Docker
```sh
docker run --name postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:15

docker run --name rabbitmq -p 5672:5672 -p 15672:15672 -d rabbitmq:3-management
```

Ajuste as configurações de conexão no arquivo `src/main/resources/application.properties` conforme necessário.

### 3. Build do projeto
```sh
./mvnw clean install
```
Ou, se estiver no Windows:
```sh
mvnw.cmd clean install
```

### 4. Executando o projeto em modo desenvolvimento
```sh
./mvnw quarkus:dev
```
Ou, no Windows:
```sh
mvnw.cmd quarkus:dev
```

A aplicação estará disponível em: http://localhost:8080


## Observações
- Certifique-se de que as portas 5432 (PostgreSQL) e 5672/15672 (RabbitMQ) estejam livres.
- O projeto utiliza Quarkus, facilitando a criação de imagens nativas e integração com containers.

## Contato
Dúvidas ou sugestões? Entre em contato com o mantenedor do projeto.

