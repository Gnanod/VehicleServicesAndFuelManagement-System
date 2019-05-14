package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.Customer;
import com.sliit.vsafms.model.Vehicle;
import com.sliit.vsafms.service.CustomerService;
import com.sliit.vsafms.service.VehicleService;
import com.sliit.vsafms.service.impl.CustomerServiceImpl;
import com.sliit.vsafms.service.impl.VehicleServiceImpl;

/**
 * Servlet implementation class SearchVehicleAjaxServlet @Gnanod
 */
@WebServlet(urlPatterns ="/searchVehicleAjaxServlet")
public class SearchVehicleAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchVehicleAjaxServlet() {
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
		VehicleService vehService = new VehicleServiceImpl();
		try {
			ArrayList<Vehicle> vehList  = vehService.SearchVehicle(searchName);
			ArrayList<Vehicle> custNewList = new ArrayList<Vehicle>();
			
			if(vehList.size()!=0) {
				
				for(Vehicle veh :vehList) {
					  PrintWriter writer =response.getWriter();
					  writer.println("<tr>");
					  writer.println("<td>"+veh.getVehicleNumber()+"</td>");
					  writer.println("<td>"+veh.getEngineNumber()+"</td>");
					  writer.println("<td>"+veh.getVehicleClass()+"</td>");
					  writer.println("<td>"+veh.getVehicleBrand()+"</td>");
					  writer.println("<td>"+veh.getVehicleModel()+"</td>");
					  writer.println("<td>"+veh.getYearOfManufacture()+"</td>");
					  writer.println("<td>"+veh.getDateOfRegistration()+"</td>");
					  writer.println("<td>"+veh.getFuelType()+"</td>");
					  writer.println("</tr>");
				}
				
			}else {
				
				  PrintWriter writer =response.getWriter();
				  writer.println("<tr>");
				  writer.println("<td class=\"alert alert-danger\" colspan=\"8\" style=\"text-align:center\">"+"Vehicle Not Found"+"</td>");
				  writer.println("<tr>");
				
				
				return;
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
