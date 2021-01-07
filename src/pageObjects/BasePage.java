package pageObjects;

import org.openqa.selenium.WebDriver;

import resources.BaseMethods;

public class BasePage {

	protected static WebDriver driver = null;

	public BasePage(WebDriver driver) {
		BasePage.driver = driver;
		BaseMethods methods = new BaseMethods();
		methods.waitPageToLoad(driver, 15);
	}
}
