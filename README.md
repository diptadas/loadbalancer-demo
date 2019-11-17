# Load Balancer Demo

## Server Side LB: Nginx

### Spring boot demo server

```
$ cd nginx-demo/demo-server
$ mvn clean install
$ java -jar -Dserver.port=8070 target/demo-server-0.0.1-SNAPSHOT.jar
$ java -jar -Dserver.port=8090 target/demo-server-0.0.1-SNAPSHOT.jar
```

### Run nginx in foreground

```
$ cd nginx-demo/nginx-config
$ nginx -p . -c nginx.conf

// test
$ curl localhost:8020
```

### Configure nginx with SSL

```
$ cd nginx-demo/nginx-config

// create private key
$ openssl genrsa -des3 -out server.key 2048

// remove passphrase
$ openssl rsa -in server.key -out server.key

// generate self signed certificate
$ openssl x509 -req -days 365 -in server.csr -signkey server.key -out server.crt
```

## Client Side LB: Ribbon

### Spring boot demo server and client (with Ribbon) 

```
$ cd ribbon-demo
$ mvn clean install

// run servers
$ cd demo-server
$ java -jar -Dserver.port=8070 target/demo-server-0.0.1-SNAPSHOT.jar
$ java -jar -Dserver.port=8090 target/demo-server-0.0.1-SNAPSHOT.jar

// run client
$ cd demo-client
$ java -jar target/demo-client-0.0.1-SNAPSHOT.jar

// test
$ curl localhost:8020
```

### Ribbon with Eureka

```
$ cd ribbon-eureka-demo
$ mvn clean install

// run service registry
$ cd demo-discovery
$ java -jar target/demo-discovery-0.0.1-SNAPSHOT.jar

// run servers
$ cd demo-server
$ java -jar -Dserver.port=8070 target/demo-server-0.0.1-SNAPSHOT.jar
$ java -jar -Dserver.port=8090 target/demo-server-0.0.1-SNAPSHOT.jar

// run client
$ cd demo-client
$ java -jar target/demo-client-0.0.1-SNAPSHOT.jar

// test
$ curl localhost:8020
```
