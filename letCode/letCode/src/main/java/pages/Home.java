package pages;

import com.shaft.driver.SHAFT;
import engine.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Home {
    private final SHAFT.GUI.WebDriver driver;
    private String url = "https://letcode.in/";
    private final By alert_div = By.xpath("//div[@role='alertdialog']");
    private final By closeAlert_button = SHAFT.GUI.Locator.hasTagName("button").hasAttribute("aria-label", "Close").build();
    private final By signOut_button = SHAFT.GUI.Locator.hasTagName("a").hasText("Sign out").build();

    public Home (){
        driver = Driver.get();
    }

    @Step("I Navigate Home")
    @When("I Navigate Home")
    public Home navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("I am logged in successfully")
    @Then("I am logged in successfully")
    public Home validateSuccessfulLogin(){
        return validateAlertText("(Welcome) .*|(You have logged in).*");
    }

    @Step("I get the error message \"{errorMessage}\"")
    @Then("I get the error message {string}")
    public Home iGetTheErrorMessage(String errorMessage) {
        return validateAlertText(errorMessage);
    }

    @Step("I validate the alert to contain the text \"{expectedText}\"")
    @Then("I validate the alert to contain the text {string}")
    private Home validateAlertText(String expectedText){
        driver.element().assertThat(alert_div).text().matchesRegex(expectedText)
                .withCustomReportMessage("Assert the alert to match the regex \""+expectedText+"\"").perform();
        closeAlertIfOpen();
        return this;
    }

    @Step("I Sign out")
    @When("I Sign out")
    public Home signOut(){
        closeAlertIfOpen();
        driver.element().click(signOut_button);
        return this;
    }

    @Step("I am logged out successfully")
    @Then("I am logged out successfully")
    public Home iAmLoggedOutSuccessfully() {
        return validateAlertText("Bye! See you soon :)");
    }

    public Home closeAlertIfOpen(){
        if (driver.getDriver().findElements(closeAlert_button).size() > 1) {
            driver.element().click(closeAlert_button);
        }
        return this;
    }
}