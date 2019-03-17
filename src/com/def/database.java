package com.def;

import java.io.PrintWriter;
import java.sql.*;


public class  database {
	public  Connection con;
	public  Connection connect() throws SQLException{
		
	try {
Class.forName("com.mysql.jdbc.Driver");

 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/e_farmer","root","root");
	}catch(Exception e) {}
	
	
	/*String quey="select * from logi where uname=? and pass=?";
	PreparedStatement st=con.prepareStatement(quey);
	st.setString(1,"root");
	st.setString(2, "root");
	
	
	ResultSet rs=st.executeQuery();
	
	if(rs.next()) {
		 

		System.out.println("Finded");
		
	}
	*/
	
	
	
	
	return con;
	
	}
	
}



