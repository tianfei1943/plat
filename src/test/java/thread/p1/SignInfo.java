package thread.p1;

public class SignInfo {
	
	public String name;
	
	public String locationId;
	
	public String key;
	
	public SignInfo(){
		
	}
	
	public SignInfo(String key){
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
	
}
