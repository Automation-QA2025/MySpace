package testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListeners extends BaseClass implements ITestListener {
	
//		@Override
//	  public void onTestStart(ITestResult result) {
//		  
//		  }
//		@Override
//	  public void onTestSuccess(ITestResult result) {
//		    
//		  }

	  @Override
	  public void onTestFailure(ITestResult result) {
		  
			TakesScreenshot screenshot= (TakesScreenshot) driver;
			File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
			
			File destination = new File(System.getProperty("user.dir")+"/ScreenShot/fullpage.png");
			
			try {
				FileUtils.copyFile(sourceFile, destination);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		  }

//		@Override
//	  public void onTestSkipped(ITestResult result) {
//		   
//		  }
//		@Override
//	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		   
//		  }
//
//		@Override
//	  public void onTestFailedWithTimeout(ITestResult result) {
//		    onTestFailure(result);
//		  }
//
//		@Override
//	  public void onStart(ITestContext context) {
//		   
//		  }
//		@Override
//	  public void onFinish(ITestContext context) {
//		   
//		  }

}
