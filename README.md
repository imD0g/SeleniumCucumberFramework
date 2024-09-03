# Java Selenium Cucumber Rest Assured Framework

This framework combines Selenium WebDriver, Cucumber, and Rest Assured to provide a comprehensive testing solution for
web applications, including both UI and API testing.

## Table of Contents

1. [Features](#features)
2. [Prerequisites](#prerequisites)
3. [Project Structure](#project-structure)
4. [Setup](#setup)
6. [Running Tests](#running-tests)
7. [Reporting](#reporting)
8. [Best Practices](#best-practices)

## Features

- Web UI testing with Selenium WebDriver
- Behavior-Driven Development (BDD) with Cucumber
- API testing with Rest Assured
- Configurable test environments

## Prerequisites

- Java JDK 11 or higher
- Maven 3.6 or higher
- IDE (IntelliJ IDEA, Eclipse, or similar)
- Web browsers (Chrome, Firefox, etc.)

## Project Structure

```
src
├── main
│   ├── java
│      └── org
│          └── com
│              ├── api
│              └── frontend
│                  ├── components
│                  ├── config
│                  ├── pages
│                  └── utils
└── test
    ├── java
    │   └── org
    │       └── com
    │           └── api
    │               ├── runners
    │               └── stepdefinitions
    │           └── frontend
    │               ├── runners
    │               └── stepdefinitions
    └── resources
        └── features
            ├── api
            └── frontend
```

## Setup

1. Clone the repository:
   ```
   git clone https://github.com/imD0g/SeleniumCucumberFramework.git
   ```
2. Install dependencies:
   ```
   mvn clean install
   ```

## Running Tests

Execute tests using Maven:

```
mvn clean test
```

To run specific tags:

```
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## Reporting

HTML reports are generated in the `target/cucumber-reports` directory after test execution.

## Best Practices

- Keep step definitions small and reusable
- Use page object pattern for UI elements
- Implement proper waits and synchronization
- Use configuration files for environment-specific data
- Regularly update dependencies