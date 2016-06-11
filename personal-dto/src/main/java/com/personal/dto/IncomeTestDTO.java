package com.personal.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;

@JsonIgnoreType
@JsonIgnoreProperties
public class IncomeTestDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String txt;

	public IncomeTestDTO()
	{
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

}