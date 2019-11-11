# Load Balancer Demo

## Server side LB: Nginx

### Spring Boot Demo Server

```
$ mvn clean install
$ java -jar -Dserver.port=8070 target/demo-server-0.0.1-SNAPSHOT.jar
$ java -jar -Dserver.port=8090 target/demo-server-0.0.1-SNAPSHOT.jar
```

### Run nginx in foreground

```
$ nginx -p . -c nginx.conf
```
