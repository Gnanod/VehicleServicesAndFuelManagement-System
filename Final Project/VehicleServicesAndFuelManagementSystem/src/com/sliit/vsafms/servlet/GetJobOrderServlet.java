package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sliit.vsafms.model.JobOrder;
import com.sliit.vsafms.model.JobOrderDetails;
import com.sliit.vsafms.service.JobOrderService;
import com.sliit.vsafms.service.impl.JobOrderServiceImpl;

/**
 * Servlet implementation class GetJobOrderServlet
 */
@WebServlet(urlPatterns="/GetJobOrderServlet")
public class GetJobOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetJobOrderServlet() {
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
	 * @throws IOException 
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String value = request.getParameter("value");
		JobOrderService Job = new JobOrderServiceImpl();
		
		System.out.println("JJJJJJJJJJjj"+value);
		
			JobOrderDetails jm=null;
			try {
				jm = Job.getJobOrderDetail(value);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			PrintWriter writer = response.getWriter();
			
			if(jm!=null) {
				
				
				  writer.println("<tr>");
				  writer.println("<td class=\"text-center\">"+jm.getCustomerFName()+"</td>");
				  writer.println("<td class=\"text-center\">"+jm.getVehicleNumber()+"</td>");
				  writer.println("<td class=\"text-center\">"+jm.getModel()+"</td>");
				  writer.println("<td class=\"text-center\">"+jm.getBrand()+"</td>");
				  writer.println("<td class=\"text-center\">"+jm.getBrand()+"</td>");
				  writer.println("</tr>");

	
			}
	
		
			
		
		
		
		
	}

}
