package com.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.MainHomePage;
import utilities.Browser;
import utilities.Config;

//Test Case 13 click on DashBoard link and verify 
public class DashBoardTest {
	WebDriver driver;

	@BeforeMethod
	@BeforeClass
	public void setUp() {
		driver = Browser.getDriver();
	}

	@AfterMethod
	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	@Test(priority = 1)
	public void listYourLogin() throws InterruptedException {
		driver.get(Config.getProperty("url"));
		MainHomePage mainPage1 = new MainHomePage(driver);
		mainPage1.loginBut();
		mainPage1.userLogin();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void clickDashoBoardL() {
		MainHomePage mainPage1 = new MainHomePage(driver);
		mainPage1.dashBoardLink.click();

		AssertJUnit.assertEquals(Browser.getDriver().getCurrentUrl(), Config.getProperty("urlDashBoard"));
		String currentTitleDash = Browser.getDriver().getTitle();
		System.out.println(currentTitleDash);
		AssertJUnit.assertEquals(Browser.getDriver().getTitle(), Config.getProperty("titleDashBoard"));
		AssertJUnit.assertTrue(Config.getProperty("userName").contains("John"));
///
	}
}
