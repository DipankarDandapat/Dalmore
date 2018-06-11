package pageLocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import genericLib.Driver;
import genericLib.CommonLib;

public class TenantPage {
	
	@FindBy(xpath="//*[@class='profile']/div[2]/h2")
	public WebElement profileName;
	
	@FindBy(xpath="//*[@id='menu_toggle']")
	public WebElement menutoggle;
	
	
	@FindBy(xpath="//a[@class='site_title']/span")
	public WebElement Ziksana;
	
	
	@FindBy(xpath="//*[contains(text(),' Master Data')]")
	public WebElement masterData;
	
	@FindBy(xpath="//*[@id='sidebar-menu']/div/ul/li[2]/ul/li[1]")
	public WebElement Tenant;
	
	@FindBy(xpath="//*[contains(text(),'Add New')]")
	public WebElement addNewButton;
	
	@FindBy(xpath="//*[contains(text(),'Save')]")
	public WebElement saveButton;
	
	@FindBy(xpath="//*[contains(text(),'Cancel')]")
	public WebElement cancelButton;
	
	@FindBy(xpath="//*[contains(text(),'Update')]")
	public WebElement UpdateButton;
	
	
	
	
	
	

	@FindBy(id="zsytenant-name")
	private WebElement tenantName;
	
	@FindBy(id="zsytenant-tenanttype")
	private WebElement tenantType;
	
	@FindBy(id="zsytenant-status")
	private WebElement tenantStatus;
	
	@FindBy(id="zsytenant-description")
	private WebElement tenantDescription;
	
	@FindBy(id="zsytenant-operatingmarket")
	private WebElement tenantoperatingMarket;
	
	//After Create Tenants/or view
	@FindBy(xpath="//table[@id='w0']/tbody/tr[1]/td")
	public WebElement viewName;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[2]/td")
	public WebElement viewDescription;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[3]/td")
	public WebElement viewOperatingMarket;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[4]/td")
	public WebElement viewType;
	
	@FindBy(xpath="//table[@id='w0']/tbody/tr[5]/td")
	public WebElement viewStatus;
	
	//index page
	
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[2]")
	public WebElement indexviewName;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[3]")
	public WebElement indexType;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[4]")
	public WebElement indexOperatingMarket;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[5]")
	public WebElement indexStatus;
	
	
	//index all button 
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]/a[1]")
	public WebElement indexviewButton;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]/a[2]")
	public WebElement indexUpdateButton;
	@FindBy(xpath="//div[@id='kv-grid-demo-container']/table/tbody/tr[1]/td[6]/a[3]")
	public WebElement indexDeactiveButton;
	
	//deActive ok button
	@FindBy(xpath="//button[contains(text(),'Ok')]")
	public WebElement deactiveOkButton;
	
	
	//Search by table
	@FindBy(xpath="//*[@id='zsytenantsearch-name']")
	private WebElement SearchTenantName;
	@FindBy(xpath="//*[@id='kv-grid-demo-container']/table/tbody/tr/td/div")
	public WebElement NoSearchFile;
	
	//table
	@FindBy(xpath="//*[@id='kv-grid-demo-container']/table/tbody")
	public WebElement tenantTable;
	
	@FindBy(xpath="//*[@id='kv-grid-demo-container']/table/tbody/tr")
	public List<WebElement> tenantTotal_tr;
	
	@FindBy(xpath="//*[@id='kv-grid-demo-container']/table/tbody/tr[1]/td")
	public List<WebElement> tenantFirstrow_td;
	
	
	public void createTenant(String tenantname,String tenanttype, String tenantstatus,String tenantdescription,String tenantoperatingmarket) {
		
		tenantName.sendKeys(tenantname);
		CommonLib.selectbyVisibleText(tenantType, tenanttype);
		CommonLib.selectbyVisibleText(tenantStatus, tenantstatus);
		tenantDescription.sendKeys(tenantdescription);
		tenantoperatingMarket.sendKeys(tenantoperatingmarket);
		
		
	}
	
public void updateTenant(String tenantname,String tenanttype,String tenantstatus, String tenantdescription,String tenantoperatingmarket) {
		
		tenantName.clear();
		tenantName.sendKeys(tenantname);
		
		CommonLib.selectbyVisibleText(tenantType, tenanttype);
		CommonLib.selectbyVisibleText(tenantStatus, tenantstatus);
		tenantDescription.clear();
		tenantDescription.sendKeys(tenantdescription);
		tenantoperatingMarket.clear();
		tenantoperatingMarket.sendKeys(tenantoperatingmarket);
		
		
	}

public void updateTenantStatus(String tenantstatus) {
	CommonLib.selectbyVisibleText(tenantStatus, tenantstatus);
	
}

public void SearchbyTenantName(String TenantName) {
	
	SearchTenantName.clear();
	SearchTenantName.sendKeys(TenantName);
	SearchTenantName.sendKeys(Keys.ENTER);
	
}


public void findTenantDetails(String TenanName) {
	
	for (int i = 1; i <tenantTotal_tr.size(); i++) {

		  for (int j = 1; j <=tenantFirstrow_td.size(); j++) {
			
			WebElement e = Driver.driver.findElement(By.xpath("//*[@id='kv-grid-demo-container']/table/tbody/tr[" + i + "]/td["+ j +"]"));
			  
			if(e.getText().contains(TenanName)==true) {
				
				WebElement e1 = Driver.driver.findElement(By.xpath("//*[@id='kv-grid-demo-container']/table/tbody/tr[" + i + "]/td[6]/a[1]"));
				e1.click();
				
				
				
				i=tenantTotal_tr.size();				
				break;	
			}
			
		  }

	}
}
	
	
	
	
}
