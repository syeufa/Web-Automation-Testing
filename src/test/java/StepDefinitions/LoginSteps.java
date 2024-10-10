package StepDefinitions;

import org.junit.Assert;

import Actions.LoginPageActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.HelperClass;

public class LoginSteps {

	LoginPageActions objLogin = new LoginPageActions();
	String url = "https://www.saucedemo.com/";

	@Given("User has opened swag labs browser")
	public void user_has_opened_swag_labs_browser() throws InterruptedException {
		HelperClass.openPage(url);
		Thread.sleep(2000);
	}

	@Then("There are fields for inputting username and password that have not been filled in")
	public void there_are_fields_for_inputting_username_and_password_that_have_not_been_filled_in() {
		Assert.assertTrue(objLogin.isPasswordFieldDisplayed());
		Assert.assertTrue(objLogin.isUsernameFieldDisplayed());
	}

	@Then("There is a Swag Labs logo name")
	public void there_is_a_swag_labs_logo_name() {
		Assert.assertTrue(objLogin.isLogoDisplayed());
	}

	@When("User enter username as {string} and password as {string}")
	public void user_enter_username_as_and_passwrod_as(String username, String password) {
		objLogin.inputCredetial(username, password);
	}

	@When("User click login button")
	public void user_click_login_button() {
		objLogin.clickLoginButton();
	}

	@Then("User should be able to see Dashboard Page")
	public void user_should_be_able_to_see_dashboard_page() {
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", objLogin.getCurrentUrl());
	}

	@Then("Showing symbol red x in the {string}")
	public void showing_symbol_red_x_in_the(String field) {
		boolean isRedXDisplayed = false;

		if (field.equals("both")) {
			isRedXDisplayed = objLogin.isRedXFieldPasswordDisplayed() && objLogin.isRedXFieldUsernameDisplayed();
		} else if (field.equals("username")) {
			isRedXDisplayed = objLogin.isRedXFieldUsernameDisplayed();
		} else if (field.equals("password")) {
			isRedXDisplayed = objLogin.isRedXFieldPasswordDisplayed();
		}

		Assert.assertTrue(isRedXDisplayed);
	}

	@Then("Showing Error message {string}")
	public void showing_error_message(String expectedErrorMessage) {
		String actualErrorMessage = objLogin.getErrorMessage();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}

	@Then("Stay on the login page")
	public void stay_on_the_login_page() {
		Assert.assertEquals("https://www.saucedemo.com/", objLogin.getCurrentUrl());
	}

	@Then("The label and border in the {string} field are red")
	public void the_label_and_border_in_the_field_are_red(String field) {
	    boolean isLabelBorderRed = false;
	    LoginPageActions objLogin = new LoginPageActions();

	    if (field.equals("both")) {
	        isLabelBorderRed = objLogin.isErrorFieldUsername()
	                && objLogin.isErrorFieldPassword();
	    } else if (field.equals("username")) {
	        isLabelBorderRed = objLogin.isErrorFieldUsername();
	    } else if (field.equals("password")) {
	        isLabelBorderRed = objLogin.isErrorFieldPassword();
	    }

	    Assert.assertTrue("The label and border in the " + field + " field are not red", isLabelBorderRed);
	}

}
