package com.Project.preetish;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Utility.BaseClass;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CRM extends BaseClass{
	
	ExtentReports report;
	ExtentTest logger;
	Logger log;
	WebDriver driver;
	String user = "preetish1234";
	String pass = "mili21sep@preetish";
	
	
	@Test(description = "This will take data from database")
	public void testDb() throws ClassNotFoundException, SQLException
	{
try{	
	
	logger = report.startTest("DatabaseTesting");
      Class.forName("com.mysql.jdbc.Driver");	
System.out.println("database loaded");

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","mili21sep");
	System.out.println("Connected to mysql DataBase");

	
	Statement smt=con.createStatement();
	ResultSet rs = smt.executeQuery("select * from userid where firstname = 'preetish1234'");

	
	while (rs.next()){

		String 	first_Name = rs.getString("firstname");
 System.out.println("Database user record is = " + first_Name + " But found " + user);
    
 if(!rs.getString("firstname").equals(user)){
	   System.out.println("invalid user");
	        logger.log(LogStatus.FAIL, "invalid user "+ user );   
   
   }else
   
	   System.out.println("user with correct credential");
      logger.log(LogStatus.INFO, "user is valid " + user);
	 
	
	String password= rs.getString("password");
System.out.println("Database password record is = "+ password);
if(!rs.getString("password").equalsIgnoreCase(pass)){
	 System.out.println("invalid password");
	   logger.log(LogStatus.FAIL, "invalid Password");

}else
	
	System.out.println("user can login with correct credential");
logger.log(LogStatus.INFO, "password is valid " + pass);
	}
	con.close();	
	}	catch (Exception e){
		System.out.println(e);
	
  }		
}
	

	@Test(description="This wil login to app",dependsOnMethods = { "testDb" },groups="Login",priority=1,alwaysRun=true)	
		
		public void LoginTOApp() throws Exception{
			
            try {
				logger = report.startTest("LoginTest");
         com.Page.loginPage account = new com.Page.loginPage(driver);
        account.My_Account(driver);
				logger.log(LogStatus.INFO, "Account click");
    account.Login(driver, user, pass);
				logger.log(LogStatus.PASS, "user can login sucessfully");
			} catch (Exception e) {
				
				e.printStackTrace();
			}	
		 
	}
	

}
