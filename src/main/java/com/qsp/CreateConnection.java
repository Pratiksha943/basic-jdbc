package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection {
	public static void main(String[] args) {
		try {
			// 1st Step : load or register the driver
			Class.forName("org.postgresql.Driver");
			System.out.println("--------Driver is loaded--------");
			
			// 2nd Step : create connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/qsp", "postgres", "root");
			// System.out.println(con);
			System.out.println("--------Connection is done--------");
			
			// 3rd Step : Create Statement
			Statement stm = con.createStatement();
			System.out.println("--------Statement is created--------");
			
			// 4th Step : Execute the Query
			stm.execute("delete from Student where id=4");
			System.out.println("--------Query Exceuted--------");
			
			//5th Step : Close the connection 
			con.close();
			System.out.println("--------Connection Closed--------");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
