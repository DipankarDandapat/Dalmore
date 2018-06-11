package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.CommonLib;
import genericLib.Driver;
import genericLib.Wait;
import pageObjectRepoLib.Calendar;


public class SystemCoursePage extends Driver {
	
	Calendar cal;
	
	@FindBy(xpath="//*[@class='profile']/div[2]/h2")
	public WebElement profileName;
	
	@FindBy(xpath="//*[contains(text(),' Master Data')]")
	public WebElement masterData;
	
	@FindBy(xpath="//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[4]")
	public WebElement courses;
	
	@FindBy(xpath="//*[contains(text(),'Add New')]")
	public WebElement addNewButton;
	
	@FindBy(xpath="//*[contains(text(),'Save')]")
	public WebElement saveButton;
	
	@FindBy(xpath="//*[@class='x_panel']//*[text()='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(xpath="//*[contains(text(),'Update')]")
	public WebElement UpdateButton;
	
	
	
	@FindBy(id="zsyoffering-name")
	public WebElement courseName;
	
	@FindBy(id="zsyoffering-institutionid")
	public WebElement institutionName;
	
	@FindBy(id="zsyoffering-level")
	public WebElement courseLevel;
	
	@FindBy(id="zsyoffering-certifyingboard")
	public WebElement certifyingBoard;
	
	@FindBy(id="zsyoffering-offeringtype")
	public WebElement offeringType;
	
	@FindBy(id="zsyoffering-startdate")
	public WebElement startDate;
	
	@FindBy(id="zsyoffering-enddate")
	public WebElement endDate;
	
	@FindBy(id="zsyoffering-description")
	public WebElement Description;
	
	/////////////////////////////////////////////////////
	@FindBy(xpath="//table[@id='w0']/tbody/tr[1]/td")
	public WebElement viewCourseName;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[2]/td")
	public WebElement viewInstitutionName;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[3]/td")
	public WebElement viewLevel;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[4]/td")
	public WebElement viewCertifyingBoard;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[5]/td")
	public WebElement viewOfferingType;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[6]/td")
	public WebElement viewStartDate;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[7]/td")
	public WebElement viewEndDate;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[8]/td")
	public WebElement viewStatus;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[9]/td")
	public WebElement viewDescription;
	/////////////////////////////////////////////////////////
	//index Table first  row
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[2]")
	public WebElement indexViewCourseName;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[3]")
	public WebElement indexViewInstitution;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[4]")
	public WebElement indexViewOfferingType;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]")
	public WebElement indexViewLevel;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]")
	public WebElement indexViewCertifyingBoard;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[7]")
	public WebElement indexViewStatus;
	
	////////////////////////////////////////////////////////////////////////////
	//index all button 
		@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[8]/a[1]")
		public WebElement indexviewButton;
		@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[8]/a[2]")
		public WebElement indexUpdateButton;
		@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[8]/a[3]")
		public WebElement indexDeactiveButton;
		
		//deActive ok button
		@FindBy(xpath="//button[contains(text(),'Ok')]")
		public WebElement deactiveOkButton;
	
	
	
	
	
	
	
	
	public void createCourse(String coursename,String selectinstitution,String selectCourselevel,String selectCertifyingboard,String selectOfferingType,String description) {
	
		courseName.clear();
		courseName.sendKeys(coursename);
		
		CommonLib.selectbyVisibleText(institutionName, selectinstitution);
		
		CommonLib.selectbyVisibleText(courseLevel, selectCourselevel);
		
		CommonLib.selectbyVisibleText(certifyingBoard, selectCertifyingboard);
		
		CommonLib.selectbyVisibleText(offeringType, selectOfferingType);
		
		Description.sendKeys(description);
		
		
		
	}
	
	
	
	public void updateCourse(String coursename,String selectCourselevel,String selectCertifyingboard,String selectOfferingType,String description) {
		
		courseName.clear();
		courseName.sendKeys(coursename);
		CommonLib.selectbyVisibleText(courseLevel, selectCourselevel);
		CommonLib.selectbyVisibleText(certifyingBoard, selectCertifyingboard);
		CommonLib.selectbyVisibleText(offeringType, selectOfferingType);
		
		Description.clear();
		Description.sendKeys(description);
		
		
	}
	
	
	public void updatedate(String Startdate,String Enddate) throws InterruptedException {
		
		cal=PageFactory.initElements(driver, Calendar.class);
	    Wait.waitForPageToLoad();
	 
	    startDate.click();
		Wait.waitForPageToLoad();
		cal.getDate(Startdate);
		
		endDate.click();
		Wait.waitForPageToLoad();
		cal.getDate(Enddate);
		
	}
	
	
	
	
	

}
