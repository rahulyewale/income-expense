package com.personal.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.personal.dao.OrderDetailDAO;
import com.personal.entity.OrderDetail;
import com.personal.generic.dao.impl.PersonalDAOImpl;

/**
 */
@Repository
public class OrderDetailDAOImpl extends PersonalDAOImpl<OrderDetail> implements OrderDetailDAO
{
	@Override
	public List<OrderDetail> getOrderDetails() {
		

		List<OrderDetail> orderDetailsList = new ArrayList<OrderDetail>(0);
		try
		{
			Query query = getEntityManager().createNamedQuery("OrderDetail.findAll", OrderDetail.class);
			orderDetailsList = (List<OrderDetail>) query.getResultList();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return orderDetailsList;
	
	}
	
	@Override
	public void loadCsv(String filePath)
	{
		filePath = "E:\\Rahul\\sunilj\\import-export\\order-details-header.csv";
		
		Connection connection = null;
		ResultSet rs = null;
		connection = getEntityManager().unwrap(Session.class).connection();
		
		String insertTableSQL = "COPY public.order_details(sr_no,booking_date,company_name,pincode,state,document_no,service,mode,invoice_no,invoice_value,package_count,dimensions,rieter_weight,fedex_weight,status,delay_reason,address) FROM '";
		
		insertTableSQL = insertTableSQL + filePath + "' WITH CSV HEADER DELIMITER AS ','";
		
		//String insertTableSQL = "COPY public.order_details(sr_no,booking_date,company_name,pincode,state,document_no,service,mode,invoice_no,invoice_value,package_count,dimensions,rieter_weight,fedex_weight,status,delay_reason,address) FROM 'E:\\Rahul\\sunilj\\import-export\\order-details-header.csv' WITH CSV HEADER DELIMITER AS ','";

		PreparedStatement preparedStatement;
		try
		{
			preparedStatement = connection.prepareStatement(insertTableSQL);
			int noOfRecordsInerted = preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}
}
