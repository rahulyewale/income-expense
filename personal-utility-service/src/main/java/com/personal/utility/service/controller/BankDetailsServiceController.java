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
import com.personal.common.json.util.CommonUtil;
import com.personal.dto.BankDetailsDTO;
import com.personal.dto.IncomeExpenseSummaryResponse;

/**
 * The IncomeExpenseServiceController use-full to server the
 * incomeExpenseRequest for given period of Date.
 */
@Controller
public class BankDetailsServiceController
{

	/** The Constant APPLICATION_JSON. */
	private static final String APPLICATION_JSON = "application/json";

	@Autowired
	private BankDetailsService bankService;

	/**
	 * This service operation use to serve Income Expense Request.
	 * @param serviceRequest the service request
	 * @return serviceResponse
	 */

	@RequestMapping(value = CommonConstants.RequestMapping.GET_BANK_LIST, method = RequestMethod.GET, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	@ResponseBody
	public ServiceResponse getBankList(@RequestBody
	ServiceRequest serviceRequest)
	{
		return null;
	}

	/**
	 * method use to prepare the ServiceResponse
	 * @param incomeExpenseSummaryResponse the income expense summary response
	 * @return the service response
	 */
	private ServiceResponse prepareServiceReponse(IncomeExpenseSummaryResponse incomeExpenseSummaryResponse)
	{
		ResponseData responseData = new ResponseData(ResponseType.SUCCESS, ResponseSeverity.INFO, ResponseCategory.SUCCESS, "Success");

		return new ServiceResponse(responseData, CommonConstants.RequestMesageMapKeyConstant.INCOME_EXPENSE_RESPONSE_KEY, incomeExpenseSummaryResponse);
	}

	@RequestMapping(value = CommonConstants.RequestMapping.SUBMIT_BANK_DETAILS, method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	@ResponseBody
	public ServiceResponse submitBankDetails(@RequestBody
	ServiceRequest serviceRequest)
	{

		BankDetailsDTO bankDetailsDTO = (BankDetailsDTO) CommonUtil.getDTOFromRequest(serviceRequest, CommonConstants.RequestMesageMapKeyConstant.SUBMIT_BANK_DETAILS_REQUEST_KEY, BankDetailsDTO.class);
		boolean bankDetailsAdded = bankService.submitBankDetails(bankDetailsDTO);
		ResponseData responseData = null;

		if (bankDetailsAdded)
		{
			responseData = new ResponseData(ResponseType.SUCCESS, ResponseSeverity.INFO, ResponseCategory.SUCCESS, "Success");
		}
		else
		{
			responseData = new ResponseData(ResponseType.SUCCESS, ResponseSeverity.INFO, ResponseCategory.SUCCESS, "Success");
		}

		return new ServiceResponse(responseData);

	}

}
