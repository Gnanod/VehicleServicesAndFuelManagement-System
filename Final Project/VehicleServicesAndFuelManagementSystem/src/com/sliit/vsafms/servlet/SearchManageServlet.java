package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.Customer;
import com.sliit.vsafms.model.Part;
import com.sliit.vsafms.service.CustomerService;
import com.sliit.vsafms.service.PartService;
import com.sliit.vsafms.service.impl.CustomerServiceImpl;
import com.sliit.vsafms.service.impl.PartServiceImpl;

/**
 * Servlet implementation class SearchManageServlet
 */
@WebServlet(urlPatterns ="/SearchManageServlet")
public class SearchManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		 
		 String searchPart  = request.getParameter("part"); 
		 PartService ptService = new PartServiceImpl();
		 System.out.println("SearchPart"+searchPart);
		 try {
			Part p = ptService.getPart(searchPart);
			
			if(p!=null) {
				PrintWriter writer = response.getWriter();
				
				 writer.println("<tr>");
				 
				 	writer.println("<td class=\"text-center\">"+p.getPartId()+"</td>");
					writer.println("<td class=\"text-center\">"+p.getPartName()+"</td>");
					writer.println("<td class=\"text-center\"> ");
					
					writer.println("<input type=\"submit\" onclick=\"AddProductIdfunction("+p.getPartId()+")\"class=\"btn btn-primary\" class=\"btn btn_success\" value=\"AddParts\">");
					writer.println("</td>");
					writer.println("</tr>");
				
				
				
			}else {
				
				PrintWriter writer =response.getWriter();
				  writer.println("<tr>");
				  writer.println("<td class=\"alert alert-danger\" colspan=\3\" style=\"text-align:center\">"+"Part Not Found"+"</td>");
				  writer.println("<tr>");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}
