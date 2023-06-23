package testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.baseClass;
import pageObjects.loginPage;

public class testCase01 extends baseClass {
	
	
	@Test
	public void loginTest() {
		driver.get(baseURL);
		logger.info("Entered the URL successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//	loginPage lp=new loginPage(driver);
		
		
		
		
		if(driver.getTitle().equals("Amazon.com. Spend less. Smile more.")) {
			Assert.assertTrue(true);
			logger.info("Test case passed!");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Test case failed!");
		}
	}

}
