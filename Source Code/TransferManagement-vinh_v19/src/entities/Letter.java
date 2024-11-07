package entities;

public class Letter {
	private int id;
	private String name;
	private int recordId;
	private String content;
	
	public Letter() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public Letter(int id, String name, int recordId, String content) {
		super();
		this.id = id;
		this.name = name;
		this.recordId = recordId;
		this.content = content;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
