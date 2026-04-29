package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement admin; //Locating WebElements using PageFactory
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout']")WebElement logout;
	@FindBy(xpath="//body[@class='login-page']")WebElement loginPage;
	
	@FindBy(xpath="(//div[@id='sidebar-overlay']//preceding::i[@class='fas fa-arrow-circle-right'])[7]")WebElement manageNewsMoreInfoButton;
	@FindBy(xpath="(//div[@id='sidebar-overlay']//preceding::i[@class='fas fa-arrow-circle-right'])[1]")WebElement adminUsersMoreInfoButton;
	@FindBy(xpath="(//div[@id='sidebar-overlay']//preceding::a[@class='small-box-footer'])[9]")WebElement manageCategoryMoreInfoButton;
	@FindBy(xpath="(//a[@class='small-box-footer']//following::i[@class='fas fa-arrow-circle-right'])[3]")WebElement manageContactMoreInfoButton;
	@FindBy(xpath="(//div[@id='sidebar-overlay']//preceding::a[@class='small-box-footer'])[8]")WebElement manageFooterMoreInfoButton;
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this); //initElements() - Used to initialise the WebElements
	}
	
	public ManageNewsPage clickOnManageNewsMoreInfoButton()
	{
	
		
		manageNewsMoreInfoButton.click();
		return new ManageNewsPage(driver);
		
	}
	
	
	public AdminUsersPage clickOnAdminUsersMoreInfoButton()
	{
	
		adminUsersMoreInfoButton.click();
		return new AdminUsersPage(driver);
		
	}
	
	public ManageCategoryPage clickManageCategoryMoreInfoButton()
	{
		
		manageCategoryMoreInfoButton.click();
		return new ManageCategoryPage(driver);
		
	}
	
	public ManageContactPage clickManageContactMoreInfoButton()
	{
		
		manageContactMoreInfoButton.click();
		return new ManageContactPage(driver);
		
	}
	
	public ManageFooterPage clickManageFooterMoreInfoButton()
	{
		
		manageFooterMoreInfoButton.click();
		return new ManageFooterPage(driver);
		
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
