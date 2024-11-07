package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbConnect.ConnectDB;
import entities.Employee;
import entities.Role;

public class RoleModel {

	public List<Role> findAll(){
		List<Role> records = new ArrayList<Role>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from role");
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Role record = new Role();
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
	
	public Role findById(int id) {
		Role record = null ;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from role where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				record = new Role();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			record = null;
		}finally {
			ConnectDB.disconnect();
		}
		return record;
	}
	
	public boolean create(Role role) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Insert into role(name) values(?)");
			statement.setString(1, role.getName());

			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(Role role) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update employee set name = ? where id = ?)");
			statement.setString(1, role.getName());
			statement.setInt(2, role.getId());
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
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Delete from role where id = ?");	
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
