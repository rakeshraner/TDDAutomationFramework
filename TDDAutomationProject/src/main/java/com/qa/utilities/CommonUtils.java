package com.qa.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class CommonUtils extends TestBase
{

	public void EnterText(WebElement ele, String text)
	{
		ele.sendKeys(text);
	}
	
	public void SelectValueFromDD(WebElement ele, String value)
	{
		Select select=new Select(ele);
		select.selectByValue(value);		
	}
	
	public void SelectIndexFromDD(WebElement ele, String index)
	{
		Select select=new Select(ele);
		select.selectByValue(index);		
	}
	
	public void SelectTextFromDD(WebElement ele, String text)
	{
		Select select=new Select(ele);
		select.selectByValue(text);
	}
	
	public String getTextFromAlert()
	{
		String alertText =driver.switchTo().alert().getText();
		return alertText;
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
