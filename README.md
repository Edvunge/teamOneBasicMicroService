### SpringBoot API Spring Boot project + DB Docker (team) MySQL and Docker Exercise ###

In order to put api running you need to install docker https://docs.docker.com/get-docker/ 

create and acount https://hub.docker.com/ 

if you're using intellij Ide install docker plugin

When oppening the project you need to run in project path in terminal 

``` docker-compose -f src\main\resources up ```

``` docker ps ``` --> to check if u r in the right place 


and run the project

``` mvnw spring-boot:run ```



you can open workbench connecting in port 3307
this project about microservices,
where the main objective is to create a basketball league, where we have teams, players and games
We created the relation many to many
We created the one to many relation and implemented the basic rules to create CRUD ,
and Create the DB and dockerize it
and the entities between them within a period of three hours in group
Create a Spring Boot project, the database (MySQL) has to be in Docker.
- Create 3 tables
- Create a relation many to many
- Create a relation one to many
- Create the basic CRUD:
- Get registers by id
- Get all the registers
- Create new register
- Delete register
- Update register
- Create the DB and dockerize it
- Push the changes to you repository and add it in the excel
- Create a basic READ.me file explaining the project and the entities.
- Create a tutorial with screenshots of the process of dockerize the DB.
- Use google drive and add the link in the same excel
At the end of the lesson the project should be delivered (time estimated approx. 3:45 hours).
