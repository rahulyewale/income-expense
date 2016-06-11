package com.personal.utility.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.personal.common.CommonConstants;
import com.personal.common.ResponseData;
import com.personal.common.ServiceRequest;
import com.personal.common.ServiceResponse;
import com.personal.common.constant.ResponseCategory;
import com.personal.common.constant.ResponseSeverity;
import com.personal.common.constant.ResponseType;
import com.personal.dto.IncomeExpenseSummaryResponse;

/**
 * The IncomeExpenseServiceController use-full to server the incomeExpenseRequest for given period of Date.
 */
@Controller
public class UserServiceController
{

	/** The Constant APPLICATION_JSON. */
	private static final String APPLICATION_JSON = "application/json";

	/** The income expense summary service. */
	@Autowired
	private UserService userService;
	
	/**
	 * This service operation use to serve Income Expense Request.
	 *
	 * @param serviceRequest the service request
	 * @return serviceResponse
	 */

	/*@RequestMapping(value = CommonConstants.RequestMapping.INCOME_EXPENSE_SUMMARY, method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	@ResponseBody
	public ServiceResponse getIncomeExpenseSummary(@RequestBody	ServiceRequest serviceRequest)
	{
		return null;
	}

	
	*//**
	 * method use to prepare the ServiceResponse
	 *
	 * @param incomeExpenseSummaryResponse the income expense summary response
	 * @return the service response
	 *//*
	private ServiceResponse prepareServiceReponse(IncomeExpenseSummaryResponse incomeExpenseSummaryResponse)
	{
		ResponseData responseData = new ResponseData(ResponseType.SUCCESS, ResponseSeverity.INFO, ResponseCategory.SUCCESS, "Success");
		
		return new ServiceResponse(responseData, CommonConstants.RequestMesageMapKeyConstant.INCOME_EXPENSE_RESPONSE_KEY, incomeExpenseSummaryResponse);
	}*/

}
