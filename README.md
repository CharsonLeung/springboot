# bc2504p-sb

## Part 1: RESTful API
- @RestController (Controller, @Responbody)
- @GetMapping, @PostMapping, @DeleteMapping, @PutMapping, @PatchMapping
- @RequestParam, @PathVariable, @RequestBody
- Class & Interface (xxxxController.java, xxxxOperation.java)
- API endpoint URI: Noun Phrase
- Spring Web (Maven Dependency)

## Part 2: Spring Context
- Create Bean is Spring Context: IoC (@Controller, @Service, @Repository, @Configuration+@Bean, @Component, @ControllerAdvice)
  - @Configuration+@Bean -> i.e. RestTemplate
  - @Conponent -> i.e. Mapper Class (custom class)
  - @CotrollerAdvice -> Global Exception Handling
- Inject Bean: DI
  - @Autowired (Search the Bean in Spring Context)
  - @Value (Such configuration params from yml)
- Inversion of Control (IoC) + Dependency Injection (DI) -> Server Starts (Bean Cycle)
  - if IoC and DI fail, Server start will fail.
  - Spring automates the dependency check in sequence (observe @autowired)

## Part 3: Database
- JPA + Database Driver (Maven Dependency)
- application.yml -> DB connection properties
- Entity class -> Table (JPA Hibernate -> create table SQL)
  - @Entity, @Table, @Getter, @NoArgsController, @AllArgsConstructor, @Builder, 
  @Column, @Id (PK), @GeneratedValue, @ManyToOne, @JoinColumn(FK)
  - Repository (CRUD) -> DML Operation (insert, select, update, delete)
    - JPA Methods (Java Method Pattern, i.e. OrderByXXXX, findByXXXX, And, Or)
      - Optional<XXXX>
      - List<XXXX>
      - findAll, findById, saveAll, save, deleteAll, deleteById
      - Find by FK, i.e. PostRepository.java -> findByUserEntity
    - JPQL (Select Entity By custom query)
    - Native SQL Query (DB specific)

## Part 4: Data Transfer Object + Serialization
- @JsonProperty (Isolate the field name between JSON and Class attribute)
- Serialization Java Object -> JSON
- Deserialization: JSON -> Java Object
- /dto folder: For Controller use (request / respond)
- /model/dto folder: For Service use (call third party)
- Mapper (i.e. Builder Logic)
  - API consumer -> controller -> select Entity -> DTO -> return API consumer
  - API consumer -> controller -> DTO -> Entity -> Database
  - Combine two entities into one DTO 
  - Combine two DTO into one DTO

## Part 5: AOP (@ControllerAdvice)
- Able to return a separate program flow
- Return another response type
- For method caller, no longer use try-catch
- throw exception object as usual

## Part 6:
- CommandLineRunner (Bean for ADP)
- Scheduling
- ObjectMapper
- Redis (RestTemplate/ RedisManager)

## Spring Boot Project
- Update Code -> Save -> harddrive
- mvn clean install -> geerate jar file (target folder)