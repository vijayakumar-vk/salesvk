package testing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String Phone = "9090909555550";
		String p = Phone.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3");
		System.out.println(p);
		String val = "100M";
	//String s=val.replaceAll(val, "$100,000,000");
			{
		 Pattern p1 = Pattern.compile("100M");
		 Matcher m = p1.matcher("$100,000,000");
		 
			}
String s=	val.replace("100M", "$100,000,000");
System.out.println(s);
String n = val.replaceFirst("(\\d{3})(\\d{3})(\\d+)","($1) $2-$3");
System.out.println(n);

Revenue r = new Revenue();
System.out.println(r.AnnualRevenue("100M"));


	}

	
}
