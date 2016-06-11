package com.personal.dao.impl;

import org.postgresql.copy.CopyIn;
import org.springframework.stereotype.Repository;

import com.personal.dao.ExpenseTypeDAO;
import com.personal.entity.ExpenseType;
import com.personal.generic.dao.impl.PersonalDAOImpl;


@Repository
public class ExpenseTypeDAOImpl extends PersonalDAOImpl<ExpenseType> implements ExpenseTypeDAO 
{
}
