package Locators;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocators {
    
    @FindBy(id = "user-name")
	public WebElement usernameField;

    @FindBy(id = "password")
	public WebElement passwordField;

    @FindBy(xpath = "//input[@type = \"submit\"]")
	public WebElement buttonLogin;

    @FindBy(className = "login_logo")
    public WebElement logoSwaLabs;

    @FindBy(xpath = "(//*[contains(@class, 'svg-inline--fa fa-times-circle fa-w-16 error_icon')])[1]")
    public WebElement xIconUsername;

    @FindBy(xpath = "(//*[contains(@class, 'svg-inline--fa fa-times-circle fa-w-16 error_icon')])[2]")
    public WebElement xIconPassword;

    @FindBy(className = "error-message-container")
    public WebElement errorField;
}
