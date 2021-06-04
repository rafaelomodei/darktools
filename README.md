<h1 align="center"> Trabalho final da disciplina Linguagem de Programação Objeto Orientada a</h1>


## Sumário
<!--ts-->
   * [Status do Projeto](#status)
   * [Features](#Features)
   * [Pré-requisitos e como rodar a aplicação](#prerequisites)
   * [Depenências](#dependency)
      * [xyz](#xyz)
   * [Arquitetura](#architecture)

<!--te-->


### ✅ Status do Projeto

    🚧  Dark Tools, em construção...  🚧


### ✅ Features

- [x] layout UI
- [x] Criar cenas
- [x] Implementação da história
- [x] Salvar jogo
- [x] Persistir os dados no MYSQL


### ✅ Pré-requisitos e como rodar a aplicação

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- [Microsoft .NET Framework 4.5](https://www.microsoft.com/pt-br/download/details.aspx?id=30653) ``` Versão: 4.5``` 
- [Microsoft Visual C++ 2010 Redistributable Package (x86)](https://www.microsoft.com/en-us/download/details.aspx?id=5555) ``` Versão: 2010``` 
- [MYSQL for visual studio](https://downloads.mysql.com/archives/visualstudio/) ``` Versão: 1.2.8``` 

- [JDK 8u111 with NetBeans 8.2](https://www.oracle.com/technetwork/java/javase/downloads/jdk-netbeans-jsp-3413139-esa.html) ``` Versão: 8.2 ```
- [MySQL Workbench](https://downloads.mysql.com/archives/installer/) ``` Versão: 8.0.13``` 
  
**Criando uma nova conexão com DB MySQL no Netbeans**

JDBC URL:
```
jdbc:mysql://localhost:3306/<nomeDoBanco>?useTimezone=true&serverTimezone=UTC
```


### 🛠 Dependências

Maven Dependências
```
<dependencies>
  <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.13</version>
  </dependency>
  <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-entitymanager</artifactId>
      <version>4.3.1.Final</version>
  </dependency>
  <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-jpamodelgen</artifactId>
      <version>4.3.1.Final</version>
      <scope>provided</scope>
  </dependency>
</dependencies>
```


### ⚙ Arquitetura
Go to the Wiki :D

### ✅ Autores
- [Jeferson Carlos Martin](https://github.com/jefersoncmn)
- [Pedro Henrique Alves dos Anjos](https://github.com/pedro182haa)
- [Rafael Geovani Omodei](https://github.com/rafaelomodei)


###  Agradecimentos
Agradecimentos a toda equipe e envolvidos, pelo esforço e interesse em aprender.

### Bugs
Go to the Wiki :D
