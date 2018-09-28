package emrgen;

public class Openemr_Patientdata extends MedicalFragment {
	long pid;
	String title;
	String language;
	String financial;
	String fname;
	String lname;
	String mname;
	String DOB;
	String street;
	String postal_code;
	String city;
	String state;
	String country;
	String country_code;
	String drivers_license;
	String ss;
	String occupation;
	String phone_home;
	String phone_cell;
	String status;	// marriage
	String date;
	String sex;
	String email;
	String race;
	long monthly_income;
	String billing_note;
	String pubid;
	
	
	public Openemr_Patientdata(String fragid, String name, String data, String ver) {
		super(fragid, name, data, ver);
	}
	
	public void generateFields(int id) {
		int married = genderGen.getRandomMarried();
		int gender = genderGen.getRandomGender();
		int age = rand.randInt(5, 90);
		
		this.pid = id;
		this.title = genderGen.getTitle(gender, married);
		this.language = stringGen.getRandomLanguage();
		this.financial = "";
		this.fname = nameGen.getRandomFName(gender);
		this.mname = nameGen.getRandomMName(gender);
		this.lname = nameGen.getRandomLName(gender);
		this.DOB = dateGen.getRandomBirthDateByAge(age);
		this.street = "";
		this.postal_code = regionGen.getRandomPostalCode();
		this.city = "";
		this.state = "";
		this.country = regionGen.getRandomCountry();
		this.country_code = regionGen.getRandomPostalCode();
		this.drivers_license = stringGen.getRandomNumbers(9);
		this.ss = stringGen.getRandomNumbers(9);
		this.occupation = stringGen.getRandomOccupation();
		this.phone_home = stringGen.getRandomPhoneNumberKR();
		this.phone_cell = stringGen.getRandomNumbers(10);
		this.status = genderGen.getMarriedString(married, "married", "unmarried");
		this.date = dateGen.getCurDate();
		this.sex = genderGen.getGenderString(gender, "male", "female");
		this.email = stringGen.getRandomEmail();
		this.race = stringGen.getRandomRace();
		this.monthly_income = rand.randInt(1, 100)*1000;
		this.billing_note = "";
		this.pubid = stringGen.getRandomId();
	}
	
	public void generateData() {
		this.data = "pid: " + String.valueOf(this.pid) + ", " + "title: " + String.valueOf(this.title) + ", " +
				"language;: " + this.language + ", " + "financial;: " + this.financial + ", " +
				"fname: " + String.valueOf(this.fname) + ", " + "lname: " + this.lname + ", " +
				"mname: " + String.valueOf(this.mname) + ", " + "DOB: " + String.valueOf(this.DOB) + ", " +
				"street: " + String.valueOf(this.street) + ", " + "postal_code: " + String.valueOf(this.postal_code) + ", " +
				"city: " + String.valueOf(this.city) + ", " + "state: " + String.valueOf(this.state) + ", " +
				"country: " + String.valueOf(this.country) + ", " + "country_code: " + String.valueOf(this.country_code) + ", " +
				"drivers_license: " + String.valueOf(this.drivers_license) + ", " + "ss: " + String.valueOf(this.ss) + ", " +
				"occupation: " + String.valueOf(this.occupation) + ", " + "phone_home: " + String.valueOf(this.phone_home) + ", " +
				"phone_cell: " + String.valueOf(this.phone_cell) + ", " + "status: " + String.valueOf(this.status) + ", " +
				"date: " + String.valueOf(this.date) + ", " + "sex: " + String.valueOf(this.sex) + ", " +
				"email: " + String.valueOf(this.email) + ", " + "race: " + String.valueOf(this.race) + ", " +
				"monthly_income: " + String.valueOf(this.monthly_income) + ", " + "phone_home: " + String.valueOf(this.phone_home) + ", " +
				"drivers_license: " + String.valueOf(this.drivers_license) + ", " + "billing_note: " + String.valueOf(this.billing_note) + ", " +
				"pubid: " + String.valueOf(this.pubid);
	}
	
	public void setPrivate(String first_name, String last_name, String dob, int gender) {
		this.fname = first_name;
		this.lname = last_name;
		this.DOB = dob;
		this.sex = genderGen.getGenderString(gender, "male", "female");
		int married;
		if(this.status.equals("married"))
			married = 0;
		else
			married = 1;
		this.title = genderGen.getTitle(gender, married);
	}
	
	public void generateFieldsDefault() {
		this.pid = 0;
		this.title = "0";
		this.language = "0";
		this.financial = "0";
		this.fname = "0";
		this.mname = "0";
		this.lname = "0";
		this.DOB = "0";
		this.street = "0";
		this.postal_code = "0";
		this.city = "0";
		this.state = "0";
		this.country = "0";
		this.country_code = "0";
		this.drivers_license = "0";
		this.ss = "0";
		this.occupation = "0";
		this.phone_home = "0";
		this.phone_cell = "0";
		this.status = "0";
		this.date = "0";
		this.sex = "0";
		this.email = "0";
		this.race = "0";
		this.monthly_income = 0;
		this.billing_note = "0";
		this.pubid = "0";
	}
}
