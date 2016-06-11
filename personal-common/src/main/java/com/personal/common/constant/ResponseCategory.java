package com.personal.common.constant;

public enum ResponseCategory {
	//CRUD success categories.
	/** The success. */
	SUCCESS,
	
	/** The read success. */
	READ_SUCCESS,
	
	/** The create success. */
	CREATE_SUCCESS,
	
	/** The modify success. */
	MODIFY_SUCCESS,
	
	/** The delete success. */
	DELETE_SUCCESS,
	
	//CRUD error categories.
	/** The error. */
	ERROR,
	
	/** The read error. */
	READ_ERROR,
	
	/** The create error. */
	CREATE_ERROR,
	
	/** The modify error. */
	MODIFY_ERROR,
	
	/** The delete error. */
	DELETE_ERROR,
	
	//Other categories.
	/** The date error. */
	DATE_ERROR
}
