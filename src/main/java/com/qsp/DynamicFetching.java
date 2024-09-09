package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicFetching {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/qsp","postgres","root");
				//3rd Step
//				PreparedStatement ps =  con.prepareStatement("select * from employee");
				System.out.println("Enter id : ");
				PreparedStatement ps =  con.prepareStatement("select * from employee where id=?");
				ps.setInt(1, sc.nextInt());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt("id"));
					System.out.println(rs.getString("name"));
					System.out.println(rs.getDouble("salary"));
				}
//				ResultSet rs = ps.executeQuery();
//				while(rs.next())
//				{
//					System.out.println(" ID   | "+rs.getInt("id"));
//					System.out.println(" Name | "+rs.getString("name"));
//					System.out.println("Salary| "+rs.getDouble("salary"));
//					System.out.println("______________");
//				}
//				ps.setInt(1,sc.nextInt());
				//4th step
				ps.executeUpdate();
				
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
