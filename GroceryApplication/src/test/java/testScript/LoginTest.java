package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	@Test(priority=1, groups = {"regression"}, retryAnalyzer = retry.Retry.class) 
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
		boolean homepage = loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepage);
		
	}
	
	@Test(priority=2)
	public void InvalidCredentialsSet1() throws IOException
	{
//		String usernameValue = "admin";
//		String passwordValue = "admin2";

		String usernameValue = ExcelUtility.getStringData(2, 0, "loginpage"); //Fetching username from the excel file from the sheet loginpage
		String passwordValue = ExcelUtility.getStringData(2, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); //Creating an object of LoginPAge Class to call the methods here.
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickonSignInButton();
		boolean alertmsg = loginpage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg);
		
		
	}
	
	@Test(priority=3)
	public void InvalidCredentialsSet2() throws IOException
	{
//		String usernameValue = "user3";
//		String passwordValue = "admin";

		String usernameValue = ExcelUtility.getStringData(3, 0, "loginpage"); //Fetching username from the excel file from the sheet loginpage
		String passwordValue = ExcelUtility.getStringData(3, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); //Creating an object of LoginPAge Class to call the methods here.
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickonSignInButton();
		
	}
	
	@Test(priority=4)
	public void InvalidCredentialsSet3() throws IOException
	{
//		String usernameValue = "user4";
//		String passwordValue = "admin4";

		String usernameValue = ExcelUtility.getStringData(4, 0, "loginpage"); //Fetching username from the excel file from the sheet loginpage
		String passwordValue = ExcelUtility.getStringData(4, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); //Creating an object of LoginPAge Class to call the methods here.
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickonSignInButton();
		
	}

}
