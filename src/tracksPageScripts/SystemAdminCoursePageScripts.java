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
import pageLocators.InstitutionPage;
import pageLocators.SystemCoursePage;
import pageLocators.UserPage;
import pageObjectRepoLib.Calendar;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;

public class SystemAdminCoursePageScripts extends ExtentReports_3 {
	
	
	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	InstitutionPage institutionPage;
	Calendar cal;
	UserPage userPage;
	SystemCoursePage coursepage;
	
	@BeforeClass
	public void configBeforClass(){
		parentlogger= extentReport.createTest("Zsync System Admin Course Page Verify");
		Driver.getBrowser();
		loginPage = PageFactory.initElements(driver, Login.class);
		userPage =PageFactory.initElements(driver, UserPage.class);
		institutionPage =PageFactory.initElements(driver, InstitutionPage.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();
		cal=PageFactory.initElements(driver, Calendar.class);
		coursepage=PageFactory.initElements(driver, SystemCoursePage.class);
		
	}
	
	
	@Test (priority=1)	
	public void tc_login() throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	childlogger=parentlogger.createNode("System Admin Login");
	String emailid =eLib.getExcelData("Sheet1", 5, 4);
	//String Password= eLib.getExcelData("Sheet1", 1, 3);
	String ufname= eLib.getExcelData("Sheet1", 6, 2);
	String ulname= eLib.getExcelData("Sheet1", 6, 3);
	
	loginPage.login_SystemAdmin(Constants.url,emailid ,"123456789" );
	childlogger.log(Status.INFO, "Platform Admin login successful");
	
	
    Wait.getWhenVisible("//*[@class='profile']/div[2]/h2");
    String profileName=coursepage.profileName.getText();
 
    
    Assert.assertTrue(profileName.equalsIgnoreCase(ufname+" "+ulname));
    
    childlogger.log(Status.INFO, "Verify Homepage User Name As==>"+ufname+" "+ulname);
	
	Wait.waitForPageToLoad();
	coursepage.masterData.click();
    Wait.getWhenVisible("//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[4]");
    
    childlogger.log(Status.INFO, "Navigation Bar Master Data Click");
    
    coursepage.courses.click();
    
    childlogger.log(Status.INFO, "Navigation Bar Courses Click");
    Wait.waitForPageToLoad();
    
	}
	
	
	
	@Test (priority=2)
	public void systemAdmin_Course_tc_1() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		childlogger=parentlogger.createNode("Create New Course and Verify Course Details");
		childlogger.assignCategory("Functional Testing");
		String selectinstitution=eLib.getExcelData("Sheet1",4,3);
		
		String coursename=eLib.getExcelData("Sheet1",14,2);
		String selectCourselevel=eLib.getExcelData("Sheet1",14,3);
		String selectCertifyingboard=eLib.getExcelData("Sheet1",14,4);
		String selectOfferingType=eLib.getExcelData("Sheet1",14,5);
		String description=eLib.getExcelData("Sheet1",14,6);
		
		String status=eLib.getExcelData("Sheet1",14,7);
		
		
		coursepage.addNewButton.click();
		childlogger.log(Status.INFO,"Create Course Add New Button Click");
		Wait.waitForPageToLoad();
		
		coursepage.createCourse(coursename, selectinstitution, selectCourselevel, selectCertifyingboard, selectOfferingType, description);
		
		 String Startdate=coursepage.startDate.getAttribute("value");
		 String Enddate=coursepage.endDate.getAttribute("value");
		 
		 coursepage.saveButton.click();
		 childlogger.log(Status.INFO, "Click on Save button");
		 childlogger.log(Status.INFO, "Course Created");
		 Wait.waitForPageToLoad();
		 
		 
		 Assert.assertEquals(coursename,coursepage.viewCourseName.getText());
		 childlogger.log(Status.INFO, "Verify Course Name value");
		 Assert.assertEquals(selectinstitution,coursepage.viewInstitutionName.getText());
		 childlogger.log(Status.INFO, "Verify Institution Name value");
		 Assert.assertEquals(selectCourselevel,coursepage.viewLevel.getText());
		 childlogger.log(Status.INFO, "Verify Level Name value");
		 
