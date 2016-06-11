package com.personal.utility.service.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.personal.common.json.util.CommonUtil;
import com.personal.dto.ExpenseUIDTO;
import com.personal.entity.ApplicationUser;
import com.personal.entity.Expense;
import com.personal.entity.audit.AuditColumns;

public class ExpenseMapper
{

	public List<Expense> toDomainList(ExpenseUIDTO expenseUIDTO)
	{
		List<Expense> expenseList = new ArrayList<Expense>();
		ApplicationUser applicationUser = new ApplicationUser();

		String applicationUserId = expenseUIDTO.getApplicationUserId();
		
		applicationUser.setApplicationUserId(Integer.valueOf(applicationUserId));
		
		AuditColumns auditColumns = new AuditColumns();
		auditColumns.setCreatedBy("online");
		auditColumns.setCreatedDate(new Timestamp(new java.util.Date().getTime()));
		
		String strExpenseDate = expenseUIDTO.getExpenseDateDiv();
		
		Date expenseDate = CommonUtil.constructDateFromString(strExpenseDate);

		
		if (null != expenseUIDTO.getTransportExpenseAmount() && !expenseUIDTO.getTransportExpenseAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getTransportExpenseAmount()));
			expense.setExpenseTypeCode("Transport");
			expense.setApplicationUser(applicationUser);

			expenseList.add(expense);
		}
		

		if (null != expenseUIDTO.getDailyNeedsAmount() && !expenseUIDTO.getDailyNeedsAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getDailyNeedsAmount()));
			expense.setExpenseTypeCode("Daily Needs");
			expense.setApplicationUser(applicationUser);

			expenseList.add(expense);
		}

		if (null != expenseUIDTO.getFuelExpenseAmount() && !expenseUIDTO.getFuelExpenseAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getFuelExpenseAmount()));
			expense.setExpenseTypeCode("Fuel");
			expense.setApplicationUser(applicationUser);

			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getHomeLoanEMIAmount() && !expenseUIDTO.getHomeLoanEMIAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getHomeLoanEMIAmount()));
			expense.setExpenseTypeCode("Home loan EMI");
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getHouseMaintainanceAmount() && !expenseUIDTO.getHouseMaintainanceAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getHouseMaintainanceAmount()));
			expense.setExpenseTypeCode("House Maintainance");
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getVehicleMaintainanceAmount() && !expenseUIDTO.getVehicleMaintainanceAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getVehicleMaintainanceAmount()));
			expense.setExpenseTypeCode("Vehicle Maintainance");
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getInternetRechargeAmount() && !expenseUIDTO.getInternetRechargeAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getInternetRechargeAmount()));
			expense.setExpenseTypeCode("Internet Recharge");
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getTataSkyRechargeAmount() && !expenseUIDTO.getTataSkyRechargeAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getTataSkyRechargeAmount()));
			expense.setExpenseTypeCode("Tata Sky Recharge");
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getLightBillAmount() && !expenseUIDTO.getLightBillAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getLightBillAmount()));
			expense.setExpenseTypeCode("Light Bill");
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getMobileRechargeAmount() && !expenseUIDTO.getMobileRechargeAmount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getMobileRechargeAmount()));
			expense.setExpenseTypeCode("Mobile Recharge");
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getOther1Amount() && !expenseUIDTO.getOther1Amount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getOther1Amount()));
			expense.setExpenseTypeCode("Other");
			expense.setExpenseDescription(expenseUIDTO.getOther1AmountDec());
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getOther2Amount() && !expenseUIDTO.getOther2Amount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getOther2Amount()));
			expense.setExpenseTypeCode("Other");
			expense.setExpenseDescription(expenseUIDTO.getOther2AmountDec());
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}
		
		if (null != expenseUIDTO.getOther3Amount() && !expenseUIDTO.getOther3Amount().isEmpty())
		{
			Expense expense = new Expense();
			
			expense.setAuditableColumns(auditColumns);
			expense.setExpenseDate(new Timestamp(expenseDate.getTime()));
			expense.setApplicationUser(applicationUser);
			expense.setExpenseAmount(Double.valueOf(expenseUIDTO.getOther3Amount()));
			expense.setExpenseTypeCode("Other");
			expense.setExpenseDescription(expenseUIDTO.getOther3AmountDec());
			expense.setApplicationUser(applicationUser);
			expenseList.add(expense);
		}

		return expenseList;
	}
}
