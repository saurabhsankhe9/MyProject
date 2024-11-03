package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage 
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="username") WebElement usernameTextBox;
	@FindBy(id="password") WebElement passwordTextBox;
	@FindBy(id="submit") WebElement loginButton;
	
	public void setUserName(String userName)
	{
		usernameTextBox.sendKeys(userName);
	}
	
	public void setPassWord(String passWord)
	{
		passwordTextBox.sendKeys(passWord);
	}
	
	public void clickLoginButton()
	{
		loginButton.click();
	}
	

}
