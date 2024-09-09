package com.qsp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class  FetchingUsingResuletSet{

	public static void main(String[] args) {
		try {
			//1. Load or register the driver
			Class.forName("org.postgresql.Driver");
			//2. Create connection
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/qsp","postgres","root");
			//3. Create statement
			Statement stm = con.createStatement();
		
			//4. Execute statement
			stm.execute("select * from student");
			ResultSet rs = stm.getResultSet();
//			System.out.println(rs.next());
//			System.out.println(rs.getInt(1));
//			System.out.println(rs.getString(2));
//			System.out.println(rs.getLong(3));
//			System.out.println(rs.next());
//			System.out.println(rs.getInt("id"));
//			System.out.println(rs.getString("name"));
//			System.out.println(rs.getLong("phone"));

			while(rs.next())
			{
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println();
				
			}
			
			System.out.println("Fetching done------");
			//5 close connection
			con.close();
			System.out.println("Connection closed");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