		 Assert.assertEquals(selectCertifyingboard,coursepage.viewCertifyingBoard.getText());
		 childlogger.log(Status.INFO, "Verify CertifyingBoard Name value");
		 
		 Assert.assertEquals(selectOfferingType,coursepage.viewOfferingType.getText());
		 childlogger.log(Status.INFO, "Verify OfferingType Name value");
		 
		 Assert.assertEquals(Startdate,coursepage.viewStartDate.getText());
		 childlogger.log(Status.INFO, "Verify Start date value");
		 
		 Assert.assertEquals(Enddate,coursepage.viewEndDate.getText());
		 childlogger.log(Status.INFO, "Verify Start date value");
		 
		 Assert.assertEquals(status,coursepage.viewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Status value");
		 
		 Assert.assertEquals(description,coursepage.viewDescription.getText());
		 childlogger.log(Status.INFO, "Verify Description value");
		 
		 
		 coursepage.cancelButton.click();
		 childlogger.log(Status.INFO, "Click on Cance button");
		 Wait.waitForPageToLoad();
		 /////////////////////////////////////////////////////////////////////////////////
		 
		 Assert.assertEquals(coursename,coursepage.indexViewCourseName.getText());
		 childlogger.log(Status.INFO, "Verify Index Page Course Name value");
		 
		 Assert.assertEquals(selectinstitution,coursepage.indexViewInstitution.getText());
		 childlogger.log(Status.INFO, "Verify Index Page Institution Name value");
		 
		 Assert.assertEquals(selectOfferingType,coursepage.indexViewOfferingType.getText());
		 childlogger.log(Status.INFO, "Verify Index Page Offering Type value");
		 
		 Assert.assertEquals(selectCourselevel,coursepage.indexViewLevel.getText());
		 childlogger.log(Status.INFO, "Verify Index Page Level value");
		 
		 Assert.assertEquals(selectCertifyingboard,coursepage.indexViewCertifyingBoard.getText());
		 childlogger.log(Status.INFO, "Verify Index Page Certifying Board value");
		 
		 Assert.assertEquals(status,coursepage.indexViewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Index Page Status value");
		 
		////////////////////////////////////////////////////////////////////////////// 
		 coursepage.indexviewButton.click();
		 childlogger.log(Status.INFO, "Click on Index View Button");
		 Wait.waitForPageToLoad();
		////////////////////////////////////////////////////////////////////////////////////
		 
		 Assert.assertEquals(coursename,coursepage.viewCourseName.getText());
		 childlogger.log(Status.INFO, "Verify Course Name value");
		 Assert.assertEquals(selectinstitution,coursepage.viewInstitutionName.getText());
		 childlogger.log(Status.INFO, "Verify Institution Name value");
		 Assert.assertEquals(selectCourselevel,coursepage.viewLevel.getText());
		 childlogger.log(Status.INFO, "Verify Level Name value");
		 
		 Assert.assertEquals(selectCertifyingboard,coursepage.viewCertifyingBoard.getText());
		 childlogger.log(Status.INFO, "Verify CertifyingBoard Name value");
		 
		 Assert.assertEquals(selectOfferingType,coursepage.viewOfferingType.getText());
		 childlogger.log(Status.INFO, "Verify OfferingType Name value");
		 
		 Assert.assertEquals(Startdate,coursepage.viewStartDate.getText());
		 childlogger.log(Status.INFO, "Verify Start date value");
		 
		 Assert.assertEquals(Enddate,coursepage.viewEndDate.getText());
		 childlogger.log(Status.INFO, "Verify Start date value");
		 
		 Assert.assertEquals(status,coursepage.viewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Status value");
		 
		 Assert.assertEquals(description,coursepage.viewDescription.getText());
		 childlogger.log(Status.INFO, "Verify Description value");
		 
		 
		 coursepage.cancelButton.click();
		 childlogger.log(Status.INFO, "Click on Cance button");
		 Wait.waitForPageToLoad();
		 
		 ////////////////////////////////////////////////////////////////////////////////
		 

	}
	
	//update
	@Test (priority=3)
	public void systemAdmin_Course_tc_2() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		childlogger=parentlogger.createNode("Updated Course Value and Verify Course Details");
		childlogger.assignCategory("Functional Testing");
		
		 coursepage.indexUpdateButton.click();
		 childlogger.log(Status.INFO, "Click on Index Update Button");
		 Wait.waitForPageToLoad();
		
		String selectinstitution=eLib.getExcelData("Sheet1",4,3);
		String status=eLib.getExcelData("Sheet1",14,7);
		
		
		String coursename=eLib.getExcelData("Sheet1",15,2);
		String selectCourselevel=eLib.getExcelData("Sheet1",15,3);
		String selectCertifyingboard=eLib.getExcelData("Sheet1",15,4);
		String selectOfferingType=eLib.getExcelData("Sheet1",15,5);
		String description=eLib.getExcelData("Sheet1",15,6); 
		 
		
		coursepage.updateCourse(coursename, selectCourselevel, selectCertifyingboard, selectOfferingType, description);
		childlogger.log(Status.INFO, "Updated New User Value");
		
		 String Startdate=coursepage.startDate.getAttribute("value");
		 String Enddate=coursepage.endDate.getAttribute("value");
		
		coursepage.UpdateButton.click();
		childlogger.log(Status.INFO, "Click Update Button");
		
		Wait.waitForPageToLoad();
		
		
		 Assert.assertEquals(coursename,coursepage.viewCourseName.getText());
		 childlogger.log(Status.INFO, "Verify Update Course Name value");
		 Assert.assertEquals(selectinstitution,coursepage.viewInstitutionName.getText());
		 childlogger.log(Status.INFO, "Verify Institution Name value");
		 Assert.assertEquals(selectCourselevel,coursepage.viewLevel.getText());
		 childlogger.log(Status.INFO, "Verify Update Level Name value");
		 
		 Assert.assertEquals(selectCertifyingboard,coursepage.viewCertifyingBoard.getText());
		 childlogger.log(Status.INFO, "Verify Update CertifyingBoard Name value");
		 
		 Assert.assertEquals(selectOfferingType,coursepage.viewOfferingType.getText());
		 childlogger.log(Status.INFO, "Verify Update OfferingType Name value");
		 
		 Assert.assertEquals(Startdate,coursepage.viewStartDate.getText());
		 childlogger.log(Status.INFO, "Verify Start date value");
		 
		 Assert.assertEquals(Enddate,coursepage.viewEndDate.getText());
		 childlogger.log(Status.INFO, "Verify Start date value");
		 
		 Assert.assertEquals(status,coursepage.viewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Status value");
		 
		 Assert.assertEquals(description,coursepage.viewDescription.getText());
		 childlogger.log(Status.INFO, "Verify Update Description value");
		 
		 Wait.waitForPageToLoad();
		 coursepage.cancelButton.click();
		 childlogger.log(Status.INFO, "Click on Cance button");
		 
		 
		 Assert.assertEquals(coursename,coursepage.indexViewCourseName.getText());
		 childlogger.log(Status.INFO, "Verify Update Index Page Course Name value");
		 
		 Assert.assertEquals(selectinstitution,coursepage.indexViewInstitution.getText());
		 childlogger.log(Status.INFO, "Verify Update Index Page Institution Name value");
		 
		 Assert.assertEquals(selectOfferingType,coursepage.indexViewOfferingType.getText());
		 childlogger.log(Status.INFO, "Verify Update Index Page Offering Type value");
		 
		 Assert.assertEquals(selectCourselevel,coursepage.indexViewLevel.getText());
		 childlogger.log(Status.INFO, "Verify Update Index Page Level value");
		 
		 Assert.assertEquals(selectCertifyingboard,coursepage.indexViewCertifyingBoard.getText());
		 childlogger.log(Status.INFO, "Verify Update Index Page Certifying Board value");
		 
		 Assert.assertEquals(status,coursepage.indexViewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Update Index Page Status value");
		 
		 
		 coursepage.indexviewButton.click();
		 childlogger.log(Status.INFO, "Click on Index View Button");
		 Wait.waitForPageToLoad();
		 
		
		 Assert.assertEquals(coursename,coursepage.viewCourseName.getText());
		 childlogger.log(Status.INFO, "Verify Update Course Name value");
		 Assert.assertEquals(selectinstitution,coursepage.viewInstitutionName.getText());
		 childlogger.log(Status.INFO, "Verify Institution Name value");
		 Assert.assertEquals(selectCourselevel,coursepage.viewLevel.getText());
		 childlogger.log(Status.INFO, "Verify Update Level Name value");
		 
		 Assert.assertEquals(selectCertifyingboard,coursepage.viewCertifyingBoard.getText());
		 childlogger.log(Status.INFO, "Verify Update CertifyingBoard Name value");
		 
		 Assert.assertEquals(selectOfferingType,coursepage.viewOfferingType.getText());
		 childlogger.log(Status.INFO, "Verify Update OfferingType Name value");
		 
		 Assert.assertEquals(Startdate,coursepage.viewStartDate.getText());
		 childlogger.log(Status.INFO, "Verify Start date value");
		 
		 Assert.assertEquals(Enddate,coursepage.viewEndDate.getText());
		 childlogger.log(Status.INFO, "Verify Start date value");
		 
		 Assert.assertEquals(status,coursepage.viewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Status value");
		 
		 Assert.assertEquals(description,coursepage.viewDescription.getText());
		 childlogger.log(Status.INFO, "Verify Update Description value");
		 
		 Wait.waitForPageToLoad();
		 coursepage.cancelButton.click();
		 childlogger.log(Status.INFO, "Click on Cance button");
		

	}
		
	
	@Test (priority=4)
	public void systemAdmin_Course_tc_3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		childlogger=parentlogger.createNode("Deactive Course and Verify Course Details");
		childlogger.assignCategory("Functional Testing");
		
		String coursestatus=eLib.getExcelData("Sheet1",15,7);
		String courseDeactivetenantStatus=eLib.getExcelData("Sheet1",15,8);
		
		
	    String courseStartdate=eLib.getExcelData("Sheet1", 4, 5);
	    String courseEnddate=eLib.getExcelData("Sheet1", 4, 6);
		
		coursepage.indexDeactiveButton.click();
		childlogger.log(Status.INFO, "Click on Index Deactive Button");
		
		Wait.getWhenVisible("//button[contains(text(),'Ok')]");
		
		coursepage.deactiveOkButton.click();
		childlogger.log(Status.INFO, "Click on  Deactive OK Button");
		
		Wait.getWhenVisible("//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[7]");
		
		 Assert.assertEquals(courseDeactivetenantStatus,coursepage.indexViewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Index Page Course Status value");
		
		 coursepage.indexviewButton.click();
		 childlogger.log(Status.INFO, "Click on  Index View Button");
		 
		 Assert.assertEquals(courseDeactivetenantStatus,coursepage.viewStatus.getText());
		 childlogger.log(Status.INFO, "Verify View Page Course Status value");
		 
		 Wait.waitForPageToLoad();
		 coursepage.cancelButton.click();
		 childlogger.log(Status.INFO, "Click on Cance button");
		 
		 
		 coursepage.indexUpdateButton.click();
		 childlogger.log(Status.INFO, "Click on Index Update button");
		 
		 
		 coursepage.updatedate(courseStartdate, courseEnddate);
		 childlogger.log(Status.INFO, "Update Date");
		 
		 coursepage.UpdateButton.click();
		 childlogger.log(Status.INFO, "Click update Button");
		 
		 Assert.assertEquals(coursestatus,coursepage.viewStatus.getText());
		 childlogger.log(Status.INFO, "Verify View Page Course Status value"); 
		 
		 Wait.waitForPageToLoad();
		 coursepage.cancelButton.click();
		 childlogger.log(Status.INFO, "Click on Cance button");
		 
		 Assert.assertEquals(coursestatus,coursepage.indexViewStatus.getText());
		 childlogger.log(Status.INFO, "Verify Index Page Course Status value");
		 
		 
		
		
	}
		
	
	
	

	 @AfterClass
		public void closePage()
		{
			driver.close();
			Log.info("Browser Closed");
		}
		
	
	
	
	
	
	

}
