package com.personal.dao;

import java.util.List;

import com.personal.common.DateRange;
import com.personal.entity.Expense;
import com.personal.generic.dao.PersonalDAO;

/**
 * The Interface ExpenseDAO.
 */
public interface ExpenseDAO  extends PersonalDAO<Expense>
{
	
	/**
	 * This method will be implemented to get the Expense details for the user in given Date Range.
	 *
	 * @param object of type IncomeExpenseDateRange
	 * @param Integer userId
	 * @return the expense list for user
	 */
	List<Expense> getExpenseListForUser(DateRange incomeExpenseValueRange,Integer applicationUserId);
}
