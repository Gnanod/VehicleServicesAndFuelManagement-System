package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.fuelPayment;
import com.sliit.vsafms.service.FuelService;
import com.sliit.vsafms.service.impl.FuelServiceImpl;
import com.sliit.vsafms.util.DBConnection;

/**
 * Servlet implementation class AddPaymentServlet
 */
@WebServlet(urlPatterns="/AddPaymentServlet")
public class AddPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection conn;
    public AddPaymentServlet() {
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
		
    	String total = request.getParameter("total");
		String price =request.getParameter("price");
		String volume= request.getParameter("volume");
		String fuelName = request.getParameter("fuelName");
		
		FuelService fService = new FuelServiceImpl();
		
		
			double beforeUpdateVolume;
			try {
				conn.setAutoCommit(false);
				beforeUpdateVolume = fService.searchVolume(fuelName);
				
				double newvolume=beforeUpdateVolume-Double.parseDouble(volume);
				  
				boolean isUpdated = fService.updateVolume(newvolume,fuelName);
				
				if(isUpdated) {
					conn.commit();
						
					fuelPayment pay = new fuelPayment();
					pay.setTotalPrice(Double.parseDouble(price));
					pay.setVolume(Double.parseDouble(volume));
					
					boolean addPayment = fService.addPayment(pay);
					int paymentId = fService.getPaymentLastId();
					pay.setPaymentId(paymentId);
					boolean addFuelPayment = fService.addFuelPayment(pay);
					
					PrintWriter out =response.getWriter();
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Payment Is ' ,  'successfull !' ,  'success' );");
					out.println("});");
					out.println("</script>");
					
					
				}else {
					conn.rollback();
					PrintWriter out =response.getWriter();
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Oops.. Payement' ,  'Fail !' ,  'error' );");
					out.println("});");
					out.println("</script>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
	
		
		
	}

}
