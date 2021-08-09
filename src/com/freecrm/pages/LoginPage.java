package com.freecrm.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.base.TestBase;

public class LoginPage extends TestBase {

	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath = "//img[@src='https://classic.freecrm.com/img/logo.png']")
	WebElement logo;
	
	@FindBy (name = "username")
	WebElement loginTextBox;
	
	@FindBy (name = "password")
	WebElement passwordTextBox;
	
	@FindBy (xpath = "//input[@value='Login']")
	WebElement loginButton;
	
	public String getTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
	
	public String getURL() {
		String actualURL = driver.getCurrentUrl();
		return actualURL;
	}
	
	public boolean LogoIsDisplayed() {
		boolean actuallogo = logo.isDisplayed();
		return actuallogo;
	}
	
	public HomePage PerformLogin() throws IOException {
		loginTextBox.sendKeys(prop.getProperty("username"));
		passwordTextBox.sendKeys(prop.getProperty("password"));
		loginButton.click();
		return new HomePage();
	}
	
	
	
}
