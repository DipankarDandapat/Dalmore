package tracksPageScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import pageLocators.SignUpPage;
import pageLocators.SystemCoursePage;
import pageLocators.UserPage;
import pageObjectRepoLib.Calendar;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;

public class SystemUserSignupPageScripts extends ExtentReports_3{
	
	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	
	Calendar cal;
	UserPage userPage;
	SystemCoursePage coursepage;
	
	SignUpPage signUpPage;
	
	@BeforeClass
	public void configBeforClass(){
		parentlogger= extentReport.createTest("Zsync System Admin SignUp Page Verify");
		Driver.getBrowser();
		loginPage = PageFactory.initElements(driver, Login.class);
		userPage =PageFactory.initElements(driver, UserPage.class);
		
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();
		cal=PageFactory.initElements(driver, Calendar.class);
		coursepage=PageFactory.initElements(driver, SystemCoursePage.class);
		signUpPage=PageFactory.initElements(driver, SignUpPage.class);
		
	}
	
	
	
	@Test (priority=1)	
	public void tc_login() throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	childlogger=parentlogger.createNode("System Admin Login");
	String emailid =eLib.getExcelData("Sheet1", 5, 4);
	//String Password= eLib.getExcelData("Sheet1", 1, 3);
	String ufname= eLib.getExcelData("Sheet1", 6, 2);
	String ulname= eLib.getExcelData("Sheet1", 6, 3);
	
	loginPage.login_SystemAdmin(Constants.url,emailid,"123456789" );
	childlogger.log(Status.INFO, "Syatem Admin login successful");
	
	
    Wait.getWhenVisible("//*[@class='profile']/div[2]/h2");
    String profileName=signUpPage.profileName.getText();
 
    
    Assert.assertTrue(profileName.equalsIgnoreCase(ufname+" "+ulname));
    
    childlogger.log(Status.INFO, "Verify Homepage User Name As==>"+ufname+" "+ulname);
	
	Wait.waitForPageToLoad();
	signUpPage.masterData.click();
	
    Wait.getWhenVisible("//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[1]");
    
    childlogger.log(Status.INFO, "Navigation Bar Master Data Click");
    
    signUpPage.signup.click();
    
