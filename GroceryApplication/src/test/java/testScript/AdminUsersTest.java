package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	
	@Test(retryAnalyzer = retry.Retry.class , description="Adding AdminUsers Test Case")
	public void verifyTheAdminIsAbleToAddUser() throws IOException
	{
		
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); //Fetching username from the excel file from the sheet loginpage
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); //Creating an object of LoginPAge Class to call the methods here.
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickonSignInButton();
		
		FakerUtility fakerutility = new FakerUtility(); //To generate username and password using fakerutility class		
		String randomUserName = fakerutility.generateUsername();
		String randomPassword = fakerutility.generatePassword();
		
		String usertypeValue = ExcelUtility.getStringData(1, 0,"adminuserspage");
		
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage.clickOnAdminUsersMoreInfoButton();
		adminuserspage.clickOnNewButton();
		adminuserspage.enterTheUserName(randomUserName);
		adminuserspage.enterThePassword(randomPassword);
		adminuserspage.selectUserType(usertypeValue);
		adminuserspage.clickSaveButton();
		boolean alertmsg = adminuserspage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg);		
				
	}

}
