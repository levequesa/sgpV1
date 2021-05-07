package wsc.sgpV1.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

public class Collaborateur {
	
		private String matricule;
		private String nom;
		private String prenom;
		private LocalDate dateDeNaissance;
		private String adresse;
		private String numDeSecu;
		private String emailPro;
		private String photo;
		private ZonedDateTime dateHeureCreation;
		private boolean actif;
		
		public Collaborateur(String matricule, String nom, String prenom, LocalDate dateDeNaissance,
				String adresse, String numDeSecu, String emailPro, String photo, ZonedDateTime dateHeureCreation,
				boolean actif) {
			super();
			this.matricule = matricule;
			this.nom = nom;
			this.prenom = prenom;
			this.dateDeNaissance = dateDeNaissance;
			this.adresse = adresse;
			this.numDeSecu = numDeSecu;
			this.emailPro = emailPro;
			this.photo = photo;
			this.dateHeureCreation = dateHeureCreation;
			this.actif = actif;
		}

		public String getMatricule() {
			return matricule;
		}

		public void setMatricule(String matricule) {
			this.matricule = matricule;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public LocalDate getDateDeNaissance() {
			return dateDeNaissance;
		}

		public void setDateDeNaissance(LocalDate dateDeNaissance) {
			this.dateDeNaissance = dateDeNaissance;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getNumDeSecu() {
			return numDeSecu;
		}

		public void setNumDeTel(String numDeSecu) {
			this.numDeSecu = numDeSecu;
		}

		public String getEmailPro() {
			return emailPro;
		}

		public void setEmailPro(String emailPro) {
			this.emailPro = emailPro;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public ZonedDateTime getDateHeureCreation() {
			return dateHeureCreation;
		}

		public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
			this.dateHeureCreation = dateHeureCreation;
		}

		public boolean isActif() {
			return actif;
		}

		public void setActif(boolean actif) {
			this.actif = actif;
		}	
}