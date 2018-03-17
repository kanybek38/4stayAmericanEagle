package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//
public class SecondListYourStayPage {
     WebDriver driver;
	
	public SecondListYourStayPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class='icon private-room']")
	public WebElement privateRoom;
	
	@FindBy (xpath = "//button[@class='btn btn-primary']")
	public WebElement nextButton;
	
	@FindBy (xpath = "//div[@class='icon apartment']")
	public WebElement apartmentLink;
	
	@FindBy (xpath = "//div[@class='icon female selected']")
	public WebElement femaleLink;
	
	@FindBy (xpath = "//label[@for='furnished']")
	public WebElement furnishedCheckBox;
	
	@FindBy (xpath = "//label[@for='balcony']")
	public WebElement balconyCheckBox;
	
	@FindBy (xpath = "//label[@for='dishwasher']")
	public WebElement dishwahserCheckBox;
	
	@FindBy (xpath = "(//input[@placeholder='123456 Happy St.'])[1]")
	public WebElement AddressLine1;
	
}
