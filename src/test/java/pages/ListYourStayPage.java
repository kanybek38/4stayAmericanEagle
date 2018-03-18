package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(xpath="//div[@class='icon bath-private selected']")
	public WebElement privateBathroom; 
	
	@FindBy(xpath="//label[@for='room_king_bed']")
	public WebElement kingBedCheckBox; 
	
	@FindBy(xpath="//label[@for='room_hangers']")
	public WebElement hangerCheckBox; 

	@FindBy(xpath="//label[@for='room_balcony']")
	public WebElement roomBalconyCheckBox; 
	
	@FindBy(xpath="//input[@class='form-control ng-pristine ng-valid ng-empty ng-touched']")
	public WebElement mainStayTitle; 
	
	
	@FindBy(xpath="//textarea[@class='form-control ng-pristine ng-valid ng-empty ng-touched']")
	public WebElement mainStayDescription; 
	
	
	@FindBy(xpath="//div[@class='date-range-picker col-8 ng-pristine ng-untouched ng-valid ng-binding ng-isolate-scope ng-not-empty']")
	public WebElement availableDateFrom; 
	
	@FindBy(xpath="//table[@class='table-condensed']//tbody[1]//tr[5]//td[.='29']")
	public WebElement march29; 
	
	
	@FindBy(xpath="//div[@class='date-range-picker col-8 ng-pristine ng-untouched ng-valid ng-binding ng-isolate-scope ng-empty']")
	public WebElement availableDateTo;
	
	@FindBy(xpath="//table[@class='table-condensed']//tbody//tr[5]//td[.='31']")
	public WebElement march31; 
	
	@FindBy(xpath="//input[@class='form-control ng-pristine ng-valid ng-empty ng-valid-min ng-valid-max ng-touched']")
	public WebElement pricePerMonth;
	
	
	@FindBy(xpath="//input[@class='form-control ng-valid ng-valid-min ng-valid-max ng-not-empty ng-dirty ng-valid-parse ng-touched']")
	public WebElement securityDeposit;
	
	@FindBy(xpath="	//button[@class='btn btn-primary ng-binding']")
	public WebElement saveButton;
	
	
	
	
	
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
	
	

	AddressLine1.sendKeys("123"+Keys.ARROW_DOWN+Keys.ENTER);
	
	
	
	
	
	
	Thread.sleep(2000);
		//AddressLine2.click();



	AddressLine2.sendKeys(Config.getProperty("addressLine1")+Keys.ARROW_DOWN+Keys.ENTER);
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
	Thread.sleep(500);

	march29.click();
	Thread.sleep(500);

	availableDateTo.click();
	Thread.sleep(500);

	march31.click();
	Thread.sleep(500);

	nextButton.click();
	Thread.sleep(500);

	pricePerMonth.sendKeys("100");
	Thread.sleep(500);

	securityDeposit.sendKeys("100");
	Thread.sleep(500);

	saveButton.click();
	
}

	
	
}
