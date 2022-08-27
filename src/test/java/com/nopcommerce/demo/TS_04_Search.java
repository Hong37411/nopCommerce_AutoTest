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
import pageObjects.SearchPageObject;

public class TS_04_Search extends BaseTest{
	WebDriver driver;
	SearchPageObject searchPage;
	LoginPageObject loginPage;
	HomePageObject homePage;
	MyAccountPageObject myAccountPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
//	TC_01: Search với empty data
//	o	Verify error message xuất hiện: Search term minimum length is 3 characters
	@Test
	public void TC_01_SearchWithEmptyData() {
		loginPage = new LoginPageObject(driver);
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox(GlobalConstants.username);
		loginPage.enterToPasswordTextbox(GlobalConstants.password);
		
		homePage = loginPage.clickToLoginButton();
		Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");
		
		searchPage = homePage.clickSearchLink();
		Assert.assertTrue(searchPage.isPageTitle("Search"));
		
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isSearchErrorMessage("Search term minimum length is 3 characters"));
		sleepInSecond(3);
	}
//	TC_02: Search với data không tồn tại, ví dụ: Macbook Pro 2040
//	o	Verify error message xuất hiện: No products were found that matched your criteria
	@Test
	public void TC_02_SearchWithNoData() {
		searchPage.refreshCurrentPage(driver);
		searchPage.enterToSearchTextbox("Macbook Pro 2040");
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isSearchMessage("No products were found that matched your criteria"));
//		sleepInSecond(3);
		
	}
//	TC_03: Search với keyword: Lenovo
	@Test
	public void TC_03_SearchWithKeyword() {
		searchPage.refreshCurrentPage(driver);
		searchPage.enterToSearchTextbox("Lenovo");
		searchPage.clickSearchButton();
//		Assert.assertTrue(searchPage.isSearchSP1("Lenovo IdeaCentre 600 All-in-One PC"));
//		Assert.assertTrue(searchPage.isSearchSP1("Lenovo Thinkpad X1 Carbon Laptop"));
		sleepInSecond(3);
	}
//	TC_04: Advance Search với Parent Categories
	@Test
	public void TC_04_SearchAdvanceWithParentCategories() {
		searchPage.refreshCurrentPage(driver);
		searchPage.enterToSearchTextbox("Apple Macbook Pro");
		searchPage.clickSearchAdvanceCheckbox();
		searchPage.enterToSearchCategoryDropdown("Computers");
		searchPage.clickSearchButton();
		Assert.assertTrue(searchPage.isSearchMessage("No products were found that matched your criteria"));
		
		sleepInSecond(3);
	}
//	TC_05: Advance Search với Sub Categories
	@Test
	public void TC_05_SearchAdvanceWithSubCategories() {
		searchPage.refreshCurrentPage(driver);
		searchPage.enterToSearchTextbox("Apple Macbook Pro");
		searchPage.clickSearchAdvanceCheckbox();
		searchPage.enterToSearchCategoryDropdown("Computers");
		searchPage.clickSearchAutomationCheckbox();
		searchPage.clickSearchButton();
		
		
		sleepInSecond(3);
	}
}
