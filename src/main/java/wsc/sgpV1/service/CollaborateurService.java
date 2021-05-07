package wsc.sgpV1.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import wsc.sgpV1.entite.Collaborateur;

public class CollaborateurService {
	List<Collaborateur> listeCollaborateurs = new ArrayList<Collaborateur>();

	public List<Collaborateur> listerCollaborateurs() {
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}
	
	public boolean isValidCollaborateur (HttpServletRequest request) {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateDeNaissance = request.getParameter("dateDeNaissance");
		String adresse = request.getParameter("adresse");
		String numDeSecu = request.getParameter("numDeSecu");
		String msgErr = "";
		
		//---Contrôles des paramètres
		if (nom == null || prenom == null  || dateDeNaissance == null || adresse == null || numDeSecu == null) {
			System.out.println("paramètre absent à tort" + nom + '-' + prenom + '-' + dateDeNaissance + '-' + adresse + '-' + numDeSecu);
			msgErr = "Tous les champs sont requis";
			return false;
		}
		
		if (nom.isEmpty() || prenom.isEmpty() || dateDeNaissance.isEmpty() || adresse.isEmpty() || numDeSecu.isEmpty()) {
			System.out.println("paramètre vide à tort : " + nom + '-' + prenom + '-' + dateDeNaissance + '-' + adresse + '-' + numDeSecu);
			msgErr = "Tous les champs sont requis";
			return false;
		}
			
		try {
			Long numeroDeSecu = Long.parseLong(numDeSecu);
			System.out.println("c'est un entier : " + numeroDeSecu + "/");
		} catch (NumberFormatException nfmt){
			System.out.println("Ce n'est pas un entier : " +  numDeSecu  + "/" + nfmt + '/' );
			msgErr = "Ce n'est pas un entier" ;
			return false;
		}
		
		if (numDeSecu.length() != 15) {
			System.out.println("num de secu ko" + numDeSecu);
			msgErr="le numéro de Secu doit comporter 15 chiffres";
			return false;
		} 
		
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	  	    //convert String to LocalDate
			LocalDate dateDeNaissanceOk = LocalDate.parse(dateDeNaissance, formatter);
		} catch (DateTimeParseException e) {
			msgErr = "date de naissance doit être au format dd/mm/yyyy : " + dateDeNaissance;
			return false;
		}	
		
		if(msgErr.isEmpty()) {
			System.out.println("Collaborateur ok");
			return true;
		} else {
			System.out.println("collaborateur ko");
			return false;
		}
	}
	
	public Collaborateur construireCollaborateur (HttpServletRequest request) {
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		String dateDeNaissanceString = request.getParameter("dateDeNaissance");
		System.out.println("date  " + dateDeNaissanceString + "/");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  	    //convert String to LocalDate
		LocalDate dateDeNaissance = LocalDate.parse(dateDeNaissanceString, formatter);
		
		String adresse = request.getParameter("adresse");
		String numDeSecu = request.getParameter("numDeSecu");
		
		//---Recup date / heure
		ZonedDateTime dateHeureCreation = ZonedDateTime.now();
		System.out.println("dateHeureCreation : " + dateHeureCreation);
		
		//---Generations matricule
        // create instance of Random class
		Random rand = new Random();
        // Generate random integers in range 0 to 999
        int entier = rand.nextInt(1000);
        String matricule = String.valueOf(entier);
		
		//---Generations emailPro        
		String emailPro = nom + prenom + "@societe.com";
		
		//---Valeur par défault
		Boolean actif = true;
		
		//photo
		String photo = "photo fictive";
		
		Collaborateur collaborateur = new Collaborateur(matricule, nom, prenom, dateDeNaissance, adresse, numDeSecu, emailPro, photo, dateHeureCreation, actif);
		System.out.println("nom du colla : " + collaborateur.getNom());
		return collaborateur;
	}
	
}