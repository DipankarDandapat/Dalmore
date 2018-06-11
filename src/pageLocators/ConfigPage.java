package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericLib.CommonLib;

public class ConfigPage {
	
	
	
	@FindBy(xpath="//*[@class='profile']/div[2]/h2")
	public WebElement profileName;
	
	@FindBy(xpath="//*[contains(text(),' Master Data')]")
	public WebElement masterData;
	
	@FindBy(xpath="//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[5]")
	public WebElement  Config;
	
	@FindBy(xpath="//*[contains(text(),'Add New')]")
	public WebElement addNewButton;
	
	@FindBy(xpath="//*[contains(text(),'Save')]")
	public WebElement saveButton;
	
	@FindBy(xpath="//*[@class='x_panel']//*[text()='Cancel']")
	public WebElement cancelButton;
	
	
	
	@FindBy(id="zsyconfig-tenantid")
	public WebElement SelectTenant;
	
	@FindBy(id="zsyconfig-parameterid")
	public WebElement SelectParameterid;
	
	@FindBy(id="zsyconfig-name")
	public WebElement ConfigName;
	
	@FindBy(id="zsyconfig-parametervalue")
	public WebElement ParameterValue;
	
	@FindBy(id="zsyconfig-status")
	public WebElement SelectStatus;
	
	
	//After Create Tenants/or view
		@FindBy(xpath="//table[@id='w0']/tbody/tr[1]/td")
		public WebElement viewConfigName;
		
		@FindBy(xpath="//table[@id='w0']/tbody/tr[2]/td")
		public WebElement viewTenantName;
		
		@FindBy(xpath="//table[@id='w0']/tbody/tr[3]/td")
		public WebElement viewParameter;
		
		@FindBy(xpath="//table[@id='w0']/tbody/tr[4]/td")
		public WebElement viewParameterValue;
		
		@FindBy(xpath="//table[@id='w0']/tbody/tr[7]/td")
		public WebElement viewStatus;
	
	
	
	public void createConfig(String selectTenant,String selectParameterid,String configName,String parameterValue,String selectStatus) {
		
    CommonLib.selectbyVisibleText(SelectTenant, selectTenant);
    
    CommonLib.selectbyVisibleText(SelectParameterid, selectParameterid);
    
    ConfigName.sendKeys(configName);
    ParameterValue.sendKeys(parameterValue);
    
    CommonLib.selectbyVisibleText(SelectStatus, selectStatus);
    
		
	}
	
	
	
	
	
	
	
	
	

}
