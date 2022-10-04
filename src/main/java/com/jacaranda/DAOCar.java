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
import java.util.ArrayList;
import java.util.List;

public class DAOCar {

	public DAOCar() {
		
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


	// Obtiene una lista con los coches
	public List<Car> getCars () throws Exception {
		List<Car> carList= new ArrayList<Car>();
		Connection connection = Conn.getConnection();
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select * from CAR_DATA");
			
		while(resultSet.next()) {
			Car car = new Car(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getBoolean(4) , resultSet.getDouble(5), LocalDate.parse(resultSet.getString(6)), resultSet.getString(7) );
			carList.add(car);
				
		}
		return  carList;
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
					
	public boolean updateCar(Car car) throws SQLException, ClassNotFoundException {
						
		Connection connection = Conn.getConnection();
		Statement st =connection.createStatement();
		boolean result = false;
						
		if(getCar(car.getId()) != null) {
					
			st.executeUpdate("UPDATE CAR_DATA SET model_year = '"+ car.getModelYear() + "', model_auto = '" + car.getModelAuto() + "', car_make = '" + car.getCarMaker() 
			+ "', availability = '" + car.isAvailability() + "', price = '"+ car.getPrice() + "', entry_date='" + car.getDateEntry() + "', id = '"+ car.getId() 
			+ "' where id = '"+ car.getId() + "';");
			result = true;
		};
		return result;
	}
					
					
	public  void deleteCar(String id) throws SQLException, ClassNotFoundException {
		Connection connection = Conn.getConnection();
		Statement statement=connection.createStatement(); 
		System.out.println("Introduce id para borrar:");
						
		statement.executeUpdate("DELETE FROM CAR_DATA WHERE id='" + id + "';");
	}
					
					
	public boolean validUser(String name, String pass) throws SQLException, ClassNotFoundException {
		Connection connection = Conn.getConnection();
		boolean valid = false;
		
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select * from USERS where name='" + name + "'and pass='" + pass + "'");
		if (!resultSet.getString(name).isEmpty()) {
			valid = true;
			//			Lo redirige a la pagina principal
		}
		//			Error no puede entrar, lo redirige a la pagina de error. <jsp:forwdard///
		return valid;
	}
	
	
	
	// Obtiene un usuario en concreto partiendo del parametro name.
	public User getUser (String name) throws Exception {
		User user=null;
		Connection connection = Conn.getConnection();
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select * from USERS where name='"+name+"';");
		if(resultSet.next()) {
			user= new User(resultSet.getString("name"), resultSet.getString("pass"));
		}else {
			throw new Exception("Error no se encontro el usuario");
		}
		
		return user;
		
	}
	// Obtiene una lista con los usuarios
	public List<User> getUssers () throws Exception {
		List<User> userList= new ArrayList<User>();
		Connection connection = Conn.getConnection();
		Statement st = connection.createStatement();
		ResultSet resultSet = st.executeQuery("select * from USERS");
		
		while(resultSet.next()) {
			User usuario= new User(resultSet.getString("name"), resultSet.getString("pass"));
			userList.add(usuario);
		}
		
		return  userList;
	}
	
}
