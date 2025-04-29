# spring-transaction Application

## Requirements

- [Docker](https://www.docker.com/)

## Test on Docker

### Build docker image

```
setup-docker.sh
```

### Start docker for Derby database
```
docker run --rm -p 9443:9443 -p 9080:9080 spring-transaction
```
Now you can access to http://localhost:9080/spring.transaction/transaction
