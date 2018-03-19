package com.test;

import org.openqa.selenium.JavascriptExecutor;
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
	   
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   
	   String expectedTitle = "Room rental, roommate finder, off-campus housing, homestay | 4stay";
	   Assert.assertEquals(m.title().trim(), expectedTitle);
	   String expectedUrl = "https://4stay.com/";
	   Assert.assertEquals(m.actualUrl(), expectedUrl);
	  //----- 
	   js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", m.ListYourButton);
	   m.listButton();
	   String expectedTitle1 = "How to become a host | Room rental, roommate finder, off-campus housing, homestay | 4stay";
	   Assert.assertEquals(m.title().trim(), expectedTitle1);
      //----
	   js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", l2.loginbutton);
	    l2.loginbutton.click();
	    js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", l2.validEmail);
	    l2.validEmail.sendKeys(Config.getProperty("email"));
	    js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", l2.validPassword);
	    l2.validPassword.sendKeys(Config.getProperty("password"));
	    js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", l2.validLoginButton);
	     l2.validLoginButton.click();
	    
	   String expectedTitle2 = "How to become a host | Room rental, roommate finder, off-campus housing, homestay | 4stay";
	   Assert.assertEquals(l1.actualTitle().trim(), expectedTitle2);
	   //---
	   js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", l1.listYourStayButton);
	   l1.listYourStayButton.click();
	   Thread.sleep(500);
	   js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", l1.privateRoom);
	    l1.privateRoom.click();
	   //---
	    js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", l1.nextButton);
	     l1.nextButton.click();
	   String expectedProperty = "Property details";
	   Assert.assertEquals(l1.smokeProperty().trim(), expectedProperty);
	   //---
	   Thread.sleep(500);
	   js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", l1.dropDownButton);
	   l1.dropDownButton();
	   Thread.sleep(500);
	   //---
	   js.executeScript("arguments[0].setAttribute('style','background: lightgreen; border: 2px solid red;');", l1.LogOutButton);
	   l1.logOutButton();
			  
	   
			   
	 }
}
