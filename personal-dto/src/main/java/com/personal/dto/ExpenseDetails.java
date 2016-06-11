package com.personal.dto;

import java.util.List;

public class ExpenseDetails
{

	private List<Expense> expensesList;
	
	private Double totalExpense;

	public ExpenseDetails()
	{
	}

	public ExpenseDetails(List<Expense> expenses, Double totalExpense)
	{
		this.expensesList = expenses;
		this.totalExpense = totalExpense;
	}

	public List<Expense> getExpenseList()
	{
		return expensesList;
	}

	public Double getTotalExpense()
	{
		return totalExpense;
	}

	public void setExpenseList(List<Expense> expenseList)
	{
		this.expensesList = expenseList;
	}

	public void setTotalExpense(Double totalExpense)
	{
		this.totalExpense = totalExpense;
	}

}
