package emrgen;

public class StringGenerator extends RandomGenerator {
	String[] mailServer = {"gmail.com", "naver.com", "khu.ac.kr", "hanmail.net", "oslab.khu.ac.kr"};
	String[] language = {"English", "Chinese", "Japanese", "Spanish", "Korean", "Irish", "Russian", "French", "Uzbek", "Turkmen", "Ukrainian", "Persian"};
	String[] occupation = {"Student", "Worker", "Jobless"};
	String[] race = {"White", "Black", "Hispanic", "East Asian", "Middle East", "East South Asian"};
	
	public String getRandomChar() {	// a - z
		return String.valueOf((char) ((int) randInt(97, 122)));
	}
	
	public String getRandomNumber() {	// 0 - 9
		return String.valueOf(randInt(0, 9));
	}
	
	public String getRandomString(int len) {
		String str = "";
		for(int i=0; i<len; i++) {
			str += this.getRandomChar();
		}
		return str;
	}
	
	public String getRandomNumbers(int len) {
		String str = "";
		for(int i=0; i<len; i++) {
			str += this.getRandomNumber();
		}
		return str;
	}
	
	public String getRandomId() {
		String front = new String();
		String back = new String();
		int fLen = randInt(3, 5);
		int bLen = randInt(2, 4);
		
		front = this.getRandomString(fLen);
		back = this.getRandomNumbers(bLen);
		
		return front + back;
	}
	
	public String getRandomEmail() {
		return getRandomId() + "@" + mailServer[randInt(mailServer.length)];
	}
	
	public String getRandomLanguage() {
		return language[randInt(language.length)];
	}
	
	public String getRandomOccupation() {
		return occupation[randInt(occupation.length)];
	}
	
	public String getRandomPhoneNumberKR() {
		return "010" + getRandomNumbers(8);
	}
	
	public String getRandomRace() {
		return race[randInt(race.length)];
	}
}
