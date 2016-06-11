package com.personal.dao.impl;

import org.springframework.stereotype.Repository;

import com.personal.dao.IncomeTypeDAO;
import com.personal.entity.IncomeType;
import com.personal.generic.dao.impl.PersonalDAOImpl;


@Repository
public class IncomeTypeDAOImpl extends PersonalDAOImpl<IncomeType> implements IncomeTypeDAO 
{

}
