# Cucumber-Demo

This repository contains a demo project that demonstrates the usage of Cucumber with Java, Selenium, TestNG, Maven, and Extent Report. Execution reports can seen at [Extent Report](https://pritamsaha92.github.io/Cucumber-Demo/extent)  & [Cucumber Report](https://pritamsaha92.github.io/Cucumber-Demo/cucumber) hosted on Github Pages 🚀.

## Table of Contents

- [Introduction](#introduction)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Running the Tests](#running-the-tests)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This repository serves as a demo project to showcase the integration of Cucumber with Java, Selenium, TestNG, Maven, and Extent Report. The project provides an example of how to write and execute automated tests using the Cucumber BDD framework along with other popular technologies.

## Technologies Used

- Java
- Selenium
- TestNG
- Maven
- Cucumber
- Extent Report

## Installation

To get started with the Cucumber-Demo project, follow these steps:

1. Clone this repository to your local machine using the following command:

   ```bash
   git clone https://github.com/pritamsaha92/Cucumber-Demo.git
   ```

2. Navigate to the project directory:

   ```bash
   cd Cucumber-Demo
   ```

3. Install the required dependencies using Maven:

   ```bash
   mvn install
   ```

## Running the Tests

You can run the tests using Maven commands. Here are the available commands:

- Run tests in local:

  ```bash
  mvn test -Psmoketests -Drunenv=local
  ```

- Run tests in headless chrome:

  ```bash
  mvn test -Psmoketests -Drunenv=ci --no-transfer-progress
  ```

- Generate and view the Reports:

  After executing the tests, the Extent & Cucumber Report will be generated automatically. You can find the report in the following location:

  ```
  /reports/extent/index.html
  ```
  ```
  /reports/extent/index.html
  ```

## Project Tree
```
├── config.properties
├── data.properties
├── pom.xml
├── readme.md
├── reports
│   ├── cucumber
│   │   └── index.html
│   └── extent
│       └── index.html
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── vitamojo
│   │               └── framework
│   │                   ├── API.java
│   │                   ├── APIModel.java
│   │                   ├── Base.java
│   │                   ├── Element.java
│   │                   └── WebWait.java
│   └── test
│       ├── java
│       │   └── com
│       │       └── vitamojo
│       │           ├── pages
│       │           │   ├── APIs.java
│       │           │   ├── AuthPOM.java
│       │           │   ├── CommonPOM.java
│       │           │   └── LandingPOM.java
│       │           ├── runner
│       │           │   └── CucumberRunner.java
│       │           └── stepdefs
│       │               ├── APITest.java
│       │               ├── Hooks.java
│       │               ├── Landing.java
│       │               ├── Login.java
│       │               └── Registration.java
│       └── resources
│           ├── cucumber.properties
│           ├── extent.properties
│           └── features
│               ├── APITest.feature
│               ├── Login.feature
│               └── Registration.feature
└── testng.xml
```

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please feel free to submit a pull request or open an issue in this repository.

## License

The Cucumber-Demo project is licensed under the [MIT License](LICENSE).