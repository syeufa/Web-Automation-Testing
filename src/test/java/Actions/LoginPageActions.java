package Actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Locators.LoginPageLocators;
import utils.HelperClass;

public class LoginPageActions {

	LoginPageLocators loginPageLocators = null;

	public LoginPageActions() {
		this.loginPageLocators = new LoginPageLocators();
		PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);
	}

	public boolean isUsernameFieldDisplayed() {
		WebElement usernameField = loginPageLocators.usernameField;
		boolean isDisplayed = usernameField.isDisplayed();
		boolean isEmpty = usernameField.getText().isEmpty();
		String placeholderText = usernameField.getAttribute("placeholder");

		return isDisplayed && isEmpty && placeholderText.equals("Username");
	}

	public boolean isPasswordFieldDisplayed() {
		WebElement passwordField = loginPageLocators.passwordField;
		boolean isDisplayed = passwordField.isDisplayed();
		boolean isEmpty = passwordField.getText().isEmpty();
		String placeholderText = passwordField.getAttribute("placeholder");

		return isDisplayed && isEmpty && placeholderText.equals("Password");
	}

	public boolean isLogoDisplayed() {
		return loginPageLocators.logoSwaLabs.isDisplayed();
	}

	// action to input data credential
	public void inputCredetial(String username, String password) {
		loginPageLocators.usernameField.sendKeys(username);
		loginPageLocators.passwordField.sendKeys(password);
	}

	// action to click login button
	public void clickLoginButton() {
		loginPageLocators.buttonLogin.click();
	}

	// action to get error message when invalid credential
	public String getErrorMessage() {
		return (loginPageLocators.errorField.getText());
	}

	public boolean isRedXFieldUsernameDisplayed() {
		return (loginPageLocators.xIconUsername.isDisplayed());

	}

	public boolean isRedXFieldPasswordDisplayed() {
		return (loginPageLocators.xIconPassword.isDisplayed());

	}

	public String getCurrentUrl() {
		String currentUrl = HelperClass.getDriver().getCurrentUrl();
		return currentUrl;
	}

	public boolean isErrorFieldUsername() {
		WebElement fieldUsername = loginPageLocators.usernameField;
		boolean hasErrorClass = fieldUsername.getAttribute("class").contains("input_error");

		return hasErrorClass;
	}

	public boolean isUsernamePlaceholderRed() {
		WebElement fieldUsername = loginPageLocators.usernameField;
		String placeholderColor = fieldUsername.getCssValue("color");
		System.out.println(placeholderColor);

		return placeholderColor.equalsIgnoreCase("rgba(226, 35, 26, 1)")
				|| placeholderColor.equalsIgnoreCase("#e2231a");
	}

	public boolean isErrorFieldPassword() {
		WebElement fieldPassword = loginPageLocators.passwordField;
		boolean hasErrorClass = fieldPassword.getAttribute("class").contains("input_error");

		return hasErrorClass;
	}

	public boolean isPasswordPlaceholderRed() {
		WebElement fieldPassword = loginPageLocators.passwordField;
		String placeholderColor = fieldPassword.getCssValue("color");
		System.out.println(placeholderColor);

		return placeholderColor.equalsIgnoreCase("#e2231a");
	}

}