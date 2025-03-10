package testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BasePage;
import pageObject.BasicDetailsPage;
import pageObject.DashBoardPage;
import pageObject.LeadPage;
import pageObject.LoginPage;

public class TCC_001_Login extends BaseClass {
	
	@Test(groups={"Regression","Smoke","Master"},priority=1)
	public void LoginPageValidation() {
		
		try {
			LoginPage lp =new LoginPage(driver);
			
//			Login("","");
			Login("    ","    ");
			Login("murali@neokred.tech@gmail.com","password@123");
			Login("123456789","123456789");
			Login("!@#$%^&*()(", "!@#$%^&*()(");
			Login("murali@neokred.tech","password@123");
			Thread.sleep(2000);
			Login("murali@gmail.com","NKtech@123");		
			
//			lp.OTP().sendKeys(OTP);
//			wait.until(ExpectedConditions.elementToBeClickable(lp.OTP())).sendKeys(OTP);
//			lp.verify().click();
//			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().refresh();
			
			driver.navigate().to(QaURL);

			lp.userEmail().sendKeys(UserEmail);
			lp.userPassword().sendKeys(Password);
			lp.loginButton().click();
			
			lp.OTP().sendKeys(OTP);
			lp.verify().click();
			
			DashBoardPage ds =new DashBoardPage(driver);
			ds.nineDot().click();
			ds.titleBcrm().click();
			
			LeadPage lg =new LeadPage(driver);
			lg.LeadsButton().click();
			lg.AddLeadButton().click();
	
		}catch(Exception e)
		{
			Assert.fail();
		}

	}
//	@Test(groups={"Regression","Smoke","Master"},priority=2)
	public void BasicDetailsPageValidation() throws Exception
	{
		driver.navigate().refresh();
		ProductSelectingForLead("Blutic");
		BasicDetailsTextField("","","","","","","");
		
		BasicDetailsTextField("   ","    ","    ","     ","    ","     ","     ");
		
		BasicDetailsTextField("Murali123","Murali123","Murali123","Murali123","Murali123","Murali123","Murali123");
		
		BasicDetailsTextField("123456789","123456789","123456789","123456789","123456789","123456789","123456789");
		
		BasicDetailsTextField("MURALI-K","MURALI-K","MURALI-K","MURALI-K","MURALI-K","MURALI-K","MURALI-K");
		
		BasicDetailsTextField("!@#$%^&**()","!@#$%^&**()","!@#$%^&**()","!@#$%^&**()","!@#$%^&**()","!@#$%^&**()","!@#$%^&**()");

		String mobile = randomMobileNumber();
		String email="murali+"+randomNumber()+"@neokred.tech";	
		
		BasicDetailsTextField("Test","","User","QA",mobile,email,"Other");

	
	}
}
