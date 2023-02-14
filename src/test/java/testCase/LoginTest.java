package testCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import util.Constants;
import util.ElementUtils;

public class LoginTest extends TestBase {
	static Logger log=Logger.getLogger(LoginTest.class.getName());

	@Test
	public void loginTest() throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Pravash\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//wait for page to load
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		log.info("Test Case Execution started------->LoginTest");
		LoginPage Login=new LoginPage(driver);
//		Login.enterUserName("Admin");
//		Login.enterPassword("admin123");
//		Login.clickLoginButton();
		HomePage homepage=Login.doLogin("Admin", "admin123");
		//32 to 34 commented as we use functions that will called from loginpage
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.name("password")).sendKeys("admin123");
//		driver.findElement(By.className("orangehrm-login-button")).click();
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		try {
//		WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-userdropdown-name")));
//		String Actual=element.getText();
		//System.out.println(element.getText());
	//	HomePage homepage=new HomePage(driver);
		boolean flag=homepage.isProfileUserNamePresent();
		Assert.assertEquals(flag, true,"userelement not displayed");
		String username=homepage.getProfileUserNameText();
		Assert.assertEquals(username, Constants.HOMEPAGE_USERNAME);
		
		
	}
	@Test
	public void InvalidLogin() {
		//43 to 50 added in base class
//		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Pravash\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//wait for page to load
//		WebDriverWait wait=new WebDriverWait(driver,10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
		
		log.info("Test Case Execution started------->InvalidLogin");
		LoginPage Login=new LoginPage(driver);
		Login.enterUserName("Admin");
		Login.enterPassword("admin1234");
		Login.clickLoginButton();
		boolean ispresent=Login.isInvalidCredmsgPresent();
		
		Assert.assertEquals(ispresent, true);
		String actual=Login.getInvalidCredMsgText();
		Assert.assertEquals(actual, Constants.INVALID_CRED_MSG);
		
////    below code is commented as above method used by importing pages package	
//		driver.findElement(By.name("username")).sendKeys("Admin");
//		driver.findElement(By.name("password")).sendKeys("admin13");
//		driver.findElement(By.className("orangehrm-login-button")).click();
//		try {
//			WebElement element =wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-alert-content-text")));
//			String Actual=element.getText();
//			//System.out.println(element.getText());
//			Assert.assertEquals(Actual, "Invalid credentials");
//			}
//			catch(TimeoutException e) {
//				Assert.assertEquals(false, true,"Invalid Credential text not displayed");
//			
//			}
	}
	
	@Test
	public void redirectToResetPasswordPageLinkPresent()
	{
		log.info("Test Case Execution started------->redirectToResetPasswordPageLinkPresent");
		boolean flag;
		try {
		driver.findElement(By.className("orangehrm-login-forgot-header"));
		flag=true;
		}
		catch(NoSuchElementException e)
		{
			flag=false;
		}
		Assert.assertEquals(flag, true);
	}
	
	@Test(dependsOnMethods= {"redirectToResetPasswordPageLinkPresent"})
	public void navigateResetPasswordPage() 
	{
		log.info("Test Case Execution started------->navigateResetPasswordPage");
		driver.findElement(By.className("orangehrm-login-forgot-header")).click();
		boolean flag;
		String str="";
		try {
		//WebElement element=driver.findElement(By.className("orangehrm-forgot-password-title"));
			WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.className("orangehrm-forgot-password-title")));
		flag=true;
		str=element.getText();
		}
		catch(Exception e)
		{
			flag=false;
		}
		Assert.assertEquals(flag, true);
		Assert.assertEquals(str, Constants.RESET_PASS_PAGE_HEADER);
	}
	@Test(dependsOnMethods= {"navigateResetPasswordPage"})
	public void cancelButton() //throws InterruptedException
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("orangehrm-forgot-password-button--cancel"))).isDisplayed();
		//Thread.sleep(2000);
		driver.findElement(By.className("orangehrm-forgot-password-button--cancel")).click();
		boolean flag;
		String str="";
		try {
			WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(By.className("oxd-text oxd-text--h5 orangehrm-login-title")));
			flag=true;
			str=element.getText();
			}
		catch(Exception e)
		{
			flag=false;
		}
		Assert.assertEquals(flag, true);
		Assert.assertEquals(str, Constants.LOGINPAGE_LOGIN_HEADER);
		}
	
	}
	


