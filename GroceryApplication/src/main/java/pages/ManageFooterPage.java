package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterPage {
	
//	@FindBy(xpath="(//div[@id='sidebar-overlay']//preceding::a[@class='small-box-footer'])[8]")WebElement manageFooterMoreInfoButton;
	
	@FindBy(xpath="//i[@class='fas fa-edit']//preceding::a[@class='btn btn-sm btn btn-primary btncss']")WebElement actionButton;
	
	@FindBy(xpath="//textarea[@id='content']")WebElement address;
	
	@FindBy(xpath="//input[@id='email']")WebElement email;
	
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	
	@FindBy(xpath="//button[@name='Update']")WebElement updateButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMsg;
	
	
	public WebDriver driver;
	
	public ManageFooterPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	/*public void clickManageFooterMoreInfoButton()
	{
		
		manageFooterMoreInfoButton.click();
		
	}*/
	
	public ManageFooterPage clickActionButton()
	{
		
		actionButton.click();
		return this;
		
	}
	
	public ManageFooterPage enterAddress(String addressValue)
	{
		
		address.clear();
		address.sendKeys(addressValue);
		return this;
		
	}
	
	public ManageFooterPage enterEmail(String emailValue)
	{
		
		email.clear();
		email.sendKeys(emailValue);
		return this;
		
	}

	public ManageFooterPage enterPhone(String phoneValue)
	{
		
		phone.clear();
		phone.sendKeys(phoneValue);
		return this;
		
	}
	
	public ManageFooterPage clickOnUpdateButton()
	{
		
		updateButton.click();
		return this;
		
	}
	
	public boolean isAlertMsgDisplayed() 
	{
		
		return alertMsg.isDisplayed();
		
	}
}
