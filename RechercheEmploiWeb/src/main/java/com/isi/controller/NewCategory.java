package com.isi.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.isi.dao.CvLocal;
import com.isi.dao.OffreLocal;
import com.isi.entities.CategorieEmploi;

/**
 * Servlet implementation class NewCategory
 */
@WebServlet(name="addCategorie", urlPatterns={"/addCategorie"})
public class NewCategory extends HttpServlet {
	@EJB
	private OffreLocal local;
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 List<CategorieEmploi> categories = local.listCategories();
		 // Stocker la liste des catégories dans la session utilisateur
        HttpSession session = request.getSession();
        session.setAttribute("categories", categories);
		
		 
		  //session.setAttribute("categories", categories);
		 
		
		  request.getRequestDispatcher("allCategories.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
			String nom = request.getParameter("nom");
				if(local.trouverParNom(nom) != null) {
					request.setAttribute("erreurMessage", "La catégorie existe déjà !");
			        request.getRequestDispatcher("addCategorie.jsp").forward(request, response);
			        return;
				}
				
				CategorieEmploi categorie_emploi = new CategorieEmploi();
				categorie_emploi.setNom(nom);
				local.addCategory(categorie_emploi);
				
					HttpSession session = request.getSession();
				  List<CategorieEmploi> categories = local.listCategories();
				  session.setAttribute("categories", categories);
				 
				/*
				 * 
				 * request.setAttribute("categories", categories);
				 */
				  request.getRequestDispatcher("allCategories.jsp").forward(request, response);	
			
	
		

		
	}

}
