package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class TS_00_Preconditions extends BaseTest{
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	String randomEmail;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		registerPage = new RegisterPageObject(driver);
		randomEmail = getRandomEmail();
		System.out.println("email using:" + randomEmail);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void TC_00_RegisterAnUserValid() {
		// Test case dùng để tạo 1 account cố định xài cho những test case khác
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToFirstNameTextbox("Hong");
		registerPage.enterToLastNameTextbox("Hong");
		registerPage.enterToEmailTextbox(GlobalConstants.username);
		registerPage.enterToPasswordTextbox(GlobalConstants.password);
		registerPage.enterToConfirmPasswordTextbox(GlobalConstants.password);

		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isValidInformationMessage("Your registration completed"));
		registerPage.clickLogoutLink();
		homePage = new HomePageObject(driver);
		homePage.clickRegisterLink();
	}

}
