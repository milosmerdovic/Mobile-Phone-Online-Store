# Spring Boot Mobile Phone Web Shop App

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [How To Run](#how-to-run)

## General info

* This is a demo project for practicing Spring + Thymeleaf. The idea was to build some basic shopping cart web app.
Users can shop for products. Each user has his own shopping cart (session functionality). Checkout is transactional, users are anonymous.

## Technologies
* It was made using **Spring Boot**, **Spring Security**, **Thymeleaf**, **Spring Data JPA**, **Hibernate**, **Spring Data REST** and **Bootstrap** for style. Database is **MySQL**.

## How To Run
* Once the app starts, go to the web browser and visit `http://localhost:8080/` , `http://localhost:8080/home` or `http://localhost:8080/index`

#### **MAVEN**
* Open a terminal and run the following commands to ensure that you have valid versions of Java and Maven installed:
````
$ java -version
openjdk version "11.0.11" 2021-04-20
OpenJDK Runtime Environment (build 11.0.11+9-Ubuntu-0ubuntu2.20.04)
OpenJDK 64-Bit Server VM (build 11.0.11+9-Ubuntu-0ubuntu2.20.04, mixed mode, sharing)
````
````
$ mvn -v
Apache Maven 3.6.3
Maven home: /usr/share/maven
Java version: 11.0.11, vendor: Ubuntu, runtime: /usr/lib/jvm/java-11-openjdk-amd64
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "5.4.0-74-generic", arch: "amd64", family: "unix"
````
#### **Using the maven plugin**
* The Spring Boot Maven plugin includes a run goal that can be used to quickly compile and run your application. Applications run in an exploded form, as they do in your IDE. The following example shows a typical Maven command to run a Spring Boot application:
`$ mvn spring-boot:run`

In `/src/main/resources/application.properties` file it is possible to change datasource url as well as port, username and password if it is included.
