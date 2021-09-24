package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobileRechargePage {
	WebDriver Driver;

	@FindBy(xpath = "//a[@id='nav-hamburger-menu']")
	WebElement allBtnLink;

	public WebElement getAllBtn() {
		return allBtnLink;
	}

	@FindBy(xpath = "//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[1]/li[22]/a[1]")
	WebElement giftcards;

	public WebElement getGiftCard() {
		return giftcards;
	}

	@FindBy(xpath = "//a[contains(text(),'Mobile Recharges')]")
	WebElement recharge;

	public WebElement getMobileRecharge() {
		return recharge;
	}

	@FindBy(xpath = "//body/div[@id='a-page']/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span/span/a")
	WebElement mobilerecharge;
	public WebElement getMobileRechargeBtn() {
		return mobilerecharge;
	}
	
	@FindBy(xpath = "//a[@id='viewPlanTriggerId']")
	WebElement viewPlans;
	public WebElement getViewPlansLink() {
		return viewPlans;
	}
	
	@FindBy(xpath = "//input[@id='mobileNumberTextInputId']")
	WebElement mobilenumber;
	public WebElement getMobileNum() {
		return mobilenumber;
	}
	@FindBy(xpath="//a[@id='operatorCircleLink']")
	WebElement edit;
	public WebElement getEdit() {
		return edit;
	}
	@FindBy(xpath="//body[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/fieldset[1]/div/label[1]")
	List<WebElement> operator;
	public List<WebElement> getOperator() {
		return operator;
	}
	@FindBy(xpath="//div[@id='circlesRadioButtonDiv']/fieldset/div/label")
	List<WebElement> states;
	public List<WebElement> getStates() {
		return states;
	}
	@FindBy(tagName = "a")
	List<WebElement> link;
	public List<WebElement> getLinks()
	{
		return link;
	}
	@FindBy(tagName = "span")
	List<WebElement> text;
	public List<WebElement> getTexts()
	{
		return text;
	}
	@FindBy(xpath="//*[@id=\"a-popover-1\"]/div/header/button")
	WebElement close;
	public WebElement getCloseBtn()
	{
		return close;
	}
	@FindBy(xpath="//*[@id=\"NO_DAILY_LIMIT\"]/tbody/tr[4]/td/div[1]/div[2]/span/span")
	WebElement pack;
	public WebElement getPack()
	{
		return pack;
	}
	@FindBy(xpath="//span[@id='payButtonText']")
	WebElement con;
	public WebElement getContinue()
	{
		return con;
	}
	@FindBy(xpath="//*[@id=\"errorMessageTextInputId\"]")
	WebElement readMsg;
	public WebElement getreadMsgOut()
	{
		return readMsg;
	}
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement logo;
	public WebElement getLogo()
	{
		return logo;
	}
	
	public MobileRechargePage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}

}
