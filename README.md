# Adidas Product Creation Challenge

This Java project has been implemented using:
 - Maven as project management and comprehension tool 
 - Spring Boot has been used to build the application
 - Each Spring boot application has been built and packaged as a Docker Microservice
 - Neo4J has been used as Graph NoSQL database 
 - An "adidas-product-creation-service-registry" microservice as Eureka Service Registry
 - An "adidas-product-creation-client" microservice that deals with querying Neo4J NoSQL
 - An "adidas-product-creation-rest" microservice that is the entry point of the application.

# Building and Running

 1. First of all clone the project running:
 > git clone https://github.com/pgian33/adidas-product-creation-20201021.git
 
2. Then you have to move into the main directory called: **"adidas-product-creation"**. Here you can run the following command to build the docker images of the 
spring boot applications using Maven:
> mvn clean install

3. On Unix S.O. there's a problem with grants related to the Docker hub image of Neo4j. For this reason I edited the original Dockerfile but you 
need to build the image again using the following ommand:
> docker-compose build --no-cache

4. After that, we are ready to use our docker-compose to run all the containers running:
> docker-compose up

Neo4j DB is running on: http://localhost:7474. The neo4j container has been created with some data. You can find some Spanish cities and the corresponding connections:
![alt text](https://ibb.co/m8tJYy6 "Optional title")
![alt text](https://ibb.co/m8tJYy6)



