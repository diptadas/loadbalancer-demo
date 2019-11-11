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

### Nginx With SSL

```
$ openssl genrsa -des3 -out server.key 2048 // create private key

$ openssl rsa -in server.key -out server.key // remove passphrase

$ openssl x509 -req -days 365 -in server.csr -signkey server.key -out server.crt // generate self signed certificate
```

## Client Side LB: Ribbon

### Spring boot demo server and client (with Ribbon) 

```
$ cd ribbon-demo
$ mvn clean install

// run server
$ cd demo-server
$ java -jar -Dserver.port=8070 target/demo-server-0.0.1-SNAPSHOT.jar
$ java -jar -Dserver.port=8090 target/demo-server-0.0.1-SNAPSHOT.jar

// run client
$ cd ../demo-client
$ java -jar target/demo-client-0.0.1-SNAPSHOT.jar
```
