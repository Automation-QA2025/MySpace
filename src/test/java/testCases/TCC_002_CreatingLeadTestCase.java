package testCases;


import static org.testng.Assert.assertEquals;



import java.awt.Robot;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.BasicDetailsPage;
import pageObject.ClientLoginpage;
import pageObject.DashBoardPage;
import pageObject.FileUpload;
import pageObject.IAMLogout;
import pageObject.IAMUser;
import pageObject.LeadPage;
import pageObject.LogOutPage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.RNCApproval;
import pageObject.Reseller;
import pageObject.ResellerApproval;
import pageObject.ResellerLogout;

public class TCC_002_CreatingLeadTestCase extends BaseClass{

	@Test(groups={"Regression","Smoke","Master"},priority=1)
	void Login() throws Exception
	{
		try {
			LoginPage lp =new LoginPage(driver);
			lp.userEmail().sendKeys(UserEmail);
			lp.userPassword().sendKeys(Password);
			lp.loginButton().click();
			lp.OTP().sendKeys(OTP);
			lp.verify().click();
		}catch(Exception e)
		{
			Assert.fail();
		}
		
	}
	@Test(groups={"Regression","Smoke","Master"},priority=2)
	void BCRMPortalRedirection()
	{
		DashBoardPage ds =new DashBoardPage(driver);
		ds.nineDot().click();
		ds.titleBcrm().click();
	}
	@Test(groups={"Regression","Smoke","Master"},priority=3)
	void DashboardPageValidation()
	{
		String expectedValue="Neokred";
		String actualValue = driver.getTitle();
		
		System.out.println("Dashboard Expected Icon :"+actualValue+" : "+expectedValue);
		
		assertEquals(expectedValue, actualValue ,"Page Title not Found");
	}
	
	String leadEmail;
	
	@Test(groups={"Regression","Smoke","Master"},priority=4)
	public void BlueticLeadCreation() throws Exception
	{	try {
		SelectModule("Leads");
		ProductSelectingForLead("Blutic");
		String mobile = randomMobileNumber();
		String email = "murali+"+randomNumber()+"@neokred.tech";
		
		BasicDetails("Matthew","John","QA",mobile,email,"Other");
		Thread.sleep(3000);
		LeadPage lg=new LeadPage(driver);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.visibilityOf(lg.UserEmail()));
		String ActualEmail = lg.UserEmail().getText();
		String ActualMobile = lg.UserPhoneNumber().getText();
		wait.until(ExpectedConditions.visibilityOf(lg.UserEmail()));
		wait.until(ExpectedConditions.visibilityOf(lg.UserPhoneNumber()));
		Thread.sleep(3000);
		
		Assert.assertEquals(ActualEmail, email);
		Assert.assertEquals(ActualMobile, mobile);	 
		
		this.leadEmail=ActualEmail;
		
		System.out.println("Lead Created Successfully"+":"+lg.LeadName().getText());
		Thread.sleep(1000);
		validation("37AAGAT3240E1ZO","Matthew","www.demotesting.com");
		Thread.sleep(1000);
		AddSpoc("Murali","Kavalakuntla",randomMobileNumber(),"murali+"+randomNumber()+"@neokred.tech","QA");
		Thread.sleep(2000);
		DeleteSpoc();
		Thread.sleep(2000);
		addRequirement("Text Entering","Requirement Entering");
		UploadNDAFile("NDA");
		SentToRNC();
		System.out.println(ActualEmail);
	}catch(Exception e)
	{
		Assert.fail();
	}
		 
	}

