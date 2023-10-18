
# Desafios de Back-end

   Este repositório contém uns desafios de back-end proposto por algumas empresas.

## Desafios

   Os desafios são divididos em pastas.

-  [Desafio PicPay Back-end](#desafio-picpay-back-end)
- [Desafio 2](#desafio-2)


## Desafio PicPay Back-end

Este [repositório](https://github.com/Cry199/Desafios-Back-end/tree/main/Desafios/picpaydesafiobackend) contém a implementação do desafio técnico proposto pela PicPay para a vaga de back-end.

[Link para o Desafio](https://github.com/PicPay/picpay-desafio-backend)

O desafio consiste em criar uma API REST para realizar transferências entre usuários. As principais funcionalidades são:

-   Cadastro de novo usuário
-  Listar todos os usuários cadastrados
-  Realiza transferência entre usuários

### Tecnologias

-   Java 17
-   Spring Boot
-   Maven
-   Banco de dados H2

### Estrutura do projeto

-   Controller: Controllers REST que expõem os endpoints da API
-   Service: Camada de serviços, contendo a lógica de negócio
-   Repository: Camada de acesso ao banco de dados H2
-   DTO: Objetos de transferência de dados
-   Exception: Tratamento de exceções personalizadas
  
### Executando o projeto localmente

Para executar o projeto na sua máquina, siga os passos abaixo:

**1. Clone o repositório**

    https://github.com/Cry199/Desafios-Back-end.git

**2. Navegue até a pasta do projeto**

    cd Desafios\picpaydesafiobackend

**3. Execute o comando para build**

    mvn clean install
    
**4. Execute a aplicação**

    mvn spring-boot:run
    
A API estará disponível em `http://localhost:8080`.

**5. Acesse os endpoints**

Agora você pode acessar os endpoints da API no seu navegador ou ferramenta como Postman.

Por exemplo, para cadastrar um novo usuário:

    POST /users 
    {  "firstName":  "Teste",  "lastName":  "Teste",  "document":  "122345671223",  "email":  "teste@gmail.com",  "userType":  "COMMON",  "balance":  10,  "password":  "Teste"  }

### Rotas da API
As rotas da API são:

-   `POST /users`  - Cadastro de novo usuário
-   `GET /users`  -  Listar todos os usuários cadastrados
-   `POST /transfers`  - Realiza transferência entre usuários

### POST /users
Rota para cadastro de novo usuário.

**Request body:** Objeto JSON representando um usuário com os campos firstName, lastName, document, email, userType, balance e password.

**Exemplo de request body:**

    {  "firstName":  "Cauã",  "lastName":  "Ribeiro",  "document":  "122345671223",  "email":  "teste@gmail.com",  "userType":  "COMMON",  "balance":  10,  "password":  "senha"  }
    
   **Response:** Objeto JSON representando o usuário criado, contendo os campos id e demais campos submetidos no cadastro.
   
   **Exemplo de response:**
   

    {  "id":  1,  "firstName":  "Cauã",  "lastName":  "Ribeiro",  "document":  "122345671223",  "email":  "teste@gmail.com",  "password":  "senha",  "balance":  10,  "userType":  "COMMON"  }
   
    
### GET /users

Rota para listar todos os usuários cadastrados.

**Parâmetros:** Nenhum

**Response:** Array de objetos JSON representando os usuários.

**Exemplo de response:**

    [  {  "id":  1,  "firstName":  "Cauã",  //...demais campos },  {  "id":  2,  "firstName":  "Helo",  //...demais campos  }  ]

### POST /transfers
Rota para realizar transferência entre contas.

**Request body**: Objeto JSON representando a transferência, com os campos amount, sender e receiver.

**Exemplo de request body:**

    { "senderId":  1, "receiverId":  2,"value":  1}

**Response:** Objeto JSON representando transferência efectuada, incluindo o campo timestamp.

**Exemplo de response:**

    {"id":1,"anount":1,"sender":{"id":2,"firstName":"Cauã","lastName":"Ribeiro","document":"122345671223","email":"teste@gmail.com","password":"senha","balance":9.00,"userType":"COMMON"},"receiver":{"id":3,"firstName":"Helo","lastName":"Ribeiro","document":"12234567","email":"teste1@gmail.com","password":"senha","balance":11.00,"userType":"COMMON"},"timestamp":"2023-10-18T15:59:05.1549889"}

## Possíveis Melhorias

### Explorando mais do Spring Boot

-   Implementar mais validações customizadas para aprender sobre Bean Validation.
-   Adicionar documentação Swagger para praticar documentação de APIs.
-   Habilitar métricas e endpoints do Spring Boot Actuator para monitoramento.

### Aprendendo sobre banco de dados

-   Migrar para MySQL/PostgreSQL para praticar SQL e um banco relacional.
-   Implementar um reposítório CRUD customizado para praticar acesso a dados.

### Conhecendo testes automatizados

-   Escrever testes unitários em JUnit para classes críticas.
-   Testar o repository com dados mockados para isolar a camada.
-   Automatizar a build e testes com Maven lifecycle.

### Subindo nível em Java e OO

-   Refatorar o código para reduzir duplicação.
-   Melhorar modularização seguindo princípios SOLID.
-   Aplicar Design Patterns para desacoplar components.

### Preparando para produção

-   Containerizar a aplicação em um Dockerfile para aprender sobre containers.
-   Automatizar o processo de build em um pipeline simples.
-   Fazer deploy da aplicação na nuvem para conhecer cloud providers.


### Considerações Finais

Este projeto foi desenvolvido como parte do desafio proposto pela PicPay. Foi um excelente exercício para praticar boas práticas de API REST com Spring Boot e documentação.

[TOP (￣y▽,￣)╭ ](#desafios)

## Desafio 2

Em Construção (❁´◡`❁)

## Créditos
Criado por [Cry199](https://github.com/Cry199) como material de estudo.


