package util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FlipkartMenuDynamicElements {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Pravash\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.className("_2doB4z")).click();
		
		WebElement fashion = driver.findElement(By.xpath("//img[@alt='Fashion']"));
		Actions action = new Actions(driver);
		action.moveToElement(fashion).perform();
		WebElement kids = driver.findElement(By.xpath("//a[text()='Kids']"));
		action.moveToElement(kids).perform();
		WebElement GirlDresses=driver.findElement(By.xpath("//a[text()='Girls Dresses']"));
		GirlDresses.click();
		
		////take Screenshot
		Thread.sleep(2000);
//		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(file,new File("D:\\Selenium Automation\\Screenshot\\screen1.jpg"));
		ScreenshotUtil.takeScreenshot(driver, "screen1");
		

	}

}
