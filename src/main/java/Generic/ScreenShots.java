package Generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class ScreenShots  {
	
	
	public void take(WebDriver driver,ITestResult result) throws IOException {
		String ldt = LocalDateTime.now().toString().replace(":", "-");
	TakesScreenshot takescreenshot = (TakesScreenshot)driver;
	File destination = takescreenshot.getScreenshotAs(OutputType.FILE);
	File source = new File("/home/onebill/eclipse-workspacevk/Salesforce/error/"+result.getMethod().getMethodName()+""+ldt+"pic.png");
	FileUtils.copyFile(destination, source);
	
	
	}
}
