## springboot-testing-layers-h2

### Spring Boot App (MySql-main DB; H2-in memory for testing; Jacoco - test cover percentage)

The main goals of the project is:

* create Spring Boot App on Java 17;
* three layers are: repository, service, controller;
* for the whole app is used MySql DB (configured in application.properties);
* for the generating app content used 'contentloader' package;
* h2-DB is used as embedded DB only for testing (does not detached with main MySql DB);
* testing packages is presented by tested classes from layers and entity also;
* repository tested by JUnit4 and JUnit5 (ProductRepositoryTest3);
* service tested by JUnit5 and assertj;
* controller tested by JUnit5 and mockMvc;
* jdbc:h2:mem:memDB configured as embedded DB in test 'recourses' package in application.properties

#### dependencies:
  - jpa;
  - web;
  - devtools;
  - mysql-connector-j;
  - spring-boot-starter-test;
  - junit; (JUnit 4)
  - h2;

#### plugins:
* spring-boot-maven-plugin;
* jacoco-maven-plugin; (reporting test coverage)

