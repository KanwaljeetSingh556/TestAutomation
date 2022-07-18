package gUtilities;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class ReadProperties {
	Properties prop;
	FileInputStream myfile;
	String filename;
	public ReadProperties(String filename) {
		this.filename = filename;
	}
	public String readData(String userKey) {
		try {
			myfile = new FileInputStream(filename);
			prop = new Properties();
			prop.load(myfile);
		} catch (IOException e  ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(userKey);
		
	}
	
	
	public void readData() {
		try {
			myfile = new FileInputStream("TestData/Aprstc.properties");
			prop = new Properties();
			prop.load(myfile);
			String myurl = prop.getProperty("URL");
			System.out.println(myurl);
			System.out.println(prop.getProperty("FromCity"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
