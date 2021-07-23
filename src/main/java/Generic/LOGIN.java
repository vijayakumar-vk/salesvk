package Generic;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LOGIN {
	public WebDriver driver;
	@Parameters({"browser","url"})
	@BeforeTest
	public void LaunchingBrowser(String browser,String url) {
		if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(url);	
	}
	@Parameters({"username","password"})
	@Test
	public void Login(String username,String password) throws DocumentException, InterruptedException {
		File FileInput = new File("/home/onebill/eclipse-workspacevk/Salesforce/src/main/resources/DATA.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(FileInput);
		
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

}
