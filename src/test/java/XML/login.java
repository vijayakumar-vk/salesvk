package XML;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class login {
	
	@Test
	public void login() throws DocumentException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		File FileInput = new File("/home/onebill/eclipse-workspacevk/Salesforce/src/main/resources/DATA.xml");
		SAXReader sxr = new SAXReader();
		Document doc = sxr.read(FileInput);
		driver.findElement(By.id(doc.selectSingleNode("//Test/LoginPage/UsernameTextField").getText())).sendKeys("dgfghjj");
		
	}

}
