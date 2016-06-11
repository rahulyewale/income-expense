package com.personal.dao.impl;

import org.springframework.stereotype.Repository;

import com.personal.dao.UserBankDetailsDAO;
import com.personal.entity.UserBankDetail;
import com.personal.generic.dao.impl.PersonalDAOImpl;


@Repository
public class UserBankDetailsDAOImpl extends PersonalDAOImpl<UserBankDetail> implements UserBankDetailsDAO 
{}
