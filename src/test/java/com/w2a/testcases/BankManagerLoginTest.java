package com.w2a.testcases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2e.base.TestBase;

public class BankManagerLoginTest extends TestBase {
	
	
	@Test
	public void loginAsBankManager() throws InterruptedException {
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		log.info("Login test case started!!");
		//driver.findElement(By.cssSelector(ObjectRespository.getProperty("bankManagerButton"))).click();
		click("bankManagerButton");
		Thread.sleep(3000);
		Assert.assertTrue(isElementPresent(By.cssSelector(ObjectRespository.getProperty("addCustomerBUtton"))),"Login not successfully");
		//Assert.fail("Failed willingly");
		
	}
	
	
	

}
