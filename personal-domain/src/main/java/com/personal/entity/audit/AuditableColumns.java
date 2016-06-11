/*
 * <copyright file=OrsAuditableColumns.java company="Department of Health">
 * Copyright 2013 Department of Health
 * All rights reserved
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of the Department of Health.
 * The intellectual and technical concepts contained
 * herein are proprietary to Health & Social Care Information Centre acting on behalf of the Department of Health.
 * 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Health & Social Care Information Centre.
 * </copyright>
 */
package com.personal.entity.audit;

import java.io.Serializable;

/*
 * Interface to be implemented by every persistent entity. 
 * JPA listener for audit columns will use this to load audit details.
 */
public interface AuditableColumns extends Serializable
{

	AuditColumns getAuditableColumns();

	void setAuditableColumns(AuditColumns auditColumns);

}
