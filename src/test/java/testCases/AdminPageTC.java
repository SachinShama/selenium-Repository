package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.adminPage;
import pageObjects.baseClass;
import pageObjects.mainPage;
import utilities.XLUtils;

public class AdminPageTC extends baseClass {
	
	@Test (dataProvider="adminData")
	public void adminpageTestCase(String uname,String role,String empname,String status) throws InterruptedException, IOException {
		mainPage mp=new mainPage(driver);
		mp.adminClick();
		Thread.sleep(3000);
		adminPage ap=new adminPage(driver);
		ap.adminusr(uname);
		ap.userRole(role);
		ap.employeeName(empname);
		ap.status(status);
		ap.search();
		
		WebElement invalid=driver.findElement(By.className("oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message"));
		WebElement tableelem=driver.findElement(By.className("oxd-table"));
		WebElement recordsData=driver.findElement(By.className("oxd-text oxd-text--span"));		
		if (invalid.isDisplayed()) {
			Assert.assertTrue(false);
		}
		else {
			
			//int rows=ap.tabledata();
			if(tableelem.isDisplayed()) {
				Assert.assertTrue(true);
			}
			else if(recordsData.getText().equals("No Records Found")) {
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
	}
	@DataProvider (name="adminData")
	public String [][] getData() throws IOException {
		//XLUtils excel=new XLUtils();
		
		String excelpath="/Users/tarun/Desktop/Automation.xlsx";
		int rCount=XLUtils.getRowCount(excelpath, "Sheet1");
		int cCount=XLUtils.getCellCount(excelpath, "Sheet1", 1);
		
		
		String excelArr[][]=new String[rCount][cCount];
		
		for(int i=1;i<=rCount;i++) {
			for (int j=0;j<cCount;j++) {
				excelArr[i-1][j]=XLUtils.getCellData(excelpath, "Sheet1", i, j);
				
			}
		}
      return excelArr;
	}
}