    childlogger.log(Status.INFO, "Navigation Bar Signup Click");
    Wait.waitForPageToLoad();
    
	}
	
	
	@Test (priority=2)
	public void systemAdmin_SignUp_tc_1() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		childlogger=parentlogger.createNode("Verify SignUp Index Page Details");
		childlogger.assignCategory("Functional Testing");
		
		String firstname=eLib.getExcelData("Sheet1",8,3);
		String institution=eLib.getExcelData("Sheet1",4,3);
		String email=eLib.getExcelData("Sheet1",8,5);
		String subscriptiontype=eLib.getExcelData("Sheet1",8,2);
		String status=eLib.getExcelData("Sheet1",9,2);
		
		
		 Assert.assertEquals(firstname,signUpPage.indexViewFirstName.getText());
		 childlogger.log(Status.INFO, "Verify Sign up Index Page FirstName Value");
		
		 Assert.assertEquals(institution,signUpPage.indexViewInstitutionName.getText());
		 childlogger.log(Status.INFO, "Verify Sign up Index Page Institution Name Value");
		
		 Assert.assertEquals(email,signUpPage.indexViewEmailId.getText());
		 childlogger.log(Status.INFO, "Verify Sign up Index Page Email id Value");
		 
		 Assert.assertEquals(subscriptiontype,signUpPage.indexViewSubscriptionType.getText());
		 childlogger.log(Status.INFO, "Verify Sign up Index Page Subscription Type Value");
		 
		 Assert.assertEquals(status,signUpPage.indexViewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Sign up Index Page Status Value");
		
	
		
	}
	
	@Test (priority=3)
	public void systemAdmin_SignUp_tc_2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, AWTException {
		
		childlogger=parentlogger.createNode("Verify SignUp View Page Details");
		childlogger.assignCategory("Functional Testing");
		
		String firstname=eLib.getExcelData("Sheet1",8,3);
		String lastname=eLib.getExcelData("Sheet1",8,4);
		String email=eLib.getExcelData("Sheet1",8,5);
		
		String address=eLib.getExcelData("Sheet1",8,7);
		String city=eLib.getExcelData("Sheet1",8,8);
		String province=eLib.getExcelData("Sheet1",8,9);
		String country=eLib.getExcelData("Sheet1",8,10);
		String zipcode=eLib.getExcelData("Sheet1",8,11);
		String description=eLib.getExcelData("Sheet1",8,13);
		
		String institution=eLib.getExcelData("Sheet1",4,3);
		
		String subscriptiontype=eLib.getExcelData("Sheet1",8,2);
		String status=eLib.getExcelData("Sheet1",9,2);
		
		
		signUpPage.indexviewButton.click();
		childlogger.log(Status.INFO,"Click View Button");
		
		
		 Assert.assertEquals(firstname,signUpPage.viewFirstName.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page FirstName Value");
		 
		 Assert.assertEquals(lastname,signUpPage.viewLastName.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Last Name Value");
		 
		 Assert.assertEquals(email,signUpPage.viewEmail.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Email id Value");
		 Assert.assertEquals(address,signUpPage.viewAddress.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Address Value");
		 Assert.assertEquals(city,signUpPage.viewCity.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page City Value");
		 Assert.assertEquals(province,signUpPage.viewProvince.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Province Value");
		 Assert.assertEquals(country,signUpPage.viewCountry.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Country Value");
		 Assert.assertEquals(zipcode,signUpPage.viewZipcode.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Zipcode Value");
		 Assert.assertEquals(description,signUpPage.viewDescription.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Description Value");
		 Assert.assertEquals(institution,signUpPage.viewInstitution.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Institution Name Value");
		 Assert.assertEquals(status,signUpPage.viewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Status Value");
		 
		 Assert.assertEquals(subscriptiontype,signUpPage.viewSubscriptionType.getText());
		 childlogger.log(Status.INFO, "Verify Sign up View Page Subscription Type Value");
		 

		    Robot robot = new Robot();
		    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		    Thread.sleep(3000);
		    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		    
		 signUpPage.cancelButton.click();
		 childlogger.log(Status.INFO,"Click Cancel Button");
		 
		
	}
	
	
	
	@Test (priority=4)
	public void systemAdmin_SignUp_tc_3() throws EncryptedDocumentException, InvalidFormatException, IOException, AWTException, InterruptedException {
		
	String newstatus=eLib.getExcelData("Sheet1",9,3);
		
	
	childlogger=parentlogger.createNode("Update SignUp Status And Verify SignUp Page Details");
	childlogger.assignCategory("Functional Testing");
	
	signUpPage.indexAddUserButton.click();
	childlogger.log(Status.INFO, "Click On Add User Button");
	
	signUpPage.changeStatus(newstatus);
	childlogger.log(Status.INFO, "Change Update Status");
	
	signUpPage.UpdateButton.click();
	childlogger.log(Status.INFO, "Click Update Button");
	
	Wait.waitForPageToLoad();
	
	
	Assert.assertEquals(newstatus,signUpPage.viewStatus.getText());
	childlogger.log(Status.INFO, "Verify Sign up View Page Status Value");
	

    Robot robot = new Robot();
    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
    Thread.sleep(3000);
    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	
	signUpPage.cancelButton.click();
	childlogger.log(Status.INFO,"Click Cancel Button");
	
	Assert.assertEquals(newstatus,signUpPage.indexViewStatus.getText());
	childlogger.log(Status.INFO, "Verify Sign up Index Page Status Value");
		
		
	}
	
	
	
	@AfterClass
	public void closePage()
	{
		driver.close();
		Log.info("Browser Closed");
	}
		
	
	
	

}
