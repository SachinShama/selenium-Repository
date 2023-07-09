package testCases;



import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.baseClass;


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
