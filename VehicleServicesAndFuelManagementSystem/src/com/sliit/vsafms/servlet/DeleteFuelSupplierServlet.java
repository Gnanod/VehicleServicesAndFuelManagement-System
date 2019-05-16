package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.service.SupplierService;
import com.sliit.vsafms.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class DeleteFuelSupplierServlet		@author PS
 */
@WebServlet("/DeleteFuelSupplierServlet")
public class DeleteFuelSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFuelSupplierServlet() {
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
		
		String supId = request.getParameter("deleteSupplier");		
		SupplierService sup = new SupplierServiceImpl();
		
		try {
			boolean deletesup = sup.deleteSupplier(supId);
			PrintWriter out =response.getWriter();
			
			if(deletesup==true) {
				  
			  	out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Delete' ,  'successfull !' ,  'success' );");
				out.println("});");
				out.println("</script>");
				
			  
		
			  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMSupplier.jsp");
			  dispatcher.include(request,response);
		  }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
