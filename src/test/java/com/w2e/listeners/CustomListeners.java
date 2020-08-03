package com.w2e.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;
import com.w2e.base.TestBase;
import com.w2e.utilities.TestUtil;

public class CustomListeners extends TestBase implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		test=report.startTest(result.getName().toUpperCase());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"PASS");
		report.endTest(test);
		report.flush();
	}

	public void onTestFailure(ITestResult result) {
		
		Reporter.log("Testcase failed");
		
		try {
			TestUtil.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"FAIL with exeption"+result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtil.screenShotName));
		report.endTest(test);
		report.flush();
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

	
}
