package com.def;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.pept.transport.Connection;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public login() {
        super();
      
    }

	
	public void init(ServletConfig config) throws ServletException {
		
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String Phone=request.getParameter("Phone");
		String pass=request.getParameter("pass");
		
		
		
		String quey="select * from login where phone=? and password=?";
		
		database b=new database();
		PreparedStatement st;
		ResultSet rs;
		java.sql.Connection con;
		try {
			con = b.connect();
			
			 st=con.prepareStatement(quey);
			st.setString(1,Phone);
			st.setString(2,pass);
			
			 rs=st.executeQuery();
			 
			 
			 
			 if(rs.next()) {
				 
					//System.out.println("Finded");
					HttpSession session=request.getSession();
					session.setAttribute("id",Phone);
					 response.sendRedirect("dash1");
					
				}
			 
			 else {
				 
				 response.sendRedirect("index.html");
			 }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}

}
