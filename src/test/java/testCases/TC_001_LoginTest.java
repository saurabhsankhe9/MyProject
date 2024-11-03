package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LoginConfirmationPage;
import pageObject.LoginPage;
import testBase.BaseClass;

public class TC_001_LoginTest extends BaseClass {
	
	@Test
	public void testLogin()
	{
		logger.info("*****Start TC_001_LoginTest***** ");
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName("student");
		logger.info("Enter Username");
		lp.setPassWord("Password123");
		logger.info("Enter Password");
		lp.clickLoginButton();
		logger.info("Click on login button");
		
		LoginConfirmationPage lcp = new LoginConfirmationPage(driver);
		String msg = lcp.confirmLoginSuccessfulText();
		
		Assert.assertEquals(msg,"Congratulations student. You successfully logged in!");
		logger.info("Validate confirmation login message");
		lcp.clickLogOutButton();
		logger.info("Click on LogOut Button");
		logger.info("*****Finish TC_001_LoginTest***** ");

	}

}
