/*
 * <copyright file=ResponseData.java company="Department of Health"> Copyright
 * 2013 Department of Health All rights reserved NOTICE: All information
 * contained herein is, and remains the property of the Department of Health.
 * The intellectual and technical concepts contained herein are proprietary to
 * Health & Social Care Information Centre acting on behalf of the Department of
 * Health. Dissemination of this information or reproduction of this material is
 * strictly forbidden unless prior written permission is obtained from Health &
 * Social Care Information Centre. </copyright>
 */
package com.personal.common;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.personal.common.constant.ResponseCategory;
import com.personal.common.constant.ResponseSeverity;
import com.personal.common.constant.ResponseType;

/**
 * This is an abstract class acts as a parent class for all domain objects. This class contains base properties which are common across domain objects.
 * 
 * @author Krishna Kuntala
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData implements Serializable {
    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The type. */
    private ResponseType type;
    
    /** The severity. */
    private ResponseSeverity severity;
    
    /** The category. */
    private ResponseCategory category;
    
    /** The message. */
    private String message;
    
    /** The Constant SUCCESS_RESPONSE_DATA. */
    public static final ResponseData SUCCESS_RESPONSE_DATA = new ResponseData(ResponseType.SUCCESS, ResponseCategory.SUCCESS);
    
    /** The Constant ERROR_RESPONSE_DATA. */
    public static final ResponseData ERROR_RESPONSE_DATA = new ResponseData(ResponseType.ERROR, ResponseCategory.ERROR);
    
    /**
     * Instantiates a new response data.
     */
    private ResponseData() {
    }
    
    /**
     * Instantiates a new response data.
     * 
     * @param type
     *            the type
     * @param severity
     *            the severity
     * @param category
     *            the category
     * @param message
     *            the message
     */
    public ResponseData(ResponseType type, ResponseSeverity severity, ResponseCategory category, String message) {
        this();
        this.setType(type);
        this.setSeverity(severity);
        this.setCategory(category);
        this.setMessage(message);
    }
    
    /**
     * Instantiates a new response data.
     *
     * @param type
     *            the type
     * @param category
     *            the category
     * @param message
     *            the message
     */
    public ResponseData(ResponseType type, ResponseCategory category, String message) {
        this(type, null, category, message);
    }
    
    /**
     * Instantiates a new response data.
     *
     * @param type
     *            the type
     * @param category
     *            the category
     */
    public ResponseData(ResponseType type, ResponseCategory category) {
        this(type, null, category, null);
    }
    
    /**
     * Instantiates a new response data.
     * 
     * @param type
     *            the type
     * @param severity
     *            the severity
     * @param message
     *            the message
     */
    public ResponseData(ResponseType type, ResponseSeverity severity, String message) {
        this(type, severity, null, message);
    }
    
    /**
     * Instantiates a new response data.
     * 
     * @param type
     *            the type
     * @param message
     *            the message
     */
    public ResponseData(ResponseType type, String message) {
        this(type, null, null, message);
    }
    
    /**
     * Gets the type.
     * 
     * @return the type
     */
    public ResponseType getType() {
        return type;
    }
    
    /**
     * Sets the type.
     * 
     * @param type
     *            the new type
     */
    private void setType(ResponseType type) {
        this.type = type;
    }
    
    /**
     * Gets the severity.
     * 
     * @return the severity
     */
    public ResponseSeverity getSeverity() {
        return severity;
    }
    
    /**
     * Sets the severity.
     * 
     * @param severity
     *            the new severity
     */
    public void setSeverity(ResponseSeverity severity) {
        this.severity = severity;
    }
    
    /**
     * Gets the category.
     * 
     * @return the category
     */
    public ResponseCategory getCategory() {
        return category;
    }
    
    /**
     * Sets the category.
     * 
     * @param category
     *            the new category
     */
    public void setCategory(ResponseCategory category) {
        this.category = category;
    }
    
    /**
     * Gets the message.
     * 
     * @return the message
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Sets the message.
     * 
     * @param message
     *            the new message
     */
    private void setMessage(String message) {
        this.message = message;
    }
    
    
    
    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode()
    {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + ((type == null) ? 0 : type.hashCode());
	    return result;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
    @Override
    public boolean equals(Object obj)
    {
	    if (this == obj)
		    return true;
	    if (obj == null)
		    return false;
	    if (getClass() != obj.getClass())
		    return false;
	    ResponseData other = (ResponseData) obj;
	    if (type != other.type)
		    return false;
	    return true;
    }

	/*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " [type=" + type + ", severity=" + severity + ", category=" + category + ", message=" + message + "]";
    }
}
