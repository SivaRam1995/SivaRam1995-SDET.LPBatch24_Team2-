package com.qa.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonAddCartPage {
	WebDriver driver;
	
	public AmazonAddCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="twotabsearchtextbox")
	WebElement searchTextField;
	public WebElement getSearchTextField() {
		
		return searchTextField;
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement magnifierBTN;
	public WebElement getMagnifireBTN() {
		
		return magnifierBTN;
	}
	
	
	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement dropDown;
	public WebElement getSerachDropdownBox() {
		return dropDown;
	}

	
	@FindBy(tagName="a")
	List<WebElement> links;
	public List<WebElement> getLinks() {
		
		return links;
	}
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='search']/div[1]/div[1]/div[1]/span[3]/div[2]/div[3]/div[1]/span[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")
	WebElement firstElem;
	public WebElement getFirstEle()
	{
		return firstElem;
	}
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	public WebElement addToCart;
	public WebElement getAddCart()
	{
		return addToCart;
	}
	
	@FindBy(id="nav-cart-count")
	public WebElement getCartValue;
	public WebElement getCartValue()
	{
		return getCartValue;
	}

}
