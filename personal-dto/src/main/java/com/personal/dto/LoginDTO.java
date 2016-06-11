package com.personal.dto;

public class LoginDTO
{
	private String loginId;
	private String password;
	private String applicationUserId;

	public String getLoginId()
	{
		return loginId;
	}

	public void setLoginId(String loginId)
	{
		this.loginId = loginId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getApplicationUserId()
	{
		return applicationUserId;
	}

	public void setApplicationUserId(String applicationUserId)
	{
		this.applicationUserId = applicationUserId;
	}
}
