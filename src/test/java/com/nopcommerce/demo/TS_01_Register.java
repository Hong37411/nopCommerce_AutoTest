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

public class TS_01_Register extends BaseTest {
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
	public void TC_01_RegisterWithEmptyData() {
		registerPage.clickToRegisterButton();
//		Assert.assertTrue(registerPage.isFirstnameErrorMessage("First name is required."));
//		Assert.assertTrue(registerPage.isLastnameErrorMessage("Last name is required."));
//		Assert.assertTrue(registerPage.isEmailErrorMessage("Email is required."));
		Assert.assertTrue(registerPage.isErrorMessage("FirstName", "First name is required."));
		Assert.assertTrue(registerPage.isErrorMessage("LastName", "Last name is required."));
		Assert.assertTrue(registerPage.isErrorMessage("Email", "Email is required."));
	}

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToEmailTextbox("abcxyz");
		registerPage.clickToRegisterButton();
//		Assert.assertTrue(registerPage.isEmailErrorMessage("Wrong email"));
		Assert.assertTrue(registerPage.isErrorMessage("Email", "Wrong email"));
		sleepInSecond(3);
	}

	@Test
	public void TC_03_RegisterWithValidInformation() {
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToFirstNameTextbox("Hong");
		registerPage.enterToLastNameTextbox("Hong");
		registerPage.enterToEmailTextbox(randomEmail);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		// enter data to dropdown
		registerPage.enterToDateDropdown("6");
		registerPage.enterToMonthDropdown("June");
		registerPage.enterToYearDropdown("2000");

		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isValidInformationMessage("Your registration completed"));
		registerPage.clickLogoutLink();
		homePage = new HomePageObject(driver);
		homePage.clickRegisterLink();
	}

	@Test
	public void TC_04_RegisterWithExistEmail() {
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToFirstNameTextbox("Hong");
		registerPage.enterToLastNameTextbox("Hong");
		registerPage.enterToEmailTextbox(randomEmail);
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("123456");

		registerPage.clickToRegisterButton();
		Assert.assertTrue(registerPage.isEmailExistMessage("The specified email already exists"));
	}

	@Test
	public void TC_05_RegisterWithPasswordLeast6Characters() {
//		registerPage.refreshCurrentPage(driver);
		registerPage.clickRegisterLink();
		registerPage.enterToFirstNameTextbox("Hong");
		registerPage.enterToLastNameTextbox("Hong");
		registerPage.enterToEmailTextbox("nthong.18it5@vku.udn.vn");
		registerPage.enterToPasswordTextbox("12345");
		registerPage.enterToConfirmPasswordTextbox("12345");
		registerPage.clickToRegisterButton();
//		Assert.assertTrue(registerPage.isPasswordLeast6Characters("Password must meet the following rules:"));
//		Assert.assertTrue(registerPage.isPasswordLeast6Characters("must have at least 6"));
		Assert.assertTrue(registerPage.isErrorMessage("Password", "Password must meet the following rules:"));
		Assert.assertTrue(registerPage.isErrorMessage("Password", "must have at least 6"));
	}

	@Test
	public void TC_06_RegisterWithConfirmPassword() {
		registerPage.refreshCurrentPage(driver);
		registerPage.enterToFirstNameTextbox("Hong");
		registerPage.enterToLastNameTextbox("Hong");
		registerPage.enterToEmailTextbox("nthong.18it5@vku.udn.vn");
		registerPage.enterToPasswordTextbox("123456");
		registerPage.enterToConfirmPasswordTextbox("654321");
		registerPage.clickToRegisterButton();
//		Assert.assertTrue(
//				registerPage.isPasswordConfirmPassword("The password and confirmation password do not match"));
		Assert.assertTrue(registerPage.isErrorMessage("ConfirmPassword", "The password and confirmation password do not match"));
	}

}
