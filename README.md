# Adidas Product Creation Challenge

This Java project has been implemented using:
 - Maven as project management and comprehension tool 
 - Spring Boot has been used to build the application
 - Each Spring boot application has been built and packaged as a Docker Microservice
 - Neo4J has been used as Graph NoSQL database 
 - An "adidas-product-creation-service-registry" microservice as Eureka Service Registry
 - An "adidas-product-creation-client" microservice that deals with querying Neo4J NoSQL
 - An "adidas-product-creation-rest" microservice that is the entry point of the application.
 - On http://localhost:8761/ you can find the Eureka Service Registry and you can check when the microservices are ready

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

Neo4j DB is running on: http://localhost:7474. The neo4j container has been created with some data. You can find some Spanish cities and the corresponding connections as you can
see in the following picture:![alt text](https://i.postimg.cc/VkcpCxNX/graph-1.png)

*Each relationship has the the arrivalTime and the departureTime as a relationship property.*

You can connect to http://localhost:7474 and run the following query that returns all nodes and relationships:
> MATCH(N) RETURN (N) 

You can also try to add new connections among cities. 
In this case, you can use the following statement:

CREATE (Pamplona)-[:CONNECTED_TO { departureTime: time({hour:15, minute:00, second:00}), arrivalTime:time({hour:21, minute:10, second:00}) }]->(Bilbao)

*Besides in the file called 'cypher_query.cql' you can find the create statements that are executed on the microservices startup.*

# REST

You can find the Swagger on the following endpoint: http://localhost:8080/swagger-ui.html#/shortest-path-controller

There are two different methods you can run:
- connections-shortest-path -> shortest path based on the number of connections
- time-shortest-path -> shortest path based on the duration 

Both of them can be called using a POST. Here is the payload you need to set in your request:
```
    {
      "departureCity": "string",
      "destinationCity": "string"
    }'
```
As response you will have the following:
```
{
    "shortestPathCitiesMap": {
        "1": "city1",
        "2": "city2",
        "3": "city3
    },
    "shortesPathRepresentation": "city1->city2->city3"
}
```
Examples:

```
curl --location --request POST 'http://localhost:8080/connections-shortest-path' \
--header 'Content-Type: application/json' \
--data-raw '{
  "departureCity": "Zaragoza",
  "destinationCity": "Barcelona"
}'

{
    "shortestPathCitiesMap": {
        "1": "Zaragoza",
        "2": "Barcelona"
    },
    "shortesPathRepresentation": "Zaragoza->Barcelona"
}

```

```
curl --location --request POST 'http://localhost:8080/time-shortest-path' \
--header 'Content-Type: application/json' \
--data-raw '{
  "departureCity": "Zaragoza",
  "destinationCity": "Barcelona"
}'

{
    "shortestPathCitiesMap": {
        "1": "Zaragoza",
        "2": "Tarragona",
        "3": "Barcelona"
    },
    "shortesPathRepresentation": "Zaragoza->Tarragona->Barcelona"
}
```


NOTE: Consider the following image during your tests:
![alt text](https://i.postimg.cc/VkcpCxNX/graph-1.png)

To check the duration to go from a city to another you can connect to Neo4j on http://localhost:7474 and run:
> MATCH(N) RETURN N
 On each relationship you will be able to see the arrivalTime and the departureTime:
![alt text](https://i.postimg.cc/SKvQGS3n/cattututut.png)








