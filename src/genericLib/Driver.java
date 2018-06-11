package genericLib;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class Driver extends ExtentReports_3 {	
	


public static WebDriver getBrowser(){
		if (Constants.browser.equals("firefox") || Constants.browser.equals("FIREFOX")) 
		{
			System.setProperty("webdriver.gecko.driver","Resource Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			Dimension d= new Dimension(Constants.DimensionWidth,Constants.DimensionHeight);
			driver.manage().window().setSize(d);
			
		} else if (Constants.browser.equals("chrome") || Constants.browser.equals("CHROME")) 
		{
			System.setProperty("webdriver.chrome.driver", "Resource Driver\\chromedriver.exe");
	                
			driver = new ChromeDriver();
			Dimension d= new Dimension(Constants.DimensionWidth,Constants.DimensionHeight);
			driver.manage().window().setSize(d);
			
			
		} else if (Constants.browser.equals("ie") || Constants.browser.equals("IE")) 
		{
		System.setProperty("webdriver.ie.driver", "Resource Driver\\IEDriverServer.exe" );
			driver = new InternetExplorerDriver();
			Dimension d= new Dimension(Constants.DimensionWidth,Constants.DimensionHeight);
			driver.manage().window().setSize(d);
		}
		else if (Constants.browser.equals("safari") ||Constants.browser.equals("SAFARI")) 
		{
			driver = new SafariDriver();
		}
		return null;
		
	}




	


}
