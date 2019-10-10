package Cucumber.Day02;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Cucumber.Day02.UtilityClass;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import Cucumber.Day02.Pages;


public class LoginTest {
	WebDriver driver;
	@Given("^user not logged in$")
	public void user_not_logged_in() throws Throwable {
		driver = UtilityClass.startBrowser("chrome", "http://newtours.demoaut.com/");
	}

	@When("^user performs login using credentials$")
	public void do_login() throws Throwable {
		Pages page= new Pages(driver);
		page.do_login("tutorial", "tutorial");
	
	}

	@Then("^logged in Successfully$")
	public void logged_in_Successfully() throws Throwable {
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tripType")));
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		System.out.println("Logged in Successfully !!");
		//driver.close();

	}



}


