package com.cucmber.AgBie;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AgBiePageSmokeTest {

	WebDriver driver;
	Scenario scenario;
	String URL = BeforeAfter.URL;

	@Before("@Smoke")
	public void Setup(Scenario scenario) {

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//BROWSERS//geckodriver");

		/*------------------------COMMON------------------------------*/
		System.out.println("---------------------------------------");
		System.out.println("--------Test Environment Setup---------");
		this.scenario = scenario;
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/*------------------------------------------------------------*/

	}

	@After("@Smoke")
	public void teardown(Scenario scenario) throws IOException {

		scenario.write("Finished Scenario " + scenario.getName());
		if (scenario.isFailed()) {
			// take ScreenShot
			{
				System.out.println("------Test has Failed---");
				final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png"); // stick it in the report
				System.out.println("inside Report");
			}
		}
		System.out.println("--------Test Environment Closed--------");
		System.out.println("---------------------------------------");

		driver.close();
		// driver.quit();
	}

	@Given("^Go to URL$")
	public void go_to_URL() throws Throwable {

		driver.get(URL);
	}

	@When("^I do search$")
	public void i_do_search() throws Throwable {

		driver.findElement(By.cssSelector("[id = 'search']")).sendKeys("acacia");
		driver.findElement(By.cssSelector("[type ='submit']")).click();
		Thread.sleep(2000);

	}

	@When("^select a record$")
	public void select_a_record() throws Throwable {

		Thread.sleep(2000);
		// driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[2]/ol/li[1]/h3/a/span/span")).click();
		driver.findElement(By.cssSelector("[class='scientific-name rank-genus']")).click();

	}

	@Then("^should be able to visit Overview tab$")
	public void should_be_able_to_visit_Overview_tab() throws Throwable {

		Thread.sleep(2000);
		driver.findElement(By.linkText("Overview")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Overview")).isDisplayed());
	}

	@Then("^should be able to visit Names tab$")
	public void should_be_able_to_visit_Names_tab() throws Throwable {

		Thread.sleep(2000);
		driver.findElement(By.linkText("Names")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Names")).isDisplayed());
	}

	@Then("^should be able to visit Classification tab$")
	public void should_be_able_to_visit_Classification_tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Classification")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Classification")).isDisplayed());
	}

	@Then("^should be able to visit Literarture tab$")
	public void should_be_able_to_visit_Literarture_tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Literature")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Literature")).isDisplayed());
	}

	@Then("^should be able to visit Sequences tab$")
	public void should_be_able_to_visit_Sequences_tab() throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sequences")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Sequences")).isDisplayed());
	}

	@Then("^Refine search on Species$")
	public void refine_search_on_Species() throws Throwable {
		Thread.sleep(2000);
		System.out.println("inside species ");
		driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[1]/ul/li[1]/a")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[1]/ul/li/a/span"))
						.isDisplayed());
		driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[1]/ul/li/a/span")).click();

	}

	/*----------------------------------------------*/

	@Then("^Refine search on Common Name$")
	public void refine_search_on_Common_Name() throws Throwable {
		Thread.sleep(2000);
		System.out.println("inside Common Name ");
		Assert.assertTrue(
				driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[1]/ul/li[2]/a"))
						.isDisplayed());
		driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[1]/ul/li[2]/a")).click();
		// Screenshot(driver)
		driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div/ul/li/a/span")).click();

	}

	@Then("^Refine search on TaxonStatus Accepted$")
	public void refine_search_on_TaxonStatus_Accepted() throws Throwable {

		Thread.sleep(2000);
		System.out.println("inside TaxonStatus Accepted ");
		Assert.assertTrue(
				driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[4]/ul/li[1]/a"))
						.isDisplayed());
		driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[4]/ul/li[1]/a")).click();
		// Screenshot(driver);

		driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[1]/ul/li/a/span")).click();

	}

	@Then("^Refine search on TaxonStatus Synonym$")
	public void refine_search_on_TaxonStatus_Synonym() throws Throwable {

		Thread.sleep(2000);
		System.out.println("inside TaxonStatus Synonym");
		Assert.assertTrue(
				driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[4]/ul/li[2]/a"))
						.isDisplayed());
		driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[4]/ul/li[2]/a")).click();
		// Screenshot(driver);

		driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[1]/div/div/div[1]/ul/li/a/span")).click();

	}

}
