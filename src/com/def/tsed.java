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


@WebServlet("/tsed")
public class tsed extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public tsed() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		
		String quey="select * from fertilizar where id != ?";
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession();

		database b=new database();
		PreparedStatement st;
		ResultSet rs;
		java.sql.Connection con;
		int count=0;
		try {
			con = b.connect();
			
			 st=con.prepareStatement(quey);
			st.setString(1,(String) session.getAttribute("id"));
			
			 rs=st.executeQuery();
			 
			
			 
			

			 out.println("<html><body>");
			 out.println("</br><table cellspacing='0' cellpadding='5' border='1'>");
			 out.println("<tr>");
			 out.println("<th>User Name</th>");
			 out.println("<th>Item name</th>");
			 out.println("<th>Quantity</th>");
			 out.println("<th>prize</th>");
			 out.println("<th>Description</th>");
			 out.println("<th>Message</th>");
			 out.println("</tr>");

			 while(rs.next()) {
			  out.println("<tr>");
			  out.println("<td>"+rs.getString(2) + "</td>");
			  out.println("<td>"+rs.getString(1) + "</td>");
			  out.println("<td>"+rs.getInt(3) + "</td>");
			  out.println("<td>"+rs.getInt(6) + "</td>");
			  out.println("<td>"+rs.getString(4) + "</td>");
			  out.println("<td> <input type=\"button\" value=\"chat\"></td>");
			  out.println("</tr>");

			 }

			 out.println("</table></br></body></html>");
			 
			 
			 
			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  


		
		
		
		
		
		
		
		
	
	}

}