//	@Test(groups={"Regression","Smoke","Master"},priority=4)
	void Collectbot() throws Exception
	{
		try {
		LeadPage lg =new LeadPage(driver);
		lg.LeadsButton().click();
		lg.AddLeadButton().click();
		ProductPage pg=new ProductPage(driver);
		pg.Collecbot().click();
		ProductSelectingForLead("Collectbot");
		String mobile = randomMobileNumber();
		String email = "murali+"+randomNumber()+"@neokred.tech";
		
		BasicDetails("Matthew","John","QA",mobile,email,"Other");
		driver.navigate().refresh();
		Thread.sleep(3000);
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		
		
		String ActualEmail = lg.UserEmail().getText();
		String ActualMobile = lg.UserPhoneNumber().getText();
		wait.until(ExpectedConditions.visibilityOf(lg.UserEmail()));
		wait.until(ExpectedConditions.visibilityOf(lg.UserPhoneNumber()));
		Thread.sleep(3000);
		Assert.assertEquals(ActualMobile, mobile);
		Assert.assertEquals(ActualEmail,email);
		
		Actions act =new Actions(driver);
		act.moveToElement(lg.ViewMoreButton()).perform();
		lg.ViewMoreButton().click();
		lg.EditGSTNumber().click();
		lg.EnterGST().sendKeys("27AACPD3544Q1ZI");
		Thread.sleep(2000);
		lg.Validate().click();
		lg.DirectorName().sendKeys("Demo");
		lg.BusinessWebSite().sendKeys("www.demotesting.com");
		Thread.sleep(3000);
		lg.companypan().click();
		act.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).perform();
		act.keyDown(Keys.COMMAND).sendKeys("c").keyUp(Keys.COMMAND).perform();
		Thread.sleep(3000);
		lg.dpan().click();
		act.keyDown(Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
		Thread.sleep(3000);
		lg.MccCode().sendKeys(randomNumber());
		lg.Din().sendKeys(randomNumber8());
		Thread.sleep(3000);
		lg.Tin().sendKeys(randomNumber());
		lg.IndustryType().click();
		lg.IndustryOption().click();
		lg.Segment().click();
		lg.SegmentOption().click();
		lg.Save().click();
		Thread.sleep(3000);
		
		AddSpoc("Murali","Kavalakuntla",randomMobileNumber(),"murali+"+randomNumber()+"@neokred.tech","QA");
		lg.AdspocCancelButton();
		driver.navigate().refresh();
		addRequirement("Text Entering","Requirement Entering");
		UploadNDAFile("NDA");
		 SentToRNC();
		}catch(Exception e)
		{
			Assert.fail();
		}
	}
	
//	@Test(groups={"Regression","Smoke","Master"},priority=5)
	public void ProfilexLeadCreation() throws Exception
	{
		Thread.sleep(3000);
		SelectModule("Leads");
		ProductSelectingForLead("Profilex");
		String mobile = randomMobileNumber();
		String email = "murali+"+randomNumber()+"@neokred.tech";
		System.out.println(email);
		BasicDetails("Melisa","mark","QA",mobile,email,"Other");
		Thread.sleep(3000);
		LeadPage lg=new LeadPage(driver);
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		String ActualEmail = lg.UserEmail().getText();
		String ActualMobile = lg.UserPhoneNumber().getText();
		wait.until(ExpectedConditions.visibilityOf(lg.UserEmail()));
		wait.until(ExpectedConditions.visibilityOf(lg.UserPhoneNumber()));
		Thread.sleep(3000);
		
		Assert.assertEquals(ActualEmail, email);
		Assert.assertEquals(ActualMobile, mobile);	
		System.out.println("Lead Created Successfully"+" : "+lg.LeadName().getText());
		validation("29AADFO5782C1Z4","Matthew","www.demotesting.com");
		Thread.sleep(1000);
  		AddSpoc("Murali","Kavalakuntla",randomMobileNumber(),"murali+"+randomNumber()+"@neokred.tech","QA");
  		Thread.sleep(2000);
		DeleteSpoc();
		Thread.sleep(2000);
		addRequirement("Text Entering","Requirement Entering");
		Thread.sleep(1000);
		Pricing();
		uploadSLA();
		UploadNDAFile("NDA");
		SentToRNC();

	}
	

