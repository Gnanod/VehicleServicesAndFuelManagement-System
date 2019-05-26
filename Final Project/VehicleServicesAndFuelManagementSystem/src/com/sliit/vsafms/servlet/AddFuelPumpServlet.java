package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.FuelPump;
import com.sliit.vsafms.model.Supplier;
import com.sliit.vsafms.service.FuelPumpService;
import com.sliit.vsafms.service.SupplierService;
import com.sliit.vsafms.service.impl.FuelPaymentServiceImpl;
import com.sliit.vsafms.service.impl.FuelPumpServiceImpl;
import com.sliit.vsafms.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class AddFuelPumpServlet
 */
@WebServlet("/AddFuelPumpServlet")
public class AddFuelPumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFuelPumpServlet() {
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

		String fName = request.getParameter("selFul");
		System.out.println(fName);
		
		
		
		FuelPumpService fuelPumpService = new FuelPumpServiceImpl();
		
		try {
			int pump = Integer.parseInt(fuelPumpService.getFuelPump(fName));
			System.out.println("wwwwww"+pump);
			
			FuelPump fuel = new FuelPump();		
			fuel.setFuelName(fName);		
			fuel.setFuelId(pump);
		
			boolean isAdd = fuelPumpService.addNewFuelPump(fuel);
			
				if(isAdd == true) {
					
					PrintWriter out = response.getWriter();
					
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Add New Pump' ,  'successfull !' ,  'success' );");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMFuelPump.jsp");
					  dispatcher.include(request,response);
				}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
					
				
		
	}

}
