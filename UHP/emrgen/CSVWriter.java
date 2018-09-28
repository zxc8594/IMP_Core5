package emrgen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;

public class CSVWriter {
	public void createOneLineCSV(ArrayList<String> dataList, String filename, String filepath, char delimeter) {
		try {
			File file = new File(filepath);
			file.mkdirs();
			String realpath = filepath + '/' + filename + ".csv";
			BufferedWriter fw = new BufferedWriter(new FileWriter(realpath, true));
			int dataListLength = dataList.size();
			
			for(int i = 0; i < dataListLength; i++) {
				fw.write(dataList.get(i));
				if(i != dataListLength - 1)
					fw.write(delimeter);
			}
			
			fw.write('\n');
			
			fw.flush();
			fw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void createFullCSV(ArrayList<String> dataList, String filename, String filepath, char delimeter, int colVol) {
		try {
			File file = new File(filepath);
			file.mkdirs();
			String realpath = filepath + '/' + filename + ".csv";
			BufferedWriter fw = new BufferedWriter(new FileWriter(realpath, true));
			int dataListLength = dataList.size();
			
			for(int i = 0; i < dataListLength / colVol; i++) {
				for(int j = 0; j < colVol; j++) {
					fw.write(dataList.get(i * colVol + j));
					if(j != colVol - 1)
						fw.write(delimeter);
				}
				if(i != dataListLength / colVol - 1)
					fw.write('\n');
			}
			
			fw.flush();
			fw.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
