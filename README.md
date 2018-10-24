# PoetHub
A SpringBoot web app for sharing poems

## Link to the project website
[Live Website](https://poethub.herokuapp.com)

## Project pics
<img src ="https://user-images.githubusercontent.com/36819928/44752163-3ac62980-aae8-11e8-9456-d8bb1db55ec8.png" width="250">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<img  src="https://user-images.githubusercontent.com/36819928/44752519-3c442180-aae9-11e8-9cef-d2810c961f4c.png" width="250">

<img  src="https://user-images.githubusercontent.com/36819928/44752402-e0799880-aae8-11e8-9971-9a071b91a4ab.png" width="800">

<img src = "https://user-images.githubusercontent.com/36819928/44752785-166b4c80-aaea-11e8-8143-5ca81a8b816e.png" width="800">

## Config
You can change the port number as well as the username and password
in the src/main/resources/application.properties file

## How to Run
* Clone/ download this repo

* Follow the instructions [here](https://developers.google.com/identity/sign-in/web/sign-in) to get a client ID 

* Add your client ID and client secret to the application.properties file

* Use any of the following ways to run the app

### Maven wrapper:
Build the jar file:
```
$ ./mvnw clean install
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
$ mvn clean install
```
then run the app:
```
$ java -jar target/poetHub-0.0.1-SNAPSHOT.jar
```

After running the app, point your browser to [https://localhost:8080](https://localhost:8080)

Use the following username and password to login:&nbsp;

username: anonymous

password: password

## License:
MIT
