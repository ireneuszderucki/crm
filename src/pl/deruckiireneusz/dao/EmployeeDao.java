package pl.deruckiireneusz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.deruckiireneusz.model.Customer;
import pl.deruckiireneusz.model.Employee;


public class EmployeeDao {
	/**
	 * loads all employees from database and creates an ArrayList
	 * @param conn
	 * @return ArrayList Employee
	 * @throws SQLException
	 */
	
	static public ArrayList<Employee> loadAllEmployees(Connection conn) throws SQLException {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT * FROM employee";
		PreparedStatement preStm = conn.prepareStatement(sql);
		ResultSet rs = preStm.executeQuery();
		while (rs.next()) {
			Employee loadedEmployee = new Employee();
			loadedEmployee.setId(rs.getInt("id"));
			loadedEmployee.setName(rs.getString("name"));
			loadedEmployee.setSurname(rs.getString("surname"));
			loadedEmployee.setAddress(rs.getString("address"));
			loadedEmployee.setCellNo(rs.getString("cellNo"));
			loadedEmployee.setNotice(rs.getString("notice"));
			loadedEmployee.setManHourCost(rs.getDouble("manHourCost"));
			employees.add(loadedEmployee);			
		}
		return employees;
	}
	
	/**
	 * loads employee from database by id
	 * @param conn
	 * @param id
	 * @return Employee employee or null
	 * @throws SQLException
	 */
	static public Employee loadEmployeeById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM employee where id=?";
		PreparedStatement preStm = conn.prepareStatement(sql);
		preStm.setInt(1, id);
		ResultSet rs = preStm.executeQuery();
		if (rs.next()) {
			Employee loadedEmployee = new Employee();
			loadedEmployee.setId(rs.getInt("id"));
			loadedEmployee.setName(rs.getString("name"));
			loadedEmployee.setSurname(rs.getString("surname"));
			loadedEmployee.setAddress(rs.getString("address"));
			loadedEmployee.setCellNo(rs.getString("cellNo"));
			loadedEmployee.setNotice(rs.getString("notice"));
			loadedEmployee.setManHourCost(rs.getDouble("manHourCost"));
			return loadedEmployee;
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
