package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class ClientLoginpage extends BasePage{
	
	public ClientLoginpage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='emailOrMobile']")
	WebElement txt_email;
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement bt_login;
	
	@FindBy(xpath="//div[@class='flex items-end']/div/input")
	WebElement txt_otp;
	
	@FindBy(xpath="//button[text()='Verify']")
	WebElement bt_verify;
	
	@FindBy(xpath="//p[text()='Resend']")
	WebElement link_resend;
	
	public WebElement Email()
	{
		return txt_email;
	}
	public WebElement LoginButton()
	{
		return bt_login;
	}
	public WebElement OTP()
	{
		return txt_otp;
	}
	public WebElement VerifyButton()
	{
		return bt_verify;
	}
	public WebElement ResendOTP()
	{
		return link_resend;
	}
}
