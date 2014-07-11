package com.qcm.platform.mvc;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qcm.platform.entities.Administrateur;
import com.qcm.platform.entities.Candidat;
import com.qcm.platform.repo.CandidatDao;

@Controller
public class CandidatController {

	@Autowired
	CandidatDao candidatDao;

	@Autowired
	private JavaMailSender mailSender;

	@RequestMapping(value = "/backoffice/user", method = RequestMethod.POST)
	public String AfficherDetailCandidat(HttpServletRequest request, Model model) {
		String idExam = request.getParameter("idExam");
		String identifiant = request.getParameter("identifiant");
		Candidat candidat = candidatDao
				.chercherCandidat(identifiant.toString());
		model.addAttribute("idExam", idExam);
		model.addAttribute("candidat", candidat);

		return "/backoffice/userDetails";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerNewCandidat(
			@Valid @ModelAttribute("newCandidat") Candidat newCandidat,
			BindingResult result, Model model) throws MessagingException {
		String password = randomPassword();
		newCandidat.setMotDePasse(password);
		candidatDao.ajouterCandidat(newCandidat);
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		String htmlMsg = "Bonjour <br> Bienvenue dans la plateforme de QCM  Vous etes enregistre avec les details suivants : <br>";
		htmlMsg += "<br>Identifiant : " + newCandidat.getIdentifiant();
		htmlMsg += "<br>Mot De Passe : " + newCandidat.getMotDePasse();
		htmlMsg += "<br><br> Cordialement <br> Equipe de travail de la plateforme QCM";
		mimeMessage.setContent(htmlMsg, "text/html");
		helper.setTo(newCandidat.getIdentifiant());
		helper.setSubject("Inscription QCM Platform");
		helper.setFrom("noreply@gmail.com");
		mailSender.send(mimeMessage);
		return "redirect:/login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String displayCandidat(Model model) {

		model.addAttribute("newCandidat", new Candidat());

		return "register";
	}

	public String randomPassword() {
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		int length = 10;
		Random rand = new Random();
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < length; i++) {
			buf.append(chars.charAt(rand.nextInt(chars.length())));
		}
		return buf.toString();
	}

	@RequestMapping(value = "/user/profile", method = RequestMethod.GET)
	public String profil(Model model, HttpServletRequest request) {

		String email = (String) request.getSession().getAttribute("email");
		model.addAttribute("profil", candidatDao.chercherCandidat(email));

		return "user/profile";
	}

	@RequestMapping(value = "/user/profile", method = RequestMethod.POST)
	public String profilEdit(@Valid @ModelAttribute("profil") Candidat user,
			Model model, HttpServletRequest request) {
		user.setActive(true);
		candidatDao.modifierCandidat(user);
		return "redirect:/user/profile";

	}
}
