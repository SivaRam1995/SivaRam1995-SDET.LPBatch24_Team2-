package com.qa.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonOrderPage {
	WebDriver driver;
	@FindBy(xpath="//a[@id='nav-cart']")
	WebElement cartBtn;
	public WebElement getCart() {
		return cartBtn;
	}
	@FindBy(id="sc-buy-box-ptc-button")
	WebElement proceed;
	public WebElement getProceedToBuyBtn() {
		return proceed;
	}
	@FindBy(xpath="//body/div[5]/div[2]/div[1]/form[1]/div[1]/div[1]/div[2]/span[1]")
	WebElement address;
	public WebElement getDeliveryAddressBtn() {
		return address;
	}
	@FindBy(xpath="//body/div[5]/div[2]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/span[1]")
	WebElement address2;
	public WebElement getDeliveryAddressBtn2() {
		return address2;
	}
	@FindBy(xpath="//body/div[5]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/span")
	WebElement address3;
	public WebElement getDeliveryAddressBtn3() {
		return address3;
	}
	@FindBy(xpath="//body/div[@id='checkoutDisplayPage']/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")
	WebElement cod;
	public WebElement getCod() {
		return cod;
	}
	@FindBy(xpath="//body/div[@id='checkoutDisplayPage']/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/span[1]/span[1]/input")
	WebElement cont;
	public WebElement getContinueBtn() {
		return cont;
	}
	@FindBy(xpath="//body/div[@id='checkoutDisplayPage']/div[@id='spc-desktop']/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/span/span")
	WebElement placeOrder;
	public WebElement getPlaceYourOrderBtn() {
		return placeOrder;
	}
	@FindBy(xpath="//div[@id='widget-purchaseConfirmationDetails']/span/div[1]/div/h4/div/div/h4")
	WebElement confirmMsg;
	public WebElement getConfirmMessage() {
		return confirmMsg;
	}
	@FindBy(xpath="//body/div[@id='a-page']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/span[1]/div[7]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement shipping;
	public WebElement getShippingDetails() {
		return shipping;
	}
	@FindBy(xpath="//body[1]/div[1]/div[4]/div[1]/div[8]/div[1]/div[2]/div[2]/div[1]/form[1]/div[2]/div/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]")
	List<WebElement> chkbox;
	public List<WebElement> getuncheckItem() {
		return chkbox;
	}
	@FindBy(xpath="//a[@id='deselect-all']")
	WebElement deselect;
	public WebElement getDeselectItem() {
		return deselect;
	}
	@FindBy(xpath="//*[@id=\"widget-purchaseConfirmationStatus\"]/div/h4/div/div/h4")
	WebElement orderPlaced;
	public WebElement getOrderPlaced()
	{
		return orderPlaced;
	}
	@FindBy(xpath="//*[@id=\"shipment-text-orderGroupID0\"]/div")
	WebElement shippingAddress;
	public WebElement getOrderCancled()
	{
		return shippingAddress;
	}
	@FindBy(xpath="//*[@id=\"widget-deliveryPromise-orderGroupID0#itemGroupID0\"]")
	WebElement deliveryDate;
	public WebElement getDeliveryDate()
	{
		return deliveryDate;
	}
	
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement logo;
	public WebElement getLogo() {
		return logo;
	}
	public AmazonOrderPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
}
