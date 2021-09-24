package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CancelOrderPage {
	WebDriver Driver;
	@FindBy(xpath="//span[contains(text(),'Returns')]")
	WebElement returns;
	public WebElement getReturnBtn()
	{
		return returns;
	}
	@FindBy(xpath="//body/div[@id='a-page']/div[@id='yourOrders']/div[@id='yourOrdersContent']/div[@id='ordersContainer']/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]")
	WebElement cancel;
	public WebElement getCancelOrder() {
		return cancel;
	}
	@FindBy(xpath="//span[@id='cancelButton']")
	WebElement cancelOrder;
	public WebElement getCanceld() {
		return cancelOrder;
	}
	@FindBy(xpath="//tbody/tr[1]/td[1]/select[1]")
	WebElement reason;
	public Select getReasonOption() {
		Select opt=new Select(reason);
		return opt;
	}
	@FindBy(xpath="//div[@id='ordersContainer']/div/div[2]/div/div[1]/div[1]/div[1]/span")
	List<WebElement> list;
	public List<WebElement> getDeliverStatus()
	{
		return list;
	}
	
	@FindBy(xpath="//tbody/tr/td[3]/input")
	List<WebElement> checkBoxes;
	public List<WebElement> getProductsCheckBoxes()
	{
		return checkBoxes;
	}
	@FindBy(xpath="//*[@id=\"orderDetails\"]/div[2]/div/h4")
	WebElement confirmMsg;
	public WebElement getConfirmMsg()
	{
		return confirmMsg;
	}
	@FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement logo;
	public WebElement getLogo()
	{
		return logo;
	}
	
	public CancelOrderPage(WebDriver Driver)
	{
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}

}
