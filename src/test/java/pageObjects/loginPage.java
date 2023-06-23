package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
 WebDriver ldriver;

 
 public loginPage(WebDriver rdriver) {
	 ldriver=rdriver;
	 PageFactory.initElements(rdriver, this);
	 
 }

 
 @FindBy(xpath="//*[@id=\"user\"]")
 WebElement username;
 
 @FindBy(id="sign_in")
 WebElement letGoBtn;

 
 public void unameinput(String uname) {
	 username.sendKeys(uname);
 }
 
 public void letsGo() {
	 letGoBtn.click();
 }
 
 
 
 

}
