package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.BaseMethods;

public class GoogleHomePage extends BasePage {
	
	public GoogleHomePage(WebDriver driver) {
		super(driver);
	}

	//xpath
	private String searchInput = "//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input";
	
	//xpath
	private String searchButton = "//*[@id=\"tsf\"]/div[2]/div[1]/div[3]/center/input[1]";
	
	//id
	private String googleLogo = "hplogo";
	
	//xpath
	private String suggestionList = "//*[@role=\"listbox\"]";
	
	//xpath
	private String firstSuggestionLink = "//*[@role=\"listbox\"]/li[1]";
	
	public WebElement getSearchInput() {
		BaseMethods methods = new BaseMethods();
		methods.isElementDisplayed(By.xpath(getSearchInputXpathLocator()), 5, driver);
		return driver.findElement(By.xpath(searchInput));
	}
	
	public String getSearchInputXpathLocator() {
		return searchInput;
	}
	
	public WebElement getSearchButton() {
		BaseMethods methods = new BaseMethods();
		methods.isElementDisplayed(By.xpath(getSearchButtonXpathLocator()), 5, driver);
		return driver.findElement(By.xpath(searchButton));
	}
	
	public String getSearchButtonXpathLocator() {
		return searchButton;
	}
	
	public WebElement getGoogleLogo() {
		BaseMethods methods = new BaseMethods();
		methods.isElementDisplayed(By.id(getGoogleLogoIdLocator()), 5, driver);
		return driver.findElement(By.id(googleLogo));
	}
	
	public String getGoogleLogoIdLocator() {
		return googleLogo;
	}
	
	public WebElement getSuggestionList() {
		BaseMethods methods = new BaseMethods();
		methods.isElementDisplayed(By.xpath(getSuggestionListXpathLocator()), 5, driver);
		return driver.findElement(By.xpath(suggestionList));
	}
	
	public String getSuggestionListXpathLocator() {
		return suggestionList;
	}
	
	public WebElement getFirstSuggestionLink() {
		BaseMethods methods = new BaseMethods();
		methods.isElementDisplayed(By.xpath(getFirstSuggestionLinkXpathLocator()), 5, driver);
		return driver.findElement(By.xpath(firstSuggestionLink));
	}
	
	public String getFirstSuggestionLinkXpathLocator() {
		return firstSuggestionLink;
	}
	
	public void writeIntoSearchInput(String text) {
		getSearchInput().sendKeys(text);
	}
	
	public void clickOnSearchButton() {
		getSearchButton().click();
	}
	
	public void clickOnGoogleLogo() {
		getGoogleLogo().click();
	}
	
	public String getFirstSuggestionLinkText() {
		return getFirstSuggestionLink().getText();
	}
	public void clickOnFirstSuggestionLink() {
		getFirstSuggestionLink().click();
	}

}
