package com.def;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/chat1")
public class chat1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public chat1() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out =response.getWriter();
		HttpSession session=request.getSession();
		String me=(String) session.getAttribute("tid");
		String fnm=(String) session.getAttribute("filename");
		String msg=request.getParameter("mmssg");
		//File f;
		
		FileWriter fw=new FileWriter("C:\\Users\\FlieNt\\eclipse-workspace\\E-farmer\\src\\com\\def\\"+fnm,true);    
         
        
        BufferedWriter br = new BufferedWriter(fw);
        PrintWriter pr = new PrintWriter(br);
       // pr.println();
        pr.println(me+":"+msg);
        pr.close();
        br.close();
        fw.close();
        System.out.print("Done msg:"+msg+" id:"+me+" name"+fnm+"  ");
        response.sendRedirect("chat");
		
	}

}
