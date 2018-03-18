package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.MainHomePage;
import pages.ListYourStayPage;
import utilities.Browser;
import utilities.Config;

public class LoginigTest {
	//
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = Browser.getDriver();
	}

	@AfterClass
	public void tearDown() {
		// driver.quit();
	}

	@Test(priority = 1)
	public void mainPage() throws InterruptedException {
		driver.get(Config.getProperty("url"));
		MainHomePage m = new MainHomePage(driver);
		// this for title
		String exceptedTitle = "Room rental, roommate finder, off-campus housing, homestay | 4stay";
		Assert.assertEquals(m.title().trim(), exceptedTitle);
		// this is for click button
		m.loginBut();
		//this is for login info and click
		m.userLogin();
		// we need to go listYourStay again
		Thread.sleep(2000);
		m.secondListYourStay();
	}
	
	@Test(priority=2)
	public void listYourStay() throws InterruptedException {
		ListYourStayPage stayPage=new ListYourStayPage(driver); 
	
		stayPage.listYourStay();
		
	}


}
