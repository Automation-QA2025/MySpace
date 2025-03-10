package testCases;

import static org.testng.Assert.assertListContains;






import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.net.PasswordAuthentication;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import javax.mail.internet.AddressException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generalUtility.Email;
import generalUtility.Utility;
import pageObject.AllClients;
import pageObject.BasicDetailsPage;
import pageObject.DashBoardPage;
import pageObject.FileUpload;
import pageObject.IAMUser;
import pageObject.LeadPage;
import pageObject.LoginPage;
import pageObject.ProductPage;
import pageObject.RNCApproval;
import pageObject.Reseller;

public class BaseClass implements Utility{
	
	
	
	public WebDriver driver;
	public Logger logger;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
	LeadPage lp =new LeadPage(driver);
	@BeforeClass(groups={"Regression","Smoke","Master"})
	@Parameters({"OS","browser"})
	void SetUp(String os,String br)
	{
	logger= LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome":driver= new ChromeDriver(); break;
		case "edge"	 :driver= new EdgeDriver(); break;
		default :System.out.println("No Browser Selected");return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(QaURL);
	}

	public String randomNumber()
	{
		String randomNum=RandomStringUtils.randomNumeric(5);
		return randomNum;
	}
	public String randomNumber8()
	{
		String randomNum8=RandomStringUtils.randomNumeric(8);
		return randomNum8;
	}
	public String randomMobileNumber()
	{
		String randomMobile=RandomStringUtils.randomNumeric(10);
		return randomMobile;
	}
	@Test
	public String getDataFromExcel(String SheetName,int row,int cell) throws IOException
	{
		FileInputStream file = new FileInputStream(Utility.ExcelPath);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(SheetName);
		Cell value = sheet.getRow(row).getCell(cell);
		return (value.toString());
		
	}
	public void BasicDetails(String Firstname,String LastName,String job,String MobileNumber,String Email,String BussinessName) throws Exception
	{
		BasicDetailsPage bd=new BasicDetailsPage(driver);
		bd.SetFirstName().sendKeys(Firstname);
		bd.SetLastName().sendKeys(LastName);
		bd.SetJobTitle().sendKeys(job);
		bd.SetMobileNumber().sendKeys(MobileNumber);
		bd.SetEmail().sendKeys(Email);
		bd.SetBusinessName().sendKeys(BussinessName);
		bd.SetSource().click();
		wait.until(ExpectedConditions.elementToBeClickable(bd.Source()));
		bd.Source().click();
		bd.SetResellerQA().click();
		wait.until(ExpectedConditions.elementToBeClickable(bd.Reseller()));
		bd.Reseller().click();	
		bd.ClickSaveButton().click();
		
	}
	public void UploadNDAFile(String FileName) throws Exception
	{
		FileUpload fl =new FileUpload(driver);
		WebElement element = fl.AddDocument();
		Actions act =new Actions(driver);
		act.moveToElement(element).perform();
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		Thread.sleep(3000);
		fl.SendFile().sendKeys(FilePath);	
		fl.RemoveName().click();
		act.keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).keyDown(Keys.BACK_SPACE).perform();
		fl.RemoveName().sendKeys(FileName);
		fl.upload().click();
	}
	public void AddSpoc(String FirstName,String LastName ,String MobileNumber,String Email,String Jobtitle)
	{	
		try {
		LeadPage lp =new LeadPage(driver);

		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lp.AddSpoc()));
		Actions act =new Actions(driver);
		act.scrollToElement(lp.AddSpoc()).perform();
		wait.until(ExpectedConditions.elementToBeClickable(lp.AddSpoc())).click();
		lp.FirstName().sendKeys(FirstName);
		lp.LastName().sendKeys(LastName);
		lp.MobileNumber().sendKeys(MobileNumber);
		lp.Email().sendKeys(Email);
		lp.JobTitle().sendKeys(Jobtitle);
		lp.SopcSave().click();
		} catch(Exception e)
		{
			Assert.fail();
		}
	}
	public void DeleteSpoc() throws Exception
	{
		LeadPage lp =new LeadPage(driver);
		Thread.sleep(2000);
		Actions act =new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(lp.EditSpoc()));
		act.moveToElement(lp.EditSpoc()).perform();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(lp.EditSpoc())).click();	
		wait.until(ExpectedConditions.elementToBeClickable(lp.EditButtonSpoc())).click();
		lp.LastName().clear();
		lp.LastName().sendKeys("K");
		lp.SopcSave().click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(lp.EditSpoc())).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(lp.DeleteSpoc())).click();
		wait.until(ExpectedConditions.elementToBeClickable(lp.DeleteYes())).click();
	}
	public void addRequirement(String Note,String Requirement)
	{	try {
		LeadPage lp =new LeadPage(driver);
		lp.LeadNote().click();
		lp.PlaceHolder().click();
		lp.PlaceHolder().sendKeys(Note);
		lp.LeadNoteAddButton().click();
		Thread.sleep(2000);
		lp.LeadRequirement().click();
		lp.RequirePlaceHolder().click();
		lp.RequirePlaceHolder().sendKeys(Requirement);
		lp.RequirementAdd().click();
	}	catch(Exception e)
		{
			Assert.fail();
		}
	}
	public void validation(String GSTNum,String DirectName,String BussinessWebsite)
	{	try {
		
		LeadPage lp =new LeadPage(driver);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(lp.ViewMoreButton())).click();
		lp.EditGSTNumber().click();
		lp.EnterGST().sendKeys(GSTNum);
		Thread.sleep(2000);
		lp.Validate().click();
		lp.DirectorName().sendKeys(DirectName);;
		lp.BusinessWebSite().sendKeys(BussinessWebsite);
		lp.Tin().sendKeys(randomNumber());
		lp.IndustryType().click();
		lp.IndustryOption().click();
		lp.Segment().click();
		lp.SegmentOption().click();
		Thread.sleep(2000);
		lp.Save().click();
	} catch(Exception e)
	{
		Assert.fail();
	}
	}
	public void Pricing() throws Exception
	{
		LeadPage lp =new LeadPage(driver);
		Thread.sleep(3000);
		Actions act=new Actions(driver);
		act.moveToElement(lp.PriceTab()).perform();
		lp.PriceTab().click();
		
		wait.until(ExpectedConditions.elementToBeClickable(lp.editbuttonOneTimeCost())).click();
		lp.OneTimeCredit().clear();
		lp.OneTimeCredit().sendKeys("100");
		wait.until(ExpectedConditions.elementToBeClickable(lp.oneTimeCreditSave())).click();
		lp.editClientRate().click();
		Thread.sleep(3000);
		lp.prefundAmount().clear();
		lp.prefundAmount().sendKeys("1000");
		lp.clientRateSave().click();
		
		Thread.sleep(3000);
		lp.editCommitment().click();
		Thread.sleep(3000);
		lp.totalPull().clear();
		Thread.sleep(3000);
		lp.totalPull().sendKeys("200");
		Thread.sleep(1000);
		lp.commitmentSave().click();
	}
		
		void uploadSLA() throws Exception
		{
			Actions act=new Actions(driver);
		FileUpload fu=new FileUpload(driver);
		act.moveToElement(fu.SLA()).click().perform();
		Thread.sleep(3000);
		fu.SendSLAFile().sendKeys(FilePath);
		Thread.sleep(3000);
		fu.SLAUpload().click();
		}
	
	void SentToRNC() throws Exception
	{
		LeadPage lp =new LeadPage(driver);
		Thread.sleep(3000);
		lp.SendToRNC().click();
		lp.Confirm().click();
		lp.Apply().click();	
	}
	
	public void SelectModule(String tabName) throws Exception
	{
		DashBoardPage db=new DashBoardPage(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(db.AllTabs()));
		
		for(WebElement element :db.AllTabs())
		{
			String tabText=element.getText();
			if(tabText.contains(tabName))
			{
				Thread.sleep(2000);
				element.click();
			}
		}
	}
	public void ProductSelectingForLead(String Selectedproduct) throws Exception {
		LeadPage lp =new LeadPage(driver);
		lp.AddLeadButton().click();
		ProductPage pp= new ProductPage(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(pp.AllProducts()));
		
		for(WebElement element:pp.AllProducts())
		{
			String product = element.getText();
			if(product.contains(Selectedproduct))
			{
				Thread.sleep(2000);
				element.click();
				break;
			}
			
		}		
	}
	void RNCApproval(String SelectedProduct) throws Exception
	{

		RNCApproval rn=new RNCApproval(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(rn.AllProducts()));
		for(WebElement Welement:rn.AllProducts())
		{
				String productName = Welement.getText();
		 
				if(productName.contains(SelectedProduct))
				{
					Thread.sleep(1000);
					wait.until(ExpectedConditions.elementToBeClickable(Welement)).click();
					break;
				}
				
		}
	}
	
  public void RNCProductApproval(String productName ) throws Exception
	{
		Actions act=new Actions(driver);
		RNCApproval rn=new RNCApproval(driver);
		String profilex="ProfileX";
		String profilex_AIGF="Profilex(AIGF)";
	
		if(productName == profilex || productName == profilex_AIGF )
		{
			Thread.sleep(3000);
			rn.ViewMore().click();
			rn.GSTVerify().click();
			rn.GstYes().click();
			wait.until(ExpectedConditions.elementToBeClickable(rn.NDA())).click();
			wait.until(ExpectedConditions.elementToBeClickable(rn.NDAVerify())).click();
			rn.NDAYes().click();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(rn.SLA())).click();
			Thread.sleep(2000);
			if(productName == profilex_AIGF)
			{
				wait.until(ExpectedConditions.elementToBeClickable(rn.SLAVerify_Profilex_AIGF())).click();
				wait.until(ExpectedConditions.elementToBeClickable(rn.SLAYes())).click();
			}else
			{
				wait.until(ExpectedConditions.elementToBeClickable(rn.SLAVerify())).click();
				wait.until(ExpectedConditions.elementToBeClickable(rn.SLAYes())).click();
			}
			
			Thread.sleep(3000);
			rn.AssignTo().click();
			rn.AssignTextfield().sendKeys("kavalakuntla Murali");
			act.moveToElement(rn.ChangeAdmin()).perform();
			Thread.sleep(3000);
			rn.ChangeAdmin().click();
			Thread.sleep(3000);
			rn.AssignTo().click();
			rn.AssignTextfield().sendKeys("sridhar C");
			act.moveToElement(rn.ReassignAdmin()).perform();
			Thread.sleep(3000);
			rn.ReassignAdmin().click();
			rn.Statu().click();
			rn.Approval().click();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(rn.Pending())).click();
			
		}
		else {
			Thread.sleep(3000);
			rn.ViewMore().click();
			rn.GSTVerify().click();
			rn.GstYes().click();
			Thread.sleep(3000);
			rn.NDA().click();
			rn.NDAVerify().click();
			rn.NDAYes().click();		
			Thread.sleep(3000);
			rn.AssignTo().click();
			rn.AssignTextfield().sendKeys("kavalakuntla Murali");
			act.moveToElement(rn.ChangeAdmin()).perform();
			Thread.sleep(3000);
			rn.ChangeAdmin().click();
			Thread.sleep(3000);
			rn.AssignTo().click();
			rn.AssignTextfield().sendKeys("sridhar C");
			act.moveToElement(rn.ReassignAdmin()).perform();
			Thread.sleep(3000);
			rn.ReassignAdmin().click();
			rn.Statu().click();
			rn.Approval().click();
			Thread.sleep(4000);
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
			
			Thread.sleep(1000);
			wait.until(ExpectedConditions.elementToBeClickable(rn.Pending())).click();
			
		}

	}
  public void BasicDetailsforReseller(String Firstname,String LastName,String job,String MobileNumber,String Email,String BussinessName)
  {
	  BasicDetailsPage bd=new BasicDetailsPage(driver);
		bd.SetFirstName().sendKeys(Firstname);
		bd.SetLastName().sendKeys(LastName);
		bd.SetJobTitle().sendKeys(job);
		bd.SetMobileNumber().sendKeys(MobileNumber);
		bd.SetEmail().sendKeys(Email);
		bd.SetBusinessName().sendKeys(BussinessName);
		bd.SetSource().click();
		wait.until(ExpectedConditions.elementToBeClickable(bd.Source()));
		bd.Source().click();
		bd.ClickSaveButton().click();
  }
  
  void Resellercreate(String tabName) throws Exception
	{
	  LeadPage lp =new LeadPage(driver);
	  lp.AddLeadButton().click();
	  
	  	Reseller rs = new Reseller(driver);
//	  	rs.ResellerProducts().click();
	  	for(WebElement element :rs.ResellerProducts())
	  	{
	  		String productName=element.getText();

	  		if(productName.contains(tabName))
	  		{
	  			Thread.sleep(2000);
	  			element.click();
	  		}
	  	}
	 rs.Continue().click();
	}
  
  public void validationforReseller(String GSTNum,String DirectName,String BussinessWebsite) throws Exception
  {
	  Reseller rs = new Reseller(driver);
	  wait.until(ExpectedConditions.elementToBeClickable(rs.ViewMore())).click();
	  LeadPage lp =new LeadPage(driver);
	  Thread.sleep(2000);
	  rs.gst().click();
	  rs.setGst().sendKeys(GSTNum);
	  rs.validate().click();
		lp.DirectorName().sendKeys(DirectName);;
		lp.BusinessWebSite().sendKeys(BussinessWebsite);
		lp.Tin().sendKeys(randomNumber());
		lp.IndustryType().click();
		lp.IndustryOption().click();
		lp.Segment().click();
		lp.SegmentOption().click();
		Thread.sleep(2000);
		lp.Save().click();
	  
  }
  public void AddSpocforReseller(String FirstName,String LastName ,String MobileNumber,String Email,String Jobtitle) throws Exception {
	  Reseller rs =new Reseller(driver);
	  wait.until(ExpectedConditions.elementToBeClickable(rs.AddSpocforReseller()));
		Actions act =new Actions(driver);
		act.scrollToElement(rs.AddSpocforReseller()).perform();
		Thread.sleep(3000);
		rs.AddSpocforReseller().click();
		
		LeadPage lp =new LeadPage(driver);
		lp.FirstName().sendKeys(FirstName);
		lp.LastName().sendKeys(LastName);
		lp.MobileNumber().sendKeys(MobileNumber);
		lp.Email().sendKeys(Email);
		lp.JobTitle().sendKeys(Jobtitle);
		lp.SopcSave().click();
		
  }
  
  public void addRequirementforReseller(String note,String requirement) throws Exception
  {
	  Reseller rs =new Reseller(driver);
	  rs.addNotebutton().click();
	  rs.NotePlaceHolder().sendKeys(note);
	  rs.AddButtonNote().click();
	  Thread.sleep(2000);
	  rs.addRequirementbutton().click();
	  rs.requirementPlaceHolder().sendKeys(requirement);
	  rs.AddButtonRequirement().click();
  }
  public void BankDetails(String Hname,String Accnumber,String ifsc) throws Exception
  {
	  Reseller rs =new Reseller(driver);
	  Actions act=new Actions(driver);
	  act.moveToElement(rs.BankDetailstab()).perform();
	  rs.BankDetailstab().click();
	  Thread.sleep(3000);
	  rs.editbankdetails().click();
	  rs.AccountHolderName().sendKeys(Hname);
	  Thread.sleep(2000);
	  rs.AccountNumber().sendKeys(Accnumber);
	  rs.IfscCode().sendKeys(ifsc);
	  Thread.sleep(2000);
	  rs.bankDetailsSave().click();
	  
  }
  public void IAMUserCreation(String IamUserEmail) throws Exception
	{
		IAMUser am=new IAMUser(driver);
		driver.navigate().refresh();
		am.Users().click();
		am.AddUser().click();
		am.FirstName().sendKeys("Murali");
		am.LastName().sendKeys("Kavalakuntla");
		am.Designation().sendKeys("QA");
		am.MobileNumber().sendKeys(randomMobileNumber());
		
		am.Email().sendKeys(IamUserEmail);
		am.EmployeeCode().sendKeys("NK"+randomNumber());
		am.SelectRoleDropDown().click();
		am.BCRMUser().click();
		am.UserNext().click();
		Thread.sleep(2000);
		am.Password().sendKeys(Password);
		am.PasswordNext().click();
		
	
	}
  public void SwitchTo(String tagname)
  {
	  IAMUser am=new IAMUser(driver);
	  wait.until(ExpectedConditions.elementToBeClickable(am.NineDots())).click();
		Actions ac=new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfAllElements(am.Essential()));
		
		for(WebElement element :am.Essential())
		{
			String tagName=element.getText();
			if(tagName.equalsIgnoreCase(tagname))
			{  
				wait.until(ExpectedConditions.visibilityOf(element));
				ac.moveToElement(element).click(element).perform();
			}
		}
		
  }
  
  public void Login(String email ,String password)
  {
	  LoginPage lp =new LoginPage(driver);
		lp.userEmail().sendKeys(email);
		lp.userPassword().sendKeys(password);
		wait.until(ExpectedConditions.elementToBeClickable(lp.loginButton())).click();
		String Error = lp.ErrorMessage().getText();
		if(Error.contains("Please provide a valid email"))
		{
			lp.userEmail().clear();
			lp.userPassword().clear();
		}
		else {
			lp.OTP().sendKeys(OTP);
			lp.verify().click();
		}

  }
  public void BasicDetailsTextField(String firstName , String middleName,String lastName, String jobtitle,String mobile,String email,String bussinessName) throws Exception
  {
		BasicDetailsPage bs=new BasicDetailsPage(driver);
		bs.SetFirstName().clear();
		bs.SetFirstName().sendKeys(firstName);
		bs.SetMiddleName().clear();
		bs.SetMiddleName().sendKeys(middleName);
		bs.SetLastName().clear();
		bs.SetLastName().sendKeys(lastName);
		bs.SetJobTitle().clear();
		bs.SetJobTitle().sendKeys(jobtitle);
		bs.SetMobileNumber().clear();
		bs.SetMobileNumber().sendKeys(mobile);
		bs.SetEmail().clear();
		bs.SetEmail().sendKeys(email);
		bs.SetBusinessName().clear();
		bs.SetBusinessName().sendKeys(bussinessName);
	
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(bs.SetSource())).click();
		bs.Source().click();
		wait.until(ExpectedConditions.elementToBeClickable(bs.SetResellerQA())).click();
		bs.Reseller().click();
		bs.ClickSaveButton().click();
  }
  public String ClientEmailFetching() throws Exception
  {
	  AllClients allclients=new AllClients(driver);
	  Thread.sleep(2000);
	  wait.until(ExpectedConditions.visibilityOf(allclients.AllclientsTab()));
	  allclients.AllclientsTab().click();
	  wait.until(ExpectedConditions.elementToBeClickable( allclients.ViewMoreButton())).click();
	  wait.until(ExpectedConditions.visibilityOf(allclients.ClientEmail()));
	 String clientEmail= allclients.ClientEmail().getText();
	 
	  return clientEmail;
  }
//  @BeforeSuite(groups= {"Regression","Smoke","Master"})
  public void deleteOldReports() {
      File reportDir = new File("test-output");
      if (reportDir.exists()) {
          for (File file : reportDir.listFiles()) {
              file.delete();
          }
      }
  }
// 	@AfterSuite(groups= {"Regression","Smoke","Master"})
  public void sendMail()  {
			
  Email email = new Email();
	try {
		email.sendMailWithAttachment("/Users/murali/Automationcoderepo/Core3/test-output/emailable-report.html");
		} 
		catch (AddressException | IOException e) {
			e.printStackTrace();
		}
		
		 
	}
 	@AfterClass(alwaysRun=true)
 	public void teardown(){
		if(driver !=null)
		{
			driver.quit();
		}
	}
 	
}







