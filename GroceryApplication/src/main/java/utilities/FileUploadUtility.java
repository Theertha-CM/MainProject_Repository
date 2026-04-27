package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	
	public void fileUploadUsingSendKeys(WebElement element, String filePath)
	{
		
		element.sendKeys(filePath); 
		
	}
	
	public void fileUploadUsingRobotClass(WebElement element, String filePath) throws AWTException
	{	
		/*StringSelection is a class in Selenium. It is used to copy a file path into the system clipboard.
		 * Why this is needed in Selenium?
		 * Because Selenium cannot directly interact with OS-level file upload windows (the popup that opens after clicking Choose File).
		 * So we use:
			Clipboard (StringSelection) + Robot class → to paste the file path into the upload dialog.
		 * Create an object of the class and give the path of the file to be uploaded.*/
		
		StringSelection stringselection = new StringSelection(filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
		
		Robot robot = new Robot();
		robot.delay(2000); //Setting a delay
		
		robot.keyPress(KeyEvent.VK_CONTROL); //VK_Control - To press Control key (VK - virtual Key )
		robot.keyPress(KeyEvent.VK_V); //VK_V- To press V key
		robot.keyPress(KeyEvent.VK_ENTER); //VK_ENTER - To press Enter key
		
		robot.keyRelease(KeyEvent.VK_CONTROL); //To release the key
		robot.keyRelease(KeyEvent.VK_V); //To release the key
		robot.keyRelease(KeyEvent.VK_ENTER); //To release the key
		
	
	}



}
