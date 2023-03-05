# ProjetoEstagio

API de uma rede social especifica para estagiarios


##Endpoints

- Login

    - [Efetuar login](#login)

- Menu

    - [Visualizar perfil](#visualizar-perfil)
    - [Minhas postagens](minhas-postagens)

- Informações Pessoais

    - [Cadastrar informações](#cadastrar-informacoes)
    - [Alterar informações](#alterar-informacoes)

- Perfil

    - [Foto do perfil](#foto-perfil)
    - [Alterar dados](#alterar-dados)

- Informações Tecnicas

    - [Alterar Informações Tecnicas](alterar-informacoes-tecnicas)


## Descrição Dos Endpoints

### Login

`POST` /ProgramaEstagio/api/login

|campo  | tipo | obrigatorio  | descrição
|-------|------|:------------:|----------|
|usuario|string|     sim      | campo para inserir o usuario criado na plataforma.
|senha  |string|     sim      | é um campo em que o usuario insere a senha que foi criada na plataforma


### Menu

`POST` /ProgramaEstagio/api/menu/postagem

|campo      | tipo | obrigatorio  | descrição
|-----------|------|:------------:|----------|
|titulo     |string|     sim      | campo que leva o titulo das postagens que o usuario vai realizar
|mensagem   |string|     sim      | campo que sera utilizado pelo usuario para descrever suas postagens
|midia      |Byte[]|     sim      | o usuario vai poder colocar imagens, videos e links de seus projetos.

```js
    {
        titulo: "Minha aplicação sobre financas"
        mensagem: "Ola estou postando o link do meu projeto em que fiz durante o curso de React"
        midia: "Inserir Link, video ou imagem do projeto"
    }
```

**Respostas**
|codigo | descrição
| -|-
|201 | postagem feita com sucesso
|400 | campos invalidos, prencher corretamente

### Informações Pessoais

`POST` /localhost/api/informacoes

|campo      | tipo | obrigatorio  | descrição
|-----------|------|:------------:|----------|
|nome       |string |     sim      | usuario pode vizualizar o perfil de outros candidatos.
|nascimento | data  |     sim      | campo para inserir data de nascimento do usuario
|genero     |boolean|     sim      | retorna o genero do usuario.
|cpf        |long   |     sim      | campo para inserir o cpf do usuario
|rg         |long   |     sim      | campo para inserir o rg do usuario
|endereco   |string |     sim      | campo para inserir o endereco do usuario
|cep        |long   |     nao      | campo dedicado ao cep do usuario

```js
    {
        nome: "Jose Antonio"
        data: "2023-28-08"
        genero: "Masculino"
        cpf: "444.777.222-10"
        rg: "20.424.111-9"
        endereco: "Rua goncalves dias"
        cep: 04.190-999
    }
```

**Respostas**
|codigo | descrição
| -|-
|201 | informações pessoais salvas com sucesso
|400 | campos invalidos

### Perfil

`POST` /localhost/api/perfil

|campo       | tipo   | obrigatorio  | descrição
|------------|--------|:------------:|----------|
|curso       |string[]|     sim      | o usuario devera inserir o curso em que esstá matriculado
|instituicao|string[] |     sim      | o usuario ira escolher sua intituição de ensino.
|descricao   |string  |     sim      | descricao do que esta estudando na curso e da instituicao.

### Informações Tecnicas

`POST` /localhost/api/habilidades

|campo       | tipo   | obrigatorio  | descrição
|------------|--------|:------------:|----------|
|idioma      |string[]|     nao      | o usuario devera inserir um idioma se possuir
|Linguagens  |string[]|     nao      | o usuario ira escolher linguagens de programação que tem mais afinidade e o seu nivel

**Respostas**
|codigo | descrição
| -|-
|201 | habilidades inseridas com sucesso


