package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ListYourStayPage;
import pages.LoginPage;
import pages.MainHomePage;
import utilities.Browser;
import utilities.Config;

public class Smoke { 
	
	 WebDriver driver;
	 
	 @BeforeClass
		public void setUp() {
			driver = Browser.getDriver();
		}

		@AfterClass
		public void tearDown() {
			// driver.quit();
		}
	 
	 @Test 
	 public void smokeTest() throws InterruptedException {
	   ListYourStayPage l1 = new ListYourStayPage(driver);
	   LoginPage l2 = new LoginPage(driver);
	   MainHomePage m = new MainHomePage(driver);
	   
	   
	   driver.get(Config.getProperty("url"));
	   String expectedTitle = "Room rental, roommate finder, off-campus housing, homestay | 4stay";
	   Assert.assertEquals(m.title().trim(), expectedTitle);
	   String expectedUrl = "https://4stay.com/";
	   Assert.assertEquals(m.actualUrl(), expectedUrl);
	  //----- 
	   m.listButton();
	   String expectedTitle1 = "How to become a host | Room rental, roommate finder, off-campus housing, homestay | 4stay";
	   Assert.assertEquals(m.title().trim(), expectedTitle1);
      //----
	   l2.loginButton();
	   String expectedTitle2 = "How to become a host | Room rental, roommate finder, off-campus housing, homestay | 4stay";
	   Assert.assertEquals(l1.actualTitle().trim(), expectedTitle2);
	   //---
	   l1.smokeListYourStayButton();
	   Thread.sleep(500);
	   l1.smokePrivateButton();
	   //---
	   l1.smokeNextButton();
	   String expectedProperty = "Property details";
	   Assert.assertEquals(l1.smokeProperty().trim(), expectedProperty);
	   //---
	   Thread.sleep(500);
	   l1.dropDownButton();
	   Thread.sleep(500);
	   //---
	   l1.logOutButton();
			  
	   
			   
	 }
}
