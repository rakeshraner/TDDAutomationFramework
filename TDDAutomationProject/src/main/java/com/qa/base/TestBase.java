package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase
{
	FileInputStream fis;
	protected static Properties prop;
	protected static WebDriver driver;

	protected TestBase()
	{
		try
		{
			fis = new FileInputStream("//Users//rakeshrane//TDDAutomationFramework//TDDAutomationFramework//TDDAutomationProject//src//main//java//com//qa//properties//config.properties");
			prop = new Properties();
			prop.load(fis);
		} 
		catch (FileNotFoundException e)
		{
			System.out.println(e.getMessage());
		} 
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	protected static void initialization()
	{
		if (prop.getProperty("Browser").equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/rakeshrane/Tools/chromedriver");
			driver = new ChromeDriver();
		} 
		else if (prop.getProperty("Browser").equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/rakeshrane/Tools/geckodriver");
			driver = new FirefoxDriver();
		}
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.get(prop.getProperty("URL"));
	}

	protected static void closeCurrentBrowserTab()
	{
		driver.close();
	}

	protected static void quitBrowser()
	{
		driver.quit();
	}

}
