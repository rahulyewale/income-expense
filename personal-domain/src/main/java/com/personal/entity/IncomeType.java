package com.personal.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the income_type database table.
 */
@Entity
@Table(name = "income_type")
@NamedQuery(name = "IncomeType.findAll", query = "SELECT i FROM IncomeType i")
public class IncomeType extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "INCOME_TYPE_INCOMETYPEID_GENERATOR", sequenceName = "INCOME_TYPE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INCOME_TYPE_INCOMETYPEID_GENERATOR")
	@Column(name = "income_type_id")
	private long incomeTypeId;

	@Column(name = "income_type_name")
	private String incomeTypeName;

	public IncomeType()
	{
	}

	public long getIncomeTypeId()
	{
		return this.incomeTypeId;
	}

	public void setIncomeTypeId(long incomeTypeId)
	{
		this.incomeTypeId = incomeTypeId;
	}


	public String getIncomeTypeName()
	{
		return this.incomeTypeName;
	}

	public void setIncomeTypeName(String incomeTypeName)
	{
		this.incomeTypeName = incomeTypeName;
	}

}