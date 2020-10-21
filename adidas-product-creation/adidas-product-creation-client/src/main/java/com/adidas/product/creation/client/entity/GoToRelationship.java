package com.adidas.product.creation.client.entity;

import java.time.OffsetTime;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.Transient;

@RelationshipEntity(type = "GO_TO")
public class GoToRelationship {
	
    @Id
    @GeneratedValue
    private Long id;
    @Transient
    private OffsetTime arrivalTime;
    @Transient
    private OffsetTime departureTime;
    
    @StartNode
    private City city;

    @EndNode
    private City destinationCity;

	public OffsetTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(OffsetTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public OffsetTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(OffsetTime departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoToRelationship [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (arrivalTime != null) {
			builder.append("arrivalTime=");
			builder.append(arrivalTime);
			builder.append(", ");
		}
		if (departureTime != null) {
			builder.append("departureTime=");
			builder.append(departureTime);
			builder.append(", ");
		}
		if (city != null) {
			builder.append("city=");
			builder.append(city);
			builder.append(", ");
		}
		if (destinationCity != null) {
			builder.append("destinationCity=");
			builder.append(destinationCity);
		}
		builder.append("]");
		return builder.toString();
	}
}
