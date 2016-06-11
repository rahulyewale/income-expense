/*
 * <copyright file=EPRDAOImpl.java company="Department of Health">
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
package com.personal.generic.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.personal.generic.dao.PersonalDAO;

public abstract class PersonalDAOImpl<T> implements PersonalDAO<T>
{

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/** The type. */
	private Class<T> type;

	@SuppressWarnings({ "rawtypes", "unchecked"})
	public PersonalDAOImpl()
	{
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	/**
	 * Gets the entity manager.
	 * @return the entity manager
	 */
	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	@Transactional
	public T save(final T object) throws Exception
	{
		try
		{
			getEntityManager().persist(object);
			getEntityManager().flush();
		}
		catch (Exception exception)
		{
			throw exception;

		}
		return object;
	}

	/*
	 * (non-Javadoc)
	 * @see uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#delete(java.lang.
	 * Object )
	 */
	@Transactional
	public void delete(final Object id) throws Exception
	{
		try
		{
			getEntityManager().remove(getEntityManager().getReference(type, id));
		}
		catch (Exception exception)
		{

		}
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#findByPrimaryKey(java
	 * .lang.Object)
	 */
	@Transactional
	public T findByPrimaryKey(final Object id) throws Exception
	{
		T object = null;
		try
		{

			object = getEntityManager().find(type, id);

		}
		catch (Exception exception)
		{
		}
		return object;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * uk.gov.hscs3ic.careid.framework.generic.dao.CareIdDAO#update(java.lang
	 * .Object , uk.gov.hscic.framework.context.ContextInfo)
	 */
	@Transactional
	public T update(final T object) throws Exception
	{
		T updatedObject = null;
		try
		{
			updatedObject = getEntityManager().merge(object);
			getEntityManager().flush();
		}
		catch (Exception exception)
		{
		}
		return updatedObject;
	}

}
