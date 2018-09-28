package emrgen;

import java.util.ArrayList;
import java.util.UUID;

public class SampleUHPGenerator {
	Lstore lstore = new Lstore();
	
	public void generateLstore_Patients(int amount) {	// build Lstore: PatientUHPrId
		//System.out.println("Building Lstore: Patient Profiles..");
		lstore.generateGlobalPatientList(amount);
		//System.out.println("Done\n");
	}
	
	public void generateLstore_Fragments(String fragName, float rate) {	// build Lstore: MedicalFragment
		//System.out.println("Building Lstore: Fragment Profiles..");
		lstore.generateGlobalFragmentList(fragName, rate);
		//System.out.println("Done\n");
	}
	
	public void writeLstore(String ppFilename, String fpFilename, String path) {
		//System.out.println("Writing Lstore..");
		lstore.writePatientProfiles(ppFilename, path + "/patientuhprid");
		lstore.writeFragmentProfiles(fpFilename, path + "/medicalfragment");
		//System.out.println("Done\n");
	}
	
	public void generateAndWriteFragments(String path) {	// generate Fragments referencing Lstore
		//System.out.println("Generating and Writing Fragments..");
		ArrayList<GlobalFragmentProfile> GlobalFragmentList = lstore.getGlobalFragmentList();
		int fragmentVol = GlobalFragmentList.size();
		MedicalFragment fragment;
		
		// define each fragment's patient id
		int krsiloemr_tblpatient_id = 0;
		int openemr_patientdata_id = 0;
		
		for(int i=0; i<fragmentVol; i++)
		{
			GlobalFragmentProfile gf = GlobalFragmentList.get(i);
			String gid = gf.getGid();
			String fragId = gf.getFragmentId();
			String fragName = gf.getFragmentName();
			String firstName = gf.getFirstName();
			String lastName = gf.getLastName();
			String DOB = gf.getDOB();
			int gender = gf.getGender();
			
			switch(fragName) {
				case "krsiloemr_tblpatient":
					fragment = new Krsiloemr_tblPatient(fragId, "krsiloemr_tblpatient", "default_data", UUID.randomUUID().toString());
					fragment.generateFields(krsiloemr_tblpatient_id);
					fragment.setPrivate(firstName, lastName, DOB, gender);
					fragment.generateData();
					fragment.writeFragment(gid, path + "/UHP");
					krsiloemr_tblpatient_id++;
					break;
				case "openemr_patientdata":
					fragment = new Openemr_Patientdata(fragId, "openemr_patientdata", "default_data", UUID.randomUUID().toString());
					fragment.generateFields(openemr_patientdata_id);
					fragment.setPrivate(firstName, lastName, DOB, gender);
					fragment.generateData();
					fragment.writeFragment(gid, path + "/UHP/");
					openemr_patientdata_id++;
					break;
				default:
					break;
			}
		}
		System.out.println("Done");
	}
}
