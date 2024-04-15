# Gestão de locação de veículos
![GitHub License](https://img.shields.io/github/license/Jullianag/gestao-locacao-veiculos) ![GitHub language count](https://img.shields.io/github/languages/count/Jullianag/gestao-locacao-veiculos) 
![GitHub commit activity](https://img.shields.io/github/commit-activity/m/Jullianag/gestao-locacao-veiculos) ![GitHub last commit](https://img.shields.io/github/last-commit/Jullianag/gestao-locacao-veiculos) 
![GitHub repo size](https://img.shields.io/github/repo-size/Jullianag/gestao-locacao-veiculos) ![GitHub repo file or directory count](https://img.shields.io/github/directory-file-count/Jullianag/gestao-locacao-veiculos)


# Sobre o projeto

O projeto Gestão de locação é uma aplicação back end desenvolvida com base no curso **DevSuperior** do professor Nélio Alves. 
Site: [DevSuperior](https://devsuperior.com "Site da DevSuperior").

O projeto consiste em todas as estruturas de um CRUD, organizado em camadas, exceções, validações, consultas SQL e JPQL, controle de acesso e login. Nele o usuário admin faz a busca de outros clientes, 
veículos e todas as informações referentes ao cliente e ao veículo atrelado, assim como também adiciona, remove e atualiza novos clientes e veículos. O usuário cliente acessa apenas seu dados cadastrais e 
consulta veículos por "nome" ou id.

Todas as requisições foram testadas via **Postman** (GET, POST, DEL, PUT).


## Modelo conceitual
![Modelo Conceitual](https://github.com/Jullianag/gestao-locacao-veiculos/blob/main/assets/Diagrama.png)

## Postman
Fotos das transações executadas dentro do Postman

![Demonstração 2](https://github.com/Jullianag/gestao-locacao-veiculos/blob/main/assets/Captura%20de%20tela%202024-04-08%20173617.png)

![Demonstração 3](https://github.com/Jullianag/gestao-locacao-veiculos/blob/main/assets/Captura%20de%20tela%202024-04-08%20173729.png)

![Demonstração 4](https://github.com/Jullianag/gestao-locacao-veiculos/blob/main/assets/Captura%20de%20tela%202024-04-08%20173749.png)

![Demonstração 5](https://github.com/Jullianag/gestao-locacao-veiculos/blob/main/assets/Captura%20de%20tela%202024-04-08%20173824.png)

![Demonstração 6](https://github.com/Jullianag/gestao-locacao-veiculos/blob/main/assets/Captura%20de%20tela%202024-04-08%20173859.png)

## Collection Postman
[Arquivo JSON](https://github.com/Jullianag/gestao-locacao-veiculos/blob/main/assets/Locacao.postman_collection.json)


# Tecnologias utilizadas
## Back end
- Java
- Spring Boot
- JPA / Hibernate
- Maven

## Banco de dados:
- Banco de dados: teste H2
- Em produção: Postgres

# Como executar o projeto

```bash
# clonar repositório
git clone https://github.com/Jullianag/gestao-locacao-veiculos

# entrar na pasta do projeto back end
cd backend

# executar o projeto
./mvnw spring-boot:run
```

## Back end
Pré-requisitos: Java 21

# Autor

Julliana Gnecco

https://www.linkedin.com/in/julliana-gnecco/
