package designer.composite;

import java.util.ArrayList;
import java.util.List;

public class Branch extends Corp {

	private List<Corp> subordinetList = new ArrayList<Corp>(30);
	
	public Branch(String name, String position, double salary) {
		super(name, position, salary);
	}
	
	public void addSubordinet(Corp corp){
		this.subordinetList.add(corp);
	}
	
	public List<Corp> getSubordinet(){
		return this.subordinetList;
	}

}
