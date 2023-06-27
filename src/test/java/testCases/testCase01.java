package testCases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.baseClass;
import pageObjects.loginPage;
import utilities.readConfig;

public class testCase01 extends baseClass {
	
	
	@Test
	public void loginTest() {
			
		if(driver.getTitle().equals("OrangeHRM")) {
			Assert.assertTrue(true);
			logger.info("TC01 passed!");
		}
		else {
			Assert.assertTrue(false);
			logger.info("TC01 failed!");
		}
	}

}
