package pageObjects;

import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class adminPage {
	WebDriver ldriver;
	
	public adminPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
@FindBy (xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
WebElement adminUsername;


@FindBy(className="oxd-select-text-input")
List<WebElement> list; //declaring as list as we have 2 fields with same class name and this one is  first.This would save both elements in list

@FindBy(css=("input[placeholder='Type for hints...'"))
WebElement employeeNM;

@FindBy(css=("button[type='submit'"))
WebElement searchbtn;

@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/span")
WebElement invalidMsg;

@FindBy(css=("div[role='table'"))
List<WebElement> table;


public void adminusr(String username) {
	adminUsername.sendKeys(username);
}

public void userRole(String usrrole) throws InterruptedException {
	WebElement urole=list.get(0); //gets the first element fetched through list
	urole.click();
	Thread.sleep(3000);
	
	if (usrrole.equals("Admin")) {
		urole.sendKeys(Keys.ARROW_DOWN);
		urole.sendKeys(Keys.ENTER);
	}
	
	if (usrrole.equals("ESS")) {
		urole.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		urole.sendKeys(Keys.ARROW_DOWN);
		urole.sendKeys(Keys.ENTER);
	}
	
	//ldriver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]")).click();
	
	

	//JavascriptExecutor js = (JavascriptExecutor) ldriver;

	//js.executeScript("arguments[1].click();",urole);
	//Select urolesel=new Select(urole); //Select class is needed for the dropdowns
	//urolesel.deselectByVisibleText(usrrole);
}

public void employeeName(String empname) throws InterruptedException {
	employeeNM.sendKeys(empname);
	Thread.sleep(2000);
	employeeNM.sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	employeeNM.sendKeys(Keys.ENTER);
}

public void status(String stat) throws InterruptedException {
	WebElement status=list.get(1); //gets the second element fetched through list
	status.click();
	Thread.sleep(3000);
	if (stat.equals("Enabled")) {
		status.sendKeys(Keys.ARROW_DOWN);
		status.sendKeys(Keys.ENTER);
	}
	
	if (stat.equals("Disabled")) {
		status.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(2000);
		status.sendKeys(Keys.ARROW_DOWN);
		status.sendKeys(Keys.ENTER);
	}
	
}

public void search() {
	searchbtn.click();
}

public int tabledata() {
	int i=table.size();
	return i;
}

}
