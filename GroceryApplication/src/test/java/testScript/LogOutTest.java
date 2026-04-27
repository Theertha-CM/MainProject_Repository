package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LogOutTest extends Base {
	
	@Test(priority=1 , description="LogOut Test Case")
	public void verifyTheUserIsAbletoLoginWithValidCredentials() throws IOException
	{
//		String usernameValue = "admin"; //Passing hardcoded userName value 
//		String passwordValue = "admin"; //Passing hardcoded pwd value

		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); //Fetching username from the excel file from the sheet loginpage
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); //Creating an object of LoginPAge Class to call the methods here.
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickonSignInButton();
		
		LogOutPage logoutpage = new LogOutPage(driver); //Creating an object of LogOutPAge Class to call the methods here.
		logoutpage.clickOnAdmin();
		logoutpage.clickOnLogout();
		boolean logOut = logoutpage.isLoginPageDisplayed();
		Assert.assertTrue(logOut);
		
	}

	
	


}
