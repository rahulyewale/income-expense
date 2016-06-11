package com.personal.entity.audit;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/*
 * Audit columns to keep track of who/when a record in database entity was created/modified.
 * Every non-lookup table has audit columns.
 * These will be embedded within relevant persistent entity.
 */
@Embeddable
public class AuditColumns
{

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_date")
	private Timestamp createdDate;

	@Column(name = "modified_by")
	private String modifiedBy;

	@Column(name = "modified_date")
	private Timestamp modifiedDate;

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

	public void setModifiedbBy(String modifiedBy)
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
