package com.personal.utility.service.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.personal.dao.UserBankDetailsDAO;
import com.personal.dto.BankDetailsDTO;
import com.personal.entity.UserBankDetail;

/**
 * The Class IncomeService.
 */
@Component
public class BankDetailsService {

	@Autowired
	private UserBankDetailsDAO userBankDetailsDAO;


	public boolean submitBankDetails(BankDetailsDTO bankDetailsDTO) {

		boolean bankDetailsAdded = false;
		UserBankDetail userBankDetail = new UserBankDetail();
		BeanUtils.copyProperties(bankDetailsDTO, userBankDetail);
		try {
			userBankDetailsDAO.save(userBankDetail);
			bankDetailsAdded=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bankDetailsAdded;
		
	}

}
