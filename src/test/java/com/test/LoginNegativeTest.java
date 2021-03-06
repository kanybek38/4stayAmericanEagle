package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MainHomePage;
import utilities.Browser;
import utilities.Config;

public class LoginNegativeTest {
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
		MainHomePage m = new MainHomePage(driver);
		// this for title
				String expectedTitle = "Room rental, roommate finder, off-campus housing, homestay | 4stay";
				Assert.assertEquals(m.title().trim(), expectedTitle);
		m.listButton();
	}
	
	@Test (priority = 2)
	public void listYourLogin2() throws InterruptedException {
		
		LoginPage m = new LoginPage(driver);
		// this for title
				String expectedTitle = "How to become a host | Room rental, roommate finder, off-campus housing, homestay | 4stay";
				Assert.assertEquals(m.title().trim(), expectedTitle);
		m.loginButtonNegative();
		Thread.sleep(500);
		String expected = "Invalid email or password. Please try again.";
		Assert.assertEquals(m.errMessage(), expected);
		
		
	}
}
