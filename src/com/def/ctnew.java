package com.def;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ctnew
 */
@WebServlet("/ctnew")
public class ctnew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ctnew() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String pass=request.getParameter("pass");
		String phn=request.getParameter("phn");
		String state=request.getParameter("state");
		String add=request.getParameter("add");
		String pin=request.getParameter("pin");
		
String quey="insert into uinfo values(?,?,?,?,?,?)";
		
		database b=new database();
		PreparedStatement st,t;
		ResultSet rs;
		java.sql.Connection con;
		try {
			con = b.connect();
			
			 st=con.prepareStatement(quey);
			 
			st.setString(1,fname);
			st.setString(2,lname);
			
			st.setInt(3,Integer.parseInt(phn));
			st.setString(4,state);
			st.setString(5,add);
			st.setInt(6,Integer.parseInt(pin));
			
			st.executeUpdate();
			System.out.print("Done");
			

		
			 quey="insert into login values(?,?)";
			t=con.prepareStatement(quey);
			System.out.print("2");
			t.setInt(1,Integer.parseInt(phn));
			System.out.print("3");
			t.setString(2,pass);
			System.out.print("4");
			t.executeUpdate();
			System.out.print("5");
			
			
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		response.sendRedirect("ctnew1");
		
	}

}
