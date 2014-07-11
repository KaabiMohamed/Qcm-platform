package com.qcm.platform.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qcm.platform.repo.ExamenDao;
import com.qcm.platform.repo.ResultatDao;

@Controller
public class UserController {

	@Autowired
	ResultatDao resultatDao;
	@Autowired
	ExamenDao examenDao;

	@RequestMapping(value = "/user/myResults")
	public String getMyResults(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String idCandidat = (String) session.getAttribute("email");
		model.addAttribute("myResults", resultatDao.findByCandidat(idCandidat));

		return "/user/myResults";

	}
	
	@RequestMapping(value = "/user")
	public String indexUser(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		String idCandidat = (String) session.getAttribute("email");
		model.addAttribute("exams", examenDao.getExamForCandidat(idCandidat));
		return "/user/main";
	}




}
