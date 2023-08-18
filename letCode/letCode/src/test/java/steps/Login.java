package steps;

import io.cucumber.java.en.When;
import io.qameta.allure.Step;

public class Login {

    @Step("I login using valid credentials")
    @When("I login using valid credentials")
    public void iLoginUsingValidCredentials() {
        // Must call "Given I'm already registered" before calling this method
        String email = steps.Signup.getValidEmail();
        String password = steps.Signup.getValidPassword();
        new pages.Login().navigate().login(email, password);
    }

    @Step("I login using invalid email")
    @When("I login using invalid email")
    public void iLoginUsingInvalidEmail() {
        new pages.Login().navigate().loginWithInvalidEmail();
    }

    @Step("I login using incorrect credentials")
    @When("I login using incorrect credentials")
    public void iLoginUsingIncorrectCredentials() {
        new pages.Login().navigate().loginWithIncorrectCredentials();
    }

}
