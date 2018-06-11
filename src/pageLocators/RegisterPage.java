package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericLib.CommonLib;

public class RegisterPage {
	
	
	@FindBy(id="zsyusersignup-tenantid")
	public WebElement SelectTenant;
	
	@FindBy(id="zsyusersignup-institutionid")
	public WebElement SelectInstitution;
	
	@FindBy(id="zsyusersignup-subscriptiontype")
	public WebElement SelectSubscriptiontype;
	
	@FindBy(id="zsyusersignup-firstname")
	public WebElement FirstName;
	
	@FindBy(id="zsyusersignup-lastname")
	public WebElement LastName;
	
	@FindBy(id="zsyusersignup-email")
	public WebElement EmailId;
	
	@FindBy(id="zsyusersignup-mobilenumber")
	public WebElement MobileNumber;
	
	@FindBy(id="zsyusersignup-address")
	public WebElement Address;
	
	@FindBy(id="zsyusersignup-city")
	public WebElement City;
	
	@FindBy(id="zsyusersignup-province")
	public WebElement Province;
	

	@FindBy(id="zsyusersignup-country")
	public WebElement Country;
	
	@FindBy(id="zsyusersignup-zipcode")
	public WebElement Zipcode;
	
	@FindBy(id="zsyusersignup-timezone")
	public WebElement SelectTimezone;
	
	@FindBy(id="zsyusersignup-description")
	public WebElement Description;
	
	@FindBy(xpath="//*[contains(text(),'Sign Up')]")
	public WebElement SignUp;
	
	@FindBy(xpath="//*[@id='cta2']/div/div[2]/div[2]/div/p")
	public WebElement Message;
	
	
	
	
	
	public void CreateRegister(String selectTenant,String selectInstitution,String selectSubscriptiontype,String firstName,String lastName,String emailId,String mobileNumber,String address,String city,String province,String country,String zipcode,String selectTimezone,String description) throws InterruptedException {
		
	
	CommonLib.selectbyVisibleText(SelectTenant, selectTenant);
	Thread.sleep(2000);
	CommonLib.selectbyVisibleText(SelectInstitution, selectInstitution);
	CommonLib.selectbyVisibleText(SelectSubscriptiontype, selectSubscriptiontype);
	
	FirstName.sendKeys(firstName);
	LastName.sendKeys(lastName);	
	EmailId.sendKeys(emailId);
	MobileNumber.sendKeys(mobileNumber);
	Address.sendKeys(address);
	City.sendKeys(city);
	Province.sendKeys(province);
	Country.sendKeys(country);
	Zipcode.sendKeys(zipcode);
	
	CommonLib.selectbyValue(SelectTimezone, selectTimezone);
	
	Description.sendKeys(description);
	
		
	}
	
	
	
	

}
