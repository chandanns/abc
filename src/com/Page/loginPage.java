package com.Page;





import junit.framework.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Utility.BaseClass;
import com.Utility.Helper;
import com.relevantcodes.extentreports.LogStatus;






public class loginPage extends BaseClass {
	
	
	WebDriver driver;
	
	
	public loginPage(WebDriver driver){
    //Initialize my object in this page
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(how=How.XPATH,using="//a[contains(.,'AccountMy Account')]")
	public  WebElement MyAccount;
	
	
	    public void My_Account(WebDriver driver){
	      
	    	Helper.highLightElement(driver, MyAccount);
	    	
	    	JavascriptExecutor executor = (JavascriptExecutor)driver;
		    executor.executeScript("arguments[0].click();",MyAccount);
	       
		    logger.log(LogStatus.INFO, "Cilck on account");
		    
	       Helper.captureScreenshot(driver, "MyAccount");
	
}
	    //Login functionality
	    @FindBy(how = How.XPATH,using="//input[@id='log'][@name='log']")
        public WebElement username;
	    
	    @FindBy(how=How.XPATH,using="//input[@id='pwd'][@name='pwd']")
	    public WebElement password;
	    
	    @FindBy(how = How.XPATH,using="//input[@id='login'][@name='submit']")
	    public WebElement LoginBottom;
	    
	  //Login functionality
	    public void Login(WebDriver driver, String user , String pass) throws Exception{

	
	    	  try {
	    		  
	    		  
	    		  try {
	    			  
					Actions action = new Actions(driver);
					 action.sendKeys(username, user).build().perform();
					Helper.highLightElement(driver, username);
			       
					//	((JavascriptExecutor)driver).executeScript("document.getElementById('log').value='preetish1234';");
					 
					  String userid = "preetish1234";
     Assert.assertEquals("invalid user", userid, user);
     logger.log(LogStatus.INFO, "User can Type");
				} catch (NoSuchElementException e) {
					
					e.printStackTrace();
				}
			
				  
				try {
					Helper.highLightElement(driver, password);
					password.click();  
					password.sendKeys(pass);
					  
					  
					  String password ="mili21sep@preetish";
 Assert.assertEquals("invaild password",password, pass);
   logger.log(LogStatus.INFO, "user can type in the password field");
				} catch ( NoSuchElementException e) {
					e.printStackTrace();
				}
			
	    	  
	    	  
	    	  Helper.highLightElement(driver, LoginBottom);
	    	  LoginBottom.click();
	    	  logger.log(LogStatus.INFO, "click on loginbuttom");
	    	
	       	  
	    	  } catch (Exception e) {
					
					e.printStackTrace();
				}
		    	  
	    	
	    }
	    
	    
}