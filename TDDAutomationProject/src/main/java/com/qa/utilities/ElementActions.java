package com.qa.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class ElementActions extends TestBase
{	
	public static By selectByLocator(String locatorType, String locatorAddress) 
	{
	    switch (locatorType.toUpperCase())
	    {
	      case "XPATH":
	        return By.xpath(locatorAddress);
	      case "TAGNAME":
	        return By.tagName(locatorAddress);
	      case "ID":
	        return By.id(locatorAddress);
	      case "NAME":
	        return By.name(locatorAddress);
	      case "CLASSNAME":
	        return By.className(locatorAddress);
	      case "LINKTEXT":
	        return By.linkText(locatorAddress);
	      case "PARTIALLINKTEXT":
	        return By.partialLinkText(locatorAddress);
	      default:
	        System.out.println("No such loactor type found : " + locatorType);
	    }
	    return null;
	  }

	  public static void clickOn(String locatorType, String locatorAddress)
	  {
	    driver.findElement(selectByLocator(locatorType, locatorAddress)).click();
	  }

	  public static void enterText(String locatorType, String locatorAddress, String text)
	  {
		  driver.findElement(selectByLocator(locatorType, locatorAddress)).clear();
		  driver.findElement(selectByLocator(locatorType, locatorAddress)).sendKeys(text);
	  }

	public static void enterText(WebElement ele, String text)
	{
		ele.clear();
		ele.sendKeys(text);
	}
	
	public static void click(WebElement ele)
	{
		ele.click();
	}
	
	public static void clickWithJS(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
	    js.executeScript("arguments[0].click();", ele);
	}
	
	public static void selectValueFromDD(WebElement ele, String value)
	{
		Select select=new Select(ele);
		select.selectByValue(value);		
	}
	
	public static void selectIndexFromDD(WebElement ele, String index)
	{
		Select select=new Select(ele);
		select.selectByValue(index);		
	}
	
	public static void selectTextFromDD(WebElement ele, String text)
	{
		Select select=new Select(ele);
		select.selectByValue(text);
	}
	
	public String getTextFromAlert()
	{
		String alertText;
		return alertText =driver.switchTo().alert().getText();
	}
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert()
	{
		driver.switchTo().alert().dismiss();
	}
	 
}
