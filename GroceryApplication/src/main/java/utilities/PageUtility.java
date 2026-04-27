package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectByVisibleTextMethod(WebElement elementName, String visibleText ) //To handle dropdown
	{
		Select select = new Select(elementName);
		select.selectByVisibleText(visibleText);
		
	}
	
	public void selectByValueMethod(WebElement elementName, String value ) //To handle dropdown
	{
		Select select = new Select(elementName);
		select.selectByValue(value);
		
	}
	
	public void selectByIndexMethod(WebElement elementName, int index ) //To handle dropdown
	{
		Select select = new Select(elementName);
		select.selectByIndex(index);
		
	}
	
	

}
