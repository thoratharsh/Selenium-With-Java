package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Utilities.CommonFunctions;

public class DemoTest {
	
	@Test
	public void my_First_Test_Case() throws InterruptedException {
		CommonFunctions action = new CommonFunctions();
		action.open_Application("chrome", "http://www.google.com");
		Thread.sleep(4000);
		action.close_Browser();	
	}
}
