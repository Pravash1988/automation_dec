package testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class Flipkart {
	protected WebDriver driver;
	protected WebDriverWait wait;
//	Before method to run before every test case
	@BeforeMethod 
    public void beforemethod() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Pravash\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.className("_2doB4z")).click();
}
	
}