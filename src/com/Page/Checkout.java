package com.Page;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;








import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;






import com.Utility.BaseClass;
import com.Utility.Helper;
import com.google.common.base.Function;
import com.relevantcodes.extentreports.LogStatus;



public class Checkout extends BaseClass{
	
	WebDriver driver;
	
	public Checkout(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how=How.XPATH,using=".//*[@id='fancy_notification_content']/a[1]")
	public WebElement checkOut_link;
	
	

	public void CheckOut(WebDriver driver){
	
    try {
    //	new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fancy_notification_content']/a[1]")));
   
    	
    	
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
         .withTimeout(30, TimeUnit.SECONDS)
         .pollingEvery(250, TimeUnit.MILLISECONDS)
         .ignoring(NoSuchElementException.class);
        
         WebElement element = wait.until(new Function<WebDriver, WebElement>() 
        		 {
       public WebElement apply(WebDriver driver) 
{

    // find the element

     WebElement ele = driver.findElement(By.xpath(".//*[@id='fancy_notification_content']/a[1]"));

        String value = ele.getAttribute("innerHTML");

                   if (value.equalsIgnoreCase("Go to Checkout")) 
                    { 

                        return ele;

                   }
                   else
                   {
      System.out.println("Text wil come oc screen >>> "+value);
      logger.log(LogStatus.INFO,"Text wil come oc screen >>> "+value);
         return null;
              }
           }

        });



        System.out.println("Final visible status is >>>>> " + element.isDisplayed());

   


    	
   JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",checkOut_link );
                
		logger.log(LogStatus.INFO, "click in checkout");
		   }
    catch (Exception e) {
		e.printStackTrace();
	}
	}
    
	@FindBy(how = How.XPATH,using="//a[@class='step2']")
	public WebElement Continous_Bottom;
	
	
	   public void cLickB0ttom(WebDriver driver){
		try {
			Helper.highLightElement(driver, Continous_Bottom);
			Helper.explicitWait(driver, "//a[@class='step2']");
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",Continous_Bottom );
         logger.log(LogStatus.INFO, "Continue Bottom click");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}
	

}
