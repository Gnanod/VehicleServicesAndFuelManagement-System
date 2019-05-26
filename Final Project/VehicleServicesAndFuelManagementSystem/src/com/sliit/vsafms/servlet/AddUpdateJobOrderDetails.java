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

import com.sliit.vsafms.service.UpdateJobOrderService;
import com.sliit.vsafms.service.impl.UpdateJobOrderServiceImpl;
import com.sliit.vsafms.util.DBConnection;

/**
 * Servlet implementation class AddUpdateJobOrderDetails
 */
@WebServlet("/AddUpdateJobOrderDetails")
public class AddUpdateJobOrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUpdateJobOrderDetails() {
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


	    Connection conn = DBConnection.getConnection();
		
        
        String id = request.getParameter("id");
        String  jobOrderDescription=  request.getParameter("jobOrderDescription");
        String partsId =request.getParameter("parts_id");
        
        UpdateJobOrderService ujo = new UpdateJobOrderServiceImpl();
        
        try {
			boolean isUpdated  = ujo.updateJobOrder(id,jobOrderDescription);
			if(isUpdated==true) {
				conn.setAutoCommit(false);
				
				boolean isAdded = ujo.AddPartsJobOrder(id,partsId );
				
				if(isAdded) {
					conn.commit();
					PrintWriter out =response.getWriter();
					out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
					out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
					out.println("<script>");
					out.println("$(document).ready(function(){");
					out.println("swal ( 'Job Order Updated SuccessFully' ,  'successfull !' ,  'success' );");
					out.println("});");
					out.println("</script>");
					
					 RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mechanicalEngUI.jsp");
					  dispatcher.include(request,response);
				}else {
					conn.rollback();
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        		
        
	}

}
