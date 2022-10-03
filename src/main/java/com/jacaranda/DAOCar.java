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
	
	public void getCars() throws SQLException, ClassNotFoundException {
		Connection connection = Conn.getConnection();
		
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
	
	public Car getCar(String idCar) throws SQLException, ClassNotFoundException {
		Connection connection = Conn.getConnection();
		Statement st = connection.createStatement();
		
		ResultSet resultSet = st.executeQuery("select * from CAR_DATA where id= '"+idCar+"';");
		Car car = null;
		while (resultSet.next()) {
		    //Crea el objeto car con la información de la consulta por id. 
		    //Obteniendo los datos por columnas
		    car = new Car(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(4) , resultSet.getDouble(5), LocalDate.parse(resultSet.getString(6)), resultSet.getString(7) );
		}
		    
		return car;
	}
	

	public void addCar(int model_year, String model_auto, String car_make, boolean availability, double price, LocalDate entry_date, String id) throws SQLException, IOException, ClassNotFoundException {
		String linea;
		
		Connection connection = Conn.getConnection();
		
		Statement st =connection.createStatement();
		ResultSet resulSet =st.executeQuery("Select id from CAR_DATA where id= id;");
		if(resulSet.getString(id).isEmpty()) {
//			esta vacia??? Crealo
			st.executeUpdate("INSERT INTO CAR_DATA (model_year, model_auto, car_make, availability, price, entry_date, id) values('', '', '', '', '', '', '');\n");
		}else {
			//VENTANA DE ERROR QUE YA EXISTE
		}
		
				
	}
	
	public boolean updateCar(int model_year, String model_auto, String car_make, boolean availability, double price, LocalDate entry_date, String id) throws SQLException, ClassNotFoundException {
		
		Connection connection = Conn.getConnection();
		Statement st =connection.createStatement();
		
		if(getCar(id) != null) {
			
			st.executeUpdate("UPDATE CAR_DATA SET model_year = '"+ model_year + "', model_auto = '" + model_auto + "', car_make = '" + car_make + "', availability = '" + availability + "', price = '"+ price + "', entry_date='" + entry_date + "', id = '"+ id + "';");//TO DO
			
		};
		return false;
	}
	
	
	
	public boolean getUsers(String name, String pass) throws SQLException, ClassNotFoundException {
		Connection connection = Conn.getConnection();
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
	
	public static void deleteCar(String id) throws SQLException, ClassNotFoundException {
		Connection connection = Conn.getConnection();
		Statement statement=connection.createStatement(); 
		System.out.println("Introduce id para borrar:");
		
		statement.executeUpdate("DELETE FROM CAR_DATA WHERE id='"+id+"\';");
	}
	
	
	
}
