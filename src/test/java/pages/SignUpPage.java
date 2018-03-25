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
		
		@FindBy(xpath="//input[@id='last-name']")
		public WebElement signUpLastName;
		
		@FindBy(id="email")
		public WebElement signUpEmail; 
		
		@FindBy(id="password")
		public WebElement signUpPassword; 
		
		@FindBy(xpath="//button[@class='btn btn-primary w-100 m-0 ng-binding']")
		public WebElement signUpButton; 
		
		@FindBy(xpath="//label[@for='last-name']")
		public WebElement alertLastName; 
		
		@FindBy(xpath="//h5[@class='text-center mb-4']")
		public WebElement TextIWanttoBecome;
		
		@FindBy(xpath="//a[@ng-click='vm.next()']")
		public WebElement signUpNextButton;
		
		@FindBy(xpath="//textarea[@ng-model='vm.user.about_me']")
		public WebElement tellUsAboutYourself;
		
		@FindBy(xpath="//input[@ng-model='vm.user.dob_year']")
		public WebElement yearOfBirth;
		
		@FindBy(xpath="//button[@ng-bind-html='vm.buttonLabel']")
		public WebElement signUpSaveButton;
		
		
		
		
		
		
		
		
		
		
		
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
			
			String result=alertLastName.getAttribute("class").trim(); 
			return result;

		}
		
		public void signUpRegNumericName()  {
			signUp.click();

			moreOptions.click();	

			continueWithEmail.click();

			
			signUpFirstName.sendKeys(Config.getProperty("signUpNumericFirstName"));

			signUpLastName.sendKeys(Config.getProperty("signUpNumericFirstName"));
			
			signUpEmail.sendKeys(Config.getProperty("signUpEmail"));
			signUpPassword.sendKeys(Config.getProperty("signUpPassword"));

			signUpButton.click();
			
		}
		
		public void signUpRegPositive() {
			
			signUp.click();

			moreOptions.click();	

			continueWithEmail.click();

			
			signUpFirstName.sendKeys(Config.getProperty("signUpRegPositiveFirstName"));

			signUpLastName.sendKeys(Config.getProperty("signUpRegPositiveLastName"));
			
			signUpEmail.sendKeys(Config.getProperty("signUpRegPositiveEmail"));
			signUpPassword.sendKeys(Config.getProperty("signUpPassword"));

			signUpButton.click();
			
			signUpNextButton.click();
			
			tellUsAboutYourself.sendKeys(Config.getProperty("tellUsAboutYourself"));
			
			yearOfBirth.sendKeys(Config.getProperty("yearOfBirth"));
			
			signUpSaveButton.click();
		}
		
}
