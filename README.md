# Java Selenium TestNG Automation Framework

Framework generated for:

- Language: Java
- Build tool: Maven
- UI automation: Selenium WebDriver
- Test runner: TestNG
- Design pattern: Page Object Model
- Browsers: Chrome, Firefox, Edge
- CI/CD: GitHub Actions
- Reporting: Allure
- API testing: REST Assured
- Base URL: https://www.letskodeit.com

## Folder structure

```text
letskodeit-java-selenium-testng-framework
├── .github
│   └── workflows
│       └── tests.yml
├── src
│   └── test
│       ├── java
│       │   └── com
│       │       └── letskodeit
│       │           ├── base
│       │           │   └── BaseTest.java
│       │           ├── config
│       │           │   └── ConfigReader.java
│       │           ├── driver
│       │           │   ├── DriverFactory.java
│       │           │   └── DriverManager.java
│       │           ├── listeners
│       │           │   └── TestListener.java
│       │           ├── pages
│       │           │   ├── BasePage.java
│       │           │   ├── HomePage.java
│       │           │   └── LoginPage.java
│       │           └── tests
│       │               ├── api
│       │               │   └── ApiHealthTest.java
│       │               └── ui
│       │                   └── HomePageTest.java
│       └── resources
│           ├── allure.properties
│           └── config.properties
├── pom.xml
├── testng.xml
├── .gitignore
└── README.md
```

## What each part does

`pages` contains Page Object Model classes. Each page class stores page locators and user actions.

`tests` contains TestNG test classes. Tests should be readable and should call page methods instead of directly using Selenium everywhere.

`driver` creates and stores WebDriver instances. It uses ThreadLocal so parallel browser execution is safer.

`listeners` captures screenshots automatically when UI tests fail.

`config.properties` stores values like base URL, browser, headless mode, and timeout.

`testng.xml` controls which tests run and which browsers are used.

`.github/workflows/tests.yml` runs tests automatically in GitHub Actions.

## Prerequisites

Install these before running the framework:

1. Java JDK 17 or newer
2. Maven 3.9 or newer
3. IntelliJ IDEA, Eclipse, or VS Code
4. Chrome, Firefox, and Edge installed locally
5. Optional: Allure command line, if you want to serve reports locally

Check your installation:

```bash
java -version
mvn -version
```

## How to open in an IDE

### IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Select **Open**.
3. Choose this project folder.
4. IntelliJ should detect `pom.xml`.
5. Click **Load Maven Project** if prompted.

### VS Code

Install these extensions:

- Extension Pack for Java
- Maven for Java

Then open the project folder.

## How to run tests

Run all tests from terminal:

```bash
mvn clean test
```

Run in headless mode:

```bash
mvn clean test -Dheadless=true
```

Run with a different base URL:

```bash
mvn clean test -DbaseUrl=https://www.letskodeit.com
```

Run one browser only by editing `testng.xml`, or run from Maven with the default browser:

```bash
mvn clean test -Dbrowser=chrome
```

## How to generate Allure report

After running tests:

```bash
mvn allure:report
```

The static report is generated here:

```text
target/site/allure-maven-plugin/index.html
```

If you have Allure CLI installed, you can also run:

```bash
allure serve target/allure-results
```

## How to add a new UI test

1. Create or update a page class under `src/test/java/com/letskodeit/pages`.
2. Add locators and reusable actions.
3. Create a test under `src/test/java/com/letskodeit/tests/ui`.
4. Add the test class to `testng.xml`.

Example idea:

```java
@Test
public void shouldOpenLoginPage() {
    HomePage homePage = new HomePage();
    LoginPage loginPage = homePage.clickLogin();

    Assert.assertTrue(loginPage.isDisplayed());
}
```

## How to add a new API test

Create a class under:

```text
src/test/java/com/letskodeit/tests/api
```

Use REST Assured:

```java
given()
    .relaxedHTTPSValidation()
.when()
    .get("/")
.then()
    .statusCode(lessThan(500));
```

## GitHub Actions

When this project is pushed to GitHub, the workflow in `.github/workflows/tests.yml` will run on:

- push to main/master
- pull request to main/master
- manual workflow dispatch

It runs tests in headless mode and uploads the Allure report as a workflow artifact.

## Beginner notes

Selenium controls the browser.

TestNG organizes and runs your tests.

Page Object Model keeps Selenium locators away from the test logic. This makes tests easier to read and maintain.

Maven downloads dependencies and runs the project.

Allure turns raw test results into readable reports.

REST Assured tests APIs without opening a browser.
