package com.def;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;




@WebServlet("/chat")
public class chat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public chat() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File f1,f2,cf;
		FileReader fr;
		BufferedReader br;
		HttpSession session=request.getSession();
		String id=(String)session.getAttribute("id");
		String aid="ok";
		String tid="ko";
		String fname1=aid+tid;
		String fname2=tid+aid;
		String line="";
		String uu="",mm="";
		String postion="";
HttpSession tsession=request.getSession();
		
		tsession.setAttribute("tid","ok");
		String iid=session.getAttribute("tid").toString();
		System.out.println("sssss"+iid);
		int u=0;
		PrintWriter out = response.getWriter();
		
		
		try {
			
		 f1=new File("C:\\Users\\FlieNt\\eclipse-workspace\\E-farmer\\src\\com\\def\\"+fname1);
		 
		 f2=new File("C:\\Users\\FlieNt\\eclipse-workspace\\E-farmer\\src\\com\\def\\"+fname2);
		 
		 
		 if(!f1.exists()||!f2.exists()) {
			 
			 boolean fvar = f1.createNewFile();
		     if (fvar){
		          System.out.println("File has been created successfully");
		     }
		     else{
		          System.out.println("File already present at the specified location");
		     }
		 }
		 
			 if(!f1.exists()) {cf=f2; }else{cf=f1;}
			 session.setAttribute("filename",""+cf.getName());
			 
			 fr=new FileReader(cf);
			 br=new BufferedReader(fr);
			 line=br.readLine();
			 
			 response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
			 response.setHeader("Pragma","no-cache");
			 response.setHeader("Expires","0");
			 
 out.println("<html><body>");
			 
 
 
 
			 out.println("<div style=\"border:1px solid;height=100%;width:200px;\"> ");
			
			 
			 while(line!=null) {
			
				// if(line.indexOf(":")) {}
				 
			u=line.indexOf(":");
		
			uu=line.substring(0, u);
			
			
			
			
			if(uu.equals(iid)) 
			{
				
				postion="right";
				//System.out.print("  "+uu);
				
			}
			else 
			{
				//System.out.println("2"+uu+" ."+iid);
				postion="left";
				//System.out.print("  "+uu);
			}
				 
				 
			
			 
			 out.println("<p style=\"text-align:"+postion+"\">"+line.substring(u+1)+"</p>");
			 
			 
				 line=br.readLine();
				 
			 }
		
			 br.close();
			 fr.close();
			 out.print("<form action=\"chat1\" method=\"post\">");
		 out.print("<input type=\"text\" style=\"width:77%\" name=\"mmssg\">");
		 out.print("<input type=\"submit\" value=\"send\"></form>");
		 
			 out.println("</div></body><html>");
		 
		 
		 
		 
		}catch(Exception e) {
			System.out.println(e);
		}
	
	
	}

}
