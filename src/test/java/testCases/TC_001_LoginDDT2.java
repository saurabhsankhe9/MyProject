package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.LoginConfirmationPage;
import pageObject.LoginPage;
import testBase.BaseClass;
import utilities.DataProidersClass;

public class TC_001_LoginDDT2 extends BaseClass {
	
	@Test(dataProvider = "LoginDataProvider",dataProviderClass =DataProidersClass.class )
	public void testLogin(String userName,String passWord,String result)
	{
		try {
			
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		lp.setPassWord(passWord);
		lp.clickLoginButton();
		
		LoginConfirmationPage lcpPage = new LoginConfirmationPage(driver);
		
		if(result.equalsIgnoreCase("Valid"))
		{
			if(lcpPage.confirmLoginSuccessfulText().equalsIgnoreCase("Congratulations student. You successfully logged in!"))
			{
				lcpPage.clickLogOutButton();
				Assert.assertTrue(true,"Correct Test");
			}
			else
			{
				Assert.assertTrue(false,"Incorrect Test");
			}
		}
		
		if(result.equalsIgnoreCase("Invalid"))
		{
			if(lcpPage.confirmLoginSuccessfulText().equalsIgnoreCase("Congratulations student. You successfully logged in!"))
			{
				lcpPage.clickLogOutButton();
				Assert.assertTrue(false,"Incorrect Test");
			}
			else
			{
				Assert.assertTrue(true,"Correct Test");
			}
		}
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		
	}

}
