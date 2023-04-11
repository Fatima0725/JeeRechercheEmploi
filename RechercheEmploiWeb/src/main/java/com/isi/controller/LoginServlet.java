package com.isi.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.isi.dao.CvLocal;
import com.isi.entities.Cv;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="login", urlPatterns={"/login"} )
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private CvLocal local;
       
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Cv cv = local.findByEmailAndPassword(email, password);
		
		String action = request.getParameter("action");
		if(action.equals("Login")) {
			if(email.equals("admin@gmail.com") && password.equals("admin")) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect(request.getContextPath() + "/include/view/admin.jsp");
			}
			if(cv != null) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				response.sendRedirect(request.getContextPath() + "/include/view/home.jsp");
				
			}else {
			
				request.setAttribute("errorMessage", "Email ou mot de passe incorrect");
				request.setAttribute("typemsg", "error");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
