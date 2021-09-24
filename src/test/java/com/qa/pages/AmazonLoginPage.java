package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonLoginPage {
	WebDriver Driver;

	public AmazonLoginPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}

	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement Account;

	@FindBy(xpath = "//span[@class='nav-action-inner']")
	WebElement Signin;

	@FindBy(xpath = "//a[@id='createAccountSubmit']")
	WebElement CreateAmznAccnt;
	// CreateAccountElements
	@FindBy(id = "ap_customer_name")
	WebElement YourName;

	@FindBy(id = "ap_phone_number")
	WebElement MobileNumber;

	@FindBy(xpath = "//input[@id='ap_email']")
	WebElement Email;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(id = "continue")
	WebElement Continue;

	public WebElement Account() {
		return Account;
	}

	public WebElement Signin() {
		return Signin;
	}

	public WebElement CreateAmznAccnt() {
		return CreateAmznAccnt;
	}

	public WebElement YourName() {
		return YourName;
	}

	public WebElement MobileNumber() {
		return MobileNumber;
	}

	public WebElement Email() {
		return Email;
	}

	public WebElement Password() {
		return Password;
	}

	public WebElement Continue() {
		return Continue;
	}

	// signIn Elements
	@FindBy(id = "ap_email")
	WebElement PhoneNumber;

	public WebElement PhoneNumber() {
		return PhoneNumber;
	}

	@FindBy(id = "continue")
	WebElement continue1;

	public WebElement continue1() {
		return continue1;
	}

	@FindBy(xpath = "//span[@class='a-list-item']")
	WebElement text;

	public WebElement getExistAccText() {
		return text;
	}

	@FindAll({@FindBy(linkText = "Sign in"),@FindBy(linkText = "Sign-In")})
	WebElement signinLink;

	public WebElement getSignInLink() {
		return signinLink;
	}
	@FindBy(xpath="//*[@id=\"ap_email\"]")
	WebElement mobileoremail;
	
	public WebElement getMobOrMailBox() {
		return mobileoremail;
	}

	@FindBy(id = "ap_password")
	WebElement pass;

	public WebElement getPassword() {
		return pass;
	}
	@FindBy(id = "signInSubmit")
	WebElement signInSubmit;

	public WebElement getsignInSubmit() {
		return signInSubmit;
	}
	@FindBy(xpath = "//input[@name='rememberMe']")
	WebElement remember;

	public WebElement getRemember() {
		return remember;
	}
	@FindBy(xpath = "//*[@id=\"ap_password_check\"]")
	WebElement againPassword;
	
	public WebElement getReEnterPassword() {
		return againPassword;
	}

}
