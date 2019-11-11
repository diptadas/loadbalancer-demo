# Load Balancer Demo

## Server side LB: Nginx

### Build docker image

```
$ docker build -t diptadas/server .
```

### Run docker image

```
$ docker run -it -p 8090:8080 -e NAME=server-1 diptadas/server
$ docker run -it -p 8070:8080 -e NAME=server-2 diptadas/server
```
