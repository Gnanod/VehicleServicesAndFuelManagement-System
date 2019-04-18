package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sliit.vsafms.model.BreakDownJobOrder;
import com.sliit.vsafms.model.Customer;
import com.sliit.vsafms.model.Vehicle;
import com.sliit.vsafms.service.BreakDownJobOrderService;
import com.sliit.vsafms.service.CustomerService;
import com.sliit.vsafms.service.VehicleService;
import com.sliit.vsafms.service.impl.BreakDownJobOrderServiceImpl;
import com.sliit.vsafms.service.impl.CustomerServiceImpl;
import com.sliit.vsafms.service.impl.VehicleServiceImpl;
import com.sliit.vsafms.util.DBConnection;

/**
 * Servlet implementation class AddSpecialJobOrderServlet
 */
@WebServlet( urlPatterns="/AddSpecialJobOrderServlet")
public class AddSpecialJobOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection conn;
    public AddSpecialJobOrderServlet() {
        super();
        conn = DBConnection.getConnection();
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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String nic = request.getParameter("nic");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		String arr=  request.getParameter("favorite");
		String[] myJsonData = request.getParameterValues("favorite");
		
		
		try {
			
			JSONObject ob = new JSONObject(request.getParameter("favorite"));
			Iterator it =  ob.keys(); //gets all the keys
			while(it.hasNext())
			{
			    String key = (String) it.next(); // get key
			   
					Object o = ob.get(key);
					 System.out.println("oooo"+o);
				 // get value
			    
			   
			  //  session.putValue(key, o); // store in session
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
//		boolean bfname=false;
//		boolean blname=false;
//		boolean bnic=false;
//		boolean baddress=false;
//		boolean bemail=false;
//		boolean bphone=false;
//		
//		boolean fVehicleNumber=false;
//		boolean fengineNumber = false;
//		boolean fVehicleClass = false;
//		boolean fbrand = false;
//		boolean fmodel = false;
//		boolean freg = false;
//		boolean fmanuYear = false;
//		boolean ffuel = false;
//		boolean fproblem = false;
//		
//		if(fname.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'FirstName Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			bfname=true;
//		}
//		
//		if(lname.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'SecondName Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			blname=true;
//		}
//		
//		
//		if(nic.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Nic Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			bnic=true;
//		}
//		
//		if(address.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Address Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			baddress=true;
//		}
//		
//		
//		
//		if(email.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Email Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			bemail=true;
//		}
//		
//		if(phone.matches("\\d{3}-\\d{7}")) {
//
//			bphone=true;
//			
//		}else {
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Phone Number is Invalid' ,  '(xxx-xxxxxxx)' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//			
//		}
//		
//		String vehicleNumber = request.getParameter("vehicleNumber");
//		String engineNumber = request.getParameter("EngineNumber");
//		String vehicleClass = request.getParameter("VehicleClass");
//		String brand = request.getParameter("brand");
//		String model = request.getParameter("Model");
//		String yearOfManufacture = request.getParameter("Yearofmanufacture");
//		String dateOfRegistration = request.getParameter("Dateofregistration");
//		String fuelType = request.getParameter("Fueltype");
//		String problem= request.getParameter("message");
//		
//		if(vehicleNumber.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Vehicle Number Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			fVehicleNumber=true;
//		}
//		
//		if(engineNumber.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Engine Number Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			fengineNumber=true;
//		}
//		
//		if(vehicleClass.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'VehicleClass Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			fVehicleClass=true;
//		}
//		
//		if(brand.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Vehicle Brand Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			fbrand=true;
//		}
//		
//		if(model.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Vehicle Model Field is' ,  'Empty !' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			fmodel=true;
//		}
//		
//		
//		
//		if(yearOfManufacture.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Manufacture Year Field is' ,  'Empty ' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//		}else {
//			fmanuYear=true;
//		}
//		
//		if(dateOfRegistration.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Registration Date Field is' ,  'Empty Or Invalid(XXXX)' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//			
//		}else {
//			freg=true;
//		}
//		if(fuelType.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Fuel Field is' ,  'Empty Or Invalid(XXXX)' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//			
//		}else {
//			ffuel=true;
//		}
//		
//
//		if(problem.isEmpty()) {
//
//			PrintWriter out =response.getWriter();
//			out.println("<script>");
//			out.println("$(document).ready(function(){");
//			out.println("swal ( 'Problem Field is' ,  'Empty Or Invalid(XXXX)' ,  'error' );");
//			out.println("});");
//			out.println("</script>");
//			
//		}else {
//			fproblem=true;
//		}
//		
//		Customer cus = new Customer();
//		cus.setCustomerFName(fname);
//		cus.setCustomerLName(lname);
//		cus.setCustomerAddress(address);
//		cus.setCustomerNic(nic);
//		cus.setCustomerPhone(phone);
//		cus.setCustomerEmail(email);
//		
//		
//		Vehicle veh = new Vehicle();
//		veh.setDateOfRegistration(dateOfRegistration);
//		veh.setEngineNumber(engineNumber);
//		veh.setFuelType(fuelType);
//		veh.setVehicleBrand(brand);
//		veh.setVehicleModel(model);
//		veh.setYearOfManufacture(yearOfManufacture);
//		veh.setVehicleNumber(vehicleNumber);
//		veh.setVehicleClass(vehicleClass);
//		
//		BreakDownJobOrder bo = new BreakDownJobOrder();
//		bo.setJobOrderDescription(problem);
//		bo.setJobOrderStatus("UnAssigned");
//		
//		BreakDownJobOrderService service = new BreakDownJobOrderServiceImpl();
//		CustomerService cusService = new CustomerServiceImpl();
//		VehicleService vehService = new VehicleServiceImpl();
//			
//		
//		System.out.println(fVehicleNumber);
//		System.out.println(fengineNumber);
//		System.out.println(fVehicleClass);
//		System.out.println(fbrand);
//		System.out.println(fmodel);
//		System.out.println(freg);
//		System.out.println(fmanuYear);
//		System.out.println(ffuel);
//		System.out.println(fproblem);
//		
//		
//		if(bfname==true&&blname==true&&bnic==true&&baddress==true&&bemail==true&&bphone==true&&fVehicleNumber==true&&fengineNumber==true&&fVehicleClass==true&&fbrand==true&&fmodel==true&&freg==true&&fmanuYear==true&&ffuel==true&&fproblem==true) {
//			try {
//				int number1= cusService.searchExcistingCustomer(nic);
//				int number2 = vehService.searchExcistingVehicle(vehicleNumber);
//				
//				System.out.println(number1);
//				System.out.println(number2);
//				boolean cusStatus = false;
//				boolean vehStatus = false;
//				if(number1!=0) {
//					cusStatus=true;
//				}
//				if(number2!=0) {
//					vehStatus=true;
//				}
//			
//				if(cusStatus==true && vehStatus==true) {
//					
//					int idNumber = cusService.getCustomerId(nic);
//					boolean status1 = service.addBreakDownServiceJobOrder(bo,idNumber);
//					
//					System.out.println("Status1111"+status1);
//					if(status1==true) {
//						
//						PrintWriter out =response.getWriter();
//						out.println("<script>");
//						out.println("$(document).ready(function(){");
//						out.println("swal ( 'Job Order Added' ,  'successfull !' ,  'success' );");
//						out.println("});");
//						out.println("</script>");
//						
//					}else {
//						
//						PrintWriter out =response.getWriter();
//						out.println("<script>");
//						out.println("$(document).ready(function(){");
//						out.println("swal ( 'Added' ,  'Fail !' ,  'error' );");
//						out.println("});");
//						out.println("</script>");
//					}
//				}
//				
//				if(cusStatus==false && vehStatus==false) {
//					conn.setAutoCommit(false);
//					
//					boolean status1 = cusService.addNewCustomer(cus);
//					int lastId = cusService.lastId();
//					boolean status2 = vehService.addNewVehicle(veh,lastId);
//					
//					if(status1==true && status2==true) {
//						conn.commit();
//						boolean status3 = service.addBreakDownServiceJobOrder(bo, lastId);
//							if(status3==true) {
//								
//								PrintWriter out =response.getWriter();
//								out.println("<script>");
//								out.println("$(document).ready(function(){");
//								out.println("swal ( 'Job Order Added' ,  'successfull !' ,  'success' );");
//								out.println("});");
//								out.println("</script>");
//							}else {
//								PrintWriter out =response.getWriter();
//								out.println("<script>");
//								out.println("$(document).ready(function(){");
//								out.println("swal ( 'Oops.. Added' ,  'Fail !' ,  'error' );");
//								out.println("});");
//								out.println("</script>");
//							}
//					}else {
//					conn.rollback();
//					
//					PrintWriter out =response.getWriter();
//					out.println("<script>");
//					out.println("$(document).ready(function(){");
//					out.println("swal ( 'Oops.. Added' ,  'Fail !' ,  'error' );");
//					out.println("});");
//					out.println("</script>");
//					}
//				}
//				//boolean status = service.addBreakDownService(cus,veh,bo);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}finally {
//				try {
//					conn.setAutoCommit(true);
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
	}

}
