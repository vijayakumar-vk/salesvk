package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy (xpath="//div[@class='slds-icon-waffle']")
	private WebElement SearchApps; 
	

	@FindBy (xpath="//button[text()='View All']")
	private WebElement ViewAllButton;
	

	@FindBy (xpath="//h2[text()='App Launcher']")
	private WebElement AppLauncherIconVerification;
	

	@FindBy (xpath="//input[@placeholder='Search apps or items...']")
	private WebElement SearchTextField;
	

	@FindBy (xpath="//mark[text()='Accounts']")
	private WebElement AccountsButton;
	
	
	@FindBy (xpath="//img[@class='icon noicon']")
    private WebElement UserButton;
	
	
	@FindBy (xpath="//a[text()='Log Out']")
	private WebElement LogoutButton;
	
	

	public WebElement getSearchApps() {
		return SearchApps;
	}


	public WebElement getViewAllButton() {
		return ViewAllButton;
	}


	public WebElement getAppLauncherIconVerification() {
		return AppLauncherIconVerification;
	}


	public WebElement getSearchTextField() {
		return SearchTextField;
	}


	public WebElement getAccountsButton() {
		return AccountsButton;
	}
	
	
	public WebElement getUserButton() {
		return UserButton;
	}


	public WebElement getLogoutButton() {
		return LogoutButton;
	}

	
	
	
	
	

}
