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

public class HomePageTest extends TestBase{

	

	public HomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Parameters ({"browser"})
	@BeforeMethod
	public void setup(String browser, Method method) throws ATUTestRecorderException, IOException {
		logger = extent.startTest(method.getName());
		initialization(browser);
		loginpage = new LoginPage();
		recorder = new ATUTestRecorder("E:\\workspace\\PageObjectFreeCRM\\TestReport" , method.getName() , false);
		recorder.start();
		homepage = loginpage.PerformLogin();
		
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

	@Test(priority = 5)
	public void ClickOnContactsTest()  {
        homepage.switchToframe();
		homepage.clickOnContacts();
		boolean ActualResult = homepage.isContactStatusDisplayed();
		Assert.assertTrue(ActualResult, "the status lable is not displayed");

	}

	@Test(priority = 6)
	public void ClickOnDealsTest() {
        homepage.switchToframe();
        homepage.clickOndeals();
		boolean ActualResult = homepage.isdealsStatusDisplayed();
		Assert.assertTrue(ActualResult, "the Keyword lable is not displayed");
	}

	@Test(priority = 7)
	public void ClickOnTasksTest() {
		homepage.switchToframe();		
		homepage.clickOntasks();
		boolean ActualResult = homepage.istasksStatusDisplayed();
		Assert.assertTrue(ActualResult, "the Keyword lable is not displayed");
	
	}

}
