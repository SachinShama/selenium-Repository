package pageObjects;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import utilities.readConfig;

public class baseClass {

	
	readConfig rc=new readConfig();
	
	public String baseURL=rc.getapplicationURL();
	//public String uname=rc.getusername();
	//public String pword=rc.getPassword();
	public String chromedriver=rc.chromedriver();
	public static WebDriver driver;
	public static Logger logger;
	
	//@Parameters("browser")
	@BeforeClass
	public void setup() {
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver")
		
		logger=Logger.getLogger("Practice");
		PropertyConfigurator.configure("Log4j.properties");
		
		
			System.setProperty("webdriver.chrome.driver",chromedriver);
			driver=new ChromeDriver();
		
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
