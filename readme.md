# FICTICIUS API

Esta api foi desenvolvida como demonstração e prática de conhecimentos em Java
através do web framework Spring.

O projeto será evoluído com o tempo e até o momento foram mapeadas oportunidades
de melhoria ao fim deste texto.

### Orientações para execução do projeto:

- Clone o projeto em uma pasta com o comando
  `git clone <url do repositório>.git`

- Utilize o Gradle para realizar a build com o comando `gradle build` nas pastas
  de cada uma das APIs. É importante, pois o docker-compose irá utilizar a pasta
  bin para executar o projeto no container.

- Após as respectivas builds, executar dentro do terminal na pasta de origem do
  arquivo docker-compose o comando `docker-compose up -d`

### Portas do projeto:

- cars-api -> 8080;
- consumption-api -> 8081
- api-docs -> /api-docs
- swagger-ui -> /swagger-ui.html

### Pendências

- Customização de pesquisa no retorno das APIs, como paginação, ordenação,
  HATEOAS, etc;
- Aprimoramento das mensagens de erro;
- Documentação com instrução de uso;
- Melhorar campos do Swagger-UI;
- Implementação dos testes automatizados;
- Otimização das queries utilizando o JPA/Hibernate e redução de complexidade
  dos algoritmos;
- Implementação de observabilidade;
- Comunicação entre APIs utilizando websockets, webhooks, gRPC ou mensagerias
  gerais ao invés de HTTP/Rest;
- Javadoc;
- Reavaliação da estrutura de pastas/nomenclatura de arquivos;
