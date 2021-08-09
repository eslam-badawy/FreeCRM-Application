package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class ContactPage extends TestBase {
	
	public ContactPage() throws IOException {
	PageFactory.initElements(driver, this);	
	}

	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "surname")
	WebElement lastname;
	
	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(id = "department")
	WebElement department;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement save;
	
	
	public void addNewContact(String fname, String lname, String companyname, String departmentname) {
		firstname.sendKeys(fname);
		lastname.sendKeys(lname);
		company.sendKeys(companyname);
		department.sendKeys(departmentname);
		save.click();
	}
	
	
	

	

}
