package com.qcm.platform.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcm.platform.repo.AdminDao;
import com.qcm.platform.repo.ExamenDao;
import com.qcm.platform.repo.ResultatDao;

@Controller
public class ResultatsController {
	
	@Autowired
	AdminDao adminDao;

	@Autowired
	ExamenDao examenDao;
	
	@Autowired
	ResultatDao resultatDao;
	
	@RequestMapping("/backoffice/resultats")
	public String exams(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		model.addAttribute("resultats", resultatDao.findByAdministrateur(session
				.getAttribute("email").toString()));
		
	    return "backoffice/resultats";
	}
	
	@RequestMapping(value = "/backoffice/resultats/{idExam}")
	public String detailQuestion(@PathVariable("idExam") int idExam, Model model) {

		model.addAttribute("idExam", idExam);
		model.addAttribute("lesResultats", resultatDao.findByExamen(idExam));
		model.addAttribute("titre", examenDao.RechercherExamen(idExam).getTitre());

		return "backoffice/resultatByExam";
	}

}
