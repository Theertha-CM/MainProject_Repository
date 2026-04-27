package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageContactPage {
	
	@FindBy(xpath="(//a[@class='small-box-footer']//following::i[@class='fas fa-arrow-circle-right'])[3]")WebElement manageContactMoreInfoButton;
	
	@FindBy(xpath="//a[@role='button']")WebElement actionButton;
	
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	
	@FindBy(xpath="//input[@id='email']")WebElement email;
	
	@FindBy(xpath="//textarea[@id='content' and @name='address']")WebElement address;
	
	@FindBy(xpath="//textarea[@id='content' and @name='del_time']")WebElement deliveryTime;
	
	@FindBy(xpath="//input[@id='del_limit']")WebElement deliveryChargeLimit;
	
	@FindBy(xpath="//button[@type='submit']")WebElement updateButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMsg;
	
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
	
	public ManageContactPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void clickManageContactMoreInfoButton()
	{
		
		manageContactMoreInfoButton.click();
		
	}
	
	public void clickActionButton()
	{
		
		actionButton.click();
		
	}
	
	public void enterPhoneNumber(String phoneNumberValue)
	{
		
		phone.clear();
		phone.sendKeys(phoneNumberValue);
		
	}
	
	public void enterEmail(String emailValue)
	{
		
		email.clear();
		email.sendKeys(emailValue);
		
	}
	
	
	public void enterAddress(String addressValue)
	{
		
		address.clear();
		address.sendKeys(addressValue);
		
	}
	
	public void enterDeliveryTime(String deliveryTimeValue)
	{
		
		deliveryTime.clear();
		deliveryTime.sendKeys(deliveryTimeValue);
		
	}
	
	public void enterDeliveryChargeLimit(String deliveryChargeLimitValue)
	{
		
		deliveryChargeLimit.clear();
		deliveryChargeLimit.sendKeys(deliveryChargeLimitValue);
		
	}
	
	public void clickUpdateButton()
	{
		//As the click() method is not working, we need to use ActionClass to perform the click operation.
//		Actions actions = new Actions(driver);
//		actions.moveToElement(updateButton).pause(500).click().perform(); 
		
	
		pageutility.singleClick(driver, updateButton);
		
		
	}
	
	public boolean isAlertMsgDisplayed() 
	{
		
		return alertMsg.isDisplayed();
		
	}
	
}
