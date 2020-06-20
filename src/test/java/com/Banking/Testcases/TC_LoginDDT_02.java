package com.Banking.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Banking.PageObjects.LoginPage;
import com.Banking.Utilities.XLUtils;

//LOGIN DATA DRIVEN TEST

public class TC_LoginDDT_02 extends Baseclass
{
	@Test(dataProvider="LoginData") 
	public void LoginDDT(String user,String pwd) throws InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);	
		lp.setUserName(user);
		Logger.info("user name provided"); //jus a msg to display in console
		lp.setPassword(pwd);
		Logger.info("Password provided");
		lp.clickSubmit();
		
		
		Thread.sleep(3000);

		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			Logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			Logger.info("Login Passed");
			lp.clickLogout(); //logging out wn credentials are crct
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent(); //focus on login

		}
	}
	//valid and invalid UN and pwd , error alert for invalid
	//user defined method to check alert is present or not
	public boolean isAlertPresent() // userdefined method to chk alert present or nt ,boolean gives true/false IF ALERT PRESENT OR NT
	{
		try{
			driver.switchTo().alert(); // if alert is not present throws exception
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}





	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+ "/src/test/java/com/Banking/TestData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "sheet1");
		int colcount=XLUtils.getCellCount(path, "sheet1", 1);

		String logindata[][]=new String[rownum][colcount]; //creating 2dim array
		//to get data , in excel "0" is header
		for(int i=1;i<=	rownum;i++) //rows
		{
			for(int j=0;j<colcount;j++) //cols
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"sheet1",i,j); // 1 0 -- to get celldtata
			}
		}
		return logindata;

	}
}
