package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readConfig {
	Properties pro;
	
	public readConfig() {
		File src=new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception is" + e.getMessage());
		}
		
	}
	

	public String getapplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getusername() {
		String Usernm=pro.getProperty("Username");
		return Usernm;
	}
	
	public String getPassword() {
		String pwd=pro.getProperty("Password");
		return pwd;
	}
	
	public String chromedriver() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	
}
