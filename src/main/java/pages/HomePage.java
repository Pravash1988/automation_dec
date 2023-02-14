package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ElementUtils;

public class HomePage {
	ElementUtils elementutils;
	WebDriver driver;
	//Page Elements
	By profileUserName=By.className("oxd-userdropdown-name"); 
	By allLinks = By.className("oxd-main-menu-item--name");
	By timeLink = By.xpath("//span[text()='Time']");
	
	
	
	//Constructor to call the driver and initialize the driver of that particular page
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		elementutils=new ElementUtils(driver);
	}
	
	
	//Page Actions
     public boolean isProfileUserNamePresent() {
    	 WebDriverWait  wait=new WebDriverWait(driver,10);
    	 try {
    		WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(profileUserName));
    	 return true;
    	 }
    	 catch(NoSuchElementException e) {
    		 return false;
    	 }
     }
    
     public String getProfileUserNameText()
     {
    	 return driver.findElement(profileUserName).getText();
     }
     
 	public ArrayList<String> getLinks()
 	{
 		ArrayList<String> texts = new ArrayList<String>();
 		List<WebElement> list = driver.findElements(allLinks);
 		
 		for(WebElement e : list)
 		{
 			texts.add(e.getText());
 		}
 		
 		return texts;
 	}
 	
 	public TimePage clickTimeLink()
 	{
 		//driver.findElement(timeLink).click();
 		elementutils.doClick(timeLink);
 		return new TimePage(driver);
 	}
 	
 	
}
