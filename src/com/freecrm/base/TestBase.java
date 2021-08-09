package com.freecrm.base;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Parameters;

import com.freecrm.pages.ContactPage;
import com.freecrm.pages.HomePage;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.WebListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import atu.testrecorder.ATUTestRecorder;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebListener weblistener;
	public static EventFiringWebDriver e_driver;
	public static ATUTestRecorder recorder;
	
	public static LoginPage loginpage;
	public static HomePage homepage;
	public static ContactPage contactpage;
	
	public static ExtentReports extent;
	public static ExtentTest logger;
	
	// da esmo constructor bykon nafs esm el class w da awel 7aga byt3mlha run 3ashan kda 
	//ha3araf gwah el properties
	public TestBase() throws IOException { 
	    prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\workspace\\FreeCRMApplication\\src\\com\\freecrm\\config\\config.properties");
		prop.load(fis);
	}
	
	@Parameters({"browser"})
	public void initialization(String browser) {
		
		if (browser.contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\programs\\embedded\\browsers_drivers\\chrome\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browser.contentEquals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\programs\\embedded\\browsers_drivers\\firefox\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
	
	weblistener = new WebListener();
	e_driver = new EventFiringWebDriver(driver);
	e_driver.register(weblistener);
	driver=e_driver;
	driver.get(prop.getProperty("URL"));
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

}
}