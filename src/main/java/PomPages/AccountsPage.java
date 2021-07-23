package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {

	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	@FindBy (xpath="//span[text()='Recently Viewed']")
	private WebElement RecentlyViewedTextverification;


	@FindBy (xpath="//div[text()='New']")
	private WebElement NewAccountbutton;

	@FindBy (xpath="//h2[text()='New Account']")
	private WebElement NewAccountverification;


	//DATAS GIVEN WHILE CREATING NEW ACCOUNT
	@FindBy (xpath ="(//input[@type='text'])[4]")
	private WebElement AccountsName;


	@FindBy (xpath="//input[@type='tel']")
	private WebElement Phone;
	
	
	@FindBy (xpath="//input[@data-interactive-lib-uid='14']")
	private WebElement Phone1;
	

	@FindBy (xpath="//input[@data-interactive-lib-uid='11']")
	private WebElement fax;



	@FindBy (xpath="//input[@type='url']")
	private WebElement Website;


	@FindBy (xpath="//a[@class='select']")
	private WebElement Type;


	@FindBy (xpath="//a[text()='Prospect']")
	private WebElement Prospect;	


	@FindBy (xpath="(//a[@class='select'])[2]")
	private WebElement Industry;


	@FindBy  (xpath="//a[text()='Finance']")
	private WebElement Finance;


	@FindBy (xpath="//input[@class='input uiInputSmartNumber']")
	private WebElement Employees;


	@FindBy (xpath="//input[@data-interactive-lib-uid='17']")
	private WebElement AnnualRevenue;


	@FindBy (xpath="//textarea[@class=' textarea']")
	private WebElement Description;


	@FindBy (xpath="//textarea[@placeholder='Billing Street']")
	private WebElement BillingStreet;


	@FindBy (xpath="//input[@placeholder='Billing City']")
	private WebElement BillingCity;


	@FindBy (xpath="//input[@placeholder='Billing State/Province']")
	private WebElement BillingState;


	@FindBy (xpath="//input[@placeholder='Billing Zip/Postal Code']")
	private WebElement BillingZipcode;


	@FindBy (xpath="//input[@placeholder='Billing Country']")
	private WebElement BillingCountry;


	@FindBy (xpath="//span[text()='Copy Billing Address to Shipping Address']")
	private WebElement CopyBillingAddressToShippingAddress;


	@FindBy (xpath="(//span[text()='Sae'])[2]")
	private WebElement Savebutton;






	public WebElement getRecentlyViewedTextverification() {
		return RecentlyViewedTextverification;
	}


	public WebElement getNewAccountbutton() {
		return NewAccountbutton;
	}


	public WebElement getNewAccountverification() {
		return NewAccountverification;
	}


	public WebElement getAccountsName() {
		return AccountsName;
	}


	public WebElement getPhone() {
		return Phone;
	}
	

	public WebElement getPhone1() {
		return Phone1;
	}


	public WebElement getFax() {
		return fax;
	}


	public WebElement getWebsite() {
		return Website;
	}


	public WebElement getType() {
		return Type;
	}


	public WebElement getProspect() {
		return Prospect;
	}


	public WebElement getIndustry() {
		return Industry;
	}


	public WebElement getFinance() {
		return Finance;
	}


	public WebElement getEmployees() {
		return Employees;
	}


	public WebElement getAnnualRevenue() {
		return AnnualRevenue;
	}


	public WebElement getDescription() {
		return Description;
	}


	public WebElement getBillingStreet() {
		return BillingStreet;
	}


	public WebElement getBillingCity() {
		return BillingCity;
	}


	public WebElement getBillingState() {
		return BillingState;
	}


	public WebElement getBillingZipcode() {
		return BillingZipcode;
	}


	public WebElement getBillingCountry() {
		return BillingCountry;
	}


	public WebElement getCopyBillingAddressToShippingAddress() {
		return CopyBillingAddressToShippingAddress;
	}


	public WebElement getSavebutton() {
		return Savebutton;
	}



	//VERIFICATION


	@FindBy (xpath="//span[@class='custom-truncate uiOutputText']")
	private WebElement AccountNameVerification;


	@FindBy (xpath="//a[text()='(999) 999-9999']")
	private WebElement PhoneVerification;


	@FindBy (xpath="//a[text()='www.candidateOne.com']")
	private WebElement Websiteverification;


	@FindBy (xpath="//lightning-formatted-text[text()='Finance']")
	private WebElement IndustryVerification;


	@FindBy (xpath="//a[text()='(909) 090-9090']")
	private WebElement FaxVerification;


	@FindBy (xpath="//lightning-formatted-text[text()='Prospect']")
	private WebElement TypeVerification;


	@FindBy (xpath="//lightning-formatted-number[text()='75']")
	private WebElement EmployeesVerification;
	
	
	@FindBy (xpath="//lightning-formatted-text[text()='$100,000,000']")
	private WebElement AnnualRevenueVerification;


	@FindBy (xpath="//lightning-formatted-text[text()='There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain…']")
	private WebElement DescriptionVerification;


	@FindBy (xpath="//div[text()='3080 Olcott Street']")
	private WebElement BillingStreetVerification;


	@FindBy (xpath="(//div[text()='Santa Clara, CA 95054']")
	private WebElement BillingAddressVerification;


	@FindBy (xpath="//div[text()='USA']")
	private WebElement BillingCountryVerification;





	public WebElement getAccountNameVerification() {
		return AccountNameVerification;
	}


	public WebElement getPhoneVerification() {
		return PhoneVerification;
	}


	public WebElement getWebsiteverification() {
		return Websiteverification;
	}


	public WebElement getIndustryVerification() {
		return IndustryVerification;
	}


	public WebElement getFaxVerification() {
		return FaxVerification;
	}


	public WebElement getTypeVerification() {
		return TypeVerification;
	}


	public WebElement getEmployeesVerification() {
		return EmployeesVerification;
	}
	
	
	public WebElement getAnnualRevenueVerification() {
		return AnnualRevenueVerification;
	}


	public WebElement getDescriptionVerification() {
		return DescriptionVerification;
	}


	public WebElement getBillingStreetVerification() {
		return BillingStreetVerification;
	}


	public WebElement getBillingAddressVerification() {
		return BillingAddressVerification;
	}


	public WebElement getBillingCountryVerification() {
		return BillingCountryVerification;

	}
	
	
































}
