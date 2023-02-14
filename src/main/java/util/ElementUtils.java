package util;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	WebDriver driver;
	
	static Logger log=Logger.getLogger(ElementUtils.class.getName());
	public ElementUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	public void doClick(By locator)
	{
		log.info("Inside doclick method");
		//System.out.println("Inside doclick method");
		log.info("Locator : " +locator);
		//System.out.println("Locator : " +locator);
		try
		{
		driver.findElement(locator).click();
		log.info("click successful");
		//System.out.println("click successful");
		}
		catch(Exception e)
		{
			log.error("click not successful");
			//System.out.println("click not successful");
			log.error(e.toString());
			//e.printStackTrace();
		}
	}
	public void doClick(String  xpath)
	{
		//System.out.println("Inside doclick method");
		log.info("Inside doclick method");
		//System.out.println("Xpath : " +xpath);
		log.info("Xpath : " +xpath);
		try
		{
		driver.findElement(By.xpath(xpath)).click();
		log.info("click successful");
		//System.out.println("click successful");
		}
		catch(Exception e)
		{
			log.error("click not successful");
			//System.out.println("click not successful");
			log.error(e.toString());
			//e.printStackTrace(); 
		}
	}
	public void doClick(WebElement  ele)
	{
		log.info("Inside doclick method with webelement");
		//System.out.println("Inside doclick method with webelement");
	
		try
		{
		ele.click();
		log.info("click  successful");
		//System.out.println("click successful");
		}
		catch(Exception e)
		{
			log.error("click not successful");
			//System.out.println("click not successful");
			log.error(e.toString());
			//e.printStackTrace();
		}
	}
	public void enterText(By locator,String text )
	{
		
		    log.info("Inside enterText method");
			//System.out.println("Inside enterText method");
		    log.info("Locator : " +locator);
			//System.out.println("Locator : " +locator);
			try
			{
			driver.findElement(locator).sendKeys(text);
			log.info("Text Entered  successful");
			//System.out.println("Text Entered  successful");
			}
			catch(Exception e)
			{
			log.error("Text  not Entered  successful");
			//System.out.println("text not entered");
			log.error(e.toString());
			//e.printStackTrace();
			}
		
	}
	
	public boolean isElementPresent(By locator,int time)
	{
		        log.info("Inside iselemetPresent method");
		        //System.out.println("Inside iselemetPresent method");
		        log.info("Locator : " +locator);
		        //System.out.println("Locator : " +locator);
		        try {
			 
			    WebDriverWait  wait=new WebDriverWait(driver,time);
				WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				log.info("Element located within the time");
				//System.out.println("Element located within the time");
				return true;
				}
				catch(TimeoutException e)
		        {
				log.error("Element not located ");	
				//System.out.println("Element not located ");
				log.error(e.toString());
				//e.printStackTrace();
				return false;
				}
	}

}
