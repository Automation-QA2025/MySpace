package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class AllClients extends BasePage{

	public AllClients(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//tbody[@class='divide-y divide-solid divide-gray-50 ']/tr[1]/td[8]")
	WebElement table_bt_viewMore;
	
	@FindBy(xpath="(//div[@class='grid grid-cols-[auto,auto] gap-x-3'])[1]/div[4]")
	WebElement Client_Email;
	
	@FindBy(css="li[id='allClients'] button[class='text-gray-0 hover:text-gray-10 hover:bg-[#EEF1F9] group flex gap-x-3 rounded-md p-2 text-16 leading-6 w-full font-500 undefined']")
	WebElement tab_allClients;
	
	public WebElement ViewMoreButton()
	{
		return table_bt_viewMore;
	}
	public WebElement ClientEmail()
	{
		return Client_Email;
	}
	public WebElement AllclientsTab()
	{
		return tab_allClients;
	}
}
