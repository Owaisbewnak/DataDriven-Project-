# Data-Driven Testing Framework V2

A robust, scalable data-driven testing framework built with Selenium WebDriver, TestNG, and ExtentReports for automated testing of web applications. This framework is specifically designed to test the Rediff Money Portfolio Management application.

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Technologies & Dependencies](#technologies--dependencies)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running Tests](#running-tests)
- [Test Data Management](#test-data-management)
- [Reporting](#reporting)
- [Framework Architecture](#framework-architecture)
- [Key Components](#key-components)
- [Best Practices](#best-practices)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

This data-driven testing framework enables automated testing of web applications with a focus on separation of test data from test logic. The framework follows the Keyword-Driven approach where test actions are encapsulated as reusable keywords, making tests more maintainable and readable.

The framework is currently configured to test the **Rediff Money Portfolio Management** application, including features like:

- User authentication (Login/Logout)
- Portfolio creation and deletion
- Stock management (Add, Modify, Sell stocks)
- Transaction history verification

---

## Features

- **Data-Driven Testing**: External JSON-based test data management for multiple test scenarios
- **Keyword-Driven Architecture**: Reusable keywords for common actions (click, type, select, etc.)
- **Cross-Browser Support**: Supports Chrome, Firefox, and Edge browsers
- **Comprehensive Reporting**: ExtentReports integration with screenshots on failure
- **Soft Assertions**: Continue test execution even when assertions fail
- **Centralized Locators**: All UI locators managed in a single properties file
- **Flexible Test Configuration**: TestNG XML suite configuration for test execution control
- **Screenshot Capture**: Automatic screenshot capture on test failures
- **Wait Mechanisms**: Explicit waits and page load synchronization

---

## Project Structure

```
DataDrivenFrameWorkV2/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Keywords/
│   │       │   ├── ApplicationKeywords.java
│   │       │   ├── GenericKeywords.java
│   │       │   └── ValidationKeywords.java
│   │       └── reports/
│   │           └── ExtentManager.java
│   │
│   └── test/
│       ├── java/
│       │   ├── listner/
│       │   │   └── MyTestNGListener.java
│       │   ├── runner/
│       │   │   ├── DataUtil.java
│       │   │   ├── JSONRunner.java
│       │   │   ├── Runner.java
│       │   │   └── TestNGRunner.java
│       │   ├── testbase/
│       │   │   └── BaseTest.java
│       │   └── testcasesrediffPortfolio/
│       │       ├── ManagePortfolioTest.java
│       │       ├── ManageSessionTest.java
│       │       └── ManageStocksTest.java
│       │
│       └── resources/
│           ├── Project.properties
│           ├── PortfolioSuite.xml
│           ├── StockManage.xml
│           ├── testng.xml
│           └── projectJSONs/
│               ├── testJSONData/
│               │   ├── portfolioData.json
│               │   └── stocksData.json
│               └── suites/
│                   ├── portfoliosuite.json
│                   └── stocksuite.json
│
├── Driver/
│   ├── chromedriver.exe
│   ├── geckodriver.exe
│   └── msedgedriver.exe
│
├── reports/
├── test-output/
└── pom.xml
```

---

## Technologies & Dependencies

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 11+ | Programming language |
| Selenium WebDriver | 4.35.0 | Browser automation |
| TestNG | 7.11.0 | Test framework |
| ExtentReports | 5.1.2 | HTML reporting |
| JSON-Simple | 1.1.1 | JSON parsing |
| Commons-IO | 2.20.0 | File utilities |
| Maven | - | Build & dependency management |

---

## Prerequisites

Before running this project, ensure you have the following installed:

1. **Java Development Kit (JDK) 11 or higher**
2. **Maven**
3. **Web Browsers** (Chrome, Firefox, or Edge)
4. **IDE** (IntelliJ IDEA or Eclipse)

---

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Owaisbewnak/DataDriven-Project-.git
   cd DataDriven-Project-/DataDrivenFrameWorkV2
   ```

2. Install Maven dependencies:
   ```bash
   mvn clean install
   ```

3. Update browser drivers if needed

---

## Configuration

### Browser Configuration

Edit `src/test/resources/Project.properties`:

```properties
browser_name=chrome
URL=https://money.rediff.com
```

### Test Data Configuration

Test data is stored in JSON files under `src/test/resources/projectJSONs/testJSONData/`

### Locator Configuration

All UI element locators are centralized in `Project.properties`

---

## Running Tests

### Using Maven

```bash
mvn test
```

### Using IDE

1. Right-click on `testng.xml`
2. Select "Run As" > "TestNG Suite"

---

## Test Data Management

### Run Mode Control

- `Yes` - Test will execute
- `No` - Test will be skipped

### Data Flags

| Flag | Description |
|------|-------------|
| `createnewportfolio` | Test data for creating new portfolios |
| `deletenewportfolio` | Test data for deleting portfolios |
| `addfreshstock` | Test data for adding new stocks |
| `sellexistingstock` | Test data for selling stocks |

---

## Reporting

The framework generates HTML reports using ExtentReports at `reports/<timestamp>/Index.html`

---

## Framework Architecture

### Keyword-Driven Design

```
Test Classes
     │
     ▼
ApplicationKeywords.java (Business keywords)
     │
     ▼
ValidationKeywords.java (Validation keywords)
     │
     ▼
GenericKeywords.java (Core Selenium keywords)
```

---

## Key Components

| Component | Description |
|-----------|-------------|
| BaseTest.java | Foundation class with setup/teardown |
| GenericKeywords.java | Core Selenium wrapper methods |
| ApplicationKeywords.java | Business-specific keywords |
| ValidationKeywords.java | Assertion methods |

---

## Best Practices

1. Keep test data separate in JSON files
2. Use meaningful names for test methods
3. Update locators in `Project.properties` only
4. Check ExtentReports after each run
5. Use soft assertions for non-critical failures

---

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Open a Pull Request

---

## License

This project is licensed under the MIT License.

---

## Author

**Owaisbewnak**

GitHub: [@Owaisbewnak](https://github.com/Owaisbewnak)
