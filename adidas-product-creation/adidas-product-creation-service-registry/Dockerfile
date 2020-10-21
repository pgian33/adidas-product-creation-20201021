FROM java:8-jdk-alpine
MAINTAINER javaonfly
COPY ./target/adidas-product-creation-service-registry-0.0.1-SNAPSHOT.jar /opt/lib/
ENTRYPOINT ["usr/bin/java"]
CMD ["-jar", "/opt/lib/adidas-product-creation-service-registry-0.0.1-SNAPSHOT.jar"]
EXPOSE 8761