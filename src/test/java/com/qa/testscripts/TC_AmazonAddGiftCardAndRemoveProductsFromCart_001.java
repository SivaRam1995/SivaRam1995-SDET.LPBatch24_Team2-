package com.qa.testscripts;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.katasiva.excelutility.TestData;

public class TC_AmazonAddGiftCardAndRemoveProductsFromCart_001 extends TestBase {

	@Test
	public void amazonAddGiftCardAndRemoveProductsInCat() throws InterruptedException, IOException {

		gftb.getAllBtn().click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		String file_path = ".//OutputExcel//AmazonLeftSideAllBtnLinks.xlsx";
		String sheetName = "AmazonLeftSideAllBtnInsideLinksList";
		setDetailMsg(sheetName + "- sheet is created");
		String heading = "AmazonLeftSideAllBtnLinks";
		TestData.openFile(file_path, sheetName, heading);
		List<WebElement> allList = gftb.getAllList();
		int rowNum = 1;
		for (WebElement li : allList) {
			if (!li.getText().equals("")) {
				TestData.writeDataOnExcel(rowNum, 0, li.getText());
				rowNum++;
			}
		}
		TestData.closeFile();
		Thread.sleep(1000);
		gftb.getGiftCard().click();
		Thread.sleep(1000);
		gftb.getAllGiftCardsLink().click();
		setDetailMsg("Title is - " + Driver.getTitle());
		Thread.sleep(1000);
		gftb.getSeeMore().click();
		Thread.sleep(1000);
		gftb.getStarPerformer().click();
		Thread.sleep(1000);
		gftb.getOtherBox().sendKeys(property.getProperty("starPerformereGift"));
		Thread.sleep(1000);
		gftb.getAddToCart().click();
		Thread.sleep(3000);
		if (gftb.getGiftLink().isDisplayed()) {
			gftb.getGiftLink().click();
		} else {
			String linkName = property.getProperty("giftCardLink");
			Thread.sleep(4000);
			js.executeScript("var i=0;while(true){if(document.getElementById('nav-xshop').getElementsByTagName('a')[i].innerText==\""+ linkName+ "\"){document.getElementById('nav-xshop').getElementsByTagName('a')[i].click();break;}i++;}");
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		gftb.getGoodLuck().click();
		Thread.sleep(1000);
		gftb.getOtherBox().sendKeys(property.getProperty("goodluckeGift"));
		Thread.sleep(1000);
		gftb.getAddToCart().click();
		Thread.sleep(3000);
		gftb.getViewCart().click();
		Thread.sleep(3000);
		Driver.navigate().refresh();
		try {
			int expCartValue = Integer.parseInt(amazoneOBJ.getCartValue.getText());
			setDetailMsg("available Products count in cart :" + expCartValue + "<br>");
			int actCartValue;
			while (true) {
				Driver.navigate().refresh();
				Thread.sleep(8000);
				actCartValue = Integer.parseInt(amazoneOBJ.getCartValue.getText());
				setDetailMsg("Products deleted from cart :" + actCartValue);
				Thread.sleep(2000);
				if (gftb.getDeleteCard().isDisplayed()) {
					gftb.getDeleteCard().click();
					expCartValue--;
				} else {
					break;
				}
			}
			setDetailMsg("expected CartValue :- " + expCartValue + "actual cartValue :- " + actCartValue);
			Assert.assertEquals(actCartValue, expCartValue);
		} catch (NoSuchElementException e) {
			Thread.sleep(1000);
			gftb.getLogo().click();
			Actions act = new Actions(Driver);
			act.moveToElement(gftb.getAccount()).build().perform();
			Thread.sleep(1000);
			if (gftb.getSignOut().isDisplayed()) {
				gftb.getSignOut().click();
				setDetailMsg("signout button clicked");
				js.executeScript("alert('\"Batch 24 Team 2 \" Amazon Project Successfully Done.........!\\nTeam Members :- \\n - 1.Kata Siva Rama Subbaiah \\n - 2.Vennela \\n - 3.Khan \\n - 4.Apsar \\n - 5.Sagar \\n - 6.Venkatesh \\n - 7.Nilesh')");
				Thread.sleep(15000);
				Driver.switchTo().alert().accept();
				setOpenFilePath(file_path);
				Assert.assertTrue(true);
			} else {
				setDetailMsg("Error Occured");
				Assert.assertTrue(false);
			}
		}
	}

}
