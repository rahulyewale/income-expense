	package com.personal.webapp.controller;
	
	import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.personal.common.CommonConstants;
import com.personal.common.ServiceRequest;
import com.personal.common.ServiceResponse;
import com.personal.common.context.ContextInfo;
import com.personal.dto.IncomeUIDTO;
import com.personal.rest.client.RestServiceInvoker;
import com.personal.webapp.constants.WebConstants;
	
	@Controller(value = CommonConstants.RequestMapping.INCOME)
	public class IncomeController
	{
	
		@Autowired
		RestServiceInvoker restServiceInvoker;
	
		@RequestMapping(value = CommonConstants.RequestMapping.CREATE_INCOME, method = RequestMethod.POST)
		@ResponseBody
		public String createIncome(HttpServletRequest httpServletRequest, @ModelAttribute(WebConstants.ModelAttributes.INCOME)
		IncomeUIDTO incomeUIDTO)
		{
	
			ContextInfo contextInfo = new ContextInfo("System");
	
			ServiceRequest serviceRequest = new ServiceRequest(contextInfo);
	
			serviceRequest.add(CommonConstants.RequestMesageMapKeyConstant.CREATE_INCOME_REQUEST_KEY, incomeUIDTO);
	
			ServiceResponse serviceResponse = restServiceInvoker.invokeRestService(serviceRequest, CommonConstants.RequestMapping.CREATE_INCOME);
	
			return "success";
			
		}
	
		@RequestMapping(value = CommonConstants.RequestMapping.DISPLAY_ADD_INCOME, method = {
										RequestMethod.GET,
										RequestMethod.POST})
		public ModelAndView displayAddIncome()
		{
	
			ModelAndView modelAndView = new ModelAndView(WebConstants.ViewNames.INCOME_PORTLET);
	
			return modelAndView;
		}
	
	}
