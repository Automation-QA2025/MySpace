package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class ResellerLogout extends BasePage{

	public ResellerLogout(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//button[@id='headlessui-menu-button-:r2:']")
	WebElement profile_Icon;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement RNC_logout;
	
	public WebElement ProfileIcon()
	{
		return profile_Icon;
	}
	public WebElement RNCLogout()
	{
		return RNC_logout;
	}
}
