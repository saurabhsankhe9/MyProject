package testCases;

import org.testng.annotations.Test;

import pageObject.DropDownPage;
import testBase.BaseClass;

public class TC_001DropDownTest extends BaseClass{
	
	@Test
	public void selectCountry() throws InterruptedException
	{
		DropDownPage ddp = new DropDownPage(driver);
		
		ddp.clickOnDrp();
		ddp.selectDrpMethodTwo(ddp.countryList,"India");
		//ddp.genericMethod(ddp.countryList,"India");
		ddp.scrollWebPage();
		
	}

}
