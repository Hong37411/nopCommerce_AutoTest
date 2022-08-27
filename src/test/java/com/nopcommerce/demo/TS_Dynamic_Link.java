package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class TS_Dynamic_Link extends BaseTest {
	WebDriver driver;
	RegisterPageObject registerPage;
	HomePageObject homePage;
	

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
		
		registerPage = new RegisterPageObject(driver);
		homePage = new HomePageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void testDynamicLink() {
		homePage.clickDynamicLink("register");
        homePage.clickDynamicLink("login");
        homePage.clickDynamicLink("wishlist");
        homePage.clickDynamicLink("cart");
	}
	@Test
	public void testDynamicMessage() {
		homePage.clickDynamicLink("register");
		Assert.assertTrue(registerPage.isErrorMessage("FirstName", "First name is required."));
		Assert.assertTrue(registerPage.isErrorMessage("LastName", "Last name is required."));
		Assert.assertTrue(registerPage.isErrorMessage("Email", "Email is required."));
//		Assert.assertTrue(registerPage.isLastnameErrorMessage("Last name is required."));
//		Assert.assertTrue(registerPage.isEmailErrorMessage("Email is required."));
	}

}
