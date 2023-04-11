package com.isi.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class AccessControlServlet
 */
@WebServlet("/secure/*")
public class AccessControlServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		// Vérifier si l'utilisateur est authentifié
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("cv") == null) {
            // L'utilisateur n'est pas authentifié, rediriger vers la page de connexion
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }
        
        // L'utilisateur est autorisé, continuer avec la requête
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view" + request.getPathInfo());
        dispatcher.forward(request, response);
    }

	}

}
