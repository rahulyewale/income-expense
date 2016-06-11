package com.personal.generic.dao;

public interface PersonalDAO<T> {

	T save(T object) throws Exception;

	void delete(Object id) throws Exception;

	T findByPrimaryKey(Object id) throws Exception;

	T update(T object) throws Exception;
}
