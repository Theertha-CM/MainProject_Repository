package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	
	HomePage homepage;
	ManageNewsPage newspage;

	@Test(description="Manage News Test Case to check whether the Admin is able to add news.")
	public void verifyTheAdminIsAbleToAddNews() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); 
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); 
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);//Chaining two methods in loginpage
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.clickonSignInButton();
		
		String newsValue = ExcelUtility.getStringData(0, 0, "newspage");
		
//		ManageNewsPage newspage = new ManageNewsPage(driver);
		newspage=homepage.clickOnManageNewsMoreInfoButton(); //chaining two pages.
		newspage.clickOnNewButton().enterTheNews(newsValue).clickOnSaveButton();//Chaining two methods in newspage
//		newspage.enterTheNews(newsValue);
//		newspage.clickOnSaveButton();
		boolean alertmsg = newspage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg, Constant.MANAGENEWSMSG);
		
		
		
		
	}
	
}
