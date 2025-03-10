package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class DashBoardPage extends BasePage{


	public DashBoardPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//img[@class='h-8 w-auto lg:block ml-8']")  
	WebElement text_Neokred;
	
	@FindBy(xpath="//button[@id='headlessui-popover-button-:r0:']")
	WebElement bt_nineDot;
	
	@FindBy(xpath="//div[@id='nav_item_bcrm']")
	WebElement title_Bcrm;
	
	@FindBy(xpath="//ul[@class='px-6 -mx-2 space-y-1 mt-6']/li")  
	List<WebElement> tab_all;
	
	public WebElement nineDot()
	{
		return bt_nineDot;
	}
	public WebElement titleBcrm()
	{
		return title_Bcrm;
	}
	public WebElement DashBoardVerify()
	{
		return text_Neokred;
	}
	public List<WebElement> AllTabs()
	{
		return tab_all;
	}
	
	
}
