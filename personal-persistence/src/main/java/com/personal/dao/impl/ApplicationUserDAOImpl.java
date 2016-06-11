package com.personal.dao.impl;

import org.springframework.stereotype.Repository;

import com.personal.dao.ApplicationUserDAO;
import com.personal.entity.ApplicationUser;
import com.personal.generic.dao.impl.PersonalDAOImpl;


@Repository
public class ApplicationUserDAOImpl extends PersonalDAOImpl<ApplicationUser> implements ApplicationUserDAO 
{

}
