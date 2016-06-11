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
import com.personal.dto.ExpenseUIDTO;
import com.personal.rest.client.RestServiceInvoker;
import com.personal.webapp.constants.WebConstants;

@Controller(value = CommonConstants.RequestMapping.EXPENSE)
public class ExpenseController
{

	@Autowired
	RestServiceInvoker restServiceInvoker;

	
	
	@RequestMapping(value = CommonConstants.RequestMapping.CREATE_EXPENSE, method = RequestMethod.POST)
	@ResponseBody
	public String createIncome(HttpServletRequest httpServletRequest, @ModelAttribute(WebConstants.ModelAttributes.EXPENSE)
	ExpenseUIDTO expenseUIDTO)
	{

		ContextInfo contextInfo = new ContextInfo("System");

		ServiceRequest serviceRequest = new ServiceRequest(contextInfo);

		serviceRequest.add(CommonConstants.RequestMesageMapKeyConstant.CREATE_EXPESNE_REQUEST_KEY, expenseUIDTO);

		ServiceResponse serviceResponse = restServiceInvoker.invokeRestService(serviceRequest, CommonConstants.RequestMapping.CREATE_EXPENSE);

		return "success";
	}
	
	@RequestMapping(value = CommonConstants.RequestMapping.DISPLAY_ADD_EXPENSE, method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView displayAddExpense()
	{
		
		ModelAndView modelAndView = new ModelAndView(WebConstants.ViewNames.EXPENSE_PORTLET);
		
		return modelAndView;
	}
}
