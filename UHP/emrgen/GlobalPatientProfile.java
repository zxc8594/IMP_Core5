package emrgen;

import java.util.UUID;

public class GlobalPatientProfile {
	// should be notified as table column
	String firstName;
	String lastName;
	String DOB;
	String gid;
	
	// not be notified
	int gender;
	
	RandomGenerator rand = new RandomGenerator();
	NameGenerator nameGen = new NameGenerator();
	DateGenerator dateGen = new DateGenerator();
	GenderGenerator genderGen = new GenderGenerator();
	
	public void generateFields() {
		int gender = genderGen.getRandomGender();
		this.gender = gender;
		String fullName = nameGen.getRandomName(gender);
		String[] splitName = fullName.split(" ");
		int age = rand.randInt(5, 90);
		UUID uuid = UUID.randomUUID();
		
		this.firstName = splitName[0];
		this.lastName = splitName[1];
		this.DOB = dateGen.getRandomBirthDateByAge(age);
		this.gid = uuid.toString();
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
	
	public String getGid() {
		return this.gid;
	}
	
	public int getGender() {
		return this.gender;
	}
}
