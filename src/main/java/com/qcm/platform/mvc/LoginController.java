package com.qcm.platform.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.qcm.platform.forms.LoginForm;
import com.qcm.platform.repo.CandidatDao;
import com.qcm.platform.repo.LoginDao;

@Controller
@RequestMapping("/login")
@Scope("session")
@SessionAttributes("req")
public class LoginController {

	@Autowired
	LoginDao loginDao;
	@Autowired
	CandidatDao candidatDao;

	@RequestMapping(method = RequestMethod.GET)
	public String displayUser(Model model) {
		model.addAttribute("user", new LoginForm());
		return "login";
	}

}
