package com.personal.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.personal.common.DateRange;
import com.personal.dao.ExpenseDAO;
import com.personal.entity.Expense;
import com.personal.entity.Income;
import com.personal.generic.dao.impl.PersonalDAOImpl;

/**
 * The Class ExpenseDAOImpl.
 */
@Repository
public class ExpenseDAOImpl extends PersonalDAOImpl<Expense> implements ExpenseDAO
{

	/* (non-Javadoc)
	 * @see com.personal.dao.ExpenseDAO#getExpenseListForUser(com.personal.common.IncomeExpenseDateRange, java.lang.Integer)
	 */
	@Override
	@Transactional
	public List<Expense> getExpenseListForUser(DateRange incomeExpenseValueRange, Integer applicationUserId)
	{
		List<Expense> expenses = new ArrayList<Expense>(0);
		try
		{
			
			Query query = null;
			List result = null;
			

			if (applicationUserId.equals(0))
			{// Fetch for all users.
				//query = getEntityManager().createNamedQuery("Expense.expensesForAll", Expense.class);
				query = getEntityManager().createNamedQuery("Expense.expensesForAll");
			}
			else
			{
				//query = getEntityManager().createNamedQuery("Expense.expensesForUser", Object.class);
				query = getEntityManager().createNamedQuery("Expense.expensesForUser");
				query.setParameter("user_Id", Long.valueOf(applicationUserId));
			}
			
			
			query.setParameter("startDate", incomeExpenseValueRange.getFromDate());
			query.setParameter("endDate", incomeExpenseValueRange.getToDate());
			result = query.getResultList();
			
			
			for (Object object : result)
			{
				Object[] objectArray = (Object[]) object;
				Expense expense = new Expense();
				expense.setExpenseAmount((Double) objectArray[0]);
				expense.setExpenseTypeCode((String) objectArray[1]);
				expenses.add(expense);
			}
			
			
			System.out.println("Expenses=" + expenses);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return expenses;
	}

}
