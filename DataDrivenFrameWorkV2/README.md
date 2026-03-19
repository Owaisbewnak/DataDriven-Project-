Data-Driven Testing Framework V2
A robust, scalable data-driven testing framework built with Selenium WebDriver, TestNG, and ExtentReports for automated testing of web applications. This framework is specifically designed to test the Rediff Money Portfolio Management application.

Table of Contents
Overview
Features
Project Structure
Technologies & Dependencies
Prerequisites
Installation
Configuration
Running Tests
Test Data Management
Reporting
Framework Architecture
Key Components
Best Practices
Contributing
License
Overview
This data-driven testing framework enables automated testing of web applications with a focus on separation of test data from test logic. The framework follows the Keyword-Driven approach where test actions are encapsulated as reusable keywords, making tests more maintainable and readable.

The framework is currently configured to test the Rediff Money Portfolio Management application, including features like:

User authentication (Login/Logout)
Portfolio creation and deletion
Stock management (Add, Modify, Sell stocks)
Transaction history verification
Features
Data-Driven Testing: External JSON-based test data management for multiple test scenarios
Keyword-Driven Architecture: Reusable keywords for common actions (click, type, select, etc.)
Cross-Browser Support: Supports Chrome, Firefox, and Edge browsers
Comprehensive Reporting: ExtentReports integration with screenshots on failure
Soft Assertions: Continue test execution even when assertions fail
Centralized Locators: All UI locators managed in a single properties file
Flexible Test Configuration: TestNG XML suite configuration for test execution control
Screenshot Capture: Automatic screenshot capture on test failures
Wait Mechanisms: Explicit waits and page load synchronization
Project Structure
DataDrivenFrameWorkV2/
├── src/
│ ├── main/
│ │ └── java/
│ │ ├── Keywords/
│ │ │ ├── ApplicationKeywords.java # Application-specific keywords
│ │ │ ├── GenericKeywords.java # Generic Selenium keywords
│ │ │ └── ValidationKeywords.java # Validation/assertion keywords
│ │ └── reports/
│ │ └── ExtentManager.java # ExtentReports configuration
│ │
│ └── test/
│ ├── java/
│ │ ├── listner/
│ │ │ └── MyTestNGListener.java # TestNG listener for events
│ │ ├── runner/
│ │ │ ├── DataUtil.java # Test data utility
│ │ │ ├── JSONRunner.java # JSON-based test runner
│ │ │ ├── Runner.java # Main test runner
│ │ │ └── TestNGRunner.java # TestNG-specific runner
│ │ ├── testbase/
│ │ │ └── BaseTest.java # Base test class with setup/teardown
│ │ ├── testcasesrediffPortfolio/
│ │ │ ├── ManagePortfolioTest.java # Portfolio management tests
│ │ │ ├── ManageSessionTest.java # Session/login tests
│ │ │ └── ManageStocksTest.java # Stock management tests
│ │ └── testCases/
│ │ └── CreatePortfolioTest.java # Additional portfolio tests
│ │
│ └── resources/
│ ├── Project.properties # Centralized locators & config
│ ├── PortfolioSuite.xml # Portfolio test suite
│ ├── StockManage.xml # Stock management test suite
│ ├── testng.xml # Main TestNG configuration
│ └── projectJSONs/
│ ├── testJSONData/
│ │ ├── portfolioData.json # Portfolio test data
│ │ └── stocksData.json # Stock test data
│ └── suites/
│ ├── portfoliosuite.json # Portfolio suite config
│ └── stocksuite.json # Stock suite config
│
├── Driver/ # Browser driver executables
│ ├── chromedriver.exe
│ ├── geckodriver.exe
│ ├── msedgedriver.exe
│ ├── operadriver.exe
│ └── IEDriverServer.exe
│
├── reports/ # Generated test reports
├── test-output/ # TestNG output files
└── pom.xml # Maven configuration

