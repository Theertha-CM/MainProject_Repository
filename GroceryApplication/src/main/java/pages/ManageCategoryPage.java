package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCategoryPage {

	@FindBy(xpath="(//div[@id='sidebar-overlay']//preceding::a[@class='small-box-footer'])[9]")WebElement manageCategoryMoreInfoButton;
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newButton;
	
	@FindBy(xpath="//input[@id='category']")WebElement categoryField;	
	
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
	
	@FindBy(xpath="//li[@id='134-selectable']")WebElement selectGroup;
	
	@FindBy(xpath="//button[@type='submit']")WebElement saveButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMsg;
	
	
	public WebDriver driver;
	
	public ManageCategoryPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickManageCategoryMoreInfoButton()
	{
		
		manageCategoryMoreInfoButton.click();
		
	}
	
	public void clickNewButton()
	{
		
		newButton.click();
		
	}
	
	public void enterCategory(String categoryValue)
	{
		
		categoryField.sendKeys(categoryValue);
		
	}
	
	public void clickOnChooseFile(String filepath)
	{
		
		chooseFile.sendKeys(filepath);
		
	}
	
	public void clickOnSelectTheGroups()
	{
		
		selectGroup.click();
		
	}
	
	public void clickOnSaveButton()
	{
		Actions actions = new Actions(driver);
		
		actions.moveToElement(saveButton).pause(500).click().perform();
		
	}
	
	public boolean isAlertMsgDisplayed() 
	{
		
		return alertMsg.isDisplayed();
		
	}
	
	
	
	
	
}
