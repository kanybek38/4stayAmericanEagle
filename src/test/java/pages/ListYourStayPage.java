package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Config;

//
public class ListYourStayPage {
     WebDriver driver;
    
	
	public ListYourStayPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[@href='/dashboard/home']")
	public WebElement dashboardButton;
	
	@FindBy (xpath = "//a[@href='/dashboard/stays/new']")
	public WebElement listYourStayButton;
	
	@FindBy (xpath = "//div[@class='icon private-room']")
	public WebElement privateRoom;
	
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	public WebElement nextButton;
	
	@FindBy (xpath = "//div[@class='icon apartment']")
	public WebElement apartmentLink;
	
	@FindBy (xpath = "//div[@class='icon female']")
	public WebElement femaleLink;
	
	@FindBy (xpath = "//label[@for='furnished']")
	public WebElement furnishedCheckBox;
	
	@FindBy (xpath = "//label[@for='balcony']")
	public WebElement balconyCheckBox;
	
	@FindBy (xpath = "//label[@for='dishwasher']")
	public WebElement dishwasherCheckBox;
	
	@FindBy (xpath = "(//div[@class='col-12 form-group']//input)[1]")
	public WebElement AddressLine1;
	
	@FindBy(xpath="(//div[@class='col-12 form-group']//input)[3]")
	public WebElement AddressLine2; 
	
	@FindBy(xpath="(//div[@class='icon bath-private'])[2]")
	public WebElement privateBathroom; 
	
	@FindBy(xpath="//label[@for='room_king_bed']")
	public WebElement kingBedCheckBox; 
	
	@FindBy(xpath="//label[@for='room_hangers']")
	public WebElement hangerCheckBox; 

	@FindBy(xpath="//label[@for='room_balcony']")
	public WebElement roomBalconyCheckBox; 
	
	@FindBy(xpath="(//div[@class='col-12 form-group']//input)[4]")
	public WebElement mainStayTitle; 
	
	
	@FindBy(xpath="//div[@class='col-12 form-group']//textarea")
	public WebElement mainStayDescription; 
	
	
	@FindBy(xpath="(//div[@class='row form-group']//div)[1]")
	public WebElement availableDateFrom; 
	
	@FindBy(xpath="//table[@class='table-condensed']//tbody[1]//tr[5]//td[.='29']")
	public WebElement march29; 
	
	
	@FindBy(xpath="(//div[@class='row form-group']//div)[2]")
	public WebElement availableDateTo;
	
	@FindBy(xpath="(//table[@class='table-condensed']//tbody//tr[5]//td[.='31'])[2]")
	public WebElement march31; 
	
	@FindBy(xpath="//input[@max='100000']")
	public WebElement pricePerMonth;
	
	
	@FindBy(xpath="//input[@max='500']")
	public WebElement securityDeposit;
	
	@FindBy(xpath="	//button[@class='btn btn-primary ng-binding']")
	public WebElement saveButton;
	

	@FindBy(xpath="//button[@class='btn btn-outline-primary']")
	public WebElement seeWhatYouMissedButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger']//li[.='Define price for your stay']")
	public WebElement errorSign1; 
	
	@FindBy(xpath="//div[@class='alert alert-danger']//li[.='Define deposit amount for your stay']")
	public WebElement errorSign2;
	
	@FindBy(xpath="//div[@class='card-header']//label[.='Property details']")
	public WebElement propertyDetails;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	public WebElement dropDownButton;
	
	@FindBy(xpath="//ul[@class='dropdown-menu animated fadeInRight']//li[3]")
	public WebElement LogOutButton;
	
	
	public String actualTitle() {
		String result = driver.getTitle().trim();
		return result;
	}
	
	
public static void sendKeyAddressLine(WebElement element, String str) {
	
	element.sendKeys(str);
		
		Select select=new Select(element);
		
		
		
		select.selectByIndex(1);
	
	}


public void listYourStay() throws InterruptedException {
	
	Thread.sleep(500);
	dashboardButton.click();
	Thread.sleep(500);
	listYourStayButton.click();
	Thread.sleep(500);
	privateRoom.click();
	Thread.sleep(500);
	nextButton.click();
	Thread.sleep(500);
	apartmentLink.click();
	Thread.sleep(500);
	femaleLink.click();
	Thread.sleep(500);
	nextButton.click();
	Thread.sleep(500);
	furnishedCheckBox.click();
	Thread.sleep(500);
	balconyCheckBox.click();
	Thread.sleep(500);
	dishwasherCheckBox.click();
	Thread.sleep(500);
	nextButton.click();		
	Thread.sleep(2000);
	//AddressLine1.click();
	
	

	AddressLine1.sendKeys(Config.getProperty("addressLine1"));
	Thread.sleep(500);

	AddressLine1.sendKeys(Keys.ARROW_DOWN);	
	Thread.sleep(500);

	AddressLine1.sendKeys(Keys.ENTER	);	

	
	Thread.sleep(500);
		//AddressLine2.click();



	AddressLine2.sendKeys(Config.getProperty("addressLine1"));
	Thread.sleep(500);

	AddressLine2.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(500);

	AddressLine2.sendKeys(Keys.ENTER	);	

	
	Thread.sleep(500);

	nextButton.click();
	Thread.sleep(500);

	privateBathroom.click();
	Thread.sleep(500);

	nextButton.click();
	Thread.sleep(500);

	kingBedCheckBox.click();
	Thread.sleep(500);

	hangerCheckBox.click();
	Thread.sleep(500);

	roomBalconyCheckBox.click();
	Thread.sleep(500);

	nextButton.click();
	Thread.sleep(500);

	mainStayTitle.sendKeys("Female only");
	Thread.sleep(500);

	mainStayDescription.sendKeys("Accept only female");
	Thread.sleep(500);

	availableDateFrom.click();
	Thread.sleep(1000);

	march29.click();
	Thread.sleep(1000);

	availableDateTo.click();
	Thread.sleep(1000);

	march31.click();
	Thread.sleep(1000);

	nextButton.click();
	Thread.sleep(500);

	pricePerMonth.sendKeys("100");
	Thread.sleep(500);

	securityDeposit.sendKeys("100");
	Thread.sleep(500);

	saveButton.click();
	
}

public void listYourStayNegative() throws InterruptedException {
	
	Thread.sleep(500);
	dashboardButton.click();
	Thread.sleep(500);
	listYourStayButton.click();
	Thread.sleep(500);
	privateRoom.click();
	Thread.sleep(500);
	nextButton.click();

	Thread.sleep(500);
	nextButton.click();
	Thread.sleep(500);

	nextButton.click();		
	

	Thread.sleep(500);
	nextButton.click();
	Thread.sleep(500);



	nextButton.click();
	Thread.sleep(500);


	nextButton.click();
	Thread.sleep(500);


	nextButton.click();
	Thread.sleep(500);


	seeWhatYouMissedButton.click();
	
}

public String errorSign(WebElement element) {
	
	String result = element.getText().trim();
	
	return result; 
}

	public void smokeListYourStayButton() {
		listYourStayButton.click();
	}

	public void smokePrivateButton() {
		privateRoom.click();
	}

	public void smokeNextButton() {
		nextButton.click();
	}
	
	public String smokeProperty() {
		String result = propertyDetails.getText().trim();
		return result;
	}
	
	public void dropDownButton() throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(dropDownButton).click(dropDownButton).perform();
		Thread.sleep(200);
		

		dropDownButton.isDisplayed();
	}
	
	public void logOutButton() {
		LogOutButton.click();
	}
}
