package com.sliit.vsafms.servlet;

import java.io.IOException;
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
 * Servlet implementation class SearchCustomerServlet
 */
@WebServlet("/searchCustomerAjaxServlet")
public class SearchCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchCustomerServlet() {
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
		// TODO Auto-generated method stub
//		String searchName = request.getParameter("searchName");
//		
//		CustomerService cusService = new CustomerServiceImpl();
//		
//		try {
//			ArrayList<Customer> custList  = cusService.SearchCustomer(searchName);
//			
//			if(custList.size()==0) {
//				System.out.println("rrrrrrrrrrrrrrrrrrrr");
//			}
//			
//			ArrayList<Customer> custNewList = new ArrayList<Customer>();
//			
//			if(custList.size()!=0) {
//				
//				
//				
//				for(Customer cus :custList) {
//					Customer c = new Customer();
//					c.setCustomerID(cus.getCustomerID());
//					c.setCustomerAddress(cus.getCustomerAddress());
//					c.setCustomerEmail(cus.getCustomerEmail());
//					c.setCustomerFName(cus.getCustomerFName());
//					c.setCustomerLName(cus.getCustomerLName());
//					c.setCustomerNic(cus.getCustomerNic());
//					c.setCustomerPhone(cus.getCustomerPhone());
//					custNewList.add(c);
//				}
//				
//				request.setAttribute("customer",custNewList);
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addJobShedule.jsp");
//				dispatcher.forward(request, response);
//				return;
//			}else {
//				
//				String message = "Customer Not Found";
//				request.setAttribute("message", message);
//				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addJobShedule.jsp");
//				dispatcher.forward(request, response);
//				
//				return;
//			}
//			
//			
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
