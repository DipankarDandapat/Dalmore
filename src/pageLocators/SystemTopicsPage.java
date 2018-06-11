package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.CommonLib;
import genericLib.Driver;
import pageObjectRepoLib.Time;

public class SystemTopicsPage extends Driver{
	Time time;
	@FindBy(xpath="//*[@class='profile']/div[2]/h2")
	public WebElement profileName;
	
	@FindBy(xpath="//*[contains(text(),' Master Data')]")
	public WebElement masterData;
	
	@FindBy(xpath="//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[5]")
	public WebElement  Topics;
	
	@FindBy(xpath="//*[contains(text(),'Add New')]")
	public WebElement addNewButton;
	
	@FindBy(xpath="//*[contains(text(),'Save')]")
	public WebElement saveButton;
	
	@FindBy(xpath="//*[@class='x_panel']//*[text()='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(xpath="//*[contains(text(),'Update')]")
	public WebElement UpdateButton;
	
	
	@FindBy(id="zsytopic-offeringid")
	public WebElement courseid;
	
	@FindBy(id="zsytopic-name")
	public WebElement topicname;
	
	@FindBy(id="zsytopic-hostid")
	public WebElement hostid;
	
	@FindBy(id="zsytopic-startdate")
	public WebElement startdate;
	
	@FindBy(id="time")
	public WebElement starttime;
	
	@FindBy(id="time1")
	public WebElement endtime;
	
	@FindBy(id="zsytopic-description")
	public WebElement Description;
	
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[1]/td")
	public WebElement viewTopicName;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[2]/td")
	public WebElement viewDescription;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[3]/td")
	public WebElement viewStatus;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[4]/td")
	public WebElement viewOfferingCourse;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[5]/td")
	public WebElement viewUser;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[6]/td")
	public WebElement viewStartDate;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[7]/td")
	public WebElement viewStartTime;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[8]/td")
	public WebElement viewEndTime;
	
	//index Table first  row
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[2]")
	public WebElement indexViewTopicName;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[3]")
	public WebElement indexViewCourseName;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[4]")
	public WebElement indexViewHostName;
		
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]")
	public WebElement indexViewHostStatus;	
	
	
	
	
	
	
	
	public void createTopic(String selectCourse,String topicName,String hostingEducator,String expecthours,String expectmins,String expectendhours,String expecendtmins,String description) throws InterruptedException {
	time=PageFactory.initElements(driver,Time.class);
		
	CommonLib.selectbyVisibleText(courseid, selectCourse);
	topicname.clear();
	topicname.sendKeys(topicName);
	
	CommonLib.selectbyVisibleText(hostid, hostingEducator);
	
	starttime.click();
	time.getStartHours(expecthours, expectmins);
	Thread.sleep(2000);
	endtime.click();
	time.getEndHours(expectendhours, expecendtmins);
	
	Description.click();
	Description.sendKeys(description);
	
	
	
	
	
	
	
	}
	
	
	

}
