package testCase;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import testbase.TestBase;
import util.Constants;
public class HomeTest extends TestBase {
	@Test
	public void verifyLinks()
	{
//		ArrayList<String> expectedList = new ArrayList<String>();
//		expectedList.add("Admin");
//		expectedList.add("PIM");
//		expectedList.add("Leave");
//		expectedList.add("Time");
//		expectedList.add("Recruitment");
//		expectedList.add("My Info");
//		expectedList.add("Performance");
//		expectedList.add("Dashboard");
//		expectedList.add("Directory");
//		expectedList.add("Maintenance");
//		expectedList.add("Buzz");
//		
		LoginPage login = new LoginPage(driver);
		HomePage homePage = login.doLogin("Admin", "admin123");
		
		
		Assert.assertEquals(homePage.isProfileUserNamePresent(), true);
		
		ArrayList<String> list = homePage.getLinks();
		
		Assert.assertEquals(list.size(), Constants.HOMEPAGE_MENU_LINKS.size());
		
		Assert.assertEquals(list, Constants.HOMEPAGE_MENU_LINKS);
		
	}

}
