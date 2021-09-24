package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonFilterPages {
	WebDriver driver;

	@FindBy(id = "searchDropdownBox")
	WebElement searchCategory;

	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;

	@FindBy(xpath = "//header/div[@id='navbar']/div[@id='nav-progressive-subnav']/div[@id='nav-subnav']/a[3]")
	WebElement menCateg;

	@FindBy(xpath = "//a[contains(text(),'Metallic')]")
	WebElement watchCateg;

	@FindAll(@FindBy(css = "div.mega-menu ul>li"))
	List<WebElement> subCategWearType;

	public List<WebElement> getSubCategWearType() {
		return subCategWearType;
	}
	
	@FindAll(@FindBy(css = "a>[class = 'nav-a-content']"))
	List<WebElement> subCategories;

	@FindAll(@FindBy(css = "div.mm-column>ul.mm-category-list"))
	List<WebElement> subCategoryInfo;

	@FindBy(xpath = "//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/span[1]/div[1]/div[1]/div[6]/ul[2]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]")
	WebElement payOnDelivery;

	@FindBy(id = "RETURNS_POLICY")
	WebElement returnsPolicy;

	@FindBy(id = "AMAZON_DELIVERED")
	WebElement amazonDelivered;

	@FindBy(id = "WARRANTY")
	WebElement warranty;

	@FindBy(id = "add-to-wishlist-button-submit")
	WebElement addToWishList;

	//@FindAll(@FindBy(css = "li[id^='p_n_size_browse-vebin']"))
	@FindAll(@FindBy(xpath = "//div[@id='s-refinements']/div//li"))
	List<WebElement> size;

	@FindBy(id = "add-to-cart-button")
	WebElement addToCartButton;

	@FindBy(css = "input[type='checkbox']")
	List<WebElement> checkBoxes;

	//@FindAll(@FindBy(xpath = "//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[11]/ul[1]/li/span[1]/a[1]/div[1]"))
	@FindAll(@FindBy(xpath = "//div[@id='s-refinements']/div//a/div[@class='a-section']"))
	List<WebElement> avgCustomerReview;

	//@FindAll(@FindBy(css = "li[id^='p_36/4'] a"))
	@FindAll(@FindBy(css = "ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-medium>li.a-spacing-micro> span>a"))
	List<WebElement> priceRange;

	@FindAll(@FindBy(css = "li[id^='p_n_size_two_browse-vebin']>span>a"))
	List<WebElement> colorSelection;

	@FindAll(@FindBy(xpath = "//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[15]/ul[1]/li/span/a"))
	List<WebElement> discountRange;

	@FindAll(@FindBy(css = "li[id^='p_n_material_browse'] a"))
	List<WebElement> materialType;

	@FindAll(@FindBy(css = "ul.a-unordered-list.a-nostyle.a-vertical.a-spacing-medium>li.a-spacing-micro> span>a"))
	List<WebElement> occasionWear;

	@FindAll(@FindBy(css = "ul.a-unordered-list.a-nostyle.a-vertical>li.a-spacing-micro> span>a"))
	List<WebElement> brandNames;

	@FindAll(@FindBy(xpath = "//body/div[@id='a-page']/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/ul[1]/li/span/a/span[1]"))
	List<WebElement> ethnicWearTypes;

	//@FindBy(xpath = "//div[@class='sg-col-inner']/span[3]/child::div[2]/descendant::div[10]/span/a")
	@FindBy(css = "div[data-index='1'] span>a.s-no-outline")
	WebElement product;
	
	@FindBy(xpath = "//a[@id='nav-logo-sprites']")
	WebElement home;
	
	@FindAll(@FindBy(xpath = "//div[@id='s-refinements']/div//li"))
	List<WebElement> filterCategories;
	
	@FindAll(@FindBy(css = "#nav-subnav a"))
	List<WebElement> subCategory;
	
	@FindBy(css = "select#native_dropdown_selected_size_name")
	WebElement sizes;

	public WebElement getSizes() {
		return sizes;
	}

	public List<WebElement> getFilterCategories() {
		return filterCategories;
	}

	public WebElement getHome() {
		return home;
	}

	public WebElement getProduct() {
		return product;
	}

	public List<WebElement> getEthnicWearTypes() {
		return ethnicWearTypes;
	}

	public List<WebElement> getBrandNames() {
		return brandNames;
	}

	public List<WebElement> getOccasionWear() {
		return occasionWear;
	}

	public List<WebElement> getMaterialType() {
		return materialType;
	}

	public List<WebElement> getDiscountRange() {
		return discountRange;
	}

	public List<WebElement> getColorSelection() {
		return colorSelection;
	}

	public List<WebElement> getPriceRange() {
		return priceRange;
	}

	public List<WebElement> getAvgCustomerReview() {
		return avgCustomerReview;
	}

	public List<WebElement> getCheckBoxes() {
		return checkBoxes;
	}

	public List<WebElement> getSize() {
		return size;
	}

	public WebElement getAddToWishList() {
		return addToWishList;
	}

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	public WebElement getReturnsPolicy() {
		return returnsPolicy;
	}

	public WebElement getWarranty() {
		return warranty;
	}

	public WebElement getAmazonDelivered() {
		return amazonDelivered;
	}

	public WebElement getPayOnDelivery() {
		return payOnDelivery;
	}

	public List<WebElement> getSubCategoryInfo() {
		return subCategoryInfo;
	}

	public List<WebElement> getSubCategory() {
		return subCategory;
	}

	public WebElement getSearchCategory() {
		return searchCategory;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getMenCateg() {
		return menCateg;
	}

	public WebElement getWatchCateg() {
		return watchCateg;
	}

	public AmazonFilterPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
