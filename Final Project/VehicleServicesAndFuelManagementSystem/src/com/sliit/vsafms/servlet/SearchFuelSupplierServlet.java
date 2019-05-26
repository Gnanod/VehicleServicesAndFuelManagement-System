package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.Supplier;
import com.sliit.vsafms.service.SupplierService;
import com.sliit.vsafms.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class SearchFuelSupplierServlet		@author PS
 */
@WebServlet(urlPatterns ="/SearchFuelSupplierServlet")
public class SearchFuelSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchFuelSupplierServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchName = request.getParameter("searchSupplier");
		
		SupplierService supService = new SupplierServiceImpl();
		
		try {
			Supplier supList  = supService.SearchSupplier(searchName);	
									
			if(supList != null) {				
		 
					  PrintWriter writer =response.getWriter();
					  writer.println("<tr>");
					 // writer.println("<td class=\"text-center\">"+cus.getCustomerID()+"</td>");
					  writer.println("<td>"+supList.getsID()+"</td>");
					  writer.println("<td class=\"text-center\">"+supList.getsName()+"</td>");
					  writer.println("<td class=\"text-center\">"+supList.getsAddress()+"</td>");
					  writer.println("<td class=\"text-center\">"+supList.getsPhone()+"</td>");
					  writer.println("<td class=\"text-center\">"+supList.getsEmail()+"</td>");
					  writer.println("<td class=\"td-actions\" style=\"width:30px\">");
//					  writer.println("<form action=\"UpdateFuelSupplierServlet\" method=\"post\">");
//					  writer.println("<input type=\"hidden\" id=\"DeleteSupplierInput\" name=\"deleteSupplier\" value=\"+supList.getsID()+\"/>");
//					  writer.println("<button type=\"submit\" class=\"btn btn-warning\">UPDATE</button>");
//					  writer.println("</form>");
					  writer.println("</td>");
					  writer.println("<td class=\"td-actions\" style=\"width:30px\">");
					  writer.println("<form action=\"DeleteFuelSupplierServlet\" method=\"post\">");
					  writer.println("<input type=\"hidden\" id=\"DeleteSupplierInput\" name=\"deleteSupplier\" value=\"+supList.getsID()+\"/>");
					  writer.println("<button type=\"submit\" class=\"btn btn-danger\">DELETE</button>");
					  writer.println("</form>");
					  writer.println("</td>");
					  
					  writer.println("</tr>");
								
			}else {
				
				  PrintWriter writer =response.getWriter();
				  writer.println("<tr>");
				  writer.println("<td class=\"alert alert-danger\" colspan=\"4\" style=\"text-align:center\">"+"Customer Not Found"+"</td>");
				  writer.println("<tr>");
				
				
				
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
