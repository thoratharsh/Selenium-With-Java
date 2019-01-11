package com.test.Utilities;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

public class CommonFunctions {
	ExtentTest test = null;

	public CommonFunctions(ExtentTest test) {
		this.test = test;
	}

	public WebDriver open_Application(String BrowserName, String url) {
		WebDriver driver = null;
		switch (BrowserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Config.CHROMEDRIVER_PATH);
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", Config.FIREFOXDRIVER_PATH);
			driver = new FirefoxDriver();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver", Config.IEDRIVER_PATH);
			driver = new InternetExplorerDriver();
			break;

		case "opera":
			System.setProperty("webdriver.opera.driver", Config.OPERADRIVER_PATH);
			driver = new InternetExplorerDriver();
			break;

		default:
			System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();

		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(url);
		return driver;
	}

	public void input_Text(WebDriver driver, String xpath, String text, String field_name) {
		try {
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(text);
			Extent_Report.pass_test(test, text + " entered in " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while entering text in " + field_name);
			e.printStackTrace();
		}
	}

	public void clear_Text(WebDriver driver, String xpath) {
		driver.findElement(By.xpath(xpath)).clear();
	}

	public void click_Element(WebDriver driver, String xpath, String field_name) {
		try {
			driver.findElement(By.xpath(xpath)).click();
			Extent_Report.pass_test(test, "Clicked on " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while clicking on " + field_name);
			e.printStackTrace();
		}
	}

	public void wait_until_Element_is_Visible(WebDriver driver, String xpath, int wait_time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, wait_time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void wait_until_Element_is_Clickable(WebDriver driver, String xpath, int wait_time) {
		WebDriverWait wait = new WebDriverWait(driver, wait_time);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}

	public void wait_until_Element_is_not_Visible(WebDriver driver, String xpath, int wait_time) {
		WebDriverWait wait = new WebDriverWait(driver, wait_time);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}

	public void wait_until_All_Elements_are_Visible(WebDriver driver, String xpath, int wait_time) {
		WebDriverWait wait = new WebDriverWait(driver, wait_time);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));
	}

	public void select_Picklist_By_Visible_Text(WebDriver driver, String xpath, String text, String field_name) {
		try {
			Select select = new Select(driver.findElement(By.xpath(xpath)));
			select.selectByVisibleText(text);
			Extent_Report.pass_test(test, text + " selected in " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while selecting " + text + " in " + field_name);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void select_Picklist_By_Value(WebDriver driver, String xpath, String value, String field_name) {
		try {
			Select select = new Select(driver.findElement(By.xpath(xpath)));
			select.selectByValue(value);
			Extent_Report.pass_test(test, value + "selected in " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while selecting " + value + " in " + field_name);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void select_Picklist_By_Index(WebDriver driver, String xpath, int index, String field_name) {
		try {
			Select select = new Select(driver.findElement(By.xpath(xpath)));
			select.selectByIndex(index);
			Extent_Report.pass_test(test, "Picklist of index " + index + " selected in " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while selecting picklist value in " + field_name);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deselect_Picklist_By_Visible_Text(WebDriver driver, String xpath, String text, String field_name) {
		try {
			Select select = new Select(driver.findElement(By.xpath(xpath)));
			select.deselectByVisibleText(text);
			Extent_Report.pass_test(test, "Deselected " + text + " in " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error While deselecting " + text + " in " + field_name);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deselect_Picklist_By_Value(WebDriver driver, String xpath, String value, String field_name) {
		try {
			Select select = new Select(driver.findElement(By.xpath(xpath)));
			select.deselectByValue(value);
			Extent_Report.pass_test(test, "Deselected " + value + " in " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while deselecting picklist in " + field_name);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deselect_Picklist_By_Index(WebDriver driver, String xpath, int index, String field_name) {
		try {
			Select select = new Select(driver.findElement(By.xpath(xpath)));
			select.deselectByIndex(index);
			Extent_Report.pass_test(test, "Deselected picklist of index " + index + " from " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while deselecting picklist in" + field_name);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String get_Selected_Picklist(WebDriver driver, String xpath) {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		return select.getFirstSelectedOption().getText();
	}

	public List<String> get_All_Options(WebDriver driver, String xpath) {
		List<String> options = null;
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		List<WebElement> op = select.getOptions();
		for (int i = 0; i < op.size(); i++) {
			options.add(op.get(i).getText());
		}
		return options;
	}

	public void select_checkbox(WebDriver driver, String xpath, String field_name) {
		try {
			boolean result = driver.findElement(By.xpath(xpath)).isSelected();
			if (!result) {
				driver.findElement(By.xpath(xpath)).click();
			}
			Extent_Report.pass_test(test, "Selected checkbox " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while selecting checkbox " + field_name);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void unselect_checkbox(WebDriver driver, String xpath, String field_name) {
		try {
			boolean result = driver.findElement(By.xpath(xpath)).isSelected();
			if (result) {
				driver.findElement(By.xpath(xpath)).click();
			}
			Extent_Report.pass_test(test, "Unselected checkbox " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while unselecting checkbox " + field_name);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mouseover_over_element(WebDriver driver, String xpath) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath(xpath))).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void drag_element_to_target_element(WebDriver driver, String source_xpath, String target_xpath) {
		try {
			Actions action = new Actions(driver);
			WebElement source = driver.findElement(By.xpath(source_xpath));
			WebElement target = driver.findElement(By.xpath(target_xpath));
			action.dragAndDrop(source, target).build().perform();
			Extent_Report.pass_test(test, "Dragged and dropped element");
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while drag and drop element");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void double_click(WebDriver driver, String xpath, String field_name) {
		try {
			Actions action = new Actions(driver);
			action.doubleClick(driver.findElement(By.xpath(xpath))).build().perform();
			Extent_Report.pass_test(test, "Double clicked on " + field_name);
		} catch (Exception e) {
			Extent_Report.fail_test(test, "Error while double clicking at " + field_name);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void select_frame(WebDriver driver, String xpath) {
		WebElement ele= driver.findElement(By.xpath(xpath));
		driver.switchTo().frame(ele);
	}
	
	public void switch_to_default_frame(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	public Set<String> get_window_handles (WebDriver driver){
		Set<String> windows = driver.getWindowHandles();
		return windows;
	}
	
	public void select_window(WebDriver driver, String window_handle) {
		driver.switchTo().window(window_handle);
	}

	public void close_Browser(WebDriver driver) {
		driver.close();
		driver.quit();
	}

}