text


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
   ```bash
   java -version
Maven
bash

mvn -version
Web Browsers (at least one):
Google Chrome
Mozilla Firefox
Microsoft Edge
IDE (recommended):
IntelliJ IDEA
Eclipse IDE
Installation
Clone the repository:
bash

git clone https://github.com/Owaisbewnak/DataDriven-Project-.git
cd DataDriven-Project-/DataDrivenFrameWorkV2
Install Maven dependencies:
bash

mvn clean install
Update browser drivers (if needed):
Download the appropriate WebDriver for your browser version
Place it in the Driver/ directory
Configuration
Browser Configuration
Edit src/test/resources/Project.properties:

properties

# Browser Configuration
browser_name=chrome
URL=https://money.rediff.com
Supported browsers: chrome, firefox, edge

Test Data Configuration
Test data is stored in JSON files under src/test/resources/projectJSONs/testJSONData/:

portfolioData.json:

json

{
    "testdata": [
        {
            "flag": "createnewportfolio",
            "data": [
                {
                    "portfolioname": "port300",
                    "runmode": "Yes"
                }
            ]
        }
    ]
}
stocksData.json:

json

{
    "testdata": [
        {
            "flag": "addfreshstock",
            "data": [
                {
                    "portfolioname": "Portfolio30",
                    "companyName": "HDFC Bank",
                    "selectionDate": "10-12-2020",
                    "stockQuantity": "200",
                    "stockPrice": "300",
                    "runmode": "Yes"
                }
            ]
        }
    ]
}
Locator Configuration
All UI element locators are centralized in Project.properties:

properties

# Login Page Locators
signIn_linkText=Sign In
userName_id=useremail
password_xpath=//*[@id='userpass']
submitBtn_name=loginsubmit

# Portfolio Page Locators
createPortfolio_id=createPortfolio
portfolioname_id=create
portfolioid_dropdown_id=portfolioid
Running Tests
Using Maven
Run all tests:

bash

mvn test
Using TestNG XML
Run specific suite:

bash

mvn test -DsuiteXmlFile=src/test/resources/PortfolioSuite.xml
Using IDE
Right-click on testng.xml or any TestNG suite file
Select "Run As" > "TestNG Suite"
Running Specific Test Classes
bash

mvn test -Dtest=ManagePortfolioTest
Test Data Management
The framework uses JSON-based test data management with the following structure:

Run Mode Control
Each test data entry includes a runmode flag:

Yes - Test will execute
No - Test will be skipped
Data Flags
Test data is organized by flags that correspond to different test scenarios:

Flag
Description
createnewportfolio	Test data for creating new portfolios
deletenewportfolio	Test data for deleting portfolios
addfreshstock	Test data for adding new stocks
addexistingstock	Test data for adding to existing stock positions
sellexistingstock	Test data for selling stocks

Reporting
ExtentReports
The framework generates comprehensive HTML reports using ExtentReports:

Location: reports/<timestamp>/Index.html
Features:
Test execution status (Pass/Fail/Skip)
Step-by-step test logging
Screenshots on failure
Test categorization
Viewing Reports
Navigate to reports/ directory
Open any dated folder
Open Index.html in a web browser
TestNG Reports
Additional TestNG reports are generated in test-output/:

emailable-report.html - Quick email-friendly report
testng-results.xml - XML format results
Framework Architecture
Keyword-Driven Design
The framework follows a three-tier keyword architecture:

text

┌─────────────────────────────────────────────────────────────┐
│                    Test Classes                             │
│    (ManagePortfolioTest, ManageStocksTest, etc.)           │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│              ApplicationKeywords.java                       │
│         (Application-specific business keywords)            │
│   - goToBuySell()                                           │
│   - selectDateFromCalender()                                │
│   - findCurrentStockQuantity()                              │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│              ValidationKeywords.java                        │
│              (Validation keywords)                          │
│   - validateTitle()                                         │
│   - validateSelectedValueInDropDown()                       │
│   - validateElementPresent()                                │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│               GenericKeywords.java                          │
│              (Core Selenium keywords)                       │
│   - openBrowser()                                           │
│   - click()                                                 │
│   - type()                                                  │
│   - getElement()                                            │
│   - takeScreenShot()                                        │
└─────────────────────────────────────────────────────────────┘
Test Flow
text

1. BeforeTest → Initialize WebDriver, ExtentReports, Load Test Data
2. BeforeMethod → Check for critical failures
3. Test Method → Execute test using keywords
4. AfterMethod → Report assertions
5. AfterTest → Quit driver, flush reports
Key Components
BaseTest.java
The foundation class for all tests providing:

Test data loading from JSON
WebDriver initialization
Report initialization
Setup and teardown methods
GenericKeywords.java
Core Selenium wrapper methods:

openBrowser() - Initialize browser driver
click() - Click element with scroll handling
type() - Enter text in input fields
getElement() - Find element with waits
takeScreenShot() - Capture screenshot
ApplicationKeywords.java
Business-specific keywords for the Rediff Money application:

goToBuySell() - Navigate to stock buy/sell page
selectDateFromCalender() - Select date from calendar widget
findCurrentStockQuantity() - Get current stock quantity
getRowNumWithCellData() - Find row in table by cell data
ValidationKeywords.java
Assertion methods:

validateTitle() - Validate page title
validateSelectedValueInDropDown() - Verify dropdown selection
validateSelectedValueNotInDropDown() - Verify value not in dropdown
Best Practices
Keep test data separate: Modify JSON files, not test code
Use meaningful names: For test methods and data flags
Update locators centrally: Edit Project.properties only
Check runmode: Set runmode: "No" to skip tests
Review reports: Check ExtentReports after each run
Handle waits: Use explicit waits over implicit waits
Use soft assertions: Tests continue on non-critical failures
Troubleshooting
Common Issues
Issue
Solution
Browser not opening	Check browser driver version matches browser version
Element not found	Verify locator in Project.properties
Test skipped	Check runmode in test data JSON
Timeout errors	Increase wait time in keywords
Screenshot not captured	Check reports/ directory permissions

Debug Mode
Add logging in test classes:

java

app.logInfo("Debug message");
Contributing
Fork the repository
Create a feature branch (git checkout -b feature/AmazingFeature)
Commit your changes (git commit -m 'Add some AmazingFeature')
Push to the branch (git push origin feature/AmazingFeature)
Open a Pull Request
License
This project is licensed under the MIT License - see the LICENSE file for details.

Author
Owaisbewnak

GitHub: @Owaisbewnak
Acknowledgments
Selenium WebDriver documentation
TestNG documentation
ExtentReports community
All contributors and testers
