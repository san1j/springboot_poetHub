# PoetHub
A SpringBoot web app for sharing poems

## Link to the project website
[Live Website](https://poethub.herokuapp.com)

## Config
You can change the port number as well as the username and password
in the src/main/resources/application.properties file

## How to Run
Clone/ download this repo

Use any of the following ways to run the app

### Maven wrapper:
Build the jar file:
```
$ scripts/mvnw clean package
```
run it:
```
$ java -jar target/poetHub-0.0.1-SNAPSHOT.jar
```
 
### Using maven:
Before running, check if you have maven installed:
```
$ mvn -v
```
and then
```
$ mvn clean package
```
then run the app:
```
$ java -jar target/poetHub-0.0.1-SNAPSHOT.jar
```

After running the app, point your browser to [https://localhost:8080](https://localhost:8080)

Use the following username and password to login:

username: anonymous

password: password

## License:
MIT
