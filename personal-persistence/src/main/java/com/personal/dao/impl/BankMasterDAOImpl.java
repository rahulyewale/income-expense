package com.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.personal.dao.BankMasterDAO;
import com.personal.entity.BankMaster;
import com.personal.entity.Expense;
import com.personal.generic.dao.impl.PersonalDAOImpl;


@Repository
public class BankMasterDAOImpl extends PersonalDAOImpl<BankMaster> implements BankMasterDAO 
{

	@Override
	public List<BankMaster> getBankMasterList() {
		

		List<BankMaster> bankMasterList = new ArrayList<BankMaster>(0);
		try
		{
			Query query = getEntityManager().createNamedQuery("BankMaster.findAll", BankMaster.class);
			bankMasterList = (List<BankMaster>) query.getResultList();
			//System.out.println("Expenses=" + expenses);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return bankMasterList;
	
	}

}
