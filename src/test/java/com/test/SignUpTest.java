package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.MainHomePage;
import pages.SignUpPage;
import utilities.Browser;
import utilities.Config;

public class SignUpTest {
	

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = Browser.getDriver();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}
	
	@Test (priority = 1)
	public void listYourLogin() {
		driver.get(Config.getProperty("url"));
		
		SignUpPage signUpPage=new SignUpPage(driver); 
	
		 signUpPage.signUp(); 
		 
		 Assert.assertEquals(signUpPage.getStatusAlert(), "active");
		
	}

}
