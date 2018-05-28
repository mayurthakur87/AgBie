package com.cucmber.AgBie;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAfter {

	public static String URL= "https://ag-bie.oztaxa.com/";
	
	@Before
	public void Initialise(Scenario scenario) {
		
		System.out.println("---------GLOBAL TEST ENVIRONMENT---------");
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\BROWSERS\\geckodriver.exe");

	}
	@After
	public void GlobalTestTearDown(Scenario scenario) {

		System.out.println("----GLOBAL TEST ENVIRONMENT TEARDOWN-----");

	}
}
