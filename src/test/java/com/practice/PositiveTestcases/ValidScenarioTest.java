package com.practice.PositiveTestcases;

import org.testng.annotations.Test;

import com.practice.bases.BaseClass;
import com.practice.utilities.TestUtilties;
import com.relevantcodes.extentreports.LogStatus;

public class ValidScenarioTest extends BaseClass {
	
	
	@Test(dataProviderClass = TestUtilties.class, dataProvider = "dp", priority = 1)
	public void selectFromAndTOCityTest(String From,String To) {
		
		scrollDown();
		click("cookieCloseBtn_XPATH");
		type("fromBtn_XPATH", From);
		type("ToBtn_XPATH", To);
		forceWait();
		test.log(LogStatus.PASS, "Entered Mumbai As ARRIVAL and Delhi As Depature City");
		
	}
	

	@Test(priority = 2)
	public void seletOneWayTest() {
		
		click("oneWayBtn_ID");
		forceWait();
		test.log(LogStatus.PASS, "Trip Booking For One Way Journey");
		
	}
	
	@Test(priority = 3)
	public void selectDateTest() throws InterruptedException {
		
		click("departDateBtn_XPATH");
		click("date_ID");
		selectDate("nextMonth_XPATH");
		forceWait();
		test.log(LogStatus.PASS, "Selected Dates For Journey");
	
	}
	
	@Test(priority = 4 )
	public void clickSearchTest() throws InterruptedException {
		click("searchBtn_ID");
		toNavigate();
		scrollDown();
		scrollDown();
		forceWait();
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Clicked On Search Button");
	}
	
	
	
	
	
	
	
	

}
