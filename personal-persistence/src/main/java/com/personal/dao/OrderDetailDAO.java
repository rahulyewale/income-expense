/*
 * <copyright file=ProductMstDAO.java company="Department of Health">
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
package com.personal.dao;

import java.util.List;

import com.personal.entity.OrderDetail;
import com.personal.generic.dao.PersonalDAO;

public interface OrderDetailDAO  extends PersonalDAO<OrderDetail>
{
	public List<OrderDetail> getOrderDetails();
	
	public void loadCsv(String filePath);
}
