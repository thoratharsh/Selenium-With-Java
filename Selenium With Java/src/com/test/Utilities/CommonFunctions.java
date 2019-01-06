package com.test.Utilities;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public void input_Text(String xpath, String text) {
		driver.findElement(By.xpath(xpath)).clear();
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	public void clear_Text(String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}

	public void click_Element(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void wait_until_Element_is_Visible(String xpath, int wait_time) {
		WebDriverWait wait = new WebDriverWait(driver, wait_time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public void wait_until_Element_is_Clickable(String xpath, int wait_time) {
		WebDriverWait wait = new WebDriverWait(driver, wait_time);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void wait_until_Element_is_not_Visible(String xpath, int wait_time) {
		WebDriverWait wait = new WebDriverWait(driver, wait_time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public void wait_until_All_Elements_are_Visible(String xpath, int wait_time) {
		WebDriverWait wait = new WebDriverWait(driver, wait_time);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	public void select_Picklist_By_Visible_Text(String xpath, String text) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByVisibleText(text);
	}

	public void select_Picklist_By_Value(String xpath, String value) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByValue(value);
	}

	public void select_Picklist_By_Index(String xpath, int index) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByIndex(index);
	}

	public void deselect_Picklist_By_Visible_Text(String xpath, String text) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.deselectByVisibleText(text);
	}

	public void deselect_Picklist_By_Value(String xpath, String value) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.deselectByValue(value);
	}

	public void deselect_Picklist_By_Index(String xpath, int index) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.deselectByIndex(index);
	}

	public String get_Selected_Picklist(String xpath) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		return select.getFirstSelectedOption().getText();
	}

	public List<String> get_All_Options(String xpath) {
		List<String> options = null;
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		List<WebElement> op = select.getOptions();
		for (int i = 0; i < op.size(); i++) {
			options.add(op.get(i).getText());
		}
		return options;
	}

	public void close_Browser() {
		driver.close();
		driver.quit();
	}

}
