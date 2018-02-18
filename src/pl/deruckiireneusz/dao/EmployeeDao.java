package pl.deruckiireneusz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	 * @param employee
	 * @throws SQLException
	 */
	
	static public void saveEmployeeToDB(Connection conn, Employee employee) throws SQLException {
		if (employee.getId() == 0) {
			String sql = "INSERT INTO employee (name, surname, address, cellNo, notice, manHourCost) VALUES (?, ?, ?, ?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preStm = conn.prepareStatement(sql, generatedColumns);
			preStm.setString(1, employee.getName());
			preStm.setString(2, employee.getSurname());
			preStm.setString(3, employee.getAddress());
			preStm.setString(4, employee.getCellNo());
			preStm.setString(5, employee.getNotice());
			preStm.setDouble(6, employee.getManHourCost());
			preStm.executeUpdate();
			ResultSet rs = preStm.getGeneratedKeys();
			if (rs.next()) {
				employee.setId(rs.getInt(1));
			}
		}
		else {
			String sql = "UPDATE employee SET name=?, surname=?, address=?, cellNo=?, notice=?, manHourCost=? where id=?";
			PreparedStatement preStm = conn.prepareStatement(sql);
			preStm.setString(1, employee.getName());
			preStm.setString(2, employee.getSurname());
			preStm.setString(3, employee.getAddress());
			preStm.setString(4, employee.getCellNo());
			preStm.setString(5, employee.getNotice());
			preStm.setDouble(6, employee.getManHourCost());
			preStm.setInt(7, employee.getId());
			preStm.executeUpdate();
		}
	}
	
	/**
	 * deletes a single employee from database by id
	 * @param conn
	 * @param employee
	 * @throws SQLException
	 */
	
	static public void deleteEmployee(Connection conn, Employee employee) throws SQLException {
		if (employee.getId() != 0) {
			String sql = "DELETE FROM employee where id=?";
			PreparedStatement preStm = conn.prepareStatement(sql);
			preStm.setInt(1, employee.getId());
			preStm.executeUpdate();
			employee.setId(0);
		}
	}

}
