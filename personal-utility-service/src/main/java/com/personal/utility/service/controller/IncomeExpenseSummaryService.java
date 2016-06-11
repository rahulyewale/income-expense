package com.personal.utility.service.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.personal.common.CommonConstants;
import com.personal.common.DateRange;
import com.personal.common.ServiceRequest;
import com.personal.common.json.util.CommonUtil;
import com.personal.common.json.util.JsonUtil;
import com.personal.dto.ExpenseDetails;
import com.personal.dto.IncomeExpenseSummaryRequest;
import com.personal.dto.IncomeExpenseSummaryResponse;
import com.personal.dto.IncomeDetails;

/**
 * The Class IncomeExpenseSummaryService Responsible to process on the
 * IncomeExpesnseRequest.
 */
@Component
public class IncomeExpenseSummaryService
{

	/** The income service. */
	@Autowired
	private IncomeService incomeService;

	/** The expense service. */
	@Autowired
	private ExpenseService expenseService;

	/**
	 * This method getThe ServiceRequest ,process it and gives
	 * IncomeExpenseSummaryResponse.
	 * @param ServiceRequest from controller
	 * @return IncomeExpenseSummaryResponse
	 */
	public IncomeExpenseSummaryResponse getIncomeExpenseSummary(ServiceRequest serviceRequest)
	{
		IncomeExpenseSummaryResponse incomeExpenseSummaryResponse = null;
		DateRange incomeExpenseSummaryDateRange = null;

		IncomeExpenseSummaryRequest incomeExpenseSummaryRequest = extractIncomeExpenseSummaryRequest(serviceRequest);

		if (null != incomeExpenseSummaryRequest.getApplicationUserId())
		{

			incomeExpenseSummaryDateRange = deriveDateRangeToFetchIncomeExpenseSummary(incomeExpenseSummaryRequest);

			IncomeDetails incomeDetailsForGivenDateRange = incomeService.getIncomeDetailsForUserByDateRange(incomeExpenseSummaryDateRange, incomeExpenseSummaryRequest.getApplicationUserId());

			ExpenseDetails expenseDetailsForGivenDateRange = expenseService.getExpenseDetailsForUserByDateRange(incomeExpenseSummaryDateRange, incomeExpenseSummaryRequest.getApplicationUserId());

			incomeExpenseSummaryResponse = prepearIncomeExpenseSummaryResponse(incomeDetailsForGivenDateRange, expenseDetailsForGivenDateRange, incomeExpenseSummaryDateRange);

		}

		return incomeExpenseSummaryResponse;
	}

	/**
	 * Method can use to prepare IncomeExpenseSummaryResponse from IncomeResponse
	 * and ExpenseResponse.
	 * @param incomeExpenseSummaryDateRange
	 * @param object of Type IncomeResponse
	 * @param object of Type ExpenseResponse
	 * @return object of Type IncomeExpenseSummaryResponse
	 */
	private IncomeExpenseSummaryResponse prepearIncomeExpenseSummaryResponse(IncomeDetails incomeForGivenDateRange, ExpenseDetails expenseForGivenDateRange, DateRange incomeExpenseSummaryDateRange)
	{
		IncomeExpenseSummaryResponse incomeExpenseSummaryResponse = new IncomeExpenseSummaryResponse();

		incomeExpenseSummaryResponse.setExpenseDetails(expenseForGivenDateRange);

		incomeExpenseSummaryResponse.setIncomeDetails(incomeForGivenDateRange);

		Double caluclatedAmount = calculateDifference(incomeForGivenDateRange.getTotalIncome(), expenseForGivenDateRange.getTotalExpense());

		incomeExpenseSummaryResponse.setBalance(caluclatedAmount);

		String incomeExpenseSummaryStartDate = CommonUtil.getDateStringFromTimestamp(new Timestamp(incomeExpenseSummaryDateRange.getFromDate().getTime()));
		String incomeExpenseSummaryEndDate = CommonUtil.getDateStringFromTimestamp(new Timestamp(incomeExpenseSummaryDateRange.getToDate().getTime()));

		incomeExpenseSummaryResponse.setStartDate(incomeExpenseSummaryStartDate);
		incomeExpenseSummaryResponse.setEndDate(incomeExpenseSummaryEndDate);

		return incomeExpenseSummaryResponse;
	}

	/**
	 * Method Calculate the difference between Total income and totalExpense.
	 * @param Double type value
	 * @param Double type value
	 * @return Double type value
	 */
	private Double calculateDifference(Double totalIncome, Double totalExpenses)
	{
		return totalIncome - totalExpenses;
	}

	/**
	 * Method validate all the attributes in the Object of type
	 * IncomeExpenseSummaryRequest and set the IncomeExpenseDateRange values
	 * @param object of type IncomeExpenseSummaryRequest
	 * @return object of type IncomeExpenseDateRange
	 */
	private DateRange deriveDateRangeToFetchIncomeExpenseSummary(IncomeExpenseSummaryRequest incomeExpenseSummaryRequest)
	{
		DateRange incomeAndExpensedateRange = null;
		if (CommonUtil.isInvalidString(incomeExpenseSummaryRequest.getStartDate()) || CommonUtil.isInvalidString(incomeExpenseSummaryRequest.getEndDate()))
		{
			incomeAndExpensedateRange = CommonUtil.getMonthBoundariesForGivenDate(new Date());
		}
		else
		{
			Date fromDate = CommonUtil.constructDateFromString(incomeExpenseSummaryRequest.getStartDate());

			Date toDate = CommonUtil.constructDateFromString(incomeExpenseSummaryRequest.getEndDate());

			incomeAndExpensedateRange = new DateRange(fromDate, toDate);
		}
		return incomeAndExpensedateRange;
	}

	/**
	 * Method Extracts serviceRequest and get IncomeExpenseSummaryRequest using
	 * the key "IncomeExpenseRequest".
	 * @param object type of ServiceRequest
	 * @return object type of IncomeExpenseSummaryRequest
	 */
	private IncomeExpenseSummaryRequest extractIncomeExpenseSummaryRequest(ServiceRequest serviceRequest)
	{
		IncomeExpenseSummaryRequest incomeExpenseSummaryRequest = null;
		if (null != serviceRequest)
		{
			try
			{
				String incomeExpenseRequestString = JsonUtil.convertObjectToJson(serviceRequest.get(CommonConstants.RequestMesageMapKeyConstant.INCOME_EXPENSE_REQUEST_KEY));
				incomeExpenseSummaryRequest = (IncomeExpenseSummaryRequest) JsonUtil.convertJsonToObject(incomeExpenseRequestString, IncomeExpenseSummaryRequest.class);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return incomeExpenseSummaryRequest;
	}

}
