package com.Banking.Testcases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Banking.Utilities.ReadConfig;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;  // only this works with logs
import org.apache.log4j.PropertyConfigurator;
public class Baseclass {

	ReadConfig readconfig = new ReadConfig(); // creating obj for Readconfig class
	
	//with readconfig variables can be soft coded  - 2method
	//so in future whenevr you wanna chnage path , can change it oly in config.prop
	public String baseURL= readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password= readconfig.getPassword();
	
	//hardcoding values  - 1method
	/*public String baseURL = "http://www.demo.guru99.com/v3/index.php";
	public String username="mngr265343";
	public String password="YpahUtY";*/
	
	public static WebDriver driver;
	public static Logger Logger;  // logs to testcases
	
	@Parameters("browser")
	@BeforeClass
	//public void setup()   // FOR ONLY ONE BROWSER TESTING
	
	public void setup(String br) /// FOR CROSS BROWSER TESTING USING VAR br
	{
		//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe"); //1method-hardcoded
		//driver = new ChromeDriver();
		Logger = Logger.getLogger("ebanking");  //name of the prjct ebanking in logger
		PropertyConfigurator.configure("Log4j.properties");
	
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath()); //2method
			driver= new ChromeDriver();
		}
		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEpath());
			driver= new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);
}
    @AfterClass
	public void tearDown()
    {
    	driver.quit();
    }

   
    public void capturescreenshot(WebDriver driver,String tname) throws IOException
	{
    TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screeshot captured");
}
  //every customer sld hv unique emailaddress , sld pass unique id everytime in automation
  	//hardcoding not possible so generating randomly emailid dynamically
//**whatever are common resources/methods using across all testcases sld be part of base class
	public String randomstring()
	{
		//Java has predefined class RandomStringUtils
		String generatedstring = RandomStringUtils.randomAlphabetic(8); //pass 8chars
		return(generatedstring);}
	public String randomnum()
	{
		//Java has predefined class RandomStringUtils
		String generatedstring2 = RandomStringUtils.randomNumeric(4) ;//generating num with num
		return(generatedstring2);}




}

