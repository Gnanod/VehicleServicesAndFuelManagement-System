package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.FuelPump;
import com.sliit.vsafms.service.FuelPumpService;
import com.sliit.vsafms.service.impl.FuelPumpServiceImpl;

/**
 * Servlet implementation class AddFuelPumpRepairCostServlet	@author PS
 */
@WebServlet("/AddFuelPumpRepairCostServlet")
public class AddFuelPumpRepairCostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFuelPumpRepairCostServlet() {
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
		
		int pumpID = Integer.parseInt(request.getParameter("FuelPumpID"));
		int fuelID = Integer.parseInt(request.getParameter("FuelID"));
		String upDate = request.getParameter("UpdateDate");
		double cost = Double.parseDouble(request.getParameter("ReCost"));		
		
		LocalDate dd = LocalDate.parse(upDate);
		
		System.out.println("date print : "+dd);
		System.out.println("pump id :"+pumpID);
		System.out.println("fuid id :"+fuelID);
		System.out.println("cost id :"+cost);
		
		FuelPump fuelPump = new FuelPump();
		
		fuelPump.setFuelPumpId(pumpID);
		fuelPump.setFuelId(fuelID);
		fuelPump.setServiceDate(dd);
		fuelPump.setServicePrice(cost);
		
		FuelPumpService fuelPumpService = new FuelPumpServiceImpl();
		
		try {
			boolean isAdd = fuelPumpService.addNewPumpService(fuelPump);
			PrintWriter out =response.getWriter();
			
			if(isAdd == true) {
				System.out.println("Success");
				
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Add Cost' ,  'successfull !' ,  'success' );");
				out.println("});");
				out.println("</script>");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMRepair&Services.jsp");
				  dispatcher.include(request,response);
			}
			
		} catch (SQLException e) {
			PrintWriter out =response.getWriter();
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'WORNING..!' ,  'already added today update' ,  'warning' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMRepair&Services.jsp");
			  dispatcher.include(request,response);
			  
			e.printStackTrace();
		}
	}


}
