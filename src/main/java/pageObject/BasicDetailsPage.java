package pageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BasePage;

public class BasicDetailsPage extends BasePage {

	
	
	public BasicDetailsPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement txt_FirstName;
	
	@FindBy(xpath="//input[@id='middleName']")
	WebElement txt_middleName;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement txt_LastName;
	
	@FindBy(xpath="//input[@id='jobTitle']")
	WebElement txt_JobTitle;
	
	@FindBy(xpath="//input[@id='mobileNumber']")
	WebElement txt_MobileNumber;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='businessName']")
	WebElement txt_BusinessName;
	
	@FindBy(xpath="(//*[local-name()='svg'and @class='css-8mmkcg'])[1]")
	WebElement drop_down_Source;
	
	@FindBy(xpath="//div[@id='react-select-2-option-3']")
	WebElement source;
	
	@FindBy(xpath=" //div[@id='react-select-3-option-2']")
	WebElement reseller;
	
	@FindBy(xpath="(//*[local-name()='svg'and @class='css-8mmkcg'])[2]")
	WebElement drop_down_LeadOwner;
	
	@FindBy(xpath="(//*[local-name()='svg'and @class='css-8mmkcg'])[2]")
	WebElement drop_down_QAReseller;
	
	@FindBy(xpath="(//*[local-name()='svg'and @class='css-8mmkcg'])[3]")
	WebElement drop_down_Reseller;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement bt_Save;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement bt_Cancel;
	
	
	public WebElement SetFirstName()
	{
		return txt_FirstName;
	}
	public WebElement SetMiddleName()
	{
		return txt_middleName;
	}
	public WebElement SetLastName()
	{
		return txt_LastName;
	}
	public WebElement SetJobTitle() {
		return txt_JobTitle;
	}
	public WebElement SetMobileNumber()
	{
		return txt_MobileNumber;
	}
	public WebElement SetEmail()
	{
		return txt_Email;
	}
	public WebElement SetBusinessName() {
		return txt_BusinessName;
	}
	public WebElement SetSource() {
		return(drop_down_Source);
	}
	public WebElement SetLeadOwner() {
		return(drop_down_LeadOwner);
	}
	public WebElement SetResellerQA()
	{
		return(drop_down_QAReseller);
	}
	public WebElement SetReseller() 
	{
		return(drop_down_Reseller);
	}
	public WebElement ClickSaveButton() {
		return(bt_Save);
	}
	public WebElement ClickCancelButton() {
		return bt_Cancel;
	}
	public WebElement Source()
	{
		return source;
	}
	public WebElement Reseller()
	{
		return reseller;
	}
	
}
