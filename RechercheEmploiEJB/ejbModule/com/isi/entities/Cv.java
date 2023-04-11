package com.isi.entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import jakarta.persistence.*;


/**
 * Entity implementation class for Entity: Cv
 *
 */
@Entity
@Table(name="Cv")
public class Cv implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "age")
	private Integer age;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "adresse")
	private String adresse;
	
	@Column(name = "specialite")
	private String specialite;
	
	@Column(name = "niveauEtude")
	private String niveauEtude;
	
	@Column(name = "experienceProfessionnel")
	private String experienceProfessionnel;
	
	@Column(name = "telephone")
	private String telephone;
	private static final long serialVersionUID = 1L;

	public Cv() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}   
	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}   
	public String getNiveauEtude() {
		return this.niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}   
	public String getExperienceProfessionnel() {
		return this.experienceProfessionnel;
	}

	public void setExperienceProfessionnel(String experienceProfessionnel) {
		this.experienceProfessionnel = experienceProfessionnel;
	}   
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Cv(String nom, String prenom, Integer age, String email, String password, String adresse, String specialite,
			String niveauEtude, String experienceProfessionnel, String telephone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.email = email;
		this.password = password;
		this.adresse = adresse;
		this.specialite = specialite;
		this.niveauEtude = niveauEtude;
		this.experienceProfessionnel = experienceProfessionnel;
		this.telephone = telephone;
	}
	
	
}
