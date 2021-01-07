package resources;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
public class BaseMethods {
	
	private static FluentWait<WebDriver> fluentWait(int time, WebDriver driver) {
		FluentWait<WebDriver> wait = null;
		try {
			wait = new FluentWait<WebDriver>(driver)
	                .withTimeout(Duration.ofSeconds(time))
	                .pollingEvery(Duration.ofSeconds(5))
	                .ignoring(NoSuchElementException.class)
	                .withMessage("Element was not found");
		} catch (Exception e) {
			wait = null;
		}
		return wait;
    }
	
	public void isElementPresentVisibleAndClickable(By by, int time, WebDriver driver) throws NoSuchElementException {
		try {
           fluentWait(time, driver).until(ExpectedConditions.elementToBeClickable(driver.findElement(by)));
        } catch (Exception e) {
            throw new NoSuchElementException("The element was not visible and clickable.");
        }
   }

 public void isElementDisplayed(By by, int time, WebDriver driver) throws NoSuchElementException {
	 try {
            fluentWait(time, driver).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            throw new NoSuchElementException("The element was not visible.");
        }
   }
 
 public void isElementPresent(By by, int time, WebDriver driver) throws NoSuchElementException {
     try {
         fluentWait(time, driver).until(ExpectedConditions.presenceOfElementLocated(by));
     } catch (Exception e) {
         throw new NoSuchElementException("The element was not present.");
     }
}
 
 public void isElementPresentVisibleAndClickable(WebElement element, int time, WebDriver driver) throws NoSuchElementException {
	 try {
        fluentWait(time, driver).until(ExpectedConditions.elementToBeClickable(element));
     } catch (Exception e) {
         throw new NoSuchElementException("The element was not visible and clickable.");
     }
}

 public void waitPageToLoad(WebDriver driver, int duration) {
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
	 wait.until((ExpectedCondition<Boolean>) driver1 -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
 }
}
