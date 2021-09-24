package com.qa.testscripts;


import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_AmazonPlaceOrder_001 extends TestBase {
	
	@Test
	public void AmazonOrder() throws InterruptedException {
		
		ao.getLogo().click();
		Thread.sleep(2000);
		ao.getCart().click();
		Thread.sleep(6000);
		while(true) {
			if (ao.getProceedToBuyBtn().isDisplayed()) {
				ao.getProceedToBuyBtn().click();
				Thread.sleep(000);
				break;
			}
		}
		Thread.sleep(1000);
		try {
			ao.getDeliveryAddressBtn().click();
		}catch(Exception e){
			try {
			ao.getDeliveryAddressBtn2().click();
			}catch (Exception e1) {
				ao.getDeliveryAddressBtn3().click();
			}
		}
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,350)");
		try{
		ao.getCod().click();
		ao.getContinueBtn().click();
		js.executeScript("window.scrollBy(0,-350)");
		Thread.sleep(6000);
		ao.getPlaceYourOrderBtn().click();
		Thread.sleep(2000);
		setDetailMsg("Cart Items Order Placed.....!");
		setDetailMsg(ao.getOrderPlaced().getText());
		setDetailMsg("Address:-  "+ao.getShippingDetails().getText());
		setDetailMsg("Delivery Date:-  "+ao.getDeliveryDate().getText());
		Thread.sleep(5000);
		ao.getLogo().click();
		Assert.assertTrue(true);
		}catch(Exception e) {
			Thread.sleep(2000);
			Driver.navigate().back();
			Driver.navigate().back();
			ao.getLogo().click();
			Thread.sleep(2000);
			setDetailMsg("Cart Items Order not Placed Because there is no Pay On Delivery option");
			Assert.assertTrue(false);
		}
	}

}
