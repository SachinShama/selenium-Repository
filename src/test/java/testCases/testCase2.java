package testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.baseClass;
import pageObjects.mainPage;

public class testCase2 extends baseClass {
	
	
	@Test
	public void TC02() throws InterruptedException {
			
		mainPage mp=new mainPage(driver);
		mp.adminClick();
		Thread.sleep(3000);
		WebElement username=driver.findElement(By.className("]/div[2]/form/div[1]/div/div[1]/div/div[2]/input"));
		
		if (username.isDisplayed()==true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		
		
		
		
		
	}

}
