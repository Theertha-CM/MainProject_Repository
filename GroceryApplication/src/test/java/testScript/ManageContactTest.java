package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class ManageContactTest extends Base {
	
	HomePage homepage;
	ManageContactPage managecontactpage;
	
	@Test(retryAnalyzer = retry.Retry.class , description="Manage Contact Test Case to add")
	public void verifyAdminIsAbleToAddContact() throws IOException
	{
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage"); //Fetching username from the excel file from the sheet loginpage
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		
		LoginPage loginpage = new LoginPage(driver); //Creating an object of LoginPAge Class to call the methods here.
		loginpage.enterUserName(usernameValue).enterPassword(passwordValue);
		homepage=loginpage.clickonSignInButton();
		
		FakerUtility fakerutility = new FakerUtility();
		String phoneNumberValue = fakerutility.generatePhoneNumber();
		String emailValue = fakerutility.generateEmail();
		String addressValue = fakerutility.generateAddress();
		
		String deliveryTimeValue = ExcelUtility.getStringData(1, 0, "managecontactpage");
		String deliveryChargeLimitValue = ExcelUtility.getStringData(1, 1, "managecontactpage");
		
//		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage=homepage.clickManageContactMoreInfoButton();
		managecontactpage.clickActionButton().enterPhoneNumber(phoneNumberValue).enterEmail(emailValue).enterAddress(addressValue).enterDeliveryTime(deliveryTimeValue).enterDeliveryChargeLimit(deliveryChargeLimitValue).clickUpdateButton();
//		managecontactpage.enterPhoneNumber(phoneNumberValue);
//		managecontactpage.enterEmail(emailValue);
//		managecontactpage.enterAddress(addressValue);
//		managecontactpage.enterDeliveryTime(deliveryTimeValue);
//		managecontactpage.enterDeliveryChargeLimit(deliveryChargeLimitValue);
//		managecontactpage.clickUpdateButton();
		boolean alertmsg = managecontactpage.isAlertMsgDisplayed();
		Assert.assertTrue(alertmsg, Constant.MANAGECONTACTMSG);
		
		
	}

}
