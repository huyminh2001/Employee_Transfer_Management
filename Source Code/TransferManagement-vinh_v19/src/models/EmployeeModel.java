package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.chrono.MinguoChronology;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.security.auth.login.AccountException;

import org.mindrot.jbcrypt.BCrypt;

import dbConnect.ConnectDB;
import entities.Employee;

public class EmployeeModel {
	public List<Employee> findAll() {
		List<Employee> records = new ArrayList<Employee>();
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement("select * from employee");
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Employee record = new Employee();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setEmail(resultset.getString("email"));
				record.setUsername(resultset.getString("username"));
				record.setPassword(resultset.getString("password"));
				record.setSecurityCode(resultset.getInt("securityCode"));
				record.setRoleId(resultset.getInt("roleId"));
				record.setCurrentProject(resultset.getInt("currentProject"));
				record.setCurrentDepartment(resultset.getInt("currentDepartment"));
				record.setCurrentLocation(resultset.getInt("currentLocation"));
				record.setJoiningDate(resultset.getDate("joiningDate"));
				record.setManagerId(resultset.getInt("managerId"));
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

	public Employee findById(int id) {
		Employee record = null;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select * from employee where id = ?");
			statement.setInt(1, id);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				record = new Employee();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setEmail(resultset.getString("email"));
				record.setUsername(resultset.getString("username"));
				record.setPassword(resultset.getString("password"));
				record.setSecurityCode(resultset.getInt("securityCode"));
				record.setRoleId(resultset.getInt("roleId"));
				record.setCurrentProject(resultset.getInt("currentProject"));
				record.setCurrentDepartment(resultset.getInt("currentDepartment"));
				record.setCurrentLocation(resultset.getInt("currentLocation"));
				record.setJoiningDate(resultset.getDate("joiningDate"));
				record.setManagerId(resultset.getInt("managerId"));
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

	public int getEmployeeId(String employeeName) {
		int result = 0;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select id from employee where name = ?");
			statement.setString(1, employeeName);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				result = resultset.getInt("id");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public Employee findByUsername(String username) {
		Employee record = null;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select * from employee where username = ?");
			statement.setString(1, username);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				record = new Employee();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setEmail(resultset.getString("email"));
				record.setUsername(resultset.getString("username"));
				record.setPassword(resultset.getString("password"));
				record.setSecurityCode(resultset.getInt("securityCode"));
				record.setRoleId(resultset.getInt("roleId"));
				record.setCurrentProject(resultset.getInt("currentProject"));
				record.setCurrentDepartment(resultset.getInt("currentDepartment"));
				record.setCurrentLocation(resultset.getInt("currentLocation"));
				record.setJoiningDate(resultset.getDate("joiningDate"));
				record.setManagerId(resultset.getInt("managerId"));
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

	public int getCurrentProject(int employeeId) {
		int result = 0;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select currentProject from employee where id = ?");
			statement.setInt(1, employeeId);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				result = resultset.getInt("currentProject");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public int getCurrentDepartment(int employeeId) {
		int result = 0;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select currentDepartment from employee where id = ?");
			statement.setInt(1, employeeId);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				result = resultset.getInt("currentDepartment");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public int getCurrentLocation(int employeeId) {
		int result = 0;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select currentLocation from employee where id = ?");
			statement.setInt(1, employeeId);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				result = resultset.getInt("currentLocation");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public List<Employee> getManagedEmployees(int managerId, int employeeId) {
		List<Employee> records = new ArrayList<Employee>();
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select * from employee where managerId = ? or id = ? ");
			statement.setInt(1, managerId);
			statement.setInt(2, employeeId);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Employee record = new Employee();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setEmail(resultset.getString("email"));
				record.setUsername(resultset.getString("username"));
				record.setPassword(resultset.getString("password"));
				record.setSecurityCode(resultset.getInt("securityCode"));
				record.setRoleId(resultset.getInt("roleId"));
				record.setCurrentProject(resultset.getInt("currentProject"));
				record.setCurrentDepartment(resultset.getInt("currentDepartment"));
				record.setCurrentLocation(resultset.getInt("currentLocation"));
				record.setJoiningDate(resultset.getDate("joiningDate"));
				record.setManagerId(resultset.getInt("managerId"));
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

	public boolean changePassword(int id, String password) {
		Random random = new Random();
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update employee set password = ? where id = ?");
			statement.setString(1, BCrypt.hashpw(password, BCrypt.gensalt()));
			statement.setInt(2, id);
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean create(Employee employee) {
		Random random = new Random();
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Insert into employee(name, email, "
							+ "username, password, roleId, securityCode, " + "currentProject, currentDepartment, "
							+ "currentLocation, joiningDate, managerId, status) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getEmail());
			statement.setString(3, employee.getUsername());
			statement.setString(4, BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt()));
			statement.setInt(5, employee.getRoleId());
			statement.setInt(6, random.nextInt(10000));
//			statement.setInt(6, 1111);
			statement.setInt(7, employee.getCurrentProject());
			statement.setInt(8, employee.getCurrentDepartment());
			statement.setInt(9, employee.getCurrentLocation());
			statement.setDate(10, new java.sql.Date(employee.getJoiningDate().getTime()));
			statement.setInt(11, employee.getManagerId());
			statement.setInt(12, 1);
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean createManagerNull(Employee employee) {
		Random random = new Random();
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Insert into employee(name, email, "
							+ "username, password, roleId, securityCode, " + "currentProject, currentDepartment, "
							+ "currentLocation, joiningDate, status) values(?,?,?,?,?,?,?,?,?,?,?)");
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getEmail());
			statement.setString(3, employee.getUsername());
			statement.setString(4, BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt()));
			statement.setInt(5, employee.getRoleId());
			statement.setInt(6, random.nextInt(10000));
//			statement.setInt(6, 1111);
			statement.setInt(7, employee.getCurrentProject());
			statement.setInt(8, employee.getCurrentDepartment());
			statement.setInt(9, employee.getCurrentLocation());
			statement.setDate(10, new java.sql.Date(employee.getJoiningDate().getTime()));
//			statement.setInt(11, employee.getManagerId());
			statement.setInt(11, 1);
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	
	public boolean update(Employee employee) {
		Random random = new Random();
		int min = 1000;
		int max = 9999;
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update employee set name = ?, email = ?, "
							+ "username = ?, roleId = ?, securityCode = ?, "
							+ "currentProject = ?, currentDepartment = ?, currentLocation = ?, joiningDate = ? , managerId = ?, status = ? where id = ?");
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getEmail());
			statement.setString(3, employee.getUsername());
			statement.setInt(4, employee.getRoleId());
			statement.setInt(5, random.nextInt((max - min) + 1) + min);
			statement.setInt(6, employee.getCurrentProject());
			statement.setInt(7, employee.getCurrentDepartment());
			statement.setInt(8, employee.getCurrentLocation());
			statement.setDate(9, new java.sql.Date(employee.getJoiningDate().getTime()));
			statement.setInt(10, employee.getManagerId());
			statement.setInt(11, employee.getStatus());
			statement.setInt(12, employee.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean updateCurrentProject(Employee employee) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update employee set currentProject = ?, joiningDate = ? where id = ?");
			statement.setInt(1, employee.getCurrentProject());
			statement.setDate(2, new java.sql.Date(employee.getJoiningDate().getTime()));
			statement.setInt(3, employee.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean updateCurrentDepartment(Employee employee) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update employee set currentDepartment = ?, joiningDate = ? where id = ?");
			statement.setInt(1, employee.getCurrentDepartment());
			statement.setDate(2, new java.sql.Date(employee.getJoiningDate().getTime()));
			statement.setInt(3, employee.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean updateCurrentLocation(Employee employee) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update employee set currentLocation = ?, joiningDate = ? where id = ?");
			statement.setInt(1, employee.getCurrentLocation());
			statement.setDate(2, new java.sql.Date(employee.getJoiningDate().getTime()));
			statement.setInt(3, employee.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean updateSecurityCode(String username) {
		Random random = new Random();
		boolean result = false;
		int min = 1000;  // lower bound (inclusive)
        int max = 9999;  // upper bound (inclusive)
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update employee set securityCode = ? where username = ?");
			statement.setInt(1, random.nextInt((max - min) + 1) + min);
			statement.setString(2, username);
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
			PreparedStatement statement = ConnectDB.connection().prepareStatement("Delete from employee where id = ?");
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean login(String username, String password) {
		List<Employee> employees = findAll();
		Optional<Employee> option = employees.stream().filter(e -> e.getUsername().equals(username)).findFirst();
		if (option.isPresent()) {
			Employee employee = option.get();
			return BCrypt.checkpw(password, employee.getPassword());
		}
		return false;
	}

//	public List<Employee> filterEmployee(String employeeName, Integer managerName, String email, String username,
//			String role, String currentProject, String currentDepartment, String currentLocation,
//			String joiningDateFrom, String joiningDateTo) {
//		List<Employee> records = new ArrayList<Employee>();
//		StringBuilder query = new StringBuilder(" SELECT DISTINCT e.* FROM employee e "
//				+ " LEFT JOIN employee m ON m.managerId = e.id " + " JOIN projects p ON e.currentProject = p.id "
//				+ " JOIN department d ON e.currentDepartment = d.id " + " JOIN location l ON e.currentLocation = l.id "
//				+ " JOIN role r on e.roleId = r.id " + " WHERE 1=1 ");
//
//		List<String> parameters = new ArrayList<>();
//		if (employeeName != null && !employeeName.isEmpty()) {
//			query.append(" AND e.name LIKE ? ");
//			parameters.add("%" + employeeName + "%");
//		}
//
//		if (managerName != null) {
//			query.append(" AND m.managerId = ? ");
//			parameters.add(String.valueOf(managerName));
//		}
////else {
////query.append(" AND m.managerId IS NULL ");
////}
//
//		if (email != null && !email.isEmpty()) {
//			query.append(" AND e.email LIKE ");
//			parameters.add("%" + email + "%");
//		}
//
//		if (username != null && !username.isEmpty()) {
//			query.append(" AND e.username LIKE ? ");
//			parameters.add("%" + username + "%");
//		}
//
//		if (role != null) {
//			if (role.equals("All")) {
//
//			}
//		} else {
//			query.append(" AND r.name LIKE ?");
//			parameters.add("%" + role + "%");
//		}
//
//		if (currentProject != null) {
//			if (currentProject.equals("All")) {
//
//			}
//		} else {
//			query.append(" AND p.name LIKE ?");
//			parameters.add("%" + currentProject + "%");
//		}
//
//		if (currentDepartment != null) {
//			if (currentDepartment.equals("All")) {
//
//			}
//		} else {
//			query.append(" AND d.name LIKE ?");
//			parameters.add("%" + currentDepartment + "%");
//		}
//
//		if (currentLocation != null) {
//			if (currentLocation.equals("All")) {
//
//			}
//		} else {
//			query.append(" AND l.name LIKE ?");
//			parameters.add("%" + currentLocation + "%");
//		}
//
//		if (joiningDateFrom != null && joiningDateTo != null) {
//
//			query.append(" AND e.joiningDate BETWEEN ? AND ? ");
//			parameters.add(joiningDateFrom);
//			parameters.add(joiningDateTo);
//
//		} else if (joiningDateFrom != null) {
//
//			query.append(" AND e.joiningDate >= ? ");
//			parameters.add(joiningDateFrom);
//
//		} else if (joiningDateTo != null) {
//
//			query.append(" AND e.joiningDate <= ? ");
//			parameters.add(joiningDateTo);
//		}
//
//		try {
//			PreparedStatement statement = ConnectDB.connection().prepareStatement(query.toString());
//			for (int i = 0; i < parameters.size(); i++) {
//				statement.setObject(i + 1, parameters.get(i));
//			}
//			ResultSet resultset = statement.executeQuery();
//			while (resultset.next()) {
//				Employee record = new Employee();
//				record.setId(resultset.getInt("id"));
//				record.setName(resultset.getString("name"));
//				record.setEmail(resultset.getString("email"));
//				record.setUsername(resultset.getString("username"));
//				record.setPassword(resultset.getString("password"));
//				record.setSecurityCode(resultset.getInt("securityCode"));
//				record.setRoleId(resultset.getInt("roleId"));
//				record.setCurrentProject(resultset.getInt("currentProject"));
//				record.setCurrentDepartment(resultset.getInt("currentDepartment"));
//				record.setCurrentLocation(resultset.getInt("currentLocation"));
//				record.setJoiningDate(resultset.getDate("joiningDate"));
//				record.setManagerId(resultset.getInt("managerId"));
//				record.setStatus(resultset.getInt("status"));
//
//				records.add(record);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			records = null;
//		} finally {
//			ConnectDB.disconnect();
//		}
//		return records;
//	}
//	
	public List<Employee> filterEmployee(String employeeName, String managerName, String email, String username,
			int role, int currentProject, int currentDepartment, int currentLocation, String joiningDateFrom,
			String joiningDateTo) {
		List<Employee> records = new ArrayList<Employee>();
		StringBuilder query = new StringBuilder(" SELECT DISTINCT e.* FROM employee e "
				+ " LEFT JOIN employee m ON m.id = e.managerId "
				+ " LEFT JOIN projects p ON e.currentProject = p.id "
				+ " LEFT JOIN department d ON e.currentDepartment = d.id "
				+ " LEFT JOIN location l ON e.currentLocation = l.id " + " LEFT JOIN role r on e.roleId = r.id "
				+ " WHERE 1=1 ");

		List<String> parameters = new ArrayList<>();
		if (employeeName != null && !employeeName.isEmpty()) {
			query.append(" AND e.name LIKE ? ");
			parameters.add("%" + employeeName + "%");
		}

//		if (managerName != null) {
//			query.append(" AND e.managerId = ? ");
//			parameters.add(String.valueOf(managerName));
//		}
		
		if(managerName != null ) {
			query.append(" AND m.name LIKE ? ");
			parameters.add("%" + managerName + "%");
		}

		if (email != null && !email.isEmpty()) {
			query.append(" AND e.email LIKE ? ");
			parameters.add("%" + email + "%");
		}

		if (username != null && !username.isEmpty()) {
			query.append(" AND e.username LIKE ? ");
			parameters.add("%" + username + "%");
		}

//if(role != null) {
//if(role.equals("All")) {
//
//}
//}else {
//query.append(" AND r.name LIKE ?");
//parameters.add("%" + role + "%");
//System.out.println(role);
//}

		if (role < 0) {
			if (role == -1) {

			}
		} else {
			query.append(" AND r.id = ?");
			parameters.add(String.valueOf(role));
			System.out.println(role);
		}

		if (currentProject < 0) {
			if (currentProject == -1) {

			}
		} else {
			query.append(" AND p.id = ? ");
			parameters.add(String.valueOf(currentProject));
			System.out.println(currentProject);
		}

		if (currentDepartment < 0) {
			if (currentDepartment == -1) {

			}
		} else {
			query.append(" AND d.id = ? ");
			parameters.add(String.valueOf(currentDepartment));
			System.out.println(currentDepartment);
		}

		if (currentLocation < 0) {
			if (currentLocation == -1) {

			}
		} else {
			query.append(" AND l.id = ? ");
			parameters.add(String.valueOf(currentLocation));
			System.out.println(currentLocation);
		}

//--------------------------------------------------------------
//if(currentProject != null) {
//if(currentProject.equals("All")) {
//
//}
//}else {
//query.append(" AND p.name LIKE ?");
//parameters.add("%" + currentProject + "%");
//System.out.println(currentProject);
//}
//
//if(currentDepartment != null) {
//if(currentDepartment.equals("All")) {
//
//}
//}else {
//query.append(" AND d.name LIKE ?");
//parameters.add("%" + currentDepartment + "%");
//System.out.println(currentDepartment);
//}
//
//if(currentLocation != null) {
//if(currentLocation.equals("All")) {
//
//}
//}else {
//query.append(" AND l.name LIKE ?");
//parameters.add("%" + currentLocation + "%");
//System.out.println(currentLocation);
//}

		if (joiningDateFrom != null && joiningDateTo != null) {

			query.append(" AND e.joiningDate BETWEEN ? AND ? ");
			parameters.add(joiningDateFrom);
			parameters.add(joiningDateTo);

		} else if (joiningDateFrom != null) {

			query.append(" AND e.joiningDate >= ? ");
			parameters.add(joiningDateFrom);

		} else if (joiningDateTo != null) {

			query.append(" AND e.joiningDate <= ? ");
			parameters.add(joiningDateTo);
		}

		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(query.toString());
			for (int i = 0; i < parameters.size(); i++) {
				statement.setString(i + 1, parameters.get(i));
//System.out.println("Index i: " + i);
			}
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				Employee record = new Employee();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setEmail(resultset.getString("email"));
				record.setUsername(resultset.getString("username"));
				record.setPassword(resultset.getString("password"));
				record.setSecurityCode(resultset.getInt("securityCode"));
				record.setRoleId(resultset.getInt("roleId"));
				record.setCurrentProject(resultset.getInt("currentProject"));
				record.setCurrentDepartment(resultset.getInt("currentDepartment"));
				record.setCurrentLocation(resultset.getInt("currentLocation"));
				record.setJoiningDate(resultset.getDate("joiningDate"));
				record.setManagerId(resultset.getInt("managerId"));
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

	public int getEmployeeManagerId(String managerName) {
		int result = 0;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select managerId from employee where name = ?");
			statement.setString(1, managerName);
			ResultSet resultset = statement.executeQuery();
			if (resultset.next()) {
				result = resultset.getInt("managerId");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = 0;
		}
		return result;
	}

	public Employee findByName(String employeeName) {
		Employee record = null;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select * from employee where name = ?");
			statement.setString(1, employeeName);
			ResultSet resultset = statement.executeQuery();
			while (resultset.next()) {
				record = new Employee();
				record.setId(resultset.getInt("id"));
				record.setName(resultset.getString("name"));
				record.setEmail(resultset.getString("email"));
				record.setUsername(resultset.getString("username"));
				record.setPassword(resultset.getString("password"));
				record.setSecurityCode(resultset.getInt("securityCode"));
				record.setRoleId(resultset.getInt("roleId"));
				record.setCurrentProject(resultset.getInt("currentProject"));
				record.setCurrentDepartment(resultset.getInt("currentDepartment"));
				record.setCurrentLocation(resultset.getInt("currentLocation"));
				record.setJoiningDate(resultset.getDate("joiningDate"));
				record.setManagerId(resultset.getInt("managerId"));
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

	public boolean updateManagerNull(Employee employee) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("Update employee set name = ?, email = ?, " + "username = ?, roleId = ?,  "
							+ "currentProject = ?, currentDepartment = ?, currentLocation = ?, joiningDate = ? , managerId = null where id = ?");
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getEmail());
			statement.setString(3, employee.getUsername());
			statement.setInt(4, employee.getRoleId());
			statement.setInt(5, employee.getCurrentProject());
			statement.setInt(6, employee.getCurrentDepartment());
			statement.setInt(7, employee.getCurrentLocation());
			statement.setDate(8, new java.sql.Date(employee.getJoiningDate().getTime()));
			statement.setInt(9, employee.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	 // Check if a username already exists in the database
    public boolean doesEmployeeNameExist(String name) {
        try {
        	PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("SELECT COUNT(*) FROM employee WHERE name = ?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;  // Return true if count is greater than 0
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
	
	 // Check if a username already exists in the database
    public boolean doesUsernameExist(String username) {
        try {
        	PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("SELECT COUNT(*) FROM employee WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;  // Return true if count is greater than 0
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // Check if an email already exists in the database
    public boolean doesEmailExist(String email) {
        try {
        	PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("SELECT COUNT(*) FROM employee WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;  // Return true if count is greater than 0
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


	public boolean checkManagedEmployees(int employeeId) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection()
					.prepareStatement("select * from employee where managerId = ? ");
			statement.setInt(1, employeeId);
			ResultSet resultSet = statement.executeQuery();
			result = resultSet.next();
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean updateCurrentProject_Department_Location(Employee employee) {
		boolean result = false;
		try {
			PreparedStatement statement = ConnectDB.connection().prepareStatement(
					"Update employee set currentProject = ?, currentDepartment = ?, currentLocation = ?, joiningDate = ? where id = ?");
			statement.setInt(1, employee.getCurrentProject());
			statement.setInt(2, employee.getCurrentDepartment());
			statement.setInt(3, employee.getCurrentLocation());
			statement.setDate(4, new java.sql.Date(employee.getJoiningDate().getTime()));
			statement.setInt(5, employee.getId());
			result = statement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	
}
