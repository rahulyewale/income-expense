package com.personal.utility.service.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.personal.common.json.util.CommonUtil;
import com.personal.dto.IncomeUIDTO;
import com.personal.entity.ApplicationUser;
import com.personal.entity.Income;
import com.personal.entity.audit.AuditColumns;

public class IncomeMapper
{

	public List<Income> toDomainList(IncomeUIDTO incomeUIDTO)
	{
		List<Income> incomeList = new ArrayList<Income>();
		
		
		AuditColumns auditColumns = new AuditColumns();
		auditColumns.setCreatedBy("online");
		auditColumns.setCreatedDate(new Timestamp(new java.util.Date().getTime()));
		
		String strIncomeDate = incomeUIDTO.getIncomeDateDiv();
		
		Date incomeDate = CommonUtil.constructDateFromString(strIncomeDate);
		
		String applicationUserId = incomeUIDTO.getApplicationUserId();
		
		ApplicationUser applicationUser = new ApplicationUser();

		applicationUser.setApplicationUserId(Integer.valueOf(applicationUserId));

		if (null != incomeUIDTO.getSalaryIncomeAmount() && !incomeUIDTO.getSalaryIncomeAmount().isEmpty())
		{

			Income income = new Income();
			
			income.setAuditableColumns(auditColumns);

			income.setIncomeDate(new Timestamp(incomeDate.getTime()));
			income.setApplicationUser(applicationUser);
			income.setIncomeAmount(Double.valueOf(incomeUIDTO.getSalaryIncomeAmount()));
			income.setIncomeTypeCode("Salary");
			income.setApplicationUser(applicationUser);

			incomeList.add(income);

		}

		if (null != incomeUIDTO.getHouseRent() && !incomeUIDTO.getHouseRent().isEmpty())
		{

			Income income = new Income();
			income.setAuditableColumns(auditColumns);
			income.setIncomeDate(new Timestamp(incomeDate.getTime()));
			income.setApplicationUser(applicationUser);
			income.setIncomeAmount(Double.valueOf(incomeUIDTO.getHouseRent()));
			income.setIncomeTypeCode("House Rent");
			income.setApplicationUser(applicationUser);
			incomeList.add(income);

		}

		if (null != incomeUIDTO.getOther1Amount() && !incomeUIDTO.getOther1Amount().isEmpty())
		{

			Income income = new Income();
			income.setAuditableColumns(auditColumns);
			income.setIncomeDate(new Timestamp(incomeDate.getTime()));
			income.setApplicationUser(applicationUser);
			income.setIncomeAmount(Double.valueOf(incomeUIDTO.getOther1Amount()));
			income.setIncomeDescription(incomeUIDTO.getOther1AmountDec());
			income.setIncomeTypeCode("Other");
			income.setApplicationUser(applicationUser);
			incomeList.add(income);

		}

		if (null != incomeUIDTO.getOther2Amount() && !incomeUIDTO.getOther2Amount().isEmpty())
		{

			Income income = new Income();
			income.setAuditableColumns(auditColumns);
			income.setIncomeDate(new Timestamp(incomeDate.getTime()));
			income.setApplicationUser(applicationUser);
			income.setIncomeAmount(Double.valueOf(incomeUIDTO.getOther2Amount()));
			income.setIncomeDescription(incomeUIDTO.getOther2AmountDec());
			income.setIncomeTypeCode("Other");
			income.setApplicationUser(applicationUser);
			incomeList.add(income);

		}

		if (null != incomeUIDTO.getOther3Amount() && !incomeUIDTO.getOther3Amount().isEmpty())
		{

			Income income = new Income();
			income.setAuditableColumns(auditColumns);
			income.setIncomeDate(new Timestamp(incomeDate.getTime()));
			income.setApplicationUser(applicationUser);
			income.setIncomeAmount(Double.valueOf(incomeUIDTO.getOther3Amount()));
			income.setIncomeDescription(incomeUIDTO.getOther3AmountDec());
			income.setIncomeTypeCode("Other");
			income.setApplicationUser(applicationUser);
			incomeList.add(income);

		}

		return incomeList;
	}
}
