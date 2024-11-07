package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dbConnect.ConnectDB;
import entities.Report;

public class ReportModel {
	
	public List<Report> findAll(){
		List<Report> records = new ArrayList<Report>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from report");
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Report record = new Report();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRecordId(resultset.getInt("recordId"));
				record.setContent(resultset.getString("content"));
				record.setDate(resultset.getDate("reportDate"));
				
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
	
	public Report findById(int id){
		Report record = new Report();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from report where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				record = new Report();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRecordId(resultset.getInt("recordId"));
				record.setContent(resultset.getString("content"));
				record.setDate(resultset.getDate("reportDate"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			record = null;
		}finally {
			ConnectDB.disconnect();
		}
		return record;
	}
	
	public boolean create(Report report) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Insert into report(name, employeeId, recordId, content, reportDate) values(?,?,?,?,?)");
			statement.setString(1, report.getName());
			statement.setInt(2, report.getEmployeeId());
			statement.setInt(3, report.getRecordId());
			statement.setString(4, report.getContent());
			statement.setDate(5, new java.sql.Date(new Date().getTime()));
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
//	public boolean update(Report report) {
//		boolean result = false;
//		try {
//			PreparedStatement statement = ConnectDB.connection().prepareStatement("Update report set content = ? where id = ?");
//			statement.setString(1, report.getContent());
//			statement.setInt(2, report.getId());
//			result = statement.executeUpdate() > 0;
//		} catch (Exception e) {
//			e.printStackTrace();
//			result = false;
//		}finally {
//			ConnectDB.disconnect();
//		}
//		return result;
//	}
	
	public boolean delete(Report report) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("delete from report where id = ?");
			statement.setInt(1, report.getId());
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