//	@Test(groups={"Regression","Smoke","Master"},priority=6)
	void Profilex_AIGFLeadCreation() throws Exception
	{
		
		Thread.sleep(2000);
		SelectModule("Leads");
		ProductSelectingForLead("Profilex(AIGF)");
		String mobile = randomMobileNumber();
		String email = "murali+"+randomNumber()+"@neokred.tech";
		Thread.sleep(3000);
		BasicDetails("Sunitha","viliam","QA",mobile,email,"Other");
		LeadPage lg=new LeadPage(driver);
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		String ActualEmail = lg.UserEmail().getText();
		String ActualMobile = lg.UserPhoneNumber().getText();
		wait.until(ExpectedConditions.visibilityOf(lg.UserEmail()));
		wait.until(ExpectedConditions.visibilityOf(lg.UserPhoneNumber()));
		Thread.sleep(3000);
		
		Assert.assertEquals(ActualEmail, email);
		Assert.assertEquals(ActualMobile, mobile);	
		System.out.println("Lead Created Successfully"+":"+lg.LeadName().getText());
		Thread.sleep(1000);
		validation("37AADFO5782C1Z7","Matthew","www.demotesting.com");
		Thread.sleep(1000);
		AddSpoc("Murali","Kavalakuntla",randomMobileNumber(),"murali+"+randomNumber()+"@neokred.tech","QA");
		Thread.sleep(2000);
		DeleteSpoc();
		Thread.sleep(1000);
		addRequirement("Text Entering","Requirement Entering");
		Pricing();
		Thread.sleep(1000);
		uploadSLA();
		UploadNDAFile("NDA");
		Thread.sleep(1000);
		 SentToRNC();

		
	}
//	@Test(groups= {"Regression","Smoke","Master"},priority=7)
	void ResellerCreation() throws Exception
	{
		Thread.sleep(2000);
		SelectModule("Reseller");
		Resellercreate("ProfileX");
		String mobile = randomMobileNumber();
		String email = "murali+"+randomNumber()+"@neokred.tech";
		
		BasicDetailsforReseller("Sunitha","viliam","QA",mobile,email,"Other");
		Reseller rs = new Reseller(driver);
		Thread.sleep(3000);
		String ActualEmail = rs.getEmail().getText();
		String ActualMobile = rs.getMobileNumber().getText();
		wait.until(ExpectedConditions.visibilityOf(rs.getEmail()));
		wait.until(ExpectedConditions.visibilityOf(rs.getMobileNumber()));
		Thread.sleep(3000);
		
		Assert.assertEquals(ActualEmail, email);
		Assert.assertEquals(ActualMobile,mobile);	
		System.out.println("Reseller Created Successfully"+":"+rs.getResellerName().getText());
		Thread.sleep(1000);
		validationforReseller("37ABGPO0498M1Z1","Matthew","www.demotesting.com");
		Thread.sleep(1000);
		AddSpocforReseller("Murali","Kavalakuntla",randomMobileNumber(),"murali+"+randomNumber()+"@neokred.tech","QA");
		Thread.sleep(1000);
		addRequirementforReseller("Text Entering","Requirement Entering");
		BankDetails("Murali Kavalakuntla","35117553160","SBIN0008042");
		 UploadNDAFile("NDA");
		 Thread.sleep(1000);
		 SentToRNC();
	}
	
//	@Test(groups= {"Regression","Smoke","Master"},priority=8)
	public void Logout() throws Exception
	{	try {
		LogOutPage lg = new LogOutPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lg.ClickOnProfile())).click();
		lg.ClickOnLogout().click();
	}catch(Exception e)
	{
		Assert.fail();
	}
 }
//	@Test(groups= {"Regression","Smoke","Master"},priority=9)
	public void LeadLogin() throws Exception
	{
		ClientLoginpage loginpage=new ClientLoginpage(driver);
		driver.navigate().to(ClientLoginQAURL);
		System.out.println(leadEmail);
		loginpage.Email().sendKeys(leadEmail);
		loginpage.LoginButton().click();
		loginpage.OTP().sendKeys(OTP);
		loginpage.VerifyButton().click();
		
		LogOutPage lg = new LogOutPage(driver);
		Thread.sleep(2000);
		lg.ClickOnProfile().click();
		lg.ClickOnLogout().click();
	}
	
}







