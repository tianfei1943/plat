package gson.domain;

import java.util.List;

public class Temp {

	private List<Student> insertedList;
	
	private List<Student> updatedList;
	
	private List<Student> deletedList;

	public Temp(List<Student> insertedList, List<Student> updatedList,
			List<Student> deletedList) {
		super();
		this.insertedList = insertedList;
		this.updatedList = updatedList;
		this.deletedList = deletedList;
	}

	public List<Student> getInsertedList() {
		return insertedList;
	}

	public List<Student> getUpdatedList() {
		return updatedList;
	}

	public List<Student> getDeletedList() {
		return deletedList;
	}
	
	
	
}
