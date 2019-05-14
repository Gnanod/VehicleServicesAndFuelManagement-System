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

import com.sliit.vsafms.service.PartManagement;
import com.sliit.vsafms.service.impl.PartManagementImpl;

/**
 * Servlet implementation class DeletePartServlet
 */
@WebServlet("/DeletePartServlet")
public class DeletePartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePartServlet() {
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
		 
		 String partId = request.getParameter("delete");
		 PartManagement pm = new PartManagementImpl();
		 
		
		try {
			 boolean isDeleted=false;
			isDeleted = pm.deletePart(partId);
			PrintWriter writer = response.getWriter();
			
			 if(isDeleted==true) {
				 
				 
				 writer.println("<script>");
				 writer.println("alert('Deleted')");
				 writer.println("</script");
				 
				 RequestDispatcher dispacher = getServletContext().getRequestDispatcher("/addPart.jsp");
				 dispacher.include(request,response);
				
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
	}

}
