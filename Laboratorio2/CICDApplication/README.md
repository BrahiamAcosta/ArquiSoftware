# Implementation of a Simple App with the next operations:

[![CI/CD Pipeline](https://github.com/BrahiamAcosta/ArquiSoftware/actions/workflows/build.yml/badge.svg)](https://github.com/BrahiamAcosta/ArquiSoftware/actions/workflows/build.yml)

* Get random nations
* Get random currencies
* Get random Aircraft
* Get application version
* health check
Including integration with GitHub Actions, Sonarqube (SonarCloud), Coveralls and
Snyk
### Folders Structure
In the folder `src` is located the main code of the app
In the folder `test` is located the unit tests
### How to install it
Execute:
```shell
$ mvnw spring-boot:run
```
to download the node dependencies
### How to test it
Execute:
```shell
$ mvnw clean install
```
### How to get coverage test
Execute:
```shell
$ mvnw -B package -DskipTests --file pom.xml
```
