# migration-junit4-junit5

### Spring Boot Application is showed migration from JUnit4 to JUnit 5;
Project contain:

* This source code repository contains JUnit 4 and JUnit 5 test examples with Maven.
* packages: entity, dataloader, exceptions, repository, service, controller;
* entity: Pizza, Ingredients; (Many-to-Many relationships);
* dataloader is for generation data for app;
* exceptions contain handling classes for existing cases of exceptions;
* repository: IngredientsRepository, PizzaRepository; (layer for persisting data);
* service: contain interfaces and implementations (IngredientServiceImpl, PizzaServiceImpl); layer for interact with the database more easily;
* controller: responsible for receiving HTTP requests (e.g., GET, POST, PUT, DELETE) from clients;
* pom: java17, jpa, mysql, h2, devtools, web, lombok;

### JUnit 4 testing
The following guide illustrate how to use JUnit 4:

* entity package tested: IngredientTest, PizzaTest, PortionSizeTest;
* repository package tested: IngredientRepositoryTest, PizzaRepositoryTest;
* service.impl package tested: IngredientServiceImplTest, PizzaServiceImplTest;
* controller package tested: IngredientControllerTest, PizzaControllerTest;

### JUnit 5 testing

The following guide illustrate how to use JUnit 5:

* case1;
* case2;
* case3;

### JUnit 4 migration to JUnit 5

The following guide illustrate how to migrate:

* case1;
* case2;
* case3;