package com.qa.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;
import com.qa.pages.SignUpPage1;
import com.qa.pages.SignUpPage2;
import com.qa.utilities.ElementVerify;

public class SignUpPageTest extends TestBase
{
	LoginPage loginPage;
	SignUpPage1 signUpPage1;
	SignUpPage2 signUpPage2;

	public SignUpPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		signUpPage1 = new SignUpPage1();
		signUpPage2 = new SignUpPage2();
	}

	@Test
	public void signUpTestWithPositiveData()
	{
		loginPage.clickOnSignUpLink();
		signUpPage1.basicFormOfRegistration("1", "Shreya", "Patil","Shrey.Patil@gmail.com", "Shrey.Patil@gmail.com", "ShreyaPa","ShreyaPa", "ShreyaPa");
		signUpPage2.companyInfoForRegistration("Kwanta", "12313213","12313213", "Kwanta.com", "Kwanta.kwant@gmail.com","KwantaService", "Belapur", "Belapur", "Maharashtra", "400614","India");
		signUpPage2.verifySuccessfulSignUp();
		//ElementVerify.verifyURL(actualURL, expectedURL);
		
	}

	@AfterMethod
	public void tearDown()
	{
		closeCurrentBrowserTab();
	}

}
