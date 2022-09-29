package com.jacaranda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOCar {

	public DAOCar() {
		
	}
	
public void getCars() throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/concesionario?useSSL=false", "toor", "toor");
		
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select * from CAR_DATA");
		System.out.println("ModelYear, ModelAuto, CarMaker, Availability, Price, EntryDate, ID");

		while(resultSet.next()) {
			System.out.println(resultSet.getString(0) + ", "
							+ resultSet.getString(1)
							+ ", " + resultSet.getString(2)
							+ ", " + resultSet.getString(3)
							+ ", " + resultSet.getString(4)
							+ ", " + resultSet.getString(5)
							+ ", " + resultSet.getString(6));
		}

	}
//	public static  java.sql.Connection getMySqlConnection( String username, String pass){
//		try {
//			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//			String url = "jdbc:mysql:localhost:3306/concesionario";
//			Connection conn = DriverManager.getConnection(url, username, pass);
//			if (conn != null) {
//				System.out.println("--------> CONNECTED TO SERVER: CONCESIONARIO" );
//			}else {
//				System.out.println("--------> UNABLE TO CONNECT TO SERVER: CONCESIONARIO");
//			}
//			return conn;
//		} catch (Exception e) {
//			System.out.println("ERROR "+ e);
//			
//			return null;
//		}
//	}
}
