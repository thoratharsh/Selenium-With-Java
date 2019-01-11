package com.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.test.BusinessFunctions.Login;
import com.test.Utilities.CommonFunctions;
import com.test.Utilities.Config;
import com.test.Utilities.Extent_Report;

public class DemoTest {
	ExtentTest test = null;
	CommonFunctions action = new CommonFunctions(test);
	WebDriver driver = null;

	@BeforeClass
	public void setup_before_suite() {
		Extent_Report.create_Report();
	}

	@BeforeMethod
	public void setup() {
		driver = action.open_Application("chrome", Config.URL);
	}

	@Test
	public void Login_to_Organge_HRM() throws InterruptedException {
		ExtentTest test = Extent_Report.start_test("TC001_Verify user can login to Organge HRM");
		Login login = new Login(driver, test);
		login.login_to_Orange_hrm("Admin", "admin123");
		
		Extent_Report.end_test(test);
	}

	@Test
	public void Login_to_Organge_HRM2() throws InterruptedException {
		ExtentTest test = Extent_Report.start_test("TC002_Verify user can login to Organge HRM");
		Login login = new Login(driver, test);
		login.login_to_Orange_hrm("Admin", "admin123");
		Extent_Report.end_test(test);
	}

	@AfterMethod
	public void teardown() {
		action.close_Browser(driver);
	}

	@AfterClass
	public void teardown_after_suite() {
		Extent_Report.close_Report();
	}
}
