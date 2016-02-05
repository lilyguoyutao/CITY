package com.jcg.examples.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class logoutController {
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public ModelAndView logout(HttpSession session)
	  
	{   
		String login=(String)session.getAttribute("iflogin");
		if(login==null)
			login="";
		session.setAttribute("iflogin", "");
		session.removeAttribute("iflogin");
		session.removeAttribute("username");
		session.invalidate();
	    return new ModelAndView("Logout");
	    }
	}


