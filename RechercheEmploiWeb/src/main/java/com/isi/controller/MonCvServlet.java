package com.isi.controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.isi.dao.CvLocal;
import com.isi.entities.Cv;

/**
 * Servlet implementation class MonCvServlet
 */
@WebServlet(name="monCv", urlPatterns= {"/monCv"})
public class MonCvServlet extends HttpServlet {
	@EJB
	private CvLocal local;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MonCvServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//Recuperation des données du formulaire
		/*
		 * Long cvId = Long.parseLong(request.getParameter("cvId")); Cv cv =
		 * local.getCv(cvId); request.setAttribute("cv", cv);
		 */
		 Long id = Long.parseLong(request.getParameter("id"));
	        Cv cv = local.getCv(id);
	        request.setAttribute("cv", cv);
	        //request.getRequestDispatcher("/edition.jsp").forward(request, response);

		request.getRequestDispatcher("monCv.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		// Récupérer le paramètre "age" de la requête
		Integer age= Integer.parseInt(request.getParameter("age"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String specialite = request.getParameter("specialite");
		String niveauEtude = request.getParameter("niveauEtude");
		String experienceProfessionnel = request.getParameter("experienceProfessionnel");
		String telephone = request.getParameter("telephone");
		
		String action = request.getParameter("action");
		if(action.equals("Register")) {
			Cv cv = new Cv();
			cv.setNom(nom);
			cv.setPrenom(prenom);
			cv.setAge(age);
			cv.setAdresse(adresse);
			cv.setEmail(email);
			cv.setExperienceProfessionnel(experienceProfessionnel);
			cv.setNiveauEtude(niveauEtude);
			cv.setPassword(password);
			cv.setSpecialite(specialite);
			cv.setTelephone(telephone);
			
			local.updateCV(cv);
			request.getRequestDispatcher("monCv.jsp").forward(request, response);
			}
		
		
		//Enregistrement des mis à jour
		//local.updateCV(cv);
	
	}

}
