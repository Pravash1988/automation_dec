package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import testbase.TestBase;
import util.Constants;

public class OrangeResetPassword extends TestBase{
	
	@Test
	public void cancelButtonResetPasswordPage()
	{
		driver.findElement(By.className("orangehrm-login-forgot-header")).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-button oxd-button--large oxd-button--ghost orangehrm-forgot-password-button orangehrm-forgot-password-button--cancel")));
	    //driver.findElement(By.className("oxd-button oxd-button--large oxd-button--ghost orangehrm-forgot-password-button orangehrm-forgot-password-button--cancel")).click();
	    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@type='button']")));
		driver.findElement(By.xpath("//button[@type='button']")).click();
		boolean flag;
	    String str="";
 try {
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.className("orangehrm-login-title")));
		flag=true;
		str=element.getText();
	
		}
	catch(Exception e)
	{
		flag=false;
	}
	    Assert.assertEquals(flag, true);
	    Assert.assertEquals(str, "Login");
	}
	
	@Test
	public void adminPage()
	{
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.className("orangehrm-login-button")).click();
		try {
			WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-userdropdown-name")));
			String Actual=element.getText();
			Assert.assertEquals(Actual, Constants.HOMEPAGE_USERNAME);
			}
			catch(TimeoutException e) {
				Assert.assertEquals(false, true,"userelement not displayed");
			}
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		boolean flag;
	    String str="";
 try {
		WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-topbar-header-breadcrumb-level")));
		flag=true;
		str=element.getText();
	
		}
	catch(Exception e)
	{
		flag=false;
	}
	    Assert.assertEquals(flag, true);
	    Assert.assertEquals(str, Constants.ADMIN_USERMANAGEMENT_HEADER);
	}

}
