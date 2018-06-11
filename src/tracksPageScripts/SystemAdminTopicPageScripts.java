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
import pageLocators.SystemTopicsPage;
import pageLocators.UserPage;
import pageObjectRepoLib.Calendar;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;
import pageObjectRepoLib.Time;

public class SystemAdminTopicPageScripts extends ExtentReports_3 {
	
	
	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	UserPage userPage;
	Calendar cal;
	SystemTopicsPage topicsPage;
	Time time;
	
	
	@BeforeClass
	public void userPage(){
	
		parentlogger= extentReport.createTest("Zsync System Admin Topic Page Verify");
		Driver.getBrowser();

		loginPage = PageFactory.initElements(driver, Login.class);
		userPage =PageFactory.initElements(driver, UserPage.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();
		cal=PageFactory.initElements(driver, Calendar.class);
		topicsPage=PageFactory.initElements(driver, SystemTopicsPage.class);
		time=PageFactory.initElements(driver,Time.class);
		
		
	}
	
	@Test (priority=1)	
	public void tc_login() throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	childlogger=parentlogger.createNode("System Admin Login");
	String emailid =eLib.getExcelData("Sheet1", 5, 4);
	//String Password= eLib.getExcelData("Sheet1", 1, 3);
	String ufname= eLib.getExcelData("Sheet1", 6, 2);
	String ulname= eLib.getExcelData("Sheet1", 6, 3);
	
	loginPage.login_SystemAdmin(Constants.url,emailid,"123456789" );
	childlogger.log(Status.INFO, "Platform Admin login successful");
	
	
    Wait.getWhenVisible("//*[@class='profile']/div[2]/h2");
    String profileName=topicsPage.profileName.getText();
 
    
    Assert.assertTrue(profileName.equalsIgnoreCase(ufname+" "+ulname));
    
    childlogger.log(Status.INFO, "Verify Homepage User Name As==>"+ufname+" "+ulname);
	
	Wait.waitForPageToLoad();
	topicsPage.masterData.click();
    Wait.getWhenVisible("//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[2]");
    
    childlogger.log(Status.INFO, "Navigation Bar Master Data Click");
    
    topicsPage.Topics.click();
    
    childlogger.log(Status.INFO, "Navigation Bar Institution Click");
    Wait.waitForPageToLoad();
    
	}
	
	
	
	@Test (priority=2)	
    public void SystemAdmin_topic_tc_1() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		
		childlogger=parentlogger.createNode("Create New Topic and Verify Topic Details");
		childlogger.assignCategory("Functional Testing");
		
		String selectCourse=eLib.getExcelData("Sheet1", 15, 2);
		String hostingEducator=eLib.getExcelData("Sheet1", 13, 2);
		
		String topicName=eLib.getExcelData("Sheet1", 16, 2);
		
		String expecthours=eLib.getExcelData("Sheet1", 16, 3);
		
		String expectmins=eLib.getExcelData("Sheet1", 16, 4);
		
		String expectendhours=eLib.getExcelData("Sheet1", 16, 5);
		String expecendtmins=eLib.getExcelData("Sheet1", 16, 6);
		
		String description =eLib.getExcelData("Sheet1", 16, 7);
		
		
		
		
		
		
		
		topicsPage.addNewButton.click();
		childlogger.log(Status.INFO,"Create Topic Add New Button Click");
	    Wait.waitForPageToLoad();
	    
		
		topicsPage.createTopic(selectCourse, topicName, hostingEducator, expecthours, expectmins, expectendhours, expecendtmins, description);
		childlogger.log(Status.INFO, "All fields set value");
		String Startdate=topicsPage.startdate.getAttribute("value");
		
		topicsPage.saveButton.click();
		childlogger.log(Status.INFO, "Click on Save button");
	    childlogger.log(Status.INFO, "Topic Created");
	    
	    Assert.assertEquals(topicName,topicsPage.viewTopicName.getText());
	    childlogger.log(Status.INFO, "Verify Topic Name value");
	    
	    Assert.assertEquals(description,topicsPage.viewDescription.getText());
	    childlogger.log(Status.INFO, "Verify Description value");
	    
	    
	    Assert.assertEquals(selectCourse,topicsPage.viewOfferingCourse.getText());
	    childlogger.log(Status.INFO, "Verify Offering Coursevalue");
	    
	    Assert.assertEquals(hostingEducator,topicsPage.viewUser.getText());
	    childlogger.log(Status.INFO, "Verify User Name");
	    
	    Assert.assertEquals(Startdate,topicsPage.viewStartDate.getText());
	    childlogger.log(Status.INFO, "Verify Start date Value");
	    
	    
	    
	    
	    topicsPage.cancelButton.click();
	    childlogger.log(Status.INFO, "Click on Cance button");
	    Wait.waitForPageToLoad();
	    
	    
	    Assert.assertEquals(topicName,topicsPage.indexViewTopicName.getText());
	    childlogger.log(Status.INFO, "Verify Topic Name value");
	    
	    Assert.assertEquals(selectCourse,topicsPage.indexViewCourseName.getText());
	    childlogger.log(Status.INFO, "Verify Offering Course value");
	    
	    Assert.assertEquals(hostingEducator,topicsPage.indexViewHostName.getText());
	    childlogger.log(Status.INFO, "Verify User Name");
	    
		
		
	}
	
	
	
	
	
	


	@AfterClass
	public void closePage()
	{
		driver.close();
		Log.info("Browser Closed");
	}
	
	
	
	
	
	

}
