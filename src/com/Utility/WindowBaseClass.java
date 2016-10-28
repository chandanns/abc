
package com.Utility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class WindowBaseClass 
{
	protected static WebDriver driver;
	protected ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void setupReport()
	{
		report=new ExtentReports(System.getProperty("user.dir")+"./ScreenShots/1"+Helper.getCurrentDateTime()+".html");
	}
	
	
	@AfterMethod
	public void tearDownReport()
	{
		report.endTest(WindowBaseClass.logger);
		
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		
	}
	
	@AfterSuite
	public void generateReport()
	{
		report.flush();
	}
	
}
