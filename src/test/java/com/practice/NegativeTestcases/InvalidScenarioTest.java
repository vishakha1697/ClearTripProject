package com.practice.NegativeTestcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.practice.bases.BaseClass;
import com.practice.utilities.TestUtilties;
import com.relevantcodes.extentreports.LogStatus;

public class InvalidScenarioTest extends BaseClass {
	
	@BeforeClass
	public void back() {
		
		driver.navigate().back();
		scrollDown();
		clear("fromBtn_XPATH");
		clear("ToBtn_XPATH");
		forceWait();
	}
	
	
	@Test(dataProviderClass = TestUtilties.class, dataProvider = "dp")
	public void invalidSearchTest(String From,String To) throws InterruptedException {
		
		scrollDown();
		clear("departDateBtn_XPATH");
		clear("nextMonth_XPATH");
		click("departDateBtn_XPATH");
		click("date_ID");
		selectDate("nextMonth_XPATH");
		click("searchBtn_ID");
		forceWait();
		test.log(LogStatus.PASS, "Not Filling All Details and Clicking On Search Button, Error Displayed As 'Enter Location'");
	}
	
	
	
	@Test(dataProviderClass = TestUtilties.class, dataProvider = "dp")
	public void invalidSearchFromCityTest(String From,String To) {
		clear("fromBtn_XPATH");
		type("fromBtn_XPATH", From);
		click("fromBtn_XPATH");
		forceWait();
		test.log(LogStatus.PASS,"Invalid Arrival and Departure city");
		
	}
	
	@Test
	public void invalidSearchseletOneWayTest() {
		click("oneWayBtn_ID1");
		click("searchBtn_ID");
		forceWait();
		test.log(LogStatus.FAIL,"Incorrrect Locator But Still Selecting Oneway Button");
	}
	
	@Test(priority = 1 )
	public void invalidSearchselectDateTest() {
		click("departDateBtn_XPATH");
		click("date_ID");
		click("searchBtn_ID");
		forceWait();
		test.log(LogStatus.PASS,"Not Selecting Check Out City");
	}
	
	
	
	
	
	

}
