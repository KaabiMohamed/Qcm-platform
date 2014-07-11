package com.qcm.platform.mvc;

import java.util.ArrayList;
import java.util.List;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qcm.platform.entities.Candidat;
import com.qcm.platform.entities.Examen;
import com.qcm.platform.repo.AdminDao;
import com.qcm.platform.repo.CandidatDao;
import com.qcm.platform.repo.ExamenDao;

@Controller
public class MailingController {

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private CandidatDao candidatDao;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	ExamenDao examenDao;

	private Candidat candidat;

	int idexamen;

	@RequestMapping("/backoffice/invite/{idExam}")
	public String invitePage(@PathVariable("idExam") int idExam, Model model) {
		Examen examen = examenDao.RechercherExamen(idExam);
		model.addAttribute("exam", examen);
		idexamen = idExam;
		return "backoffice/invite";
	}

	@RequestMapping(value = "/backoffice/sendInvites", method = RequestMethod.POST)
	public String sendInvite(
			@Valid @RequestParam("emails") List<String> emails,
			HttpServletRequest request, Model model) throws MessagingException {

		List<Candidat> lesCandidats = new ArrayList<Candidat>();
		Examen examen = examenDao.RechercherExamen(idexamen);
		List<Candidat> oldList = examen.getLesCandidats();
		// get Admin Email
//		HttpSession session = request.getSession();
//		Administrateur admin = adminDao.chercherAdmin(session.getAttribute(
		// "email").toString());

		for (String email : emails) {

			if (email.equals("")
					|| oldList.contains(candidatDao.chercherCandidat(email))) {

			} else {

				String password = null;

				if (candidatDao.candidatExist(email)) {

					Candidat candidat = candidatDao.chercherCandidat(email);
					lesCandidats.add(candidat);
					password = candidat.getMotDePasse();

				} else {
					password = randomPassword();
					Candidat newOne = new Candidat();
					newOne.setIdentifiant(email);
					newOne.setMotDePasse(password);
					lesCandidats.add(newOne);
					candidatDao.ajouterCandidat(newOne);

				}
				// send mail

				MimeMessage mimeMessage = mailSender.createMimeMessage();
				MimeMessageHelper helper;

				helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
				String htmlMsg = "Bonjour <br> Vous etes inscrit dans le QCM : "
						+ examen.getTitre()
						+ " Suite a votre Candidature pour l'un de nos postes <br>";
				htmlMsg += "<br>Identifiant : " + email;
				htmlMsg += "<br>Mot De Passe : " + password;
				htmlMsg += "<br><br> Cordialement";
				mimeMessage.setContent(htmlMsg, "text/html");
				helper.setTo(email);
				helper.setSubject("Candidature Chez GFI");
				helper.setFrom("noreply@gfi.com");
				mailSender.send(mimeMessage);

			}
		}
		lesCandidats.addAll(oldList);

		examen.setLesCandidats(lesCandidats);
		examenDao.ModifierExamen(examen);

		return "redirect:/backoffice/exams";
	}

	// sending Mails

	@RequestMapping(value = "/backoffice/sendMail", method = RequestMethod.POST)
	public String PageEnvoiMailFromResultats(HttpServletRequest request,
			Model model) {

		String idExam = request.getParameter("idExam");
		String identifiant = request.getParameter("identifiant");

		model.addAttribute("idExam", idExam);
		model.addAttribute("identifiant", identifiant);

		return "/backoffice/sendMail";
	}

	@RequestMapping(value = "/backoffice/sendOne", method = RequestMethod.POST)
	public String dosend(HttpServletRequest request, Model model)
			throws MessagingException {

		String idExam = request.getParameter("idExam");
		String identifiant = request.getParameter("identifiant");
		String sujet = request.getParameter("sujet");
		String message = request.getParameter("message");

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper;

		helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		String htmlMsg = message;
		mimeMessage.setContent(htmlMsg, "text/html");
		helper.setTo(identifiant);
		helper.setSubject(sujet);
		helper.setFrom("noreply@gfi.com");
		mailSender.send(mimeMessage);

		return "redirect:/backoffice/resultats/" + idExam.toString();
	}

	/**
	 * @return the candidat
	 */
	public Candidat getCandidat() {
		return candidat;
	}

	/**
	 * @param candidat
	 *            the candidat to set
	 */
	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
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

}
