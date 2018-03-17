package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Config;

public class MainHomePage {

	WebDriver driver;
	
	public MainHomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText="LIST YOUR STAY")
	public WebElement ListYourButton;
	
	@FindBy (xpath = "//a[@href='#login-modal']")
	public WebElement loginButton;
	
	@FindBy (xpath = "//input[@id='user_email']")
	public WebElement userEmail;
	
	@FindBy (xpath = "//input[@id='user_password']")
	public WebElement userPassword;
	
	@FindBy (xpath = "//a[@id='login_btn']")
	public WebElement userLoginButton; 
	
	@FindBy (xpath = "//li[@class='list']/a" )
	public WebElement secondListYourStay;
	
	public String title() {
	
		String actualTitle = driver.getTitle().toString().trim();
	    return actualTitle;
	}
	
	public void listButton() {
		
		ListYourButton.click();
	}
  
	public void loginBut() {
		loginButton.click();
	}
    
	public void userLogin() {
		userEmail.sendKeys(Config.getProperty("email"));
		userPassword.sendKeys(Config.getProperty("password"));
		userLoginButton.click();
	}
	
	public void secondListYourStay() {
		secondListYourStay.click();
	}
	
}
