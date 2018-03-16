package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainHomePage {

	WebDriver driver;
	
	public MainHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText="LIST YOUR STAY")
	public WebElement ListYourButton;
	
	
	
	public String title() {
	
		String actualTitle = driver.getTitle().toString().trim();
	    return actualTitle;
	}
	
	public void listButton() {
		
		ListYourButton.click();
	}


	
}
