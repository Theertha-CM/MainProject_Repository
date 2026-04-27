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
	public void enterUserName(String usernameValue)
	{
		
		userName.sendKeys(usernameValue); 
		//userName - WebElement name given in @FindBy Annotation, Passing the argument as usernameValue - the value is given in the method inside LoginTest.
		
	}
	
	public void enterPassword(String passwordValue)
	{
		
		pwd.sendKeys(passwordValue);
		//pwd - WebElement name given in @FindBy Annotation, Passing the argument as passwordValue - the value is given in the method inside LoginTest.
		
	}
	
	public void clickonSignInButton()
	{
	
		//WaitUtility waitutility = new WaitUtility();
		//waitutility.waitForElementToBeClickable(driver, signIn);
		signIn.click();
		
	}
	
	public boolean isHomePageDisplayed() //Method used to validate whether dashboard is displayed.
	{
		
		return dashboard.isDisplayed();
		
	}
	
	public boolean isAlertMsgDisplayed() //Method used to validate whether dashboard is displayed.
	{
		
		return alertmsg.isDisplayed();
		
	}
//	public void dropDown()
//	{
//		PageUtility pageutility = new PageUtility();
//		pageutility.selectByVisibleTextmethod(country, "India"); //For example we have given. We need to give the webElement of dropdown and the visibleText should be given accordingly.
//	}

}
