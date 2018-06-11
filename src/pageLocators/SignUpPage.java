package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericLib.CommonLib;

public class SignUpPage {
	
/////////////////////////////////////////////////////
	
	@FindBy(xpath="//*[@class='profile']/div[2]/h2")
	public WebElement profileName;
	
	@FindBy(xpath="//*[contains(text(),' Master Data')]")
	public WebElement masterData;
	
	@FindBy(xpath="//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[1]")
	public WebElement signup;
	
	@FindBy(xpath="//*[contains(text(),'Save')]")
	public WebElement saveButton;
	
	@FindBy(xpath="//*[@class='x_panel']//*[text()='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(xpath="//*[contains(text(),'Update')]")
	public WebElement UpdateButton;
///////////////////////////////////////////////////////
	@FindBy(id="zsyusersignup-signupstatus")
	public WebElement signupStatus;
	
	
//////////////////////////////////////////////	
@FindBy(xpath="//table[@id='w0']/tbody/tr[1]/td")
public WebElement viewFirstName;

@FindBy(xpath="//table[@id='w0']/tbody/tr[2]/td")
public WebElement viewLastName;

@FindBy(xpath="//table[@id='w0']/tbody/tr[3]/td")
public WebElement viewEmail;

@FindBy(xpath="//table[@id='w0']/tbody/tr[4]/td")
public WebElement viewAddress;

@FindBy(xpath="//table[@id='w0']/tbody/tr[5]/td")
public WebElement viewCity;

@FindBy(xpath="//table[@id='w0']/tbody/tr[6]/td")
public WebElement viewProvince;

@FindBy(xpath="//table[@id='w0']/tbody/tr[7]/td")
public WebElement viewCountry;

@FindBy(xpath="//table[@id='w0']/tbody/tr[8]/td")
public WebElement viewZipcode;

@FindBy(xpath="//table[@id='w0']/tbody/tr[9]/td")
public WebElement viewDescription;

@FindBy(xpath="//table[@id='w0']/tbody/tr[10]/td")
public WebElement viewInstitution;
@FindBy(xpath="//table[@id='w0']/tbody/tr[11]/td")
public WebElement viewStatus;
@FindBy(xpath="//table[@id='w0']/tbody/tr[12]/td")
public WebElement viewSubscriptionType;
@FindBy(xpath="//table[@id='w0']/tbody/tr[13]/td")
public WebElement viewTimezone;

@FindBy(xpath="//table[@id='w0']/tbody/tr[14]/td")
public WebElement viewRequestedDate;

@FindBy(xpath="//table[@id='w0']/tbody/tr[15]/td")
public WebElement viewApprovedDate;
/////////////////////////////////////////////////////////
	
//index Table first  row
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[2]")
	public WebElement indexViewFirstName;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[3]")
	public WebElement indexViewInstitutionName;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[4]")
	public WebElement indexViewEmailId;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]")
	public WebElement indexViewSubscriptionType;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]")
	public WebElement indexViewStatus;
	

	////////////////////////////////////////////////////////////////////////////
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[7]/a[1]")
	public WebElement indexviewButton;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[7]/a[2]")
	public WebElement indexAddUserButton;
	
	
	public void changeStatus(String newstatus) {
		
		CommonLib.selectbyVisibleText(signupStatus, newstatus);
		
		
	}
	
	
	
	
	
	

}
