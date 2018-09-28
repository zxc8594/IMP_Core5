package emrgen;

import java.util.UUID;

public class GlobalFragmentProfile {
	// to be notified as table column
	String gid;
	String fragmentId;
	String fragmentName;
	
	// not to be notified
	String firstName;
	String lastName;
	String DOB;
	int gender;
	
	public GlobalFragmentProfile(String gid, String firstName, String lastName, String DOB, int gender) {
		this.gid = gid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.DOB = DOB;
		this.gender = gender;
	}
	
	public void generateFields(String fragName) {
		UUID uuid = UUID.randomUUID();
		this.fragmentId = uuid.toString();
		this.fragmentName = fragName;
	}
	
	public String getGid() {
		return this.gid;
	}
	
	public String getFragmentId() {
		return this.fragmentId; 
	}
	
	public String getFragmentName() {
		return this.fragmentName;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getDOB() {
		return this.DOB;
	}
	
	public int getGender() {
		return this.gender;
	}
}
