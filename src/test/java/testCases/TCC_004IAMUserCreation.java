package testCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import pageObject.IAMLogout;
import pageObject.IAMUser;
import pageObject.LogOutPage;
import pageObject.LoginPage;

public class TCC_004IAMUserCreation extends BaseClass {

	@Test(groups= {"Regression","Smoke","Master"},priority=1)
	public void IAMLogin() throws Exception
	{
		LoginPage lp =new LoginPage(driver);
		driver.navigate().to(QaURL);
		lp.userEmail().sendKeys(AdminEmail);
		lp.userPassword().sendKeys(Password);
		Thread.sleep(3000);
		lp.loginButton().click();
		lp.OTP().sendKeys(OTP);
		lp.verify().click();
	}
	@Test(groups= {"Regression","Smoke","Master"},priority=2)
	public void RedirectionToBCRM() throws Exception
	{
		Thread.sleep(1000);
		SwitchTo("BCRM");
	}
	@Test(groups= {"Regression","Smoke","Master"},priority=3)
	public void RedirectionToIAM() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		SwitchTo("IAM");
	}
	
	String UserEmail;
	
	@Test(groups= {"Regression","Smoke","Master"},priority=4)
	void UserCreationInIAM() throws Exception
	{
		String IamUserEmail="murali+"+randomNumber()+"@neokred.tech";
		
		IAMUserCreation(IamUserEmail);
		this.UserEmail=IamUserEmail;
	}

	@Test(groups= {"Regression","Smoke","Master"},priority=5)
	public void IAMUserEdit() throws Exception
	{
		Thread.sleep(1000);
		IAMUser am=new IAMUser(driver);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(am.Users())).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(am.SelectUserInTable())).click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(am.EditUser())).click();
		am.UpdateFirstName().clear();
		am.UpdateFirstName().sendKeys("murali");
		am.UpdateLastName().clear();
		am.UpdateLastName().sendKeys("K");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(am.UpdateConfirm())).click();
	}
//	@Test(groups= {"Regression","Smoke","Master"},priority=6)
	public void GroupCreation()
	{
		IAMUser am=new IAMUser(driver);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(am.Groups())).click();
		wait.until(ExpectedConditions.elementToBeClickable(am.CreateNewGroup())).click();
		am.GroupName().sendKeys("Test");
		am.GroupConfirm().click();
		am.EditGroup().click();
		am.GroupName().sendKeys("test");
		am.GroupConfirm().click();
		wait.until(ExpectedConditions.elementToBeClickable(am.DeleteGroup())).click();
		am.ConfirmDeleteGroup().click();

	}
//	@Test(groups= {"Regression","Smoke","Master"},priority=7)
	public void policyAttachForUser() throws Exception
	{
		IAMUser am=new IAMUser(driver);
		Thread.sleep(1000);
		String IamUserEmail="murali+"+randomNumber()+"@neokred.tech";
		IAMUserCreation(IamUserEmail);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(am.AttachPolicyDirectly())).click();
		am.SelectPolicyInTable().click();
		am.AddPolicyNext().click();
		am.ConfirmPolicyNext().click();
		wait.until(ExpectedConditions.elementToBeClickable(am.UpdateUserDelete())).click();
		am.DeleteUserConfirm().click();
	}
//	@Test(groups= {"Regression","Smoke","Master"},priority=8)
	public void AddUserInGroup()
	{
		IAMUser am=new IAMUser(driver);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(am.Groups())).click();
		wait.until(ExpectedConditions.elementToBeClickable(am.CreateNewGroup())).click();
		am.GroupName().sendKeys("Test");
		am.GroupConfirm().click();
		am.AdduserGroup().click();
		am.AddsingleUserInGroup().click();
		am.AdduserInGroup().click();
		am.AdduserInGroupConfirm().click();
		wait.until(ExpectedConditions.elementToBeClickable(am.DeleteGroup())).click();
		am.ConfirmDeleteGroup().click();
	}
	@Test(groups= {"Regression","Smoke","Master"},priority=9)
	public void IAMlogout() throws Exception
	{		
		IAMLogout al=new IAMLogout(driver);
		Thread.sleep(1000);
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(al.UserProfile())).click();
		al.Logout().click();
		
	}
	@Test(groups= {"Regression","Smoke","Master"},priority=10)
	public void IAMuserLogin() throws Exception
	{
		LoginPage lp =new LoginPage(driver);
		Thread.sleep(2000);
		lp.userEmail().sendKeys(UserEmail);
		System.out.println(UserEmail);
		lp.userPassword().sendKeys(Password);
		Thread.sleep(2000);
		lp.loginButton().click();
		lp.OTP().sendKeys(OTP);
		Thread.sleep(2000);
		lp.verify().click();
		
		LogOutPage lg = new LogOutPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lg.ClickOnProfile())).click();
		lg.ClickOnLogout().click();
	}
	
}
