package emrgen;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateGenerator extends RandomGenerator {
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
	Date date = new Date();
	
	public String getCurYear() {
		int curYear = Calendar.YEAR;
		return String.format("%02d", curYear);
	}
	
	public String getCurMonth() {
		int curMonth = Calendar.MONTH;
		return String.format("%02d", curMonth);
	}
	
	public String getCurDay() {
		int curDay = Calendar.DAY_OF_MONTH;
		return String.format("%02d", curDay);
	}
	
	public String getCurDate() {
		return getCurYear() + getCurMonth() + getCurDay();
	}
	
	public String getRandomBirthDateByAge(int age) {
		int dob_y = Calendar.YEAR - age;
		int dob_m = randInt(1, 12);
		int dob_d = randInt(1, 28);
		return String.valueOf(dob_y) + String.format("%02d", dob_m) + String.format("%02d", dob_d);
	}
	
	public int getAgeFromDOB(String DOB) {
		return Integer.valueOf(this.getCurYear()) - Integer.valueOf(DOB.substring(0, 4));
	}
}
