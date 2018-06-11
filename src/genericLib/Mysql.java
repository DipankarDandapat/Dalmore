package genericLib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;




public class Mysql {
	
	

	public Object[][] getData() throws ClassNotFoundException, SQLException  {
		
		Class.forName("com.mysql.jdbc.Driver");  

		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dipankar","root","");
		
		Statement stmt=con.createStatement();  

		ResultSet rs=stmt.executeQuery("select * from dipankar.login"); 
		
		
		
		
		ArrayList arr=new ArrayList();
		while(rs.next()) {
			
			
			String userName= rs.getString(2);
		    String passWord=rs.getString(3);
		    
		    arr.add(userName);
		    arr.add(passWord);
		    
		}
		System.out.println(arr);
		 
		
		return null;

	}
   

}