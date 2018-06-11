package tracksPageScripts;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import genericLib.Constants;
import genericLib.Driver;
import genericLib.ExcelLib;
import genericLib.ExtentReports_3;
import genericLib.Wait;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;



public class LoginPageScripts extends ExtentReports_3 {
	
	
	
	
	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	
	
	
	@BeforeClass
	public void loginPage()
	{
		parentlogger= extentReport.createTest("Zsync loginPage Verify");
		Driver.getBrowser();
		
		
		loginPage = PageFactory.initElements(driver, Login.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();	
	}
	
//Wrong username/password,The user is shown an error Message
	@Test (priority=1)
	public void login_tc_1() {
	
	childlogger=parentlogger.createNode("Pre-conditions==>Username was correct, but the password was wrong.");
	childlogger.assignCategory("Functional Testing");
	
	loginPage.login_PlatformAdmin(Constants.url, Constants.WrongUsername, Constants.WrongPassword);
	Wait.getWhenVisible("//form[@id='signinform']/div/div[2]/div/p");
	String errorMessage=loginPage.ErrorMessage.getText();
	childlogger.log(Status.INFO, "Verify Error Message ==>Incorrect username or password.");
	Assert.assertEquals("Incorrect username or password.",errorMessage);
	
	 Wait.waitForPageToLoad();
		
	}
	
//Username was correct, but the password was wrong. The user is shown an error message.
	@Test (priority=2)
	public void login_tc_2() {
	childlogger=parentlogger.createNode("Pre-conditions==>Username was correct, but the password was wrong.");
	childlogger.assignCategory("Functional Testing");
	loginPage.login_PlatformAdmin(Constants.url, Constants.CorrectUsername, Constants.WrongPassword);
	Wait.getWhenVisible("//form[@id='signinform']/div/div[2]/div/p");
	String errorMessage=loginPage.ErrorMessage.getText();
	childlogger.log(Status.INFO, "Verify Error Message ==>Incorrect username or password.");
	Assert.assertEquals("Incorrect username or password.",errorMessage);
	
	}
	
   //Username was wrong, but the password was correct. The user is shown an error message.
   @Test (priority=3)
   public void login_tc_3() {
	childlogger=parentlogger.createNode("Pre-conditions==>Username was wrong, but the password was correct.");
	childlogger.assignCategory("Functional Testing");
    loginPage.login_PlatformAdmin(Constants.url, Constants.WrongUsername, Constants.CorrectPassword);
    Wait.getWhenVisible("//form[@id='signinform']/div/div[2]/div/p");
	String errorMessage=loginPage.ErrorMessage.getText();
	
	childlogger.log(Status.INFO, "Verify Error Message ==>Incorrect username or password.");
	Assert.assertEquals("Incorrect username or password.",errorMessage);
	
		
	}
	
	
 //Blank username/password,The user is shown an error Message.
	
   @Test (priority=4)
   public void login_tc_4() {
	childlogger=parentlogger.createNode("Pre-conditions==>Blank username/password.");
	childlogger.assignCategory("Functional Testing");
    loginPage.login_PlatformAdmin(Constants.url, Constants.BlankUsername, Constants.BlankPassword);
    
    Wait.getWhenVisible("//form[@id='signinform']/div/div[1]/div/p");
    String usernameerrorMessage=loginPage.userNameErrorMessage.getText();
    Assert.assertEquals("Email cannot be blank.",usernameerrorMessage);
    
    childlogger.log(Status.INFO, "Verify Error Message ==>Email cannot be blank.");
    Wait.getWhenVisible("//form[@id='signinform']/div/div[2]/div/p");
  	String errorMessage=loginPage.ErrorMessage.getText();
  	
  	childlogger.log(Status.INFO, "Verify Error Message ==>Password cannot be blank.");
  	Assert.assertEquals("Password cannot be blank.",errorMessage);
  	
   
   }
   
  //Username was Blank, but the password was wrong. The user is shown an error message. 
   @Test (priority=5)
   public void login_tc_5() {
	childlogger=parentlogger.createNode("Pre-conditions==>Username was Blank, but the password was wrong.");
	childlogger.assignCategory("Functional Testing");

   loginPage.login_PlatformAdmin(Constants.url, Constants.BlankUsername,Constants.WrongPassword);
   Wait.getWhenVisible("//form[@id='signinform']/div/div[1]/div/p");
   String usernameerrorMessage=loginPage.userNameErrorMessage.getText();
   childlogger.log(Status.INFO, "Verify Error Message ==>Email cannot be blank.");
   Assert.assertEquals("Email cannot be blank.",usernameerrorMessage);
  
	   
   }
   
 //Username was Blank, but the password was Correct. The user is shown an error message. 
   @Test (priority=6)
   public void login_tc_6() {
   childlogger=parentlogger.createNode("Pre-conditions-->Username was Blank, but the password was Correct.");
   childlogger.assignCategory("Functional Testing");
   loginPage.login_PlatformAdmin(Constants.url, Constants.BlankUsername,Constants.CorrectPassword);
   Wait.getWhenVisible("//form[@id='signinform']/div/div[1]/div/p");
   String usernameerrorMessage=loginPage.userNameErrorMessage.getText();
   
   childlogger.log(Status.INFO, "Verify Error Message ==>Email cannot be blank.");
   Assert.assertEquals("Email cannot be blank.",usernameerrorMessage);
  
	   
   }
   
 //Username was wrong, but the password was Blank. The user is shown an error message. 
   @Test (priority=7)
   public void login_tc_7() {
	childlogger=parentlogger.createNode("Pre-conditions==>Username was wrong, but the password was Blank.");
	childlogger.assignCategory("Functional Testing");
    loginPage.login_PlatformAdmin(Constants.url, Constants.WrongUsername,Constants.BlankPassword);
    Wait.getWhenVisible("//form[@id='signinform']/div/div[2]/div/p");
 	String errorMessage=loginPage.ErrorMessage.getText();
 	
 	childlogger.log(Status.INFO, "Verify Error Message ==>Password cannot be blank.");
 	Assert.assertEquals(errorMessage,"Password cannot be blank.");
 	
	   
   }
   
 //Username was Correct, but the password was Blank. The user is shown an error message. 
   @Test (priority=8)
   public void login_tc_8() {
	childlogger=parentlogger.createNode("Pre-conditions==>Username was Correct, but the password was Blank.");
	childlogger.assignCategory("Functional Testing");
    
    loginPage.login_PlatformAdmin(Constants.url, Constants.CorrectUsername,Constants.BlankPassword);
    Wait.getWhenVisible("//form[@id='signinform']/div/div[2]/div/p");
 	String errorMessage=loginPage.ErrorMessage.getText();
 	childlogger.log(Status.INFO, "Verify Error Message ==>Password cannot be blank.");
 	Assert.assertEquals(errorMessage,"Password cannot be blank.");
 	
	   
   }
   
  
   @Test (priority=9)
   public void login_tc_9() {
	childlogger=parentlogger.createNode("Pre-conditions==>Username was Correct, but the password was Uppercase Correct Password");
	childlogger.assignCategory("Functional Testing");
    loginPage.login_PlatformAdmin(Constants.url, Constants.CorrectUsername,Constants.UppercaseCorrectPassword);
    Wait.getWhenVisible("//form[@id='signinform']/div/div[2]/div/p");
 	String errorMessage=loginPage.ErrorMessage.getText();
 	childlogger.log(Status.INFO, "Verify Error Message ==>Incorrect username or password.");
 	Assert.assertEquals(errorMessage,"Incorrect username or password.");
 	
	   
   }
   
   @Test (priority=10)
   public void login_tc_10() {
	childlogger=parentlogger.createNode("Pre-conditions==>Uppercase Correct Username and Uppercase Correct Password");
	childlogger.assignCategory("Functional Testing");
	
    loginPage.login_PlatformAdmin(Constants.url, Constants.CorrectUsername,Constants.UppercaseCorrectPassword);
    Wait.getWhenVisible("//form[@id='signinform']/div/div[2]/div/p");
 	String errorMessage=loginPage.ErrorMessage.getText();
 	childlogger.log(Status.INFO, "Verify Error Message ==>Incorrect username or password.");
 	Assert.assertEquals(errorMessage,"Incorrect username or password.");
 	
	   
   }
   
   
   
   
   
   
   @Test (priority=11)
   public void forgotPassword_tc_1() {
	  
	   childlogger=parentlogger.createNode("Pre-conditions==>Put Valid user email id and Verify Success Message ");
	   childlogger.assignCategory("Functional Testing");
	   Wait.getWhenVisible("//*[contains(text(),'Forgot Username')]");
	   loginPage.ForgotUsernamelink.click();
	   
	   Wait.getWhenVisible("//input[@id='email1']");
	   loginPage.forgotUsername(Constants.ValidEmailid);
	   
	   loginPage.ForgotUsernameSaveButton.click();
	   Wait.getWhenVisible("//*[@id='username_window']/div/div/div[2]/i/b/font");
	   String successMessage=loginPage.ForgotUsernameMessage.getText();
	   
	   childlogger.log(Status.INFO, "Verify Success Message==> You will get an Email shortly with the requested information. Thank You!.");
	   
	   Assert.assertEquals("You will get an Email shortly with the requested information. Thank You!.",successMessage);
	   loginPage.ForgotUsernameCloseButton.click();
	   Wait.waitForPageToLoad();
	   
	   
	   
   }
   
  @Test (priority=12)
   public void forgotPassword_tc_2() {
	   
	  childlogger=parentlogger.createNode("Pre-conditions==>Put InValid user email id and Verify Error Message.");
	  childlogger.assignCategory("Functional Testing");
	   loginPage.ForgotUsernamelink.click();
	   Wait.getWhenVisible("//input[@id='email1']");
	   loginPage.forgotUsername(Constants.InValidEmailid);
	   
	   loginPage.ForgotUsernameSaveButton.click();
	   Wait.getWhenVisible("//*[@id='username_window']/div/div/div[2]/i/b/font");
	   String errorMessage=loginPage.ForgotUsernameMessage.getText();
	   childlogger.log(Status.INFO, "Verify Error Message==> Your email is not present in our record.");
	   Assert.assertEquals("Your email is not present in our record.",errorMessage);
	   loginPage.ForgotUsernameCloseButton.click();
	   Wait.waitForPageToLoad();
	   
	   
	   
   }
   
   @Test (priority=13)
   public void forgotPassword_tc_3() {
	   
	   childlogger=parentlogger.createNode("Pre-conditions==>Put In  Blank email id and Verify Error Message.");
	   childlogger.assignCategory("Functional Testing");
	   loginPage.ForgotUsernamelink.click();
	   Wait.getWhenVisible("//input[@id='email1']");
	   loginPage.forgotUsername(Constants.BlankEmailid);
	   
	   loginPage.ForgotUsernameSaveButton.click();
	   Wait.getWhenVisible("//*[@id='username_window']/div/div/div[2]/i/b/font");
	   String errorMessage=loginPage.ForgotUsernameMessage.getText();
	   
	   childlogger.log(Status.INFO, "Verify Error Message==> Please enter your email address");
	   loginPage.ForgotUsernameCloseButton.click();
	   Assert.assertEquals(errorMessage,"please enter your email address");
	   
   }
   
   @Test (priority=14)
   public void forgotPassword_tc_4() {
	   
	   childlogger=parentlogger.createNode("Pre-conditions==>Put In  Wrong email id and Verify Error Message.");
	   childlogger.assignCategory("Functional Testing");
	   loginPage.ForgotUsernamelink.click();
	   Wait.getWhenVisible("//input[@id='email1']");
	   loginPage.forgotUsername(Constants.IncorrectEmail);
	   
	   loginPage.ForgotUsernameSaveButton.click();
	   Wait.getWhenVisible("//*[@id='username_window']/div/div/div[2]/i/b/font");
	   String errorMessage=loginPage.ForgotUsernameMessage.getText();
	   
	   childlogger.log(Status.INFO, "Verify Error Message==> please enter valid email address!");
	   loginPage.ForgotUsernameCloseButton.click();
	   Assert.assertEquals(errorMessage,"please enter valid email address!");
	   
   }
   
   
   
 //Username was Correct, and  password was Correct. and the user Navigated to Homepage. 
  @Test (priority=15)
   public void login_tc_11() {
	childlogger=parentlogger.createNode("Pre-conditions==>Username/password Correct, and the User Navigated to Homepage.");
    childlogger.assignCategory("Smoke Testing");
   childlogger.log(Status.INFO, "Verify Homepage User Name As==> Admin");
   loginPage.login_PlatformAdmin(Constants.url, Constants.CorrectUsername,Constants.CorrectPassword);
   Wait.getWhenVisible("//*[@class='profile']/div[2]/h2");
   String profileName=loginPage.profileName.getText();
 
   Assert.assertEquals(profileName,"Admin");
   
   
   
	   
   }
	

  
   @AfterClass
	public void closePage()
	{
		driver.close();
		
	}
	

}
