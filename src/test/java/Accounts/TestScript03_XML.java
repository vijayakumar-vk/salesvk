package Accounts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Generic.BaseXml;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestScript03_XML extends BaseXml {
	public Document document;
	@Parameters({"account","AccountName","Phone","Fax","Website","Industry","Type","Employees","AnnualRevenue","Description","BillingStreet",
		"BillingCity","BillingState","BillingZipCode","BillingCountry"})
	@Test(alwaysRun=true)
	public void open(String account,String AccountName,String Phone,String Fax, String Website,String Industry,String Type,String Employees,String AnnualRevenue,String Description,String BillingStreet,
			String BillingCity,String BillingState,String BillingZipCode,String BillingCountry) throws DocumentException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//GETTING ELEMENTS PATH FROM XML FILE
		saxReader = new SAXReader();
		document = saxReader.read(FileInput);
		String SrearchApp = document.selectSingleNode("//Test/HomePage/SearchAppsDot").getText();
		String ViewAll = document.selectSingleNode("//Test/HomePage/ViewAllButton").getText();
		String AppLauncherVerification = document.selectSingleNode("//Test/HomePage/AppLauncherVerification").getText();
		String SearchTextField = document.selectSingleNode("//Test/HomePage/SearchAppTextField").getText();
		String AccountsButton = document.selectSingleNode("//Test/HomePage/AccountsButton").getText();
		String RecentlyViewedVerification = document.selectSingleNode("//Test/HomePage/RecentlyViewedVerification").getText();
		String NewAccount = document.selectSingleNode("//Test/AccountsPage/NewAccountButton").getText();
		String NewAccountVerification = document.selectSingleNode("//Test/HomePage/NewAccountVerification").getText();
		String accountname = document.selectSingleNode("//Test/AccountsPage/AccountNameTextField").getText();
		String PhoneNumber = document.selectSingleNode("//Test/AccountsPage/PhoneNumber").getText();
		String fax= document.selectSingleNode("//Test/AccountsPage/Fax").getText();
		String website = document.selectSingleNode("//Test/AccountsPage/Website").getText();
		String type = document.selectSingleNode("//Test/AccountsPage/Type").getText();
		String prospect = document.selectSingleNode("//Test/AccountsPage/Prospect").getText();
		String industry = document.selectSingleNode("//Test/AccountsPage/Industry").getText();
		String finance = document.selectSingleNode("//Test/AccountsPage/Finance").getText();
		String employees = document.selectSingleNode("//Test/AccountsPage/Employees").getText();
		String annualRevenue = document.selectSingleNode("//Test/AccountsPage/AnnualRevenue").getText();
		String description = document.selectSingleNode("//Test/AccountsPage/Description").getText();
		String billingStreet = document.selectSingleNode("//Test/AccountsPage/BillingStreet").getText();
		String billingCity = document.selectSingleNode("//Test/AccountsPage/BillingCity").getText();
		String billingState = document.selectSingleNode("//Test/AccountsPage/BillingState").getText();
		String billingCountry = document.selectSingleNode("//Test/AccountsPage/BillingCountry").getText();
		String billingZipCode = document.selectSingleNode("//Test/AccountsPage/BillingZipCode").getText();
		String copyBillingAddressToShippingAddress = document.selectSingleNode("//Test/AccountsPage/CopyBillingAddressToShippingAddress").getText();
		String save = document.selectSingleNode("//Test/AccountsPage/Save").getText();
		
		
		//HOMEPAGE ACTIVITIES
		driver.findElement(By.xpath(SrearchApp)).click();
		driver.findElement(By.xpath(ViewAll)).click();
		
		//ASSERTION FOR APP LAUNCHER POP-UP
		Assert.assertEquals(driver.findElement(By.xpath(AppLauncherVerification)).getText(),"App Launcher","App Launcher POP-UP is not Displayed");
		Reporter.log("App Launcher POP-UP is Displayed",true);
		
		driver.findElement(By.xpath(SearchTextField)).sendKeys(account);
		driver.findElement(By.xpath(AccountsButton)).click();
		
		//ASSERTION FOR ACCOUNTS PAGE
		Assert.assertEquals(driver.findElement(By.xpath(RecentlyViewedVerification)).getText(), "Recently Viewed","Accounts Page Is Not Displayed");
		Reporter.log("AccountsPage is Displayed",true);
		
		//ACCOUNTPAGEACTIVITIES
		driver.findElement(By.xpath(NewAccount)).click();
		Thread.sleep(3000);
		
		//ASSERTION FOR NEW ACCOUNT POP-UP
		Assert.assertEquals(driver.findElement(By.xpath(NewAccountVerification)).getText(), "New Account","New Account Popup Is Not Displayed");
		Reporter.log("new Account popup is Displayed",true);
		
		//ENTERING DATAS IN THE POPUP
		driver.findElement(By.xpath(accountname)).sendKeys(AccountName);
		driver.findElement(By.xpath(PhoneNumber)).sendKeys(Phone);
		driver.findElement(By.xpath(website)).sendKeys(Website);
		driver.findElement(By.xpath(type)).click();
		driver.findElement(By.xpath(prospect)).click();
		driver.findElement(By.xpath(employees)).click();
		driver.findElement(By.xpath(industry)).click();
		driver.findElement(By.xpath(finance)).click();
		driver.findElement(By.xpath(employees)).sendKeys(Employees);
		driver.findElement(By.xpath(description)).sendKeys(Description);
		driver.findElement(By.xpath(billingStreet)).sendKeys(BillingStreet);
		driver.findElement(By.xpath(billingCity)).sendKeys(BillingCity);
		driver.findElement(By.xpath(billingState)).sendKeys(BillingState);
		driver.findElement(By.xpath(billingZipCode)).sendKeys(BillingZipCode);
		driver.findElement(By.xpath(billingCountry)).sendKeys(BillingCountry);
	    driver.findElement(By.xpath(copyBillingAddressToShippingAddress)).click();
	    driver.findElement(By.xpath(annualRevenue)).sendKeys(AnnualRevenue);
	    driver.findElement(By.xpath(fax)).sendKeys(Fax);
		driver.findElement(By.xpath(save)).click();
		
		//GETTING DATAS FOR ASSERTION
		String AccountNameVerification = document.selectSingleNode("//Test/AccountsPage/AccountNameVerification").getText();
		String PhoneVerification = document.selectSingleNode("//Test/AccountsPage/PhoneVerification").getText();
		String WebsiteVerification = document.selectSingleNode("//Test/AccountsPage/WebsiteVerification").getText();
		String IndustryVerification = document.selectSingleNode("//Test/AccountsPage/IndustryVerification").getText();
		String FaxVerification = document.selectSingleNode("//Test/AccountsPage/FaxVerification").getText();
		String TypeVerification = document.selectSingleNode("//Test/AccountsPage/TypeVerification").getText();
		String EmployeeVerification = document.selectSingleNode("//Test/AccountsPage/EmployeeVerification").getText();
		String AnnualRevenueVerification = document.selectSingleNode("//Test/AccountsPage/AnnualRevenueVerification").getText();
		String DescriptionVerification = document.selectSingleNode("//Test/AccountsPage/DescriptionVerification").getText();
		String BillingStreetVerification = document.selectSingleNode("//Test/AccountsPage/BillingStreetVerification").getText();
		String BillingCountryVerification = document.selectSingleNode("//Test/AccountsPage/BillingCountryVerification").getText();
		Thread.sleep(2000);
		
		//ASSERTION FOR NEWWELY CREATED ACCOUNT
		Assert.assertEquals(driver.findElement(By.xpath(AccountNameVerification)).getText(), AccountName,"New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(PhoneVerification)).getText(),  Phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3"),"New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(WebsiteVerification)).getText(), Website,"New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(IndustryVerification)).getText(), Industry,"New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(FaxVerification)).getText(), Fax.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3"),"New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(TypeVerification)).getText(), Type,"New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(EmployeeVerification)).getText(), Employees,"New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(AnnualRevenueVerification)).getText(), "$100,000,000","New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(DescriptionVerification)).getText(), Description,"New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(BillingStreetVerification)).getText(), BillingStreet,"New Account Is Not Created");
		Assert.assertEquals(driver.findElement(By.xpath(BillingCountryVerification)).getText(), BillingCountry,"New Account Is Not Created");
		Reporter.log("NewAccount is Created Successfully",true);
	
	}

}
