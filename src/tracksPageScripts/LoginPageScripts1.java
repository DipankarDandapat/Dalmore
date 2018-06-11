package tracksPageScripts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import genericLib.Constants;
import genericLib.Driver;
import genericLib.ExcelLib;
import genericLib.Log;
import genericLib.Wait;
import pageObjectRepoLib.Login;
import pageObjectRepoLib.Logout;

public class LoginPageScripts1 extends Driver {


	Login loginPage;
	Logout logoutpage;
	ExcelLib eLib;
	
	 private Statement stmt = null;
	 String Query;
	 ResultSet res;
	
	
	@BeforeClass
	public void loginPage()
	{
		Driver.getBrowser();
		Log.info("Browser start");
		loginPage = PageFactory.initElements(driver, Login.class);
		logoutpage=PageFactory.initElements(driver, Logout.class);
		
	}
	
	@BeforeTest
	 public void DBConnection() throws Exception
	 {
	  try{
	   Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dipankar","root","");
	   stmt = con.createStatement();
	  }catch(Exception e)
	  {System.out.println(e.getMessage());}
	 }
	
	
	
	@Test
	 public void tc_1() throws Exception
	 {
	  try{
	  Query = "Select * from login";
	  res = stmt.executeQuery(Query);
	  
	 
	   ArrayList<String> singleAddress = new ArrayList<String>();
	     
	     while(res.next()) //move to the next row in result set, row by row
	     {
	      String userName = res.getString("username");//database Column name
	      String password = res.getString("password");//database Column name
	      singleAddress.add(userName);
	      
	      
	     // Login Methods call
	      loginPage.login_PlatformAdmin(Constants.url, userName, password);
	      
	      Wait.waitForPageToLoad();
	      
	      
	     }
	     
	     
	     System.out.println(singleAddress);
	     
	  }catch(Exception e){System.out.println(e.getMessage());}
	 }
	
	
	
	
	
}
