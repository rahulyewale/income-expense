package com.personal.entity.audit;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.personal.domain.context.PersonalServiceContext;

/*
 * JPA listener to set audit column details whenever an entity is persisted.
 */
/**
 * The listener interface for receiving auditColumns events. The class that is
 * interested in processing a auditColumns event implements this interface, and
 * the object created with that class is registered with a component using the
 * component's <code>addAuditColumnsListener<code> method. When
 * the auditColumns event occurs, that object's appropriate
 * method is invoked.
 * @see AuditColumnsEvent
 */
public class AuditColumnsListener
{

	/**
	 * On create.
	 * @param entity the entity
	 */
	@PrePersist
	public void onCreate(Object entity)
	{

		if (entity instanceof AuditableColumns)
		{

			AuditableColumns auditableColumnsEntity = (AuditableColumns) entity;

			if (auditableColumnsEntity.getAuditableColumns() == null)
			{
				auditableColumnsEntity.setAuditableColumns(new AuditColumns());
			}

			if (null == auditableColumnsEntity.getAuditableColumns().getCreatedBy())
			{
				auditableColumnsEntity.getAuditableColumns().setCreatedBy(PersonalServiceContext.getContextInfo().getActionedBy());
			}

			if (null == auditableColumnsEntity.getAuditableColumns().getCreatedDate())
			{
				auditableColumnsEntity.getAuditableColumns().setCreatedDate(new Timestamp((new Date()).getTime()));
			}
		}
	}

	/**
	 * On persist.
	 * @param entity the entity
	 */
	@PreUpdate
	public void onPersist(Object entity)
	{

		if (entity instanceof AuditableColumns)
		{

			AuditableColumns auditableColumnsEntity = (AuditableColumns) entity;

			if (auditableColumnsEntity.getAuditableColumns() == null)
			{
				auditableColumnsEntity.setAuditableColumns(new AuditColumns());
			}

			if (null == auditableColumnsEntity.getAuditableColumns().getModifiedBy())
			{
				auditableColumnsEntity.getAuditableColumns().setModifiedbBy(PersonalServiceContext.getContextInfo().getActionedBy());
			}

			auditableColumnsEntity.getAuditableColumns().setModifiedDate(new Timestamp((new Date()).getTime()));
		}
	}
}
