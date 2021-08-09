package com.freecrm.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testNG_Before_After {

	// da tartib el XML files

	// suite
	// multi tests
	// multi classes
	// multi methods (test cases)

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("i will execute before suite (before all the tests and classes and methods)");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("i will execute after suite (before all the tests and classes and methods)");
	}

	@BeforeTest
	public void beforetest() {
		System.out.println("i will execute before test (before all the classes and methods)");
	}

	@AfterTest
	public void aftertest() {
		System.out.println("i will execute after test (before all the classes and methods)");
	}

	@BeforeClass
	public void beforeclass() {
		System.out.println("i will execute before this class (before all methods)");
	}

	@AfterClass
	public void afterclass() {
		System.out.println("i will execute after this class (before all methods)");
	}

	@BeforeMethod
	public void beforemethod() {
		System.out.println("i will execute before this method)");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("i will execute after this method)");
	}

	@Test
	public void TestCase1() {
		System.out.println("this is the first test case");
	}

	@Test
	public void TestCase2() {
		System.out.println("this is the second test case");
	}

	@Test
	public void TestCase3() {
		System.out.println("this is the third test case");
	}

	@Test
	public void TestCase4() {
		System.out.println("this is the fourth test case");
	}

}
