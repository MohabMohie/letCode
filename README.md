# letCode Automation practice
A demo repo, to practice selenium/java/cucumber ui test automation.

## Details
This repo will use Selenium / Java to create some basic Gherkin scenarios against [https://letcode.in/](https://letcode.in/).
It will use [SHAFT](https://shafthq.github.io/) as the automation engine.
It will use [GitHub Actions](https://github.com/MohabMohie/letCode/actions) for CI/CD, and [Selenium Grid 4](https://www.selenium.dev/documentation/grid/) for remote test execution.
The objective is to demo a complete end-to-end test automation solution.

## Architecture
- The project will apply the page object model design pattern; all page-related locators, variables, and methods will exist under `src/main/java/pages`
- The project will apply the singleton driver design pattern; there will be only one driver instance that will be shared across all the scenarios using the same java thread, and it will be managed under `src/main/java/engine`
- The project will have two layers of step definitions as follows:
  1. action steps; these will exist within their respective page or engine classes.
  2. domain-specific-language steps; these will act as high-level steps and will exist under `src/test/java/steps`. These will only exist when needed to facilitate descriptive and declarative scenario design, else the action steps can be user directly.
- There will be one feature file per module and they will exist under `src/test/resources/features`
- Scenarios will be designed in a [Descriptive and Declarative style](https://cucumber.io/docs/bdd/better-gherkin/)

## Testing checklist
- Business scenarios:
  - The objective of these scenarios is to implement gherkin design best practices and re-usability

1. Register User -> `src/test/resources/features/register.feature`
2. Register User with existing email -> `src/test/resources/features/register.feature`
3. Login User with correct email and password -> `src/test/resources/features/login.feature`
4. Login User with incorrect email and password -> `src/test/resources/features/login.feature`
5. Login User with invalid email -> `src/test/resources/features/login.feature`
6. Logout User -> `src/test/resources/features/logout.feature`


- Technical demo scenarios: `src/test/resources/features/technicalDemo.feature`
  - The objective of these scenarios is to demo some technical capabilities of the SHAFT framework without focusing on best practices or re-usability
7. Element visual assertion
8. Element attribute assertion
9. Element CSS property assertion
10. Element steps

## Prerequisites
- Latest stable version from IntelliJ IDEA Community Edition.
- Latest Java 17 LTS.

## Execution
1. Import the project from Git to your IntelliJ.
2. Allow the project to finish building and fetching dependencies.
3. Run `mvn -f letCode/letCode/ clean test` to execute all the test scenarios.
   - Run `mvn -f letCode/letCode/ clean test -Dcucumber.filter.tags=@business` to execute the login and registration business scenarios.
   - Run `mvn -f letCode/letCode/ clean test -Dcucumber.filter.tags=@technical` to execute the technical scenarios.
4. You can execute the `src/test/java/TestRunner.java` class.
5. After execution is finished, the execution report will open automatically in your default browser.
6. You can run any scenario/feature from the `src/test/resources/*.feature` files. [^1] (Note: Report will not open automatically in that case.)
7. You can modify the target browser, operating system, or other properties via the `src/main/resources/properties/custom.properties` file.
8. You can reopen the execution report for the last test run by running this file `generate_allure_report` from your project root directory.

[^1]: Due to a known issue with IntelliJ you need to edit your run configuration templates before running your tests by following these steps:
<br/>- Open 'Edit Run/Debug Configurations' dialog > Edit Configurations... > Edit configuration templates...
<br/>- Select <b>Cucumber Java</b> > Program Arguments > and add this argument:
<br/>`--plugin com.shaft.listeners.CucumberFeatureListener`
<br/>- After saving the changes, remember to delete any old runs you may have triggered by mistake before adding the needed config.

## CI/CD & Cloud Device Farm Integration
This project also demonstrates its CI/CD and Cloud Device Farm integration capabilities, and its cross-platform compatibility by using GitHub Actions, Selenium Grid, and BrowserStack to run against Windows, Linux, Mac & Chrome, Edge, Safari.
- You can examine this file `.github/workflows/e2eTests.yml` for more details about the github actions pipeline.
- You can examine this file `.github/docker-compose/selenium4grid.yml` for more details about the dockerized selenium grid.
- You can navigate to [this link](https://github.com/MohabMohie/letCode/actions/workflows/e2eTests.yml) or to the Actions tab to view the latest test runs and download the test execution reports.

## Final Notes
- I hope you find this project satisfactory and informative.
- Feel free to reach-out if you need any further support or if you have collaboration opportunities.
- Here's a link to my profile [GitHub/MohabMohie](https://github.com/MohabMohie)
- Kindly note that I'm the creator and one of 35 maintainers for [SHAFT_Engine](https://github.com/shafthq/SHAFT_ENGINE); the framework used under this sample project.
- Kindly note that [SHAFT_Engine](https://github.com/shafthq/SHAFT_ENGINE) is listed as [one of 15 official selenium webdriver ecosystem frameworks](https://www.selenium.dev/ecosystem/#frameworks).