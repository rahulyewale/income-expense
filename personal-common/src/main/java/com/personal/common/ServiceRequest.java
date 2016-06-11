package com.personal.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonIgnoreType;

import com.personal.common.context.ContextInfo;
import com.personal.common.json.util.JsonUtil;

@JsonIgnoreType
@JsonIgnoreProperties
public class ServiceRequest implements Serializable
{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The context info. */
	private ContextInfo contextInfo;

	/** The request objects. */
	private Map<String, Object> requestObjects;

	/**
	 * Instantiates a new service request.
	 */
	private ServiceRequest()
	{
		this.setRequestObjects(new HashMap<String, Object>());
	}

	/**
	 * Instantiates a new service request.
	 * @param contextInfo the context info
	 */
	public ServiceRequest(ContextInfo contextInfo)
	{
		this();
		this.setContextInfo(contextInfo);
	}

	/**
	 * Instantiates a new service request.
	 * @param contextInfo the context info
	 * @param key the key
	 * @param object the object
	 */
	public ServiceRequest(ContextInfo contextInfo, String key, Object object)
	{
		this(contextInfo);
		this.getRequestObjects().put(key, object);
	}

	/**
	 * Gets the context info.
	 * @return the context info
	 */
	public ContextInfo getContextInfo()
	{
		return contextInfo;
	}

	/**
	 * Sets the context info.
	 * @param contextInfo the new context info
	 */
	private void setContextInfo(ContextInfo contextInfo)
	{
		this.contextInfo = contextInfo;
	}

	/**
	 * Gets the request objects.
	 * @return the request objects
	 */
	public Map<String, Object> getRequestObjects()
	{
		return requestObjects;
	}

	/**
	 * Sets the request objects.
	 * @param requestObjects the request objects
	 */
	private void setRequestObjects(Map<String, Object> requestObjects)
	{
		this.requestObjects = requestObjects;
	}

	/**
	 * Adds the.
	 * @param key the key
	 * @param object the object
	 */
	public void add(String key, Object object)
	{
		this.getRequestObjects().put(key, object);
	}

	/**
	 * Gets the.
	 * @param key the key
	 * @return the object
	 */
	public Object get(String key)
	{
		return this.getRequestObjects().get(key);
	}

	/**
	 * This method is used get the serviceRequest Object which is stored in the
	 * map by name and type you are expecting. It performs first getting the
	 * object's JSON string and converting that JSON string to object.
	 * @param <T> the generic type
	 * @param key the key
	 * @param pojoClass the pojo class
	 * @return the object
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String key, Class<T> pojoClass)
	{
		// Checking if key and value present
		if (this.getRequestObjects().get(key) == null)
		{
			return null;
		}

		String jsonString = null;
		try
		{
			// Creating the JSONString
			jsonString = JsonUtil.convertObjectToJson(this.getRequestObjects().get(key));
		}
		catch (Exception ioException)
		{
		}
		// Creating the object from the JSON String
		if (StringUtils.isNotEmpty(jsonString))
		{
			try
			{
				return (T) JsonUtil.convertJsonToObject(jsonString, pojoClass);
			}
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}