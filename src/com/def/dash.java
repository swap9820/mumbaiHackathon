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
import javax.servlet.http.HttpSession;


@WebServlet("/dash")
public class dash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public dash() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String id=(String) session.getAttribute("id");
		
		String itm=request.getParameter("item");
		String icate=request.getParameter("icat");
		String qut=request.getParameter("qut");
		String dis=request.getParameter("dis");
		String prize=request.getParameter("prz");
		String table="";
		
		if(icate.equals("cop")) {
			table="coops";
		}
		if(icate.equals("fer")) {
			table="fertilizar";
		}
		if(icate.equals("sed")) {
			table="seeds";
		}
		
		
String quey="insert into "+table;
quey=quey+" values(?,?,?,?,?,?)";
		System.out.print(icate);
		database b=new database();
		PreparedStatement st;
		java.sql.Connection con;
		try {
			con = b.connect();
			
			 st=con.prepareStatement(quey);
			 
			st.setString(1,itm);
			st.setString(2,id);
			st.setInt(3,Integer.parseInt(qut));
			st.setString(4,dis);
			st.setInt(5,1);
			st.setInt(6,Integer.parseInt(prize));
			
			st.executeUpdate();
			
			
			response.sendRedirect("Dashboard.jsp");
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
