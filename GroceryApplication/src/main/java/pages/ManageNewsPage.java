package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
//	The below webElement is present in HomePage. So commenting it here.
//	@FindBy(xpath="(//div[@id='sidebar-overlay']//preceding::i[@class='fas fa-arrow-circle-right'])[7]")WebElement manageNewsMoreInfoButton; 
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton; 
	
	@FindBy(xpath="//textarea[@id='news']")WebElement textArea; 
	
	@FindBy(xpath="//button[@type='submit']")WebElement saveButton; 
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage; 
	
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
//	The below Method is present in HomePage. So commenting it here.
/*	public void clickOnManageNewsMoreInfoButton()
	{
	
		
		manageNewsMoreInfoButton.click();
		
	}*/
	
	public ManageNewsPage clickOnNewButton()
	{
	
		newButton.click();
		return this;
		
	}
	
	public ManageNewsPage enterTheNews(String newsValue)
	{
		
		textArea.sendKeys(newsValue);
		return this;
		
	}
	
	public ManageNewsPage clickOnSaveButton()
	{
		
		saveButton.click();
		return this;
		
	}
	
	public boolean isAlertMsgDisplayed() //Method used to validate whether dashboard is displayed.
	{
		
		return alertMessage.isDisplayed();
		
	}
	

}
