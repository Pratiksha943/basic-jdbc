package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnectionAssignment {

	public static void main(String[] args) {
		try {
			//1. Load or register the driver
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			//2. Create connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/qsp","postgres","root");
			System.out.println("Connection created");
			//3. Create statement
			Statement smt = con.createStatement();
			System.out.println("Statement Created");
			//4. Execute statement
			//smt.execute("insert into department values(105,'E&TC','J. N. Thorat')");
			smt.execute("update department set dhod='R. S. Panapalli' where did=104");
			System.out.println("Query/stmt executed");
			//5 close connection
			con.close();
			System.out.println("Connection closed");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
