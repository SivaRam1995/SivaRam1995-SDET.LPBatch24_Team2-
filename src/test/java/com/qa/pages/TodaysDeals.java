package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodaysDeals {
	  
    WebDriver Driver;
	public TodaysDeals(WebDriver Driver){
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}
	
	@FindBy(className="GridFilterLabel-module__gridFilterHeader_2OVJdXqcMlKTHBkWC_qXE7")
	List<WebElement> GridFilter;
	@FindBy(className="CheckboxFilter-module__checkboxLabel_21MUk0e7QdlZKH5Xcwap-F")
	List<WebElement> Objective;
	@FindBy(xpath="//body/div[@id='a-page']/div[13]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/i[1]")
	WebElement Left;
    @FindBy(xpath="/html[1]/body[1]/div[1]/div[13]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")	
    WebElement Right;
    @FindBy(xpath="//body/div[@id='a-page']/div[16]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/span[3]/span[1]/div[2]/div[1]/div[1]/label[1]/input[1]")
    WebElement Appliances;
    @FindBy(xpath="//body/div[@id='a-page']/div[16]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]")
    WebElement Kitchen;
    @FindBy(xpath="//body/div[@id='a-page']/div[3]/div[1]/div[2]/div[1]/ul[1]/li[1]")
    WebElement Borosil;
    @FindBy(xpath="//body/div[@id='a-page']/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/span[1]/div[1]/div[1]")
    WebElement prod2;
    public WebElement getPro2()
    {
    	return prod2;
    }
    @FindBy(xpath="//input[@id='add-to-cart-button']")
    WebElement Chart;
    @FindBy(xpath="//a[@id='nav-logo-sprites']")
	WebElement logo;
    @FindBy(xpath="//body/div[@id='a-page']/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/ul[1]/li[1]/span[1]/div[1]/div[1]/a[1]/div[1]")
    WebElement anotherPro;
    @FindBy(xpath="//a[@id='attach-close_sideSheet-link']")
    WebElement crossmark;
    public WebElement getClose() {
    	return crossmark;
    }
    public WebElement getAnotherProduct() {
    	return anotherPro;
    }
	public WebElement getLogo()
	{
		return logo;
	}
	public List<WebElement> GridFilter() {
		return GridFilter;
	}
	public List<WebElement> Prodcut_objects() {
		return Objective;
	}
	public WebElement LeftArrow() {
		return Left;
	}
	public WebElement RightArrow() {
		return Right;	}
	public WebElement Appliances() {
		return Appliances;
	}
	public WebElement Kitchen() {
		return Kitchen;
	}
	public WebElement Kitchen_produt() {
		return Borosil;
	}
	public WebElement AddtoChar() {
		return Chart;
	}
	@FindBy(xpath="//*[@id=\"slot-15\"]/div/div/div[2]/div[2]")
	List<WebElement> allLinks;
	public List<WebElement> getAllLinksInThisPage() {
		return allLinks;
	}
	
	@FindBy(xpath = "//*[@id=\"title\"]")
	WebElement prodName;

	public WebElement getProductName() {
		return prodName;
	}

}

