package com.personal.utility.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.personal.common.DateRange;
import com.personal.common.json.util.CommonUtil;
import com.personal.dao.ExpenseDAO;
import com.personal.dto.ExpenseDetails;
import com.personal.dto.ExpenseUIDTO;
import com.personal.entity.Expense;
import com.personal.entity.Income;
import com.personal.utility.service.mapper.ExpenseMapper;
import com.personal.utility.service.mapper.IncomeMapper;

/**
 * The Class ExpenseService.
 */
@Component
public class ExpenseService
{
	
	/** The expense dao. */
	@Autowired
	private ExpenseDAO expenseDAO;

	/**
	 * Gets the expense list for user.
	 *
	 * @param incomeExpenseValueRange the income expense value range
	 * @param applicationUserId the application user id
	 * @return the expense list for user
	 */
	public ExpenseDetails getExpenseDetailsForUserByDateRange(DateRange incomeExpenseValueRange, Integer applicationUserId)
	{
		ExpenseDetails expenseResponse = new ExpenseDetails();
		
		List<Expense> expensesOfUserForGivenDates = expenseDAO.getExpenseListForUser(incomeExpenseValueRange, applicationUserId);
		
		List<com.personal.dto.Expense> expenseDTO = getExpenseDTO(expensesOfUserForGivenDates);
		
		expenseResponse.setExpenseList(expenseDTO);
		
		expenseResponse.setTotalExpense(getTotalExpensesForTheGivenDuration(expensesOfUserForGivenDates));

		return expenseResponse;
	}
	
	/**
	 * Gets the total expenses for the given duration.
	 *
	 * @param expenses the expenses
	 * @return the total expenses for the given duration
	 */
	private Double getTotalExpensesForTheGivenDuration(List<Expense> expenses)
	{
		Double totalExpenseAmount = new Double(0.0);
		
		for (Expense expense : expenses)
		{
			totalExpenseAmount += expense.getExpenseAmount();
		}
		
		return totalExpenseAmount;
	}

	/**
	 * Gets the expense dto.
	 *
	 * @param expensesOfUserForGivenDates the expenses of user for given dates
	 * @return the expense dto
	 */
	private List<com.personal.dto.Expense> getExpenseDTO(List<Expense> expensesOfUserForGivenDates)
	{
		List<com.personal.dto.Expense> expenseList = new ArrayList<com.personal.dto.Expense>(0);

		for (Expense expense : expensesOfUserForGivenDates)
		{
			com.personal.dto.Expense expenseDTO = new com.personal.dto.Expense(expense.getExpenseTypeCode(), expense.getExpenseDescription(), expense.getExpenseAmount(),null, expense.getIsInvestment());
			//expenseDTO.setExpenseDate(CommonUtil.getDateStringFromTimestamp(expense.getExpenseDate()));
			expenseList.add(expenseDTO);
			
		}
		return expenseList;
	}

	public void createExpense(ExpenseUIDTO expenseUIDTO)
	{
		
		List<Expense> expenseList = new ExpenseMapper().toDomainList(expenseUIDTO);
		
		for (Expense expense : expenseList)
		{
			try
			{
				expenseDAO.save(expense);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

}
