package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.Fuel;
import com.sliit.vsafms.service.FuelService;
import com.sliit.vsafms.service.impl.FuelServiceImpl;
import com.sliit.vsafms.util.DBConnection;

/**
 * Servlet implementation class UpdateFuelStockServlet		@author PS
 */
@WebServlet("/UpdateFuelStockServlet")
public class UpdateFuelStockServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private Connection conn;
    public UpdateFuelStockServlet() {
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
		
		//String quantity = request.getParameter("fuelQuentity");
		double quantity = Double.parseDouble(request.getParameter("fuelQuentity"));
		String fuelName = request.getParameter("FuelName");
		
		System.out.println("fQty : "+quantity);
		System.out.println("fName : "+fuelName);
		
		Fuel UpdatefuelQty = new Fuel();
		
		UpdatefuelQty.setQty(quantity);
		UpdatefuelQty.setFuleName(fuelName);
		
		FuelService fuelService = new FuelServiceImpl();	
		try {
			double QTT = fuelService.getCurrentQty(quantity, fuelName);
			
			
			if(quantity == 3300) {
				if(QTT < 11700) {
					
					try {				
						boolean isUpdated = fuelService.updateFuelStock(quantity, fuelName, QTT);
						
						PrintWriter out =response.getWriter();
						
						if(isUpdated == true) {							
							
							out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
							out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
							out.println("<script>");
							out.println("$(document).ready(function(){");
							out.println("swal ( 'Stock Update' ,  'successfull !' ,  'success' );");
							out.println("});");
							out.println("</script>");	
							
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMStock.jsp");
							 dispatcher.include(request,response);
							
							
						}else {
							conn.rollback();
							
							out.println("<script>");
							out.println("$(document).ready(function(){");
							out.println("swal ( 'Oops.. FuelStockUpdate' ,  'Fail !' ,  'error' );");
							out.println("});");
							out.println("</script>");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
					PrintWriter out =response.getWriter();
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Can not Update' ,  'Input Fuel Volume is greater than the remaining Tank Volume..... Max Volume is 15000 Liters' );");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMStock.jsp");
					 dispatcher.include(request,response);					
				}
				
			}else if(quantity == 6600) {
				if(QTT < 8400) {
					
					try {				
						boolean isUpdated = fuelService.updateFuelStock(quantity, fuelName, QTT);
						
						PrintWriter out =response.getWriter();
						
						if(isUpdated == true) {							
							
							out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
							out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
							out.println("<script>");
							out.println("$(document).ready(function(){");
							out.println("swal ( 'Stock Update' ,  'successfull !' ,  'success' );");
							out.println("});");
							out.println("</script>");	
							
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMStock.jsp");
							 dispatcher.include(request,response);
							
							
						}else {
							conn.rollback();
							
							out.println("<script>");
							out.println("$(document).ready(function(){");
							out.println("swal ( 'Oops.. FuelStockUpdate' ,  'Fail !' ,  'error' );");
							out.println("});");
							out.println("</script>");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
					PrintWriter out =response.getWriter();
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Can not Update' ,  'Input Fuel Volume is greater than the remaining Tank Volume..... Max Volume is 15000 Liters' );");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMStock.jsp");
					 dispatcher.include(request,response);					
				}
				
			}else if(quantity == 13200) {
				if(QTT < 1800) {
					
					try {				
						boolean isUpdated = fuelService.updateFuelStock(quantity, fuelName, QTT);
						
						PrintWriter out =response.getWriter();
						
						if(isUpdated == true) {							
							
							out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
							out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
							out.println("<script>");
							out.println("$(document).ready(function(){");
							out.println("swal ( 'Stock Update' ,  'successfull !' ,  'success' );");
							out.println("});");
							out.println("</script>");	
							
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMStock.jsp");
							 dispatcher.include(request,response);
							
							
						}else {
							conn.rollback();
							
							out.println("<script>");
							out.println("$(document).ready(function(){");
							out.println("swal ( 'Oops.. FuelStockUpdate' ,  'Fail !' ,  'error' );");
							out.println("});");
							out.println("</script>");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
					PrintWriter out =response.getWriter();
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Can not Update' ,  'Input Fuel Volume is greater than the remaining Tank Volume..... Max Volume is 15000 Liters' );");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMStock.jsp");
					 dispatcher.include(request,response);					
				}
			}
				
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
				try {
					conn.setAutoCommit(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
	}

}
