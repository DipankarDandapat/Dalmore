package genericLib;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;


public class CommonLib extends ExtentReports_3 {
	
	public static boolean verifyText(WebElement wb , String expectText){
		boolean flag = false;
		String actVal = wb.getText();
		if(expectText.equals(actVal)){
			flag = true;
			System.out.println(expectText + ", data is verfied==PASS");
		}else{
			System.out.println(expectText + ", data is not verfied==FAIL");
		}
		return flag;
	   }
	
	
	
	public static  void aceptAlert(){
		Alert alt = Driver.driver.switchTo().alert();
		alt.accept();
	  }
	
	
	public static  void dismissAlert(){
		Alert alt = Driver.driver.switchTo().alert();
		alt.dismiss();
	}
	
	public static void getTextAlert() {
		Alert alt = Driver.driver.switchTo().alert();
		String AlertText= alt.getText();
		System.out.println(AlertText);
		
	  }
	
	
	
	public static void selectbyVisibleText(WebElement element, String dropDownValue){
		Select select = new Select(element);
		Reporter.log("selecting "+dropDownValue+" value in dropdown");
		select.selectByVisibleText(dropDownValue);
	}
	
	public static void selectbyIndex(WebElement element, int dropDownValue){
		Select select = new Select(element);
		Reporter.log("selecting "+dropDownValue+" value in dropdown");
		select.selectByIndex(dropDownValue);
	}
	
	public static void selectbyValue(WebElement element, String dropDownValue){
		Select select = new Select(element);
		Reporter.log("selecting "+dropDownValue+" value in dropdown");
		select.selectByValue(dropDownValue);
	}
	
	
	
	public void moveToSingleElementAndClick(WebElement locator) {
		
		 Actions builder = new Actions(driver);
		 
		 Action mouseOver= builder.moveToElement(locator).click().build();
		 mouseOver.perform();      
		
	}
	
	
	public void moveToDoubleElementAndClick(WebElement firstlocator,WebElement secondlocator) throws InterruptedException {
		
		 Actions builder = new Actions(driver);
		 
		  Action mouseOver = builder.moveToElement(firstlocator).build();
		  mouseOver.perform(); 
		  Thread.sleep(2000);
		  Action mouseOver1=  builder.moveToElement(secondlocator).click().build();
		  mouseOver1.perform(); 
	}
	
	
	public void moveToTripleElementAndClick(WebElement firstlocator,WebElement secondlocator,WebElement thirdlocator) throws InterruptedException {
		
		 Actions builder = new Actions(driver);
		 
		  Action mouseOver = builder.moveToElement(firstlocator).build();
		  mouseOver.perform(); 
		  Thread.sleep(2000);
		  Action mouseOver1=  builder.moveToElement(secondlocator).build();
		  mouseOver1.perform(); 
		  Thread.sleep(2000);
		  Action mouseOver2=  builder.moveToElement(thirdlocator).click().build();
		  mouseOver2.perform(); 
	}
	
	

}
