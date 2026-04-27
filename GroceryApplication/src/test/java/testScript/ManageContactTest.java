package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	
	@Test(retryAnalyzer = retry.Retry.class , description="Manage Contact Test Case")
	public void verifyAdminIsAbleToAddContact() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); //Fetching username from the excel file from the sheet loginpage
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); //Creating an object of LoginPAge Class to call the methods here.
		loginpage.enterUserName(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.clickonSignInButton();
		
		FakerUtility fakerutility = new FakerUtility();
		String phoneNumberValue = fakerutility.generatePhoneNumber();
		String emailValue = fakerutility.generateEmail();
		String addressValue = fakerutility.generateAddress();
		
		String deliveryTimeValue = ExcelUtility.getStringData(1, 0, "managecontactpage");
		String deliveryChargeLimitValue = ExcelUtility.getStringData(1, 1, "managecontactpage");
		
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.clickManageContactMoreInfoButton();
		managecontactpage.clickActionButton();
		managecontactpage.enterPhoneNumber(phoneNumberValue);
		managecontactpage.enterEmail(emailValue);
		managecontactpage.enterAddress(addressValue);
		managecontactpage.enterDeliveryTime(deliveryTimeValue);
		managecontactpage.enterDeliveryChargeLimit(deliveryChargeLimitValue);
		managecontactpage.clickUpdateButton();
		boolean alertmsg = managecontactpage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg);
		
		
	}

}
