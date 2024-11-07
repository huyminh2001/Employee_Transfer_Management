package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbConnect.ConnectDB;
import entities.Letter;

public class LetterModel {
	
	public List<Letter> findAll(){
		List<Letter> records = new ArrayList<Letter>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from letter");
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Letter record = new Letter();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setRecordId(resultset.getInt("recordId"));
				record.setContent(resultset.getString("content"));
				
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
	
	public Letter findById(int id){
		Letter record = new Letter();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from letter where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				record = new Letter();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setRecordId(resultset.getInt("recordId"));
				record.setContent(resultset.getString("content"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			record = null;
		}finally {
			ConnectDB.disconnect();
		}
		return record;
	}
	
	public boolean create(Letter letter) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Insert into letter(name, recordId, content) values(?,?,?)");
			statement.setString(1, letter.getName());
			statement.setInt(2, letter.getRecordId());
			statement.setString(3, letter.getContent());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(Letter letter) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Update letter set name = ?, content = ? where id = ?");
			statement.setString(1, letter.getName());
			statement.setString(2, letter.getContent());
			statement.setInt(3, letter.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean delete(Letter letter) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("delete from letter where id = ?");
			statement.setInt(1, letter.getId());
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
