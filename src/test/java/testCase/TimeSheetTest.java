package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AttendancePage;
import pages.HomePage;
import pages.LoginPage;
import pages.TimePage;
import testbase.TestBase;

public class TimeSheetTest extends TestBase {
	
	@Test
	public void timeSheetTest1()
	{
		
		LoginPage login = new LoginPage(driver);
		HomePage homePage = login.doLogin("Admin", "admin123");
		Assert.assertEquals(homePage.isProfileUserNamePresent(), true);
		TimePage timesheet=homePage.clickTimeLink();
		String actual = timesheet.getTimeTitle();
		Assert.assertEquals(actual, "Time / Timesheets");
		AttendancePage attPage=timesheet.clickMyRecords();
		String attTitle=attPage.getAttendanceTitle();
		Assert.assertEquals(attTitle, "Attendance / Attendance");
	}

}
