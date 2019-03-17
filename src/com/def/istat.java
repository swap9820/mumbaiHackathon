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


@WebServlet("/istat")
public class istat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public istat() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		

		String quey="select * from coops where id = ?";
	
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
			 
			
			 
			

			 out.println("<html><head><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
			 		"<link rel=\"stylesheet\" href=\"https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css\">\r\n" + 
			 		"<script src=\"https://code.jquery.com/jquery-1.11.3.min.js\"></script>\r\n" + 
			 		"<script src=\"https://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js\"></script></>");
			 
			 out.println("<html><body>");
			 
			 
			 out.println("</br><table cellspacing='0' cellpadding='5' border='1'>");
			 out.println("<tr>");
			// out.println("<th>User Name</th>");
			 out.println("<th>Item name</th>");
			 out.println("<th>Quantity</th>");
			 out.println("<th>prize</th>");
			 out.println("<th>Description</th>");
			 out.println("<th>Action</th>");
			 out.println("<th border=\"white\"></th>");
			 //out.println("<th>Message</th>");
			 out.println("</tr>");
			 
			 out.println("<form action=\"delentry\" method=\"post\">");
			 while(rs.next()) {
			  out.println("<tr>");
			  //out.println("<td>"+rs.getString(2) + "</td>");
			  out.println("<td>"+rs.getString(1) + "</td>");
			  out.println("<td>"+rs.getInt(3) + "</td>");
			  out.println("<td>"+rs.getInt(6) + "</td>");
			  out.println("<td>"+rs.getString(4) + "</td>");
			  out.println("<td> <button>Edit</buttton> </td>");
			  
			 
			  
			  out.println("<td> <input type=\"submit\" value=\"remove\"> </td> </form>");
			  
			 // out.println("<td> <a href=\"delentry\"><button>remove</button></a></td>");
			 
			  
			  /* out.println("<td> <div data-role=\"main\" class=\"ui-content\">\r\n" + 
			  		"    <a href=\"#myPopup\" data-rel=\"popup\" class=\"ui-btn ui-btn-inline ui-corner-all\">Chat</a>\r\n" + 
 			  		"    <div data-role=\"popup\" id=\"myPopup\" style=\"width:250px\" class=\"ui-content\">\r\n" + 
			  		"      <a href=\"istat\" class=\"ui-btn ui-corner-all ui-shadow ui-btn ui-icon-delete ui-btn-icon-notext ui-btn-right\">Close</a>\r\n" + 
			  		"      <iframe src=\"chat\"  style=\"width:100%;height:300px\">\r\n" + 
			  		"  <p>Your browser does not support iframes.</p>\r\n" + 
			  		"</iframe>\r\n" + 
			  		"      \r\n" + 
			  		"    </div>\r\n" + 
			  		"  </div></td>");*/
			  out.println("</tr>");

			 }

			 out.println("</table></br></body></html>");
			 
			 
			 
			 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
