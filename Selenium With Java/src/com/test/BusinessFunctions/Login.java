package com.test.BusinessFunctions;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.test.PageObjects.LoginPage;
import com.test.Utilities.CommonFunctions;

public class Login {
	public WebDriver driver = null;
	ExtentTest test= null;
	CommonFunctions action = null;

	public Login(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test= test;
		action=new CommonFunctions(this.test);
	}

	public void login_to_Orange_hrm(String username, String password) {
		action.input_Text(driver, LoginPage.username, username,"Username");
		action.input_Text(driver, LoginPage.password, password,"Password");
		action.click_Element(driver, LoginPage.login_button,"Login button");
	}
}
