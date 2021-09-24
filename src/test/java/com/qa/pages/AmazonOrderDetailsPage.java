package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonOrderDetailsPage {
	public WebDriver Driver;
	@FindBy(xpath="//body/div[@id='divsinglecolumnminwidth']/div[3]/div[3]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/table/tbody/tr")
	List<WebElement> messages;
	public List<WebElement> getMessages()
	{
		return messages;
	}
	@FindBy(xpath="//*[@id=\"inbox_button_next_page\"]")
	WebElement nextpage;
	public WebElement getNextBtn() {
		return nextpage;
	}
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement Account;
	public WebElement getAccount() {
		return Account;
	}
	@FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-flyout-anchor']/div[@id='nav-flyout-accountList']/div[2]/div[1]/div[2]/a[1]")
	WebElement youract;
	public WebElement getYourAccount() {
		return youract;
	}
	@FindBy(linkText = "Message center")
	WebElement msgCenter;
	public WebElement getMsgCenter() {
		return msgCenter;
	}
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement logo;
	public WebElement getLogo() {
		return logo;
	}
	public AmazonOrderDetailsPage(WebDriver Driver){
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
		
	}

}
