package com.personal.common;

public final class CommonConstants
{

	public static final String NUMERIC_DATE_FORMAT = "dd-MMM-yyyy";
	
	public static class RequestMapping
	{
		public static final String EXPENSE = "/expense";

		public static final String INCOME = "/income";

		public static final String SUMMARY = "/summary";

		public static final String CREATE_EXPENSE = "/createExpense";

		public static final String CREATE_INCOME = "/createIncome";

		public static final String INCOME_EXPENSE_SUMMARY = "/incomeExpenseSummary";
		
		public static final String GET_BANK_LIST = "/getbanklist";
		
		public static final String BANK_DETAILS = "/bankdetails";
		
		public static final String VIEW_ADD_BANK_DETAILS = "/viewbankdetails";
		
		public static final String SUBMIT_BANK_DETAILS = "/submitbankdetails";
		
		public static final String LOGISTICS = "/logistics";
		
		public static final String GENERATE_INVOICE = "/generateinvoice";
		
		public static final String GET_LOGISTICS = "/getlogistics";
		
		public static final String LOAD_CSV = "/loadcsv";
		public static final String DISPLAY_ADD_INCOME = "/displayaddincome";
		public static final String DISPLAY_ADD_EXPENSE = "/displayaddexpense";
		
		
		

	}
	
	public static class RequestMesageMapKeyConstant
	{
		public static final String INCOME_EXPENSE_REQUEST_KEY = "IncomeExpenseRequest";
		
		public static final String INCOME_EXPENSE_RESPONSE_KEY = "IncomeExpenseResponse";
		
		public static final String SUBMIT_BANK_DETAILS_REQUEST_KEY = "SubmitBankDetailsRequest";
		
		public static final String LOGISTICS_RESPONSE_KEY = "LogisticsResponseKey";
		
		public static final String CREATE_INCOME_REQUEST_KEY = "CreateIncomeRequestKey";
		
		public static final String CREATE_INCOME_RESPONSE_KEY = "CreateIncomeResposneKey";
		
		public static final String CREATE_EXPESNE_REQUEST_KEY = "CreateExpenseRequestKey";
		
		public static final String CREATE_EXPENSE_RESPONSE_KEY = "CreateExpesneResposneKey";
	}

}
