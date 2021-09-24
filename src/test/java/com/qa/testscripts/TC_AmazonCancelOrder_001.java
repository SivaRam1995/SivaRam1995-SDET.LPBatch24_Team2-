package com.qa.testscripts;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AmazonCancelOrder_001 extends TestBase {
	

	@Test
	public void cancelOrder() throws InterruptedException {
		
		cop.getReturnBtn().click();
		Thread.sleep(1500);
		cop.getCancelOrder().click();
		setDetailMsg("Cancle Button Clicked");
		Thread.sleep(1500);
		List<WebElement> checkBoxes = cop.getProductsCheckBoxes();
		for (WebElement check : checkBoxes) {
			if(check.isSelected()==false) {
			check.click();
			Thread.sleep(1500);
			}
		}
		cop.getReasonOption().selectByIndex(1);
		Thread.sleep(3000);
		while (true) {
			if (cop.getCanceld().isEnabled()) {
				setDetailMsg(cop.getCanceld().getText()+" button clicked");
				cop.getCanceld().submit();
				break;
			}
		}
		Thread.sleep(8000);
		if(cop.getConfirmMsg().getText().contains("This order has been cancelled.")) {
			setDetailMsg("Title of this page is : "+Driver.getTitle());
			setDetailMsg(cop.getConfirmMsg().getText());
			Thread.sleep(1000);
			cop.getLogo().click();
			Thread.sleep(1000);
			Assert.assertTrue(true);
		}
		else {
			setDetailMsg("Title of this page is : "+Driver.getTitle());
			Thread.sleep(1000);
			cop.getLogo().click();
			Thread.sleep(1000);
			Assert.assertTrue(false);

		}
		
	}
}
