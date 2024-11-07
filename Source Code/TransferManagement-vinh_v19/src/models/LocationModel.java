package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dbConnect.ConnectDB;
import entities.Location;
import entities.Projects;

public class LocationModel {
	
	public List<Location> findAll(){
		List<Location> records = new ArrayList<Location>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from location");
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Location record = new Location();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setAllowances(resultset.getDouble("allowances"));
				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
			records = null;
		}finally {
			ConnectDB.disconnect();
		}
		return records;
	}
	
	public Location findById(int id) {
		Location record = null ;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from location where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()) {
				record = new Location();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setAllowances(resultset.getDouble("allowances"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			record = null;
		}finally {
			ConnectDB.disconnect();
		}
		return record;
	}
	
	public int getLocationId(String locationName) {
		int result = 0;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select id from location where name = ?");
			statement.setString(1, locationName);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()) {
				result = resultset.getInt("id");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}
	
	public List<Location> exclusiveCurrentLocation(int excludeLocationId){
		List<Location> records = new ArrayList<Location>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from location where id != ?");
			statement.setInt(1, excludeLocationId);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Location record = new Location();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				
				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
			records = null;
		}finally {
			ConnectDB.disconnect();
		}
		return records;
	}
	
	public boolean create(Location location) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Insert into Location(name) values(?)");
			statement.setString(1, location.getName());

			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(Location location) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update location set name = ? where id = ?)");
			statement.setString(1, location.getName());
			statement.setInt(2, location.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean delete(int id) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Delete from location where id = ?");	
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
}
