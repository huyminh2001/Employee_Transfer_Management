package entities;

public class Location {
	private int id;
	private String name;
	private double allowances;
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Location(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	

	public Location(int id, String name, double allowances) {
		super();
		this.id = id;
		this.name = name;
		this.allowances = allowances;
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

	

	public double getAllowances() {
		return allowances;
	}

	public void setAllowances(double allowances) {
		this.allowances = allowances;
	}
	
	
}
