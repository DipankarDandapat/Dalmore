package genericLib;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.base.Function;


public class Wait {
	
	
	public static void waitForPageToLoad(){
		//Reporter.log("waiting for page to load...");
		try{
		Driver.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Reporter.log("Page is loaded");
		}
		catch(Throwable error){
			//Reporter.log("Timeout for Page Load Request to complete after "+ 20 + " seconds");
			Assert.assertTrue(false, "Timeout for page load request after "+20+" second");
		}
	  }
	
	
	public void waitForXpathPresent(String wbXpath){
		WebDriverWait wait = new WebDriverWait(Driver.driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(wbXpath)));
		
			 		
	   }

	
	
	public void waitForNamePresent(String wbName){
		WebDriverWait wait = new WebDriverWait(Driver.driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.name(wbName)));
						
	  }
	
	
	public void clickWhenReady(String locator) {
		WebDriverWait wait = new WebDriverWait(Driver.driver, 20);
		 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
		

	}
	
	public static void getWhenVisible(String locator) {

		WebDriverWait wait = new WebDriverWait(Driver.driver, 20);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

	}
	
	
	
	
	public WebElement fluentWait(String webElement) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(webElement));
			}
		});

		return element;
	   }

	
	
}
