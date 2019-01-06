package com.test.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CommonFunctions {

	WebDriver driver = null;

	public void open_Application(String BrowserName, String url) {
		switch (BrowserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Config.CHROMEDRIVER_PATH);
			this.driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", Config.FIREFOXDRIVER_PATH);
			this.driver = new FirefoxDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", Config.IEDRIVER_PATH);
			this.driver = new InternetExplorerDriver();
			break;
			
		case "opera":
			System.setProperty("webdriver.opera.driver", Config.OPERADRIVER_PATH);
			this.driver = new InternetExplorerDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
			this.driver = new ChromeDriver();

		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(url);
	}

	public WebDriver get_Driver() {
		return driver;
	}

	public void close_Browser() {
		driver.close();
		driver.quit();
	}

}
