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

import com.sliit.vsafms.model.Part;
import com.sliit.vsafms.service.PartManagement;
import com.sliit.vsafms.service.impl.PartManagementImpl;

/**
 * Servlet implementation class AddPartServlet
 */
@WebServlet("/AddPartServlet")
public class AddPartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPartServlet() {
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
		 
		String name = request.getParameter("pname");
		String quantity = request.getParameter("qty");
		String price = request.getParameter("price");
		String brand = request.getParameter("brand");
		String model = request.getParameter("model");
		String photo = request.getParameter("photo");
		
		Part p = new Part();
		
		p.setPartName(name);
		p.setQty(quantity);
		p.setPrice(price);
		p.setBrand(brand);
		p.setModel(model);
		p.setPhoto(photo);
		
		PartManagement pm = new PartManagementImpl();
		
		
		
		boolean hname=false;
		boolean hquantity=false;
		boolean hprice=false;
		boolean hbrand=false;
		boolean hmodel=false;
		boolean hphoto=false;
		
		if(name.isEmpty()) {

			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Name Field is' ,  'Empty !' ,  'error' );");
			out.println("});");
			out.println("</script>");
			
	 
		}else {
			hname= true;
		}
		if(quantity.isEmpty()) {

			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Quantity Field is' ,  'Empty !' ,  'error' );");
			out.println("});");
			out.println("</script>");
		 
		}else {
			hquantity=true;
		}
		if(price.isEmpty()) {

			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Quantity Field is' ,  'Empty !' ,  'error' );");
			out.println("});");
			out.println("</script>");
			 
		}else {
			hprice=true;
		}
		if(brand.isEmpty()) {

			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Quantity Field is' ,  'Empty !' ,  'error' );");
			out.println("});");
			out.println("</script>");
			 
		}else {
			hbrand=true;
		}
		if(model.isEmpty()) {

			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Quantity Field is' ,  'Empty !' ,  'error' );");
			out.println("});");
			out.println("</script>");
			 
		}else {
			hmodel=true;
		}
		if(photo.isEmpty()) {

			PrintWriter out =response.getWriter();
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Quantity Field is' ,  'Empty !' ,  'error' );");
			out.println("});");
			out.println("</script>");
			 
		}else {
			hphoto=true;
		}
		
		if(hname==true&&hquantity==true&&hprice==true&&hbrand==true&&hmodel==true&&hphoto==true) {
			try {
				boolean isAdded = pm.addNewPart(p);
				PrintWriter writer = response.getWriter();
				
				
				if(isAdded == true) {
					System.out.println("Success");
					
					 writer.println("<script>");
					 writer.println("alert('Added Successfully!!!')");
					 writer.println("</script");
					 
					 RequestDispatcher dispacher = getServletContext().getRequestDispatcher("/addPart.jsp");
					 dispacher.include(request,response);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
		}
		
		
	}

}
