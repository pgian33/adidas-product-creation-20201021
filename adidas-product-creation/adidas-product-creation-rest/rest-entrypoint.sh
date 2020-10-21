#!/bin/sh
while ! nc -z discovery-eureka 8761 ; do
    echo "Waiting for the Eureka Server"
    sleep 3
done
​
java -jar /opt/lib/adidas-product-creation-rest-0.0.1-SNAPSHOT.jar
