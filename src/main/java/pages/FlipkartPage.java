package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPage  {
	  WebDriver driver;
	  //Page Elements
	  By mobiles=By.xpath("//img[@alt='Mobiles']");
	  
	  
	  //Constructor
	  public FlipkartPage(WebDriver driver)
		{
			this.driver=driver;
		}
		
	  //Page actions
	  public String getMobileText()
	  {
		  WebDriverWait  wait=new WebDriverWait(driver,10);
		  WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(mobiles));
		  String mtext=element.getText();
		  return mtext;
		  
	  }

}
