package com.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.MainHomePage;
import pages.SignUpPage;
import utilities.Browser;
import utilities.Config;

public class SignUpTest {
	

	WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = Browser.getDriver();
	}

	@AfterTest
	public void tearDown() {
		 driver.quit();
	}
	
	//@Test (priority = 1)
	public void signUpNegative1() {
		driver.get(Config.getProperty("url"));
		
		SignUpPage signUpPage=new SignUpPage(driver); 
	
		 signUpPage.signUp(); 
		 
		 Assert.assertEquals(signUpPage.getStatusAlert(), "active");
		
	}
	
	//@Test(priority = 2)
	public void signUpNegative4() {
	driver.get(Config.getProperty("url"));
	SignUpPage signUpPage=new SignUpPage(driver); 
	signUpPage.signUpRegNumericName();
	Assert.assertTrue(signUpPage.TextIWanttoBecome.isDisplayed());
		
	}
	
	@Test(priority = 3)
	public void signUpPositive5() {
	driver.get(Config.getProperty("url"));
	SignUpPage signUpPage=new SignUpPage(driver); 
	signUpPage.signUpRegPositive();
	
	String expectedtitle=driver.getTitle(); 
	
	
	System.out.println(driver.getTitle()); 
	
	Assert.assertEquals(driver.getTitle(), expectedtitle);
		
	}
	
	
	
	
	

}
