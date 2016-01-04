package list;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private Long id;
	
	private String name;

	public Person(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	public static void main(String[] args) {
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(1l,"t"));
		list.add(new Person(2l,"t"));
		list.add(new Person(4l,"t"));
		Person p = new Person(4l,"t");
		//list.add(p);
		System.out.println(list.contains(p));
		System.out.println(list);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + "]";
	}
	
	
}
