package com.qcm.platform.mvc;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcm.platform.entities.Candidat;
import com.qcm.platform.entities.ExamEnCours;
import com.qcm.platform.entities.Examen;
import com.qcm.platform.entities.Question;
import com.qcm.platform.entities.Resultats;
import com.qcm.platform.forms.QuestionForm;
import com.qcm.platform.repo.CandidatDao;
import com.qcm.platform.repo.ExamenDao;
import com.qcm.platform.repo.QcmService;
import com.qcm.platform.repo.ResultatDao;

@Controller
public class PasserQcm {

	@Autowired
	QcmService qcmService;

	@Autowired
	ExamenDao examenDao;

	@Autowired
	protected CandidatDao candidatDao;

	@Autowired
	protected ResultatDao resultatDao;

	Examen examen = new Examen();
	List<Question> questions;
	ExamEnCours examEnCours = new ExamEnCours();
	double percentage;

	@RequestMapping(value = "/startQcm/{idQcm}")
	public String StartQcm(@PathVariable("idQcm") int idQcm) {
		examen = examenDao.RechercherExamen(idQcm);
		percentage = 0;
		questions = qcmService.generateQuestions(examen.getNombreQuestions(),
				examen.getLanguage());
		examEnCours.setStartTime(new Date().getMinutes());
		System.out.println(questions.size());
		return "redirect:/user/qcm/0";
	}

	@RequestMapping(value = "/user/qcm/{nextQuestion}")
	public String Qcm(@PathVariable("nextQuestion") int nextQuestion,
			@Valid @ModelAttribute("questionForm") QuestionForm questionForm,
			Model model, HttpServletRequest request) {

		long remainingTime = examen.getNombreMinutes()
				- (new Date().getMinutes() - examEnCours.getStartTime());
		if (remainingTime == 0 || remainingTime < 0) {
			return "redirect:/user/qcm/finalise";
		}
		// Store respnenses
		String check0 = (String) request.getParameter("check0");
		if (check0 == null) {
			check0 = "Faux";
		}
		String key0 = request.getParameter("key0");
		String check1 = (String) request.getParameter("check1");
		if (check1 == null) {
			check1 = "Faux";
		}
		String key1 = request.getParameter("key1");
		String check2 = (String) request.getParameter("check2");
		if (check2 == null) {
			check2 = "Faux";
		}
		String key2 = request.getParameter("key2");
		String check3 = (String) request.getParameter("check3");
		if (check3 == null) {
			check3 = "Faux";
		}
		String key3 = request.getParameter("key3");

		String currentQuestion = request.getParameter("currentQuestion");
		if (currentQuestion == null)
			currentQuestion = "0";
		System.out.println(currentQuestion);
		Question question = questions.get(Integer.parseInt(currentQuestion));
		System.out.println(question.getReponses().values().toString());

		double noteQuestion = 0;
		System.out.println("********************" + currentQuestion
				+ "*********************");
		if (check0.equals(question.getReponses().get(key0))) {
			System.out.println("1 ++");
			noteQuestion++;
		} else {
			noteQuestion--;
			System.out.println("1 --");
		}
		if (check1.equals(question.getReponses().get(key1))) {
			System.out.println("2 ++");
			noteQuestion++;
		} else {
			noteQuestion--;
			System.out.println("2 --");
		}
		if (check2.equals(question.getReponses().get(key2))) {
			System.out.println("3 ++ ");
			noteQuestion++;
		} else {
			noteQuestion--;
			System.out.println("3 --");
		}
		if (check3.equals(question.getReponses().get(key3))) {
			System.out.println("4 ++");
			noteQuestion++;
		} else {
			noteQuestion--;
			System.out.println("4 --");
		}

		if (noteQuestion < 0) {
			noteQuestion = 0;
		}
		System.out.println("noteQuestion : " + noteQuestion / 4);

		percentage += (((noteQuestion / 4) * 100) / examen.getNombreQuestions());
		System.out.println(percentage + "%");

		// reset f
		questionForm = new QuestionForm();
		questionForm.setQuestion(questions.get(nextQuestion));

		model.addAttribute("question", questions.get(nextQuestion));
		model.addAttribute("numQuestion", nextQuestion);
		model.addAttribute("numberOfQuestions", questions.size());
		model.addAttribute("remainingTime", remainingTime);

		return "/user/qcm";
	}

	@RequestMapping(value = "/user/qcm/finalise")
	public String finalise(HttpServletRequest request) {
		Resultats resultats = new Resultats();
		resultats.setDate(new Date());
		resultats.setPourcentageReussite(percentage);
		resultats.setExamen(examen);
		HttpSession session = request.getSession();
		Candidat candidat = candidatDao.chercherCandidat(session.getAttribute(
				"email").toString());
		resultats.setCandidat(candidat);

		resultatDao.ajouterResultat(resultats);

		return "redirect:/user/myResults";
	}

}
