package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	HomePage homepage;
	
	
	@Test(priority=1, groups = {"regression"}, retryAnalyzer = retry.Retry.class , description="LogIn Test Case with Valid credentials") 
	public void verifyTheUserIsAbletoLoginWithValidCredentials() throws IOException
	{

		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); 
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); 
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue); //Chaining two methods
//		loginpage.enterPassword(passwordValue);
		homepage=loginpage.clickonSignInButton();
		boolean homepagedisplay = loginpage.isHomePageDisplayed();
		Assert.assertTrue(homepagedisplay, Constant.VALIDCREDSMSG); //To give message if the test case fails. Message is given in Constant.
		
	}
	
	@Test(priority=2, description="LogIn Test Case with Valid username and Invalid password")
	public void InvalidCredentialsSet1() throws IOException
	{

		String usernameValue = ExcelUtility.getStringData(2, 0, "loginpage"); 
		String passwordValue = ExcelUtility.getStringData(2, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); 
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue); //Chaining two methods
		homepage=loginpage.clickonSignInButton();
		boolean alertmsg = loginpage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg, Constant.INVALIDPWDMSG);
		
		
	}
	
	@Test(priority=3, description="LogIn Test Case with Invalid username and Valid password")
	public void InvalidCredentialsSet2() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(3, 0, "loginpage"); 
		String passwordValue = ExcelUtility.getStringData(3, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); 
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		homepage=loginpage.clickonSignInButton();
		boolean alertmsg = loginpage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg, Constant.INVALIDUSERNAMEMSG);
		
	}
	
	@Test(priority=4, description="LogIn Test Case with Invalid credentials")
	public void InvalidCredentialsSet3() throws IOException
	{

		String usernameValue = ExcelUtility.getStringData(4, 0, "loginpage"); 
		String passwordValue = ExcelUtility.getStringData(4, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); 
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		homepage=loginpage.clickonSignInButton();
		
		boolean alertmsg = loginpage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg, Constant.INVALIDCREDSMSG);
	}

}
