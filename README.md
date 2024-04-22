# CyberCube QA Task
Here's the QA task. Unfortunately, I didn't have time do it on its entirety since it's a long task and as I'm on holidays, traveling back and forth. I tried to make it useful and simple.
There is some rough edges around reports and stuff, I know. Again, I didn't have proper time and place to address everything.

This project is using: Java 17, JUnit 5, Cucumber 7, RestAssured, Selenide (amazing API built on top of Selenium, which has improved selectors, other features that Selenium has, like built-in waits and an embedded WebDriver: https://selenide.org/documentation.html). I also use Allure Reports for reporting.

## Instructions

1. Clone the project and wait for the dependencies to download
2. Run on terminal:
   ```mvn clean install```
   to run all of the tests
4. Since I used Cucumber, you also have the option to filter the execution by the tags ```@api and @ui```, you can execute the command ```mvn test -D"cucumber.filter.tags=@api"``` or ```mvn test -D"cucumber.filter.tags=@ui"``` to run the API test or the UI test respectively.
5. The WebDriver will open automatically from Selenide and execute the tests.
6. There will be tests failing due to the usage of different users for Sauce Labs and the bugs in Sauce Labs itself.
7. Once the execution is done, you can check the ```target/cucumber-report/cucumber.html``` for pretty html cucumber reports, or ```mvn allure:serve``` to check Allure reports (they are a bit weird on how the examples and tests are looking, but it still could use some edge round-up).

8. Thank you.
