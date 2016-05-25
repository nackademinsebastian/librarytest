package se.nackademin.cucumber;

import static com.codeborne.selenide.Selenide.open;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class CucumberTestBase {

    @Before
    public void setup() {
        open("http://localhost:8080/librarytest");
    }

    @After
    public void tearDown(Scenario scenario) {
        sleep(1000);
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}
