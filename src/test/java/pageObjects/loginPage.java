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

 
 @FindBy(name="username")
 WebElement username;
 
 @FindBy(name="password")
 WebElement password;
 
 @FindBy(xpath="//button[@type='submit']")
 WebElement submit;

 
 public void unameInput(String uname) {
	 username.sendKeys(uname);
 }
 
 public void pwdInput(String pwd) {
	 password.sendKeys(pwd);
 }
 
 public void submit() {
	 submit.click();
 }
 

}
