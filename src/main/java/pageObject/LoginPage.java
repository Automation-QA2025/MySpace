package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;


public class LoginPage extends BasePage {
	

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//p[@id='welcome']")
	WebElement text_Welcome;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_userEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txt_userPassword;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement bt_loginButton;
	
	@FindBy(xpath="//div[@class='flex items-end']/div/input")
	WebElement bt_Otp;
	
	@FindBy(xpath="//button[text()='Verify']")
	WebElement bt_verify;
	
	@FindBy(xpath="//p[text()='Please provide a valid email']")
	WebElement error_message_enail;
	
	public WebElement userEmail()
	{
		return txt_userEmail;
	}
	public WebElement userPassword()
	{
		return txt_userPassword;
	}
	public WebElement loginButton()
	{
		return bt_loginButton;
	}
	public WebElement OTP()
	{
		return bt_Otp;
	}
	public WebElement verify()
	{
		return bt_verify;
	}
	public WebElement LoginPageAccessed()
	{
		return text_Welcome ;
	}
	public WebElement ErrorMessage()
	{
		return error_message_enail;
	}
}
