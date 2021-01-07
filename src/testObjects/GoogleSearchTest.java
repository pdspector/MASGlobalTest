package testObjects;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.FirstResultPage;
import pageObjects.GoogleHomePage;
import pageObjects.GoogleResultsPage;

@Listeners(value = { resources.ExtentReporterNG.class, resources.Listeners2.class })
public class GoogleSearchTest extends BaseTest {
	
	private String firstTextToSearch = "The name of the wind";
	private String secondTextToSearch = "The name of the w";
	private String firstResultLinkText = "The Name of the Wind - Patrick Rothfuss";
	private String expectedSiteHeaderText = "Patrick Rothfuss - The Books";
	private String googleHomeUrl = "https://www.google.com";
	private GoogleHomePage homePage = null;
	private GoogleResultsPage googleResultsPage = null;
	private FirstResultPage firstResultPage = null;
	
	@BeforeMethod
	public void beforeMethod() {
		getDriver().get(googleHomeUrl);
	}
	
	@Test(priority = 1)
	public void verifyOfficialSiteIsOnFirstGoogleResultAndIsAccessible() {
		homePage = new GoogleHomePage(getDriver());
		homePage.writeIntoSearchInput(firstTextToSearch);
		homePage.clickOnGoogleLogo();
		homePage.clickOnSearchButton();
		googleResultsPage = new GoogleResultsPage(getDriver());
		String linkText = googleResultsPage.getFirstResultLinkTitleText();
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(linkText, firstResultLinkText,
				"The first result link text was not the one expected. Got: " + linkText + ". Expected: " + firstResultLinkText + ".");
		googleResultsPage.clickOnFirstResultLink();
		firstResultPage = new FirstResultPage(getDriver());
		String header = firstResultPage.getPageHeader();
		assertion.assertEquals(header, expectedSiteHeaderText,
				"The first result page was not the one expected. Got: " + header + ". Expected: " + expectedSiteHeaderText + ".");
		assertion.assertAll();
	}
	
	@Test(priority = 2)
	public void verifyOfficialSiteIsFirstSuggestionAndIsAccessible() {
		homePage = new GoogleHomePage(getDriver());
		homePage.writeIntoSearchInput(secondTextToSearch);
		SoftAssert assertion = new SoftAssert();
		assertion.assertTrue(homePage.getSuggestionList().isDisplayed(),
				"The suggestion list was not displayed");
		homePage.clickOnFirstSuggestionLink();
		googleResultsPage = new GoogleResultsPage(getDriver());
		String linkText = googleResultsPage.getFirstResultLinkTitleText();
		assertion.assertEquals(linkText, firstResultLinkText,
				"The first result link text was not the one expected. Got: " + linkText + ". Expected: " + firstResultLinkText + ".");
		googleResultsPage.clickOnFirstResultLink();
		firstResultPage = new FirstResultPage(getDriver());
		String header = firstResultPage.getPageHeader();
		assertion.assertEquals(header, expectedSiteHeaderText,
				"The first result page was not the one expected. Got: " + header + ". Expected: " + expectedSiteHeaderText + ".");
		assertion.assertAll();
	}
	
	
}
