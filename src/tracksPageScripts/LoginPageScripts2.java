package tracksPageScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericLib.Constants;
import genericLib.Driver;
import genericLib.ExcelLib;
import genericLib.Log;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;

public class LoginPageScripts2 extends Driver {
	
	
	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	
	
	
	@BeforeClass
	public void loginPage()
	{
		Driver.getBrowser();
		Log.info("Browser start");
		loginPage = PageFactory.initElements(driver, Login.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		eLib = new ExcelLib();	
	}
	
	
	 @Test(dataProvider = "MySQL-provider")
    public void tc_1(String a, String b)
    {
		  loginPage.login_PlatformAdmin(Constants.url, a, b);
    }

	



}
