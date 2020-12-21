package com.appium.stepdefinitions;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
	features = "src/test/resources/",
	plugin = 	{
					"pretty",
			        "html:target/cucumber",
					"json:target/cucumber.json"
				}
)
public class RunCukeTest {
}
