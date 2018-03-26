package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Config;

public class LoginPage {
	//
    WebDriver driver;
	
	public LoginPage(WebDriver driver) {
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
	
	@FindBy (xpath = "(//a[@href='#login-modal'])[1]")
	public WebElement loginbutton;
	
	@FindBy (xpath = "//div[@class='col-12']//input[@placeholder='Email address']")
	public WebElement validEmail;
	
	@FindBy (xpath = "//div[@class='col-12']//input[@placeholder='Password']")
	public WebElement validPassword;
	
	@FindBy (xpath = "//a[@id='login_btn']")
	public WebElement validLoginButton;
	
	@FindBy (xpath ="//div[@id='login_status']")
	public WebElement errorMessage;
	
	@FindBy(id="user_email")
	public WebElement loginEmail; 
	
	@FindBy(id="user_password")
	public WebElement loginPassword; 
	
	@FindBy(id="login_btn")
	public WebElement negativeLoginButton;
	
	@FindBy(id="login_status")
	public WebElement loginStatus; 
	
	@FindBy(xpath="//a[@data-toggle='modal']")
	public WebElement NegativePasswordLoginButton;
	
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
	
	public void loginButton() {
		loginbutton.click();
		validEmail.sendKeys(Config.getProperty("email"));
		validPassword.sendKeys(Config.getProperty("password"));
		validLoginButton.click();
	}
	
	public void loginButtonNegative() {
		loginbutton.click();
		validEmail.sendKeys(Config.getProperty("email"));
		validLoginButton.click();
	}
	
	public String errMessage() {
		String result = errorMessage.getText().trim();
		return result;
	}
	
	public void negativePasswordLogin() {
		
		NegativePasswordLoginButton.click();
		
		loginEmail.sendKeys(Config.getProperty("email"));
		
		loginPassword.sendKeys(Config.getProperty("wrongPassword"));
		
		negativeLoginButton.click();
		
		
		
	}
	public void  negativeEmailLogin() {
		NegativePasswordLoginButton.click();
		loginEmail.sendKeys(Config.getProperty("wrongEmail"));
		loginPassword.sendKeys(Config.getProperty("password"));
		negativeLoginButton.click();
		
		
	}
	
	

}
