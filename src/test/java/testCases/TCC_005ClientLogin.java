package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pageObject.ClientLoginpage;

public class TCC_005ClientLogin extends BaseClass{
	
	@Test(groups={"Regression","Smoke","Master"},priority=1)
	void LeadLogin() throws Exception
	{
		TCC_002_CreatingLeadTestCase createlead = new TCC_002_CreatingLeadTestCase();
		driver.navigate().to(ClientLoginQAURL);
//		String leademail = createlead.BlueticLeadCreation();
		
		ClientLoginpage loginpage=new ClientLoginpage(driver);
		
//		loginpage.Email().sendKeys(leademail);
		loginpage.LoginButton().click();
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(loginpage.ResendOTP())).click();
		loginpage.OTP().sendKeys("123456");
		loginpage.VerifyButton().click();
		
	}
//	@Test(groups={"Regression","Smoke","Master"},priority=2)
	void IAMUserLogin()
	{
		
	}
}
