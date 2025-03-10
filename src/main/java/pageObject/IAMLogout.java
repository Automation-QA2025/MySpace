package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class IAMLogout extends BasePage{

	public IAMLogout(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//img[@class='h-10 w-10 rounded-full']") 
	WebElement user_Profile;
	
	@FindBy(xpath="//a[text()='Logout']")  
	WebElement logout;
	
	
	public WebElement UserProfile()
	{
		return user_Profile;
	}
	public WebElement Logout()
	{
		return logout;
	}
}
