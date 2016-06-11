package com.personal.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the bank_master database table.
 * 
 */
@Entity
@Table(name="bank_master")
@NamedQuery(name="BankMaster.findAll", query="SELECT b FROM BankMaster b")
public class BankMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "BANK_MASTER_IDGENERATOR", sequenceName = "BANK_MASTER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BANK_MASTER_IDGENERATOR")
	@Column(name="bank_master_id")
	private Long bankMasterId;

	@Column(name="bank_name")
	private String bankName;

	@Column(name="created_by")
	private String createdBy;

	@Column(name="created_date")
	private Timestamp createdDate;

	@Column(name="modified_by")
	private String modifiedBy;

	@Column(name="modified_date")
	private Timestamp modifiedDate;

	public BankMaster() {
	}

	public Long getBankMasterId() {
		return this.bankMasterId;
	}

	public void setBankMasterId(Long bankMasterId) {
		this.bankMasterId = bankMasterId;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
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

}