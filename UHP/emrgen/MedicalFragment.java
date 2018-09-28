package emrgen;

import java.util.ArrayList;

public abstract class MedicalFragment {
	String fragmentId;	// fragId should be different between all fragments
	String name;	// the type of fragment
	String data;
	String version;
	
	RandomGenerator rand = new RandomGenerator();
	NameGenerator nameGen = new NameGenerator();
	DateGenerator dateGen = new DateGenerator();
	GenderGenerator genderGen = new GenderGenerator();
	StringGenerator stringGen = new StringGenerator();
	RegionGenerator regionGen = new RegionGenerator();
	
	CSVWriter cw = new CSVWriter();
	ArrayList<String> dataList = new ArrayList<String>();
	
	public MedicalFragment(String fragid, String name, String data, String ver) {
		this.setFragId(fragid);
		this.setName(name);
		this.setData(data);
		this.setVersion(ver);
	}
	
	public void setFragId(String fragid) {
		this.fragmentId = fragid;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setVersion(String ver) {
		this.version = ver;
	}
	
	public void printInfo() {
		System.out.println(this.fragmentId + "\n" + this.name+ "\n" + this.data + "\n" + this.version + "\n");
	}
	
	public void makeDataList() {
		dataList.add(this.fragmentId);
		dataList.add(this.name);
		dataList.add(this.data);
		dataList.add(String.valueOf(this.version));
	}
	
	public void writeFragment(String filename, String filepath) {
		this.makeDataList();
		cw.createOneLineCSV(dataList, filename, filepath, '|');
	}
	
	public String genderConvert(String gender, String male, String female) {	// 'male' -> male, 'female' -> female
		if(gender.equals("male"))
			return male;
		return female;
	}
	
	public abstract void generateFields(int id);	// the parameter id should be different between the fragments which have the same name
	public abstract void generateData();
	public abstract void setPrivate(String first_name, String last_name, String dob, int gender);	// set the information of name, date of birth, and gender to specific (gender: male = 0, female = 1)
	public abstract void generateFieldsDefault();
}
