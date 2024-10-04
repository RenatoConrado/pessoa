# Gerenciamento de Pessoas

## Aluno: Renato Conrado da Silva 01629996

## [application.properties](./src/main/resources/application.properties)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
```

## POST

````
http://localhost:8080/persons
````

## GET

````
http://localhost:8080/persons/{id}
````

## Exemplo

### POST

````
http://localhost:8080/persons
````

````json
{
    "name": "Marcelo",
    "cpf": "12345678910",
    "age": 25
}
````

### GET

````
http://localhost:8080/persons/94587228-0b7b-4eec-a2dd-c6d3e96e68a1
````

````json
{
    "id": "94587228-0b7b-4eec-a2dd-c6d3e96e68a1",
    "name": "Marcelo",
    "cpf": "12345678910",
    "age": 25
}
````

