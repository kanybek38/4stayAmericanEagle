package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class Browser {
static WebDriver driver;
	
	public static WebDriver getDriver() {
		if(driver == null || ((RemoteWebDriver)driver).getSessionId()==null) {
		String browser = Config.getProperty("browser");
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	           break;
		case "fireFox":
			
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}else {
		return driver;
	}
	}
}
