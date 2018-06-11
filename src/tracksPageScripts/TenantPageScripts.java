package tracksPageScripts;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


import genericLib.CommonLib;
import genericLib.Constants;
import genericLib.Driver;
import genericLib.ExcelLib;
import genericLib.ExtentReports_3;
import genericLib.Log;
import genericLib.TakeScreenshort;
import genericLib.Wait;
import pageLocators.TenantPage;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;

public class TenantPageScripts extends ExtentReports_3{
	

	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	TenantPage Tenantpage;
	
	@BeforeClass
	public void configBeforClass(){
		
		parentlogger= extentReport.createTest("Zsync TenantPage Verify");
		Driver.getBrowser();
		
		loginPage = PageFactory.initElements(driver, Login.class);
		Tenantpage =PageFactory.initElements(driver, TenantPage.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();
	}
	
	@Test (priority=1)	
	public void PlatformAdminlogin() throws EncryptedDocumentException, InvalidFormatException, IOException {
	childlogger=parentlogger.createNode("Platform Admin Login");
	childlogger.assignCategory("Functional Testing");
	
	
	loginPage.login_PlatformAdmin(Constants.url,Constants.CorrectUsername,Constants.CorrectPassword );
	
	childlogger.log(Status.INFO, "Platform Admin login successful");
	
	

   Wait.getWhenVisible("//*[@class='profile']/div[2]/h2");
   String profileName=Tenantpage.profileName.getText();
 
   Assert.assertEquals(profileName,"Admin");
   childlogger.log(Status.INFO, "Verify Homepage User Name As==> Admin");
	   
	Wait.waitForPageToLoad();
    Tenantpage.masterData.click();
    childlogger.log(Status.INFO, "Navigation Bar Master Data Click");
    Wait.waitForPageToLoad();
    
    Tenantpage.Tenant.click();
    
    childlogger.log(Status.INFO, "Navigation Bar Tenant Click");
    Wait.waitForPageToLoad();
    
	}
	
	@Test(priority=2)	
	public void PlatformAdmin_Tenant_tc_1() throws EncryptedDocumentException, InvalidFormatException, IOException {
		childlogger=parentlogger.createNode("Create New Tenant and Verify Tenant Details");
		childlogger.assignCategory("Functional Testing");
		String tenantName=eLib.getExcelData("Sheet1", 1, 2);
		String tenantType=eLib.getExcelData("Sheet1", 1, 3);
		String tenantStatus=eLib.getExcelData("Sheet1", 1, 4);
		String tenantDescription=eLib.getExcelData("Sheet1", 1, 5);
		String tenantOperatingMarket=eLib.getExcelData("Sheet1", 1, 6);
		
		
	    Tenantpage.addNewButton.click();
	    childlogger.log(Status.INFO, "Create Tenant Add New Button Click");
	    Wait.waitForPageToLoad();
	    //Create tenant
	    Tenantpage.createTenant(tenantName,tenantType , tenantStatus,tenantDescription,tenantOperatingMarket);
	    childlogger.log(Status.INFO, "All fields set value");
	    
	    Tenantpage.saveButton.click();
	    childlogger.log(Status.INFO, "Click on Save button");
	    
	    childlogger.log(Status.INFO, "Tenant Created");
	    
	    Wait.waitForPageToLoad();
	    //Create tenant verify
	    
	    
	    Assert.assertEquals(tenantName,Tenantpage.viewName.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Name value");
	    
	    Assert.assertEquals(tenantDescription,Tenantpage.viewDescription.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Description value");
	    
	    Assert.assertEquals(tenantOperatingMarket,Tenantpage.viewOperatingMarket.getText());
	    childlogger.log(Status.INFO, "Verify Tenant OperatingMarket value");
	    
	    Assert.assertEquals(tenantType,Tenantpage.viewType.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Type value");
	    
	    Assert.assertEquals(tenantStatus,Tenantpage.viewStatus.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Status value");
	    
	    
	   
	    
	    Tenantpage.cancelButton.click();
	    childlogger.log(Status.INFO, "Click on Cance button");
	    
	    Wait.waitForPageToLoad();
	  //Create tenant verify in index page 1st row
	    Assert.assertEquals(tenantName,Tenantpage.indexviewName.getText());
	    childlogger.log(Status.INFO, "Verify Tenant index page Tenant Name value");
	    
	    Assert.assertEquals(tenantOperatingMarket,Tenantpage.indexOperatingMarket.getText());
	    childlogger.log(Status.INFO, "Verify Tenant index page Tenant OperatingMarket value");
	    
	    Assert.assertEquals(tenantType,Tenantpage.indexType.getText());
	    childlogger.log(Status.INFO, "Verify Tenant index page Tenant Type value");
	    
	    Assert.assertEquals(tenantStatus,Tenantpage.indexStatus.getText());
	    childlogger.log(Status.INFO, "Verify Tenant index page Tenant Status value");
	    
	   
	    
	    
		Tenantpage.indexviewButton.click();
		childlogger.log(Status.INFO, "Click on Index View Button");
		Wait.waitForPageToLoad();
		//Create tenant verify in view page
		Assert.assertEquals(tenantName,Tenantpage.viewName.getText());
		childlogger.log(Status.INFO, "Verify Tenant Name value");
	    
	    Assert.assertEquals(tenantDescription,Tenantpage.viewDescription.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Description value");
	    
	    Assert.assertEquals(tenantOperatingMarket,Tenantpage.viewOperatingMarket.getText());
	    childlogger.log(Status.INFO, "Verify Tenant OperatingMarket value");
	    
	    Assert.assertEquals(tenantType,Tenantpage.viewType.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Type value");
	    
	    Assert.assertEquals(tenantStatus,Tenantpage.viewStatus.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Status value");
	    
	    
	    Tenantpage.cancelButton.click();
	    childlogger.log(Status.INFO, "Click Cancel Button");
	    
	}
	

	
@Test (priority=3)	
 public void PlatformAdmin_Tenant_tc_2() throws EncryptedDocumentException, InvalidFormatException, IOException {
	childlogger.assignCategory("Functional Testing");
	String updatetenantName=eLib.getExcelData("Sheet1", 2, 2);
	String updatetenantType=eLib.getExcelData("Sheet1", 2, 3);
	String updatetenantStatus=eLib.getExcelData("Sheet1", 2, 4);
	String updatetenantDescription=eLib.getExcelData("Sheet1", 2, 5);
	String updatetenantOperatingMarket=eLib.getExcelData("Sheet1", 2, 6);
	
	childlogger=parentlogger.createNode("Updated Tenant Value and Verify Tenant Details");
	
	Tenantpage.indexUpdateButton.click();
	childlogger.log(Status.INFO, "Click on Index Page Update Button");
	Wait.waitForPageToLoad();
	//update Tenant
	Tenantpage.updateTenant(updatetenantName,updatetenantType ,updatetenantStatus ,updatetenantDescription ,updatetenantOperatingMarket );
	childlogger.log(Status.INFO, "Updated New Tenant Value");
	
	
	Tenantpage.UpdateButton.click();
	childlogger.log(Status.INFO, "Click Update Button");
	
	Wait.waitForPageToLoad();
	//update Tenant verify
	    Assert.assertEquals(updatetenantName,Tenantpage.viewName.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant Name value");
	    
	    Assert.assertEquals(updatetenantDescription,Tenantpage.viewDescription.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant Description value");
	    
	    Assert.assertEquals(updatetenantOperatingMarket,Tenantpage.viewOperatingMarket.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant OperatingMarket value");
	    
	    Assert.assertEquals(updatetenantType,Tenantpage.viewType.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant Type value");
	    
	    Assert.assertEquals(updatetenantStatus,Tenantpage.viewStatus.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant Status value");

	
	/*CommonLib.verifyText(Tenantpage.viewName, updatetenantName);
    CommonLib.verifyText(Tenantpage.viewDescription, updatetenantDescription);
    CommonLib.verifyText(Tenantpage.viewOperatingMarket, updatetenantOperatingMarket);
    CommonLib.verifyText(Tenantpage.viewType, updatetenantType);
    CommonLib.verifyText(Tenantpage.viewStatus, updatetenantStatus);*/
    
    Tenantpage.cancelButton.click();
    childlogger.log(Status.INFO, "Click Cancel Button");
    
    Wait.waitForPageToLoad();
  //update Tenant verify in index pahe 1st row
    Assert.assertEquals(updatetenantName,Tenantpage.indexviewName.getText());
    childlogger.log(Status.INFO, "Verify Update Tenant index page Tenant Name value");
    
    Assert.assertEquals(updatetenantOperatingMarket,Tenantpage.indexOperatingMarket.getText());
    childlogger.log(Status.INFO, "Verify Update Tenant index page Tenant OperatingMarket value");
    
    Assert.assertEquals(updatetenantType,Tenantpage.indexType.getText());
    childlogger.log(Status.INFO, "Verify Update Tenant index page Tenant Type value");
    
    Assert.assertEquals(updatetenantStatus,Tenantpage.indexStatus.getText());
    childlogger.log(Status.INFO, "Verify Update Tenant index page Tenant Status value");
    
    
    
    
   
    
   //update Tenant verify in view page
	Tenantpage.indexviewButton.click();
	childlogger.log(Status.INFO, "Click Index View Button");
	Wait.waitForPageToLoad();
	
	   Assert.assertEquals(updatetenantName,Tenantpage.viewName.getText());
	   childlogger.log(Status.INFO, "Verify Update Tenant Name value");
	    
	    Assert.assertEquals(updatetenantDescription,Tenantpage.viewDescription.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant Description value");
	    
	    Assert.assertEquals(updatetenantOperatingMarket,Tenantpage.viewOperatingMarket.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant OperatingMarket value");
	    
	    Assert.assertEquals(updatetenantType,Tenantpage.viewType.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant Type value");
	    
	    Assert.assertEquals(updatetenantStatus,Tenantpage.viewStatus.getText());
	    childlogger.log(Status.INFO, "Verify Update Tenant Status value");
	
	
       Tenantpage.cancelButton.click();
       childlogger.log(Status.INFO, "Click Cancel Button");
 }

//Deactive
@Test (priority=4)
public void PlatformAdmin_Tenant_tc_3() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
	
	childlogger=parentlogger.createNode("Deactive Tenant and Verify Tenant Details");
	childlogger.assignCategory("Functional Testing");
	String tenantStatus=eLib.getExcelData("Sheet1", 2, 4);
	
	String DeactivetenantStatus=eLib.getExcelData("Sheet1", 2, 7);
	
	Tenantpage.indexDeactiveButton.click();
	
	childlogger.log(Status.INFO, "Click index Page Deactive Button Current Create Tenant");
	
	Wait.getWhenVisible("//button[contains(text(),'Ok')]");
	//Deactive tenant
	Tenantpage.deactiveOkButton.click();
	
	childlogger.log(Status.INFO, "Click  Deactive Ok  Button");
	
	Wait.waitForPageToLoad();
	//Deactive tenant verify status in index page
	//CommonLib.verifyText(Tenantpage.indexStatus, DeactivetenantStatus);
	
	Assert.assertEquals(DeactivetenantStatus,Tenantpage.indexStatus.getText());
	childlogger.log(Status.INFO, "Verify Deactive Tenant Status value");
	
	
	Tenantpage.indexviewButton.click();
	childlogger.log(Status.INFO, "Click index page view Button");
	
	
	 Wait.waitForPageToLoad();
	//Deactive tenant verify status in view page
	//CommonLib.verifyText(Tenantpage.viewStatus, DeactivetenantStatus);
	Assert.assertEquals(DeactivetenantStatus,Tenantpage.viewStatus.getText());
	childlogger.log(Status.INFO, "Verify Deactive Tenant Status value");
	
	Wait.waitForPageToLoad();
    Tenantpage.cancelButton.click();
    childlogger.log(Status.INFO, "Click Cancel Button");
    
    
    //update tenant
    Tenantpage.indexUpdateButton.click();
    childlogger.log(Status.INFO, "Click Index Page Update Button");
    
	Wait.waitForPageToLoad();
	
	//update tenant status change
	Tenantpage.updateTenantStatus(tenantStatus);
	childlogger.log(Status.INFO, " Update status Inactive to Active");
	
	
	Tenantpage.UpdateButton.click();
	childlogger.log(Status.INFO, " Click On Update Button");
	
	Thread.sleep(3000);
	
	Wait.getWhenVisible("//*[contains(text(),'Cancel')]");
	
	Tenantpage.cancelButton.click();
	
	childlogger.log(Status.INFO, " Click On Cancel Button");
	
	
    Wait.waitForPageToLoad();
	//verify Tenant ststus verify in index page
   // CommonLib.verifyText(Tenantpage.indexStatus, tenantStatus);
    
    Assert.assertEquals(tenantStatus,Tenantpage.indexStatus.getText());
    childlogger.log(Status.INFO, "Verify Active Tenant Status value");
	
    Tenantpage.indexviewButton.click();
    
    childlogger.log(Status.INFO, " Click On Index View Button");
	Wait.waitForPageToLoad();
	//view page ststus verify
    //CommonLib.verifyText(Tenantpage.viewStatus, tenantStatus);
    Assert.assertEquals(tenantStatus,Tenantpage.viewStatus.getText());
    childlogger.log(Status.INFO, "Verify Active Tenant Status value");
    
    Tenantpage.cancelButton.click();
    
    childlogger.log(Status.INFO, " Click On Cancel Button");
	
	   
	
}

//@Test (priority=5)
public void tc_4() {
	
	    
	
	    Tenantpage.findTenantDetails("Abcd00010"); 
	    System.out.println(Tenantpage.viewName.getText()); 
	    System.out.println(Tenantpage.viewDescription.getText());
	    System.out.println(Tenantpage.viewOperatingMarket.getText());
	    System.out.println(Tenantpage.viewType.getText());
	    System.out.println(Tenantpage.viewStatus.getText());
	    Tenantpage.cancelButton.click();
}

//@Test (priority=6)
public void tc_5() {
	
	
    Tenantpage.SearchbyTenantName("abcdef1313");

    Assert.assertEquals("No results found.",Tenantpage.NoSearchFile.getText());
}



@AfterClass
public void closePage()
{
	driver.close();
	Log.info("Browser Closed");
}
	
	
	
	
}
