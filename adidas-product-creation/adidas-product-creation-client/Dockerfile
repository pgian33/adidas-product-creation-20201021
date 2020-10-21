FROM java:8-jdk-alpine
MAINTAINER javaonfly
RUN apk --no-cache add netcat-openbsd
COPY ./target/adidas-product-creation-client-0.0.1-SNAPSHOT.jar /opt/lib/
COPY client-entrypoint.sh /opt/bin/client-entrypoint.sh
RUN chmod 755 /opt/bin/client-entrypoint.sh
EXPOSE 8084