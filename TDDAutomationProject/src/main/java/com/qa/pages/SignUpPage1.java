package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;
import com.qa.utilities.ElementActions;

public class SignUpPage1 extends TestBase
{
	@FindBy(id="payment_plan_id")	
	private static WebElement editionDropDownId;
	@FindBy(name="first_name")
	private static WebElement firstNameTextName;
	@FindBy(name="surname")
	private static WebElement lastNameTextName;
	@FindBy(name="email")
	private static WebElement emailTextName;
	@FindBy(name="email_confirm")
	private static WebElement confirmEmailTextName;
	@FindBy(name="username")
	private static WebElement usernameTextName;
	@FindBy(name="password")
	private static WebElement passwordTextName;
	@FindBy(name="passwordconfirm")
	private static WebElement confirmPasswordTextName;
	@FindBy(name="agreeTerms")
	private static WebElement agreedCheckboxName;
	@FindBy(xpath="//div[@class='myButton']")
	private static WebElement submitButtonXpath;


	public SignUpPage1()
	{
		PageFactory.initElements(driver, this);
	}
	

	public SignUpPage2 basicFormOfRegistration(String edition,String firstName, String lastName, String email, String confirmEmail, String userName, String password, String confirmPassword)
	{
		ElementActions.selectValueFromDD(editionDropDownId, edition);
		ElementActions.enterText(firstNameTextName, firstName);
		ElementActions.enterText(lastNameTextName, lastName);
		ElementActions.enterText(emailTextName, email);
		ElementActions.enterText(confirmEmailTextName, confirmEmail);
		ElementActions.enterText(usernameTextName, userName);
		ElementActions.enterText(passwordTextName, password);
		ElementActions.enterText(confirmPasswordTextName, confirmPassword);
		ElementActions.click(agreedCheckboxName);
		ElementActions.click(submitButtonXpath);	
		return new SignUpPage2();
	}

}
