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
import pageObjectRepoLib.Calendar;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;

public class SystemAdminInstitutionPageScripts  extends ExtentReports_3{
	
	
	
	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	InstitutionPage institutionPage;
	Calendar cal;
	
	@BeforeClass
	public void configBeforClass(){
		parentlogger= extentReport.createTest("Zsync System Admin Institution Page Verify");
		Driver.getBrowser();
		loginPage = PageFactory.initElements(driver, Login.class);
		institutionPage =PageFactory.initElements(driver, InstitutionPage.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();
		cal=PageFactory.initElements(driver, Calendar.class);
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
    String profileName=institutionPage.profileName.getText();
 
    
    Assert.assertTrue(profileName.equalsIgnoreCase(ufname+" "+ulname));
    
    childlogger.log(Status.INFO, "Verify Homepage User Name As==>"+ufname+" "+ulname);
	
	Wait.waitForPageToLoad();
    institutionPage.masterData.click();
    Wait.getWhenVisible("//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[2]");
    
    childlogger.log(Status.INFO, "Navigation Bar Master Data Click");
    
    institutionPage.Institution.click();
    
    childlogger.log(Status.INFO, "Navigation Bar Institution Click");
    Wait.waitForPageToLoad();
    
	}
	
	
	
	

	@Test(priority=2)	
	public void SystemAdmin_institution_tc_1() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		
		childlogger=parentlogger.createNode("Create New Institution and Verify Institution Details");
		childlogger.assignCategory("Functional Testing");
		String insTenant=eLib.getExcelData("Sheet1", 2, 2);

		String insName=eLib.getExcelData("Sheet1", 10, 2);
		String insDescription=eLib.getExcelData("Sheet1", 10, 3);
		
		String insStartdate=eLib.getExcelData("Sheet1", 4, 5);
		String insEnddate=eLib.getExcelData("Sheet1", 4, 6);
		
		String insCurrency=eLib.getExcelData("Sheet1", 10, 4);
		String insUrl=eLib.getExcelData("Sheet1", 10, 5);
	
		String insStatus=eLib.getExcelData("Sheet1", 10, 6);
		
		
	    
	    institutionPage.addNewButton.click();
	    childlogger.log(Status.INFO, "Create Institution Add New Button Click");
	    Wait.waitForPageToLoad();

	    institutionPage.createSystemInstitution(insName, insDescription,insStartdate,insEnddate, insCurrency, insUrl);
	    childlogger.log(Status.INFO, "All fields set value");
	    
	    String startdate=institutionPage.institutionStartDate.getAttribute("value");
	    String enddate=institutionPage.institutionEndDate.getAttribute("value");
	    
	    
	    institutionPage.saveButton.click();
	    childlogger.log(Status.INFO, "Click on Save button");
	    childlogger.log(Status.INFO, "Institution Created");
	    
	    
	    Assert.assertEquals(insName,institutionPage.viewInsName.getText());
	    childlogger.log(Status.INFO, "Verify Institution Name value");
	    
	    Assert.assertEquals(insTenant,institutionPage.viewTenantName.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Name value");
	    
	    Assert.assertEquals(insCurrency,institutionPage.viewCurrency.getText());
	    childlogger.log(Status.INFO, "Verify Institution Currency value");
	    
	    Assert.assertEquals(startdate,institutionPage.viewStartDate.getText());
	    childlogger.log(Status.INFO, "Verify Institution StartDate value");
	    Assert.assertEquals(enddate,institutionPage.viewEndDate.getText());
	    childlogger.log(Status.INFO, "Verify Institution EndtDate value");
	    Assert.assertEquals(insDescription,institutionPage.viewDescription.getText());
	    childlogger.log(Status.INFO, "Verify Institution Description value");
	    Assert.assertEquals(insUrl,institutionPage.viewURL.getText());
	    childlogger.log(Status.INFO, "Verify Institution URL value");
	    
	    
	    institutionPage.cancelButton.click();
	    childlogger.log(Status.INFO, "Click on Cance button");
	    
	    Wait.waitForPageToLoad();
	    Assert.assertEquals(insName,institutionPage.indexViewInsName.getText());
	    childlogger.log(Status.INFO, "Verify Institution index page Institution Name value");
	    
	   // Assert.assertEquals(insTenant,institutionPage.indexViewTenantName.getText());
	   // childlogger.log(Status.INFO, "Verify Institution index page Tenant Name value");
	    
	    Assert.assertEquals(insCurrency,institutionPage.systemindexViewCurrencyName.getText());
	    childlogger.log(Status.INFO, "Verify Institution index page Currency value");
	    Assert.assertEquals(insStatus,institutionPage.systemindexViewStatus.getText());
	    childlogger.log(Status.INFO, "Verify Institution index page Institution Status value");
	    
	    
	    
	    institutionPage.systemindexviewButton.click();
	    childlogger.log(Status.INFO, "Click on Index View Button");
		Wait.waitForPageToLoad();
		
		Assert.assertEquals(insName,institutionPage.viewInsName.getText());
		childlogger.log(Status.INFO, "Verify view Institution Institution Name value");
	    Assert.assertEquals(insTenant,institutionPage.viewTenantName.getText());
	    childlogger.log(Status.INFO, "Verify view Institution Tenant Name value");
	    Assert.assertEquals(insCurrency,institutionPage.viewCurrency.getText());
	    childlogger.log(Status.INFO, "Verify view Institution Currency value");
	    Assert.assertEquals(startdate,institutionPage.viewStartDate.getText());
	    childlogger.log(Status.INFO, "Verify view Institution StartDate value");
	    Assert.assertEquals(enddate,institutionPage.viewEndDate.getText());
	    childlogger.log(Status.INFO, "Verify view Institution EndDate value");
	    Assert.assertEquals(insDescription,institutionPage.viewDescription.getText());
	    childlogger.log(Status.INFO, "Verify view Institution Description value");
	    Assert.assertEquals(insUrl,institutionPage.viewURL.getText());
	    childlogger.log(Status.INFO, "Verify view Institution URL value");
	
	    institutionPage.cancelButton.click();
	    childlogger.log(Status.INFO, "Click on Cancel Button");
	    
	    
	}
	
	
	 @Test(priority=3)	
		public void SystemAdmin_institution_tc_2 () throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException {
		   
		   childlogger=parentlogger.createNode("Updated Institution Value and Verify Institution Details");
		   childlogger.assignCategory("Functional Testing");
		    String insTenant=eLib.getExcelData("Sheet1", 2, 2);
		   
			String insName=eLib.getExcelData("Sheet1", 11,2);
			String insDescription=eLib.getExcelData("Sheet1", 11, 3);
			String insStartdate=eLib.getExcelData("Sheet1", 4, 5);
			String insEnddate=eLib.getExcelData("Sheet1", 4, 6);
			
			String insCurrency=eLib.getExcelData("Sheet1", 11, 4);
			String insUrl=eLib.getExcelData("Sheet1", 11, 5);
			
			String insStatus=eLib.getExcelData("Sheet1", 11, 6);
			
			
			
	    	
	    	institutionPage.systemindexUpdateButton.click();
	    	childlogger.log(Status.INFO, "Click on Index Page Update Button");
	    	Wait.waitForPageToLoad();
	    	
	    	institutionPage.updateInstitution(insName,insDescription, insStartdate, insEnddate, insCurrency, insUrl);
	    	childlogger.log(Status.INFO, "Updated New Institution Value");
	    	
	    	
	    	String startdate=institutionPage.institutionStartDate.getAttribute("value");
		    String enddate=institutionPage.institutionEndDate.getAttribute("value");
		 
	    	institutionPage.UpdateButton.click();
	    	childlogger.log(Status.INFO, "Click Update Button");
	    	
	    	
	    	Assert.assertEquals(insName,institutionPage.viewInsName.getText());
	    	childlogger.log(Status.INFO, "Verify Update Institution Name value");
	    	
	    	Assert.assertEquals(insTenant,institutionPage.viewTenantName.getText());
	    	childlogger.log(Status.INFO, "Verify Update Tenant Name value");
		    Assert.assertEquals(insCurrency,institutionPage.viewCurrency.getText());
		    childlogger.log(Status.INFO, "Verify Update Currency value");
		    Assert.assertEquals(startdate,institutionPage.viewStartDate.getText());
		    childlogger.log(Status.INFO, "Verify Update StartDate value");
		    Assert.assertEquals(enddate,institutionPage.viewEndDate.getText());
		    childlogger.log(Status.INFO, "Verify Update EndtDate value");
		    Assert.assertEquals(insStatus,institutionPage.viewStatus.getText());
		    childlogger.log(Status.INFO, "Verify Update Institution Status value");
		    Assert.assertEquals(insDescription,institutionPage.viewDescription.getText());
		    childlogger.log(Status.INFO, "Verify Update Institution Description value");
		    Assert.assertEquals(insUrl,institutionPage.viewURL.getText());
		    childlogger.log(Status.INFO, "Verify Update Institution URL value");
		
	    	Wait.waitForPageToLoad();
	    	
	    	institutionPage.cancelButton.click();
	    	childlogger.log(Status.INFO, "Click Cancel Button");
	    	
	    	Wait.waitForPageToLoad();
		    Assert.assertEquals(insName,institutionPage.indexViewInsName.getText());
		    childlogger.log(Status.INFO, "Verify Update Institution index page Institution Name value");
		    
		    Assert.assertEquals(insCurrency,institutionPage.systemindexViewCurrencyName.getText());
		    childlogger.log(Status.INFO, "Verify Update Institution index page Currency value");
		    Assert.assertEquals(insStatus,institutionPage.systemindexViewStatus.getText());
		    childlogger.log(Status.INFO, "Verify Update Institution index page Institution Status value");
	    	
		    
		    institutionPage.systemindexviewButton.click();
		    childlogger.log(Status.INFO, "Click Index View Button");
			Wait.waitForPageToLoad();
			
			Assert.assertEquals(insName,institutionPage.viewInsName.getText());
			childlogger.log(Status.INFO, "Verify Update Institution Name value");
		    Assert.assertEquals(insTenant,institutionPage.viewTenantName.getText());
		    childlogger.log(Status.INFO, "Verify Update Tenant Name value");
		    Assert.assertEquals(insCurrency,institutionPage.viewCurrency.getText());
		    childlogger.log(Status.INFO, "Verify Update Currency value");
		    Assert.assertEquals(startdate,institutionPage.viewStartDate.getText());
		    childlogger.log(Status.INFO, "Verify Update StartDate value");
		    Assert.assertEquals(enddate,institutionPage.viewEndDate.getText());
		    childlogger.log(Status.INFO, "Verify Update EndtDate value");
		    Assert.assertEquals(insStatus,institutionPage.viewStatus.getText());
		    childlogger.log(Status.INFO, "Verify Update Institution Status value");
		    Assert.assertEquals(insDescription,institutionPage.viewDescription.getText());
		    childlogger.log(Status.INFO, "Verify Update Institution Description value");
		    Assert.assertEquals(insUrl,institutionPage.viewURL.getText());
		    childlogger.log(Status.INFO, "Verify Update Institution URL value");
		
		    institutionPage.cancelButton.click();
		    childlogger.log(Status.INFO, "Click Cancel Button");
	    	
	  
	    }
	
	
	 
	 @Test (priority=4)
	   public void SystemAdmin_institution_tc_3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		   
		   childlogger=parentlogger.createNode("Deactive Institution and Verify Institution Details");
		    childlogger.assignCategory("Functional Testing");
		   
		    String insActiveStatus=eLib.getExcelData("Sheet1", 11, 6);
		    String insStartdate=eLib.getExcelData("Sheet1", 4, 5);
			String insEnddate=eLib.getExcelData("Sheet1", 4, 6);
		    String DeactivetenantStatus=eLib.getExcelData("Sheet1", 11, 7);
		   
		   
		   institutionPage.systemindexDeactiveButton.click(); 
		   
		   childlogger.log(Status.INFO, "Click Deactive Buttonn");
		   
		   Wait.getWhenVisible("//button[contains(text(),'Ok')]");
		   
		   institutionPage.deactiveOkButton.click();
		   
		   childlogger.log(Status.INFO, "Click Deactive OK  Buttonn");
		  
		   
		   Wait.getWhenVisible("//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]");
		   
		   Assert.assertEquals(DeactivetenantStatus,institutionPage.systemindexViewStatus.getText());
		   childlogger.log(Status.INFO, "Verify Index page  Institution Status value");
		   
		   institutionPage.systemindexviewButton.click();
		   childlogger.log(Status.INFO, "Click Index View  Buttonn");
		  
		   
		   Assert.assertEquals(DeactivetenantStatus,institutionPage.viewStatus.getText());
		   childlogger.log(Status.INFO, "Verify View page  Institution Status value");
		   
		   institutionPage.cancelButton.click();
		   childlogger.log(Status.INFO, "Click Cancel  Buttonn");
		   
		   Wait.waitForPageToLoad();
		   
		   institutionPage.systemindexUpdateButton.click();
		   childlogger.log(Status.INFO, "Click Index Update Button  Buttonn");
		   
		   institutionPage.dateUpdate(insStartdate, insEnddate);
		   childlogger.log(Status.INFO, "Update Start date and End Date");
		   
		   institutionPage.UpdateButton.click();
		   childlogger.log(Status.INFO, "Click on Update Button");
		   
		   Thread.sleep(4000);
		   Wait.waitForPageToLoad();
		   institutionPage.cancelButton.click();
		   childlogger.log(Status.INFO, "Click on Cancel Button");
		   
		   Wait.waitForPageToLoad();
		   Assert.assertEquals(insActiveStatus,institutionPage.systemindexViewStatus.getText());
		   childlogger.log(Status.INFO, "Verify Index Page  Institution Status value");
		   
		   institutionPage.systemindexviewButton.click();
		   childlogger.log(Status.INFO, "Click on Index View Button");
		   
		   Assert.assertEquals(insActiveStatus,institutionPage.viewStatus.getText());
		   childlogger.log(Status.INFO, "Verify View Page  Institution Status value");
		   
		   institutionPage.cancelButton.click();
		   childlogger.log(Status.INFO, "Click on Cancel Button");
		   
		   

		   
	   }
	   
	   
	
	  @AfterClass
	  	public void closePage()
	  	{
	  		driver.close();
	  		Log.info("Browser Closed");
	  	}
	  	
	
	
	
	

}
