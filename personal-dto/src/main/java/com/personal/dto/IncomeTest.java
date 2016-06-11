package com.personal.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;

@JsonIgnoreType
@JsonIgnoreProperties
public class IncomeTest implements Serializable
{
	private static final long serialVersionUID = 1L;
	

	private List<String> txt;

	

	public IncomeTest()
	{
	}



	public List<String> getTxt() {
		return txt;
	}



	public void setTxt(List<String> txt) {
		this.txt = txt;
	}

	
	

}