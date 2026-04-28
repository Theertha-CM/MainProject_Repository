package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {
	
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException
	{
		//Converting webdriver to screenshot mode (TypeCasting). Selenium Webdriver cannot take screenshots directly. so we typecast it to take screenshot.
		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot - Is an interface provided by TestNG to take screenshots
		
		//This takes the screenshot and stores it temporarily as a file.
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //getScreenshotAs() - Used to capture the screenshot. Method provided by TakesScreenshot.
		
		//Creates date and time.
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
		//
		File f1 = new File(System.getProperty("user.dir") + "//outputScreenShot"); 
		if (!f1.exists()) 
		{
			f1.mkdirs(); //Create a folder if it doesnot exist.
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png"; //Decides final screenshot path
		
		//copy screenshot to final location. Screenshot was temporarily stored and now it is permanently stored in the folder(finalDestination).
		File finalDestination = new File(destination); 
		FileHandler.copy(screenShot, finalDestination); // FileHandler-class and copy() are used to copy screenshot to final location.
	}

}
