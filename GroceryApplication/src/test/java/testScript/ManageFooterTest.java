package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTest extends Base {
	
	HomePage homepage;
	ManageFooterPage managefooterpage;
	
	@Test(retryAnalyzer = retry.Retry.class , description="Manage Footer TestCase to add new footer")
	public void verifyAdminIsAbleToAddFooter() throws IOException
	{
		
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); 
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); 
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		homepage=loginpage.clickonSignInButton();
		
		FakerUtility fakerutility = new FakerUtility();
		String addressValue = fakerutility.generateAddress();
		String emailValue = fakerutility.generateEmail();
		String phoneValue = fakerutility.generatePhoneNumber();
		
//		ManageFooterPage managefooterpage = new ManageFooterPage(driver);
		managefooterpage=homepage.clickManageFooterMoreInfoButton();
		managefooterpage.clickActionButton().enterAddress(addressValue).enterEmail(emailValue).enterPhone(phoneValue).clickOnUpdateButton();
//		managefooterpage.enterAddress(addressValue);
//		managefooterpage.enterEmail(emailValue);
//		managefooterpage.enterPhone(phoneValue);
//		managefooterpage.clickOnUpdateButton();		
		boolean alertmsg = managefooterpage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg, Constant.MANAGEFOOTERMSG);
		
		
		
	}

}
