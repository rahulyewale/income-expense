package com.personal.utility.service.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.personal.common.DateRange;
import com.personal.common.json.util.CommonUtil;
import com.personal.dao.IncomeDAO;
import com.personal.dto.IncomeDetails;
import com.personal.entity.Income;

/**
 * The Class IncomeService.
 */
@Component
public class UserService
{
	
	/** The income dao. */
	@Autowired
	private IncomeDAO incomeDAO;

	/**
	 * Gets the income list for user.
	 *
	 * @param incomeExpenseValueRange the income expense value range
	 * @param applicationUserId the application user id
	 * @return the income list for user
	 */
	public IncomeDetails getIncomeDetailsForUserByDateRange(DateRange incomeExpenseValueRange, Integer applicationUserId)
	{
		IncomeDetails incomeResponse = new IncomeDetails();

		List<Income> incomeListForUser = incomeDAO.getIncomeListForUser(incomeExpenseValueRange, applicationUserId);

		List<com.personal.dto.Income> incomeDTO = getIncomeDTO(incomeListForUser);

		incomeResponse.setIncomeList(incomeDTO);

		incomeResponse.setTotalIncome(getTotalIncome(incomeListForUser));

		return incomeResponse;

	}

	/**
	 * Gets the total income.
	 *
	 * @param list of type Income
	 * @return Double Value
	 */
	private Double getTotalIncome(List<Income> incomeListForUser)
	{	
		Double totalIncome = new Double(0.0);
		
		for (Income income : incomeListForUser)
		{
			totalIncome += income.getIncomeAmount();
		}
		
		return totalIncome;
	}

	/**This is Temporary Method to convert Entity to DTO
	 * Replacement will be Orika Mapper
	 *
	 * @param list incomeListForUser
	 * @return list<com.personal.dto.Income>
	 */
	private List<com.personal.dto.Income> getIncomeDTO(List<Income> incomeListForUser)
	{
		List<com.personal.dto.Income> incomeList = new ArrayList<com.personal.dto.Income>(0);
		for (Income income : incomeListForUser)
		{
			com.personal.dto.Income incomeDTO = new com.personal.dto.Income(income.getIncomeType().getIncomeTypeName(), income.getIncomeDescription(), income.getIncomeAmount(), null);
			incomeDTO.setIncomeDate(CommonUtil.getDateStringFromTimestamp(income.getIncomeDate()));
			incomeList.add(incomeDTO);
		}
		return incomeList;
	}

}
