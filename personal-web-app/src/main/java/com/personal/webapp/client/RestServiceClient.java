/*
 * <copyright file=RestServiceClient.java company="Department of Health">
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
package com.personal.webapp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestServiceClient
{
	
	/**
	 * The rest template used for calling various rest web services.
	 */
	@Autowired
	@Qualifier("restServiceTemplate")
	private RestTemplate restTemplate;


	/**
	 * Gets the rest template used for calling various rest web services.
	 * @return the rest template used for calling various rest services.
	 */
	public RestTemplate getRestTemplate()
	{
		return restTemplate;
	}

	/**
	 * Sets the rest template used for calling various rest services.
	 * @param restTemplate the new rest template used for calling various rest services
	 */
	public void setRestTemplate(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}
	
	/**
	 * Invoke rest service.
	 *
	 * @param requestStringObject the request string object
	 * @param restServiceUrl the rest service url
	 * @param exceptionCode the exception code
	 * @return the string
	 * @throws CareIDExceptionImpl the care id exception impl
	 */
	public String invokeRestService(String requestStringObject, String restServiceUrl, String exceptionCode, String auditableResponseId) 
	{
		String serializableResponseObject = null;
		try
		{
			if(restServiceUrl ==  null)
			{
				throw new IllegalArgumentException("External service url is not configured");
			}
			
			//Adding Headers for media type as JSON String
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> httpEntity = new HttpEntity<String>(requestStringObject, headers);
			
			serializableResponseObject = getRestTemplate().postForObject(restServiceUrl, httpEntity, String.class);			
		}
		
		catch (Exception exception)
		{
			String asyncResponseIdMesg = "";
			if(auditableResponseId != null)
			{
				asyncResponseIdMesg = " for auditResponseId : "+ auditableResponseId;
			}
			
		}	
		return serializableResponseObject;		
	}		
}
