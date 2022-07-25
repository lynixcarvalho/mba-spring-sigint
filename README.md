# SiGInt - Sistema de Gerenciamento e Integração  🤵‍♂️🤖🍻🍻😄

![Badge em Desenvolvimento](http://img.shields.io/static/v1?label=STATUS&message=Em+desenvolvimento&color=GREEN&style=for-the-badge)

## 🎯 Objetivo

SiGInt é um sistema para gerenciamento e integração que possibilita o cadastro de alunos de uma instituição, gerar cartões para os mesmos e integrar com autorizadora externa transações nesses respectivos cartões. Além disso, disponibiliza extrato das transações feitas nos cartões.


## 🛠️ Tecnologias utilizadas

- Docker: devido a facilidade de subir um banco de dados já configurado e pronto para integrar com o Spring. Além disso, a ideia é portar toda aplicação para microsserviços utilizando o docker
- Git: ferramenta escolhida para controle de versão e integração do código
- Gradle
- Java
- MySQL: Escolhido por ser um banco de dados relacional, com estrutura específica e que apresenta os dados em tabela. No entanto, a principal razão é a possibilidade de criar relações entre as entidades.
- REST
- Spring

### Pré requisitos:
- Docker com a ferramenta docker-compose instalada
- Git
- Java 17

### Passo a passo para a execução:
1. Clonar projeto do GitHub:
~~~bash
$ git clone git@github.com:lynixcarvalho/mba-spring-sigint.git
$ cd mba-spring-final-project
~~~
2. Subir o banco de dados utilizando o docker-compose:
~~~bash
$ docker-compose up -d
~~~
3. Acessar o diretório filebatch e executar o bootRun.
~~~bash
$ cd filebatch
$ ./gradlew bootRun
~~~
4. Voltar para a pasta raiz do projeto, acessar o diretório sigint e executar o bootRun:
~~~bash
$ cd ../sigint
$ ./gradlew bootRun
~~~
5. Abrir uma nova janela ou aba do terminal, acessar a pasta raiz do projeto, acessar o diretório cardbatch e executar o bootRun:
~~~bash
$ cd cardbatch
$ ./gradlew bootRun
~~~

Os passos 3 e 5 acima servem para popular o banco de dados com os dados dos alunos fornercidos anteriormente. O passo 4 sobe a aplicação com o swagger, endpoints e a criação das tabelas no banco de dados.


## 👨🏽‍💻👩🏽‍💻 Desenvolvedores 

[<img src="https://avatars.githubusercontent.com/alessferns" width=115><br><sub>Alessandro Fernandes Santos</sub>](https://github.com/alessferns) 

[<img src="https://avatars.githubusercontent.com/KarinaFSantos" width=115><br><sub>Karina Fávero dos Santos</sub>](https://github.com/KarinaFSantos)  

[<img src="https://avatars.githubusercontent.com/lynixcarvalho" width=115><br><sub>Lincoln Silva Carvalho</sub>](https://github.com/lynixcarvalho)

[<img src="https://avatars.githubusercontent.com/Makio78" width=115><br><sub>Marcelo Akio Kitahara</sub>](https://github.com/Makio78)

[<img src="https://avatars.githubusercontent.com/jrsorgato" width=115><br><sub>Osvaldo Sorgato Junior</sub>](https://github.com/jrsorgato)

[<img src="https://avatars.githubusercontent.com/VANESSA-SS" width=115><br><sub>Vanessa Santos e Silva</sub>](https://github.com/VANESSA-SS) 


## Origem 
Projeto realizado como requisito para conclusão da disciplina Spring Framework do MBA Full Stack Development - FIAP 2022
Prof. Fabio Tadashi (https://github.com/fabiotadashi)
