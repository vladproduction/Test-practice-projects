# junit5-springboot-pizzadb

### Spring Boot Application is illustrating how to use JUnit 5 and Mockito;
Project contain:

* This source code contains JUnit 5, Mockito test examples with Maven.
* packages: entity, dataloader, exceptions, repository, service, controller;
* entity: Pizza, Ingredients; (Many-to-Many relationships);
* dataloader is for generation data for app;
* exceptions contain handling classes for existing cases of exceptions;
* repository: IngredientsRepository, PizzaRepository; (layer for persisting data);
* service: contain interfaces and implementations (IngredientServiceImpl, PizzaServiceImpl); layer for interact with the database more easily;
* controller: responsible for receiving HTTP requests (e.g., GET, POST, PUT, DELETE) from clients;
* pom: java17, jpa, mysql, h2, devtools, web, lombok, mockito;

### JUnit 5 testing
The following guide illustrate how to use JUnit 5:

* entity package tested: IngredientTest, PizzaTest, PortionSizeTest;
* repository package tested: IngredientRepositoryTest, PizzaRepositoryTest;
* service.impl package tested: IngredientServiceImplTest, PizzaServiceImplTest;
* controller package tested: IngredientControllerTest, PizzaControllerTest;
