package com.personal.dao.impl;

import org.springframework.stereotype.Repository;

import com.personal.dao.ItemInfoDAO;
import com.personal.entity.ItemInfo;
import com.personal.generic.dao.impl.PersonalDAOImpl;


@Repository
public class ItemInfoDAOImpl extends PersonalDAOImpl<ItemInfo> implements ItemInfoDAO 
{

}
