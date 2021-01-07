package testObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	private static WebDriver driver;
	
	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable_notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void afterTest() {
		getDriver().quit();
	}
	
	protected static WebDriver getDriver() {
		return driver;
	}

}
