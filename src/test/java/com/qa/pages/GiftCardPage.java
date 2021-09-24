package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCardPage {
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
	@FindBy(xpath = "//a[contains(text(),'All Gift Cards')]")
	WebElement allgiftcards;
	
	public WebElement getAllGiftCardsLink() {
		return allgiftcards;
	}
	@FindBy(xpath = "//body/div[@id='a-page']/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/img[1]")
	WebElement seemore;
	
	public WebElement getSeeMore() {
		return seemore;
	}
	@FindBy(xpath = "//body/div[@id='a-page']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[3]/div[1]/div[1]/a[1]/img[1]")
	WebElement star;
	
	public WebElement getStarPerformer() {
		return star;
	}
	@FindBy(xpath = "//input[@id='gc-order-form-custom-amount']")
	WebElement other;
	
	public WebElement getOtherBox() {
		return other;
	}
	@FindBy(xpath = "//input[@id='gc-buy-box-atc']")
	WebElement addToCart;
	
	public WebElement getAddToCart() {
		return addToCart;
	}
	@FindBy(xpath = "//a[@id='nav-cart']")
	WebElement viewCart;
	
	public WebElement getViewCart() {
		return viewCart;
	}
	
	@FindBy(xpath = "")
	List<WebElement> deleteGiftCard;
	public List<WebElement> getDeleteGiftCards() {
		return deleteGiftCard;
	}
	@FindBy(xpath = "//body/div[@id='a-page']/div[4]/div[1]/div[8]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div[3]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[2]/span")
	WebElement deleted;
	public WebElement getDeleteCard() {
		return deleted;
	}
	@FindBy(xpath="//a[contains(text(),'Gift Cards')]")
	WebElement clickOnLink;
	public WebElement getGiftLink()
	{
		return clickOnLink;
	}
	@FindBy(xpath="//body/div[@id='a-page']/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/a[1]")
	WebElement goodluck;
	public WebElement getGoodLuck()
	{
		return goodluck;
	}
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement logo;
	public WebElement getLogo()
	{
		return logo;
	}
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement Account;
	public WebElement getAccount() {
		return Account;
	}
	@FindBy(xpath = "//*[@id=\"hmenu-content\"]/ul/li/a")
	List<WebElement> allList;
	public List<WebElement> getAllList() {
		return allList;
	}
	@FindBy(xpath = "//a[@id='nav-item-signout']")
	WebElement signout;
	public WebElement getSignOut() {
		return signout;
	}
	@FindBy(xpath = "//*[@id=\"activeCartViewForm\"]/div[2]/div[3]/div[4]/div/div/div/div/div[2]/ul/li[1]/span/a/span/span")
	WebElement cartProName;
	public WebElement getCartProdName() {
		return cartProName;
	}
	@FindBy(xpath = "//*[@id=\"activeCartViewForm\"]/div[2]/div[3]/div[4]/div/div[2]/p")
	WebElement cartProAmt;
	public WebElement getCartProdAmount() {
		return cartProAmt;
	}

	public GiftCardPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);

	}


}
