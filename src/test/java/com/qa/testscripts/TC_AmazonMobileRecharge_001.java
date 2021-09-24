package com.qa.testscripts;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.katasiva.excelutility.TestData;

public class TC_AmazonMobileRecharge_001 extends TestBase {

	@Test(dataProvider = "getRechargeData")
	public void amazonMobileRecharge(String[] input) throws InterruptedException {
		
		aftb.getAllBtn().click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		aftb.getGiftCard().click();
		Thread.sleep(1000);
		aftb.getMobileRecharge().click();
		Thread.sleep(1000);
		aftb.getMobileRechargeBtn().click();
		Thread.sleep(1000);
		aftb.getMobileNum().sendKeys(input[0]);
		Thread.sleep(2000);
		aftb.getEdit().click();
		Thread.sleep(1000);
		List<WebElement> operators = aftb.getOperator();
		for(WebElement operator:operators)
		{
			if(operator.getText().equals(input[1]))
			{
				operator.click();
			}
		}
		List<WebElement> states = aftb.getStates();
		for(WebElement state:states)
		{
			if(state.getText().equals(input[2])) {
				state.click();
			}
		}
		aftb.getViewPlansLink().click();
		Thread.sleep(2000);
		try {
		List<WebElement> links = aftb.getLinks();
		for(WebElement unlimited:links) {
			if(unlimited.getText().equals("Unlimited Plans")||unlimited.getText().equals("No Daily Limit")) {
				unlimited.click();
				break;
			}
		}
		Thread.sleep(1000);
		aftb.getPack().click();
		}
		catch(Exception e) {
			aftb.getCloseBtn().click();
		}
		Thread.sleep(2000);
		aftb.getContinue().click();
		Thread.sleep(6000);
		if(Driver.getTitle().contains("Select a Payment Method")) {
		Driver.navigate().back();
		Thread.sleep(3000);
		setDetailMsg("Mobile number, operator and plans selected correctly");
		Thread.sleep(2000);
		aftb.getLogo().click();
		Assert.assertTrue(true);
		}else {
			setDetailMsg("Mobile number, operator and plans not selected");
			Assert.assertTrue(false);
		}
		
	}
	@DataProvider(name="getRechargeData")
	public String[][] getData() throws IOException {
		String sheetName = "MobileRecharge";
		return TestData.getDataFromExcel(path, sheetName);
	}
	
}
