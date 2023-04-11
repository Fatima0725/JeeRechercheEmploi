package com.isi.controller;

import jakarta.ejb.EJB;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.isi.dao.CvImpl;
import com.isi.dao.CvLocal;
import com.isi.entities.CategorieEmploi;
import com.isi.entities.Cv;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet(name="register", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {

	//private CvImpl cvDAO = new CvImpl();
	@EJB
	private CvLocal local;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    /*public RegisterServlet() {
    	Context ctx = new InitialContext();
       local = ctx.lookup("ejb:/RechercheEmploiEJB/")
    }*/

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		 List<Cv> cvs = local.listCvs();
		 // Stocker la liste des catégories dans la session utilisateur
        HttpSession session = request.getSession();
        if(session!= null) {
        	session.setAttribute("cvs", cvs);
        	request.getRequestDispatcher("allCvs.jsp").forward(request, response);
        }
        
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
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
			
			local.addCv(cv);
			
			// Adresse email de l'expéditeur
			String emailExpediteur = "fatimataniang208@gmail.com";

			// Mot de passe de l'expéditeur
			String motDePasseExpediteur = "bpbgjzsaogwuthbx\r\n"
					+ "";

			// Adresse email du destinataire (récupérée depuis le formulaire d'inscription)
			String emailDestinataire = cv.getEmail();

			// Objet du message
			String objetMessage = "Bienvenue sur notre site d'emploi !";

			// Corps du message
			String corpsMessage = "Bonjour " + cv.getPrenom() +" "+ cv.getNom() + ",\n\n"
			                    + "Nous vous remercions de vous être inscrit sur notre site d'emploi. "
			                    + "Vous pouvez maintenant vous connecter et voir tous les offres.\n\n"
			                    + "Cordialement,\n\n"
			                    + "L'équipe de notre site d'emploi";

			// Propriétés de la session SMTP
			Properties proprietes = new Properties();
			proprietes.put("mail.smtp.auth", "true");
			proprietes.put("mail.smtp.starttls.enable", "true");
			proprietes.put("mail.smtp.host", "smtp.gmail.com");
			proprietes.put("mail.smtp.port", "25");

			// Création de la session SMTP
			Session session = Session.getInstance(proprietes, new jakarta.mail.Authenticator() {
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication(emailExpediteur, motDePasseExpediteur);
			    }
			});

			try {
			    // Création du message
			    Message message = new MimeMessage(session);
			    message.setFrom(new InternetAddress(emailExpediteur));
			    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestinataire));
			    message.setSubject(objetMessage);
			    message.setText(corpsMessage);

			    // Envoi du message
			    Transport.send(message);

			    System.out.println("Le message a été envoyé avec succès.");
			} catch (MessagingException e) {
			    throw new RuntimeException(e);
			}

		
			request.setAttribute("cv", cv);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		//
		
		/*cvDAO.addCv(cv);
		response.sendRedirect("/login.jsp");*/

		
	}

}
