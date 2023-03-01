# CRUD de um produto-SKU com Spring Boot e Spring MVC

## 💻 Sobre o projeto

Este projeto apresenta as operações de CRUD - Cadastro, Leitura, Update e Delete de um produto. 
Com a construção de algumas views feitas com o auxilio do Spring MVC.

## 📃 Requisitos apresentados pelo cliente

Com o apoio do Spring MVC, realize uma implementação para realizar a persistência de um
&quot;produto&quot;. Obs.: Não há necessidade de realizar a persistência dos seus objetos
relacionados, neste momento o objetivo será apenas compreender sua habilidade em
realizar o setup do projeto e implementação das classes e interfaces mínimas para tal
operação.

## ⚙️ Funcionalidades Estabelecidas

Index - Listar todos os produtos. Com links para:
Criar um "Novo Produto" - para a view new, contendo validação dos campos.
Detalhar um produto com "Detalhes" - dá acesso a view show.
Editar um produto com "Editar" - Carrega o id e abre a view edit com seus valores.
Deletar um produto com "Deletar" - Realiza a exclusão do produto selecionado de forma imediata.


## ⚙️ Funções dos métodos na produtoController

- index - Traz a lista de produtos existentes no banco e monta a view index.
- nnew - Retorna a view de criação de um produto.
- create - Se não tiver erros salva no banco de dados os dados que vieram no formulário, 
se tiver erros retorna a view com o apontamento dos erros. 
- show - Monta a view show detalhando o id que foi clicado, se o id não existir aprenta a index.
- edit - Monta a view edit com os atributos do produto que deseja editar
- update - Recebe a requisição da pagina edit, e se existir o id, atualiza os seus atributos.
- delete - Remove um produto pelo seu id, se ele existir.

## 🛠 Tecnologias

As seguintes tecnologias foram utilizadas no desenvolvimento da API MVC do projeto:

- **[Java 17](https://www.oracle.com/java)**
- **[Spring Boot 3](https://spring.io/projects/spring-boot)**
- **[Spring MVC](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html)**
- **[Maven](https://maven.apache.org)**
- **[PostgreSQL](https://www.postgresql.org/)**
- **[Hibernate](https://hibernate.org)**
- **[Lombok](https://projectlombok.org)**
- **[thymeleaf](https://www.thymeleaf.org)**

## Como utilizar

#### Carregamento do projeto

 <p>Neste momento para utilizar o sistema é necessário rodar o sistema offline dentro de alguma IDE, através do Spring Boot.</p>
   <p><strong>Etapas:</strong></p>
     - Download do projeto e descompactar </br>
     - Fazer a atualização das dependências com o Maven em sua IDE</br>
     - Fazer a configuração do banco de dados de sua preferência</br>
     - Criar o scema no banco de dados </br>
     - Configurar a API para este banco de dados</br>
     - Rodar o projeto com a app.properties em spring.jpa.hibernate.ddl-auto=create</br>
     - Em seguida colocar spring.jpa.hibernate.ddl-auto=none</br>

#### Na operacionalização do sistema:

Acessar local http://localhost:8080/produtos que leva a página inicial.
Em seguida cadastrar alguns novos produtos clicando no link Novo Produto.

Depois de cadastrado o sistema redireciona para a view Detalhes, mostrando
os detalhes do produto recém cadastrado. 

Clicando no botão voltar o sistema acessa a view index, onde é mostrada a lista 
de produtos com o novo produto incluso. 
