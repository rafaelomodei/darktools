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

- [ ] layout UI
- [ ] Criar cenas
- [ ] Implementação da história
- [ ] Salvar jogo
- [ ] Persistir os dados no MYSQL


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

**História**<br>
Exemplo arquivo json responsável pro direcionar os acontecimentos ao decorrer da história.
```
[
  {
      "id":"1a",
      "turnSide":"neutral",
      "whoSpeaks":"Master",
      "words":["Olá guerreiros","Bem vindos ao caos","Preparados para sofrer?"],
      "wordsSongs":["etc/songs/speaks1.mp3"],
      "enemy":["cavaleiro"],
      "currentScenario":"taberna",
      "commands":["showButtons"],
      "showButtons":["Sim", "Não", "Estou pronto pra morte!"],
      "routes":["2a","3a","4a"]
  },
]
```

- ``id`` -> Endereço
- ``turnSide`` -> De qual lado é quem está falando (neutral, enemy, player)
- ``whoSpeaks`` -> Nome da pessoa que esta falando
- ``words`` -> Falas
- ``wordsSongs`` -> Caminho do arquivo de audio das falas
- ``enemy`` -> Endereço dos personagens que estão a falar e batalhar (caso o atributo "battle" exista na chave ``commands``)
- ``currentScenario`` -> Cenário
- ``commands`` -> Armazenará atributos que definirão certos comportamentos (``showButtons`` = Define o aparecimentos de botões de escolha na tela)
- ``showButtons`` -> Textos dos botões que irão aparecer (valor definido pela quantidade de atributos)
- ``routes`` -> Armazena o endereço dos proximos segmentos de script;
 

**Cenário**<br>
Exemplo arquivo json responsável por conter dados de informações de cenários pertencentes ao mapa do jogo.
```
[
  {
      "id":"taberna",
      "pathImage":"path/img.png"
  }
]
```

- ``id`` -> Endereço
- ``pathImage`` -> Caminho para o documento da imagem de fundo do respectivo cenário

**Personagens**<br>
Exemplo arquivo json com dados dos personagens não jogáveis.
```
[
  {
		"id":"cavaleiro1",
		"name":"Erick Mavine ou só Cavaleiro, depende se é um NPC de fundo ou um NPC importante"
		"damage":20,
		"skill":"lançada",
		"pathImage":"pasta/seila.png"
	},
]
```

- ``id`` -> Endereço
- ``name`` -> Nome do personagem
- ``damage`` -> Dano do personagem
- ``skill`` -> Nome da habilidade de combate usada pelo personagem
- ``pathImage`` -> Caminho para o documento da imagem do personagem

### ✅ Autores
- [Jeferson Carlos Martin](https://github.com/jefersoncmn)
- [Pedro Henrique Alves dos Anjos](https://github.com/pedro182haa)
- [Rafael Geovani Omodei](https://github.com/rafaelomodei)


###  Agradecimentos
