package com.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.personal.common.DateRange;
import com.personal.dao.IncomeDAO;
import com.personal.entity.Expense;
import com.personal.entity.Income;
import com.personal.generic.dao.impl.PersonalDAOImpl;

/**
 * The Class IncomeDAOImpl.
 */
@Repository
public class IncomeDAOImpl extends PersonalDAOImpl<Income> implements IncomeDAO
{

	/* (non-Javadoc)
	 * @see com.personal.dao.IncomeDAO#getIncomeListForUser(com.personal.common.IncomeExpenseDateRange, java.lang.Integer)
	 */
	@Override
	@Transactional
	public List<Income> getIncomeListForUser(DateRange incomeExpenseValueRange,Integer applicationUserId)
	{

		List<Income> incomeList = new ArrayList<Income>();
		try
		{
			Query query = null;
			List result = null;

			if (applicationUserId.equals(0))
			{// Fetch for all users.
				//query = getEntityManager().createNamedQuery("Expense.expensesForAll", Expense.class);
				query = getEntityManager().createNamedQuery("Income.incomeListForAll");
			
			}
			else
			{
				//query = getEntityManager().createNamedQuery("Expense.expensesForUser", Object.class);
				query = getEntityManager().createNamedQuery("Income.incomeListForUser");
				query.setParameter("user_Id", Long.valueOf(applicationUserId));
			}

			query.setParameter("startDate", incomeExpenseValueRange.getFromDate(), TemporalType.DATE);
			query.setParameter("endDate", incomeExpenseValueRange.getToDate(), TemporalType.DATE);
			result =  query.getResultList();
			
			for (Object object : result)
			{
				Object[] objectArray = (Object[]) object;
				Income income = new Income();
				income.setIncomeAmount((Double) objectArray[0]);
				income.setIncomeTypeCode((String) objectArray[1]);
				incomeList.add(income);
			}
			
			// System.out.println(""+incomeList);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return incomeList;
	}
}
