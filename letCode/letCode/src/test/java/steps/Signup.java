package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.Getter;

public class Signup {

    @Step("I register using valid and unique data")
    @When("I register using valid and unique data")
    public void registerValidUser(){
        new pages.Signup().navigate().registerNewUser();
    }

    @Getter
    private static String validEmail;
    @Getter private static String validPassword = "secure1234@#$%";
    @Step("I'm already registered")
    @Given("I'm already registered")
    public void iMAlreadyRegistered() {
        // note that dynamic test data creation to be consumed during runtime is dangerous as it may cause a domino effect if test data preparation fails
        // it is recommended to use predefined static test data that meet the criteria of the scenario where applicable
        validEmail = "alreadyExistingEmail_" + System.currentTimeMillis() + "@test.test";
        new pages.Signup().navigate().registerNewUser(validEmail, validPassword).signOut();
    }

    @Step("I register using already existing data")
    @When("I register using already existing data")
    public void registerAlreadyExistingUser(){
        new pages.Signup().navigate().registerNewUser(validEmail, validPassword);
    }
}
