package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;
import pageUIs.MyAccountPageUI;
import pageUIs.RegisterPageUI;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	// constructor
	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToFirstNameTextbox(String firstname) {
        waitForElementVisible(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX, firstname);
    }
    
    public void enterToLastNameTextbox(String lastname) {
        waitForElementVisible(driver, MyAccountPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, MyAccountPageUI.LASTNAME_TEXTBOX, lastname);
    }
    
    public void enterToEmailTextbox(String email) {
        waitForElementVisible(driver, MyAccountPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, MyAccountPageUI.EMAIL_TEXTBOX, email);
    }
    
    public void clickToSaveButton() {
        waitForElementClickable(driver, MyAccountPageUI.SAVE_BUTTON);
        clickToElement(driver, MyAccountPageUI.SAVE_BUTTON);
    }
    public void clickToAddressSaveButton() {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);
        clickToElement(driver, MyAccountPageUI.ADDRESS_SAVE_BUTTON);
    }
    public void clickToAddressEditButton() {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESS_EDIT_BUTTON);
        clickToElement(driver, MyAccountPageUI.ADDRESS_EDIT_BUTTON);
    }
    
    
    public boolean isPageTitle(String value) {
		String message = getTextOfElement(driver, MyAccountPageUI.PAGE_TITLE);
		return message.contains(value);
	}
    
    public String getFirstNameValue(String name) {
    	return getAttributeValue(driver, MyAccountPageUI.FIRSTNAME_TEXTBOX, name);
    }
    
    public String getLastNameValue(String name) {
    	return getAttributeValue(driver, MyAccountPageUI.LASTNAME_TEXTBOX, name);
    }
    public void clickToAddressTab() {
        waitForElementClickable(driver, MyAccountPageUI.ADDRESS_TAB);
        clickToElement(driver, MyAccountPageUI.ADDRESS_TAB);
    }
    public void clickToAddAddressButton() {
        waitForElementClickable(driver, MyAccountPageUI.ADD_ADDRESS_BUTTON);
        clickToElement(driver, MyAccountPageUI.ADD_ADDRESS_BUTTON);
    }
    
    public void enterToAddressFirstNameTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX, firstname);
	}
    public String getAddressFirstNameValue(String name) {
    	return getAttributeValue(driver, MyAccountPageUI.ADDRESS_FIRSTNAME_TEXTBOX, name);
    }
    
    public void enterToAddressLastNameTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_LASTNAME_TEXTBOX);
		sendKeysToElement(driver, MyAccountPageUI.ADDRESS_LASTNAME_TEXTBOX, firstname);
	}
    public String getAddressLastNameValue(String name) {
    	return getAttributeValue(driver, MyAccountPageUI.ADDRESS_LASTNAME_TEXTBOX, name);
    }
    public void enterToAddressEmailTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX);
		sendKeysToElement(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, firstname);
	}
    public String getAddressEmailValue(String name) {
    	return getAttributeValue(driver, MyAccountPageUI.ADDRESS_EMAIL_TEXTBOX, name);
    }
    
    public void enterToAddressCityTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_CITY);
		sendKeysToElement(driver, MyAccountPageUI.ADDRESS_CITY, firstname);
	}
    public String getAddressCityValue(String name) {
    	return getAttributeValue(driver, MyAccountPageUI.ADDRESS_CITY, name);
    }
    
    public void enterToAddress1Textbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_ADDRESS1);
		sendKeysToElement(driver, MyAccountPageUI.ADDRESS_ADDRESS1, firstname);
	}
    public void enterToAddressZipTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_ZIP_POSTAL);
		sendKeysToElement(driver, MyAccountPageUI.ADDRESS_ZIP_POSTAL, firstname);
	}
    public void enterToAddressPhoneNumberTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.ADDRESS_PHONE_NUMBER);
		sendKeysToElement(driver, MyAccountPageUI.ADDRESS_PHONE_NUMBER, firstname);
	}
    public void enterToCountryDropdown(String value) {
		selectDropdownByText(driver, MyAccountPageUI.ADDRESS_COUNTRY, value);
	}
    public boolean isAddressNoDataMessage(String value) {
		String message = getTextOfElement(driver, MyAccountPageUI.ADDRESS_NO_DATA_MESSGAGE);
		return message.contains(value);
	}
   /// CHANGE PASS
    public void clickToChangePassTab() {
        waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_TAB);
        clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_TAB);
    }
    public void enterToOldPasswordTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, MyAccountPageUI.OLD_PASSWORD_TEXTBOX, firstname);
	}
    public void enterToNewPasswordTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, MyAccountPageUI.NEW_PASSWORD_TEXTBOX, firstname);
	}
    public void enterToConfirmPasswordTextbox(String firstname) {
		waitForElementVisible(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, MyAccountPageUI.CONFIRM_PASSWORD_TEXTBOX, firstname);
	}
    
    public void clickToChangePassButton() {
        waitForElementClickable(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver, MyAccountPageUI.CHANGE_PASSWORD_BUTTON);
    }
    public void clickToLogOutLink() {
        waitForElementClickable(driver, MyAccountPageUI.LOGOUT_LINK);
        clickToElement(driver, MyAccountPageUI.LOGOUT_LINK);
    }
    public boolean isBarNotificationMessage(String value) {
		String message = getTextOfElement(driver, MyAccountPageUI.BAR_NOTIFICATION_MESSGAGE);
		return message.contains(value);
	}
    public void clickToCloseBarNotification() {
        waitForElementClickable(driver, MyAccountPageUI.BAR_NOTIFICATION_CLOSE_BUTON);
        clickToElement(driver, MyAccountPageUI.BAR_NOTIFICATION_CLOSE_BUTON);
    }
    
    

}
