# Currency Converter

Currency Converter provides an API to convert between two currencies using updated conversion rates from an external service.

API documentation can be accessed locally in [here](http://localhost:9037/currency-converter/swagger-ui.html), 
or on Heroku in [here](https://app-currency-convert.herokuapp.com/currency-converter/swagger-ui.html)

## Installation

This is a Spring Boot app built using Maven. This project is compiled inside a docker container.

### Prerequisites

* Git
* Docker
* Docker-compose 
* If not using the docker, set the environment variable: ACCESS_KEY=cc1c93359bcca52446be37373d083018

### Run

Use the following commands to run an application:

		git clone https://github.com/andreia23/currency-converter
		cd currency-converter
		docker-compose up -d

Before starting to use, make sure the container is working.

## Use

You can use this API by importing a <a href="https://www.postman.com/">Postman</a> collection located in the directory /src/main/webapp/tests.

![Captura de tela de 2021-10-22 00-43-32](https://user-images.githubusercontent.com/44982439/138390520-e0a46260-e1ee-4c65-b6cf-76059e39654d.png)


## Tests

The tests with JUnit are in /src/test/java/controller

## Interacting with the API

Interaction with the API can be done through the Swagger interface.

## Features

Register a user: [https://app-currency-convert.herokuapp.com/currency-converter/swagger-ui.html#/user-controller/registerUserUsingPOST](https://app-currency-convert.herokuapp.com/currency-converter/swagger-ui.html#/user-controller/registerUserUsingPOST)

Conversion between currencies: [https://app-currency-convert.herokuapp.com/currency-converter/swagger-ui.html#/conversion-controller/convertCurrencyUsingPOST](https://app-currency-convert.herokuapp.com/currency-converter/swagger-ui.html#/conversion-controller/convertCurrencyUsingPOST)

Get transactions from a user by id: [https://app-currency-convert.herokuapp.com/currency-converter/swagger-ui.html#/transaction-controller/transactionsByUserUsingGET](https://app-currency-convert.herokuapp.com/currency-converter/swagger-ui.html#/transaction-controller/transactionsByUserUsingGET)

Get all transactions: [https://app-currency-convert.herokuapp.com/currency-converter/swagger-ui.html#/transaction-controller/findAllUsingGET](https://app-currency-convert.herokuapp.com/currency-converter/swagger-ui.html#/transaction-controller/findAllUsingGET)

## Implementation

Currency Converter has been separated into four layers: `model`, `controller`, `service` and `repository`

Java, Spring Boot, Maven and Docker technologies were chosen because they are highly used in the market and also because they are the ones that the developer has more experience.

The technology used for lint configuration was [SonarLint](https://www.sonarlint.org/)
