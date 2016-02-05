package com.jcg.examples.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jcg.examples.service.UserService;

@Controller
public class Userlogin {
	
	@Autowired
	private UserService userservice;
	
	
	
	@RequestMapping(value="/userlogin", method=RequestMethod.GET)
	public ModelAndView userlogin()
	{
		ModelAndView model=new ModelAndView();
		model.setViewName("userlogin");
		return model;
	}
	
	
	@RequestMapping(value="/userlogin",method=RequestMethod.POST)
	public ModelAndView userlogin2(HttpServletRequest request,HttpServletResponse response) throws SQLException{
		ModelAndView model=new ModelAndView();
		HttpSession session = request.getSession();
		String username=(String)request.getParameter("username");
		if(username==null)
			username="";
		String password=(String)request.getParameter("password");
		if(password==null)
			password="";
		String type=(String)request.getParameter("type");
		if(type==null)
			type="";
		String message="";
		if(username=="")
			message="username should not be empty";
		else if(password=="")
			message="password should not be empty";
		else if(type=="")
			message="user type should not be empty";
		else
		{
		if(userservice.checkUserpass_service(username, password,type)>0){
			if(type.trim().equals("teacher"))
			   model.setViewName("redirect:/listcomname1");
			else
		       model.setViewName("redirect:/listcomname2");		
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			session.setAttribute("iflogin", "true");
			session.setAttribute("id", String.valueOf(userservice.checkUserpass_service(username, password,type)));
			session.setAttribute("type", type);
			message="";
			
		}
		else
		{message="account not exsit";}
		}
		model.addObject("message", message);
		model.addObject("username", username);
		return model;
	}
	

}
