package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dbConnect.ConnectDB;
import entities.Employee;
import entities.Projects;
import entities.Records;

public class RecordModel {

	public List<Records> findAll() {
		List<Records> records = new ArrayList<Records>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from record ");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Records record = new Records();
				record.setId(resultset.getInt("id"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRequestFor(resultset.getInt("requestFor"));
				record.setLocationFrom(resultset.getInt("locationFrom"));
				record.setLocationTo(resultset.getInt("locationTo"));
				record.setProjectFrom(resultset.getInt("projectFrom"));
				record.setProjectTo(resultset.getInt("projectTo"));
				record.setDepartmentFrom(resultset.getInt("departmentFrom"));
				record.setDepartmentTo(resultset.getInt("departmentTo"));
				record.setTransferRelievingDate(resultset.getDate("transferRelievingDate"));
				record.setTransferJoiningDate(resultset.getDate("transferJoiningDate"));
				record.setCreatedDate(resultset.getDate("createdDate"));
				record.setStatus(resultset.getInt("status"));

				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
			records = null;
		} finally {
			ConnectDB.disconnect();
		}
		return records;
	}

	public Records findById(int id) {
		Records record = null;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from record where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				record = new Records();
				record.setId(resultset.getInt("id"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRequestFor(resultset.getInt("requestFor"));
				record.setLocationFrom(resultset.getInt("locationFrom"));
				record.setLocationTo(resultset.getInt("locationTo"));
				record.setProjectFrom(resultset.getInt("projectFrom"));
				record.setProjectTo(resultset.getInt("projectTo"));
				record.setDepartmentFrom(resultset.getInt("departmentFrom"));
				record.setDepartmentTo(resultset.getInt("departmentTo"));
				record.setTransferRelievingDate(resultset.getDate("transferRelievingDate"));
				record.setTransferJoiningDate(resultset.getDate("transferJoiningDate"));
				record.setCreatedDate(resultset.getDate("createdDate"));
				record.setStatus(resultset.getInt("status"));

			}
		} catch (Exception e) {
			e.printStackTrace();
			record = null;
		} finally {
			ConnectDB.disconnect();
		}
		return record;
	}

	public List<Records> findByEmployeeName(String employeeName) {
		List<Records> records = new ArrayList<Records>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(
					"select * from record r join employee e on r.employeeId = e.id where e.name like ?");
			statement.setString(1, "%" + employeeName + "%");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Records record = new Records();
				record.setId(resultset.getInt("id"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRequestFor(resultset.getInt("requestFor"));
				record.setLocationFrom(resultset.getInt("locationFrom"));
				record.setLocationTo(resultset.getInt("locationTo"));
				record.setProjectFrom(resultset.getInt("projectFrom"));
				record.setProjectTo(resultset.getInt("projectTo"));
				record.setDepartmentFrom(resultset.getInt("departmentFrom"));
				record.setDepartmentTo(resultset.getInt("departmentTo"));
				record.setTransferRelievingDate(resultset.getDate("transferRelievingDate"));
				record.setTransferJoiningDate(resultset.getDate("transferJoiningDate"));
				record.setCreatedDate(resultset.getDate("createdDate"));
				record.setStatus(resultset.getInt("status"));

				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
			records = null;
		} finally {
			ConnectDB.disconnect();
		}
		return records;
	}

	public List<Records> findByRequestFor(String employeeName) {
		List<Records> records = new ArrayList<Records>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(
					"select * from record r join employee e on r.requestFor = e.id where e.name like ?");
			statement.setString(1, "%" + employeeName + "%");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Records record = new Records();
				record.setId(resultset.getInt("id"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRequestFor(resultset.getInt("requestFor"));
				record.setLocationFrom(resultset.getInt("locationFrom"));
				record.setLocationTo(resultset.getInt("locationTo"));
				record.setProjectFrom(resultset.getInt("projectFrom"));
				record.setProjectTo(resultset.getInt("projectTo"));
				record.setDepartmentFrom(resultset.getInt("departmentFrom"));
				record.setDepartmentTo(resultset.getInt("departmentTo"));
				record.setTransferRelievingDate(resultset.getDate("transferRelievingDate"));
				record.setTransferJoiningDate(resultset.getDate("transferJoiningDate"));
				record.setCreatedDate(resultset.getDate("createdDate"));
				record.setStatus(resultset.getInt("status"));

				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
			records = null;
		} finally {
			ConnectDB.disconnect();
		}
		return records;
	}


	public List<Records> findBy_ProjectDepartmentLocation_FromTo(String employeeName, String requestFor,
			String projectFrom, String projectTo, String departmentFrom, String departmentTo, String locationFrom,
			String locationTo, String leavingDateFrom, String leavingDateTo, String joiningDateFrom,
			String joiningDateTo, String createdDateFrom, String createdDateTo, String statusPending,
			String statusApproved, String statusRejected) {
		List<Records> records = new ArrayList<Records>();
		StringBuilder query = new StringBuilder("SELECT DISTINCT r.* FROM record r "
			    + "LEFT JOIN (SELECT e.* FROM employee e LEFT JOIN employee re ON re.id = e.id) as joined_emp ON joined_emp.id = r.requestFor "
			    + "LEFT JOIN employee e2 ON r.requestFor = e2.id "  // Replace 'e.id' with 'e2.id'
			    + "LEFT JOIN projects p ON r.projectFrom = p.id "
			    + "LEFT JOIN department d ON d.id = r.departmentFrom "
			    + "LEFT JOIN location l ON l.id = r.locationFrom "
			    + "LEFT JOIN projects p2 ON p2.id = r.projectTo "
			    + "LEFT JOIN department d2 ON d2.id = r.departmentTo "
			    + "LEFT JOIN location l2 ON l2.id = r.locationTo "
			    + "WHERE 1=1"
			);
		List<String> parameters = new ArrayList<>();

		if (employeeName != null && !employeeName.isEmpty()) {
			query.append(" AND e2.name LIKE ?");
			parameters.add("%" + employeeName + "%");
		}

		if (requestFor != null  && !requestFor.isEmpty()) {
	        query.append(" AND joined_emp.name LIKE ? ");
	        parameters.add("%" + requestFor + "%");
	    }

		// Handle projectTo filter
		if (projectFrom != null) {
			if (projectFrom.equals("All")) {
				// No additional filter for "All"
			} else if (projectFrom.equals("None")) {
				query.append(" AND r.projectFrom IS NULL");
			} else {
				query.append(" AND p.name LIKE ?");
				parameters.add("%" + projectFrom + "%");
			}
		}

		if (projectTo != null) {
			if (projectTo.equals("All")) {
				// No additional filter for "All"
			} else if (projectTo.equals("None")) {
				query.append(" AND r.projectTo IS NULL");
			} else {
				query.append(" AND p2.name LIKE ?");
				parameters.add("%" + projectTo + "%");
			}
		}

		// Handle departmentFrom filter
		if (departmentFrom != null) {
			if (departmentFrom.equals("All")) {
				// No additional filter for "All"
			} else if (departmentFrom.equals("None")) {
				query.append(" AND r.departmentFrom IS NULL");
			} else {
				query.append(" AND d.name LIKE ?");
				parameters.add("%" + departmentFrom + "%");
			}
		}

		// Handle departmentTo filter
		if (departmentTo != null) {
			if (departmentTo.equals("All")) {
				// No additional filter for "All"
			} else if (departmentTo.equals("None")) {
				query.append(" AND r.departmentTo IS NULL");
			} else {
				query.append(" AND d2.name LIKE ?");
				parameters.add("%" + departmentTo + "%");
			}
		}

		// Handle locationFrom filter
		if (locationFrom != null) {
			if (locationFrom.equals("All")) {
				// No additional filter for "All"
			} else if (locationFrom.equals("None")) {
				query.append(" AND r.locationFrom IS NULL");
			} else {
				query.append(" AND l.name LIKE ?");
				parameters.add("%" + locationFrom + "%");
			}
		}

		// Handle locationTo filter
		if (locationTo != null) {
			if (locationTo.equals("All")) {
				// No additional filter for "All"
			} else if (locationTo.equals("None")) {
				query.append(" AND r.locationTo IS NULL");
			} else {
				query.append(" AND l2.name LIKE ?");
				parameters.add("%" + locationTo + "%");
			}
		}

		if (leavingDateFrom != null && leavingDateTo != null) {

			query.append(" AND transferRelievingDate BETWEEN ? AND ? ");
			parameters.add(leavingDateFrom);
			parameters.add(leavingDateTo);

		} else if (leavingDateFrom != null) {

			query.append(" AND transferRelievingDate >= ? ");
			parameters.add(leavingDateFrom);

		} else if (leavingDateTo != null) {

			query.append(" AND transferRelievingDate <= ? ");
			parameters.add(leavingDateTo);
		}

		if (joiningDateFrom != null && joiningDateTo != null) {

			query.append(" AND transferJoiningDate BETWEEN ? AND ? ");
			parameters.add(joiningDateFrom);
			parameters.add(joiningDateTo);

		} else if (joiningDateFrom != null) {

			query.append(" AND transferJoiningDate >= ? ");
			parameters.add(joiningDateFrom);

		} else if (joiningDateTo != null) {

			query.append(" AND transferJoiningDate <= ? ");
			parameters.add(joiningDateTo);
		}

		if (createdDateFrom != null && createdDateTo != null) {

			query.append(" AND r.createdDate BETWEEN ? AND ?");
			parameters.add(createdDateFrom);
			parameters.add(createdDateTo);

		} else if (createdDateFrom != null) {

			query.append(" AND r.createdDate >= ?");
			parameters.add(createdDateFrom);

		} else if (createdDateTo != null) {

			query.append(" AND r.createdDate <= ?");
			parameters.add(createdDateTo);

		}
		
		if((statusPending != null && !statusPending.isEmpty()) 
				   || (statusApproved != null && !statusApproved.isEmpty()) 
				   || (statusRejected != null && !statusRejected.isEmpty())) {
				    
				    List<String> statusConditions = new ArrayList<>();
				    
				    if (statusPending != null && !statusPending.isEmpty() && statusPending.equals("0")) {
				        statusConditions.add("r.status = ?");
				        parameters.add(statusPending);
				    }

				    if (statusApproved != null && !statusApproved.isEmpty() && statusApproved.equals("1")) {
				        statusConditions.add("r.status = ?");
				        parameters.add(statusApproved);
				    }

				    if (statusRejected != null && !statusRejected.isEmpty() && statusRejected.equals("2")) {
				        statusConditions.add("r.status = ?");
				        parameters.add(statusRejected);
				    }

				    // Combine the status conditions with OR
				    if (!statusConditions.isEmpty()) {
				        query.append(" AND (");
				        query.append(String.join(" OR ", statusConditions));
				        query.append(")");
				    }
				}

		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(query.toString());
			for (int i = 0; i < parameters.size(); i++) {
				statement.setString(i + 1, parameters.get(i));
			}
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Records record = new Records();
				record.setId(resultset.getInt("id"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRequestFor(resultset.getInt("requestFor"));
				record.setLocationFrom(resultset.getInt("locationFrom"));
				record.setLocationTo(resultset.getInt("locationTo"));
				record.setProjectFrom(resultset.getInt("projectFrom"));
				record.setProjectTo(resultset.getInt("projectTo"));
				record.setDepartmentFrom(resultset.getInt("departmentFrom"));
				record.setDepartmentTo(resultset.getInt("departmentTo"));
				record.setTransferRelievingDate(resultset.getDate("transferRelievingDate"));
				record.setTransferJoiningDate(resultset.getDate("transferJoiningDate"));
				record.setCreatedDate(resultset.getDate("createdDate"));
				record.setStatus(resultset.getInt("status"));

				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
			records = null;
		} finally {
			ConnectDB.disconnect();
		}
		return records;
	}


	public boolean createProjectRecord(Records record) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(
					"Insert into record(employeeId, requestFor, projectFrom, projectTo, transferRelievingDate, transferJoiningDate, createdDate, status)"
							+ "values(?,?,?,?,?,?,?,?)");
			statement.setInt(1, record.getEmployeeId());
			statement.setInt(2, record.getRequestFor());
			statement.setInt(3, record.getProjectFrom());
			statement.setInt(4, record.getProjectTo());
			statement.setDate(5, new java.sql.Date(record.getTransferRelievingDate().getTime()));
			statement.setDate(6, new java.sql.Date(record.getTransferJoiningDate().getTime()));
			statement.setDate(7, new java.sql.Date(new Date().getTime()));
			statement.setInt(8, 0);
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean createDepartmentRecord(Records record) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(
					"Insert into record(employeeId, requestFor, departmentFrom, departmentTo, transferRelievingDate, transferJoiningDate, createdDate, status)"
							+ "values(?,?,?,?,?,?,?,?)");
			statement.setInt(1, record.getEmployeeId());
			statement.setInt(2, record.getRequestFor());
			statement.setInt(3, record.getDepartmentFrom());
			statement.setInt(4, record.getDepartmentTo());
			statement.setDate(5, new java.sql.Date(record.getTransferRelievingDate().getTime()));
			statement.setDate(6, new java.sql.Date(record.getTransferJoiningDate().getTime()));
			statement.setDate(7, new java.sql.Date(new Date().getTime()));
			statement.setInt(8, 0);
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean createLocationRecord(Records record) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(
					"Insert into record(employeeId, requestFor, locationFrom, locationTo, transferRelievingDate, transferJoiningDate, createdDate, status)"
							+ "values(?,?,?,?,?,?,?,?)");
			statement.setInt(1, record.getEmployeeId());
			statement.setInt(2, record.getRequestFor());
			statement.setInt(3, record.getLocationFrom());
			statement.setInt(4, record.getLocationTo());
			statement.setDate(5, new java.sql.Date(record.getTransferRelievingDate().getTime()));
			statement.setDate(6, new java.sql.Date(record.getTransferJoiningDate().getTime()));
			statement.setDate(7, new java.sql.Date(new Date().getTime()));
			statement.setInt(8, 0);
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean updateProjectRecord(Records record) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update record set requestFor = ?, " + "projectFrom = ?, projectTo = ?, "
							+ "transferRelievingDate = ?, transferJoiningDate = ?, "
							+ "createdDate = ?, status = ? where id = ?");
			statement.setInt(1, record.getRequestFor());
			statement.setInt(2, record.getProjectFrom());
			statement.setInt(3, record.getProjectTo());
			statement.setDate(4, new java.sql.Date(record.getTransferRelievingDate().getTime()));
			statement.setDate(5, new java.sql.Date(record.getTransferJoiningDate().getTime()));
			statement.setDate(6, new java.sql.Date(new Date().getTime()));
			statement.setInt(7, record.getStatus());
			statement.setInt(8, record.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean updateDepartmentRecord(Records record) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update record set requestFor = ?, " + "departmentFrom = ?, departmentTo = ?, "
							+ "transferRelievingDate = ?, transferJoiningDate = ?, "
							+ "createdDate = ?, status = ? where id = ?");
			statement.setInt(1, record.getRequestFor());
			statement.setInt(2, record.getDepartmentFrom());
			statement.setInt(3, record.getDepartmentTo());
			statement.setDate(4, new java.sql.Date(record.getTransferRelievingDate().getTime()));
			statement.setDate(5, new java.sql.Date(record.getTransferJoiningDate().getTime()));
			statement.setDate(6, new java.sql.Date(new Date().getTime()));
			statement.setInt(7, record.getStatus());
			statement.setInt(8, record.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean updateLocationRecord(Records record) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update record set requestFor = ?, locationFrom = ?, locationTo = ?, "
							+ "transferRelievingDate = ?, transferJoiningDate = ?, "
							+ "createdDate = ?, status = ? where id = ?");
			statement.setInt(1, record.getRequestFor());
			statement.setInt(2, record.getLocationFrom());
			statement.setInt(3, record.getLocationTo());
			statement.setDate(4, new java.sql.Date(record.getTransferRelievingDate().getTime()));
			statement.setDate(5, new java.sql.Date(record.getTransferJoiningDate().getTime()));
			statement.setDate(6, new java.sql.Date(new Date().getTime()));
			statement.setInt(7, record.getStatus());
			statement.setInt(8, record.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean delete(int id) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Delete from record where id = ?");
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public List<Records> findManagedEmployeeRecord(int managerId, int employeeId) {
		List<Records> records = new ArrayList<Records>();
		String query = "(SELECT DISTINCT r.* " + "FROM record r " +
//                 "JOIN employee e ON r.employeeId = e.id " +
				"JOIN employee e ON r.requestFor = e.id " + "WHERE e.managerId = ? OR e.id = ?)";
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(query);
			statement.setInt(1, employeeId);
			statement.setInt(2, managerId);
//			statement.setInt(3, managerId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Records record = new Records();
				record.setId(resultset.getInt("id"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRequestFor(resultset.getInt("requestFor"));
				record.setLocationFrom(resultset.getInt("locationFrom"));
				record.setLocationTo(resultset.getInt("locationTo"));
				record.setProjectFrom(resultset.getInt("projectFrom"));
				record.setProjectTo(resultset.getInt("projectTo"));
				record.setDepartmentFrom(resultset.getInt("departmentFrom"));
				record.setDepartmentTo(resultset.getInt("departmentTo"));
				record.setTransferRelievingDate(resultset.getDate("transferRelievingDate"));
				record.setTransferJoiningDate(resultset.getDate("transferJoiningDate"));
				record.setCreatedDate(resultset.getDate("createdDate"));
				record.setStatus(resultset.getInt("status"));

				records.add(record);
			}
		} catch (Exception e) {
			e.printStackTrace();
			records = null;
		} finally {
			ConnectDB.disconnect();
		}
		return records;
	}

	public boolean updateEmployeeRecord(Records record) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(
					"Update record set requestFor = ?, " + " projectTo = ?, departmentTo = ?, locationTo = ?, "
							+ " transferJoiningDate = ?, " + "createdDate = ?, status = ? where id = ?");
			statement.setInt(1, record.getRequestFor());
			statement.setInt(2, record.getProjectTo());
			statement.setInt(3, record.getDepartmentTo());
			statement.setInt(4, record.getLocationTo());
			statement.setDate(5, new java.sql.Date(record.getTransferJoiningDate().getTime()));
			statement.setDate(6, new java.sql.Date(new Date().getTime()));
			statement.setInt(7, 1);
			statement.setInt(8, record.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean createEmployeeRecord(Records record) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Insert into record(employeeId, requestFor, projectTo, departmentTo, locationTo, transferJoiningDate, createdDate, status)"
							+ "values(?,?,?,?,?,?,?,?)");
			statement.setInt(1, record.getEmployeeId());
			statement.setInt(2, record.getRequestFor());
			statement.setInt(3, record.getProjectTo());
			statement.setInt(4, record.getDepartmentTo());
			statement.setInt(5, record.getLocationTo());
			statement.setDate(6, new java.sql.Date(record.getTransferJoiningDate().getTime()));
			statement.setDate(7, new java.sql.Date(new Date().getTime()));
			statement.setInt(8, 1);
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean checkAvailablePendingProjectRecord(Employee employee) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("SELECT r.* FROM record r WHERE r.requestFor = ? AND r.projectFrom IS NOT NULL AND r.status = 0");
			statement.setInt(1, employee.getId());

			ResultSet resultSet = statement.executeQuery();
			result = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean checkAvailablePendingDepartmentRecord(Employee employee) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("SELECT r.* FROM record r WHERE r.requestFor = ? AND r.departmentFrom IS NOT NULL AND r.status = 0");
			statement.setInt(1, employee.getId());

			ResultSet resultSet = statement.executeQuery();
			result = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean checkAvailablePendingLocationRecord(Employee employee) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("SELECT r.* FROM record r WHERE r.requestFor = ? AND r.locationFrom IS NOT NULL AND r.status = 0");
			statement.setInt(1, employee.getId());

			ResultSet resultSet = statement.executeQuery();
			result = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public Integer countPendingRecord(){
		Integer result = null;
		try {

			PreparedStatement statement = ConnectDB.connection()
												   .prepareStatement("Select count(*) from record where status = 0");
			ResultSet resultSet = statement.executeQuery(); 
			resultSet.next(); 
			result = resultSet.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		} finally {
			ConnectDB.disconnect();
		}
		
		return result;
	}
	
	public Integer countApprovedRecord(){
		Integer result = null;
		try {

			PreparedStatement statement = ConnectDB.connection()
												   .prepareStatement("Select count(*) from record where status = 1");
			ResultSet resultSet = statement.executeQuery(); 
			resultSet.next(); 
			result = resultSet.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		} finally {
			ConnectDB.disconnect();
		}
		
		return result;
	}
	
	public Integer countRejectedRecord(){
		Integer result = null;
		try {

			PreparedStatement statement = ConnectDB.connection()
												   .prepareStatement("Select count(*) from record where status = 2");
			ResultSet resultSet = statement.executeQuery(); 
			resultSet.next(); 
			result = resultSet.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		} finally {
			ConnectDB.disconnect();
		}
		
		return result;
	}
	
	public Integer countEmployeePendingRecord(int employeeId, int managerId){
		Integer result = null;
		try {

			PreparedStatement statement = ConnectDB.connection()
												   .prepareStatement("Select count(*) from record r "
														   		   + "Join employee e ON r.requestFor = e.id "
												   				   + "where r.status = 0 AND (e.managerId = ? OR e.id = ?)");
			statement.setInt(1, employeeId);
			statement.setInt(2, managerId);
			ResultSet resultSet = statement.executeQuery(); 
			resultSet.next(); 
			result = resultSet.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		} finally {
			ConnectDB.disconnect();
		}
		
		return result;
	}
	
	public Integer countEmployeeApprovedRecord(int employeeId, int managerId){
		Integer result = null;
		try {

			PreparedStatement statement = ConnectDB.connection()
										   .prepareStatement("Select count(*) from record r "
												   		   + "Join employee e ON r.requestFor = e.id "
										   				   + "where r.status = 1 AND (e.managerId = ? OR e.id = ?)");
			statement.setInt(1, employeeId);
			statement.setInt(2, managerId);
			ResultSet resultSet = statement.executeQuery(); 
			resultSet.next(); 
			result = resultSet.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		} finally {
			ConnectDB.disconnect();
		}
		
		return result;
	}
	
	public Integer countEmployeeRejectedRecord(int employeeId, int managerId){
		Integer result = null;
		try {

			PreparedStatement statement = ConnectDB.connection()
										   .prepareStatement("Select count(*) from record r "
												   		   + "Join employee e ON r.requestFor = e.id "
										   				   + "where r.status = 2 AND (e.managerId = ? OR e.id = ?)");
			statement.setInt(1, employeeId);
			statement.setInt(2, managerId);
			ResultSet resultSet = statement.executeQuery(); 
			resultSet.next(); 
			result = resultSet.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
			result = null;
		} finally {
			ConnectDB.disconnect();
		}
		
		return result;
	}
	
	public List<Records> findByPendingStatus(){
		List<Records> records = new ArrayList<Records>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from record where status = 0");
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Records record = new Records();
				record.setId(resultset.getInt("id"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRequestFor(resultset.getInt("requestFor"));
				record.setLocationFrom(resultset.getInt("locationFrom"));
				record.setLocationTo(resultset.getInt("locationTo"));
				record.setProjectFrom(resultset.getInt("projectFrom"));
				record.setProjectTo(resultset.getInt("projectTo"));
				record.setDepartmentFrom(resultset.getInt("departmentFrom"));
				record.setDepartmentTo(resultset.getInt("departmentTo"));
				record.setTransferRelievingDate(resultset.getDate("transferRelievingDate"));
				record.setTransferJoiningDate(resultset.getDate("transferJoiningDate"));
				record.setCreatedDate(resultset.getDate("createdDate"));
				record.setStatus(resultset.getInt("status"));
				
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
	
	public List<Records> findByEmployeePendingStatus(int employeeId, int managerId){
		List<Records> records = new ArrayList<Records>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from record r "
																				+ "Join employee e On r.employeeId = e.id "
																				+ "where r.status = 0 AND (e.managerId = ? OR e.id = ?)");
			statement.setInt(1, employeeId);
			statement.setInt(2, managerId);
			ResultSet resultset = statement.executeQuery();
			while(resultset.next()) {
				Records record = new Records();
				record.setId(resultset.getInt("id"));
				record.setEmployeeId(resultset.getInt("employeeId"));
				record.setRequestFor(resultset.getInt("requestFor"));
				record.setLocationFrom(resultset.getInt("locationFrom"));
				record.setLocationTo(resultset.getInt("locationTo"));
				record.setProjectFrom(resultset.getInt("projectFrom"));
				record.setProjectTo(resultset.getInt("projectTo"));
				record.setDepartmentFrom(resultset.getInt("departmentFrom"));
				record.setDepartmentTo(resultset.getInt("departmentTo"));
				record.setTransferRelievingDate(resultset.getDate("transferRelievingDate"));
				record.setTransferJoiningDate(resultset.getDate("transferJoiningDate"));
				record.setCreatedDate(resultset.getDate("createdDate"));
				record.setStatus(resultset.getInt("status"));
				
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
}
