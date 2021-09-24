package com.qa.testscripts;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.katasiva.excelutility.ExcelUtility;
import com.katasiva.excelutility.TestData;

public class TC_WriteOrderMessagesDetailsOnExcel_001 extends TestBase {
	@Test
	public void writeAmazonOrderMessageDetails() throws InterruptedException, IOException {
		
		Thread.sleep(5000);
		act.moveToElement(mcp.getAccount()).build().perform();
		mcp.getYourAccount().click();
		setDetailMsg("click on Your Account");
		Thread.sleep(1000);
		mcp.getMsgCenter().click();
		setDetailMsg("Title of this page - "+Driver.getTitle());
		setDetailMsg("click on MessageCenter from Email Alerts,Messages,and ads");
		js.executeScript("window.scrollBy(0,150);");
		String file_path=".//OutputExcel//AmazonOrderDetails.xlsx";
		String sheetName="orderDetails";
		setDetailMsg(sheetName+"- sheet is created");
		String heading="Amazon Order List";
		TestData.openFile(file_path, sheetName, heading);
		int msgCount=0;
		int i=1;
		while (true) {
			Thread.sleep(4000);
			List<WebElement> messages = mcp.getMessages();
			for (WebElement msg : messages) {
				Thread.sleep(1000);
				TestData.writeDataOnExcel(i,0,msg.getText());
				msgCount=i;
				i++;
			}
			if (mcp.getNextBtn().getAttribute("class").contains("a-button-disabled")==false) {
				mcp.getNextBtn().click();
			} else {
				break;
			}
		}
		if (mcp.getNextBtn().getAttribute("class").contains("a-button-disabled")==true) {
		TestData.closeFile();
		js.executeScript("window.scrollBy(0,-150)");
		Thread.sleep(3000);
		setDetailMsg("Previous all orderDetails readed and write into on EXCEl file path is -"+file_path);
		mcp.getLogo().click();
		Thread.sleep(6000);
		ExcelUtility excel=new ExcelUtility(file_path);
		int rowCount=excel.getRowCount(sheetName);
		setOpenFilePath(file_path);
		Assert.assertEquals(msgCount,rowCount,"Message Count :-"+msgCount+"-: And After writing the Messages Excel file Rows Count :-"+rowCount+"-: both matched condition successfull ");
		}
		else {
			setDetailMsg("Error occured Test case failed");
			Assert.assertTrue(false);
		}
	}
}
