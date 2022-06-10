# Rest-API-SpringBoot
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/lucashbdutra/Cities-API/blob/main/LICENSE) 

API rest que permite o cálculo da distancia entre duas cidades do Brasil. Além de permitir a pesquisa paginada de vários países do mundo e todos os estados do Brasil.

## Tecnologias utilizadas
### Back end

- Java
- Spring Boot
- JPA / Hibernate / PostgreSQL
- Docker
- Maven

## DataBase

### Postgres

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=root -e POSTGRES_PASSWORD=root -e POSTGRES_DB=cities postgres
```

### Populate

* [data](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL

docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

psql -h localhost -U root cities -f /tmp/pais.sql
psql -h localhost -U root cities -f /tmp/estado.sql
psql -h localhost -U root cities -f /tmp/cidade.sql

psql -h localhost -U postgres_user_city cities

CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)

### Access

```shell script
docker exec -it cities-db /bin/bash

psql -U root cities
```

### Query Earth Distance

Point
```roomsql
select ((select lat_lon from cidade where id = 4929) <@> (select lat_lon from cidade where id=5254)) as distance;
```

Cube
```roomsql
select earth_distance(
    ll_to_earth(-21.95840072631836,-47.98820114135742), 
    ll_to_earth(-22.01740074157715,-47.88600158691406)
) as distance;
```

## Como executar o projeto

### Back end
Pré-requisitos: Java 18

```bash
## clonar repositório
git clone https://github.com/lucashbdutra/Cities-API

## entrar na pasta do projeto que você quer executar
cd path-to-file

## executar o projeto
./mvnw spring-boot:run
```

# Autor

Lucas Dutra

https://www.linkedin.com/in/lucas-dutra-8b41681b7/
