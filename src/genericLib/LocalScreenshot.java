package genericLib;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;



public class LocalScreenshot extends TestListenerAdapter {

    String Seperator=System.getProperty("file.separator");

    @Override
    public void onTestFailure(ITestResult result) {
        
        
        String sTestClassName=result.getTestClass().getRealClass().getSimpleName();
       
        String sFileName=result.getName();
       
 
        String imagePathInHost="Screenshots"+Seperator+"LatestResults"+Seperator+sTestClassName+Seperator+captureScreenshot(Driver.driver,sTestClassName,sFileName);
        
    
    }

    public String captureScreenshot(WebDriver driver,String sTestClassName,String sFileName)
    {
        sFileName=sFileName+".png";
        try
        {
            File file = new File("Screenshots" + Seperator + "LatestResults");
            if (!file.exists())
            {
                
                file.mkdir();
            }
           
           
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            
            File targetFile = new File("Screenshots" + Seperator + "LatestResults" + Seperator + sTestClassName+timestamp(), sFileName);
            FileUtils.copyFile(sourceFile, targetFile);
            return sFileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
    
    
    public static String timestamp() {

	       return new SimpleDateFormat("dd MMMM yyyy").format(new Date());
	       
	   }
		
	 
}