package pageObjectRepoLib;




import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericLib.Driver;

public class Calendar extends Driver{
	
	
	@FindBy(xpath="//div[@class='datepicker-days']/table/thead/tr[2]/th[2]")
	private WebElement monthYear;
	
	
	@FindBy(xpath="//div[@class='datepicker-days']/table/thead/tr[2]/th[3]")
	private WebElement Next;
	
	
	
	@FindBy(xpath="//div[@class='datepicker-days']/table/tbody")
	private WebElement tbody;
	
	@FindBy(xpath="//div[@class='datepicker-days']/table/tbody/tr/td")
	public List <WebElement> alldate;
	
	
	public void getDate(String selectdate) throws InterruptedException {
		
		
		
		
		String expectmonth="June 2018";
		
		
		if(expectmonth.equals(monthYear.getText())) {
			System.out.println("month is selected");
		
		}
		else {
			for (int i = 0; i <= 12; i++) {
				Next.click();
				Thread.sleep(2000);
				monthYear.getText();
				
				if(expectmonth.equals(monthYear.getText())) {
					System.out.println("month selected");
				    break ;
				}
			}
		}
		
		
		for (WebElement dates : alldate) {
			
			String celldata=dates.getText();
					
					if (celldata.equals(selectdate)) {
						dates.click();
						break;
						
					}
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
