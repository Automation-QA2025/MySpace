package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class Reseller extends BasePage{

	public Reseller(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='flex py-4 gap-4']/div/input")
	List<WebElement> Reseller_allProducts;
	
	@FindBy(xpath="//tbody[@class='divide-y divide-solid divide-gray-50 ']/tr[1]/td[11]")
	WebElement bt_viewmore;
	
	@FindBy(xpath="//tbody[@class='divide-y divide-solid divide-gray-50 ']/tr[1]/td[6]")
	WebElement mobileNumber;
	
	@FindBy(xpath="//tbody[@class='divide-y divide-solid divide-gray-50 ']/tr[1]/td[7]")
	WebElement email;
	
	@FindBy(xpath="//tbody[@class='divide-y divide-solid divide-gray-50 ']/tr[1]/td[4]")
	WebElement ResellerName;
	
	@FindBy(xpath="//img[@id='reseller_editGst']")
	WebElement edit_gst;
	
	@FindBy(xpath="//input[@id='gstNumber']")
	WebElement txt_gst;
	
	@FindBy(xpath="//button[text()='Validate']")
	WebElement bt_validate;
	
	@FindBy(xpath="//*[local-name()='svg' and @id='reseller_addSpoc']")
	WebElement edit_spoc;
	
	@FindBy(xpath="//button[@id='reseller_addNotes']")
	WebElement bt_addNote;
	
	@FindBy(xpath="//textarea[@placeholder='Take a note...']")
	WebElement txt_placeholder;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement bt_add;
	
	@FindBy(xpath="//button[text()='Add Requirements']")
	WebElement bt_addRequirement;
	
	@FindBy(xpath="//textarea[@placeholder='What is the requirement from the client?']")
	WebElement txt_req_placeholder;
	
	@FindBy(xpath="//button[text()='Add']")
	WebElement bt_require_add;
	
	@FindBy(xpath="//span[text()='Bank Account']")
	WebElement bt_bank_details;
	
	@FindBy(xpath="//*[local-name()='svg' and @id='reseller_editBankAccount']")
	WebElement edit_bankDetails;
	
	@FindBy(xpath="//input[@id='accountHolderName']")
	WebElement txt_accountHolderName;
	
	@FindBy(xpath="//input[@id='accountNumber']")
	WebElement txt_accountNumber;
	
	@FindBy(xpath="//input[@id='ifscCode']")
	WebElement txt_ifscCode;
	
	
	@FindBy(xpath="//p[text()='Validate And Save']")
	WebElement bt_validate_save;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement bt_continue;
	
	
	public List<WebElement> ResellerProducts()
	{
		return Reseller_allProducts;
	}
	public WebElement ViewMore()
	{
		return bt_viewmore;
	}
	public WebElement getMobileNumber()
	{
		return mobileNumber;
	}
	public WebElement getEmail()
	{
		return email;
	}
	public WebElement getResellerName()
	{
		return ResellerName;
	}
	public WebElement gst()
	{
		return edit_gst;
	}
	public WebElement setGst()
	{
		return txt_gst;
	}
	public WebElement validate()
	{
		return bt_validate;
	}
	public WebElement AddSpocforReseller()
	{
		return edit_spoc;
	}
	public WebElement addNotebutton()
	{
		return bt_addNote;
	}
	public WebElement NotePlaceHolder()
	{
		return txt_placeholder;
	}
	public WebElement AddButtonNote()
	{
		return bt_add;
	}
	public WebElement addRequirementbutton()
	{
		return bt_addRequirement;
	}
	public WebElement requirementPlaceHolder()
	{
		return txt_req_placeholder;
	}
	public WebElement AddButtonRequirement()
	{
		return bt_require_add;
	}
	public WebElement BankDetailstab()
	{
		return bt_bank_details;
	}
	public WebElement editbankdetails()
	{
		return edit_bankDetails;
	}
	public WebElement AccountHolderName()
	{
		return txt_accountHolderName;
	}
	public WebElement AccountNumber()
	{
		return txt_accountNumber;
	}
	public WebElement IfscCode()
	{
		return txt_ifscCode;
	}
	public WebElement bankDetailsSave()
	{
		return  bt_validate_save;
	}
	public WebElement Continue()
	{
		return bt_continue;
	}
}
