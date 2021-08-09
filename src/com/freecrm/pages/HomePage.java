package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Contacts']")
	WebElement contacts;
		
	@FindBy(xpath = "//a[text()='Deals']")
	WebElement deals;
	
    @FindBy(xpath = "//a[text()='Tasks']")
    WebElement tasks;
    
    @FindBy(xpath = "//a[text()='New Contact']")
    WebElement newcontact;
    
    @FindBy(xpath = "//td[text()='Status']")
    WebElement contactStatus;
    
    @FindBy(xpath = "//td[text()='Keyword']")
    WebElement dealsKeyword;
    
    @FindBy(xpath = "//td[text()='Keyword']")
    WebElement tasksKeyword;
    
	
	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public void switchToframe() {
		driver.switchTo().frame("mainpanel");

	}

	public void clickOnContacts() {
		contacts.click();
	}
	
	public boolean isContactStatusDisplayed() {
		boolean isContactDisplayed = contacts.isDisplayed();
		return isContactDisplayed;
	}
	
	public void clickOndeals() {
		deals.click();
	}
	
	public boolean isdealsStatusDisplayed() {
		boolean isdealsDisplayed = contacts.isDisplayed();
		return isdealsDisplayed;
	}
	
	
	public void clickOntasks() {
		tasks.click();
	}
	
	public boolean istasksStatusDisplayed() {
		boolean istasksDisplayed = contacts.isDisplayed();
		return istasksDisplayed;
	}
	
	public ContactPage ClickOnNewcontact() throws IOException {
		Actions action = new Actions(driver);
		action.moveToElement(contacts).build().perform();
		newcontact.click();
		return new ContactPage();
	}
	
	
	
}

