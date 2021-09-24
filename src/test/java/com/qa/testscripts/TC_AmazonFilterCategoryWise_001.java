package com.qa.testscripts;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.katasiva.excelutility.TestData;

public class TC_AmazonFilterCategoryWise_001 extends TestBase {
	

	@Test(dataProvider = "getData")
	public void filterCategorySelection(String[] input) throws InterruptedException {
		WebElement sCat = filter.getSearchCategory();
		if (!input[0].equals("")) {
			new Select(sCat).selectByVisibleText(input[0]);
		}
		filter.getSearchButton().click();
		Thread.sleep(3000);
		List<WebElement> mouseHoverCateg = filter.getSubCategory();
		for (WebElement webElement : mouseHoverCateg) {
			if (!input[1].equals("")) {
				if (webElement.getText().equalsIgnoreCase(input[1])) {
					act.moveToElement(webElement).build().perform();
					List<WebElement> wearTypes = filter.getSubCategWearType();
					Thread.sleep(2000);
					for (WebElement wearType : wearTypes) {
						if (!input[2].equals("")) {
							if (wearType.getText().equalsIgnoreCase(input[2])) {
								act.moveToElement(wearType).click().build().perform();
								break;
							}
						}
					}
					break;
				}
			}
		}
		Thread.sleep(3000);

		List<WebElement> customerReviews = filter.getAvgCustomerReview();
		for (WebElement webElement : customerReviews) {
			if (!input[3].equals("")) {
				if (webElement.getAttribute("aria-label").equalsIgnoreCase(input[3])) {
					Assert.assertTrue(true);
					Assert.assertTrue(webElement.isDisplayed());
					webElement.click();
					break;
				}
			}
		}
		Thread.sleep(2000);
		if (!input[4].equals("")) {
			webOperation(filter.getSize(), input[4]);
		}
		Thread.sleep(2000);
		if (!input[5].equals("")) {
			webOperation(filter.getPriceRange(), input[5]);
		}
		Thread.sleep(2000);
		if (!input[6].equals("")) {
			webOperation(filter.getOccasionWear(), input[6]);
		}
		Thread.sleep(2000);
		if (!input[7].equals("")) {
			webOperation(filter.getBrandNames(), input[7]);
		}
		Thread.sleep(4000);
		filter.getProduct().click();
		Thread.sleep(2000);
		String defaultWindow = Driver.getWindowHandle();
		Set<String> windows = Driver.getWindowHandles();
		for (String window : windows) {
			Driver.switchTo().window(window);
			if (!input[9].equals("")) {
				if (Driver.getTitle().startsWith(input[9])) {
					if (!input[8].equals("")) {
						new Select(filter.getSizes()).selectByVisibleText(input[8]);
					}
						Thread.sleep(5000);
						filter.getAddToCartButton().click();
						Assert.assertTrue(true);
						break;
				}
			}
		}
		Thread.sleep(3000);
		Driver.close();
		Thread.sleep(2000);
		Driver.switchTo().window(defaultWindow);
		filter.getHome().click();
		Thread.sleep(3000);
		Driver.navigate().refresh();
		
	}
	public static void webOperation(List<WebElement> webElements, String input) throws InterruptedException {
		for (WebElement webElement : webElements) {
			if (webElement.getText().equalsIgnoreCase(input)) {
				Assert.assertTrue(true);
				Assert.assertTrue(webElement.isDisplayed());
				Reporter.log(webElement.getText());
				webElement.click();
				break;
			}
		}
	}

	@DataProvider
	public String[][] getData() throws Throwable {
		String sheetName = "Filter";
		return TestData.getDataFromExcel(path, sheetName);
	}

}
