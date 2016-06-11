package com.personal.dto;

import java.util.List;

public class IncomeDetails
{

	private List<Income> incomeList;
	private Double totalIncome;

	public List<Income> getIncomeList()
	{
		return incomeList;
	}

	public Double getTotalIncome()
	{
		return totalIncome;
	}

	public void setIncomeList(List<Income> incomeList)
	{
		this.incomeList = incomeList;
	}

	public void setTotalIncome(Double totalIncome)
	{
		this.totalIncome = totalIncome;
	}


}
