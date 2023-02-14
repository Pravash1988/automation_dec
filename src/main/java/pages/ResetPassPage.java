package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ElementUtils;

public class ResetPassPage {
 WebDriver driver;
 ElementUtils elementutils;
 //Page Elements
 By resetPasswordTitle=By.className("orangehrm-forgot-password-title");
 //By cancelButton=By.className("forgot-password-button--cancel");
 By cancelButton=By.xpath("//button[@type='button']");
 
 
 //constructor
 public ResetPassPage(WebDriver driver)
	{
		this.driver=driver;
		elementutils=new ElementUtils(driver);
		
	}
 
 
 //PageActions
 public boolean isResetLinkPresent() {
	 WebDriverWait  wait=new WebDriverWait(driver,10);
	 try {
		WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(resetPasswordTitle));
	 return true;
	 }
	 catch(NoSuchElementException e) {
		 return false;
	 }
 }
 public String getResetHeaderText()
 {
	 return driver.findElement(resetPasswordTitle).getText();
 }
 public LoginPage cancelButtonClick()
 {
	 
	 LoginPage login=new LoginPage(driver);
	 login.clickForgotLink();
	 WebDriverWait  wait=new WebDriverWait(driver,10);
	 WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(cancelButton));
	 element.click();
	 return login;
 }
	
 
}
