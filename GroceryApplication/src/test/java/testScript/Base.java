package testScript;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilities.WaitUtility;

public class Base {
	
	public WebDriver driver; //Creating reference variable for the Interface WebDriver
	
	public Properties properties;
	
	//To implement cross browser Testing, Selenium uses the annotation @Parameters
	@Parameters("browser")
	@BeforeMethod(alwaysRun = true) //To run this method always.
	public void browserInitialisation(String browser) throws Exception 
	{
		try
		{
			
			properties = new Properties();
			FileInputStream fileinputstream = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinputstream);
			
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			
		}
		
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();	
		}
		
		else if(browser.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		
		else 
		{
			throw new Exception("Invalid Browser");
		}
		
//		driver = new ChromeDriver(); //This line needs to be used if the above code snippet is being commented
		System.out.println("Initialising Browser");
//		driver.get("https://groceryapp.uniqassosiates.com/admin"); //To launch the url
		driver.get(properties.getProperty("url")); //Launching url from config.properties file
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize(); //To maximise the window
	}
	
	//@AfterMethod(alwaysRun = true)
	public void browserQuitandClose()
	{
		//driver.close(); //Closes only the parent window.
		driver.quit(); //Closes all the windows which are opened during execution. Useful when we uses multiple windows and tabs.
	}




}
