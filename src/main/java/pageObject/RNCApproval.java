package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class RNCApproval extends BasePage{
	
	public RNCApproval(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//*[local-name()='svg' and @class='w-10 h-10 p-1  rounded-full bg-white-0 shadow-sm text-blue-20']")
	WebElement bt_ninedot;
	
	@FindBy(xpath="//div[@class='mt-2']/div[2]/a/span")
	WebElement option_Risk_Complience;
	
	@FindBy(xpath="//div[@id='headlessui-dialog-panel-:r5:']/nav/ul/li")
	List<WebElement> All_option;
	
	@FindBy(xpath="//*[@id='leads']/button")
	WebElement option_pending;
	
	@FindBy(xpath="//div[@class='flex gap-5 overflow-x-auto p-2']/div")
	List<WebElement> all_products;
	
	@FindBy(xpath="//div[@id='leads']/div/div[3]")
	WebElement produc_profilex;
	
	@FindBy(xpath="//div[@id='leads']/div/div[4]")
	WebElement produc_bluetic;
	
	@FindBy(xpath="//div[@id='leads']/div/div[5]")
	WebElement product_collectbot;
	
	@FindBy(xpath="//div[@id='leads']/div/div[6]")
	WebElement product_profilex_AIGF;
	
	@FindBy(xpath="//div[@id='leads']/div/div[7]")
	WebElement product_leanx;
	
	@FindBy(xpath="//div[@id='leads_leadsTable']/div/div/div/div/following-sibling::div/div/div/following-sibling::div/table/thead/following-sibling::tbody/tr[1]/td[10]")
	WebElement bt_ViewMore;
	
	@FindBy(xpath="//button[@id='leads_markAsVerified']")
	WebElement bt_markAsVerify_GST;
	
	@FindBy(xpath="//div[@class='flex self-end gap-4']/button[2]")
	WebElement bt_Yes;
	
	@FindBy(xpath="//div[@id='leads_leadDocuments']/div/div/following-sibling::div/div/div/div/button[2]/div/div/span")
	WebElement bt_NDA;
	
	@FindBy(xpath="//div[@id='leads_leadDocuments']/div/div[2]/div[2]/div/div/div/div/div/button")
	WebElement bt_markAsVerify_NDA;
	
	@FindBy(xpath="//div[@class='flex self-end gap-4']/button[2]")
	WebElement bt_NDA_yes;
	
	@FindBy(xpath="//div[@id='leads_leadsRncStatusUpdate']/div/button")
	WebElement drop_down_status;
	
	@FindBy(xpath="//div[@id='leads_leadsRncStatusUpdate']/div/button/following-sibling::ul/li[3]/div")
	WebElement option_Approval;
	
	@FindBy(xpath="//button[@id='headlessui-menu-button-:r2:']")
	WebElement user_profile ;
	
	@FindBy(xpath="//div[@id='headlessui-menu-items-:r4:']/a[2]")
	WebElement bt_Logout;
	
	@FindBy(xpath="//*[local-name()='svg' and @id='leads_leadsAssignedTo']")
	WebElement assign_to;
	
//	@FindBy(xpath="//div[@id='headlessui-popover-panel-:ro:']/div/div/div/div[2]/ul/li")
//	List<WebElement> assign_Option;
	
	@FindBy(xpath="//input[@placeholder='Select']")
	WebElement assign_text_field;
	
	@FindBy(xpath="//li[text()='sridhar c']")
	WebElement sridhar_c;
	
	@FindBy(xpath="(//li[text()='kavalakuntla Murali'])[1]")
	WebElement kavalakuntla_Murali;
	
	@FindBy(xpath="//div[@id='leads_leadDocuments']/div/div[2]/div/div/div/button[3]")
	WebElement tab_sla;
	
	@FindBy(xpath="//div[@id='headlessui-tabs-panel-:r2i:']/div/div/div/div/button")
	WebElement markasvalid_sla;
	
	@FindBy(xpath="//div[@class='flex self-end gap-4']/button[2]")
	WebElement bt_sla_yes;
	
	@FindBy(xpath="//div[@class='w-full flex gap-3 justify-end p-[16px]']/div/button")
	WebElement bt_markasvalid_Profilex_AIGF_SLA;
	
	@FindBy(xpath="(//div[@class='grid grid-cols-[auto,auto] gap-x-3'])[1]/div[4]/div")
	WebElement client_email;
	
	@FindBy(xpath="")
	WebElement tab_allClients;
	
	
	public WebElement nineDot()
	{
		return bt_ninedot;
	}
	public WebElement riskandcomplience()
	{
		return option_Risk_Complience;
	}
	public WebElement Pending()
	{
		return option_pending;
	}
	public WebElement  profilex()
	{
		return produc_profilex;
	}
	public WebElement  blutic()
	{
		return produc_bluetic;
	}
	public WebElement profilex_AIGF()
	{
		return product_profilex_AIGF;
	}
	public WebElement  collectbot()
	{
		return product_collectbot;
	}
	public WebElement leanx()
	{
		return product_leanx;
	}
	public WebElement  ViewMore()
	{
		return bt_ViewMore;
	}
	public WebElement GSTVerify()
	{
		return bt_markAsVerify_GST;
	}
	public WebElement GstYes()
	{
		return bt_Yes;
	}
	public WebElement NDA()
	{
		return bt_NDA;
	}
	public WebElement NDAVerify()
	{
		return bt_markAsVerify_NDA;
	}
	public WebElement NDAYes()
	{
		return bt_NDA_yes;
	}
	public WebElement Statu()
	{
		return drop_down_status;
	}
	public WebElement Approval()
	{
		return option_Approval;
	}
	public WebElement ClickonProfile()
	{
		return user_profile;
	}
	public WebElement logout()
	{
		return bt_Logout;
	}
	public List<WebElement> AllProducts()
	{
		return all_products;
	}
	public WebElement AssignTo()
	{
		return assign_to;
	}
//	public List<WebElement> AssignOption()
//	{
//		return assign_Option;
//	}
	public WebElement AssignTextfield()
	{
		return assign_text_field;
	}
	public WebElement ReassignAdmin()
	{
		return sridhar_c;
	}
//	public List<WebElement> All_option()
//	{
//		return All_option;
//	}
	public WebElement ChangeAdmin()
	{
		return kavalakuntla_Murali;
	}
	public WebElement SLA()
	{
		return tab_sla;
	}

	public WebElement SLAVerify()
	{
		return markasvalid_sla;
	}
	public WebElement SLAYes()
	{
		return bt_sla_yes;
	}
	public WebElement SLAVerify_Profilex_AIGF()
	{
		return bt_markasvalid_Profilex_AIGF_SLA;
	}
	public WebElement ClientEmail()
	{
		return client_email;
	}
	
}
