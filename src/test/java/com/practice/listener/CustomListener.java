package com.practice.listener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.practice.bases.BaseClass;
import com.practice.utilities.TestUtilties;
import com.relevantcodes.extentreports.LogStatus;


public class CustomListener extends BaseClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = rep.startTest(result.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output", "false");
	
		
		try {
			TestUtilties.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(LogStatus.PASS, result.getName().toUpperCase() +" CLASS HAS BEEN PASSED");
		test.log(LogStatus.PASS, test.addScreenCapture(TestUtilties.ScreenshotName));
		Reporter.log("<a target=\"_blank\" href ="+TestUtilties.ScreenshotName+">Screenshot</a>");
		Reporter.log("<a href ="+TestUtilties.ScreenshotName+"><img height=100 width=100 src="+TestUtilties.ScreenshotName+"></img></a>");
		rep.endTest(test);
		rep.flush();
			
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {
			TestUtilties.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed Exeption" + result.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtilties.ScreenshotName));
		
		
		Reporter.log("<a target=\"_blank\" href ="+TestUtilties.ScreenshotName+">Screenshot</a>");
		Reporter.log("<a href ="+TestUtilties.ScreenshotName+"><img height=100 width=100 src="+TestUtilties.ScreenshotName+"></img></a>");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
