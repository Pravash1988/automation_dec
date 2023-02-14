package testCase;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ResetPassPage;
import testbase.TestBase;

public class ResetPasswordPage extends TestBase {
	@Test
	public void resetlinkpresent()
	{
		
		LoginPage Login=new LoginPage(driver);
		ResetPassPage rsp=Login.clickForgotLink();
		//ResetPassPage rsp=new ResetPassPage(driver);
		boolean flag=rsp.isResetLinkPresent();
		Assert.assertEquals(flag, true,"restlink not present");
		String text=rsp.getResetHeaderText();
		Assert.assertEquals(text, "Reset Password");
}
	@Test
	public void cancelButtonClickHome() {
		ResetPassPage rsp=new ResetPassPage(driver);
		LoginPage login=rsp.cancelButtonClick();
		boolean flag=login.isOrangeTitlePresent();
		Assert.assertEquals(flag, true,"orangetitle not present");
		String text=login.getOrangeTitleText();
		Assert.assertEquals(text, "Login");
		
	}
}
