package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="username")
	private WebElement UsernameTextfield;

	@FindBy(id="password")
	private WebElement PasswordTextfield;

	@FindBy(id="Login")
	private WebElement LoginButton;

	public WebElement getUsernameTextfield() {
		return UsernameTextfield;
	}

	public WebElement getPasswordTextfield() {
		return PasswordTextfield;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}


}
