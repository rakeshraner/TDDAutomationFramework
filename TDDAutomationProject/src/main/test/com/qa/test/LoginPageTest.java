package com.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.utilities.ElementVerify;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;

	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();	
		loginPage=new LoginPage();
	}
	
	/*@DataProvider
	public Object[][] loginWithPositiveData()
	{
		 Object[][] data =ReadExcel.readData("Sheet1");
		 return data;
	}*/
	
	@Test(priority=1)
	public void loginTest()
	{
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String currentPageTitle =ElementVerify.getCurrentPageTitle();
		ElementVerify.verifyURL(currentPageTitle, "CRMPRO");
	}
	
	@Test(priority=2)
	public void featureLinkTest()
	{
		loginPage.clickOnFeatureLink();
		String currentPageUrl=ElementVerify.getCurrentUrl();
		ElementVerify.verifyURL(currentPageUrl, "https://www.freecrm.com/features.html");
	}
	
	@Test(priority=3)
	public void pricingLinkTest()
	{
		loginPage.clickOnPricingLink();
		String currentPageUrl=ElementVerify.getCurrentUrl();
		ElementVerify.verifyURL(currentPageUrl, "https://www.freecrm.com/pricing.html");
	}
	
	@Test(priority=4)
	public void customersLinkTest()
	{
		loginPage.clickOnCustomersLink();
		String currentPageUrl=ElementVerify.getCurrentUrl();
		ElementVerify.verifyURL(currentPageUrl, "https://www.freecrm.com/customers.html");
	}
	
	@Test(priority=5)
	public void contactLinkTest()
	{
		loginPage.clickOnContactLink();
		String currentPageUrl=ElementVerify.getCurrentUrl();
		ElementVerify.verifyURL(currentPageUrl, "https://www.freecrm.com/contact.html");
	}
	
	@Test(priority=6)
	public void supportLinkTest()
	{
		loginPage.clickOnSupportLink();
		String currentPageUrl=ElementVerify.getCurrentUrl();
		ElementVerify.verifyURL(currentPageUrl, "https://support.cogmento.com/");
	}
	
	@Test(priority=7)
	public void verifyApplicationLogo()
	{
		loginPage.isApplicationLogoPresent();
	}	
	
	@AfterMethod
	public void tearDown()
	{
		closeCurrentBrowserTab();
	}

}
