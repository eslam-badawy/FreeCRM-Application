package com.freecrm.testcases;


import java.io.IOException;
import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.freecrm.base.TestBase;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;


public class LoginPageTest extends TestBase {


	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

    
	@Parameters ({"browser"})
	@BeforeMethod
	public void setup(String browser,Method method) throws ATUTestRecorderException, IOException {
		logger = extent.startTest(method.getName());
		initialization(browser);
		loginpage = new LoginPage(); 
		recorder = new ATUTestRecorder("E:\\workspace\\PageObjectFreeCRM\\TestReport" , method.getName() , false);
		recorder.start();

	}

	@AfterMethod
	public void tearDown(Method method , ITestResult result) throws ATUTestRecorderException, IOException {
		recorder.stop();
		TestUtils.takePicture(method.getName());
		
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			logger.log(LogStatus.PASS, "test passed");
			logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			logger.log(LogStatus.PASS, "<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");
			
		}
		else if(result.getStatus() == ITestResult.FAILURE)
		{
			logger.log(LogStatus.FAIL, result.getThrowable());
			logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".png" + "'><span class='lable info'>Download Snapshot</span></a>");
			logger.log(LogStatus.FAIL, "<a href='" + result.getName() + ".mov" + "'><span class='lable info'>Download Video</span></a>");
			
		}
		else
		{
			logger.log(LogStatus.SKIP, "test skipped");

		}
		driver.quit();
	}

	@Test(priority = 1)
	public void titleTest() {
		String Expectedresult = ("Free CRM - CRM software for customer relationship management, sales, and support.");
		String Actualresult = loginpage.getTitle();
		System.out.println(Actualresult);
		Assert.assertEquals(Actualresult, Expectedresult, "the title is not correct");
	
	}

	@Test(priority = 2)
	public void urlCheck()  {
		String Expectedresult = ("https://classic.freecrm.com/index.html");
		String Actualresult = loginpage.getURL();
		System.out.println(Actualresult);
		Assert.assertEquals(Actualresult, Expectedresult, "the url is not correct");
	}

	@Test(priority = 3)
	public void logoTest() {
		boolean Actualresult = loginpage.LogoIsDisplayed();
		System.out.println(Actualresult);
		Assert.assertTrue(Actualresult, "the logo is not displayed");


	}

	@Test(priority = 4)
	public void loginTest() throws IOException  {
		homepage = loginpage.PerformLogin();
		String Expectedresult = ("CRMPRO");
		// 3ayz y3raf el title bta3 elhome page
		String Actualresult = homepage.getTitle();
		Assert.assertEquals(Actualresult, Expectedresult, "username or password is wrong");


	}

	

}
