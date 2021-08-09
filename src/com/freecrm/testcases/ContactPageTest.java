package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.freecrm.base.TestBase;
import com.freecrm.pages.LoginPage;
import com.freecrm.util.TestUtils;
import com.relevantcodes.extentreports.LogStatus;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ContactPageTest extends TestBase {

	public ContactPageTest() throws IOException {
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
		homepage = loginpage.PerformLogin();
	}
	
	@AfterMethod
	public void TearDown(Method method , ITestResult result) throws IOException, ATUTestRecorderException {
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
	
	@Test (dataProvider = "TestData")
	public void addContact(String fname, String lname, String companyname, String departmentname) throws IOException  {
		homepage.switchToframe();
		contactpage = homepage.ClickOnNewcontact();
		contactpage.addNewContact(fname, lname, companyname, departmentname);
		
		
	}
	
	@DataProvider
	public Object[][] TestData() throws Throwable{
		
		Object data[][]= TestUtils.getdDataFromExcell("Sheet1");
		return data;
		
		
	}
	
	

}
