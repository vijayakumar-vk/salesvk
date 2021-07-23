package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Propertyfile {
	
	public String GetdataFromProperty(String data) {
		
		Properties property = new Properties();
		try {
			property.load(new FileInputStream ("/home/onebill/eclipse-workspacevk/Salesforce/src/main/resources/data.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return property.getProperty(data);
		
	}

}
