package pageObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import genericLib.Wait;

public class Logout extends Wait {
	
	//xpath=//a[contains(@href,'logout')]
			
	@FindBy(xpath="//a[contains(@href,'logout')]")
	private WebElement logOut;
	
	public void logOut() {
		
		
		logOut.click();
		
	}
	

}
