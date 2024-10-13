# CSOB Test

## Run Application
`mvn spring-boot:run`

## Test Application
`curl -X 'GET' \
  'http://localhost:8080/interests-of-users?interests=reading&interests=programming' \
  -H 'accept: */*'`

## API Documentation
[OpenAPI](http://localhost:8080/swagger-ui/index.html)