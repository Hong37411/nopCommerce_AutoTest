package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.RegisterPageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}
	
	
	public void clickLogInLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
	}
	
	public MyAccountPageObject clickMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return new MyAccountPageObject(driver);
	}
	public SearchPageObject clickSearchButton() {
		waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON);
		clickToElement(driver, HomePageUI.SEARCH_BUTTON);
		return new SearchPageObject(driver);
	}
	public void enterToSearchTextbox(String firstname) {
		waitForElementVisible(driver, HomePageUI.SEARCH_TEXTBOX);
		sendKeysToElement(driver, HomePageUI.SEARCH_TEXTBOX, firstname);
	}
	public SearchPageObject clickSearchLink() {
		waitForElementClickable(driver, HomePageUI.SEARCH_LINK_FOOTER);
		clickToElement(driver, HomePageUI.SEARCH_LINK_FOOTER);
		return new SearchPageObject(driver);
	}
	///click tu dong
	public void clickDynamicLink(String value){
        waitForElementClickable(driver, HomePageUI.DYNAMIC_LINK, value);
        clickToElement(driver, HomePageUI.DYNAMIC_LINK, value);
    }
}
