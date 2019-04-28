package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.Fuel;
import com.sliit.vsafms.service.FuelService;
import com.sliit.vsafms.service.impl.FuelServiceImpl;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet(urlPatterns="/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
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
		
		String type = request.getParameter("selectedType");
		
		FuelService fuelService = new FuelServiceImpl();   
		String price=null;
        try {
        	
			 price = fuelService.getPrice(type);
			 if(price!=null) {
				 PrintWriter writer =response.getWriter();
				  writer.println("<input type=\"text\" class=\"form-control\" value=\""+price+"\" id=\"input\">");
				  
				
				 
				
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
