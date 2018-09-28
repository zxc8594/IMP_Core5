package emrgen;

import java.util.ArrayList;
import java.lang.Math;

public class Lstore {
	ArrayList<GlobalPatientProfile> GlobalPatientList = new ArrayList<GlobalPatientProfile>();
	ArrayList<GlobalFragmentProfile> GlobalFragmentList = new ArrayList<GlobalFragmentProfile>();
	CSVWriter cw = new CSVWriter();
	
	public void generateGlobalPatientList(int amount) {
		for(int i=0; i<amount; i++) {
			GlobalPatientProfile gp = new GlobalPatientProfile();
			gp.generateFields();
			this.GlobalPatientList.add(gp);
		}
	}
	
	public void generateGlobalFragmentList(String fragName, float rate) {	// 0 < rate <= 1
		if(rate <= 0 || rate > 1) {
			System.out.println("Fragment rate (a parm of generateGlobalFramentList) should be: 0 < rate <= 1");
			System.exit(1);
		}
		
		int patientVol = this.GlobalPatientList.size();
		int limit =  Math.round(patientVol*rate);
		
		for(int i=0; i<patientVol; i++) {
			if(i==limit) {
				break;
			}
			GlobalPatientProfile gp = this.GlobalPatientList.get(i);
			for(int j=0; j<10; j++) {	// 10 versions per one fragment
				GlobalFragmentProfile gf = new GlobalFragmentProfile(gp.getGid(), gp.getFirstName(), gp.getLastName(), gp.getDOB(), gp.getGender());
				gf.generateFields(fragName);
				this.GlobalFragmentList.add(gf);
			}
		}
	}
	
	public ArrayList<GlobalFragmentProfile> getGlobalFragmentList() {
		return this.GlobalFragmentList;
	}
	
	public void writePatientProfiles(String filename, String path) {
		ArrayList<String> GlobalPatientData = new ArrayList<String>();
		int patientVol = this.GlobalPatientList.size();
		
		for(int i = 0; i < patientVol; i++) {
			GlobalPatientProfile gp = this.GlobalPatientList.get(i);
			GlobalPatientData.add(gp.getFirstName());
			GlobalPatientData.add(gp.getLastName());
			GlobalPatientData.add(gp.getDOB());
			GlobalPatientData.add(gp.getGid());
		}
		
		cw.createFullCSV(GlobalPatientData, filename, path, ',', 4);
	}
	
	public void writeFragmentProfiles(String filename, String path) {
		ArrayList<String> GlobalFragmentData = new ArrayList<String>();
		int fragmentVol = this.GlobalFragmentList.size();
		
		for(int i = 0; i < fragmentVol; i++) {
			GlobalFragmentProfile gf = this.GlobalFragmentList.get(i);
			GlobalFragmentData.add(gf.getGid());
			GlobalFragmentData.add(gf.getFragmentId());
			GlobalFragmentData.add(gf.getFragmentName());
		}
		
		cw.createFullCSV(GlobalFragmentData, filename, path, ',', 3);
	}
}
