package testing;

import java.util.ArrayList;
import java.util.List;

public class fijn {

	public static List<String> para(String para) {
		
		List<String> vk = new ArrayList<String>();
		String t = null ;
		String data[]=para.split("\\|");
		for(int j=1;j<data.length;j++) {
			for(int i=0;i<j;i++) {
				String d[]=data[i].split("=");
				t=d[1];
			}
			vk.add(t);
		}
		
//		String AccountName =vk.get(0);
//		String Phone =vk.get(1);
//		String Fax=vk.get(2);
//		String WebSite=vk.get(3);
//		String Employee=vk.get(6);
//		String AnnualRevenue=vk.get(7);
//		String Description=vk.get(8);
//		return Fax;
		return vk;
	}
	


}
