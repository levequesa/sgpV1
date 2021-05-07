package wsc.sgpV1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wsc.sgpV1.entite.Collaborateur;
import wsc.sgpV1.service.CollaborateurService;
import wsc.sgpV1.util.Constantes;

/**
 * Servlet implementation class ListerCollaborateursController
 */
@WebServlet(name="ListerCollaborateursController", urlPatterns="/listerCollaborateurs")
public class ListerCollaborateursController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// recuperation du service
	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	ServletException, IOException {
		//doGet OK
		System.out.println("ListerCollaborateursController - doGet method : ok ");
		
		// utilisation du service
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		
		req.setAttribute("listCollab", collaborateurs);
		req.getRequestDispatcher("/views/collab/listerCollaborateurs.jsp").forward(req, resp);
	}
}