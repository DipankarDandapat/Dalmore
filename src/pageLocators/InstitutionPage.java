package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLib.CommonLib;
import genericLib.Driver;
import genericLib.Wait;
import pageObjectRepoLib.Calendar;

public class InstitutionPage extends Driver {
	
	@FindBy(xpath="//*[@class='profile']/div[2]/h2")
	public WebElement profileName;
	
	@FindBy(xpath="//*[contains(text(),' Master Data')]")
	public WebElement masterData;
	
	@FindBy(xpath="//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[2]")
	public WebElement  Institution;
	
	@FindBy(xpath="//*[contains(text(),'Add New')]")
	public WebElement addNewButton;
	
	@FindBy(xpath="//*[contains(text(),'Save')]")
	public WebElement saveButton;
	
	@FindBy(xpath="//*[contains(text(),'Cancel')]")
	public WebElement cancelButton;
	
	@FindBy(xpath="//*[contains(text(),'Update')]")
	public WebElement UpdateButton;
	
	
	@FindBy(id="zsyinstitution-tenantid")
	public WebElement institutionTenantid;
	
	@FindBy(id="zsyinstitution-name")
	private WebElement institutionName;
	
	@FindBy(id="zsyinstitution-description")
	private WebElement institutionDescription;
		
	@FindBy(id="zsyinstitution-startdate")
	public WebElement institutionStartDate;
	
	
	
	@FindBy(id="zsyinstitution-enddate")
	public WebElement institutionEndDate;
	
	
	
	@FindBy(name="ZsyInstitution[Currency]")
	private WebElement institutionCurrency;
	
	@FindBy(id="zsyinstitution-url")
	private WebElement institutionUrl ;
	
	//view institution
	@FindBy(xpath="//table[@id='w0']/tbody/tr[1]/td")
	public WebElement viewInsName;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[2]/td")
	public WebElement viewTenantName;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[3]/td")
	public WebElement viewCurrency;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[4]/td")
	public WebElement viewStartDate;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[5]/td")
	public WebElement viewEndDate;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[6]/td")
	public WebElement viewStatus;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[7]/td")
	public WebElement viewDescription;
	@FindBy(xpath="//table[@id='w0']/tbody/tr[8]/td")
	public WebElement viewURL;
	
	//index Table first  row
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[2]")
	public WebElement indexViewInsName;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[3]")
	public WebElement indexViewTenantName;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[4]")
	public WebElement indexViewCurrencyName;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[3]")
	public WebElement systemindexViewCurrencyName;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]")
	public WebElement indexViewStatus;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[4]")
	public WebElement systemindexViewStatus;
	
	
	//index all button 
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]/a[1]")
	public WebElement indexviewButton;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]/a[1]")
	public WebElement systemindexviewButton;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]/a[2]")
	public WebElement indexUpdateButton;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]/a[2]")
	public WebElement systemindexUpdateButton;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]/a[3]")
	public WebElement indexDeactiveButton;
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]/a[3]")
	public WebElement systemindexDeactiveButton;
	
	//deActive ok button
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	public WebElement deactiveOkButton;
	
	
	
	
	Calendar cal=PageFactory.initElements(driver, Calendar.class);

	public void createInstitution(String insTenant,String insName,String insDescription,String Startdate,String Enddate,String insCurrency , String insUrl) throws InterruptedException {
		cal=PageFactory.initElements(driver, Calendar.class);
		
		CommonLib.selectbyVisibleText(institutionTenantid, insTenant);
		institutionName.sendKeys(insName);
		institutionDescription.sendKeys(insDescription);
		institutionStartDate.click();
		cal.getDate(Startdate);
		
		institutionEndDate.click();
		cal.getDate(Enddate);
		
		
		CommonLib.selectbyVisibleText(institutionCurrency, insCurrency);
		institutionUrl.sendKeys(insUrl);
		
		
	}
	
	
	public void createSystemInstitution(String insName,String insDescription,String Startdate,String Enddate,String insCurrency , String insUrl) throws InterruptedException {
		cal=PageFactory.initElements(driver, Calendar.class);
		
		
		institutionName.sendKeys(insName);
		institutionDescription.sendKeys(insDescription);
		institutionStartDate.click();
		cal.getDate(Startdate);
		
		institutionEndDate.click();
		cal.getDate(Enddate);
		
		
		CommonLib.selectbyVisibleText(institutionCurrency, insCurrency);
		institutionUrl.sendKeys(insUrl);
		
		
	}
	
	
	public void updateInstitution(String insName,String insDescription,String Startdate,String Enddate,String insCurrency,String insUrl) throws InterruptedException {
		
		Wait.waitForPageToLoad();
		institutionName.clear();
		institutionName.sendKeys(insName);
		institutionDescription.clear();
		institutionDescription.sendKeys(insDescription);
		
		institutionStartDate.click();
		Wait.waitForPageToLoad();
		cal.getDate(Startdate);
		
		institutionEndDate.click();
		Wait.waitForPageToLoad();
		cal.getDate(Enddate);
		
		CommonLib.selectbyVisibleText(institutionCurrency, insCurrency);
		institutionUrl.clear();
		institutionUrl.sendKeys(insUrl);
		
		
		
	}
	
	public void dateUpdate(String Startdate,String Enddate) throws InterruptedException {
	 Wait.waitForPageToLoad();
	 
	 institutionStartDate.click();
		Wait.waitForPageToLoad();
		cal.getDate(Startdate);
		
		institutionEndDate.click();
		Wait.waitForPageToLoad();
		cal.getDate(Enddate);
		
	}
	
	
	
	
	
	

}
