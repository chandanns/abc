package com.Page;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.Utility.BaseClass;
import com.Utility.Helper;
import com.relevantcodes.extentreports.LogStatus;





public class Product_category extends BaseClass {
	
	WebDriver driver;
	
	public Product_category(WebDriver driver){
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(how=How.XPATH,using="//a[contains(.,'Product Category')]")
	public WebElement productcategory;
	
	
	@FindBy(how = How.XPATH,using ="//a[contains(text(),'Accessories')]")
    public WebElement accessories;
    
	
	
	@FindBy(how = How.XPATH,using =".//*[@id='default_products_page_container']/div[3]/div[2]/form/div[2]/div[1]/span/input")
    public WebElement addChart;
	
	
	
	
	//Mouse hover
	//add to chart
	public void ProductAction(WebDriver driver) throws InterruptedException{
		
	   
		try {
			
			
		
		
			Helper.highLightElement(driver, productcategory);
			//util.isElementPresnt(driver, "//a[contains(.,'Product Category')]", 30);
		    Helper.Hover(driver, productcategory);
			
			
			
			Helper.highLightElement(driver, accessories);
			Helper.isElementPresnt(driver, "//a[contains(text(),'Accessories')]", 10);
			
			
	//javaScript to click on the hover action without loading
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",accessories );
			logger.log(LogStatus.INFO, "Click on Accessories");
			 
			//
			//((JavascriptExecutor)driver).executeScript("scroll(0,50)");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",addChart );
		
			
			//new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='default_products_page_container']/div[3]/div[2]/form/div[2]/div[1]/span/input")));
			
			JavascriptExecutor executor1 = (JavascriptExecutor)driver;
			executor1.executeScript("arguments[0].click();",addChart );
			List<WebElement> addChart = driver.findElements(By.xpath(".//*[@id='default_products_page_container']/div[3]/div[2]/form/div[2]/div[1]/span/input")); 
             		for(int i =0; i< addChart.size();i++){
             			
             			WebElement localclick = addChart.get(i);
             			
             	     String value = localclick.getAttribute("innerHTML");
             			System.out.println("values are - " + value);
             		
             			if (value.equalsIgnoreCase("Add To Cart")){
             				localclick.click();
             				logger.log(LogStatus.INFO, "Click on AddCart");
             				break;		
             			}
             			
             		}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	
}
