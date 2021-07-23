package Generic;

import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import PomPages.AccountsPage;
import PomPages.HomePage;
import PomPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public HomePage homepage;
	public AccountsPage accountspage;
	public ScreenShots screenshot;
	@Parameters({"url"})
	@BeforeTest
	public void LaunchingBrowser(String url) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);	
	}
	@Parameters({"username","password",})
	@BeforeMethod(alwaysRun = true)
	public void Login(String username,String password) throws InterruptedException, IOException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		LoginPage login = new LoginPage(driver);
		login.getUsernameTextfield().sendKeys(username);
		login.getPasswordTextfield().sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.name("rememberUn")).click();
		login.getLoginButton().click();
		//ASSERTING LOGIN PAGE
		String ExpectedTitle="Home | Salesforce";
		Thread.sleep(35000);
		Assert.assertEquals(driver.getTitle(),ExpectedTitle,"Loginpage is not Successfull");
		Reporter.log("LOGINPAGE IS SUCCECFULL AND LANDED IN DASHBOARD",true);

		Thread.sleep(5000);

	}


	@AfterMethod(alwaysRun=true)
	public void Logout(ITestResult result) throws InterruptedException, IOException {
		int	status = result.getStatus();
		if(status==2) {
			ScreenShots screenshot = new ScreenShots();
			screenshot.take(driver, result);
		}

		homepage = new HomePage(driver);
		Actions a = new Actions(driver);
		a.moveToElement(homepage.getUserButton()).click().perform();
		a.moveToElement(homepage.getLogoutButton()).click().perform();
		//Assertion for Logout

		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(),"Login | Salesforce","Logout is Not Done Successfully ");
		Reporter.log("Logout Is Successfull And landed in Login Page");

	}
	@AfterTest
	public void ClosingBrowser() {
		driver.close();
	}

}

