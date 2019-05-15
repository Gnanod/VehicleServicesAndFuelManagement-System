package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.Fuel;
import com.sliit.vsafms.service.FuelService;
import com.sliit.vsafms.service.impl.FuelServiceImpl;

/**
 * Servlet implementation class UpdateFuelPriceServlet		@author PS
 */
@WebServlet("/UpdateFuelPriceServlet")
public class UpdateFuelPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFuelPriceServlet() {
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
		
		String fuelName = request.getParameter("UpdateFuelPrice");
//		String priceIn = request.getAttribute("updatePriceIn");
		//String price = request.getParameter("updatPrice");
		double price = Double.parseDouble(request.getParameter("updatPrice"));
		LocalDate updateDate = (java.time.LocalDate.now());
		System.out.println("updatPrice"+price);
		System.out.println("Price1213123"+fuelName);
		System.out.println("date :"+java.time.LocalDate.now());
//		int fID = Integer.parseInt(fuelID);	
//		Double fPrice = Double.parseDouble(priceIn);
		
		Fuel fuelDetail = new Fuel();
		
		fuelDetail.setPrice(price);
		fuelDetail.setFuleName(fuelName);
		
		FuelService fuel = new FuelServiceImpl();
		
		try {
			boolean updatePrice = fuel.updateFuelPrice(fuelName, price, updateDate);
			PrintWriter out =response.getWriter();
			
				if(updatePrice == true) {
					
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Update' ,  'successfull !' ,  'success' );");
					out.println("});");
					out.println("</script>");
								
				 
			
				  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMUpdatePrice.jsp");
				  dispatcher.include(request,response);
				  
				}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
