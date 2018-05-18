package com.cucmber.AgBie;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { 
		 "classpath:AgBiePageSmokeTest.feature"
		
}, 
					tags = { "@All" }, 
					plugin = { "pretty:target/cucumber-html-report", 
								"html:target/cucumber-htmlreport",
								"json:target/cucumber.json", 
								"junit:target/cucumber-results.xml" })
public class RunnerTest {

}
