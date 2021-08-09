package com.freecrm.testcases;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.freecrm.base.TestBase;
import com.relevantcodes.extentreports.ExtentReports;

public class Config extends TestBase{

	public Config() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	@BeforeSuite
	public void start() {
		extent = new ExtentReports("E:\\workspace\\PageObjectFreeCRM\\TestReport\\index.html",true);
		extent.addSystemInfo("OS", "windows");
		extent.addSystemInfo("owner", "eslam badawy");
		extent.addSystemInfo("Test name", "FreeCRM Test");
		extent.addSystemInfo("Language","JAVA");
		extent.addSystemInfo("FrameWork Design", "Page Object");
		
	}
	
	
	@AfterSuite
	public void end() {
		extent.flush();
		
	}
	
	
	

}
