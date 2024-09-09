package com.qsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchExecution {

	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5433/qsp","postgres","root");
			//3rd Step
			Statement st = con.createStatement();
			st.addBatch("insert into student values(101,'Tanisha',9787865675)");
			st.addBatch("insert into student values(102,'Payal',9797708768)");
			st.addBatch("update student set name='payaleee' where id=102");
			st.executeBatch();
			System.out.println("Batch executed");
			con.close();
		}
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
