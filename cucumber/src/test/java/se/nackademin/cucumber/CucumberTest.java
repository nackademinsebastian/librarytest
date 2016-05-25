package se.nackademin.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"junit:target/reports/junit/junit.xml", "html:target/reports/html", "json:target/reports/report.json"})
public class CucumberTest {
}
