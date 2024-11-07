package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dbConnect.ConnectDB;
import entities.Department;
import entities.Location;

public class DepartmentModel {

	public List<Department> findAll(){
		List<Department> records = new ArrayList<Department>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from department");
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Department record = new Department();
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
	
	public Department findById(int id) {
		Department record = null ;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from department where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()) {
				record = new Department();
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
	
	public int getDepartmentId(String departmentName) {
		int result = 0;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select id from department where name = ?");
			statement.setString(1, departmentName);
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
	
	public List<Department> exclusiveCurrentDepartment(int excludeDepartmentId){
		List<Department> records = new ArrayList<Department>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from department where id != ?");
			statement.setInt(1, excludeDepartmentId);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Department record = new Department();
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
	
	public boolean create(Department department) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Insert into department(name) values(?)");
			statement.setString(1, department.getName());

			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(Department department) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update department set name = ? where id = ?)");
			statement.setString(1, department.getName());
			statement.setInt(2, department.getId());
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
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Delete from department where id = ?");	
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
