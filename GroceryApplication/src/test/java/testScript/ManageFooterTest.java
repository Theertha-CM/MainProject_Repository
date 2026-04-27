package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageFooterPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageFooterTest extends Base {
	
	@Test(retryAnalyzer = retry.Retry.class , description="Manage Footer Test Case")
	public void verifyAdminIsAbleToAddFooter() throws IOException
	{
		
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); 
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); 
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickonSignInButton();
		
		FakerUtility fakerutility = new FakerUtility();
		String addressValue = fakerutility.generateAddress();
		String emailValue = fakerutility.generateEmail();
		String phoneValue = fakerutility.generatePhoneNumber();
		
		ManageFooterPage managefooterpage = new ManageFooterPage(driver);
		managefooterpage.clickManageFooterMoreInfoButton();
		managefooterpage.clickActionButton();
		managefooterpage.enterAddress(addressValue);
		managefooterpage.enterEmail(emailValue);
		managefooterpage.enterPhone(phoneValue);
		managefooterpage.clickOnUpdateButton();		
		boolean alertmsg = managefooterpage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg);
		
		
		
	}

}
