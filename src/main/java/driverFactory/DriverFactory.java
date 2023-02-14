package driverFactory;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.sun.corba.se.pept.transport.EventHandler;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.WebDriverListenersClass;



public class DriverFactory {
 static WebDriver driver;
 static Logger log=Logger.getLogger(DriverFactory.class.getName());
public  static WebDriver init_driver(String browser)
{
	log.info("inside init_driver, browser : " +browser);
	
	if(browser.equals("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	//System.setProperty("webdriver.chrome.driver", "C:\\Selenium Pravash\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	log.info("chrome driver initialized");
	}
	else if(browser.equals("edge"))
	{ 
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	else
	{
		System.out.println("Enter correct browser name {chrome,edge}");
		System.exit(0);
	}
	driver.manage().window().maximize();
	
	EventFiringWebDriver eDriver = new EventFiringWebDriver(driver);
	WebDriverListenersClass driverListener = new WebDriverListenersClass();
	eDriver.register(driverListener);
	driver = (WebDriver)eDriver;
	return driver;
}
public static WebDriver getDriver()
{
	return driver;
}
}	
