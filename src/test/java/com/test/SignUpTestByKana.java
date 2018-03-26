package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.SignUpPage;
import utilities.Browser;
import utilities.Config;

public class SignUpTestByKana {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		driver = Browser.getDriver();
	}

	@AfterTest
	public void tearDown() {
		 driver.quit();
	}
	
	 @Test (priority = 1)
		public void signUpNegative1()  {
			driver.get(Config.getProperty("url"));
			
			SignUpPage signUpPage=new SignUpPage(driver); 
		
			 signUpPage.signUpKana1(); 
			 
			 Assert.assertEquals(signUpPage.getStatusAlert(), "active");
			 Assert.assertEquals(signUpPage.actualTitle(), "Sign Up - Room rental, roommate finder, off-campus housing, homestay | 4stay");
			 
		}
	 
	 @Test (priority = 2)
		public void signUpNegative2() {
			driver.get(Config.getProperty("url"));
			
			SignUpPage signUpPage=new SignUpPage(driver); 
		
			 signUpPage.signUpKana2(); 
			 
			 Assert.assertEquals(signUpPage.getStatusAlert(), "active");
			 Assert.assertEquals(signUpPage.actualTitle(), "Sign Up - Room rental, roommate finder, off-campus housing, homestay | 4stay");
			 
		}
	 

}
