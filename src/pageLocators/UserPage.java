package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.CommonLib;
import genericLib.Driver;
import genericLib.Wait;
import pageObjectRepoLib.Calendar;

public class UserPage extends Driver {
	Calendar cal;
	
	@FindBy(xpath="//*[@class='profile']/div[2]/h2")
	public WebElement profileName;
	
	@FindBy(xpath="//*[contains(text(),' Master Data')]")
	public WebElement masterData;
	
	@FindBy(xpath="//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[3]")
	public WebElement  User;
	
	@FindBy(xpath="//*[contains(text(),'Add New')]")
	public WebElement addNewButton;
	

	@FindBy(xpath="//a[contains(text(),'Add New')]")
	public WebElement addNewRoleButton;
	
	@FindBy(xpath="//*[contains(text(),'Save')]")
	public WebElement saveButton;
	
	@FindBy(xpath="//*[@class='x_panel']//*[text()='Cancel']")
	public WebElement cancelButton;
	
	@FindBy(xpath="//*[contains(text(),'Update')]")
	public WebElement UpdateButton;
	
	
	
	@FindBy(id="zsyuser-tenantid")
	private WebElement userTenant;
	
	@FindBy(id="zsyuser-institutionid")
	private WebElement userInstitution;
	
	@FindBy(id="zsyuser-firstname")
	private WebElement userFirstName;
	
	@FindBy(id="zsyuser-lastname")
	private WebElement userLastName;
	
	@FindBy(id="zsyuser-email")
	private WebElement userEmail;
	
	@FindBy(id="zsyuser-mobilenumber")
	private WebElement userMobileNumber;
	
	@FindBy(id="zsyuser-startdate")
	public WebElement userStartdate;
	
	@FindBy(id="zsyuser-enddate")
	public WebElement userEnddate;
	
	@FindBy(id="zsyuser-profession")
	private WebElement userProfession;
	
	@FindBy(id="zsyuser-address")
	private WebElement userAddress;
	
	@FindBy(id="zsyuser-city")
	private WebElement userCity;
	
	@FindBy(id="zsyuser-province")
	private WebElement userProvince;
	
	@FindBy(id="zsyuser-country")
	private WebElement userCountry;
	
	@FindBy(id="zsyuser-zipcode")
	private WebElement userZipcode;
	
	@FindBy(id="zsyuser-timezone")
	private WebElement userTimezone;
	
	@FindBy(id="zsyuser-photopath")
	private WebElement userPhotopath;
	
	@FindBy(id="zsyuser-url")
	private WebElement userUrl;
	
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[1]/td")
	public WebElement viewTenantName;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[2]/td")
	public WebElement viewInstitutionName;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[3]/td")
	public WebElement viewStartDate;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[4]/td")
	public WebElement viewEndDate;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[5]/td")
	public WebElement viewStatus;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[6]/td")
	public WebElement viewSubscriptionType;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[7]/td")
	public WebElement viewAmount;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[8]/td")
	public WebElement viewAutorenewalIndicator;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[9]/td")
	public WebElement viewAutorenewalDate;
	
	
	@FindBy(xpath="//*[@class='list-unstyled user_data']/li[1]")
	public WebElement viewEmailid;
	
	@FindBy(xpath="//*[@class='list-unstyled user_data']/li[3]")
	public WebElement viewProfession;
	
	@FindBy(xpath="//*[@class='list-unstyled user_data']/li[4]")
	public WebElement viewURL;
	
	
	//index Table first  row
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[2]")
	public WebElement indexViewUserFirstName;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[3]")
	public WebElement indexViewUserEmail;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[4]")
	public WebElement indexViewUserTenant;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[4]")
	public WebElement systemindexViewUserInstitution;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]")
	public WebElement indexViewUserInstitution;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]")
	public WebElement systemindexViewUserrole;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]")
	public WebElement indexViewUserStatus;


	//index all button 
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[7]/a[1]")
	public WebElement indexviewButton;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[7]/a[2]")
	public WebElement indexUpdateButton;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[7]/a[3]")
	public WebElement indexDeactiveButton;
	
	//deActive ok button
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	public WebElement deactiveOkButton;
	
	
	@FindBy(xpath="//*[@id='userType']")
	public WebElement userType;
	
	@FindBy(id="zsyuserrole-startdate")
	public WebElement userRoleStartdate;
	
	@FindBy(id="zsyuserrole-enddate")
	public WebElement userRoleEnddate;
	
	
	
	
	
