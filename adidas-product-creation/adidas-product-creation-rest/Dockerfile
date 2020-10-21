FROM java:8-jdk-alpine
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY ./target/adidas-product-creation-rest-0.0.1-SNAPSHOT.jar /opt/lib/
COPY rest-entrypoint.sh /opt/bin/rest-entrypoint.sh
RUN chmod 755 /opt/bin/rest-entrypoint.sh
EXPOSE 8080