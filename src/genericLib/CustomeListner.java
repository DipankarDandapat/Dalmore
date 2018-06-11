package genericLib;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;



public class CustomeListner extends TestListenerAdapter {
	
	
	
	 public void onTestFailure(ITestResult tr){
		  
		   File scrFile = ((TakesScreenshot)Driver.driver).getScreenshotAs(OutputType.FILE);
			
			try {
				FileUtils.copyFile(scrFile, new File("F:\\Workspace\\Zsync\\ScreenShort\\Failures\\"+ tr.getName()+".png"));
			    } 
			catch (IOException e) 
			{
			  System.out.println("ExceptionScreenshot Failure");
			}
			
	         }
	 
	 
	 
	/* public void onTestSuccess(ITestResult tr){
		   
		 File scrFile = ((TakesScreenshot)Driver.driver).getScreenshotAs(OutputType.FILE);
					
		try {
				FileUtils.copyFile(scrFile, new File("F:\\Workspace\\Zsync\\ScreenShort\\Success\\"+ tr.getName()+".png"));
			} 
		catch (IOException e) 
		    {
			 System.out.println("ExceptionScreenshot Success");
			}
			
			}*/
	 
	/* public void onTestSkipped(ITestResult tr){
			
			File scrFile = ((TakesScreenshot)Driver.driver).getScreenshotAs(OutputType.FILE);
					
			try {
				FileUtils.copyFile(scrFile, new File("F:\\Workspace\\Zsync\\ScreenShort\\Skipped\\"+ tr.getName()+".png"));
				} 
			catch (IOException e)
			{
			  System.out.println("ExceptionScreenshot Skipped");	
			}
				
			}
	*/
	
	
	
	

}
