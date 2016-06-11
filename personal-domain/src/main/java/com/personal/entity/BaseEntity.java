package com.personal.entity;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import com.personal.entity.audit.AuditColumns;
import com.personal.entity.audit.AuditColumnsListener;
import com.personal.entity.audit.AuditableColumns;

@EntityListeners(AuditColumnsListener.class)
@MappedSuperclass
public  class BaseEntity implements AuditableColumns
{

	/** The Constant serialVersionUID. */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;

	private AuditColumns auditColumns;

	@Override
	public AuditColumns getAuditableColumns()
	{
		return auditColumns;
	}

	@Override
	public void setAuditableColumns(AuditColumns auditColumns)
	{
		this.auditColumns = auditColumns;
		
	}

}
