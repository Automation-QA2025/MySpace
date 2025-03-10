package pageObject;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseClass.BasePage;

public class ProductPage extends BasePage{


	public ProductPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='flex py-4 gap-4'][1]/div[1]/div/following-sibling::div/div/following-sibling::button")
	WebElement prod_Blutic;
	
	@FindBy(xpath="//div[@class='flex py-4 gap-4'][1]/div[2]/div/following-sibling::div/div/following-sibling::button")
	WebElement prod_Collectbot;
	
	@FindBy(xpath="//div[@class='flex py-4 gap-4'][1]/div[3]/div/following-sibling::div/div/following-sibling::button")
	WebElement prod_Datai;
	
	@FindBy(xpath="//div[@class='flex py-4 gap-4'][1]/div[5]/div/following-sibling::div/div/following-sibling::button")
	WebElement prod_profilex;
	
	@FindBy(xpath="//div[@class='flex py-4 gap-4'][1]/div[6]/div/following-sibling::div/div/following-sibling::button")
	WebElement prod_profilex_AIGF;
	
	@FindBy(xpath="//div[@class='flex py-4 gap-4']/div")
	List<WebElement> All_Products;
	
	
	
	
	public WebElement Blutic()
	{
		return prod_Blutic;
	}
	public WebElement Collecbot()
	{
		return prod_Collectbot;
		
	}
	public WebElement Datai()
	{
		return prod_Datai;
	}
	public WebElement Profilex()
	{
		return prod_profilex;
	}
	public WebElement Profilex_AIGF()
	{
		return prod_profilex_AIGF;
	}
	public List<WebElement> AllProducts()
	{
		return All_Products;
	}
}
