package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.ListYourStayPage;
import pages.MainHomePage;
import utilities.Browser;
import utilities.Config;

public class CreatAccoundNegativeTest {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = Browser.getDriver();
	}

	@AfterClass
	public void tearDown() {
	   driver.quit();
	}

	@Test(priority = 1)
	public void mainPage() {
		driver.get(Config.getProperty("url"));
		MainHomePage m = new MainHomePage(driver);
		// this for title
		String exceptedTitle = "Room rental, roommate finder, off-campus housing, homestay | 4stay";
		Assert.assertEquals(m.title().trim(), exceptedTitle);
		// this is for click button
		m.listButton();
	}

	@Test(priority = 2)
	public void ListPage() {
		ListYourStayPage l = new ListYourStayPage(driver);
		String exceptedTitle = "How to become a host | Room rental, roommate finder, off-campus housing, homestay | 4stay";
		Assert.assertEquals(l.title().trim(), exceptedTitle);
		l.sendYourInfo();
	}

	@Test(priority = 3)
	public void select() {
		ListYourStayPage l = new ListYourStayPage(driver);
		l.select();
		l.clickB();
	}
	
	@Test (priority = 4)
	public void errorsNegative() {
		String exceptedError = "Email has already been taken";
		ListYourStayPage l = new ListYourStayPage(driver);
		System.out.println(l.err());
		Assert.assertEquals(l.err(), exceptedError);
	}
}
