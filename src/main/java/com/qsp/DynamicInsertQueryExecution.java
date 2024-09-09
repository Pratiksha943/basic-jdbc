package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicInsertQueryExecution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/qsp","postgres","root");
			//3rd Step
			PreparedStatement ps =  con.prepareStatement("insert into employee values(?,?,?)");
			System.out.print("Enter id : ");
			ps.setInt(1,sc.nextInt());
			System.out.print("Enter name : ");
			ps.setString(2,sc.next());
			System.out.print("Enter salary : ");
			ps.setDouble(3,sc.nextDouble());
			//4th step
			ps.executeUpdate();
			System.out.println("____________Query Executed____________");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}
