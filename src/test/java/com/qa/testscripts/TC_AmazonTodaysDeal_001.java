package com.qa.testscripts;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.katasiva.excelutility.TestData;

public class TC_AmazonTodaysDeal_001 extends TestBase {

	@Test
	public void todayDeals() throws InterruptedException, IOException {
		String linkName=property.getProperty("linkname");
		Thread.sleep(4000);
		js.executeScript("var i=0;while(true){if(document.getElementById('nav-xshop').getElementsByTagName('a')[i].innerText==\""+linkName+"\"){document.getElementById('nav-xshop').getElementsByTagName('a')[i].click();break;}i++;}");
		Thread.sleep(1000);
		for (int i = 1; i <= 3; i++) {
			js.executeScript("window.scrollBy(0,1000)");// Scrool Vertical with 1000pixles
			Thread.sleep(500);
		}
		for (int i = 1; i <= 3; i++) {
			js.executeScript("window.scrollBy(0,-1000)"); // Scrool Vertical with 1000pixles
			Thread.sleep(500);
		}
		if(Driver.getTitle().contains(linkName)) {
			setDetailMsg(Driver.getTitle());
			Assert.assertTrue(true);
		}
		else {
			setDetailMsg(Driver.getTitle()+" not matched");
			Assert.assertTrue(false);
		}
		Thread.sleep(1000);
		Amazon.RightArrow().click();
		Thread.sleep(500);
		Amazon.LeftArrow().click();
		Thread.sleep(2000);
		String path = ".//OutputExcel//TodayDeals.xlsx";
		String sheetName="Objects";
		setDetailMsg(sheetName+"- sheet is created");
		String heading="OBJECTS_IN_TODAYSDEAL";
		TestData.openFile(path, sheetName, heading);
		List<WebElement> Elements2 = Amazon.getAllLinksInThisPage();
		int i=1;
		for (WebElement Ele : Elements2) {
			
			if (!Ele.getText().equals("")) {
				Thread.sleep(500);
				TestData.writeDataOnExcel(i,0,Ele.getText());
				i++;
			}
		}
		TestData.closeFile();
 		Thread.sleep(2000);
		js.executeScript("arguments[0].ScrollntoView", Amazon.Appliances());
		Amazon.Appliances().click();
		Thread.sleep(2000);
		Amazon.Kitchen().click();
		Thread.sleep(6000);
		try {
			Amazon.Kitchen_produt().click();
		}catch(Exception e){
			try{
			Amazon.getAnotherProduct().click();
			}catch(Exception e1) {
				Amazon.getPro2().click();
			}
		}
		setDetailMsg("Product clicked");
		setDetailMsg("Selected Product Page Title is - "+Driver.getTitle());
		String proName=Amazon.getProductName().getText();
		int expCartValue=Integer.parseInt(amazoneOBJ.getCartValue.getText());
		Thread.sleep(3000);
		Amazon.AddtoChar().click();
		Thread.sleep(3000);
		setDetailMsg("Product Added to the cart");
		int actCartValue=Integer.parseInt(amazoneOBJ.getCartValue.getText());
		if(expCartValue<actCartValue) {
		setDetailMsg("Old Cart Value "+expCartValue+" is added +1 is = "+actCartValue +" :- Then Product Name - "+proName+" - is added to the Cart");
		}else {
			setDetailMsg("Old Cart Value "+expCartValue+"and new cart value "+actCartValue+" is same "+proName+" - is not added into the Cart");
		}
		setOpenFilePath(path);
		Assert.assertEquals(actCartValue, expCartValue+1);
	}
}
