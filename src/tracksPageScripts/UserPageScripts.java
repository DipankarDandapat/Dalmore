package tracksPageScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import genericLib.Constants;
import genericLib.Driver;
import genericLib.ExcelLib;
import genericLib.ExtentReports_3;
import genericLib.Log;
import genericLib.TakeScreenshort;
import genericLib.Wait;
import pageLocators.UserPage;
import pageObjectRepoLib.Calendar;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;

public class UserPageScripts extends ExtentReports_3 {
	

	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	UserPage userPage;
	Calendar cal;
	
	@BeforeClass
	public void userPage(){
	
		parentlogger= extentReport.createTest("Zsync User Page Verify");
		Driver.getBrowser();

		loginPage = PageFactory.initElements(driver, Login.class);
		userPage =PageFactory.initElements(driver, UserPage.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();
		cal=PageFactory.initElements(driver, Calendar.class);
	}
	
	
	
	
	@Test (priority=1)	
	public void tc_login() throws EncryptedDocumentException, InvalidFormatException, IOException {
		
	childlogger=parentlogger.createNode("Platform Admin User Login");
	
	loginPage.login_PlatformAdmin(Constants.url,Constants.CorrectUsername,Constants.CorrectPassword );
	Wait.waitForPageToLoad();
	childlogger.log(Status.INFO, "Platform Admin login successful");
	
	Wait.getWhenVisible("//*[@class='profile']/div[2]/h2");
    String profileName=userPage.profileName.getText();
 
    Assert.assertEquals(profileName,"Admin");
    childlogger.log(Status.INFO, "Verify Homepage User Name As==> Admin");
	
	
	userPage.masterData.click();
    Wait.getWhenVisible("//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[3]");
    childlogger.log(Status.INFO, "Navigation Bar Master Data Click");
    
    userPage.User.click();
    childlogger.log(Status.INFO, "Navigation Bar user Click");
    Wait.waitForPageToLoad();
	
	}
	//create user and verify user
	@Test (priority=2)	
    public void PlatformAdmin_users_tc_1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		childlogger=parentlogger.createNode("Create New User and Verify User Details");
		childlogger.assignCategory("Functional Testing");
		String selectTenant=eLib.getExcelData("Sheet1", 2, 2);
		String selectInstitution=eLib.getExcelData("Sheet1", 4, 3);
		
		String firstName=eLib.getExcelData("Sheet1", 5, 2);
		String lastName=eLib.getExcelData("Sheet1", 5, 3);
		
		String email=eLib.getExcelData("Sheet1", 5, 4);
		
		String mobileNumber=eLib.getExcelData("Sheet1", 5, 5);
		String profession=eLib.getExcelData("Sheet1", 5, 6);
		String address=eLib.getExcelData("Sheet1", 5, 7);
		String city=eLib.getExcelData("Sheet1", 5, 8);
		String province=eLib.getExcelData("Sheet1", 5, 9);
		String country=eLib.getExcelData("Sheet1", 5, 10);
		String zipcode=eLib.getExcelData("Sheet1", 5, 11);
		String timezoneValue=eLib.getExcelData("Sheet1", 5, 12);
		String photopath=eLib.getExcelData("Sheet1", 5, 13);
		String url=eLib.getExcelData("Sheet1", 5, 14);
		
		
		String status=eLib.getExcelData("Sheet1", 5, 15);
		String SubscriptionType=eLib.getExcelData("Sheet1", 5, 16);
		String Amount=eLib.getExcelData("Sheet1", 5, 16);
		String AutorenewalIndicator=eLib.getExcelData("Sheet1", 5, 16);
		String AutorenewalDate=eLib.getExcelData("Sheet1", 5, 16);
		

	    userPage.addNewButton.click();

	    childlogger.log(Status.INFO,"Create User Add New Button Click");
	    Wait.waitForPageToLoad();
	    
	    userPage.createUser(selectTenant, selectInstitution, firstName, lastName, email, mobileNumber, profession, address, city, province, country, zipcode, timezoneValue, photopath, url);
	    childlogger.log(Status.INFO, "All fields set value");
	    String Startdate=userPage.userStartdate.getAttribute("value");
	   
	    String Enddate=userPage.userEnddate.getAttribute("value");
	   
	    
	    userPage.saveButton.click();
	    childlogger.log(Status.INFO, "Click on Save button");
	    childlogger.log(Status.INFO, "User Created");
	    
	    Wait.waitForPageToLoad();
	    

	   //userPage.viewUser(selectTenant, selectInstitution, Startdate, Enddate, Status, SubscriptionType, Amount, AutorenewalIndicator, AutorenewalDate,email,profession,url);
	    
	    Assert.assertEquals(selectTenant,userPage.viewTenantName.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Name value");
	    
	    Assert.assertEquals(selectInstitution,userPage.viewInstitutionName.getText());
	    childlogger.log(Status.INFO, "Verify Institution Name value");
	    
	    Assert.assertEquals(Startdate,userPage.viewStartDate.getText());
	    childlogger.log(Status.INFO, "Verify StartDate value");
	    
	    Assert.assertEquals(Enddate,userPage.viewEndDate.getText());
	    childlogger.log(Status.INFO, "Verify EndDate value");
	    
	    Assert.assertEquals(status,userPage.viewStatus.getText());
	    childlogger.log(Status.INFO, "Verify Status value");
	    
	    Assert.assertEquals(SubscriptionType,userPage.viewSubscriptionType.getText());
	    childlogger.log(Status.INFO, "Verify Subscription Type value");
	    
	    Assert.assertEquals(Amount,userPage.viewAmount.getText());
	    childlogger.log(Status.INFO, "Verify Amount value");
	    
	    Assert.assertEquals(AutorenewalIndicator,userPage.viewAutorenewalIndicator.getText());
	    childlogger.log(Status.INFO, "Verify Autorenewal Indicator value");
	    
	    Assert.assertEquals(AutorenewalDate,userPage.viewAutorenewalDate.getText());
	    childlogger.log(Status.INFO, "Verify Autorenewal Date value");

	    Assert.assertEquals(email,userPage.viewEmailid.getText());
	    childlogger.log(Status.INFO, "Verify Emailid value");
	    
	    Assert.assertEquals(profession,userPage.viewProfession.getText());
	    childlogger.log(Status.INFO, "Verify Profession value");
	    
	    Assert.assertEquals(url,userPage.viewURL.getText());
	    childlogger.log(Status.INFO, "Verify URL value");
	    
	    
	    
	    
	    userPage.cancelButton.click();
	    childlogger.log(Status.INFO, "Click on Cance button");
	    Wait.waitForPageToLoad();
	    
	    //userPage.indexViewUser(firstName, email, selectTenant, selectInstitution, Status);
	    
	    Assert.assertEquals(firstName,userPage.indexViewUserFirstName.getText());
	    childlogger.log(Status.INFO, "Verify Index Page FirstName value");
	    
	    Assert.assertEquals(email,userPage.indexViewUserEmail.getText());
	    childlogger.log(Status.INFO, "Verify Index Page Emailid value");
	    
	    Assert.assertEquals(selectTenant,userPage.indexViewUserTenant.getText());
	    childlogger.log(Status.INFO, "Verify Index Page Tenant value");
	    
	    Assert.assertEquals(selectInstitution,userPage.indexViewUserInstitution.getText());
	    childlogger.log(Status.INFO, "Verify Index Page Institution value");
	    
	    Assert.assertEquals(status,userPage.indexViewUserStatus.getText());
	    childlogger.log(Status.INFO, "Verify Index Page Status value");
	    

	    userPage.indexviewButton.click();
	    childlogger.log(Status.INFO, "Click on Index View Button");
	    Wait.waitForPageToLoad();
	    
	    
	    //userPage.viewUser(selectTenant, selectInstitution, Startdate, Enddate, Status, SubscriptionType, Amount, AutorenewalIndicator, AutorenewalDate,email,profession,url);
	    Assert.assertEquals(selectTenant,userPage.viewTenantName.getText());
	    childlogger.log(Status.INFO, "Verify View Page Tenant Name value");
	    
	    Assert.assertEquals(selectInstitution,userPage.viewInstitutionName.getText());
	    childlogger.log(Status.INFO, "Verify View Page Institution Name value");
	    
	    Assert.assertEquals(Startdate,userPage.viewStartDate.getText());
	    childlogger.log(Status.INFO, "Verify View Page StartDate value");
	    
	    Assert.assertEquals(Enddate,userPage.viewEndDate.getText());
	    childlogger.log(Status.INFO, "Verify View Page EndDate value");
	    
	    Assert.assertEquals(status,userPage.viewStatus.getText());
	    childlogger.log(Status.INFO, "Verify View Page Status value");
	    
	    Assert.assertEquals(SubscriptionType,userPage.viewSubscriptionType.getText());
	    childlogger.log(Status.INFO, "Verify View Page Subscription Type value");
	    
	    Assert.assertEquals(Amount,userPage.viewAmount.getText());
	    childlogger.log(Status.INFO, "Verify View Page Amount value");
	    
	    Assert.assertEquals(AutorenewalIndicator,userPage.viewAutorenewalIndicator.getText());
	    childlogger.log(Status.INFO, "Verify View Page Autorenewal Indicator value");
	    
	    Assert.assertEquals(AutorenewalDate,userPage.viewAutorenewalDate.getText());
	    childlogger.log(Status.INFO, "Verify View Page Autorenewal Date value");
	    
	    Assert.assertEquals(email,userPage.viewEmailid.getText());
	    childlogger.log(Status.INFO, "Verify View Page Emailid value");
	    
	    Assert.assertEquals(profession,userPage.viewProfession.getText());
	    childlogger.log(Status.INFO, "Verify View Page Profession value");
	    
	    Assert.assertEquals(url,userPage.viewURL.getText());
	    childlogger.log(Status.INFO, "Verify View Page URL value");
	    
	    Wait.waitForPageToLoad();
	    userPage.cancelButton.click();
	    childlogger.log(Status.INFO, "Click on Cancel Button");
	    Wait.waitForPageToLoad();
	
}
	
	//update user
	@Test (priority=3)
	public void PlatformAdmin_users_tc_2() throws EncryptedDocumentException, InvalidFormatException, IOException {
		childlogger=parentlogger.createNode("Updated User Value and Verify User Details");
		childlogger.assignCategory("Functional Testing");
		String selectTenant=eLib.getExcelData("Sheet1", 2, 2);
		String selectInstitution=eLib.getExcelData("Sheet1", 4, 3);
		
		
		
		String email=eLib.getExcelData("Sheet1", 5, 4);
		
		String firstName=eLib.getExcelData("Sheet1", 6, 2);
		String lastName=eLib.getExcelData("Sheet1", 6, 3);
		
		String mobileNumber=eLib.getExcelData("Sheet1", 6, 5);
		String profession=eLib.getExcelData("Sheet1", 6, 6);
		String address=eLib.getExcelData("Sheet1", 6, 7);
		String city=eLib.getExcelData("Sheet1", 6, 8);
		String province=eLib.getExcelData("Sheet1", 6, 9);
		String country=eLib.getExcelData("Sheet1", 6, 10);
		String zipcode=eLib.getExcelData("Sheet1", 6, 11);
		String timezoneValue=eLib.getExcelData("Sheet1", 6, 12);
		String photopath=eLib.getExcelData("Sheet1", 6, 13);
		String url=eLib.getExcelData("Sheet1", 6, 14);
		
		
		String status=eLib.getExcelData("Sheet1", 6, 15);
		String SubscriptionType=eLib.getExcelData("Sheet1", 6, 16);
		String Amount=eLib.getExcelData("Sheet1", 6, 16);
		String AutorenewalIndicator=eLib.getExcelData("Sheet1", 6, 16);
		String AutorenewalDate=eLib.getExcelData("Sheet1", 6, 16);
		
		
		userPage.indexUpdateButton.click();
		childlogger.log(Status.INFO, "Click on Index Page Update Button");
		
		Wait.waitForPageToLoad();
		userPage.updateUser(firstName, lastName, mobileNumber, profession, address, city, province, country, zipcode, timezoneValue, photopath, url);
		childlogger.log(Status.INFO, "Updated New User Value");
		
		String Startdate=userPage.userStartdate.getAttribute("value");
	    
	    String Enddate=userPage.userEnddate.getAttribute("value");
	    
	    
		userPage.UpdateButton.click();
		childlogger.log(Status.INFO, "Click Update Button");
		
		Wait.waitForPageToLoad();
		
	    Assert.assertEquals(selectTenant,userPage.viewTenantName.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant Name value");
	    
	    Assert.assertEquals(selectInstitution,userPage.viewInstitutionName.getText());
	    childlogger.log(Status.INFO, "Verify Update Institution Name value");
	    
	    Assert.assertEquals(Startdate,userPage.viewStartDate.getText());
	    childlogger.log(Status.INFO, "Verify Update Start Date value");
	    
	    Assert.assertEquals(Enddate,userPage.viewEndDate.getText());
	    childlogger.log(Status.INFO, "Verify Update End Date value");
	    
	    Assert.assertEquals(status,userPage.viewStatus.getText());
	    childlogger.log(Status.INFO, "Verify Update Status value");
	    
	    Assert.assertEquals(SubscriptionType,userPage.viewSubscriptionType.getText());
	    childlogger.log(Status.INFO, "Verify Update Subscription Type value");
	    
	    Assert.assertEquals(Amount,userPage.viewAmount.getText());
	    childlogger.log(Status.INFO, "Verify Update Amount value");
	    
	    Assert.assertEquals(AutorenewalIndicator,userPage.viewAutorenewalIndicator.getText());
	    childlogger.log(Status.INFO, "Verify Update Autorenewal Indicator value");
	    
	    Assert.assertEquals(AutorenewalDate,userPage.viewAutorenewalDate.getText());
	    childlogger.log(Status.INFO, "Verify Update Autorenewal Date value");
	    
	    Assert.assertEquals(email,userPage.viewEmailid.getText());
	    childlogger.log(Status.INFO, "Verify Update Emailid value");
	    
	    Assert.assertEquals(profession,userPage.viewProfession.getText());
	    childlogger.log(Status.INFO, "Verify Update Profession value");
	    
	    Assert.assertEquals(url,userPage.viewURL.getText());
	    childlogger.log(Status.INFO, "Verify Update URL value");
	

		Wait.waitForPageToLoad();
		userPage.cancelButton.click();
		childlogger.log(Status.INFO, "Click on Cancel Button");
		
		
	    
		
		Wait.waitForPageToLoad();
	    //userPage.indexViewUser(firstName, email, selectTenant, selectInstitution, Status);
		Assert.assertEquals(firstName,userPage.indexViewUserFirstName.getText());
		childlogger.log(Status.INFO, "Verify Index Page User FirstName Update value");
		
	    Assert.assertEquals(email,userPage.indexViewUserEmail.getText());
	    childlogger.log(Status.INFO, "Verify Index Page User Email Update value");
	    
	    Assert.assertEquals(selectTenant,userPage.indexViewUserTenant.getText());
	    childlogger.log(Status.INFO, "Verify Index Page User Tenant Update value");
	    
	    Assert.assertEquals(selectInstitution,userPage.indexViewUserInstitution.getText());
	    childlogger.log(Status.INFO, "Verify Index Page User Institution Update value");
	    
	    Assert.assertEquals(status,userPage.indexViewUserStatus.getText());
	    childlogger.log(Status.INFO, "Verify Index Page User Status Update value");
	    
	    
		
	    userPage.indexviewButton.click();
	    childlogger.log(Status.INFO, "Click on Index View Button Button");
	    
	    Assert.assertEquals(selectTenant,userPage.viewTenantName.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-Tenant Name value");
	    
	    Assert.assertEquals(selectInstitution,userPage.viewInstitutionName.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-Institution Name value");
	    
	    Assert.assertEquals(Startdate,userPage.viewStartDate.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-StartDate value");
	    
	    Assert.assertEquals(Enddate,userPage.viewEndDate.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-EndDate value");
	    
	    Assert.assertEquals(status,userPage.viewStatus.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-Status value");
	    
	    Assert.assertEquals(SubscriptionType,userPage.viewSubscriptionType.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-SubscriptionType value");
	    
	    Assert.assertEquals(Amount,userPage.viewAmount.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-Amount value");
	    
	    Assert.assertEquals(AutorenewalIndicator,userPage.viewAutorenewalIndicator.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-Autorenewal Indicator value");
	    
	    Assert.assertEquals(AutorenewalDate,userPage.viewAutorenewalDate.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-Autorenewal Date value");
	    
	    Assert.assertEquals(email,userPage.viewEmailid.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-Emailid value");
	    
	    Assert.assertEquals(profession,userPage.viewProfession.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-Profession value");
	    
	    Assert.assertEquals(url,userPage.viewURL.getText());
	    childlogger.log(Status.INFO, "Verify View Page  Update-URL value");
		
	    
	    Wait.waitForPageToLoad();
	    userPage.cancelButton.click();
	    childlogger.log(Status.INFO, "Click on Cancel Button");
		
	}
	
	
	@Test(priority=4)
	public void PlatformAdmin_users_tc_3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		childlogger=parentlogger.createNode("Deactive User and Verify User Details");
		childlogger.assignCategory("Functional Testing");
		String userActiveStatus=eLib.getExcelData("Sheet1", 6, 15);
		
	    String userStartdate=eLib.getExcelData("Sheet1", 4, 5);
		String userEnddate=eLib.getExcelData("Sheet1", 4, 6);
		
	    String userDeactivetenantStatus=eLib.getExcelData("Sheet1", 6, 17);
	    
	  
	    
		userPage.indexDeactiveButton.click();
		
		childlogger.log(Status.INFO, "Click on Index Deactive Button");
		  
		Wait.getWhenVisible("//button[contains(text(),'Ok')]");
		 
		userPage.deactiveOkButton.click();
		childlogger.log(Status.INFO, "Click on  Deactive OK Button");
		
		
		 Wait.getWhenVisible("//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]");
		 
		 Assert.assertEquals(userDeactivetenantStatus,userPage.indexViewUserStatus.getText());
		 
		 childlogger.log(Status.INFO, "Verify Index Page User Status value");
		 
		 
		 userPage.indexviewButton.click();
		 childlogger.log(Status.INFO, "Click on  Index View Button");
		 
		 
		 Assert.assertEquals(userDeactivetenantStatus,userPage.viewStatus.getText());
		 childlogger.log(Status.INFO, "Verify View Page User Status value");
		 
		 
		 userPage.cancelButton.click();
		 childlogger.log(Status.INFO, "Click on  Cancel Button");
		 
		 Wait.waitForPageToLoad();
		 
		 userPage.indexUpdateButton.click();
		 childlogger.log(Status.INFO, "Click on  Index Update Button");
		 
		 
		 Thread.sleep(3000);
		 
		 userPage.dateUpdate(userStartdate, userEnddate);
		 
		 childlogger.log(Status.INFO, "User Startdate and Enddate Update ");
		 
		 
		 userPage.UpdateButton.click();
		 childlogger.log(Status.INFO, "Click on Update Button");
		 
		 childlogger.log(Status.INFO, "Update Successful");
		 
		 Wait.waitForPageToLoad();
		 Thread.sleep(4000);
		 userPage.cancelButton.click();
		 childlogger.log(Status.INFO, "Click on Cancel Button");
		 
		 Assert.assertEquals(userActiveStatus,userPage.indexViewUserStatus.getText()); 
		 childlogger.log(Status.INFO, "Verify Index Page Status value");
		 
		 userPage.indexviewButton.click();
		 childlogger.log(Status.INFO, "Click on Index View Button");
		 
		 Assert.assertEquals(userActiveStatus,userPage.viewStatus.getText());
		 childlogger.log(Status.INFO, "Verify View Page Status value");
		 
		 userPage.cancelButton.click();
		 childlogger.log(Status.INFO, "Click on Cancel Button"); 
		 
		 

		
	}
	
	

	 @AfterClass
		public void closePage()
		{
			driver.close();
			Log.info("Browser Closed");
		}
		
	

}
