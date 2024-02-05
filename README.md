## :orange: Hackatlon Backend Project 
<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" />
    </a>
  <a alt="Maven">
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white"/>
  </a>
    <a alt="MySQL">
        <img src="https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white" />
    </a>
    <a alt="Spring">
        <img src="	https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white" />
    </a>
    <a alt="Spring Security">
        <img src="https://img.shields.io/badge/Spring_Security-6DB33F?style=for-the-badge&logo=Spring-Security&logoColor=white" />
    </a>
    <a alt="JWT">
        <img src="https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens" />
    </a>
    <a alt="AWS S3">
        <img src="https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white">
    </a>
</p>

## :memo: Descrição 
<ul>
<li><h3>User</h3>
  <ul>
    <li><strong>Criar:</strong>
         <ol>
            <li><strong>Request: </strong><em>firstName, lastName, email, password</em></li>
            <li><strong>Response: </strong><em>sem response</em></li>
        </ol>
    </li>
  <li><strong>Login:</strong>
    <ol>
      <li><strong>Request: </strong><em>email, password</em></li>
      <li><strong>Response: </strong><em>token</em></li>
    </ol>
  </li>  
  <li><strong>Inserir imagem de perfil:</strong>
    <ol>
      <li><strong>Request: </strong> <em>file, id</em></li>
      <li><strong>Response: </strong><em>sem response</em></li>
    </ol> 
  </li>
  <li><strong>Atualizar perfil:</strong>
    <ol>
      <li><strong>Request: </strong><em>id, firstName, lastName, country, email</em></li>
      <li><strong>Response: </strong><em>firstName, lastName, country, email</em></li>
    </ol>
  </li>
  <li><strong>Listar perfil por email:</strong>
    <ol>
      <li><strong>Request: </strong><em>email</em></li>
      <li><strong>Response: </strong><em>firstName, lastName, country, email</em></li>
    </ol>
  </li>
  <li><strong>Deletar perfil:</strong>
    <ol>
      <li><strong>Request: </strong><em>id</em></li>
      <li><strong>Response: </strong><em>sem response</em></li>
    </ol>
  </li>
  </ul>
  </li>
  <li><h3>Projeto:</h3>
  <ul>
    <li><strong>Criar projeto:</strong>
         <ol>
            <li><strong>Request: </strong><em>user_id, title, tags, detailing</em></li>
            <li><strong>Response: </strong><em>user_d, title, tags, detailing</em></li>
        </ol>
    </li>
    <li><strong>Listar todos os projetos por usuário:</strong>
    <ol>
      <li><strong>Request: </strong><em>user_id</em></li>
      <li><strong>Response: </strong><em>user_d, title, tags, detailing, image, date</em></li>
    </ol> 
    </li>
    <li><strong>Listar todos os projetos:</strong>
    <ol>
      <li><strong>Request: </strong><em>user_id</em></li>
      <li><strong>Response: </strong><em>user_d, title, tags, detailing, image, date</em></li>
    </ol> 
    </li>
    <li><strong>Atualizar projeto:</strong>
     <ol>
      <li><strong>Request: </strong><em>id, user_id, title, tags, detailing, image</em></li>
      <li><strong>Response: </strong><em>user_id, title, tags, detailing, image</em></li>
     </ol> 
    </li>
   <li><strong>Inserir imagem de perfil:</strong>
    <ol>
      <li><strong>Request: </strong> <em>file, id</em></li>
      <li><strong>Response: </strong><em>sem response</em></li>
    </ol> 
  </li>
  <li><strong>Deletar projeto:</strong>
    <ol>
      <li><strong>Request: </strong><em>id</em></li>
      <li><strong>Response: </strong><em>sem response</em></li>
    </ol> 
    </li>
  </ul>
  </li>
</ul>

## :rocket:	Execução do projeto
Para construir o projeto basta executar esse comando na pasta raiz:
```shell
mvn clean install
```
Com a aplicação rodando, clique neste link: <a href="[http://localhost:8085/swagger-ui/index.html#/]">http://localhost:8085/swagger-ui/index.html#</a>

## :computer:	Descrição das ferramentas
  <table align="center">
  	<td>Linguagem</td>
  	<td>Java</td>
  </tr>
  <tr>
  	<td>Framework</td>
  	<td>Spring Boot</td>
  </tr>
  <tr>
  	<td>Build Tool</td>
  	<td>Maven</td>
  </tr>
  <tr>
  	<td>Banco de Dados</td>
  	<td>MySQL com AWS RDS</td>
  </tr>
  <tr>
  	<td>Armazenamento de imagens</td>
  	<td>AWS S3</td>
  </tr>
  <tr>
  	<td>Database Migration</td>
  	<td>Flyway</td>
  </tr>
  <tr>
  	<td>Deploy</td>
  	<td>AWS EC2</td>
  </tr>
  </table>

## :technologist:	Contribuidores 

<table>
   <tr>
     <td align="center">
     <a href="https://github.com/victorsilvestref">
       <img
         src="https://avatars.githubusercontent.com/u/157164375?v=4"
         width="100px;"
         alt="Victor Silvestre"
         />
        <br />
        <sub>
         <b>Victor Silvestre</b>
        </sub>
     </a>
   </td>
   <td align="center">
     <a href="https://github.com/silvadebora">
        <img
          src="https://avatars.githubusercontent.com/u/105131756?v=4"
          width="100px;"alt="Débora" />
        </br>
       <sub>
        <b>Débora Silva</b>
      </sub>
      </a>
      </td>
    <td align="center">
      <a href="https://github.com/LucasBentodev">
        <img
          src="https://avatars.githubusercontent.com/u/104996345?v=4"
          width="100px;"
          alt="Lucas Jair Bento"/>
        <br>
          <sub>
            <b>Lucas Jair Bento</b>
          </sub>
      </a>
   </td>
   </tr>
</table>
