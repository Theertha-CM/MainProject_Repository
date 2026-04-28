package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement userName; //Locating WebElements using PageFactory
	
	@FindBy(xpath="//input[@placeholder='Password']")WebElement pwd;
	
	@FindBy(xpath="//button[text()='Sign In']")WebElement signIn;
	
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")WebElement alertmsg;

	public WebDriver driver; //Making driver global
	
	public LoginPage(WebDriver driver) 
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElements() - Used to initialise the WebElements
	}

	//All the methods defined in LoginPage Class will be invoked in LoginTest Class
	public LoginPage enterUserName(String usernameValue)
	{
		
		userName.sendKeys(usernameValue); 
		return this;
		
	}
	
	public LoginPage enterPassword(String passwordValue)
	{
		
		pwd.sendKeys(passwordValue);
		return this;
		
	}
	
	public HomePage clickonSignInButton()
	{
	
		//WaitUtility waitutility = new WaitUtility();
		//waitutility.waitForElementToBeClickable(driver, signIn);
		signIn.click();
		return new HomePage(driver);
		
	}
	
	public boolean isHomePageDisplayed() //Method used to validate whether dashboard is displayed.
	{
		
		return dashboard.isDisplayed();
		
	}
	
	public boolean isAlertMsgDisplayed() //Method used to validate whether dashboard is displayed.
	{
		
		return alertmsg.isDisplayed();
		
	}


}
