package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;
import com.qa.utilities.ElementActions;
import com.qa.utilities.ElementVerify;

public class LoginPage extends TestBase
{
	//Object repository for HomePage
	@FindBy(xpath="//a[@href='https://www.freecrm.com/register/']//font[text()='Sign Up']")
	private static WebElement signUpButtonXpath;
	@FindBy(xpath="//a[@href='https://www.freecrm.com/features.html' and text()='Features']")
	private static WebElement featuresButtonXpath;
	@FindBy(xpath="//a[text()='Pricing']")
	private static WebElement pricingButtonXpath;
	@FindBy(xpath="//a[text()='Customers']")
	private static WebElement customersButtonXpath;
	@FindBy(xpath="//a[text()='Contact']")
	private static WebElement contactButtonXpath;
	@FindBy(xpath="//a[text()='Support']")
	private static WebElement supportButtonXpath;
	@FindBy(xpath="//img[@class='img-responsive' and @alt='free crm logo']")
	private static WebElement companyLogoXpath;
	@FindBy(name="username")
	private static WebElement usernameInputName;
	@FindBy(name="password")
	private static WebElement passwordInputName;
	@FindBy(xpath="//input[@value='Login']")
	private static WebElement signInButtonXpath;
	
	//Page Factory Initialization
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Common Methods for HomePage
	public HomeePage login(String userName, String password)
	{
		ElementActions.enterText(usernameInputName, userName);
		ElementActions.enterText(passwordInputName, password);
		ElementActions.clickWithJS(signInButtonXpath);
	    return new HomeePage();
	}
	
	public void clickOnSignUpLink()
	{
		ElementActions.clickWithJS(signUpButtonXpath);
	}
	
	public FeaturePage clickOnFeatureLink()
	{
		ElementActions.clickWithJS(featuresButtonXpath);
		return new FeaturePage();
	}
	
	public void isApplicationLogoPresent()
	{
		ElementVerify.isElementPresent(companyLogoXpath);
	}	
	
	public PricingPage clickOnPricingLink()
	{
		ElementActions.clickWithJS(pricingButtonXpath);
		return new PricingPage();
	}

	public CustomersPage clickOnCustomersLink()
	{
		ElementActions.clickWithJS(customersButtonXpath);
		return new CustomersPage();
	}

	public ContactPage clickOnContactLink()
	{
		ElementActions.clickWithJS(contactButtonXpath);
		return new ContactPage();
	}

	public SupportPage clickOnSupportLink()
	{
		ElementActions.clickWithJS(supportButtonXpath);
		return new SupportPage();
	}

	public void verifyHomePage()
	{
		 ElementVerify.isElementPresent(companyLogoXpath);
	}

}
