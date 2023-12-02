# SeleniumWeb_TestNg_Allure
This demo represents a simplified framework for testing a website using the Selenium WebDriver, TestNG, and Allure frameworks. The project includes examples:

1. Including different types of waiters (for the visibility or presence of an element) and asserts.
2. Passing data to DataProvider from an Excel Sheet in TestNG.
3. Executing TestNG test cases using a TestNG XML file and controlling the order of execution via attributes of the Test annotation.
4. Applying the Page Object Model pattern for the framework architecture.

**Before start**

You need to install Allure Report utility.

Selenium and TestNG dependencies has already added to the project pom file.

**Start**

Run all tests

```$ mvn clean test ```

Run a set of test from several test classes

```mvn test '-Dtest=SearchCarTest,CalculatePaymentTest'```

**After tests**
If you want to see the test report locally:

```$ allure serve ./target/allure-results```

If you want just generate the test report without web service run:

```$ allure generate --clean target/allure-results```

Go to src/allure-report folder and click index.html


**Report**

Allure is a top-notch test report framework, known for its excellent support across languages and test runners, easy to integrate to the almost any CI.

A sample of the Allure report:


