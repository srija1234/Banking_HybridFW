package com.Banking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	//all pageobjects are in this package
	WebDriver ldriver;   //localdriver
	//creating constructor
	public LoginPage(WebDriver rdriver)  //remote driver // we using constructor in other classes so mk it as public
	{
		ldriver = rdriver;  
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="uid")
	//CacheLookup attribute can be used to instruct the InitElements() method to cache the element
	//once its located and so that it will not be searched over and over again
	@CacheLookup 
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup 
	WebElement txtPassword;

	@FindBy(name="btnLogin")
	@CacheLookup 
	WebElement btnLogin;
	
	@FindBy(xpath="/html[1]/body[1]/div[3]/div[1]/ul[1]/li[15]/a[1]")
	@CacheLookup 
	WebElement lnkLogout; 

    public void setUserName(String uname)
    {
	   txtUserName.sendKeys(uname);
    }
    public void setPassword(String pwd)
    {
	   txtPassword.sendKeys(pwd);
    }
    public void clickSubmit()
    {
	   btnLogin.click();
    }

    public void clickLogout()
    {
    	lnkLogout.click();
    }
    }

