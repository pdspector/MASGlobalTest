package pageObjects;

import org.openqa.selenium.WebDriver;

public class FirstResultPage extends BasePage {

	public FirstResultPage(WebDriver driver) {
		super(driver);
	}
	
	public String getPageHeader() {
		return driver.getTitle();
	}

}
