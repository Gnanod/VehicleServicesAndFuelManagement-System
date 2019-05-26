package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.Customer;
import com.sliit.vsafms.service.CustomerService;
import com.sliit.vsafms.service.impl.CustomerServiceImpl;

/**
 * Servlet implementation class searchCustomerAjaxServlet
 */
@WebServlet(urlPatterns ="/searchCustomerAjax")
public class searchCustomerAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchCustomerAjaxServlet() {
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
		
		String searchName = request.getParameter("searchName");
		System.out.println("GGGGG"+searchName);
		CustomerService cusService = new CustomerServiceImpl();
		try {
			ArrayList<Customer> custList  = cusService.SearchCustomer(searchName);
			
			
			
			ArrayList<Customer> custNewList = new ArrayList<Customer>();
			
			if(custList.size()!=0) {
				
				for(Customer cus :custList) {
					  PrintWriter writer =response.getWriter();
					  writer.println("<tr>");
					 // writer.println("<td class=\"text-center\">"+cus.getCustomerID()+"</td>");
					  writer.println("<td>"+cus.getCustomerFName()+"</td>");
					  writer.println("<td>"+cus.getCustomerLName()+"</td>");
					  writer.println("<td>"+cus.getCustomerPhone()+"</td>");
					  writer.println("<td>"+cus.getCustomerNic()+"</td>");
					  writer.println("<td>"+cus.getCustomerEmail()+"</td>");
					  writer.println("<td>"+cus.getCustomerAddress()+"</td>");
					  writer.println("</tr>");
				}
				
			}else {
				
				  PrintWriter writer =response.getWriter();
				  writer.println("<tr>");
				  writer.println("<td class=\"alert alert-danger\" colspan=\"6\" style=\"text-align:center\">"+"Customer Not Found"+"</td>");
				  writer.println("<tr>");
				
				
				return;
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
