package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2e.base.TestBase;
import com.w2e.utilities.TestUtil;


public class AddCustomerTest extends TestBase {
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomerTest(String firstName,String lastName,String pinCode,String alertText) throws InterruptedException {
		//System.setProperty("org.uncommons.reportng.escape-output", "false");
		//driver.findElement(By.cssSelector(ObjectRespository.getProperty("addCustomerBUtton"))).click();
		click("addCustomerBUtton");
		Thread.sleep(3000);
		//driver.findElement(By.cssSelector(ObjectRespository.getProperty("firstName"))).sendKeys(firstName);
		typing("firstName", firstName);
		//driver.findElement(By.cssSelector(ObjectRespository.getProperty("lastName"))).sendKeys(lastName);
		typing("lastName", lastName);
		//driver.findElement(By.cssSelector(ObjectRespository.getProperty("postCode"))).sendKeys(pinCode);
		typing("postCode", pinCode);
		//driver.findElement(By.cssSelector(ObjectRespository.getProperty("addCustomerFinalButton"))).click();
		click("addCustomerFinalButton");
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alertText), "Expected alert is present");
		
		alert.accept();
		
		//Assert.fail("Failed willingly");
		
		//Reporter.log("<a herf=\"C:\\Users\\surendarg97\\Pictures\\Screenshots\\Screenshot (438).jpg\">Screenshot</a>");
		
		Thread.sleep(3000);
		
		
	}
	
	

}
