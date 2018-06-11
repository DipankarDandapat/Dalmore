package pageObjectRepoLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import genericLib.Driver;
import genericLib.Wait;

public class Login  {
	
	@FindBy(id="loginform-username")
	private WebElement UserName;
	
	@FindBy(id="loginform-password")
	private WebElement PassWord;
	
	@FindBy(name="login-button")
	public WebElement SigninButton;
	
	
	@FindBy(xpath="//form[@id='signinform']/div/div[2]/div/p")
	public WebElement ErrorMessage;
	
	@FindBy(xpath="//form[@id='signinform']/div/div[1]/div/p")
	public WebElement userNameErrorMessage;
	
	@FindBy(xpath="//*[@class='profile']/div[2]/h2")
	public WebElement profileName;
	
	@FindBy(xpath="//*[contains(text(),'Forgot Username')]")
	public WebElement ForgotUsernamelink;
	
	@FindBy(xpath="//input[@id='email1']")
	public WebElement ForgotUsernameEmailBox;
	
	@FindBy(xpath="//button[@id='send_username']")
	public WebElement ForgotUsernameSaveButton;
	
	@FindBy(xpath="//button[@id='close_btn1']")
	public WebElement ForgotUsernameCloseButton;
	
	@FindBy(xpath="//*[@id='close_btn']")
	public WebElement ForgotUsernameCloseButtonblank;
	
	@FindBy(xpath="//*[@id='username_window']/div/div/div[2]/i/b/font")
	public WebElement ForgotUsernameMessage;
	
	
	public void forgotUsername(String emailid) {
		
		ForgotUsernameEmailBox.clear();
		ForgotUsernameEmailBox.sendKeys(emailid);
		
	}
	
	
	
	
	public void login_PlatformAdmin(  String url, String username , String password ){
		Driver.driver.get(url);
		UserName.clear();
		UserName.sendKeys(username);
		PassWord.clear();
		PassWord.sendKeys(password);
		SigninButton.click();
		
		
	 }
	
	public void login_SystemAdmin(  String url, String username , String password ){
		Driver.driver.get(url);
		
		UserName.sendKeys(username);
		PassWord.sendKeys(password);
		SigninButton.click();
		
		
	 }
	
	public void login_Educator(  String url, String username , String password ){
		Driver.driver.get(url);
		
		UserName.sendKeys(username);
		PassWord.sendKeys(password);
		SigninButton.click();
		
		
	 }
	
	public void login_Learner(  String url, String username , String password ){
		Driver.driver.get(url);
		
		UserName.sendKeys(username);
		PassWord.sendKeys(password);
		SigninButton.click();
		
		
	 }
	
	

}
