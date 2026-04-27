package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	
	@Test
	public void verifyAdminIsAbleToAddCategory() throws IOException
	{
		
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); 
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); 
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickonSignInButton();
		
		String categoryValue = ExcelUtility.getStringData(1, 0, "managecategorypage");
		String filepath = Constant.CATEGORYFILE;
		
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategorypage.clickManageCategoryMoreInfoButton();
		managecategorypage.clickNewButton();
		managecategorypage.enterCategory(categoryValue);
		managecategorypage.clickOnChooseFile(filepath);
		managecategorypage.clickOnSelectTheGroups();
		managecategorypage.clickOnSaveButton();
		boolean alertmsg = managecategorypage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg);
		
		
		
	}
}
