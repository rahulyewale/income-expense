/*
 * <copyright file=JsonConvertor.java company="Department of Health">
 * Copyright 2013 Department of Health
 * All rights reserved
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of the Department of Health.
 * The intellectual and technical concepts contained
 * herein are proprietary to Health & Social Care Information Centre acting on behalf of the Department of Health.
 * 
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Health & Social Care Information Centre.
 * </copyright>
 */
package com.personal.common.json.util;

import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.codehaus.jackson.map.ObjectMapper;



public final class JsonUtil
{

	/**
	 * Instantiates a new json convertor.
	 */
	private JsonUtil()
	{
	}

	/** The json object mapper. */
	private static ObjectMapper jsonObjectMapper = new ObjectMapper();

	/** The json factory. */
	private static MappingJsonFactory jsonFactory = new MappingJsonFactory();
	
	/**
	 * Convert Json String to Java Object.
	 *
	 * @param <T> the generic type
	 * @param jsonAsString the json as string
	 * @param pojoClass : Target Class for the Json String
	 * @return the object : Target Object after conversion
	 * @throws CareIDExceptionImpl the care id exception impl
	 */
	public static <T> Object convertJsonToObject(String jsonAsString, Class<T> pojoClass) throws Exception
	{
		final DateFormat df = new SimpleDateFormat("yyyyMMdd");
		jsonObjectMapper.setDateFormat(df);
		try
		{
			return jsonObjectMapper.readValue(jsonAsString, pojoClass);
		}
		catch (JsonParseException jsonParseException)
		{
			throw jsonParseException;
		}
		catch (JsonMappingException jsonMappingException)
		{
			throw jsonMappingException;

		}
		catch (IOException ioException)
		{
			throw ioException;
		}		
	}

	/**
	 * Convert Java Object to Json String.
	 *
	 * @param object : Object to be converted to Json String
	 * @return the Json string
	 * @throws CareIDExceptionImpl the care id exception impl
	 */
	public static String convertObjectToJson(Object object)  throws Exception
	{	
		StringWriter sw = new StringWriter();
		
		try
		{
			JsonGenerator jsonGenerator = jsonFactory.createJsonGenerator(sw);
			jsonObjectMapper.writeValue(jsonGenerator, object);
			sw.close();
		}		
		catch(Exception exception)
		{
			throw exception;
		}		
		return sw.getBuffer().toString();
	}

}
