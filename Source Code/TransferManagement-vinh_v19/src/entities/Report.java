package entities;

import java.util.Date;

public class Report {
	private int id;
	private String name;
	private int employeeId;
	private int recordId;
	private String content;
	private Date date;
	
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Report(int id, String name, int employeeId, int recordId, String content, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.employeeId = employeeId;
		this.recordId = recordId;
		this.content = content;
		this.date = date;
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


	public int getRecordId() {
		return recordId;
	}


	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
