package pageObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Time {
	
	
	@FindBy(xpath="//*[@id='w0']/div[5]/div/div/div[1]/div/div[2]/div[2]/input")
	private WebElement startHours;
	
	@FindBy(xpath="//*[@id='w0']/div[6]/div/div/div[1]/div/div[2]/div[2]/input")
	private WebElement endHours;
	
	@FindBy(xpath="//*[@id='w0']/div[5]/div/div/div[1]/div/div[3]/div[2]/input")
	private WebElement startMins;
	
	@FindBy(xpath="//*[@id='w0']/div[6]/div/div/div[1]/div/div[3]/div[2]/input")
	private WebElement endMins;
	
	@FindBy(xpath="//*[@id='w0']/div[5]/div/div/div[1]/div/div[2]/div[3]")
	private WebElement hoursNext;
	
	@FindBy(xpath="//*[@id='w0']/div[6]/div/div/div[1]/div/div[2]/div[3]")
	private WebElement endhoursNext;
	
	@FindBy(xpath="//*[@id='w0']/div[5]/div/div/div[1]/div/div[3]/div[3]")
	private WebElement minsNext;
	
	@FindBy(xpath="//*[@id='w0']/div[6]/div/div/div[1]/div/div[3]/div[3]")
	private WebElement endminsNext;
	
	
	
	public void getStartHours(String expecthours,String expectmins) throws InterruptedException {
		
		if(expecthours.equals(startHours.getAttribute("value"))) {
			System.out.println(startHours.getAttribute("value"));
		   }else {
			
			   for (int i = 0; i<=24; i++) {
				   hoursNext.click();
				   Thread.sleep(2000);
				   startHours.getAttribute("value");
				   
				   if(expecthours.equals(startHours.getAttribute("value"))) {
					   System.out.println(startHours.getAttribute("value"));
					   break; 
				   }
				
			    }
			   
		      }
		
		if(expectmins.equals(startMins.getAttribute("value"))) {
		System.out.println(startMins.getAttribute("value"));
			
		}else {
			
			for (int i = 0; i<=60; i++) {
				    minsNext.click();
				   Thread.sleep(2000);
				   startMins.getAttribute("value");
				   
				   if(expectmins.equals(startMins.getAttribute("value"))) {
					   System.out.println(startMins.getAttribute("value"));
					   break; 
				   }
				
			    }
			
		}
		
		
		
		
	}
	
	
	
public void getEndHours(String expectendhours,String expecendtmins) throws InterruptedException {
		
		if(expectendhours.equals(endHours.getAttribute("value"))) {
			System.out.println(endHours.getAttribute("value"));
		   }else {
			
			   for (int i = 0; i<=24; i++) {
				   endhoursNext.click();
				   Thread.sleep(2000);
				   endHours.getAttribute("value");
				   
				   if(expectendhours.equals(endHours.getAttribute("value"))) {
					   System.out.println(endHours.getAttribute("value"));
					   break; 
				   }
				
			    }
			   
		      }
		
		if(expecendtmins.equals(endMins.getAttribute("value"))) {
		System.out.println(endMins.getAttribute("value"));
			
		}else {
			
			for (int i = 0; i<=60; i++) {
				   endminsNext.click();
				   Thread.sleep(2000);
				   endMins.getAttribute("value");
				   
				   if(expecendtmins.equals(endMins.getAttribute("value"))) {
					   System.out.println(endMins.getAttribute("value"));
					   break; 
				   }
				
			    }
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
