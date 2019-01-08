package com.test.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.BusinessFunctions.Login;
import com.test.Utilities.CommonFunctions;
import com.test.Utilities.Config;

public class DemoTest {
	CommonFunctions action = new CommonFunctions();
	WebDriver driver = null;

	@BeforeMethod
	public void setup() {
		driver = action.open_Application("chrome", Config.URL);
	}

	@Test
	public void Login_to_Organge_HRM() throws InterruptedException {
		Login login = new Login(driver);
		login.login_to_Orange_hrm("Admin", "admin123");
		Thread.sleep(5000);
	}

	@AfterMethod
	public void teardown() {
		action.close_Browser(driver);
	}
}
