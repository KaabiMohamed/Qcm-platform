package com.qcm.platform.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qcm.platform.entities.Administrateur;
import com.qcm.platform.entities.Candidat;
import com.qcm.platform.entities.Utilisateur;
import com.qcm.platform.repo.AdminDao;
import com.qcm.platform.repo.CandidatDao;
import com.qcm.platform.repo.UtilisateurDAO;

@Controller
public class AccountsController {

	@Autowired
	AdminDao adminDao;
	@Autowired
	CandidatDao candidatDao;
	@Autowired
	UtilisateurDAO utilisateurDAO;

	// Affiher tout les comptes administrateurs
	@RequestMapping(value = "/backoffice/accounts")
	public String listAccountsAdmin(Model model) {

		model.addAttribute("listeAdmin", adminDao.chercherTout());
		model.addAttribute("listeCandidat", candidatDao.chercherTout());

		return "backoffice/accounts";
	}

	@RequestMapping(value = "/rest/accounts/admins", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	List<Administrateur> listAllMembers() {
		return adminDao.chercherTout();

	}

	// afficher tout les comptes candidats
	@RequestMapping(value = "/backoffice/accounts/candidats")
	public String listAccountsCandidats(Model model) {

		model.addAttribute("listeCandidat", candidatDao.chercherTout());

		return "backoffice/accounts/candidats";
	}
	
	@RequestMapping(value = "/backoffice/ajouterCompte", method = RequestMethod.GET)
	public String displayCandidat(Model model) {
		model.addAttribute("newUser", new Utilisateur());

		return "backoffice/ajouterCompte";
	}

	@RequestMapping(value = "/backoffice/ajouterCompte", method = RequestMethod.POST)
	public String ajouterCompte(@Valid @ModelAttribute("newUser") Utilisateur user,
			@Valid @ModelAttribute("role") String role, Model model,
			HttpServletRequest request) {

		// tester la valeur du Select du role et persister l'user selon la
		// valeur du Select
		if (role.equals("Administrateur")) {
			Administrateur admin = new Administrateur();
			admin.setActive(true);
			admin.setAdresse(user.getAdresse());
			admin.setIdentifiant(user.getIdentifiant());
			admin.setMotDePasse(user.getMotDePasse());
			admin.setNomEtPrenom(user.getNomEtPrenom());
			admin.setTelephone(user.getTelephone());
			adminDao.ajouterAdmin(admin);

		} else if (role.equals("Candidat")) {
			Candidat candidat = new Candidat();
			candidat.setActive(true);
			candidat.setAdresse(user.getAdresse());
			candidat.setIdentifiant(user.getIdentifiant());
			candidat.setMotDePasse(user.getMotDePasse());
			candidat.setNomEtPrenom(user.getNomEtPrenom());
			candidat.setTelephone(user.getTelephone());
			candidatDao.ajouterCandidat(candidat);

		}
		return "redirect:/backoffice/accounts";
	}


	
	@RequestMapping(value = "/backoffice/desactivate", method = RequestMethod.POST)
	public String desavtivate(HttpServletRequest request, Model model) {
		// System.out.println(identifiant);
		String identifiant =request.getParameter("identifiant");
		utilisateurDAO.ActiverOuDesactiverUser(identifiant);

		return "redirect:/backoffice/accounts";
	}
	
	@RequestMapping(value = "/backoffice/profil", method = RequestMethod.GET)
	public String profil(Model model,HttpServletRequest request) {
		
	String email =	(String) request.getSession().getAttribute("email");
		model.addAttribute("profil", adminDao.chercherAdmin(email));

		return "backoffice/profil";
	}
	
	@RequestMapping(value = "/backoffice/profil", method = RequestMethod.POST)
	public String profilEdit(@Valid @ModelAttribute("profil") Administrateur user,
			 Model model,
			HttpServletRequest request) {
		user.setActive(true);
		adminDao.modifierAdmin(user);
		return "redirect:/backoffice/profil";
		
		
	}
	
		

}