public void createUser(String selectTenant,String selectInstitution,String firstName,String lastName,String email,String mobileNumber,String profession,String address,String city,String province,String country,String zipcode,String timezoneValue,String photopath,String url) throws InterruptedException 
{
cal=PageFactory.initElements(driver, Calendar.class);
	
CommonLib.selectbyVisibleText(userTenant, selectTenant);
CommonLib.selectbyVisibleText(userInstitution, selectInstitution);

userFirstName.sendKeys(firstName);
userLastName.sendKeys(lastName);
userEmail.sendKeys(email);
userMobileNumber.sendKeys(mobileNumber);
//userStartdate.click();
//cal.getDate(startDate);
//userEnddate.click();
//cal.getDate(endDate);

userProfession.sendKeys(profession);
userAddress.sendKeys(address);
userCity.sendKeys(city);
userProvince.sendKeys(province);
userCountry.sendKeys(country);
userZipcode.sendKeys(zipcode);
CommonLib.selectbyValue(userTimezone, timezoneValue);
userPhotopath.sendKeys(photopath);

userUrl.sendKeys(url);

	
}


public void createSystemUser(String selectInstitution,String firstName,String lastName,String email,String mobileNumber,String profession,String address,String city,String province,String country,String zipcode,String timezoneValue,String photopath,String url) throws InterruptedException 
{
cal=PageFactory.initElements(driver, Calendar.class);
	

CommonLib.selectbyVisibleText(userInstitution, selectInstitution);

userFirstName.sendKeys(firstName);
userLastName.sendKeys(lastName);
userEmail.sendKeys(email);
userMobileNumber.sendKeys(mobileNumber);
//userStartdate.click();
//cal.getDate(startDate);
//userEnddate.click();
//cal.getDate(endDate);

userProfession.sendKeys(profession);
userAddress.sendKeys(address);
userCity.sendKeys(city);
userProvince.sendKeys(province);
userCountry.sendKeys(country);
userZipcode.sendKeys(zipcode);
CommonLib.selectbyValue(userTimezone, timezoneValue);
userPhotopath.sendKeys(photopath);

userUrl.sendKeys(url);

	
}
	
public void createSystemRole(String selectRole,String Startdate,String Enddate) throws InterruptedException {
cal=PageFactory.initElements(driver, Calendar.class);	
CommonLib.selectbyVisibleText(userType, selectRole);
userRoleStartdate.click();
cal.getDate(Startdate);
userRoleEnddate.click();

cal.getDate(Enddate);

	
}




public void viewUser(String tenantName,String institutionName,String startDate,String endDate, String Status,String SubscriptionType,String Amount,String AutorenewalIndicator,String AutorenewalDate,String Emailid,String Profession,String Url) {
	
CommonLib.verifyText(viewTenantName, tenantName);
CommonLib.verifyText(viewInstitutionName, institutionName);
CommonLib.verifyText(viewStartDate, startDate);
CommonLib.verifyText(viewEndDate, endDate);
CommonLib.verifyText(viewStatus, Status);

CommonLib.verifyText(viewSubscriptionType, SubscriptionType);
CommonLib.verifyText(viewAmount, Amount);

CommonLib.verifyText(viewAutorenewalIndicator, AutorenewalIndicator);

CommonLib.verifyText(viewAutorenewalDate, AutorenewalDate);

CommonLib.verifyText(viewEmailid, Emailid);

CommonLib.verifyText(viewProfession, Profession);

CommonLib.verifyText(viewURL, Url);


}


public void indexViewUser(String userfirstNam,String userEmail,String userTenant,String userInstitution,String userStatus ) {

CommonLib.verifyText(indexViewUserFirstName,userfirstNam);
CommonLib.verifyText(indexViewUserEmail,userEmail);
CommonLib.verifyText(indexViewUserTenant,userTenant);
CommonLib.verifyText(indexViewUserInstitution,userInstitution);
CommonLib.verifyText(indexViewUserStatus,userStatus);

	
}

public void updateUser(String firstName,String lastName,String mobileNumber,String profession,String address,String city,String province,String country,String zipcode,String timezoneValue,String photopath,String url) {
	
	userFirstName.clear();
	userFirstName.sendKeys(firstName);
	userLastName.clear();
	userLastName.sendKeys(lastName);
	userMobileNumber.clear();
	userMobileNumber.sendKeys(mobileNumber);
	userProfession.clear();
	userProfession.sendKeys(profession);
	userAddress.clear();
	userAddress.sendKeys(address);
	userCity.clear();
	userCity.sendKeys(city);
	userProvince.clear();
	userProvince.sendKeys(province);
	userCountry.clear();
	userCountry.sendKeys(country);
	userZipcode.clear();
	userZipcode.sendKeys(zipcode);
	CommonLib.selectbyValue(userTimezone, timezoneValue);
	userPhotopath.sendKeys(photopath);
	userUrl.clear();
	userUrl.sendKeys(url);
	
	
	
}
	
	
 public void dateUpdate(String Startdate,String Enddate) throws InterruptedException {
	   cal=PageFactory.initElements(driver, Calendar.class);
	    Wait.waitForPageToLoad();
	 
	    userStartdate.click();
		Wait.waitForPageToLoad();
		cal.getDate(Startdate);
		
		userEnddate.click();
		Wait.waitForPageToLoad();
		cal.getDate(Enddate);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
