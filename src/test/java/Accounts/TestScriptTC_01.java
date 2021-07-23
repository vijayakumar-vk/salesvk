package Accounts;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Generic.BaseClass;
import PomPages.AccountsPage;
import PomPages.HomePage;
import testing.Revenue;

public class TestScriptTC_01 extends BaseClass{
	public Revenue annualrevenue;
	@Parameters({"account","AccountName","Phone","Fax","Website","Employees","AnnualRevenue","Description","BillingStreet",
		"BillingCity","BillingState","BillingZipCode","BillingCountry"})
	@Test
	public void open(String account,String AccountName,String Phone,String Fax, String Website,String Employees,String AnnualRevenue,String Description,String BillingStreet,
			String BillingCity,String BillingState,String BillingZipCode,String BillingCountry) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		homepage = new HomePage(driver);
	
		homepage.getSearchApps().click();
		homepage.getViewAllButton().click();
		Thread.sleep(2000);
		
		
		//ASSERTION FOR APP LAUNCHER
		Assert.assertEquals(homepage.getAppLauncherIconVerification().getText(),"App Launcher","App Launcher POP-UP is not Displayed");
		Reporter.log("App Launcher POP-UP is Displayed",true);
		homepage.getSearchTextField().sendKeys(account);
		Thread.sleep(3000);
		homepage.getAccountsButton().click();

		accountspage = new AccountsPage(driver);
		//ASERTION FOR ACCOUNTS PAGE
		Assert.assertEquals(accountspage.getRecentlyViewedTextverification().getText(), "Recently Viewed","Accounts Page Is Not Displayed");
		Reporter.log("AccountsPage is Displayed",true);
        

		accountspage.getNewAccountbutton().click();
		//ASSSERTION FOR NEWACCOUNT POPUP
		Assert.assertEquals(accountspage.getNewAccountverification().getText(),"New Account","New Account Pop Up is not Displayed");
		Reporter.log("NewAccount Pop up is Displayed",true);

		//ENTERING DATAS IN NEWACCOUNT POPUP
		accountspage.getAccountsName().sendKeys(AccountName);
		accountspage.getPhone().sendKeys(Phone);
	//	accountspage.getFax().sendKeys(Fax);
		accountspage.getWebsite().sendKeys(Website);
		Thread.sleep(20000);
		accountspage.getType().click();
		accountspage.getProspect().click();
		accountspage.getEmployees().click();
		accountspage.getIndustry().click();
		accountspage.getFinance().click();


		accountspage.getEmployees().click();
		accountspage.getEmployees().sendKeys(Employees);
	//	accountspage.getAnnualRevenue().sendKeys(AnnualRevenue);
		accountspage.getDescription().sendKeys(Description);
		accountspage.getBillingStreet().sendKeys(BillingStreet);
		accountspage.getBillingCity().sendKeys(BillingCity);
		accountspage.getBillingState().sendKeys(BillingState);
		accountspage.getBillingZipcode().sendKeys(BillingZipCode);
		accountspage.getBillingCountry().sendKeys(BillingCountry);
	//	accountspage.getCopyBillingAddressToShippingAddress().click();
	    accountspage.getSavebutton().click();
        Thread.sleep(15000);
		
		//ASSERTION FOR NEWLY CREATED ACCOUNT
		Assert.assertEquals(accountspage.getAccountNameVerification().getText(), AccountName,"New Account Is Not Created");
		Assert.assertEquals(accountspage.getPhoneVerification().getText(),Phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3"),"New Account Is Not Created");
		Assert.assertEquals(accountspage.getWebsiteverification().getText(), Website,"New Account Is Not Created");
	//	Assert.assertEquals(accountspage.getFaxVerification().getText(),Fax.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3"),"New Account Is Not Created");
		Assert.assertEquals(accountspage.getBillingStreetVerification().getText(), BillingStreet,"New Account Is Not Created");
		Assert.assertEquals(accountspage.getBillingCountryVerification().getText(), BillingCountry,"New Account Is Not Created");
		Assert.assertEquals(accountspage.getEmployeesVerification().getText(), Employees,"New Account Is Not Created");
	//	Assert.assertEquals(accountspage.getAnnualRevenueVerification().getText(),annualrevenue.AnnualRevenue(AnnualRevenue),"New Account Is Not Created");
		Assert.assertEquals(accountspage.getDescriptionVerification().getText(), Description,"New Account Is Not Created");

		Reporter.log("New Account is Created Succesfully",true);
	}

}
