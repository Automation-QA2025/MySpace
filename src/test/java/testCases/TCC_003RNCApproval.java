package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObject.ClientLoginpage;
import pageObject.LogOutPage;
import pageObject.LoginPage;
import pageObject.RNCApproval;
import pageObject.ResellerApproval;
import pageObject.ResellerLogout;

public class TCC_003RNCApproval extends BaseClass{
	String ClientEmail;

	@Test(groups= {"Regression","Smoke","Master"},priority=1)
	void RNCLogin() throws Exception
	{
		driver.navigate().to(QaURL);
		LoginPage lp =new LoginPage(driver);
		lp.userEmail().sendKeys(RNCAdmin);
		lp.userPassword().sendKeys(Password);
		Thread.sleep(3000);
		lp.loginButton().click();
		lp.OTP().sendKeys(OTP);
		lp.verify().click();
		
		}
	@Test(groups= {"Regression","Smoke","Master"},priority=2)
	void RedirectionToRNC() throws Exception
	{
	RNCApproval rn=new RNCApproval(driver);
		rn.nineDot().click();
		Thread.sleep(3000);
		rn.riskandcomplience().click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(rn.Pending())).click();	
		wait.until(ExpectedConditions.visibilityOfAllElements(rn.AllProducts()));
	}

	
//	@Test(groups= {"Regression","Smoke","Master"},priority=3)
	void RNCApproval_Profilex() throws Exception
	{
		Thread.sleep(1000);
		RNCApproval("ProfileX");
		RNCProductApproval("ProfileX");
	
	}
//	@Test(groups= {"Regression","Smoke","Master"},priority=4)
	void RNCApproval_Blutic() throws Exception
	{
		Thread.sleep(1000);
		RNCApproval("Blutic");
		RNCProductApproval("Blutic");
	}
	
//	@Test(groups= {"Regression","Smoke","Master"},priority=5)
	void RNCApproval_Profilex_AIGF() throws Exception
	{
		Thread.sleep(1000);
		RNCApproval("Profilex(AIGF)");
		RNCProductApproval("Profilex(AIGF)");
		
	}
	@Test(groups= {"Regression","Smoke","Master"},priority=6)	
	void ClientEmailFetchingGe()throws Exception
	{
		Thread.sleep(1000);
		String clientEmail=ClientEmailFetching();
		this.ClientEmail=clientEmail;
		
	}
	
	@Test(groups= {"Regression","Smoke","Master"},priority=7)
	void RNCResellerApproval() throws Exception 
	{
		ResellerApproval rp=new ResellerApproval(driver);			
		Thread.sleep(2000);
		rp.ResellerTab().click();
		wait.until(ExpectedConditions.elementToBeClickable(rp.ViewMoreButton())).click();

		rp.gstMarkasValid().click();
		rp.gstYes().click();
		Thread.sleep(2000);
		
		rp.NDA().click();
		wait.until(ExpectedConditions.elementToBeClickable(rp.ndaMarkasValid())).click();
		rp.ndaYes().click();
		Thread.sleep(2000);
		
		rp.BankDetails().click();
		rp.BankDetailsMarkasValid().click();
		rp.bankDetailsYes().click();
		Thread.sleep(2000);
		
		rp.AssignTo().click();
		wait.until(ExpectedConditions.elementToBeClickable(rp.AssignTextfield())).sendKeys("Murali K");
		Actions act=new Actions(driver);
		act.moveToElement(rp.ChangeAdmin()).perform();
		rp.ChangeAdmin().click();
		Thread.sleep(2000);
		rp.AssignTo().click();
		wait.until(ExpectedConditions.elementToBeClickable(rp.AssignTextfield())).sendKeys("sridhar c");
		act.moveToElement(rp.ReassingToAdmin()).perform();
		rp.ReassingToAdmin().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(rp.Status())).click();
		wait.until(ExpectedConditions.elementToBeClickable(rp.Approved())).click();
	}
	@Test(groups= {"Regression","Smoke","Master"},priority=8)
	public void RNCLogout()throws Exception
	{
		ResellerLogout rl=new ResellerLogout(driver);
		Thread.sleep(2000);
		rl.ProfileIcon().click();
		rl.RNCLogout().click();
	}
//	@Test(groups= {"Regression","Smoke","Master"},priority=9)
	public void ClientLogin() throws Exception
	{
		ClientLoginpage loginpage=new ClientLoginpage(driver);
		driver.navigate().to(ClientLoginQAURL);
		wait.until(ExpectedConditions.elementToBeClickable(loginpage.Email()));
		loginpage.Email().sendKeys(ClientEmail);
		loginpage.LoginButton().click();
		loginpage.OTP().sendKeys(OTP);
		wait.until(ExpectedConditions.elementToBeClickable(loginpage.VerifyButton())).click();
		
		LogOutPage lg = new LogOutPage(driver);
		Thread.sleep(2000);
		lg.ClickOnProfile().click();
		lg.ClickOnLogout().click();
	}
}
