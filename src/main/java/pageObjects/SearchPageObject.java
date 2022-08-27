package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.MyAccountPageUI;
import pageUIs.RegisterPageUI;
import pageUIs.SearchPageUI;

public class SearchPageObject extends BasePage{
WebDriver driver;
	
	public SearchPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isPageTitle(String value) {
		String message = getTextOfElement(driver, SearchPageUI.PAGE_TITLE);
		return message.contains(value);
	}
	/////////
	public boolean isSearchErrorMessage(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_ERROR_MESSAGE);
		return message.contains(value);
	}
	
	public void enterToSearchTextbox(String firstname) {
		waitForElementVisible(driver, SearchPageUI.SEARCH_TEXTBOX);
		sendKeysToElement(driver, SearchPageUI.SEARCH_TEXTBOX, firstname);
	}
	public void clickSearchButton() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, SearchPageUI.SEARCH_BUTTON);
	}
	public boolean isSearchMessage(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_MESSAGE);
		return message.contains(value);
	}
	public boolean isSearchSP1(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_SP1);
		return message.contains(value);
	}
	public boolean isSearchSP2(String value) {
		String message = getTextOfElement(driver, SearchPageUI.SEARCH_SP2);
		return message.contains(value);
	}
	public void clickSearchAdvanceCheckbox() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_ADVANCE_CHECKED);
		clickToElement(driver, SearchPageUI.SEARCH_ADVANCE_CHECKED);
	}
	public void clickSearchAutomationCheckbox() {
		waitForElementClickable(driver, SearchPageUI.SEARCH_AUTOMATION_CHECKED);
		clickToElement(driver, SearchPageUI.SEARCH_AUTOMATION_CHECKED);
	}
	public void enterToSearchCategoryDropdown(String value) {
		selectDropdownByText(driver, SearchPageUI.SEARCH_CATEGORY_DROPDOWN, value);
	}
	
	

}
