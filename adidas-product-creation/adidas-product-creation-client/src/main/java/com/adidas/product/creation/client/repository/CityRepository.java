package com.adidas.product.creation.client.repository;

import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import com.adidas.product.creation.client.entity.City;
import com.adidas.product.creation.client.exception.Neo4jQueryException;

@Repository
public interface CityRepository extends Neo4jRepository<City, Long>  {
    
    @Query(""
    		+ "MATCH (departureCity:City {name: $name1}),(destinationCity:City {name: $name2}), p = shortestPath((departureCity)-[CONNECTED_TO*]->(destinationCity))\n"
    		+ "RETURN p")
    List<City> getConnetionShortestPath(String name1, String name2) throws Neo4jQueryException;
    
    @Query(""
    		+ "MATCH p=(departureCity:City {name: $name1})-[r:CONNECTED_TO*]->(destinationCity:City{name: $name2})\n"
    		+ "RETURN p as shortestPath,\n"
    		+ "REDUCE(time=0, r in relationships(p) | time+(duration.between(r.departureTime, r.arrivalTime)).seconds) AS totalTime "
    		+ "ORDER BY totalTime ASC\n"
    		+ "LIMIT 1")
    List<City> getTimeShortestPath(String name1, String name2) throws Neo4jQueryException;
}
