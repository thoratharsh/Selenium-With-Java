package com.test.TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.Utilities.CommonFunctions;
import com.test.Utilities.Config;

public class DemoTest {

	public CommonFunctions action = null;;

	@BeforeMethod
	public void setup() {
		action = new CommonFunctions();
	}

	@Test
	public void my_First_Test_Case() throws InterruptedException {
		action.open_Application("chrome", Config.URL);
		Thread.sleep(4000);
	}
	
	@Test
	public void my_Second_Test_Case() throws InterruptedException {
		action.open_Application("chrome", Config.URL);
		Thread.sleep(4000);
	}
	
	@AfterMethod
	public void teardown() {
		action.close_Browser();
	}
}
