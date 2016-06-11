package com.personal.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the user_bank_details database table.
 * 
 */
@Entity
@Table(name="user_bank_details")
@NamedQuery(name="UserBankDetail.findAll", query="SELECT u FROM UserBankDetail u")
public class UserBankDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "USER_BANK_DTLS_ID_GENERATOR", sequenceName = "USER_BANK_DTLS_ID_SEQ", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_BANK_DTLS_ID_GENERATOR")
	@Column(name="user_bank_dtls_id")
	private Long userBankDtlsId;

	@Column(name="application_user_id")
	private Long applicationUserId;

	@Column(name="bank_master_id")
	private Long bankMasterId;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="credit_card_ccv")
	private String creditCardCcv;

	@Column(name="credit_card_no")
	private String creditCardNo;

	@Column(name="credit_card_pin")
	private String creditCardPin;

	@Column(name="credit_card_validity_from")
	private String creditCardValidityFrom;

	@Column(name="credit_card_validity_to")
	private String creditCardValidityTo;

	@Column(name="current_account_number")
	private String currentAccountNumber;

	@Column(name="debit_card_ccv")
	private String debitCardCcv;

	@Column(name="debit_card_no")
	private String debitCardNo;

	@Column(name="debit_card_validity_from")
	private String debitCardValidityFrom;

	@Column(name="debit_card_validity_to")
	private String debitCardValidityTo;

	@Column(name="dedit_card_pin")
	private String deditCardPin;

	@Column(name="ifsc_code")
	private String ifscCode;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_date")
	private Timestamp modifiedDate;

	@Column(name="netbanking_customer_id")
	private String netbankingCustomerId;

	@Column(name="netbanking_login_password")
	private String netbankingLoginPassword;

	@Column(name="netbanking_profile_password")
	private String netbankingProfilePassword;

	@Column(name="netbanking_transaction_password")
	private String netbankingTransactionPassword;

	@Column(name="od_account_number")
	private String odAccountNumber;

	@Column(name="savings_account_number")
	private String savingsAccountNumber;

	public UserBankDetail() {
	}

	public Long getUserBankDtlsId() {
		return this.userBankDtlsId;
	}

	public void setUserBankDtlsId(Long userBankDtlsId) {
		this.userBankDtlsId = userBankDtlsId;
	}

	public Long getApplicationUserId() {
		return this.applicationUserId;
	}

	public void setApplicationUserId(Long applicationUserId) {
		this.applicationUserId = applicationUserId;
	}

	public Long getBankMasterId() {
		return this.bankMasterId;
	}

	public void setBankMasterId(Long bankMasterId) {
		this.bankMasterId = bankMasterId;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreditCardCcv() {
		return this.creditCardCcv;
	}

	public void setCreditCardCcv(String creditCardCcv) {
		this.creditCardCcv = creditCardCcv;
	}

	public String getCreditCardNo() {
		return this.creditCardNo;
	}

	public void setCreditCardNo(String creditCardNo) {
		this.creditCardNo = creditCardNo;
	}

	public String getCreditCardPin() {
		return this.creditCardPin;
	}

	public void setCreditCardPin(String creditCardPin) {
		this.creditCardPin = creditCardPin;
	}

	public String getCreditCardValidityFrom() {
		return this.creditCardValidityFrom;
	}

	public void setCreditCardValidityFrom(String creditCardValidityFrom) {
		this.creditCardValidityFrom = creditCardValidityFrom;
	}

	public String getCreditCardValidityTo() {
		return this.creditCardValidityTo;
	}

	public void setCreditCardValidityTo(String creditCardValidityTo) {
		this.creditCardValidityTo = creditCardValidityTo;
	}

	public String getCurrentAccountNumber() {
		return this.currentAccountNumber;
	}

	public void setCurrentAccountNumber(String currentAccountNumber) {
		this.currentAccountNumber = currentAccountNumber;
	}

	public String getDebitCardCcv() {
		return this.debitCardCcv;
	}

	public void setDebitCardCcv(String debitCardCcv) {
		this.debitCardCcv = debitCardCcv;
	}

	public String getDebitCardNo() {
		return this.debitCardNo;
	}

	public void setDebitCardNo(String debitCardNo) {
		this.debitCardNo = debitCardNo;
	}

	public String getDebitCardValidityFrom() {
		return this.debitCardValidityFrom;
	}

	public void setDebitCardValidityFrom(String debitCardValidityFrom) {
		this.debitCardValidityFrom = debitCardValidityFrom;
	}

	public String getDebitCardValidityTo() {
		return this.debitCardValidityTo;
	}

	public void setDebitCardValidityTo(String debitCardValidityTo) {
		this.debitCardValidityTo = debitCardValidityTo;
	}

	public String getDeditCardPin() {
		return this.deditCardPin;
	}

	public void setDeditCardPin(String deditCardPin) {
		this.deditCardPin = deditCardPin;
	}

	public String getIfscCode() {
		return this.ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getModifiedDate() {
		return this.modifiedDate;
	}

	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getNetbankingCustomerId() {
		return this.netbankingCustomerId;
	}

	public void setNetbankingCustomerId(String netbankingCustomerId) {
		this.netbankingCustomerId = netbankingCustomerId;
	}

	public String getNetbankingLoginPassword() {
		return this.netbankingLoginPassword;
	}

	public void setNetbankingLoginPassword(String netbankingLoginPassword) {
		this.netbankingLoginPassword = netbankingLoginPassword;
	}

	public String getNetbankingProfilePassword() {
		return this.netbankingProfilePassword;
	}

	public void setNetbankingProfilePassword(String netbankingProfilePassword) {
		this.netbankingProfilePassword = netbankingProfilePassword;
	}

	public String getNetbankingTransactionPassword() {
		return this.netbankingTransactionPassword;
	}

	public void setNetbankingTransactionPassword(String netbankingTransactionPassword) {
		this.netbankingTransactionPassword = netbankingTransactionPassword;
	}

	public String getOdAccountNumber() {
		return this.odAccountNumber;
	}

	public void setOdAccountNumber(String odAccountNumber) {
		this.odAccountNumber = odAccountNumber;
	}

	public String getSavingsAccountNumber() {
		return this.savingsAccountNumber;
	}

	public void setSavingsAccountNumber(String savingsAccountNumber) {
		this.savingsAccountNumber = savingsAccountNumber;
	}

}