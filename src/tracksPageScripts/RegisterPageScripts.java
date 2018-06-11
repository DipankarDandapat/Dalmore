package tracksPageScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import genericLib.Constants;
import genericLib.Driver;
import genericLib.ExcelLib;
import genericLib.ExtentReports_3;
import genericLib.Log;
import genericLib.Wait;
import pageLocators.RegisterPage;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;

public class RegisterPageScripts extends ExtentReports_3 {
	
	

	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	RegisterPage registerPage;
	
	
	@BeforeClass
	public void registerPage()
	{
		parentlogger= extentReport.createTest("Zsync Register page Verify");
		Driver.getBrowser();
		
		
		loginPage = PageFactory.initElements(driver, Login.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();
		registerPage=PageFactory.initElements(driver, RegisterPage.class);
	}
	

	@Test (priority=1)
	public void register_tc_1() {
	
	childlogger=parentlogger.createNode("Go to Zsync Register Page ");
	childlogger.assignCategory("Functional Testing");
	
	driver.get("http://zsync.ziksana.com/register");
		
	}
	
	@Test (priority=2)
	public void register_tc_2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	
	childlogger=parentlogger.createNode("Create Signup User with Valid Details");
	childlogger.assignCategory("Functional Testing");
	
	String selectTenant= eLib.getExcelData("Sheet1", 2, 2);
	String selectInstitution= eLib.getExcelData("Sheet1",4, 3);
	String selectSubscriptiontype=eLib.getExcelData("Sheet1", 8,2);
	String firstName=eLib.getExcelData("Sheet1", 8,3);
	String lastName=eLib.getExcelData("Sheet1", 8,4);
	String emailId=eLib.getExcelData("Sheet1", 8,5);
	String mobileNumber=eLib.getExcelData("Sheet1", 8,6);
	String address=eLib.getExcelData("Sheet1", 8,7);
	String city=eLib.getExcelData("Sheet1", 8,8);
	String province=eLib.getExcelData("Sheet1", 8,9);
	String country=eLib.getExcelData("Sheet1", 8,10);
	String zipcode=eLib.getExcelData("Sheet1", 8,11);
	String selectTimezone=eLib.getExcelData("Sheet1", 8,12);
	String description=eLib.getExcelData("Sheet1", 8,13);
	
	
	
	
	registerPage.CreateRegister(selectTenant,selectInstitution, selectSubscriptiontype, firstName, lastName, emailId, mobileNumber, address, city, province, country, zipcode, selectTimezone, description);
	childlogger.log(Status.INFO, "All fields set value");
	
	childlogger.log(Status.INFO, "Click on Sign Up button");
	registerPage.SignUp.click();
    childlogger.log(Status.INFO, "Sign Up user Created ");
	
		
	}
	
	
	@Test (priority=3)
	public void register_tc_3() {
		
		childlogger=parentlogger.createNode("Verify Successful Message");
		childlogger.assignCategory("Functional Testing");
		
		 String message="We have received your registration information. We will send you an email with your access credentials shortly.";
		
		 Assert.assertEquals(message,registerPage.Message.getText());
		 childlogger.log(Status.INFO, "Verify Message");
		
		
		
	}
	
	@AfterClass
	public void closePage()
	{
		driver.close();
		Log.info("Browser Closed");
	}
		

}
