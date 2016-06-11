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
 * The persistent class for the expense_type database table.
 */
@Entity
@Table(name = "expense_type")
@NamedQuery(name = "ExpenseType.findAll", query = "SELECT e FROM ExpenseType e")
public class ExpenseType extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EXPENSE_TYPE_EXPENSETYPEID_GENERATOR", sequenceName = "EXPENSE_TYPE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPENSE_TYPE_EXPENSETYPEID_GENERATOR")
	@Column(name = "expense_type_id")
	private long expenseTypeId;

	@Column(name = "expense_type_name")
	private String expenseTypeName;

	public ExpenseType()
	{
	}

	public long getExpenseTypeId()
	{
		return this.expenseTypeId;
	}

	public void setExpenseTypeId(long expenseTypeId)
	{
		this.expenseTypeId = expenseTypeId;
	}


	public String getExpenseTypeName()
	{
		return this.expenseTypeName;
	}

	public void setExpenseTypeName(String expenseTypeName)
	{
		this.expenseTypeName = expenseTypeName;
	}

}