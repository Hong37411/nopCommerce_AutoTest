package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BasePage;
import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import utils.DataHelper;

public class TS_DataFakerTest extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DataHelper data;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		loginPage = new LoginPageObject(driver);

	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	@Test
	public void TC_01_GetData() {
		data = DataHelper.getData();
		System.out.println("Data random: ");
		System.out.println(data.getFirstName());
		System.out.println(data.getLastName());
		System.out.println(data.getEmail());
		System.out.println(data.getCreditCard());
		System.out.println(data.getFullAddress());
		System.out.println(data.getSecondaryAddress());
	}

}
