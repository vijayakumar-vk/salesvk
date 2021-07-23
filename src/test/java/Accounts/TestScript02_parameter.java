package Accounts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Generic.BaseClass;
import PomPages.AccountsPage;
import PomPages.HomePage;
import testing.Revenue;
import testing.fijn;

public class TestScript02_parameter extends BaseClass {
	public Revenue annualrevenue;
	@Parameters({"params"})
	@Test
	public void createAccount(String params) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		//HOMEPAGE ACTIVITIES
		homepage = new HomePage(driver);
		homepage.getSearchApps().click();
		homepage.getViewAllButton().click();
		Thread.sleep(2000);


		//ASSERTION FOR APP LAUNCHER
		Assert.assertEquals(homepage.getAppLauncherIconVerification().getText(),"App Launcher","App Launcher POP-UP is not Displayed");
		Reporter.log("App Launcher POP-UP is Displayed",true);
		homepage.getSearchTextField().sendKeys("accounts");
		homepage.getAccountsButton().click();

		//ACCOUNTPAGE ACTIVITIES
		accountspage = new AccountsPage(driver);
		//ASERTION FOR ACCOUNTS PAGE
		Assert.assertEquals(accountspage.getRecentlyViewedTextverification().getText(), "Recently Viewed","Accounts Page Is Not Displayed");
		Reporter.log("AccountsPage is Displayed",true);
		accountspage.getNewAccountbutton().click();
		
		
		//ASSSERTION FOR NEWACCOUNT POPUP
		Assert.assertEquals(accountspage.getNewAccountverification().getText(),"New Account","New Account Pop Up is not Displayed");
		Reporter.log("NewAccount Pop up is Displayed",true);
		Thread.sleep(5000);
		
		
		//GETTING DATA FROM PARAMS
		ArrayList<String> vk = new ArrayList<String>();
		String data[]=params.split("\\|");
		for(int i=0;i<=data.length-1;i++) {
			String d[]=data[i].split("=");
			vk.add(d[1]);
		}
		String AccountName =vk.get(0);
		String Phone =vk.get(1);
		String Fax=vk.get(2);
		String Website=vk.get(3);
		String Employees=vk.get(6);
		String AnnualRevenue=vk.get(7);
		String Description=vk.get(8);
		String BillingStreet=vk.get(9);
		String BillingCity=vk.get(10);
		String BillingState=vk.get(11);
		String BillingZipcode=vk.get(12);
		String BillingCountry=vk.get(13);

		//ENTERING DATAS IN NEWACCOUNT POPUP
		accountspage.getAccountsName().sendKeys(AccountName);
		accountspage.getPhone().sendKeys(Phone);
		accountspage.getWebsite().sendKeys(Website);
		accountspage.getType().click();
		accountspage.getProspect().click();
		accountspage.getEmployees().click();
		accountspage.getIndustry().click();
		accountspage.getFinance().click();
		accountspage.getEmployees().sendKeys(Employees);
		accountspage.getDescription().sendKeys(Description);
		accountspage.getBillingStreet().sendKeys(BillingStreet);
		accountspage.getBillingCity().sendKeys(BillingCity);
		accountspage.getBillingState().sendKeys(BillingState);
		accountspage.getBillingZipcode().sendKeys(BillingZipcode);
		accountspage.getBillingCountry().sendKeys(BillingCountry);
		try {
			accountspage.getFax().sendKeys(Fax);
			accountspage.getAnnualRevenue().sendKeys(AnnualRevenue);
			accountspage.getCopyBillingAddressToShippingAddress().click();
		} catch (Exception e) {
			Reporter.log("Fax,AnnualRevenue are not present",true);
		}
		accountspage.getSavebutton().click();
		Thread.sleep(2000);
		//ASSERTION FOR NEWLY CREATED ACCOUNT
		Assert.assertEquals(accountspage.getAccountNameVerification().getText(), AccountName,"New Account Is Not Created");
		Assert.assertEquals(accountspage.getPhoneVerification().getText(),  Phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3"),"New Account Is Not Created");
		Assert.assertEquals(accountspage.getWebsiteverification().getText(), Website,"New Account Is Not Created");
		Assert.assertEquals(accountspage.getBillingStreetVerification().getText(), BillingStreet,"New Account Is Not Created");
		Assert.assertEquals(accountspage.getBillingCountryVerification().getText(), BillingCountry,"New Account Is Not Created");
		Assert.assertEquals(accountspage.getEmployeesVerification().getText(), Employees,"New Account Is Not Created");	
		Assert.assertEquals(accountspage.getDescriptionVerification().getText(), Description,"New Account Is Not Created");
		try {
			Assert.assertEquals(accountspage.getFaxVerification().getText(),Fax.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3"),"New Account Is Not Created"); 
			Assert.assertEquals(accountspage.getAnnualRevenueVerification().getText(), Revenue.AnnualRevenue(AnnualRevenue),"New Account Is Not Created");
		} catch (Exception e) {
			Reporter.log("Fax,AnnualRevenue are not present",true);
		}
		Reporter.log("New Account is Created Succesfully",true);
	}	

}



