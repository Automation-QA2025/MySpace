package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class ResellerApproval extends BasePage{

	public ResellerApproval(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='px-6 -mx-2 space-y-1  mt-6']/li/button")
	List<WebElement> tab_allModules;
	
	@FindBy(xpath="(//li[@id='reportedClients'])[2]/button")
	WebElement tab_reseller;
	
	@FindBy(xpath="//tbody[@class='divide-y divide-solid divide-gray-50 ']/tr[1]/td[6]")
	WebElement view_more;
	
	@FindBy(xpath="//button[@id='RESELLERS_markAsVerified']")
	WebElement gst_markasValid;
	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement gst_Yes;
	
	@FindBy(xpath="//div[@id='RESELLERS_resellerDocuments']/div/div[2]/div/div/div[1]/button[2]")
	WebElement tab_NDA;
	
	@FindBy(xpath="//div[@class='w-full flex gap-3 justify-end p-[16px]']/div/button")
	WebElement NDA_markasvalid;
	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement NDA_yes;
	
	@FindBy(xpath="//div[@id='RESELLERS_resellerDocuments']/div/div[2]/div/div/div[1]/button[3]")
	WebElement tab_bankDetails;
	
	@FindBy(xpath="//button[@id='RESELLERS_markAsVerified']")
	WebElement bankDetails_markasValid;
	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement bankDetails_yes;
	
	@FindBy(xpath="//div[@id='RESELLERS_resellersAssignment']/div[2]/div[3]/button")
	WebElement edit_assign_to;
	
	@FindBy(xpath="//input[@placeholder='Select']")
	WebElement txt_assign_drop_down;
	
	@FindBy(xpath="//li[text()='Murali K']")
	WebElement assign_murali;
	
	@FindBy(xpath="//li[text()='sridhar c']")
	WebElement assign_sridhar;
	
	@FindBy(xpath="//div[@id='RESELLERS_resellersRncStatus']/div[2]/div/button")
	WebElement bt_status;
	
	@FindBy(xpath="//div[@id='RESELLERS_resellersRncStatus']/div[2]/div/ul/li[3]/div")
	WebElement status_approved;
	
	public List<WebElement> AllModule()
	{
		return tab_allModules;
	}
	public WebElement ResellerTab()
	{
		return tab_reseller;
	}
	public WebElement ViewMoreButton()
	{
		return view_more;
	}
	public WebElement gstMarkasValid()
	{
		return gst_markasValid;
	}
	public WebElement gstYes()
	{
		return gst_Yes;
	}
	public WebElement NDA()
	{
		return tab_NDA;
	}
	public WebElement ndaMarkasValid()
	{
		return NDA_markasvalid;
	}
	public WebElement ndaYes()
	{
		return NDA_yes;
	}
	public WebElement BankDetails()
	{
		return tab_bankDetails;
	}
	public WebElement BankDetailsMarkasValid()
	{
		return bankDetails_markasValid;
	}
	public WebElement bankDetailsYes()
	{
		return bankDetails_yes;
	}
	public WebElement AssignTo()
	{
		return edit_assign_to;
	}
	public WebElement AssignTextfield()
	{
		return txt_assign_drop_down;
	}
	public WebElement ChangeAdmin()
	{
		return assign_murali;
	}
	public WebElement ReassingToAdmin()
	{
		return assign_sridhar;
	}
	public WebElement Status()
	{
		return bt_status;
	}
	public WebElement Approved()
	{
		return status_approved;
	}
}
