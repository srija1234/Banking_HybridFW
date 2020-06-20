package com.Banking.Testcases;

import org.testng.asserts.*;
import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.*;

import com.Banking.PageObjects.LoginPage;

public class TC_LoginTest_01 extends Baseclass{
	
    @Test	
    public void LoginTest() throws InterruptedException {
	driver.get(baseURL);
	//driver.getTitle();
    Logger.info("URL is opened");
  
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username); 
	Logger.info("Entered Username");//pageobj classes
	
	lp.setPassword(password);
	Logger.info("Entered Password");
	//driver.findElement(By.xpath("//*[@class='_2AkmmA _29YdH8']")).click();
	lp.clickSubmit();
	Thread.sleep(5);
	//driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
	if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) //hardcoding title
    {
    	Assert.assertTrue(true);
    	Logger.info("Login test passed");
    }
    else
    {//if the title is wrong take the screenshot
    	try {
			capturescreenshot(driver,"LoginTest");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	Assert.assertTrue(false);
    	Logger.info("Login test failed");
    }

}
	
	

}
