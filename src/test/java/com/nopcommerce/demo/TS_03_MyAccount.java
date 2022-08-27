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
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;

public class TS_03_MyAccount extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	MyAccountPageObject myAccountPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		myAccountPage = new MyAccountPageObject(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

//  TC_01: Ở tab Customer Info, update thông tin của Customer, save lại
	@Test
	public void TC_01_updateMyAccountCustomerInfo() {
		loginPage = new LoginPageObject(driver);
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox(GlobalConstants.username);
		loginPage.enterToPasswordTextbox(GlobalConstants.password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");
		myAccountPage = homePage.clickMyAccountLink();
		
		Assert.assertTrue(myAccountPage.isPageTitle("My account - Customer info"));
		myAccountPage.enterToFirstNameTextbox("Hong1");
		myAccountPage.enterToLastNameTextbox("Nong");
		myAccountPage.enterToEmailTextbox(GlobalConstants.username);
		myAccountPage.clickToSaveButton();
		
		Assert.assertEquals(myAccountPage.getFirstNameValue("value"), "Hong1");
		Assert.assertEquals(myAccountPage.getLastNameValue("value"), "Nong");
		
//		sleepInSecond(3);
	}
//	TC_02: Ở tab Addresses, add Address với thông tin tuỳ thích, save lại
	@Test
	public void TC_02_updateAddressMyAccount() {
		myAccountPage.clickToAddressTab();
		Assert.assertTrue(myAccountPage.isPageTitle("My account - Addresses"));
//		Assert.assertTrue(myAccountPage.isAddressNoDataMessage("No addresses"));
		myAccountPage.clickToAddAddressButton();
		Assert.assertTrue(myAccountPage.isPageTitle("My account - Add new address"));
		
		myAccountPage.enterToAddressFirstNameTextbox("Hong");
		myAccountPage.enterToAddressLastNameTextbox("Nong");
		myAccountPage.enterToAddressEmailTextbox(GlobalConstants.username);
		myAccountPage.enterToCountryDropdown("Algeria");
		myAccountPage.enterToAddressCityTextbox("ABCXYZ");
		myAccountPage.enterToAddress1Textbox("Da Nang");
		myAccountPage.enterToAddressZipTextbox("abc");
		myAccountPage.enterToAddressPhoneNumberTextbox("12345678");
		myAccountPage.clickToAddressSaveButton();
		myAccountPage.clickToAddressEditButton();
		
		Assert.assertEquals(myAccountPage.getAddressFirstNameValue("value"), "Hong");
		Assert.assertEquals(myAccountPage.getAddressLastNameValue("value"), "Nong");
		Assert.assertEquals(myAccountPage.getAddressCityValue("value"),"ABCXYZ");
		Assert.assertEquals(myAccountPage.getAddressEmailValue("value"),GlobalConstants.username);
		sleepInSecond(3);
	}
//	TC_03: Ở tab Change password, update password mới, sau đó logout rồi login lại
	@Test
	public void TC_03_updatePasswordMyAccount() {
		myAccountPage.clickToChangePassTab();
		Assert.assertTrue(myAccountPage.isPageTitle("My account - Change password"));
		myAccountPage.enterToOldPasswordTextbox(GlobalConstants.password);
		myAccountPage.enterToNewPasswordTextbox(GlobalConstants.newPassword);
		myAccountPage.enterToConfirmPasswordTextbox(GlobalConstants.newPassword);
		myAccountPage.clickToChangePassButton();
		Assert.assertTrue(myAccountPage.isBarNotificationMessage("Password was changed"));
		myAccountPage.clickToCloseBarNotification();
		
		myAccountPage.clickToLogOutLink();
		homePage.clickLogInLink();
		loginPage.enterToEmailTextbox(GlobalConstants.username);
		loginPage.enterToPasswordTextbox(GlobalConstants.password);
		
		loginPage.enterToPasswordTextbox(GlobalConstants.newPassword);
		sleepInSecond(3);
	}
}
