package com.personal.utility.service.util;

// Create the table test before running the file: 
//create table public.test(col1 int , col2 int);
//Compile using javac -classpath ./edb-jdbc14.jar pgCopy.java
// Run using java -cp ./edb-jdbc14.jar;. pgCopy

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.postgresql.copy.CopyIn;
import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

public class PGCopy
{
	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pst = null;
		/*
		 * These are the insert values You can also build them from a list or you
		 * can accept the entries programatically and then separate them with the
		 * delimeter and build a byte array | is used a delimiter between two
		 * fields you can use your own here and replace the same in copyIn call
		 */
		byte[] insert_values = "1|10\n2|20\n3|30\n4|40".getBytes();

		// These are my connection parameters
		String url = "jdbc:postgresql://localhost/personal";
		String user = "postgres";
		String password = "Password1";
		CopyIn cpIN = null;
		String driver = "org.postgresql.Driver";
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			CopyManager cm = new CopyManager((BaseConnection) con);
			/*
			 * Copy command Replace public.test(col1, col2) with you table Name and
			 * replace | with the delimeter of you choice. It should be same as the
			 * delimeter used in defining the variable byte[] insert_values
			 */
			
			
			String insertTableSQL = "COPY public.order_details(sr_no,booking_date,company_name,pincode,state,document_no,service,mode,invoice_no,invoice_value,package_count,dimensions,rieter_weight,fedex_weight,status,delay_reason,address) FROM '";
			
			insertTableSQL = insertTableSQL + "' STDIN WITH CSV HEADER DELIMITER AS ','";
			
			
			//cpIN = cm.copyIn("COPY public.test(col1, col2) FROM STDIN WITH DELIMITER '|'");
			
			cpIN = cm.copyIn(insertTableSQL);

			cpIN.writeToCopy(insert_values, 0, insert_values.length);
			cpIN.endCopy();
			System.out.println("Below Values are inserted");
			System.out.println(new String(insert_values));
		}
		catch (SQLException ex)
		{
		}
		catch (ClassNotFoundException ex)
		{
		}
		finally
		{
			try
			{
				if (con != null)
					con.close();
			}
			catch (SQLException ex)
			{
			}
		}
	}
	
	public void loadCSV(byte[] insert_values)
	{
		Connection con = null;
		/*
		 * These are the insert values You can also build them from a list or you
		 * can accept the entries programatically and then separate them with the
		 * delimeter and build a byte array | is used a delimiter between two
		 * fields you can use your own here and replace the same in copyIn call
		 */
		// These are my connection parameters
		String url = "jdbc:postgresql://localhost/personal";
		String user = "postgres";
		String password = "Password1";
		CopyIn cpIN = null;
		String driver = "org.postgresql.Driver";
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			CopyManager cm = new CopyManager((BaseConnection) con);
			/*
			 * Copy command Replace public.test(col1, col2) with you table Name and
			 * replace | with the delimeter of you choice. It should be same as the
			 * delimeter used in defining the variable byte[] insert_values
			 */
			
			
			String insertTableSQL = "COPY public.order_details(sr_no,booking_date,company_name,pincode,state,document_no,service,mode,invoice_no,invoice_value,package_count,dimensions,rieter_weight,fedex_weight,status,delay_reason,address) FROM ";
			
			insertTableSQL = insertTableSQL + " STDIN WITH CSV HEADER DELIMITER AS ','";
			
			
			//cpIN = cm.copyIn("COPY public.test(col1, col2) FROM STDIN WITH DELIMITER '|'");
			
			cpIN = cm.copyIn(insertTableSQL);

			cpIN.writeToCopy(insert_values, 0, insert_values.length);
			cpIN.endCopy();
			System.out.println("Below Values are inserted");
			System.out.println(new String(insert_values));
		}
		catch (SQLException ex)
		{
			ex.printStackTrace();
		}
		catch (ClassNotFoundException ex)
		{
		}
		finally
		{
			try
			{
				if (con != null)
					con.close();
			}
			catch (SQLException ex)
			{
			}
		}
	}
}