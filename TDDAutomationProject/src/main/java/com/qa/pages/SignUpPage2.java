package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;
import com.qa.utilities.ElementActions;
import com.qa.utilities.ElementVerify;

public class SignUpPage2 extends TestBase
{
	@FindBy(id="company_name")
	private static WebElement companyTextId;
	@FindBy(id="phone")
	private static WebElement phoneTextId;
	@FindBy(id="fax")
	private static WebElement faxTextId;
	@FindBy(id="website")
	private static WebElement websiteTextId;
	@FindBy(id="company_email")
	private static WebElement companyEmailTextId;
	@FindBy(id="service")
	private static WebElement serviceTextId;
	@FindBy(id="address")
	private static WebElement addressTextId;
	@FindBy(id="city")
	private static WebElement cityTextId;
	@FindBy(id="state")
	private static WebElement stateTextId;
	@FindBy(id="postcode")
	private static WebElement postcodeTextId;
	@FindBy(name="country")
	private static WebElement countryDropDownName;
	@FindBy(name="copy_address")
	private static WebElement copyAddressCheckBoxName;
	@FindBy(name="btnSubmit")
	private static WebElement submitCompanyInfoButtonName;
	@FindBy(name="finish")
	private static WebElement compeletRegistrationButtonName;
	@FindBy(xpath="//div[@class='text_orange']")
	private static WebElement verifySignUp;

	
	public SignUpPage2()
	{
		PageFactory.initElements(driver, this);
	}

	public LoginPage companyInfoForRegistration(String companyName, String phone, String fax, String website, String companyEmail, String service, String address, String city, String state, String postCode, String country)
	{
		ElementActions.enterText(companyTextId, companyName);
		ElementActions.enterText(phoneTextId, phone);
		ElementActions.enterText(faxTextId, fax);
		ElementActions.enterText(websiteTextId, website);
		ElementActions.enterText(companyEmailTextId, companyEmail);
		ElementActions.enterText(serviceTextId, service);
		ElementActions.enterText(addressTextId, address);
		ElementActions.enterText(cityTextId, city);
		ElementActions.enterText(stateTextId, state);
		ElementActions.enterText(postcodeTextId, postCode);
		ElementActions.selectValueFromDD(countryDropDownName, country);
		ElementActions.click(copyAddressCheckBoxName);
		ElementActions.click(submitCompanyInfoButtonName);
		ElementActions.click(compeletRegistrationButtonName);
		return new LoginPage();
	}

	public void verifySuccessfulSignUp()
	{
		ElementVerify.isElementPresent(verifySignUp);
	}
	
	
}
