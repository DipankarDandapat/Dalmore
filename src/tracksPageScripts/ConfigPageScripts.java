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
import pageLocators.ConfigPage;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;

public class ConfigPageScripts extends ExtentReports_3 {
	
	
	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	ConfigPage configpage;
	
	@BeforeClass
	public void configBeforClass(){
		
		parentlogger= extentReport.createTest("Zsync Config Page Verify");
		Driver.getBrowser();
		
		loginPage = PageFactory.initElements(driver, Login.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();
		configpage =PageFactory.initElements(driver, ConfigPage.class);
	}
	
	@Test (priority=1)	
	public void PlatformAdminlogin() throws EncryptedDocumentException, InvalidFormatException, IOException {
	childlogger=parentlogger.createNode("Platform Admin Login");
	childlogger.assignCategory("Functional Testing");
	
	
	loginPage.login_PlatformAdmin(Constants.url,Constants.CorrectUsername,Constants.CorrectPassword );
	
	childlogger.log(Status.INFO, "Platform Admin login successful");
	
	

   Wait.getWhenVisible("//*[@class='profile']/div[2]/h2");
   String profileName=configpage.profileName.getText();
 
   Assert.assertEquals(profileName,"Admin");
   childlogger.log(Status.INFO, "Verify Homepage User Name As==> Admin");
	   
	Wait.waitForPageToLoad();
	configpage.masterData.click();
    childlogger.log(Status.INFO, "Navigation Bar Master Data Click");
    Wait.waitForPageToLoad();
    
    Wait.getWhenVisible("//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[5]");
    configpage.Config.click();
    
    childlogger.log(Status.INFO, "Navigation Bar Config Click");
    Wait.waitForPageToLoad();
    
	}
	
	
	@Test(priority=2)	
	public void PlatformAdmin_Config_tc_1() throws EncryptedDocumentException, InvalidFormatException, IOException {
		childlogger=parentlogger.createNode("Create New Config and Verify Config Details");
		childlogger.assignCategory("Functional Testing");
		
		String selectTenant=eLib.getExcelData("Sheet1", 2, 2);
		String selectParameterid=eLib.getExcelData("Sheet1", 7, 2);
		String configName=eLib.getExcelData("Sheet1", 2, 2);
		String parameterValue=eLib.getExcelData("Sheet1", 7, 3);
		String selectStatus=eLib.getExcelData("Sheet1", 7, 2);
		
		
		
		configpage.addNewButton.click();
	    childlogger.log(Status.INFO, "Create Config Add New Button Click");
	    Wait.waitForPageToLoad();
	    
	    configpage.createConfig(selectTenant,selectParameterid, configName, parameterValue, selectStatus);
	    childlogger.log(Status.INFO, "All fields set value");
	    
	    configpage.saveButton.click();
	    childlogger.log(Status.INFO, "Click on Save button");
	    
	    childlogger.log(Status.INFO, "Config Created");
	    
	    Wait.waitForPageToLoad();
	    //Create tenant verify
	    
	    
	    Assert.assertEquals(configName,configpage.viewConfigName.getText());
	    childlogger.log(Status.INFO, "Verify Config Name");
	    
	    Assert.assertEquals(selectTenant,configpage.viewTenantName.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Name value");
	    
	    Assert.assertEquals(selectParameterid,configpage.viewParameter.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Description value");
	    
	    
	    
	    Assert.assertEquals(parameterValue,configpage.viewParameterValue.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Type value");
	    
	    Assert.assertEquals(selectStatus,configpage.viewStatus.getText());
	    childlogger.log(Status.INFO, "Verify Tenant Status value");
	    
	    
	    configpage.cancelButton.click();
	    childlogger.log(Status.INFO, "Click on Cance button");
	    
	    
	}
	
	
	
	
	
	
	@AfterClass
	public void closePage()
	{
		driver.close();
		Log.info("Browser Closed");
	}
		
	
	
	
	

}
