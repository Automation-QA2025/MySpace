package pageObject;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class LeadPage extends BasePage{
	
	
	
	public LeadPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//li[@id='leads']")
	WebElement bt_leads;
	
	@FindBy(xpath="//div[@id='bcrm-users-create-transaction-btn']")
	WebElement bt_AddLead;
	
	@FindBy(xpath="//div[@id='leads_leads']/div/div/div/div/div/div/div/following-sibling::div/table/thead/following-sibling::tbody/tr[1]/td[11]")
	WebElement bt_ViewMore;
	
	@FindBy(xpath="//img[@id='leads_editGst']")
	WebElement Edit_bt_GST;
	
	@FindBy(xpath="//input[@id='gstNumber']")
	WebElement txt_GSTNumber;
	
	@FindBy(xpath="//button[text()='Validate']")
	WebElement bt_Validate;
	
	@FindBy(xpath="//input[@id='directorsName']")
	WebElement txt_DirectorName;
	
	@FindBy(xpath="//input[@id='businessWebsite']")
	WebElement txt_BusinessWebSite;
	
	@FindBy(xpath="//input[@id='companyPan']")
	WebElement txt_CompanyPan;
	
	@FindBy(xpath="//input[@id='tin']")
	WebElement txt_Tin;
	
	@FindBy(xpath="//div[@id='industryType']/div[1]/div/input")
	WebElement drop_down_IndustryType;
	
	@FindBy(xpath="//div[@id='industryType']/div[2]/ul/li[3]")
	WebElement drop_down_IndustryTypeOption;
	
	@FindBy(xpath="//div[@id='segment']")
	WebElement drop_down_Segment;
	
	@FindBy(xpath="//div[@id='segment']/div[2]/ul/li[2]")
	WebElement drop_down_SegmentOption;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement bt_Save;
	
	@FindBy(css="#leads_addSpoc")  
	WebElement Edit_bt_AddSpoc;
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement txt_FirstName;
	
	@FindBy(xpath="//input[@id='lastName']")
	WebElement txt_LastName;
	
	@FindBy(xpath="//input[@id='mobileNumber']")
	WebElement txt_MobileNumber;
	
	
	@FindBy(xpath="//input[@id='email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='jobTitle']")
	WebElement txt_JobTitle;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement Spocbt_Save;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement spocbt_Cancel;
	
	@FindBy(xpath="//button[@id='leads_addNotes']")
	WebElement bt_LeadNote;
	
	@FindBy(css="[placeholder='Take a note...']")
	WebElement txt_PlaceHolder;
	
	@FindBy(xpath="//div[@class='flex  justify-end gap-[16px] w-[100%]']/button[2]")
	WebElement bt_Add;
	
	@FindBy(xpath="//button[text()='Add Requirements']")
	WebElement bt_AddRequirement;
	
	@FindBy(css="[placeholder='What is the requirement from the client?']")
	WebElement txt_placeHolder;
	
	@FindBy(xpath="//div[@class='flex  justify-end gap-[16px] w-[100%]']/button[2]")
	WebElement bt_RAdd;
	
	@FindBy(xpath="//input[@id='dPan']")
	WebElement txt_Dpan;
	
	@FindBy(xpath="//input[@id='mccCode']")
	WebElement txt_Mcc;
	
	@FindBy(xpath="//input[@id='din']")
	WebElement txt_din;
	
	@FindBy(xpath="//button[text()='Send to R&C']")
	WebElement bt_SendToRNC;
	
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement bt_Confirm;
	
	@FindBy(xpath="//button[text()='Apply']")
	WebElement bt_Apply;
	
	@FindBy(xpath="//div[@id='leads_leads']/div/div/div/div/div/following-sibling::div/div/div/following-sibling::div/table/thead/following-sibling::tbody/tr[1]/td[7]")
	WebElement user_Email;
	
	@FindBy(xpath="//div[@id='leads_leads']/div/div/div/div/div/following-sibling::div/div/div/following-sibling::div/table/thead/following-sibling::tbody/tr[1]/td[6]")
	WebElement user_PhoneNumber;
	
	@FindBy(xpath="//div[@id='leads_leads']/div/div/div/div/div[2]/div/div[2]/table/thead/following-sibling::tbody/tr[1]/td[4]")
	WebElement user_name;
	
	@FindBy(xpath="//div[@class='relative flex items-center w-full']/div/div/button[2]")
	WebElement tab_price;

	@FindBy(xpath="//*[local-name()='svg' and @id='leads_editOneTimeCost']")
	WebElement edit_bt_oneTimeCost;
	
	@FindBy(xpath="//input[@id='totalOneTimeCredit']")
	WebElement txt_OneTimeCredit ;
	
	@FindBy(xpath="(//p[text()='Save'])[1]")
	WebElement bt_OnetimeCredit_Save;
	
	@FindBy(xpath="//*[local-name()='svg' and @id='leads_editClientRate']")
	WebElement edit_clientRate;
	
	@FindBy(xpath="//input[@id='prepaidPricing.prefundAmount']")
	WebElement txt_prefundAmount;
	
	@FindBy(xpath="//div[@id='leads_clientRate']/div[2]/form/div[2]/button[2]")
	WebElement bt_ClientRate_save;
	
	@FindBy(xpath="//*[local-name()='svg'and @id='leads_editCommitment']")
	WebElement edit_commitment;
	
	@FindBy(xpath="//input[@id='totalPull']")
	WebElement txt_totalPull;
	
	@FindBy(xpath="//div[@id='leads_commitment']/div[2]/form/div[2]/button[2]")
	WebElement bt_commitment_save;
	
	@FindBy(xpath="//div[@id='leads_userDetails']/div/div[2]/div[2]/div[1]/div[3]/div[1]")
	WebElement edit_3dot_editspoc;
	
	@FindBy(xpath="//div[@id='leads_editSpoc']/h1")   /* //div[@id='headlessui-popover-panel-:r2p:']/div/div/div[1] */
	WebElement bt_Spoc_editbutton;
	
	@FindBy(xpath="//div[@id='leads_deleteSpoc']/h1")
	WebElement bt_spoc_Delete;
	
	@FindBy(xpath="//button[text()='Yes']")
	WebElement bt_deleteSpoc_Yes;
	
	public WebElement LeadsButton()
	{
		return bt_leads;
	}
	public WebElement AddLeadButton()
	{
		return bt_AddLead;
	}
	public WebElement ViewMoreButton()
	{
		return bt_ViewMore;
	}
	public WebElement EditGSTNumber()
	{
		return Edit_bt_GST;
	}
	public WebElement EnterGST()
	{
		return txt_GSTNumber;
	}
	public WebElement  Validate()
	{
		return bt_Validate;
	}
	public WebElement DirectorName()
	{
		return txt_DirectorName;
	}
	public WebElement BusinessWebSite()
	{
		return txt_BusinessWebSite;
	}
	public WebElement Tin()
	{
		return txt_Tin;
	}
	public WebElement IndustryType()
	{
		return drop_down_IndustryType;
		
	}
	public WebElement IndustryOption()
	{
		return drop_down_IndustryTypeOption;
	}
	public WebElement Segment()
	{
		return drop_down_Segment;
		
	}
	public WebElement SegmentOption()
	{
		return drop_down_SegmentOption ;
	}
	public WebElement Save()
	{
		return bt_Save;
	}
	public WebElement AddSpoc() 
	{
		 return Edit_bt_AddSpoc;
	}
	public WebElement FirstName()
	{
		return txt_FirstName;
	}
	public WebElement LastName()
	{
		return txt_LastName;
		
	}public WebElement MobileNumber()
	{
		return txt_MobileNumber;
	}public WebElement Email()
	{
		return txt_Email;
	}public WebElement JobTitle()
	{
		return txt_JobTitle;
	}
	public WebElement SopcSave()
	{
		return Spocbt_Save;
		
	}public WebElement LeadNote()
	{
		return bt_LeadNote;
		
	}public WebElement PlaceHolder()
	{
		return txt_PlaceHolder;
	}
	public WebElement LeadNoteAddButton()
	{
		return bt_Add;
	}
	public WebElement LeadRequirement()
	{
		return bt_AddRequirement;
		
	}public WebElement RequirePlaceHolder()
	{
		return txt_placeHolder;
	}
	public WebElement RequirementAdd()
	{
		return bt_RAdd;
	}
	public WebElement companypan() {
		return txt_CompanyPan;
	}
	public WebElement dpan()  {
		return txt_Dpan;
	}
	public WebElement MccCode()
	{
		return txt_Mcc;
	}
	public WebElement Din()
	{
		return txt_din;
	}
	public WebElement SendToRNC()
	{
		return bt_SendToRNC;
	}
	public WebElement  Confirm()
	{
		return bt_Confirm;
	}
	public WebElement Apply()
	{
		return bt_Apply;
	}
	public WebElement UserPhoneNumber()
	{
		return user_PhoneNumber;
	}
	public WebElement UserEmail()
	{
		return user_Email;
	}
	public WebElement AdspocCancelButton()
	{
		return spocbt_Cancel;
	}
	public WebElement LeadName()
	{
		return user_name;
	}
	public WebElement PriceTab()
	{
		return tab_price;
	}
	public WebElement editbuttonOneTimeCost()
	{
		return edit_bt_oneTimeCost;
	}
	public WebElement OneTimeCredit()
	{
		return txt_OneTimeCredit;
	}
	public WebElement oneTimeCreditSave()
	{
		return bt_OnetimeCredit_Save;
	}
	public WebElement editClientRate()
	{
		return edit_clientRate;
	}
	public WebElement prefundAmount()
	{
		return txt_prefundAmount;
	}
	public WebElement clientRateSave()
	{
		return bt_ClientRate_save;
	}
	public WebElement editCommitment()
	{
		return edit_commitment;
	}
	public WebElement totalPull()
	{
		return txt_totalPull;
	}
	public WebElement commitmentSave()
	{
		return bt_commitment_save;
	}
	public WebElement EditSpoc()
	{
		return edit_3dot_editspoc;
	}
	public WebElement EditButtonSpoc()
	{
		return bt_Spoc_editbutton;
	}
	public WebElement DeleteSpoc()
	{
		return bt_spoc_Delete;
	}
	public WebElement DeleteYes()
	{
		return bt_deleteSpoc_Yes;
	}
}
