# Desafio Java - GFT

Este é um projeto de exemplo para o Desafio Java da GFT. Ele apresenta uma aplicação Java desenvolvida com o uso das seguintes tecnologias:

- Java 17
- Spring 5
- PostgreSQL 12.1
- Docker
- JUnit

## Pré-requisitos

Antes de começar, verifique se você atende aos seguintes requisitos:

- Ter o Docker instalado em sua máquina.
- Ter o Git instalado em sua máquina.

Certifique-se de que a porta 8080 esteja disponível em sua máquina. Se você estiver usando essa porta para outros fins, ajuste a porta no arquivo docker-compose.yml antes de executar o comando docker compose up.

## Executando com Docker

Siga as instruções abaixo para executar a aplicação utilizando o Docker:

Abra o terminal de sua preferência.
Clone o repositório usando o seguinte comando:

`git clone https://github.com/marcosfaneli/gft-desafio-java.git`

Acesse a pasta criada usando o terminal:

`cd gft-desafio-java`

Dentro da pasta, execute o seguinte comando para iniciar o contêiner

`docker compose up`

Após seguir essas etapas, você poderá acessar a aplicação em seu navegador no endereço:

http://localhost:8080/swagger-ui.html

Espero que essas instruções sejam úteis para você executar o projeto com o Docker. Sinta-se à vontade para ajustar e personalizar conforme necessário.

## Pontos de melhoria

Sobre o projeto entregue alguns pontos de melhoria podem e devem ser aplicados para que a aplicação possa ser usada em sua totalidade:

- Unicidade do campo de e-mail
- Paginação na listagem de usuários
- A estratégia de geração de id das entities poderia ser trocada por UUID
- Incluir configuração para geração de logs
- Incluir testes de Integração
