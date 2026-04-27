package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	public void dragandDrop(WebDriver driver, WebElement dragElementName, WebElement dropElementName)
	{
		
		Actions ac = new Actions(driver);
		ac.dragAndDrop(dragElementName, dropElementName).perform(); //To perform drag and drop. Drag and drop elements should be given		
		
	}
	
	public void rightClick(WebDriver driver, WebElement elementName)
	{
		
		Actions ac = new Actions(driver);
		ac.contextClick(elementName).perform(); //To perform right click on a particular webelement.
		
	}
	
	public void mouseHover(WebDriver driver, WebElement elementName)
	{
		
		Actions ac = new Actions(driver);
		ac.moveToElement(elementName).perform(); //To mouse hover on a particular webelement
		
	}
	
	public void doubleClick(WebDriver driver, WebElement elementName)
	{
	
		
		Actions ac = new Actions(driver);
		ac.doubleClick(elementName).perform();
		
		
	}
	
	public void singleClick(WebDriver driver, WebElement elementName)
	{
	
		
		Actions ac = new Actions(driver);
		ac.moveToElement(elementName).click().perform(); 
		
		
	}
	
	
	

}
