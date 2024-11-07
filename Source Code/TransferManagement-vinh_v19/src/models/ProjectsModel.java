package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dbConnect.ConnectDB;
import entities.Employee;
import entities.Projects;

public class ProjectsModel {

	public List<Projects> findAll(){
		List<Projects> records = new ArrayList<Projects>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from projects");
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Projects record = new Projects();
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
	
	public Projects findById(int id) {
		Projects record = null ;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from projects where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next()) {
				record = new Projects();
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
	
	public int getProjectId(String projectName) {
		int result = 0;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select id from projects where name = ?");
			statement.setString(1, projectName);
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
	
	public List<Projects> exclusiveCurrentProject(int excludeProjectId){
		List<Projects> records = new ArrayList<Projects>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from projects where id != ?");
			statement.setInt(1, excludeProjectId);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Projects record = new Projects();
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
	
	public boolean create(Projects projects) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Insert into projects(name) values(?)");
			statement.setString(1, projects.getName());

			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(Projects projects) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update projects set name = ? where id = ?)");
			statement.setString(1, projects.getName());
			statement.setInt(4, projects.getId());
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
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Delete from projects where id = ?");	
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
