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
import com.personal.dto.LogisticsResponse;

/**
 * The IncomeExpenseServiceController use-full to server the incomeExpenseRequest for given period of Date.
 */
@Controller
public class LogisticsServiceController
{

	/** The Constant APPLICATION_JSON. */
	private static final String APPLICATION_JSON = "application/json";

	@Autowired
	private LogisticsService logisticsService;
	
	/**
	 * This service operation use to serve Income Expense Request.
	 *
	 * @param serviceRequest the service request
	 * @return serviceResponse
	 */

	@RequestMapping(value = CommonConstants.RequestMapping.GENERATE_INVOICE, method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	@ResponseBody
	public ServiceResponse generateInvoice(@RequestBody	ServiceRequest serviceRequest)
	{
		try
		{
			return prepareServiceReponse(logisticsService.generateInvoice(serviceRequest));
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = CommonConstants.RequestMapping.LOAD_CSV, method = RequestMethod.POST, consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
	@ResponseBody
	public ServiceResponse loadCsv(@RequestBody	ServiceRequest serviceRequest)
	{
		return prepareServiceReponse(logisticsService.loadCsv(serviceRequest));
	}

	
	private ServiceResponse prepareServiceReponse(LogisticsResponse logisticsResponse)
	{
		ResponseData responseData = new ResponseData(ResponseType.SUCCESS, ResponseSeverity.INFO, ResponseCategory.SUCCESS, "Success");
		
		return new ServiceResponse(responseData, CommonConstants.RequestMesageMapKeyConstant.LOGISTICS_RESPONSE_KEY, logisticsResponse);
	}

}
