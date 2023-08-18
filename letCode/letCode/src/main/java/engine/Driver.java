package engine;

import com.shaft.driver.SHAFT;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import lombok.Getter;

public class Driver {
    // driver singleton instance to facilitate state-sharing and optimize resource allocation
    // Note: this may interfere with project-level parallel execution
    private static ThreadLocal<SHAFT.GUI.WebDriver> driver;

    @Step("I Open the target browser")
    @Given("I Open the target browser")
    public static SHAFT.GUI.WebDriver get(){
        if (driver == null){
            driver = new ThreadLocal<>();
            driver.set(SHAFT.GUI.WebDriver.getInstance());
        }
        return driver.get();
    }

    @Step("I Close the target browser")
    @When("I Close the target browser")
    public void i_close_the_target_browser() {
        Driver.get().quit();
    }
}
