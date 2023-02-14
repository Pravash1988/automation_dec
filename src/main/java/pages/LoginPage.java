package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import util.ElementUtils;

public class LoginPage {
     WebDriver driver;
     ElementUtils elementutils;
	//Page WebElements
	 By username=By.name("username");
	 By password=By.name("password");
	 By loginButton=By.className("orangehrm-login-button");
	 By invalidCredmsg=By.className("oxd-alert-content-text");
	 By forgotPasswordLink=By.className("orangehrm-login-forgot-header");
	 By orangeTitle=By.className("orangehrm-login-title");
	 
	 public LoginPage(WebDriver driver) {
		 this.driver=driver;
		 elementutils=new ElementUtils(driver);
	 }
	
	
	//PageActions
	 public void enterUserName(String user) {
		 elementutils.enterText(username, user);
//		 try
//		 {
//		 driver.findElement(username).sendKeys(user);
//		 }
//	     catch(Exception e)
//	     {
//	    	 e.printStackTrace();
//	     }
		 
	 }
	 public void enterPassword(String pass) {
		 //driver.findElement(password).sendKeys(pass);
		 elementutils.enterText(password, pass);
	 }
	 //we can directly return the homepage
	 public HomePage clickLoginButton() {
		// elementutils=new ElementUtils(driver);
		 elementutils.doClick(loginButton);
//	     driver.findElement(loginButton).click();
//		 HomePage page=new HomePage(driver);
//		 return page;
		 return new HomePage(driver);
	 }
	 
	 public HomePage doLogin(String user,String pass)
     {
    	 enterUserName(user);
    	 enterPassword(pass);
//    	 HomePage page=clickLoginButton();
//    	 return page; 
    	 return clickLoginButton();
     }
	 
	 
	 public boolean isInvalidCredmsgPresent() {
		 
		return elementutils.isElementPresent(invalidCredmsg,10);
	 }
	 public String getInvalidCredMsgText() {
		 
		 WebElement element =driver.findElement(invalidCredmsg);
		 
		 return element.getText();
 }
	 
	 
	 public ResetPassPage  clickForgotLink()
	 {
		 driver.findElement(forgotPasswordLink).click(); 
//		 ResetPassPage rsp=new ResetPassPage(driver);
//		 return rsp;
		 return new ResetPassPage(driver);
	 }
	 public boolean isOrangeTitlePresent()
	 {
			 WebDriverWait  wait=new WebDriverWait(driver,10); 
			 try {
			 WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(orangeTitle));
			 return true;
		 }
			 catch(NoSuchElementException e) {
				 return false;
			 }
		 }
	 public String getOrangeTitleText()
	 {
		 return driver.findElement(orangeTitle).getText();
	 }
	 
}
