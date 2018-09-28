package emrgen;

public class Krsiloemr_tblPatient extends MedicalFragment {
	long PatientID;
	int PatientMRNNo;
	String PatientName;
	String DateOfBirth;
	int Age;
	String Gender;
	int SymptomsAndSigns;
	int ClinicalHistory;
	int PhysicalExam;
	int ECG;
	float NTproBNP;
	float BNP;
	float LVEF;
	float LAVI;
	float LVMI;
	float Ee;
	float eSeptal;
	float LongitudinalStrain;
	float TRV;
	String EncounterDate;
	
	public Krsiloemr_tblPatient(String fragid, String name, String data, String ver) {
		super(fragid, name, data, ver);
	}
	
	public void generateFields(int id) {
		int gender = genderGen.getRandomGender();
		
		this.PatientID = id;
		this.PatientMRNNo = rand.randInt(1, 10000);
		this.PatientName = nameGen.getRandomName(gender);
		this.Age = rand.randInt(5, 90);
		this.DateOfBirth = dateGen.getRandomBirthDateByAge(this.Age);
		this.Gender = genderGen.getGenderString(gender, "M", "F");
		this.SymptomsAndSigns = rand.randBool();
		this.ClinicalHistory = rand.randBool();
		this.PhysicalExam = rand.randBool();
		this.ECG = rand.randBool();
		this.NTproBNP = rand.randFloat(10,  2000);
		this.BNP = 0;	// not provided
		this.LVEF = rand.randFloat(30, 75);
		this.LAVI = rand.randFloat(15,  100);
		this.LVMI = rand.randFloat(50,  150);
		this.Ee = rand.randFloat(5,  20);
		this.eSeptal = rand.randFloat(3, 11);
		this.LongitudinalStrain = rand.randFloat(7,  20);
		this.TRV = rand.randFloat(1,  4);
		this.EncounterDate = dateGen.getCurDate();
	}
	
	public void generateData() {
		this.data = "PatientId: " + String.valueOf(this.PatientID) + ", " + "PatientMRNNo: " + String.valueOf(this.PatientMRNNo) + ", " +
				"PatientName: " + this.PatientName + ", " + "DateOfBirth: " + this.DateOfBirth + ", " +
				"Age: " + String.valueOf(this.Age) + ", " + "Gender: " + this.Gender + ", " +
				"SymptomsAndSigns: " + String.valueOf(this.SymptomsAndSigns) + ", " + "ClinicalHistory: " + String.valueOf(this.ClinicalHistory) + ", " +
				"PhysicalExam: " + String.valueOf(this.PhysicalExam) + ", " + "ECG: " + String.valueOf(this.ECG) + ", " +
				"NTproBNP: " + String.valueOf(this.NTproBNP) + ", " + "BNP: " + String.valueOf(this.BNP) + ", " +
				"LVEF: " + String.valueOf(this.LVEF) + ", " + "LAVI: " + String.valueOf(this.LAVI) + ", " +
				"Ee: " + String.valueOf(this.Ee) + ", " + "eSeptal: " + String.valueOf(this.eSeptal) + ", " +
				"LongitudinalStrain: " + String.valueOf(this.LongitudinalStrain) + ", " + "TRV: " + String.valueOf(this.TRV) + ", " +
				"EncounterDate: " + this.EncounterDate;
	}
	
	public void setPrivate(String first_name, String last_name, String dob, int gender) {
		String fullName = first_name + " " + last_name;
		this.PatientName = fullName;
		this.DateOfBirth = dob;
		this.Gender = genderGen.getGenderString(gender, "M", "F");
		this.Age = dateGen.getAgeFromDOB(dob);
	}
	
	public void generateFieldsDefault() {
		this.PatientID = 0;
		this.PatientMRNNo = 0;
		this.PatientName = "0";
		this.Age = 0;
		this.DateOfBirth = "0";
		this.Gender = "0";
		this.SymptomsAndSigns = 0;
		this.ClinicalHistory = 0;
		this.PhysicalExam = 0;
		this.ECG = 0;
		this.NTproBNP = 0;
		this.BNP = 0;
		this.LVEF = 0;
		this.LAVI = 0;
		this.LVMI = 0;
		this.Ee = 0;
		this.eSeptal = 0;
		this.LongitudinalStrain = 0;
		this.TRV = 0;
		this.EncounterDate = "0";
	}
}
