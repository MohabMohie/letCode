package pages;

import com.shaft.driver.SHAFT;
import engine.Driver;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Signup {
    private final SHAFT.GUI.WebDriver driver;
    private final String url = "https://letcode.in/signup";
    private final By name_input = By.id("name");
    private final By email_input = By.id("email");
    private final By password_input = By.id("pass");
    private final By agree_checkbox = By.id("agree");
    private final By signup_button = SHAFT.GUI.Locator.hasTagName("button").hasText("SIGN UP").build();


    public Signup (){
        driver = Driver.getDriver().get();
    }

    @Step("I Navigate to the Signup page")
    @When("I Navigate to the Signup page")
    public Signup navigate(){
        driver.browser().navigateToURL(url);
        return this;
    }

    @Step("I Register a new user with email \"{email}\" and password \"{email}\" ")
    @When("I Register a new user with email {string} and password {string}")
    public Home registerNewUser(String email, String password){
        driver.element().type(name_input, "Fname Lname")
                .typeSecure(password_input, password)
                .type(email_input, email)
                .click(agree_checkbox)
                .click(signup_button);
        return new Home();
    }

    public Home registerNewUser(){
        return registerNewUser("uniqueEmail_" + System.currentTimeMillis() + "@test.test", "s3cur3_p@$$w0rd");
    }
}
