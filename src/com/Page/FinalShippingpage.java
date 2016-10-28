package com.Page;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Utility.BaseClass;
import com.Utility.Helper;
import com.relevantcodes.extentreports.LogStatus;



public class FinalShippingpage extends BaseClass{

	WebDriver driver;

	public FinalShippingpage(WebDriver driver){
	PageFactory.initElements(driver, this);
	}
	
    @FindBy(how=How.XPATH,using="//input[contains(@class,'button')]")
public WebElement Purchase;


public void purchaseClick(WebDriver driver) throws Exception{

	try {
		
		
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Purchase);
			Helper.highLightElement(driver, Purchase);
		
		Purchase.click();
		
		logger.log(LogStatus.INFO, "Sucessfully purches");
	} catch (Exception e) {
	
		e.printStackTrace();
	}
}
}