package com.Banking.Testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

//import org.apache.commons.lang3.RandomStringUtils;

import com.Banking.PageObjects.AddCustomerPage;
import com.Banking.PageObjects.LoginPage;



public class TC_AddCustomerTest_03 extends Baseclass {
    @Test
	public void addNewCCustomer() throws InterruptedException, IOException{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();
        Thread.sleep(3000);
       //to avoid the add popup
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
		driver.manage().window().maximize();
        
        //Pageobject class
		AddCustomerPage addcust = new AddCustomerPage(driver); //creating object fr page obj class
		addcust.clickAddNewCustomer();
//these values were not put in confg properties coz there r no variables here 
		addcust.custName("Anu");
		addcust.custgender("Female");
		addcust.custdob("10","15","1995");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987898091");

		String email = randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdefg");
		addcust.custsubmit();

		Thread.sleep(3000);
		Logger.info("Validation started..");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!");
		if(res==true)
		{
			Assert.assertTrue(true);
			Logger.info("test case passed...");
		}
		else
		{
			Logger.info("test case failed...");
			capturescreenshot(driver,"addNewCustomer");
			Assert.assertTrue(false);
			//Logger.warn("testcase failed---");
		}
	}}

	
