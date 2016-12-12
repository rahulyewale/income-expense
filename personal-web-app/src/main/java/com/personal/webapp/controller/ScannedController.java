package com.personal.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.personal.common.CommonConstants;
import com.personal.dto.IncomeExpenseSummaryRequest;
import com.personal.webapp.constants.WebConstants;

@Controller
public class ScannedController
{

	@RequestMapping(value = CommonConstants.RequestMapping.SCANNED, method = { RequestMethod.GET, RequestMethod.POST})
	public ModelAndView getScannedDocumentList(@ModelAttribute(WebConstants.ModelAttributes.INCOME_EXPENSE_SUMMARY_REQUEST)
	IncomeExpenseSummaryRequest incomeExpenseSummaryRequest)
	{
		ModelAndView modelAndView = new ModelAndView(WebConstants.ViewNames.SCANNED_DOCUMENT);

		return modelAndView;
	}
}
