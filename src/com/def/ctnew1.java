package com.def;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ctnew1")
public class ctnew1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ctnew1() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		 out.println("<html><body>");
		 
		 out.println(" <input type = \"file\" name = \"file\" size = \"50\" />");
		 
		 
		 out.println("</html></body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
