package com.personal.domain.context;

import com.personal.common.context.ContextInfo;

public final class PersonalServiceContext
{

	/**
	 * Private Constructor for Utility Class.
	 */
	private PersonalServiceContext()
	{
	}

	/** The Constant localContextInfo. */
	private static final ThreadLocal<ContextInfo> LOCAL_CONTEXT_INFO = new ThreadLocal<ContextInfo>();

	/**
	 * Sets the.
	 * @param contextInfo the context info
	 */
	public static void setContextInfo(ContextInfo contextInfo)
	{
		LOCAL_CONTEXT_INFO.set(contextInfo);
	}

	/**
	 * Gets the.
	 * @return the context info
	 */
	public static ContextInfo getContextInfo()
	{
		return LOCAL_CONTEXT_INFO.get();
	}

	/**
	 * Unset.
	 */
	public static void unset()
	{
		LOCAL_CONTEXT_INFO.remove();
	}

	public static ContextInfo prepareContextInfo(final String operationName)
	{
		final ContextInfo contextInfo = new ContextInfo();
		PersonalServiceContext.setContextInfo(contextInfo);
		return contextInfo;
	}

}
