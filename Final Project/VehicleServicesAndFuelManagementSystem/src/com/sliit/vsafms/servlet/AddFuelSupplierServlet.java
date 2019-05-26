package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.Supplier;
import com.sliit.vsafms.service.SupplierService;
import com.sliit.vsafms.service.impl.SupplierServiceImpl;

/**
 * Servlet implementation class AddFuelSupplierServlet		@author PS
 */
@WebServlet("/AddFuelSupplierServlet")
public class AddFuelSupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Supplier supplier;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFuelSupplierServlet() {
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
		String suplierId = request.getParameter("supId");
		String suplierName = request.getParameter("supName");
		String suplierOrg = request.getParameter("supOrg");
		String suplierContact = request.getParameter("supContact");
		String suplierEmail = request.getParameter("supEmail");
		
		Supplier supplier = new Supplier();
		
		supplier.setsID(suplierId);
		supplier.setsName(suplierName);
		supplier.setsAddress(suplierOrg);
		supplier.setsPhone(suplierContact);
		supplier.setsEmail(suplierEmail);
		
		SupplierService supplierService = new SupplierServiceImpl();
		
		String sID = suplierId.substring(0,2);
		System.out.println("Sid : "+sID);
		
		if(sID.equals("FU") ) {
		
		try {
			boolean isAdd = supplierService.addNewSupplier(supplier);
			PrintWriter out = response.getWriter();
			
				if(isAdd == true) {
					System.out.println("Success");
					
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Add New Supplier' ,  'successfull !' ,  'success' );");
					out.println("});");
					out.println("</script>");
					
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMSupplier.jsp");
					  dispatcher.include(request,response);
				}
				
		} catch (SQLException e) {
			PrintWriter out =response.getWriter();
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'INVALID ID or INPUTS.!' ,  'ID must be begin with FU and with three Integers......!  ex:-FU000' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMSupplier.jsp");
			  dispatcher.include(request,response);	
		
			e.printStackTrace();
		}
		
		}else {
			PrintWriter out =response.getWriter();
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'INVALID ID or INPUTS.!hhhh' ,  'ID must be begin with FU and with three Integers......!  ex:-FU000' );");
			out.println("});");
			out.println("</script>");
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FMSupplier.jsp");
			  dispatcher.include(request,response);				
		}

	}

}
