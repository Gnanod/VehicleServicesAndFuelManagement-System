package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import static java.lang.System.*;
import org.xml.sax.SAXException;

import com.model.Student;
import com.service.StudentService;
import com.service.impl.StudentServiceImpl;

/**
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Student s1 = new Student();
		
		s1.setStdIdNum(request.getParameter("stdId"));
		s1.setStdName(request.getParameter("stdName"));
		s1.setStdAddress(request.getParameter("stdAddress"));
		s1.setStdPhone(request.getParameter("stdPhone"));
		
		StudentService stdService = new StudentServiceImpl();
		boolean status=false;
	//	stdService.addStudent(s1);
		try {
			
		  status =stdService.addStudentSecond(s1);
		  PrintWriter out =response.getWriter();
		  
		  if(status==true) {
			  
			  	out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'WELCOME' ,  'successfull !' ,  'success' );");
				out.println("});");
				out.println("</script>");
				
			  
		
			  RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			  dispatcher.include(request,response);
			  
		  }
		  
		} catch (ClassNotFoundException | SQLException | SAXException | ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		
		
	}

}
