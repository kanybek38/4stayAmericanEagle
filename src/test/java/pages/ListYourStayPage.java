package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Config;

public class ListYourStayPage {
	//
    WebDriver driver;
	
	public ListYourStayPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@id='first_name']")
	public WebElement firstName;
	
	@FindBy (xpath = "//input[@id='last_name']")
	public WebElement lastName;
	
	@FindBy (xpath = "//input[@id='email']")
	public WebElement email;
	
	@FindBy (xpath = "//input[@id='password']")
	public WebElement  password;
	
	@FindBy (xpath = "//input[@id='phone']")
	public WebElement  phone;
	
	@FindBy (xpath = "//label[@class='checkbox i-minus-checks']/i")
	public WebElement acceptCheckButton;
	
	@FindBy (xpath = "//input[@value='Create account']")
	public WebElement creatAccountButton;
	
	@FindBy (linkText = "Email has already been taken")
	public WebElement error;
	
	public String title() {
		
		String actualTitle = driver.getTitle().toString().trim();
	    return actualTitle;
	}
	
	public String err() {
		String result = error.toString().trim();
		result = result.substring(55, result.length()-1);
		return result;
	}
	
	
	public void sendYourInfo() {
		firstName.sendKeys(Config.getProperty("firstName"));
		lastName.sendKeys(Config.getProperty("lastName"));
		email.sendKeys(Config.getProperty("email"));
		password.sendKeys(Config.getProperty("password"));
		phone.sendKeys(Config.getProperty("phone"));
	}
	
	public void select() {
		acceptCheckButton.click();
		acceptCheckButton.isSelected();
		
	}
	
	public void clickB() {
		creatAccountButton.click();
	}
	
	

}
