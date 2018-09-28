package emrgen;

import java.io.IOException;

public class Driver extends IOException {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		
		if(args.length != 2) {
			System.out.println("Usage: emrgen.jar $path $number_of_users");
			System.exit(1);
		}
		
		try {
			String buildPath = args[0];
			String lpn = "lstore_patients";
			String lfn = "lstore_fragments";
			SampleUHPGenerator sg = new SampleUHPGenerator();
			
			// generate global patients for Lstore
			sg.generateLstore_Patients(Integer.valueOf(args[1]));
			
			// generate global profiles of fragments for Lstore
			sg.generateLstore_Fragments("krsiloemr_tblpatient", 1f);
			sg.generateLstore_Fragments("openemr_patientdata", 1f);
			
			// write Lstore
			sg.writeLstore(lpn, lfn, buildPath);
			
			// generate and write actual fragments referencing Lstore
			sg.generateAndWriteFragments(buildPath);
		}
		catch(Exception e) {
			System.out.println("Error occured: please check the parameters.");
			e.printStackTrace();
		}
	}
}
