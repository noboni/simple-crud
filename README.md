# Spring Boot Simple Rest Apis
### Pre-requisites
* Java SE Development Kit 8
### Steps to Set up
* Clone the application using the following command: 
```
git clone https://github.com/noboni/simple-crud.git
```
### Getting Started
#### Explore Rest APIs
Listing the APIs below that I have created:

| Method | Url | Decription | 
| ------ | --- | ---------- |
| POST   | localhost:8080/student | Create a student | 
| GET   |  localhost:8080/student/all | Get all students | 
| GET   |  localhost:8080/student/id/{id} | Get student by id | 
| GET   |  localhost:8080/student/name/{name} | Get all students by name |
| PUT   |  localhost:8080/student/{id} | Update student by id |
| DELETE   | localhost:8080/student/id/{id} | Delete student by id | 
| DELETE   |  localhost:8080/student/name/{name} | Delete all students by name |

#### Run the application locally
* Open a terminal in the project directory and execute the following command: 
```
./gradlew bootrun
```

#### Deploy in any server
* Set up a machine for deployment and make sure java 8 is installed there
* Run the following command in the project directory
```
./gradlew clean build
```
* In the build/libs directory a jar file will be created named simple-0.0.1.jar
* Put the jar file in the deployment machine and run the following command
```
java -jar simple-0.0.1.jar &
```

