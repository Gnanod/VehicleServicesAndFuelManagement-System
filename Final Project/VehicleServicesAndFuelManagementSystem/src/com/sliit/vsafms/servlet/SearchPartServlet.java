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

import com.sliit.vsafms.model.Customer;
import com.sliit.vsafms.model.Part;
import com.sliit.vsafms.service.PartManagement;
import com.sliit.vsafms.service.impl.PartManagementImpl;

/**
 * Servlet implementation class SearchPartServlet
 */
@WebServlet(urlPatterns="/SearchPartServlet")
public class SearchPartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPartServlet() {
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
		  
		String searchname = request.getParameter("searchPartName");
		
		PartManagement pm = new PartManagementImpl();
		
		try {
			Part s = pm.getPartDetails(searchname);
			
			if(s!=null) {
				
				
					  PrintWriter writer =response.getWriter();
					  writer.println("<tr>");
					 // writer.println("<td class=\"text-center\">"+cus.getCustomerID()+"</td>");
					  writer.println(" <td><div class=\"img-container\"><img src=\""+s.getPhoto()+"\" alt=\"...\"></div></td>");
					   
					  writer.println("<td>"+s.getPartName()+"</td>");
					  writer.println("<td>"+s.getBrand()+"</td>");
					  writer.println("<td>"+s.getModel()+"</td>");
					  writer.println("<td>"+s.getQty()+"</td>");
					  writer.println("<td>"+s.getPrice()+"</td>");
					  writer.println("<td class=\"td-actions\">");
					  writer.println("<button type=\"button\" rel=\"tooltip\" data-placement=\"left\" title=\"Remove item\" class=\"btn btn-simple\">\r\n" + 
					  		"                                                    <i class=\"material-icons\">close</i>\r\n" + 
					  		" </button>");
					  writer.println("</td>");
					  writer.println("</tr>");
			
					   
			}else {
				
				  PrintWriter writer =response.getWriter();
				  writer.println("<tr>");
				  writer.println("<td class=\"alert alert-danger\" colspan=\"4\" style=\"text-align:center\">"+"Part Not Found"+"</td>");
				  writer.println("<tr>");
				
				
				return;
			}
			//request.setAttribute("Part", pm);
			
		//	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addPart.jsp");
			//dispatcher.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
