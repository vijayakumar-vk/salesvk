package Generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import PomPages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseXml {
	public static WebDriver driver;
	public File FileInput = new File("/home/onebill/eclipse-workspacevk/Salesforce/src/main/resources/DATA.xml");
	public SAXReader saxReader;
	public Document document;
	public ScreenShots screenshot;
	@Parameters({"url"})
	@BeforeTest(alwaysRun = true)
	public void LaunchingBrowser(String url) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);	
	}
	@Parameters({"username","password"})
	@BeforeMethod(alwaysRun = true)
	public void Login(String username,String password) throws InterruptedException, IOException, DocumentException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SAXReader saxReader = new SAXReader();
		document = saxReader.read(FileInput);
		String Username = document.selectSingleNode("//Test/LoginPage/UsernameTextField").getText();
		String Password = document.selectSingleNode("//Test/LoginPage/PasswordtextField").getText();
		String Login = document.selectSingleNode("//Test/LoginPage/LoginButton").getText();
		driver.findElement(By.id(Username)).sendKeys(username);
		driver.findElement(By.id(Password)).sendKeys(password);
		driver.findElement(By.id(Login)).click();
		//ASSERTING LOGIN PAGE
		String ExpectedTitle="Home | Salesforce";
		Thread.sleep(35000);
		Assert.assertEquals(driver.getTitle(),ExpectedTitle,"Loginpage is not Successfull");
		Reporter.log("LOGINPAGE IS SUCCECFULL AND LANDED IN DASHBOARD",true);

	}


	@AfterMethod
	public void Logout(ITestResult result) throws DocumentException, IOException {
		int	status = result.getStatus();
		if(status==2) {
			ScreenShots screenshot = new ScreenShots();
			screenshot.take(driver, result);
		}
		saxReader = new SAXReader();
		document = saxReader.read(FileInput);

		String UserButton = document.selectSingleNode("//Test/HomePage/UserButton").getText();
		String LogoutButton = document.selectSingleNode("//Test/HomePage/LogoutButton").getText();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(UserButton))).click().perform();
		action.moveToElement(driver.findElement(By.xpath(LogoutButton))).click().perform();
		Assert.assertEquals(driver.getTitle(),"Login | Salesforce","Logout is Not Done Successfully ");
		Reporter.log("Logout Is Successfull And landed in Login Page");
	}


	@AfterTest
	public void ClosingBrowser() {
		driver.close();
	}

}
