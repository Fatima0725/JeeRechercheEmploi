package com.isi.entities;

import java.io.Serializable;
import javax.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entity implementation class for Entity: NotificationEmail
 *
 */
@Entity
@Table(name = "notification_email")
public class NotificationEmail implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "destinataire")
    private String destinataire;

    @Column(name = "sujet")
    private String sujet;

    @Column(name = "contenu")
    private String contenu;

	
	private static final long serialVersionUID = 1L;

	public NotificationEmail() {
		super();
	}

	public String getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(String destinataire) {
		this.destinataire = destinataire;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public NotificationEmail(String destinataire, String sujet, String contenu) {
		super();
		this.destinataire = destinataire;
		this.sujet = sujet;
		this.contenu = contenu;
	}
	
   
}
