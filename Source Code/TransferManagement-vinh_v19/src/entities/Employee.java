package entities;

import java.util.Date;

public class Employee {
	private Integer id;
	private String name;
	private String email;
	private String username;
	private String password;
	private Integer roleId;
	private int securityCode;
	private Integer currentProject;
	private Integer currentDepartment;
	private Integer currentLocation;
	private Date joiningDate;
	private Integer managerId;
	private Integer status;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Employee(Integer id, String name, String email, String username, String password, Integer roleId, int securityCode,
			Integer currentProject, Integer currentDepartment, Integer currentLocation, Date joiningDate, Integer managerId,
			Integer status) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.securityCode = securityCode;
		this.currentProject = currentProject;
		this.currentDepartment = currentDepartment;
		this.currentLocation = currentLocation;
		this.joiningDate = joiningDate;
		this.managerId = managerId;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Integer getCurrentProject() {
		return currentProject;
	}

	public void setCurrentProject(Integer currentProject) {
		this.currentProject = currentProject;
	}

	public Integer getCurrentDepartment() {
		return currentDepartment;
	}

	public void setCurrentDepartment(Integer currentDepartment) {
		this.currentDepartment = currentDepartment;
	}


	public Integer getCurrentLocation() {
		return currentLocation;
	}


	public void setCurrentLocation(Integer currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	
	public Integer getManagerId() {
		return managerId;
	}
	
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public int getSecurityCode() {
		return securityCode;
	}


	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


//	@Override
//	public String toString() {
//		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
//				+ password + ", roleId=" + roleId + ", securityCode=" + securityCode + ", currentProject="
//				+ currentProject + ", currentDepartment=" + currentDepartment + ", currentLocation=" + currentLocation
//				+ ", joiningDate=" + joiningDate + ", managerId=" + managerId + ", status=" + status + "]";
//	}
	
	
	
}
