package com.qcm.platform.mvc;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qcm.platform.entities.Question;
import com.qcm.platform.repo.QuestionDao;

@Controller
public class questionController {

	@Autowired
	QuestionDao questionDao;

	@RequestMapping("/backoffice/questions")
	public String questions(Model model) {

		model.addAttribute("listQuestion", questionDao.questions());

		return "backoffice/questions";
	}

	@RequestMapping(value = "/backoffice/questionDetail/{idQuestion}")
	public String detailQuestion(@PathVariable("idQuestion") int idQuestion,
			Model model) {
		Question selected = questionDao.recherchQuestion(idQuestion);
		// byte[] image = selected.getImage();

		// model.addAttribute("image", image);
		model.addAttribute("selectedQuestion", selected);

		return "backoffice/questionDetail";
	}

	@RequestMapping(value = "/backoffice/ajouterQuestion")
	public String ajouter(Model model) {

		model.addAttribute("newQuestion", new Question());
		return "backoffice/ajouterQuestion";
	}

	@RequestMapping(value = "/backoffice/ajouterQuestion", method = RequestMethod.POST)
	public String ajouterQuestion(
			@Valid @ModelAttribute("newQuestion") Question newQuestion,
			@Valid @ModelAttribute("rep1") String rep1,
			@Valid @ModelAttribute("rep2") String rep2,
			@Valid @ModelAttribute("rep3") String rep3,
			@Valid @ModelAttribute("rep4") String rep4,
			@Valid @ModelAttribute("radiobtns1") String radiobtns1,
			@Valid @ModelAttribute("radiobtns2") String radiobtns2,
			@Valid @ModelAttribute("radiobtns3") String radiobtns3,
			@Valid @ModelAttribute("radiobtns4") String radiobtns4,
			BindingResult result, Model model) {
		Map<String, String> reponses = new HashMap<String, String>();
		// reponse as key Unique !!
		reponses.put(rep1, radiobtns1);
		reponses.put(rep2, radiobtns2);
		reponses.put(rep3, radiobtns3);
		reponses.put(rep4, radiobtns4);

		newQuestion.setReponses(reponses);

		questionDao.ajouterQuestion(newQuestion);

		return "redirect:/backoffice/questions";
	}

	@RequestMapping(value = "/backoffice/deleteQuestion/{idQuestion}")
	public String deleteQuestion(@PathVariable("idQuestion") int idQuestion,
			Model model) {
		Question selected = questionDao.recherchQuestion(idQuestion);
		questionDao.supprimerQuestion(selected);
		return "redirect:/backoffice/questions";
	}

	@RequestMapping(value = "/backoffice/modifierQuestion/{idQuestion}")
	public String setUpdateQuestion(@PathVariable("idQuestion") int idQuestion,
			Model model) {
		Question newOne = questionDao.recherchQuestion(idQuestion);
		model.addAttribute("editQuestion", newOne);

		return "backoffice/modifierQuestion";

	}

	@RequestMapping(value = "/backoffice/modifierQuestion/{idQuestion}", method = RequestMethod.POST)
	public String modifierQuestion(
			@Valid @ModelAttribute("editQuestion") Question editQuestion,
			@Valid @ModelAttribute("rep1") String rep1,
			@Valid @ModelAttribute("rep2") String rep2,
			@Valid @ModelAttribute("rep3") String rep3,
			@Valid @ModelAttribute("rep4") String rep4,
			@Valid @ModelAttribute("radiobtns1") String radiobtns1,
			@Valid @ModelAttribute("radiobtns2") String radiobtns2,
			@Valid @ModelAttribute("radiobtns3") String radiobtns3,
			@Valid @ModelAttribute("radiobtns4") String radiobtns4,
			BindingResult result, Model model) {
		Map<String, String> reponses = new HashMap<String, String>();
		// reponse as key Unique !!
		reponses.put(rep4, radiobtns4);
		reponses.put(rep3, radiobtns3);
		reponses.put(rep2, radiobtns2);
		reponses.put(rep1, radiobtns1);

		editQuestion.setReponses(reponses);
		questionDao.modifierQuestion(editQuestion);
		return "redirect:/backoffice/questions";
	}

}
