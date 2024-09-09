package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicUpdateQuery {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/qsp","postgres","root");
			//3rd Step
			PreparedStatement ps =  con.prepareStatement("update employee set name=? where id=?");
			System.out.print("Enter updated name : ");
			ps.setString(1,sc.next());
			System.out.print("Enter id : ");
			ps.setInt(2,sc.nextInt());
			//4th step
			ps.executeUpdate();
			System.out.println("____________Data Updated Succesfully____________");
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}

}
