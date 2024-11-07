package entities;

import java.util.Date;

public class Records {
	private int id;
	private int employeeId;
	private int requestFor;
	private int locationFrom;
	private int locationTo;
	private int departmentFrom;
	private int departmentTo;
	private int projectFrom;
	private int projectTo;
	private Date transferRelievingDate;
	private Date transferJoiningDate;
	private Date createdDate;
	private int status;
	
	public Records() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Records(int id, int employeeId, int requestFor, int locationFrom, int locationTo, int departmentFrom,
			int departmentTo, int projectFrom, int projectTo, Date transferRelievingDate, Date transferJoiningDate,
			Date createdDate, int status) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.requestFor = requestFor;
		this.locationFrom = locationFrom;
		this.locationTo = locationTo;
		this.departmentFrom = departmentFrom;
		this.departmentTo = departmentTo;
		this.projectFrom = projectFrom;
		this.projectTo = projectTo;
		this.transferRelievingDate = transferRelievingDate;
		this.transferJoiningDate = transferJoiningDate;
		this.createdDate = createdDate;
		this.status = status;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	
	public int getRequestFor() {
		return requestFor;
	}

	public void setRequestFor(int requestFor) {
		this.requestFor = requestFor;
	}

	
	public int getLocationFrom() {
		return locationFrom;
	}

	public void setLocationFrom(int locationFrom) {
		this.locationFrom = locationFrom;
	}

	public int getLocationTo() {
		return locationTo;
	}

	public void setLocationTo(int locationTo) {
		this.locationTo = locationTo;
	}

	public int getDepartmentFrom() {
		return departmentFrom;
	}

	public void setDepartmentFrom(int departmentFrom) {
		this.departmentFrom = departmentFrom;
	}

	public int getDepartmentTo() {
		return departmentTo;
	}

	public void setDepartmentTo(int departmentTo) {
		this.departmentTo = departmentTo;
	}

	public int getProjectFrom() {
		return projectFrom;
	}

	public void setProjectFrom(int projectFrom) {
		this.projectFrom = projectFrom;
	}

	public int getProjectTo() {
		return projectTo;
	}

	public void setProjectTo(int projectTo) {
		this.projectTo = projectTo;
	}

	public Date getTransferRelievingDate() {
		return transferRelievingDate;
	}

	public void setTransferRelievingDate(Date transferRelievingDate) {
		this.transferRelievingDate = transferRelievingDate;
	}

	public Date getTransferJoiningDate() {
		return transferJoiningDate;
	}

	public void setTransferJoiningDate(Date transferJoiningDate) {
		this.transferJoiningDate = transferJoiningDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
