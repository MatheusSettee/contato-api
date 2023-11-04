# API de Contatos
## Descrição do Projeto
O projeto consiste em uma API REST para gerenciar um sistema de cadastro de Pessoas e seus Contatos. Sendo como principal objetivo permitir operações CRUD (Create, Read, Update, Delete). 

## Requerimentos
- Java 17
- MySQL

## Banco de Dados
Criar um Schema `app-contatos` no Banco de Dados MySQL

## Instalação de dependências e inicialização do projeto
```
./mvnw.cmd install
```

```
./mvnw.cmd spring-boot:run
```

## Acessar a documentação do OpenAPI
```
http://localhost:8080/swagger-ui.html
```

## Aplicabilidade
### Pessoas
- Adicionar uma nova pessoa
* Editar uma pessoa existente pelo id
+ Remover uma pessoa existente pelo id
- Buscar todas as pessoas cadastradas
* Busca uma pessoa cadastrada pelo id
+ Retornar os dados de uma pessoa com Mala Direta

### Contatos
- Adiconar um novo contato para uma pessoa existente
* Editar um contato existente pelo id
+ Remover um contato existente pelo id
- Buscar todos os contatos de uma pessoa
* Listar todos os contatos disponiveis
+ Carregar dados de um contato pelo id
