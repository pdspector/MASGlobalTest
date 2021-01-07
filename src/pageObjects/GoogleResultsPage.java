package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.BaseMethods;

public class GoogleResultsPage extends BasePage {

	public GoogleResultsPage(WebDriver driver) {
		super(driver);
	}
	
	//xpath
	private String firstResultLink = "//*[@id=\"rso\"]/div[1]/div/div[1]/a";
	
	//xpath
	private String firstResultPageLinkText = "//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3/span";
	
	public WebElement getFirstResultLink() {
		BaseMethods methods = new BaseMethods();
		methods.isElementDisplayed(By.xpath(getFirstResultLinkXpathLocator()), 5, driver);
		return driver.findElement(By.xpath(firstResultLink));
	}
	
	public String getFirstResultLinkXpathLocator() {
		return firstResultLink;
	}
	
	public WebElement getFirstResultLinkText() {
		BaseMethods methods = new BaseMethods();
		methods.isElementDisplayed(By.xpath(getFirstResultLinkTextXpathLocator()), 5, driver);
		return driver.findElement(By.xpath(firstResultPageLinkText));
	}
	
	public String getFirstResultLinkTextXpathLocator() {
		return firstResultPageLinkText;
	}
	
	public void clickOnFirstResultLink() {
		getFirstResultLink().click();
	}
	public String getFirstResultLinkTitleText() {
		return getFirstResultLinkText().getText();
	}

}
