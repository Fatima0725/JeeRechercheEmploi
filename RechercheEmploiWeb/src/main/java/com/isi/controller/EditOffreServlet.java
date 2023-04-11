package com.isi.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.isi.dao.OffreLocal;
import com.isi.entities.Offre;

/**
 * Servlet implementation class EditOffreServlet
 */
@WebServlet(name="editOffre", urlPatterns={"/editOffre"})
public class EditOffreServlet extends HttpServlet {
	@EJB
	private OffreLocal local;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOffreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // Récupération de l'ID de l'offre d'emploi à modifier
	    String idOffre = request.getParameter("id");
	    
	    // Convertir l'ID en entier
	    Long id = Long.parseLong(idOffre);

	    // Récupération de l'offre d'emploi correspondante dans la base de données
	    Offre offre = local.getOffre(id);

	    // Transmission de l'offre d'emploi au formulaire de modification
	    request.setAttribute("offre", offre);
	    request.getRequestDispatcher("/include/view/imprimer.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
