package com.isi.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.DateTimeAtCreation;

import com.isi.dao.OffreLocal;
import com.isi.entities.CategorieEmploi;
import com.isi.entities.Offre;

/**
 * Servlet implementation class OffreServlet
 */
@WebServlet(name="offre", urlPatterns={"/offre"})
public class OffreServlet extends HttpServlet {
	@EJB
	private OffreLocal local;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OffreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//List<CategorieEmploi> categories = local.listCategories();
		List<Offre> listeOffres = local.listOffres();
		 // Stocker la liste des catégories dans la session utilisateur
		HttpSession session = request.getSession();
		session.setAttribute("listeOffres", listeOffres);
		response.sendRedirect(request.getContextPath() + "/include/view/admin.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String titrePoste = request.getParameter("titrePoste");
		String description = request.getParameter("description");
		String postuler = request.getParameter("postuler");
		
		 // récupérer la valeur du champ "datePublication"
	    String datePublicationStr = request.getParameter("datePublication");

	    // convertir la chaîne en LocalDateTime
	    LocalDateTime datePublication = LocalDateTime.parse(datePublicationStr, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
		//long categorieId = Long.parseLong(request.getParameter("category"));
		
		
		  String[] categoriesIds = request.getParameterValues("category"); //récupération des id des catégories sélectionnées
		  
		  List<CategorieEmploi> categories = new ArrayList<>();
		  
		  for (String categoryId : categoriesIds) {
		  //listDroit.add(droitdao.getOne(Integer.parseInt(idDroit)));
		  categories.add(local.getCategorie(Long.parseLong(categoryId))); }
		  
		  Offre offre = new Offre(); 
		  String action = request.getParameter("action");
			if(action.equals("Add")) {
		  
		  offre.setTitrePoste(titrePoste);
		  offre.setDescription(description); 
		  offre.setDatePublication(datePublication);
		  offre.setCategories(categories);
		  offre.setPostuler(postuler);
			List<Offre> listeOffres = local.listOffres();
			 // Stocker la liste des catégories dans la session utilisateur
			HttpSession session = request.getSession();
			session.setAttribute("listeOffres", listeOffres);
			request.getRequestDispatcher("offres.jsp").forward(request, response);
			  local.addOffre(offre);
			  response.sendRedirect(request.getContextPath() + "/include/view/admin.jsp");
			}
		 
		
	}

}
