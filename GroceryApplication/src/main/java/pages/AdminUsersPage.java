package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class AdminUsersPage {
	
//	@FindBy(xpath="(//div[@id='sidebar-overlay']//preceding::i[@class='fas fa-arrow-circle-right'])[1]")WebElement adminUsersMoreInfoButton; 
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton; 
	
	@FindBy(xpath="//input[@id='username']")WebElement username;
	
	@FindBy(xpath="//input[@id='password']")WebElement password;
	
	@FindBy(xpath="//select[@id='user_type']")WebElement usertype;
	
	@FindBy(xpath="//button[@name='Create']")WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMsg;
	
	WebDriver driver;
	
	
	public AdminUsersPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}	
	
	/*public void clickOnAdminUsersMoreInfoButton()
	{
	
		adminUsersMoreInfoButton.click();
		
	}*/
	
	public AdminUsersPage clickOnNewButton()
	{
	
		newButton.click();
		return this;
		
	}
	
	public AdminUsersPage enterTheUserName(String randomUserName)
	{
		
		username.sendKeys(randomUserName);
		return this;
		
	}
	
	public AdminUsersPage enterThePassword(String randomPassword)
	{
		
		password.sendKeys(randomPassword);
		return this;
		
	}
	
	public AdminUsersPage selectUserType(String usertypeValue)
	{
		
		usertype.click();
		PageUtility pageutility = new PageUtility();
		pageutility.selectByVisibleTextMethod(usertype, usertypeValue);
		return this;	
		
	}
	
	public AdminUsersPage clickSaveButton()
	{
		
		saveButton.click();
		return this;
		
	}
	
	public boolean isAlertMsgDisplayed() 
	{
		
		return alertMsg.isDisplayed();
		
	}
	
	
	

}
