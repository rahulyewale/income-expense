package com.personal.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * The persistent class for the application_user database table.
 */
@Entity
@Table(name = "application_user")
@NamedQuery(name = "ApplicationUser.findAll", query = "SELECT a FROM ApplicationUser a")
public class ApplicationUser extends BaseEntity implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "APPLICATION_USER_APPLICATIONUSERID_GENERATOR", sequenceName = "APPLICATION_USER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_USER_APPLICATIONUSERID_GENERATOR")
	@Column(name = "application_user_id")
	private long applicationUserId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "login_id")
	private String loginId;

	@Column(name = "login_password")
	private String loginPassword;


	// bi-directional many-to-one association to Expense
	@OneToMany(mappedBy = "applicationUser")
	private List<Expense> expenses;

	// bi-directional many-to-one association to Income
	@OneToMany(mappedBy = "applicationUser")
	private List<Income> incomes;

	public ApplicationUser()
	{
	}

	public long getApplicationUserId()
	{
		return this.applicationUserId;
	}

	public void setApplicationUserId(long applicationUserId)
	{
		this.applicationUserId = applicationUserId;
	}

	public String getFirstName()
	{
		return this.firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return this.lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getLoginId()
	{
		return this.loginId;
	}

	public void setLoginId(String loginId)
	{
		this.loginId = loginId;
	}

	public String getLoginPassword()
	{
		return this.loginPassword;
	}

	public void setLoginPassword(String loginPassword)
	{
		this.loginPassword = loginPassword;
	}

	public List<Expense> getExpenses()
	{
		return this.expenses;
	}

	public void setExpenses(List<Expense> expenses)
	{
		this.expenses = expenses;
	}

	public Expense addExpens(Expense expens)
	{
		getExpenses().add(expens);
		expens.setApplicationUser(this);

		return expens;
	}

	public Expense removeExpens(Expense expens)
	{
		getExpenses().remove(expens);
		expens.setApplicationUser(null);

		return expens;
	}

	public List<Income> getIncomes()
	{
		return this.incomes;
	}

	public void setIncomes(List<Income> incomes)
	{
		this.incomes = incomes;
	}

	public Income addIncome(Income income)
	{
		getIncomes().add(income);
		income.setApplicationUser(this);

		return income;
	}

	public Income removeIncome(Income income)
	{
		getIncomes().remove(income);
		income.setApplicationUser(null);

		return income;
	}

}