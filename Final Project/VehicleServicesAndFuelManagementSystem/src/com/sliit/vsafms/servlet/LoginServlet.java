package com.sliit.vsafms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sliit.vsafms.model.User;
import com.sliit.vsafms.service.UserService;
import com.sliit.vsafms.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		
		String nic = request.getParameter("nic");
		String password = request.getParameter("password");
		
		User user =  new User();
		
		user.setNic(nic);
		user.setPassword(password);
		
		UserService  userService = new UserServiceImpl();
		
		try {
			HttpSession session = request.getSession();
			
			String checkUserNic = userService.CheckUserNic(user);
			String checkUserPassword1 = userService.CheckUserPassword(user);
			
			if(checkUserNic.equals("error")) {
				session.setAttribute("UserNIC", "Nic is Invalid");								
				response.sendRedirect("login.jsp");
				
			}else if(checkUserPassword1.equals("error")) {
				session.setAttribute("UserPassword", "Password is Invalid");								
				response.sendRedirect("login.jsp");
				
			}
			
			String position = userService.LoginFunction(user);
			
			System.out.println("Position"+position);
			
			if(position.equals("receptionist")) {
				
				session.setAttribute("Login", "Logged");
				session.setAttribute("position", "Reception");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addJobShedule.jsp");
				dispatcher.forward(request, response);
				
				session.removeAttribute("UserNIC");
				session.removeAttribute("UserPassword");
				
			
			}
			
			if(position.equals("fuelManager")) {
				
				session.setAttribute("Login", "Logged");
				session.setAttribute("position", "fuelManager");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/FuelManagementHome.jsp");
				dispatcher.forward(request, response);
				
				session.removeAttribute("UserNIC");
				session.removeAttribute("UserPassword");
			}
			
			if(position.equals("partmanager")) {
				
				session.setAttribute("Login", "Logged");
				
				session.setAttribute("position", "partmanager");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addPart.jsp");
				dispatcher.forward(request, response);
				
				session.removeAttribute("UserNIC");
				session.removeAttribute("UserPassword");
			}
			
			if(position.equals("mechanicalEngineer")) {
				
				session.setAttribute("Login", "Logged");
				session.setAttribute("position", "mechanicalEngineer");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/mechanicalEngUI.jsp");
				dispatcher.forward(request, response);
				
				session.removeAttribute("UserNIC");
				session.removeAttribute("UserPassword");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
