package com.automationinfotech.Log4j;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class LoginTest {

	WebDriver driver;
	//Logger log=Logger.getLogger(LoginTest.class);
	
	 private static final Logger log = LogManager.getLogger(LoginTest.class);
	
	@BeforeMethod
	public void setup()
	{
	
		log.info("*******************************************Staring Execeution****************************");
		System.setProperty("webdriver.chrome.driver", "E:/Selenium/Software/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		log.info("Launching Browser");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");
	}
	
	
	@Test(priority=1)
	public void titleTest()
	{
		
		log.info("***********************************Test Case Start**************************************");
		String Title=driver.getTitle();
		System.out.println(Title);
		log.info("Title is:"+Title);
		log.warn("Please check the actual and expected title");
		log.fatal("This is fatal Message");
		log.debug("This is debug message");
		Assert.assertEquals(Title, "Welcome: Mercury Tours");
		log.info("***********************************Test Case Completed**************************************");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		log.info("*********************************Closing Browser**************");
		driver.close();
		log.info("***************************Browser Closed********************");
	}

	
}
