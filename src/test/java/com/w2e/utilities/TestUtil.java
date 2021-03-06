package com.w2e.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.w2e.base.TestBase;

public class TestUtil extends TestBase{
	
	public static String screenShotName;
	
	public static void captureScreenshot() throws IOException {
		
		
		File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date date =new Date();
		screenShotName= date.toString().replace(":", "_").replace(" ", "_")+".jpg";
		FileUtils.copyFile(screenShotFile, new File(System.getProperty("user.dir")+"\\target\\surefire-reports\\html\\"+screenShotName));
	}
	
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		String sheetName=m.getName();
		int rows=excel.getRowCount(sheetName);
		int cols=excel.getColumnCount(sheetName);
		
		Object[][] data=new Object[rows-1][cols];
		
		for(int rowNum=2;rowNum<=rows;rowNum++) {
			for(int colNum=0;colNum<cols;colNum++){
				
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
				
			}
		}
		
		
		return data;
		
	}

}
