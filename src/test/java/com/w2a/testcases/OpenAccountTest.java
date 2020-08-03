package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2e.base.TestBase;
import com.w2e.utilities.TestUtil;


public class OpenAccountTest extends TestBase {
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void openAccountTest(String customerName,String currency) throws InterruptedException {
		
		
		
	}
	
	

}
