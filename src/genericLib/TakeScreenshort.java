package genericLib;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshort {

	public static String Seperator=System.getProperty("file.separator");
	   
	
	   static int version = 1;
	   static int flag = 0; 
	  
	   
		
		public static String captureScreenshot(WebDriver driver,String sTestClassName,String sFileName)
	   {
			//sFileName=sFileName+".png";
			File file = new File("Build"+Seperator+"Screenshot");
			 
			
	       try
	       {
	           TakesScreenshot ts=(TakesScreenshot) driver;
	           
	          /* String fileName1 = "Build";
	           String newFilename;
	           File f = new File("F:"+Seperator+"Report"+timestamp()+Seperator+ fileName1);
	           
	           if (f.exists() && f.isDirectory()) {
	        	   newFilename= fileName1 + version;
	        	   f = new File("F:"+Seperator +"Report"+timestamp()+Seperator+ fileName1+version);
	        	   version++;
	        	  
	        	}
	           f.mkdirs(); 
	    	   f.createNewFile();
	    	 */
	    	   
	    	   
	           if (!file.exists())
	           {
	              
	               file.mkdir();
	           }
	           
	           
	           File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	           String destFile= "F:\\Workspace\\zsync\\ExtentReports"+Seperator +"Build"+"-"+timestamp()+ Seperator +"Screenshot"+Seperator+sFileName+".png" ;
	           File destination=new File(destFile);
	          
	           
	           FileUtils.copyFile(sourceFile, destination);
	           
	           return destFile;
	           
	       } catch (Exception e) {
	           e.printStackTrace();
	           return null;
	       }
	       
	       
	   }
		
		
	    
	    
		public static String timestamp() {

	       return new SimpleDateFormat("dd MMMM yyyy").format(new Date());
	       
	   }
		
	 
	   
	   
}
