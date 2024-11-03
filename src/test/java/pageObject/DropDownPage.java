package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testBase.BaseClass;

public class DropDownPage extends BasePage {
	
	public DropDownPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="country") public WebElement countryDropDown;
	
	@FindBy(xpath="//select[@id='country']//option") 
	public List<WebElement> countryList;
	
	@FindBy(xpath="//input[contains(@id,'day')]")
	public List<WebElement> checkBoxes;
	
	public void clickOnDrp()
	{
		BaseClass.js.executeScript("arguments[0].scrollIntoView(true);", countryDropDown);
		//countryDropDown.click();
	}
	
	public void selectDrpOption()
	{
		Select s = new Select(countryDropDown);
		s.selectByVisibleText("Canada");
	}
	
	public void scrollWebPage() throws InterruptedException
	{
		BaseClass.js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(5000);
		BaseClass.js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		Thread.sleep(5000);
		BaseClass.js.executeScript("window.scrollBy(0,300);");
		
	}
	
	public void selectDrpOptionMethodOne(WebElement ele,String value)
	{
		Select s = new Select(ele);
		List<WebElement> optionList = s.getOptions();
		
		for(WebElement option:optionList)
		{
			if(option.getText().equalsIgnoreCase(value))
			{
				option.click();
			}
		}
		
	}
	
	public void selectDrpMethodTwo(List<WebElement> options,String value)
	{
		for(WebElement option:options)
		{
			if(option.getText().equalsIgnoreCase(value))
			{
				option.click();
			}
		}
	}
	
	public void genericMethod(List<WebElement> options,String...values)
	{
		if(!values[0].equalsIgnoreCase("All"))
		{
			for(WebElement option:options)
			{
				String drptext = option.getAttribute("id");
				
				for(String value:values)
				{
					if(drptext.equalsIgnoreCase(value))
					{
						option.click();
					}
				}
			}
		}
		else
		{
			for(WebElement option:options)
			{
				String drptext = option.getAttribute("id");
				System.out.println(drptext);
				option.click();
			}
		}
	}

}
