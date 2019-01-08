package com.test.BusinessFunctions;

import org.openqa.selenium.WebDriver;

import com.test.PageObjects.LoginPage;
import com.test.Utilities.CommonFunctions;

public class Login {
	public WebDriver driver = null;
	CommonFunctions action = new CommonFunctions();

	public Login(WebDriver driver) {
		this.driver = driver;
	}

	public void login_to_Orange_hrm(String username, String password) {
		action.input_Text(driver, LoginPage.username, username);
		action.input_Text(driver, LoginPage.password, password);
		action.click_Element(driver, LoginPage.login_button);
	}
}
