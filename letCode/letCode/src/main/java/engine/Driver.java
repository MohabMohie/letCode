package engine;

import com.shaft.driver.SHAFT;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.qameta.allure.Step;
import lombok.Getter;

public class Driver {
    // driver singleton instance to facilitate state-sharing and optimize resource allocation
    // Note: this may interfere with project-level parallel execution
    @Getter private static ThreadLocal<SHAFT.GUI.WebDriver> driver;

    @Step("The target browser is ready")
    @Given("The target browser is ready")
    public void openBrowser(){
        if (driver == null){
            driver = new ThreadLocal<>();
            driver.set(SHAFT.GUI.WebDriver.getInstance());
        }
    }
}
