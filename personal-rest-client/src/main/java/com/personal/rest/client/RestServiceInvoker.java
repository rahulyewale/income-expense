
package com.personal.rest.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.personal.common.ServiceRequest;
import com.personal.common.ServiceResponse;

public class RestServiceInvoker
{

	/**
	 * The rest template used for calling various services of identity service.
	 */
	@Autowired
	private RestTemplate restTemplate;
	
	/** The rest service url. */
	private String restServiceURL;


	/**
	 * Gets the rest template which is used for calling various services of
	 * identity service.
	 * @return the rest template which is initialized
	 */
	public RestTemplate getRestTemplate()
	{
		return restTemplate;
	}

	/**
	 * Sets the rest template which is used for calling various services of
	 * identity service.
	 * @param restTemplate the new rest template to be used for calling various
	 *           services of identity service
	 */
	public void setRestTemplate(RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}

	/**
	 * Gets the identity service URL.
	 * @return the identity service URL to which web application is pointing.
	 */
	public String getRestServiceURL()
	{
		return restServiceURL;
	}

	/**
	 * Sets the identity service URL.
	 * @param restServiceURL the new identity service URL to which the web
	 *           application needs to be pointed.
	 */
	public void setRestServiceURL(String restServiceURL)
	{
		this.restServiceURL = restServiceURL;
	}

	public ServiceResponse invokeRestService(ServiceRequest serviceRequest, String serviceUrl)
	{
		ServiceResponse response = null;
		try
		{
			response = getRestTemplate().postForObject(getRestServiceURL() + serviceUrl.trim(), serviceRequest, ServiceResponse.class);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}

		return response;

	}

}
