package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	
	HomePage homepage;
	AdminUsersPage adminuserspage;
	
	@Test(retryAnalyzer = retry.Retry.class , description="AdminUsers Test Case to add new Users")
	public void verifyTheAdminIsAbleToAddUser() throws IOException
	{
		
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); 
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); 
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);//Chaining two methods in loginpage
		homepage=loginpage.clickonSignInButton();
		
		FakerUtility fakerutility = new FakerUtility(); //To generate username and password using fakerutility class		
		String randomUserName = fakerutility.generateUsername();
		String randomPassword = fakerutility.generatePassword();
		
		String usertypeValue = ExcelUtility.getStringData(1, 0,"adminuserspage");
		
//		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		adminuserspage=homepage.clickOnAdminUsersMoreInfoButton(); //Chaining two pages.
		adminuserspage.clickOnNewButton().enterTheUserName(randomUserName).enterThePassword(randomPassword).selectUserType(usertypeValue).clickSaveButton();
//		adminuserspage.enterTheUserName(randomUserName);
//		adminuserspage.enterThePassword(randomPassword);
//		adminuserspage.selectUserType(usertypeValue);
//		adminuserspage.clickSaveButton();
		boolean alertmsg = adminuserspage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg, Constant.ADMINUSERSMSG);		
				
	}

}
