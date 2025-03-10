package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
	
	public static void main(String[] args) throws Exception {
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://qa-internal-auth.neokred.tech:9070/login");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("murali@neokred.tech");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("NKtech@123");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		Thread.sleep(2000);
		WebElement otp = driver.findElement(By.xpath("//div[@class='flex items-end']/div/input"));
		otp.click();
		Thread.sleep(2000);
		otp.sendKeys("123456");
		driver.findElement(By.xpath("//button[text()='Verify']")).click();
		Thread.sleep(2000);
		String expectedValue="Neokred";
		String actualValue = driver.getTitle();
		assertEquals(expectedValue, actualValue ,"Page Title not Found");
//		Thread.sleep(4000);
//		 WebElement ninedots = driver.findElement(By.xpath("//button[@id='headlessui-popover-button-:r0:']"));
//		 
//		 ninedots.click();
//		
//		List<WebElement> redirection = driver.findElements(By.xpath("//div[@id='headlessui-popover-panel-:r3:']/div/div[2]/div"));
//		
//		for(WebElement element:redirection)
//		{
//			String product =element.getText();
//			if(product.contains("BCRM"))
//			{
//				Thread.sleep(4000);
//				element.click();
//				
//			}
//			
//		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='leads']")).click();
//		driver.findElement(By.xpath("//div[@id='bcrm-users-create-transaction-btn']")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class='flex py-4 gap-4'][1]/div[5]/div/following-sibling::div/div/following-sibling::button")).click();
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("John");
//		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Mathew");
//		driver.findElement(By.xpath("//input[@id='jobTitle']")).sendKeys("QA");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='mobileNumber']")).sendKeys("6487283484");
//		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("murali+472374@neokred.tech");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//input[@id='businessName']")).sendKeys("Other");
//		driver.findElement(By.xpath("(//*[local-name()='svg'and @class='css-8mmkcg'])[1]")).click();
//		driver.findElement(By.xpath("//div[@id='react-select-2-option-3']")).click();
//		
//		driver.findElement(By.xpath("(//*[local-name()='svg'and @class='css-8mmkcg'])[2]")).click();
//		driver.findElement(By.xpath("//div[@class='css-1nmdiq5-menu']/div/div[1]")).click();
//		
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[text()='Save']")).click();
//		Thread.sleep(2000);
//		//button[@id='headlessui-popover-button-:r21:']
		driver.findElement(By.xpath("//div[@id='leads_leads']/div/div/div/div/div/div/div/following-sibling::div/table/thead/following-sibling::tbody/tr[2]/td[11]")).click();
		Thread.sleep(2000);
		
		
		WebElement userDetails = driver.findElement(By.xpath("//div[@id='leads_userDetails']/div/div[2]/div[2]/div[1]/div[3]/div[1]"));
		userDetails.click();
		
		driver.findElement(By.xpath("//div[@id='headlessui-popover-panel-:r2p:']/div/div/div[1]")).click();
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		lastName.clear();
		lastName.sendKeys("K");
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		Thread.sleep(2000);
		userDetails.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='headlessui-popover-panel-:r2u:']/div/div/div[2]")).click();
		
		driver.findElement(By.xpath("//button[text()='Yes']")).click();
		
		
		
//		WebElement editSpoc = userDetails.findElement(By.xpath("//button[@id='headlessui-popover-button-:r21:']"));
////		WebElement editSpoc = driver.findElement(By.xpath("//button[@id='headlessui-popover-button-:r21:']"));
//		Actions act= new Actions(driver);
//		Thread.sleep(2000);
//		act.scrollToElement(userDetails).perform();
//		Thread.sleep(2000);
//		editSpoc.click();
		
		Thread.sleep(5000);
		
		driver.quit();
	}

}
