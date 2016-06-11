package com.personal.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class BankDetailsDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long userBankDtlsId;

	private Long applicationUserId;

	private Long bankMasterId;

	private String ifscCode;

	private String micrCode;

	private String netbankingCustomerId;

	private String netbankingLoginPassword;

	private String netbankingTransactionPassword;

	private String netbankingProfilePassword;

	private String savingsAccountNumber;

	private String currentAccountNumber;

	private String odAccountNumber;

	private String debitCardNo;

	private String debitCardCcv;

	private String debitCardValidityFrom;

	private String debitCardValidityTo;

	private String deditCardPin;

	private String creditCardNo;

	private String creditCardCcv;

	private String creditCardValidityFrom;

	private String creditCardValidityTo;

	private String creditCardPin;

	private String createdBy;

	private Timestamp createdDate;

	private String modifiedBy;

	private Timestamp modifiedDate;

	public Long getUserBankDtlsId()
	{
		return userBankDtlsId;
	}

	public void setUserBankDtlsId(Long userBankDtlsId)
	{
		this.userBankDtlsId = userBankDtlsId;
	}

	public Long getApplicationUserId()
	{
		return applicationUserId;
	}

	public void setApplicationUserId(Long applicationUserId)
	{
		this.applicationUserId = applicationUserId;
	}

	public Long getBankMasterId()
	{
		return bankMasterId;
	}

	public void setBankMasterId(Long bankMasterId)
	{
		this.bankMasterId = bankMasterId;
	}

	public String getIfscCode()
	{
		return ifscCode;
	}

	public void setIfscCode(String ifscCode)
	{
		this.ifscCode = ifscCode;
	}

	public String getMicrCode()
	{
		return micrCode;
	}

	public void setMicrCode(String micrCode)
	{
		this.micrCode = micrCode;
	}

	public String getNetbankingCustomerId()
	{
		return netbankingCustomerId;
	}

	public void setNetbankingCustomerId(String netbankingCustomerId)
	{
		this.netbankingCustomerId = netbankingCustomerId;
	}

	public String getNetbankingLoginPassword()
	{
		return netbankingLoginPassword;
	}

	public void setNetbankingLoginPassword(String netbankingLoginPassword)
	{
		this.netbankingLoginPassword = netbankingLoginPassword;
	}

	public String getNetbankingTransactionPassword()
	{
		return netbankingTransactionPassword;
	}

	public void setNetbankingTransactionPassword(String netbankingTransactionPassword)
	{
		this.netbankingTransactionPassword = netbankingTransactionPassword;
	}

	public String getNetbankingProfilePassword()
	{
		return netbankingProfilePassword;
	}

	public void setNetbankingProfilePassword(String netbankingProfilePassword)
	{
		this.netbankingProfilePassword = netbankingProfilePassword;
	}

	public String getSavingsAccountNumber()
	{
		return savingsAccountNumber;
	}

	public void setSavingsAccountNumber(String savingsAccountNumber)
	{
		this.savingsAccountNumber = savingsAccountNumber;
	}

	public String getCurrentAccountNumber()
	{
		return currentAccountNumber;
	}

	public void setCurrentAccountNumber(String currentAccountNumber)
	{
		this.currentAccountNumber = currentAccountNumber;
	}

	public String getOdAccountNumber()
	{
		return odAccountNumber;
	}

	public void setOdAccountNumber(String odAccountNumber)
	{
		this.odAccountNumber = odAccountNumber;
	}

	public String getDebitCardNo()
	{
		return debitCardNo;
	}

	public void setDebitCardNo(String debitCardNo)
	{
		this.debitCardNo = debitCardNo;
	}

	public String getDebitCardCcv()
	{
		return debitCardCcv;
	}

	public void setDebitCardCcv(String debitCardCcv)
	{
		this.debitCardCcv = debitCardCcv;
	}

	public String getDebitCardValidityFrom()
	{
		return debitCardValidityFrom;
	}

	public void setDebitCardValidityFrom(String debitCardValidityFrom)
	{
		this.debitCardValidityFrom = debitCardValidityFrom;
	}

	public String getDebitCardValidityTo()
	{
		return debitCardValidityTo;
	}

	public void setDebitCardValidityTo(String debitCardValidityTo)
	{
		this.debitCardValidityTo = debitCardValidityTo;
	}

	public String getDeditCardPin()
	{
		return deditCardPin;
	}

	public void setDeditCardPin(String deditCardPin)
	{
		this.deditCardPin = deditCardPin;
	}

	public String getCreditCardNo()
	{
		return creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo)
	{
		this.creditCardNo = creditCardNo;
	}

	public String getCreditCardCcv()
	{
		return creditCardCcv;
	}

	public void setCreditCardCcv(String creditCardCcv)
	{
		this.creditCardCcv = creditCardCcv;
	}

	public String getCreditCardValidityFrom()
	{
		return creditCardValidityFrom;
	}

	public void setCreditCardValidityFrom(String creditCardValidityFrom)
	{
		this.creditCardValidityFrom = creditCardValidityFrom;
	}

	public String getCreditCardValidityTo()
	{
		return creditCardValidityTo;
	}

	public void setCreditCardValidityTo(String creditCardValidityTo)
	{
		this.creditCardValidityTo = creditCardValidityTo;
	}

	public String getCreditCardPin()
	{
		return creditCardPin;
	}

	public void setCreditCardPin(String creditCardPin)
	{
		this.creditCardPin = creditCardPin;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy(String createdBy)
	{
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate()
	{
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate)
	{
		this.createdDate = createdDate;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy)
	{
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate()
	{
		return modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate)
	{
		this.modifiedDate = modifiedDate;
	}

}
