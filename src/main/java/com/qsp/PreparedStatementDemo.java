package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementDemo {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/qsp","postgres","root");
			//3rd Step
			PreparedStatement ps =  con.prepareStatement("insert into Student values(?,?,?) ");
			ps.setInt(1,27);
			ps.setString(2,"Garima");
			ps.setLong(3,9876042410l);
			ps.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
