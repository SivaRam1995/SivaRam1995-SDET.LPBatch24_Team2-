package com.qa.testscripts;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.katasiva.excelutility.TestData;

public class TC_AmazonCreateAccountAndSignIn_001 extends TestBase {

	@Test(dataProvider = "getData")
	public void CreatAccountAndLogIn(String[] input) throws Exception {
		WebElement AccountElement = signUp_OR.Account();
		act.moveToElement(AccountElement).build().perform();
		Thread.sleep(1000);
		signUp_OR.Signin().click();
		Thread.sleep(1000);
		signUp_OR.CreateAmznAccnt().click();
		Thread.sleep(3000);
		signUp_OR.YourName().sendKeys(input[0]);
		Thread.sleep(1000);
		try {
		signUp_OR.MobileNumber().sendKeys(input[1]);
		Thread.sleep(1000);
		signUp_OR.Email().sendKeys(input[2]);
		signUp_OR.Password().sendKeys(input[3]);
		Thread.sleep(1000);
		}catch(Exception e) {
			signUp_OR.getMobOrMailBox().sendKeys(input[1]);
			Thread.sleep(1000);
			signUp_OR.Password().sendKeys(input[3]);
			Thread.sleep(1000);
			signUp_OR.getReEnterPassword().sendKeys(input[3]);
			Thread.sleep(1000);
		}
			signUp_OR.Continue().click();
		Thread.sleep(3000);
		if (signUp_OR.getExistAccText().getText().contains(property.getProperty("checkExistingAcc"))) {
			 setDetailMsg("Existing acc Details - "+signUp_OR.getExistAccText().getText());
			signUp_OR.getSignInLink().click();
			signUp_OR.PhoneNumber().sendKeys(input[1]);
			Thread.sleep(1000);
			signUp_OR.continue1().click();
			Thread.sleep(1000);
			signUp_OR.getPassword().sendKeys(input[3]);
			Thread.sleep(1000);
			signUp_OR.getRemember().click();
			signUp_OR.getsignInSubmit().click();
			Thread.sleep(3000);
			
			if(Driver.getTitle().equals(property.getProperty("ExpectedAmazonLoginTitle"))) {
			setDetailMsg("loginSuccessfull..!");
			Assert.assertTrue(true);
			}else {
				setDetailMsg("login Failed..");
				Assert.assertTrue(false);
				}
		} else {
			setDetailMsg("account existing test failed..!");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider
	public String[][] getData() throws IOException {
		String sheetName = "credentials";
		int rowNum=Integer.parseInt(property.getProperty("loginCredentialsExcelRowNum"));
		return TestData.getSingleRowFromExcel(path, sheetName, rowNum);
	}

}
