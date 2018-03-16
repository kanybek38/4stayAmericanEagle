package com.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.MainHomePage;
import utilities.Browser;
import utilities.Config;

public class MainTest {

	WebDriver driver;
	
	@BeforeClass 
	public void setUp() {
		driver = Browser.getDriver();
	}
	
	@Test (priority = 1)
	public void maniPage() {
		driver.get(Config.getProperty("url"));
		MainHomePage m = new MainHomePage(driver);
		m.listButton();
	}
}
