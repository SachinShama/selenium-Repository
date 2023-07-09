package pageObjects;

import java.util.concurrent.TimeUnit;

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
	public String uname=rc.getusername();
	public String pword=rc.getPassword();
	public String chromedriver=rc.chromedriver();
	public  WebDriver driver;
	public static Logger logger;
	
	//@Parameters("browser")
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver")
		
		logger=Logger.getLogger("Practice");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",chromedriver);
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			
		}
		else if(br.equals("safari")) {
			
		}
			driver.get(baseURL);
			logger.info("URL opened");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			loginPage lp=new loginPage(driver);
			lp.unameInput(uname);
			lp.pwdInput(pword);
			lp.submit();
			
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
