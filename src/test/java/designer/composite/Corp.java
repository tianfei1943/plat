package designer.composite;

public class Corp {
	
	private String name;
	
	private String position;
	
	private double salary;

	public Corp(String name, String position, double salary) {
		super();
		this.name = name;
		this.position = position;
		this.salary = salary;
	}
	
	public String getInfo(){
		return "Corp [name=" + name + ", position=" + position + ", salary="
				+ salary + "]";
	}

}
