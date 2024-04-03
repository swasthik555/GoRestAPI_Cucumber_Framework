package api.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features",
					glue = "api.stepdefinition",
					plugin = {"pretty", "html:target/cucumber-reports/reports.html",
							"pretty","json:target/cucumber-reports/Cucumber.json",
							"pretty","junit:target/cucumber-reports/Cucumber.xml",
							"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
					tags="@test")

public class Runner {

}
