package com.qcm.platform.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qcm.platform.entities.Administrateur;
import com.qcm.platform.entities.Examen;
import com.qcm.platform.repo.AdminDao;
import com.qcm.platform.repo.ExamenDao;
import com.qcm.platform.repo.QcmService;
import com.qcm.platform.repo.QuestionDao;

@Controller
public class ExamController {

	@Autowired
	QuestionDao questionDao;

	@Autowired
	AdminDao adminDao;

	@Autowired
	ExamenDao examenDao;
	@Autowired
	QcmService qcmService;


	

	@RequestMapping("/backoffice/ajouterExamen")
	public String newExamen(Model model) {
		model.addAttribute("newQcm", new Examen());
		List<String> languages = questionDao.getLanguages();
		languages.add(0, "Selectionnez un language");
		model.addAttribute("select", questionDao.getLanguages());
		model.addAttribute("errorMsj","");
		return "backoffice/ajouterExamen";
	}

	

	@RequestMapping(value = "/backoffice/ajouterExamen", method = RequestMethod.POST)
	public String ajouterExamen(@Valid @ModelAttribute("newQcm") Examen newQcm,
			HttpServletRequest request, BindingResult result, Model model) {

		HttpSession session = request.getSession();
		Administrateur admin = adminDao.chercherAdmin(session.getAttribute(
				"email").toString());
		newQcm.setCreateur(admin);
		newQcm.setDateExamen(new Date());
		
		boolean checkQuestionsInDB = qcmService.canCreateQcm(newQcm.getNombreQuestions(), newQcm.getLanguage());
		if(checkQuestionsInDB==false){
			List<String> languages = questionDao.getLanguages();
			languages.add(0, "Selectionnez un language");
			model.addAttribute("select", questionDao.getLanguages());
			model.addAttribute("newQcm",newQcm);
			model.addAttribute("errorMsj","Il n'y a pas autant de questions");
			return "backoffice/ajouterExamen";
		}
		
		examenDao.AjouterExamen(newQcm);

		return "redirect:/backoffice/invite/" + newQcm.getIdExam();
	}

	

	@RequestMapping("/backoffice/exams")
	public String exams(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();

		model.addAttribute("exams", examenDao.getExamByUser(session
				.getAttribute("email").toString()));

		return "backoffice/exams";
	}

	// afficher le detail d'un exam

	@RequestMapping(value = "/backoffice/examDetail/{idExam}")
	public String detailQuestion(@PathVariable("idExam") int idExam, Model model) {

		model.addAttribute("selectedExam", examenDao.RechercherExamen(idExam));

		return "backoffice/examDetail";
	}

	// suppimer un examen

	@RequestMapping(value = "/backoffice/deleteExam/{idExam}")
	public String deleteExam(@PathVariable("idExam") int idExam, Model model) {

		examenDao.supprimerExamen(examenDao.RechercherExamen(idExam));
		return "redirect:/backoffice/exams";
	}

	// modifier examn Set
	@RequestMapping(value = "/backoffice/modifierExam/{idExam}")
	public String setUpdateExam(@PathVariable("idExam") int idExam, Model model) {
		List<String> languages = questionDao.getLanguages();
		languages.add(0, "Selectionnez un language");
		model.addAttribute("select", questionDao.getLanguages());
		model.addAttribute("editExam", examenDao.RechercherExamen(idExam));

		return "backoffice/modifierExam";

	}

	// modifier un examen le GET

	@RequestMapping(value = "/backoffice/modifierExam/{idExam}", method = RequestMethod.POST)
	public String UpdateExam(
			@Valid @ModelAttribute("editExam") Examen editExam, Model model) {

		editExam.setCreateur(examenDao.RechercherExamen(editExam.getIdExam())
				.getCreateur());
		editExam.setDateExamen(new Date());
		editExam.setLesCandidats(examenDao.RechercherExamen(
				editExam.getIdExam()).getLesCandidats());
		examenDao.ModifierExamen(editExam);

		return "redirect:/backoffice/exams";
	}

}
