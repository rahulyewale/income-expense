package com.personal.webapp.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.personal.dto.IncomeExpenseSummaryRequest;
import com.personal.dto.IncomeExpenseSummaryResponse;
import com.personal.dto.IncomeType;
import com.personal.rest.client.RestServiceInvoker;
import com.personal.webapp.constants.WebConstants;

@Controller(value = CommonConstants.RequestMapping.INCOME_EXPENSE_SUMMARY)
public class IncomeExpenseSummaryController
{
	
	@Autowired	
	RestServiceInvoker restServiceInvoker;
	

	@RequestMapping(value = CommonConstants.RequestMapping.SUMMARY, method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getIncomeExpenseSummary(@ModelAttribute(WebConstants.ModelAttributes.INCOME_EXPENSE_SUMMARY_REQUEST)
	IncomeExpenseSummaryRequest incomeExpenseSummaryRequest)
	{
		if (incomeExpenseSummaryRequest.getApplicationUserId() == null)
		{
			incomeExpenseSummaryRequest.setApplicationUserId(0);
		}
		
		ModelAndView modelAndView = new ModelAndView(WebConstants.ViewNames.INCOME_EXPENSE_SUMMARY);

		IncomeType incomeType = new IncomeType();
		incomeType.setIncomeTypeId(1);
		incomeType.setIncomeTypeName("Salary");

		IncomeType incomeType1 = new IncomeType();
		incomeType1.setIncomeTypeId(1);
		incomeType1.setIncomeTypeName("House Rent");

		IncomeType incomeType2 = new IncomeType();
		incomeType2.setIncomeTypeId(1);
		incomeType2.setIncomeTypeName("Other");

		List<IncomeType> incomeTypeList = new ArrayList<IncomeType>();
		incomeTypeList.add(incomeType);
		incomeTypeList.add(incomeType1);
		incomeTypeList.add(incomeType2);

		modelAndView.addObject("incomeTypeList", incomeTypeList);

		ContextInfo contextInfo = new ContextInfo("System");

		ServiceRequest serviceRequest = new ServiceRequest(contextInfo);

		serviceRequest.add(CommonConstants.RequestMesageMapKeyConstant.INCOME_EXPENSE_REQUEST_KEY, incomeExpenseSummaryRequest);
		
		ServiceResponse serviceResponse = restServiceInvoker.invokeRestService(serviceRequest, CommonConstants.RequestMapping.INCOME_EXPENSE_SUMMARY);

		IncomeExpenseSummaryResponse incomeExpenseSummaryResponse = null;
		String responseString;
		try
		{
			responseString = JsonUtil.convertObjectToJson(serviceResponse.get(CommonConstants.RequestMesageMapKeyConstant.INCOME_EXPENSE_RESPONSE_KEY));

			incomeExpenseSummaryResponse = (IncomeExpenseSummaryResponse) JsonUtil.convertJsonToObject(responseString, IncomeExpenseSummaryResponse.class);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		modelAndView.addObject("incomeDetails", incomeExpenseSummaryResponse.getIncomeDetails());
		modelAndView.addObject("expenseDetails", incomeExpenseSummaryResponse.getExpenseDetails());
		modelAndView.addObject("incomeExpenseBalance", incomeExpenseSummaryResponse.getBalance());
		modelAndView.addObject("incomeExpenseSummaryResponse", incomeExpenseSummaryResponse);
		
		return modelAndView;
	}
}
