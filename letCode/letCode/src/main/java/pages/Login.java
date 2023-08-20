package pages;

import com.shaft.driver.SHAFT;
import engine.Driver;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Login {

    private final SHAFT.GUI.WebDriver driver;
    private final String url = "https://letcode.in/signin";
    private final By email_input = By.name("email");
    private final By password_input = By.name("password");
    private final By login_button = SHAFT.GUI.Locator.hasTagName("button").hasText("LOGIN").build();

    public Login (){
        driver = Driver.getDriver().get();
    }

    @Step("I Navigate to the Login page")
    @When("I Navigate to the Login page")
    public Login navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("I Login with email \"{email}\", and password \"{email}\"")
    @When("I Login with email {string}, and password {string}")
    public Home login(String email, String password){
        driver.element().type(email_input, email)
                .typeSecure(password_input, password)
                .click(login_button);
        return new Home();
    }

    @Step("I Login with invalid email")
    @When("I Login with invalid email")
    public Home loginWithInvalidEmail(){
        return login("invalid", "invalid");
    }

    @Step("I Login with incorrect credentials")
    @When("I Login with incorrect credentials")
    public Home loginWithIncorrectCredentials() {
        return login("invalid@email.com", "invalid");
    }
}
