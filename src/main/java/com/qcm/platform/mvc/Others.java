package com.qcm.platform.mvc;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qcm.platform.entities.Candidat;
import com.qcm.platform.entities.Resultats;
import com.qcm.platform.entities.Utilisateur;
import com.qcm.platform.repo.LoginDao;
import com.qcm.platform.repo.UtilisateurDAO;

@Controller
public class Others {

	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	LoginDao loginDao;

	@RequestMapping(value = "/backoffice")
	public String indexAdmin() {

		return "backoffice/main";
	}
	@RequestMapping(value = "/")
	public String index(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("email")!=null){
		String role = loginDao.getRoleForIdentifiiant(session.getAttribute(
					"email").toString());
		if(role=="candidat"){
			return "redirect:/user";
		}
		else if(role =="administrateur"){
			return "redirect:/backoffice";
		}}

		return "redirect:/login";
	}


	@RequestMapping(value = "/disconnect")
	public String LogOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:/login";
	}

	@RequestMapping(value = "/reset")
	public String resetPassword() {

		return "passwordReset";
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String desavtivate(HttpServletRequest request, Model model) {
		// System.out.println(identifiant);
		String identifiant = request.getParameter("identifiant");

		return "redirect:/login";
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
