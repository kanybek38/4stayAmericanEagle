package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Config;

public class SignUpPage {
	
	  WebDriver driver;
		
		public SignUpPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(xpath="(//a[@href='/sign-up'])[1]")
		public WebElement signUp;

		@FindBy(xpath="//a[@href='#!/more-options']")
		public WebElement moreOptions; 
		
		
		@FindBy(xpath="//div[@class='btn email-btn w-100 m-0 mb-3']")
		public WebElement continueWithEmail; 
		
		@FindBy(id="first-name")
		public WebElement signUpFirstName;
		
		@FindBy(id="email")
		public WebElement signUpEmail; 
		
		@FindBy(id="password")
		public WebElement signUpPassword; 
		
		@FindBy(xpath="//button[@class='btn btn-primary w-100 m-0 ng-binding']")
		public WebElement signUpButton; 
		
		@FindBy(xpath="//label[@for='last-name']")
		public WebElement alertLastName; 
		
		
		public void signUp() {
			
			signUp.click();
			moreOptions.click();
			continueWithEmail.click();
			
			signUpFirstName.sendKeys(Config.getProperty("signUpFirstName"));
			signUpEmail.sendKeys(Config.getProperty("signUpEmail"));
			signUpPassword.sendKeys(Config.getProperty("signUpPassword"));
			signUpButton.click();
			
		}
		
		public String getStatusAlert() {
			
			String result=signUpFirstName.getAttribute("class").trim(); 
			return result;

		}
		
}
