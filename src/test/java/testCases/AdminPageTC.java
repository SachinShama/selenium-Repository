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
	int counter=0;
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
		logger.info("searched clicked");
		counter=counter+1;
		
	
		try {
			WebElement invalid=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/span"));
			if (invalid.isDisplayed()==false) {
				logger.info("Invalid role first!");
				Assert.assertTrue(true);			
			}
		}
		catch (Exception e) {
			WebElement recordsData=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span"));
			List<WebElement> tableRows=driver.findElements(By.className("oxd-table-card"));
			
			
				int tableRowCount=tableRows.size();
				logger.info(tableRowCount);
				String arr[][]=new String[tableRowCount][4];
				if(tableRowCount!=0) {
					logger.info("Table returned valid data.Test case is passed");
					List<WebElement> cellValue=driver.findElements(By.cssSelector("div[role='cell'"));
					int count=cellValue.size();
					logger.info(count);
					for(int i=1;i<=tableRowCount;i++) {
						for(int j=1;j<=4;j++) {
							arr[i-1][j-1]=cellValue.get(j).getText().toString();
							XLUtils.setCellData("/Users/tarun/Desktop/Automation.xlsx","Sheet1",counter,j+4,cellValue.get(j).getText());
						}
					}
					Assert.assertTrue(true);
				}
				else if(recordsData.getText().equals("No Records Found")) {
					logger.info("No Records found! But test case can be passed");
					Assert.assertTrue(true);
				}
				else {
					logger.info("Test case is failed");
					Assert.assertTrue(false);
					
				}
			}	
	}
		
	@DataProvider (name="adminData")
	public String [][] getData() throws IOException {
		
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
