package com.personal.webapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.personal.dto.LoginDTO;

@Controller
public class LoginController
{

	
	@RequestMapping(value = "/getnavigation",method = { RequestMethod.GET, RequestMethod.POST})
	public String getNavigation(@ModelAttribute LoginDTO loginDTO, HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		//ModelAndView modelAndView = new ModelAndView("logistics");
		//return modelAndView;
		
		//return "redirect:/summary";
		return "redirect:/scanned";
	}
}
