package com.personal.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the order_details database table.
 * 
 */
@Entity
@Table(name="order_details")
@NamedQuery(name="OrderDetail.findAll", query="SELECT o FROM OrderDetail o")
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_details_id")
	private Integer orderDetailsId;

	private String address;

	@Column(name="booking_date")
	private String bookingDate;

	@Column(name="company_name")
	private String companyName;

	@Column(name="delay_reason")
	private String delayReason;

	private String dimensions;

	@Column(name="document_no")
	private String documentNo;

	@Column(name="fedex_weight")
	private Long fedexWeight;

	@Column(name="invoice_no")
	private String invoiceNo;

	@Column(name="invoice_value")
	private String invoiceValue;

	private String mode;

	@Column(name="package_count")
	private Long packageCount;

	private String pincode;

	@Column(name="rieter_weight")
	private Long rieterWeight;

	private String service;

	@Column(name="sr_no")
	private Long srNo;

	private String state;

	private String status;

	public OrderDetail() {
	}

	public Integer getOrderDetailsId() {
		return this.orderDetailsId;
	}

	public void setOrderDetailsId(Integer orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBookingDate() {
		return this.bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getDelayReason() {
		return this.delayReason;
	}

	public void setDelayReason(String delayReason) {
		this.delayReason = delayReason;
	}

	public String getDimensions() {
		return this.dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getDocumentNo() {
		return this.documentNo;
	}

	public void setDocumentNo(String documentNo) {
		this.documentNo = documentNo;
	}

	public Long getFedexWeight() {
		return this.fedexWeight;
	}

	public void setFedexWeight(Long fedexWeight) {
		this.fedexWeight = fedexWeight;
	}

	public String getInvoiceNo() {
		return this.invoiceNo;
	}

	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public String getInvoiceValue() {
		return this.invoiceValue;
	}

	public void setInvoiceValue(String invoiceValue) {
		this.invoiceValue = invoiceValue;
	}

	public String getMode() {
		return this.mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public Long getPackageCount() {
		return this.packageCount;
	}

	public void setPackageCount(Long packageCount) {
		this.packageCount = packageCount;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Long getRieterWeight() {
		return this.rieterWeight;
	}

	public void setRieterWeight(Long rieterWeight) {
		this.rieterWeight = rieterWeight;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Long getSrNo() {
		return this.srNo;
	}

	public void setSrNo(Long srNo) {
		this.srNo = srNo;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}