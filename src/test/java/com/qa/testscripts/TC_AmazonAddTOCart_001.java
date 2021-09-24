package com.qa.testscripts;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.katasiva.excelutility.TestData;

public class TC_AmazonAddTOCart_001 extends TestBase {

	@Test(dataProvider = "searchData")
	public void searchItem(String category, String data) throws InterruptedException {

		WebElement searchDropdown = amazoneOBJ.getSerachDropdownBox();
		Select item = new Select(searchDropdown);
		item.selectByVisibleText(category);
		setDetailMsg(category + " - Selected");
		String parentWindow = Driver.getWindowHandle();
		amazoneOBJ.getSearchTextField().sendKeys(data);
		setDetailMsg(data + " - is searched");
		amazoneOBJ.getMagnifireBTN().click();
		int expCartValue = Integer.parseInt(amazoneOBJ.getCartValue.getText());
		List<WebElement> allLinks = amazoneOBJ.getLinks();
		for (WebElement link : allLinks) {
			if (link.getText().contains(data)) {
				js.executeScript("window.scrollBy(0,250)");
				link.click();
				Set<String> handles = Driver.getWindowHandles();
				for (String handle : handles) {
					if (!handle.equals(parentWindow)) {
						Driver.switchTo().window(handle);
						js.executeScript("window.scrollBy(0,200)");
						amazoneOBJ.getAddCart().click();
						setDetailMsg("Add to Cart Button Clicked..!");
						Thread.sleep(1000);
					}
				}
				Driver.close();
				break;
			}
		}
		Driver.switchTo().window(parentWindow);
		Thread.sleep(1000);
		Driver.navigate().refresh();
		Thread.sleep(1000);
		amazoneOBJ.getSearchTextField().clear();
		Thread.sleep(2000);
		int actCartValue = Integer.parseInt(amazoneOBJ.getCartValue.getText());
		if (expCartValue < actCartValue) {
			setDetailMsg("Old Cart Value " + expCartValue + " is added +1 is = " + actCartValue + " :- Then " + data+ " - is added to the Cart");
		} else {
			setDetailMsg("Old Cart Value " + expCartValue + "and new cart value " + actCartValue + " is same " + data + " - is not added into the Cart");
		}
		Assert.assertEquals(actCartValue, expCartValue + 1);
	}

	@DataProvider(name = "searchData")
	public String[][] getData() throws IOException {
		String sheetName = "AddCart";
		return TestData.getDataFromExcel(path, sheetName);
	}

}