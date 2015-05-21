package gson.domain;

public class School {
	
	private String name;

	public School(String name) {
		super();
		this.name = name;
	}
	
	

	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return "School [name=" + name + "]";
	}
	
	

}
