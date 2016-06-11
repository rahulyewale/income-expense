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
 * The persistent class for the expense database table.
 */
@Entity
@NamedQueries({
@NamedQuery(name = "Expense.findAll", query = "SELECT e FROM Expense e"),
@NamedQuery(name = "Expense.expensesForUser", 
				query = "SELECT SUM(expenses.expenseAmount),expenses.expenseTypeCode "
						+ "FROM Expense expenses where expenses.applicationUser.applicationUserId = :user_Id "
						+ "AND (expenses.expenseDate BETWEEN :startDate AND :endDate) "
						+ "group by expenses.expenseTypeCode"),
				@NamedQuery(name = "Expense.expensesForAll", 
				query = "SELECT SUM(expenses.expenseAmount),expenses.expenseTypeCode "
						+ "FROM Expense expenses where (expenses.expenseDate BETWEEN :startDate AND :endDate) "
						+ "group by expenses.expenseTypeCode")
})
public class Expense extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "EXPENSE_EXPENSEID_GENERATOR", sequenceName = "EXPENSE_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EXPENSE_EXPENSEID_GENERATOR")
	@Column(name = "expense_id")
	private long expenseId;

	@Column(name = "expense_amount")
	private double expenseAmount;

	@Column(name = "expense_date")
	private Timestamp expenseDate;

	@Column(name = "expense_description")
	private String expenseDescription;
	

	@Column(name = "expense_type_code")
	private String expenseTypeCode;

	@Column(name = "is_investment")
	private Boolean isInvestment;

	// bi-directional many-to-one association to ApplicationUser
	@ManyToOne
	@JoinColumn(name = "application_user_id")
	private ApplicationUser applicationUser;

	// bi-directional many-to-one association to ExpenseType
	@ManyToOne
	@JoinColumn(name = "expense_type_id")
	private ExpenseType expenseType;

	public Expense()
	{
	}

	public long getExpenseId()
	{
		return this.expenseId;
	}

	public void setExpenseId(long expenseId)
	{
		this.expenseId = expenseId;
	}

	public double getExpenseAmount()
	{
		return this.expenseAmount;
	}

	public void setExpenseAmount(double expenseAmount)
	{
		this.expenseAmount = expenseAmount;
	}

	public Timestamp getExpenseDate()
	{
		return expenseDate;
	}

	public void setExpenseDate(Timestamp expenseDate)
	{
		this.expenseDate = expenseDate;
	}

	public String getExpenseDescription()
	{
		return this.expenseDescription;
	}

	public void setExpenseDescription(String expenseDescription)
	{
		this.expenseDescription = expenseDescription;
	}

	public Boolean getIsInvestment()
	{
		return this.isInvestment;
	}

	public void setIsInvestment(Boolean isInvestment)
	{
		this.isInvestment = isInvestment;
	}

	public ApplicationUser getApplicationUser()
	{
		return this.applicationUser;
	}

	public void setApplicationUser(ApplicationUser applicationUser)
	{
		this.applicationUser = applicationUser;
	}

	public ExpenseType getExpenseType()
	{
		return this.expenseType;
	}

	public void setExpenseType(ExpenseType expenseType)
	{
		this.expenseType = expenseType;
	}

	public String getExpenseTypeCode()
	{
		return expenseTypeCode;
	}

	public void setExpenseTypeCode(String expenseTypeCode)
	{
		this.expenseTypeCode = expenseTypeCode;
	}
	

}