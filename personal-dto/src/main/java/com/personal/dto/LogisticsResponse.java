package com.personal.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;

@JsonIgnoreType
@JsonIgnoreProperties
public class LogisticsResponse implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String startDate;

	private String endDate;

	private IncomeDetails incomeDetails;
	
	private ExpenseDetails expenseDetails;

	private double balance;


	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	public double getBalance()
	{
		return balance;
	}

	public String getStartDate()
	{
		return startDate;
	}

	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}

	public String getEndDate()
	{
		return endDate;
	}

	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}

	public IncomeDetails getIncomeDetails() {
		return incomeDetails;
	}

	public void setIncomeDetails(IncomeDetails incomeDetails) {
		this.incomeDetails = incomeDetails;
	}

	public ExpenseDetails getExpenseDetails() {
		return expenseDetails;
	}

	public void setExpenseDetails(ExpenseDetails expenseDetails) {
		this.expenseDetails = expenseDetails;
	}

}