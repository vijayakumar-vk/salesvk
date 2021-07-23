package testing;

import java.util.ArrayList;
import java.util.List;

public class test_1 {

	public static void main(String[] args) {
		String para = "Account Name=TestA|Phone=9999999999|Fax=9090909090|Website=www.candidateOne.com|Type=Prospect|Industry=Finance|Employees=75|Annual Revenue=100M|Description=There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain…|\n"
				+ "  Billing Street=3080 Olcott Street|Billing City=Santa Clara|Billing State/Province= CA| Billing Zip/Postal Code=95054|Billing Country=USA|Copy Billing Address to Shipping Address=checked";
		ArrayList<String> vk = new ArrayList<String>();
		String data[]=para.split("\\|");
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
		System.out.println(AccountName);
		System.out.println(Phone);
		System.out.println(Fax);
		System.out.println(Website);
		System.out.println(Employees);
		System.out.println(AnnualRevenue);
		System.out.println(Description);
		System.out.println(BillingStreet);
		System.out.println(BillingCity);
		System.out.println(BillingState);
		System.out.println(BillingZipcode);
		System.out.println(BillingCountry);
//	
	

	}

}
