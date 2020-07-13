package com.cf.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) throws Exception{
		
		String url = "jdbc:mysql://localhost:3306/webform_customer_tracker?useSSL=false&serverTimeZone=utc";
		
		String user = "formdatabase";
		
		String password = "formdatabase";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection(url,user,password);
		
		System.out.println("Successful connection");
	}

}
