package genericLib;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Log {
	
	// Initialize Log4j logs
	 
  public static Logger log = Logger.getLogger(Log.class.getName()); 

   // import genericLib.Log;When you used other class to call:Log.info(""); 
   //PropertyConfigurator.configure("Log4j.properties");    
  //This is to print log message of the test case
    
public static void info(String message) {
 PropertyConfigurator.configure("Log4j.properties");
    	
   log.info(message);

    }
    
    

//This is to print log for the Beginning of the test case,   
public static void startTestCase(String sTestCaseName){
	
	log.info("S--T--A--R--T "+sTestCaseName+ " S--T--A--R--T");


   }

 //This is to print log for the Ending of the test case

public static void endTestCase(String sTestCaseName){
	
	
	 log.info("E---N---D" +sTestCaseName+" E---N---D");

     }



//This is to print Warn message of the test case
public static void warn(String message) {
	

	log.warn(message);

   }

//This is to print Error message of the test case
public static void error(String message) {
	

	log.error(message);

   }

//This is to print Fatal message of the test case
public static void fatal(String message) {

	log.fatal(message);

   }


//This is to print Debug message of the test case
public static void debug(String message) {
	
	log.debug(message);

   }

}
	
	
