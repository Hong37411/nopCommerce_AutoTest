package com.nopcommerce.demo;

import java.io.IOException;

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
import utils.ExcelUtil;

public class TS_DataDrivenExcel extends BaseTest{
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
//	String randomEmail;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);
//		randomEmail = getRandomEmail();
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	@Test
	public void TC_01_LoginWithExcelFile() throws IOException  {
		ExcelUtil.setExcelFile("Auto");
		
		String excelUserName = ExcelUtil.getCellData(1, 1);
		String excelPassword = ExcelUtil.getCellData(1, 2);
		System.out.println("Account using: " + excelUserName + "," + excelPassword);
		
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox(excelUserName);
		loginPage.enterToPasswordTextbox(excelPassword);
		homePage = loginPage.clickToLoginButton();
		
//		Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");
		
		String homePageUrl = homePage.getPageUrl(driver);	
		if (homePageUrl.equals("https://demo.nopcommerce.com/")) {
			ExcelUtil.setCellData("Pass", 1, 3);
		}else{
			ExcelUtil.setCellData("Fail", 1, 3);
		}
		
	}
}