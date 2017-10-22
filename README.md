# foosball-api
Foosball API using Spring Boot, Spring MVC, Spring Security, Spring Mongo repository, Java 8

Generate project from https://start.spring.io/

if see error, please go to maven-> update project

# java.net.ConnectException: Connection refused by mongodb-driver-core-3.4.3.jar
Please add your mongodb uri to application.properties
spring.data.mongodb.uri=mongodb://<user>:<password>@<host>:<port>/<collection>
