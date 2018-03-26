package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.MainHomePage;
import pages.SearchPage;
import utilities.Browser;
import utilities.Config;
//Test Case 12 searchig for Los Angeles
public class SearchTest {
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
		MainHomePage mainPage = new MainHomePage(driver);
		mainPage.loginBut();
		mainPage.userLogin();
		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void searchLa() throws InterruptedException {
		MainHomePage mainPage = new MainHomePage(driver);
		mainPage.searchBox.sendKeys(Config.getProperty("city"));
		Thread.sleep(500);
		mainPage.searchBox.sendKeys(Keys.ARROW_DOWN);

		mainPage.searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		mainPage.searchBtn.click();

		Assert.assertTrue(Config.getProperty("city").contains("Los Angeles"));

	}

	@Test(priority = 3)
	public void pickChoice() throws InterruptedException {
		SearchPage la = new SearchPage(driver);

		AssertJUnit.assertEquals(Browser.getDriver().getCurrentUrl(), Config.getProperty("urlCity"));
		AssertJUnit.assertEquals(Browser.getDriver().getTitle(), Config.getProperty("titleCity"));

		Thread.sleep(1000);
		la.clickChoice();
		List<String> window = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(window.get(1));
	}

	@Test(priority = 4)
	public void choicePage() throws InterruptedException {
		SearchPage choiceP = new SearchPage(driver);
		String currentTitle = Browser.getDriver().getTitle();
		System.out.println(currentTitle);
		AssertJUnit.assertEquals(Browser.getDriver().getTitle(), Config.getProperty("titleChoice"));
		Thread.sleep(1000);
		choiceP.requestStayBtn.click();
		///
	}

}
