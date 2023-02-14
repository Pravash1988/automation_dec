package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ElementUtils;

public class TimePage {
	
    WebDriver driver;
    ElementUtils elementutils;
	//Page Elements
	By header1 = By.className("oxd-topbar-header-breadcrumb-module");
	
	By header2 = By.className("oxd-topbar-header-breadcrumb-level");
	
	By attendance = By.xpath("//span[text()='Attendance ']");
	By myrecords = By.xpath("//a[text()='My Records']");
	//Page Constructor
	public TimePage(WebDriver driver)
	{
		this.driver= driver;
		elementutils=new ElementUtils(driver);
	}
	//Page Actions
	public String getTimeTitle()
	{
	    elementutils.isElementPresent(header1, 10);
		String str1 = driver.findElement(header1).getText();
		String str2 = driver.findElement(header2).getText();
		return str1+" / "+ str2;
	}
	public AttendancePage clickMyRecords()
	{
		elementutils.doClick(attendance);
		elementutils.doClick(myrecords);
//		driver.findElement(attendance).click();
//		driver.findElement(myrecords).click();
		
		return new AttendancePage(driver);
	}

}
