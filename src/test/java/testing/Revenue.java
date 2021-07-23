package testing;

public class Revenue {
	
	
	public static String AnnualRevenue(String AnnualRevenue) {
	  char ch[] = AnnualRevenue.toCharArray();
	  if(AnnualRevenue.contains("M")){
		  AnnualRevenue= AnnualRevenue.substring(0, ch.length-2);
		  int a = Integer.parseInt(AnnualRevenue);
		  a = a*10000000;
		  AnnualRevenue=""+a+"";
		  AnnualRevenue=AnnualRevenue.replaceFirst("(\\d{3})(\\d{3})(\\d+)","\\$$1,$2,$3");
	  }
	return AnnualRevenue;
	}

}
