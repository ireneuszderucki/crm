package pl.deruckiireneusz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.deruckiireneusz.model.Customer;

//public class Customer {
//	private int id;
//	private String name;
//	private String surname;
//	private String birthday;

public class CustomerDao {
	/**
	 * loads all customers from database and creates an ArrayList
	 * @param conn
	 * @return ArrayList Customer
	 * @throws SQLException
	 */
	
	static public ArrayList<Customer> loadAllCustomers(Connection conn) throws SQLException {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		String sql = "SELECT * FROM customer";
		PreparedStatement preStm = conn.prepareStatement(sql);
		ResultSet rs = preStm.executeQuery();
		while (rs.next()) {
			Customer loadedCustomer = new Customer();
			loadedCustomer.setId(rs.getInt("id"));
			loadedCustomer.setName(rs.getString("name"));
			loadedCustomer.setSurname(rs.getString("surname"));
			loadedCustomer.setBirthday(rs.getString("birthday"));
			customers.add(loadedCustomer);			
		}
		return customers;
	}
	
	/**
	 * loads customer from database by id
	 * @param conn
	 * @param id
	 * @return Customer customer or null
	 * @throws SQLException
	 */
	static public Customer loadCustomerById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM customer where id=?";
		PreparedStatement preStm = conn.prepareStatement(sql);
		preStm.setInt(1, id);
		ResultSet rs = preStm.executeQuery();
		if (rs.next()) {
			Customer loadedCustomer = new Customer();
			loadedCustomer.setId(rs.getInt("id"));
			loadedCustomer.setName(rs.getString("name"));
			loadedCustomer.setSurname(rs.getString("surname"));
			loadedCustomer.setBirthday(rs.getString("birthday"));
			return loadedCustomer;
		}
		return null;
	}
	
	/**
	 * saves or updates the data in the database
	 * @param conn
	 * @param customer
	 * @throws SQLException
	 */
	
	static public void saveCustomerToDB(Connection conn, Customer customer) throws SQLException {
		if (customer.getId() == 0) {
			String sql = "INSERT INTO customer (name, surname, birthday) VALUES (?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preStm = conn.prepareStatement(sql, generatedColumns);
			preStm.setString(1, customer.getName());
			preStm.setString(2, customer.getSurname());
			preStm.setString(3, customer.getBirthday());
			preStm.executeUpdate();
			ResultSet rs = preStm.getGeneratedKeys();
			if (rs.next()) {
				customer.setId(rs.getInt(1));
			}
		}
		else {
			String sql = "UPDATE customer SET name=?, surname=?, birthday=? where id=?";
			PreparedStatement preStm = conn.prepareStatement(sql);
			preStm.setString(1, customer.getName());
			preStm.setString(2, customer.getSurname());
			preStm.setString(3, customer.getBirthday());
			preStm.setInt(4, customer.getId());
			preStm.executeUpdate();
		}
	}
	
	/**
	 * deletes a single customer from database by id
	 * @param conn
	 * @param customer
	 * @throws SQLException
	 */
	static public void deleteCustomer(Connection conn, Customer customer) throws SQLException {
		if (customer.getId() != 0) {
			String sql = "DELETE FROM customer where id=?";
			PreparedStatement preStm = conn.prepareStatement(sql);
			preStm.setInt(1, customer.getId());
			preStm.executeUpdate();
			customer.setId(0);
		}
	}

}
