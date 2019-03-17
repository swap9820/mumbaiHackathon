package com.def;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/dash1")
public class dash1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public dash1() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doPost(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		
		String quey="select * from uinfo where Phoneno = ?";
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();

		database b=new database();
		PreparedStatement st;
		ResultSet rs;
		java.sql.Connection con;
		int count=0;
		try {
			con = b.connect();
			
			System.out.println("Done"+session.getAttribute("id"));
			 st=con.prepareStatement(quey);
			st.setInt(1, Integer.parseInt((String)session.getAttribute("id")));
			System.out.println("Done2");
			 rs=st.executeQuery();
			 
			 System.out.println("Done4");
			 rs.next();
			 System.out.print(""+rs.getString(1));
			 System.out.println("Done5");
			 
			 session.setAttribute("fname",rs.getString(1));
			 session.setAttribute("lname",rs.getString(2));
			 session.setAttribute("Phoneno",rs.getString(3));
			 session.setAttribute("state",rs.getString(4));
			 session.setAttribute("pin",rs.getString(6));
			 session.setAttribute("photos",rs.getString(7));
			 
			 System.out.println(rs.getString(7));
			 
			 
			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  


		
		
		
		
		response.sendRedirect("Dashboard.jsp");
		
		
		
		
		
		
	}

}
