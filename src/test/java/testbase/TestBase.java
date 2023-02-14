package testbase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import driverFactory.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.PropConfig;
import util.ScreenshotUtil;

public class TestBase {
	protected WebDriver driver;
	protected WebDriverWait wait;
	static Properties prop;
	static Logger log=Logger.getLogger(TestBase.class.getName());
	
	
	@Parameters(value="env")
	@BeforeTest
	public void beforetest(String env) throws IOException
	{
		System.out.println(env);
		prop=PropConfig.init_properties(env);//environment is decided
	}
//	Before method to run before every test case
	@BeforeMethod 
    public void beforemethod(ITestResult result) 
	{
		log.info("-------Execution started for Testcase" + result.getMethod().getMethodName()+"-----");
		String browser=prop.getProperty("browser");//browser is decided
		driver=DriverFactory.init_driver(browser);
		String urlValue=prop.getProperty("url");//url value is picked up 
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.get(urlValue);	
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
	}
	@AfterMethod //to close driver after every method test case
	public void afterMethod(ITestResult result)
	{
		//Take the screenshot
		if(result.getStatus()==ITestResult.FAILURE)
		{
			ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());
		}
	}
//		driver.quit();
//	}
}
