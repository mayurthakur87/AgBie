package com.cucmber.AgBie;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AgBiePageSmokeTest {
	
	WebDriver driver;
	Scenario scenario;
	
	@Given("^Go to URL$")
	public void go_to_URL() throws Throwable {
	   	System.out.println("path set is");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/BROWSERS/geckodriver");
		//System.setProperty("after setting property ");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://ag-bie.oztaxa.com/");
	}

	@When("^I do search$")
	public void i_do_search() throws Throwable {
	   
	   driver.findElement(By.cssSelector("[id = 'search']")).sendKeys("acacia");
	   driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div/form/div/span/input")).click();
	}

	@Then("^should be able to visit different tabs$")
	public void should_be_able_to_visit_different_tabs() throws Throwable {
	  
	   Thread.sleep(2000);
	   Screenshot();
	   driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[2]/ol/li[1]/h3/a/span/span")).click();
	   Screenshot();
	  
	   Thread.sleep(2000);
	   driver.findElement(By.linkText("Overview")).click();
	   Screenshot();
		
	   Thread.sleep(2000);
	   driver.findElement(By.linkText("Names")).click();
	   Screenshot();
	  
	   Thread.sleep(2000);
	   driver.findElement(By.linkText("Classification")).click();
	   Screenshot();
	   
	   Thread.sleep(2000);
	   driver.findElement(By.linkText("Literature")).click();
	   Screenshot();
	   
	   Thread.sleep(2000);
	   driver.findElement(By.linkText("Sequences")).click();
	   Screenshot();
	   
	   
	   driver.close();
	}
	public int Screenshot()
	{
		System.out.println("inside screen shot");
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// String path ="C://Users//Mayur//eclipse-workspace//AgBie//ScreenShots//"+scrFile.getName();

		 String path= (System.getProperty("user.dir")+"\\ScreenShots\\"+scrFile.getName());
		System.out.println(path);
		 System.out.println( scrFile.getName());
		 try {
			FileUtils.copyFile(scrFile, new File(path));
			System.out.println("inside Try");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("inside catch");
			e.printStackTrace();
		}
		return  1;
	}
}
