package com.personal.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.common.CommonConstants;
import com.personal.common.ServiceRequest;
import com.personal.common.ServiceResponse;
import com.personal.common.context.ContextInfo;
import com.personal.common.json.util.JsonUtil;
import com.personal.dto.BankDetailsDTO;
import com.personal.dto.IncomeExpenseSummaryRequest;
import com.personal.dto.IncomeExpenseSummaryResponse;
import com.personal.rest.client.RestServiceInvoker;
import com.personal.webapp.constants.WebConstants;

@Controller(value = CommonConstants.RequestMapping.BANK_DETAILS)
public class BankDetailsController
{
	
	@Autowired	
	RestServiceInvoker restServiceInvoker;

	@RequestMapping(value = CommonConstants.RequestMapping.VIEW_ADD_BANK_DETAILS, method = { RequestMethod.GET})
	public ModelAndView showAddBankDetailsPage()
	{
		ModelAndView modelAndView = new ModelAndView(WebConstants.ViewNames.ADD_BANK_DETAILS);

		return modelAndView;
	}
	
	@RequestMapping(value = CommonConstants.RequestMapping.SUBMIT_BANK_DETAILS, method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView addBankDetails(
	BankDetailsDTO bankDetailsDTO)
	{
		ModelAndView modelAndView = new ModelAndView(WebConstants.ViewNames.ADD_BANK_DETAILS);
		
		ContextInfo contextInfo = new ContextInfo("System");

		ServiceRequest serviceRequest = new ServiceRequest(contextInfo);

		serviceRequest.add(CommonConstants.RequestMesageMapKeyConstant.SUBMIT_BANK_DETAILS_REQUEST_KEY, bankDetailsDTO);
		
		ServiceResponse serviceResponse = restServiceInvoker.invokeRestService(serviceRequest, CommonConstants.RequestMapping.SUBMIT_BANK_DETAILS);

		/*String responseString;
		try
		{
			responseString = JsonUtil.convertObjectToJson(serviceResponse.get(CommonConstants.RequestMesageMapKeyConstant.INCOME_EXPENSE_RESPONSE_KEY));

			incomeExpenseSummaryResponse = (IncomeExpenseSummaryResponse) JsonUtil.convertJsonToObject(responseString, IncomeExpenseSummaryResponse.class);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}*/
		//modelAndView.addObject("incomeDetails", incomeExpenseSummaryResponse.getIncomeDetails());
		//modelAndView.addObject("expenseDetails", incomeExpenseSummaryResponse.getExpenseDetails());
		//modelAndView.addObject("incomeExpenseBalance", incomeExpenseSummaryResponse.getBalance());
		//modelAndView.addObject("incomeExpenseSummaryResponse", incomeExpenseSummaryResponse);
		
		return modelAndView;
	}
}
