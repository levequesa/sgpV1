package wsc.sgpV1;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wsc.sgpV1.entite.Collaborateur;
import wsc.sgpV1.service.CollaborateurService;
import wsc.sgpV1.util.Constantes;

/**
 * Servlet implementation class CreerCollaborateurController
 */
@WebServlet(name="CreerCollaborateurController", urlPatterns="/nouveauCollaborateur")
public class CreerCollaborateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// recuperation du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("CreerCollaborateurController - doGet method ok");
		request.getRequestDispatcher("/views/collab/nouveauCollaborateur.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("CreerCollaborateurController - doPost method ok");
		Boolean result = collabService.isValidCollaborateur(request);
		if (result == true) {
			System.out.println("aller sur lister");
			// utilisation du service
			collabService.sauvegarderCollaborateur(collabService.construireCollaborateur(request));
			List<Collaborateur> listCollab = collabService.listerCollaborateurs();
			System.out.println("nbr dans liste : " + listCollab.size());
			request.setAttribute("listCollab", listCollab);
			//Envoi vers JSP lister collaborateur
			request.getRequestDispatcher("/views/collab/listerCollaborateurs.jsp").forward(request, response);
		} else {
			System.out.println("rester sur creer");
			String msg = "fiche incomplète ou erronée";
			request.setAttribute("msg", msg);
			//Envoi vers JSP créer pour correction
			request.getRequestDispatcher("/views/collab/nouveauCollaborateur.jsp").forward(request, response);
		}
	}
}