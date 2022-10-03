package src.main.java.com.jacaranda;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

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
	
	public boolean getCar(String idCar) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/concesionario?useSSL=false", "toor", "toor");
		boolean bandera=false;
		
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select id from CAR_DATA where id="+idCar+";");
		if (resultSet.getString(idCar).isEmpty()) {
//			Error, no se encuentra el coche///
		}else {
			ResultSet result = st.executeQuery("select id from CAR_DATA where id="+idCar+";");
			bandera=true;
		}
		return bandera;
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

	public void addCar(int model_year, String model_auto, String car_make, boolean availability, double price, LocalDate entry_date, String id) throws SQLException, IOException {
		String linea;
		
		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "toor", "toor");
		
		Statement st =connection.createStatement();
		ResultSet resulSet =st.executeQuery("Select id from CAR_DATA where id= id;");
		if(resulSet.getString(id).isEmpty()) {
//			esta vacia??? Crealo
			st.executeUpdate("INSERT INTO CAR_DATA (model_year, model_auto, car_make, availability, price, entry_date, id) values('', '', '', '', '', '', '');\n");
		}else {
			//VENTANA DE ERROR QUE YA EXISTE
		}
		
		
		while (resulSet.next()) {
			System.out.println((resulSet.getString(1)+ " , " +
			resulSet.getString(2)+ " , "+ resulSet.getString(3)+ " , "+ resulSet.getString(4)+" ,"+
			resulSet.getString(5)+ resulSet.getString(6)+ "\n"));			
						
			}			
	}
	
	public boolean modifyCar(int model_year, String model_auto, String car_make, boolean availability, double price, LocalDate entry_date, String id) throws SQLException {
		
		Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "toor", "toor");
		Statement st =connection.createStatement();
		
		if(getCar(id)) {
			
			st.executeUpdate("UPDATE CAR_DATA SET model_year = ''");//TO DO
			
		};
		return false;
	}
	
	
	
	public boolean getUsers(String name, String pass) throws SQLException {
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/concesionario?useSSL=false", "toor", "toor");
		boolean bandera=false;
		
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select * from USERS where name="+name+"and pass="+pass);
		if (resultSet.getString(name).isEmpty()) {
//			Error no puede entrar, lo redirige a la pagina de error. <jsp:forwdard///
		}else {
//			Lo redirige a la pagina principal///
			bandera=true;
		}
		return bandera;
	}
	
	public static void deleteCar(String id) throws SQLException {
		Connection connection = DriverManager.getConnection(
		"jdbc:mysql://localhost:3306/concesionario?useSSL=false", "toor", "toor");
		
		Statement statement=connection.createStatement(); 
		System.out.println("Introduce id para borrar:");
		
		statement.executeUpdate("DELETE FROM CAR_DATA WHERE id='"+id+"\';");
	}
	
	
	
}
