package com.personal.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;

@JsonIgnoreType
@JsonIgnoreProperties
public class Expense implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String expenseType;

	private String expenseDescription;

	private double expenseAmount;

	private String expenseDate;

	private Boolean isInvestment;
	
	private String expenseTypeCode;
	
	public Expense()
	{
	}

	public Expense(String expenseTypeCode, String expenseDescription, double expenseAmount, String expenseDate, Boolean isInvestment)
	{
		this.expenseTypeCode = expenseTypeCode;
		this.expenseDescription = expenseDescription;
		this.expenseAmount = expenseAmount;
		this.expenseDate = expenseDate;
		this.isInvestment = isInvestment;
	}

	public String getExpenseType()
	{
		return expenseType;
	}

	public void setExpenseType(String expenseType)
	{
		this.expenseType = expenseType;
	}

	public String getExpenseDescription()
	{
		return expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription)
	{
		this.expenseDescription = expenseDescription;
	}

	public double getExpenseAmount()
	{
		return expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount)
	{
		this.expenseAmount = expenseAmount;
	}

	public String getExpenseDate()
	{
		return expenseDate;
	}

	public void setExpenseDate(String expenseDate)
	{
		this.expenseDate = expenseDate;
	}

	public Boolean getIsInvestment()
	{
		return isInvestment;
	}

	public void setIsInvestment(Boolean isInvestment)
	{
		this.isInvestment = isInvestment;
	}

	public String getExpenseTypeCode()
	{
		return expenseTypeCode;
	}

	public void setExpenseTypeCode(String expenseTypeCode)
	{
		this.expenseTypeCode = expenseTypeCode;
	}
	
	

}