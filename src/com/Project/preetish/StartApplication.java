package com.Project.preetish;

import java.net.URL;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.Utility.WindowBaseClass;

public class StartApplication extends WindowBaseClass{
	
	WebDriver driver;
    @Test
	public void test1() throws InterruptedException
	{
   
    	
    	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
		capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
		capabilities.setPlatform(Platform.WIN10);
		capabilities.setBrowserName(BrowserType.CHROME);
		capabilities.setJavascriptEnabled(true);
	    capabilities.setCapability("cssSelectorsEnabled", true);
	    capabilities.setCapability("applicationCacheEnabled", true);
	    capabilities.setCapability("acceptSslCerts",true);
	    capabilities.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,System.setProperty("webdriver.chrome.driver", 
	    		                                   "C:\\Users\\preetish\\Downloads\\Compressed\\chromedriver.exe"));

    try 
	{
		URL url= new URL("http://192.168.0.103:4444/wd/hub");

		driver=new RemoteWebDriver(url , capabilities);
	    driver.manage().deleteAllCookies();
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://store.demoqa.com/");
		
	} catch (Exception e) {
		
	}
  }
}