package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement admin; //Locating WebElements using PageFactory
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logout;
	@FindBy(xpath="//body[@class='login-page']")WebElement loginPage;
	
	public WebDriver driver;
	
	public LogOutPage(WebDriver driver) 
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElements() - Used to initialise the WebElements
	}
	
	public void clickOnAdmin()
	{
		
		admin.click();
		
	}
	
	public void clickOnLogout()
	{
		
		logout.click();
		
	}
	
	public boolean isLoginPageDisplayed()
	{
		return loginPage.isDisplayed();
		
	}
		

}
