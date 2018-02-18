package pl.deruckiireneusz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pl.deruckiireneusz.model.Vehicle;


public class VehicleDao {
//	private int id;
//	private int customer_id;
//	private String model;
//	private String brand;
//	private String productionY;
//	private String registrationNo;
//	private String nextInspectionDate;
	
	/**
	 * loads all vehicles from database and creates an ArrayList
	 * @param conn
	 * @return ArrayList Vehicle
	 * @throws SQLException
	 */
	
	static public ArrayList<Vehicle> loadAllVehicles(Connection conn) throws SQLException {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		String sql = "SELECT * FROM vehicle";
		PreparedStatement preStm = conn.prepareStatement(sql);
		ResultSet rs = preStm.executeQuery();
		while (rs.next()) {
			Vehicle loadedVehicle = new Vehicle();
			loadedVehicle.setId(rs.getInt("id"));
			loadedVehicle.setCustomer_id(rs.getInt("customer_id"));
			loadedVehicle.setModel(rs.getString("model"));
			loadedVehicle.setBrand(rs.getString("brand"));
			loadedVehicle.setProductionY(rs.getString("productionY"));
			loadedVehicle.setRegistrationNo(rs.getString("registrationNo"));
			loadedVehicle.setNextInspectionDate(rs.getString("nextInspectionDate"));
			vehicles.add(loadedVehicle);			
		}
		return vehicles;
	}
	
	/**
	 * loads a list of vehicles assigned to a customer by customer_id, list may be null
	 * @param conn
	 * @param id
	 * @return ArrayList Vehicle
	 * @throws SQLException
	 */
	static public ArrayList<Vehicle> loadAllVehiclesByCustomerId(Connection conn, int id) throws SQLException {
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		String sql = "SELECT * FROM vehicle where customer_id=?";
		PreparedStatement preStm = conn.prepareStatement(sql);
		preStm.setInt(1, id);
		ResultSet rs = preStm.executeQuery();
		while (rs.next()) {
			Vehicle loadedVehicle = new Vehicle();
			loadedVehicle.setId(rs.getInt("id"));
			loadedVehicle.setCustomer_id(rs.getInt("customer_id"));
			loadedVehicle.setModel(rs.getString("model"));
			loadedVehicle.setBrand(rs.getString("brand"));
			loadedVehicle.setProductionY(rs.getString("productionY"));
			loadedVehicle.setRegistrationNo(rs.getString("registrationNo"));
			loadedVehicle.setNextInspectionDate(rs.getString("nextInspectionDate"));
			vehicles.add(loadedVehicle);			
		}
		return vehicles;
	}
	
	
	
	/**
	 * loads vehicle from database by id
	 * @param conn
	 * @param id
	 * @return Vehicle vehicle or null
	 * @throws SQLException
	 */
	static public Vehicle loadVehicleById(Connection conn, int id) throws SQLException {
		String sql = "SELECT * FROM vehicle where id=?";
		PreparedStatement preStm = conn.prepareStatement(sql);
		preStm.setInt(1, id);
		ResultSet rs = preStm.executeQuery();
		if (rs.next()) {
			Vehicle loadedVehicle = new Vehicle();
			loadedVehicle.setId(rs.getInt("id"));
			loadedVehicle.setCustomer_id(rs.getInt("customer_id"));
			loadedVehicle.setModel(rs.getString("model"));
			loadedVehicle.setBrand(rs.getString("brand"));
			loadedVehicle.setProductionY(rs.getString("productionY"));
			loadedVehicle.setRegistrationNo(rs.getString("registrationNo"));
			loadedVehicle.setNextInspectionDate(rs.getString("nextInspectionDate"));
			return loadedVehicle;
		}
		return null;
	}
	
	/**
	 * saves or updates the data in the database
	 * @param conn
	 * @param vehicle
	 * @throws SQLException
	 */
	
	static public void saveVehicleToDB(Connection conn, Vehicle vehicle) throws SQLException {
		if (vehicle.getId() == 0) {
			String sql = "INSERT INTO vehicle (customer_id, model, brand, productionY, registrationNo, nextInspectionDate)"
					+ " VALUES (?, ?, ?, ?, ?, ?)";
			String generatedColumns[] = { "ID" };
			PreparedStatement preStm = conn.prepareStatement(sql, generatedColumns);
			preStm.setInt(1, vehicle.getCustomer_id());
			preStm.setString(2, vehicle.getModel());
			preStm.setString(3, vehicle.getBrand());
			preStm.setString(4, vehicle.getProductionY());
			preStm.setString(5, vehicle.getRegistrationNo());
			preStm.setString(6, vehicle.getNextInspectionDate());
			preStm.executeUpdate();
			ResultSet rs = preStm.getGeneratedKeys();
			if (rs.next()) {
				vehicle.setId(rs.getInt(1));
			}
		}
		else {
			String sql = "UPDATE vehicle SET customer_id=?, model=?, brand=?, productionY=?, registrationNo=?, nextInspectionDate=?"
					+ " where id=?";
			PreparedStatement preStm = conn.prepareStatement(sql);
			preStm.setInt(1, vehicle.getCustomer_id());
			preStm.setString(2, vehicle.getModel());
			preStm.setString(3, vehicle.getBrand());
			preStm.setString(4, vehicle.getProductionY());
			preStm.setString(5, vehicle.getRegistrationNo());
			preStm.setString(6, vehicle.getNextInspectionDate());
			preStm.setInt(7, vehicle.getId());
			preStm.executeUpdate();
		}
	}
	
	/**
	 * deletes a single vehicle from database by id
	 * @param conn
	 * @param vehicle
	 * @throws SQLException
	 */
	
	static public void deleteVehicle(Connection conn, Vehicle vehicle) throws SQLException {
		if (vehicle.getId() != 0) {
			String sql = "DELETE FROM vehicle where id=?";
			PreparedStatement preStm = conn.prepareStatement(sql);
			preStm.setInt(1, vehicle.getId());
			preStm.executeUpdate();
			vehicle.setId(0);
		}
	}


}
