package com.personal.webapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.personal.common.ServiceRequest;
import com.personal.common.context.ContextInfo;
import com.personal.common.json.util.JsonUtil;
import com.personal.dto.Expense;
import com.personal.dto.Income;
import com.personal.dto.IncomeExpenseSummaryResponse;
import com.personal.dto.IncomeTest;
import com.personal.dto.ItemInfoDTO;
import com.personal.rest.client.RestServiceInvoker;

@Controller
public class HomeController
{

	@Autowired	
	RestServiceInvoker restServiceInvoker;
	
	
	@RequestMapping(value = "/adincomes",method = RequestMethod.POST,produces="application/json")
	@ResponseBody
	public ItemInfoDTO testJson(HttpServletRequest httpServletRequest, HttpServletResponse response,@ModelAttribute
	                            IncomeTest userDataVo) throws IOException
	{
		System.out.println();
		return null;
	}
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
}
