package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginConfirmationPage extends BasePage {
	
	public LoginConfirmationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//strong[contains(text(),'Congratulations student. You successfully logged i')]") WebElement loginSuccessfulText;
	@FindBy(xpath="//a[contains(text(),'Log out')]") WebElement logOutButton;
	
	public String confirmLoginSuccessfulText()
	{
		String confirmationText=loginSuccessfulText.getText();
				return confirmationText;
	}
	
	public void clickLogOutButton()
	{
		logOutButton.click();
	}
}
