package com.personal.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the income database table.
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Income.incomeListForUser", query = "SELECT SUM(incz.incomeAmount),incz.incomeTypeCode "
			+ "FROM Income incz where incz.applicationUser.applicationUserId = :user_Id "
			+ "And (incz.incomeDate BETWEEN :startDate AND :endDate) "
			+ "group by incz.incomeTypeCode"),
	@NamedQuery(name = "Income.incomeListForAll", query = "SELECT SUM(incz.incomeAmount),incz.incomeTypeCode"
			+ " FROM Income incz where (incz.incomeDate BETWEEN :startDate AND :endDate) "
			+ "group by incz.incomeTypeCode"),
	@NamedQuery(name = "Income.findAll", query = "SELECT i FROM Income i"),
})
public class Income extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "INCOME_INCOMEID_GENERATOR", sequenceName = "INCOME_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INCOME_INCOMEID_GENERATOR")
	@Column(name = "income_id")
	private long incomeId;

	@Column(name = "income_amount")
	private double incomeAmount;

	@Column(name = "income_date")
	private Timestamp incomeDate;

	@Column(name = "income_description")
	private String incomeDescription;

	@ManyToOne
	@JoinColumn(name = "application_user_id")
	private ApplicationUser applicationUser;

	// bi-directional many-to-one association to IncomeType
	@ManyToOne
	@JoinColumn(name = "income_type_id")
	private IncomeType incomeType;
	
	@Column(name = "income_type_code")
	private String incomeTypeCode;

	public Income()
	{
	}

	public long getIncomeId()
	{
		return this.incomeId;
	}

	public void setIncomeId(long incomeId)
	{
		this.incomeId = incomeId;
	}

	public double getIncomeAmount()
	{
		return this.incomeAmount;
	}

	public void setIncomeAmount(double incomeAmount)
	{
		this.incomeAmount = incomeAmount;
	}

	public Timestamp getIncomeDate()
	{
		return this.incomeDate;
	}

	public void setIncomeDate(Timestamp incomeDate)
	{
		this.incomeDate = incomeDate;
	}

	public String getIncomeDescription()
	{
		return this.incomeDescription;
	}

	public void setIncomeDescription(String incomeDescription)
	{
		this.incomeDescription = incomeDescription;
	}

	public ApplicationUser getApplicationUser()
	{
		return this.applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser)
	{
		this.applicationUser = applicationUser;
	}

	public IncomeType getIncomeType()
	{
		return this.incomeType;
	}

	public void setIncomeType(IncomeType incomeType)
	{
		this.incomeType = incomeType;
	}

	public String getIncomeTypeCode()
	{
		return incomeTypeCode;
	}

	public void setIncomeTypeCode(String incomeTypeCode)
	{
		this.incomeTypeCode = incomeTypeCode;
	}
	
	
	

}