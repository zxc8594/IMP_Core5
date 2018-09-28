package emrgen;

public class RegionGenerator extends StringGenerator {
	String[] country = {"Australia", "Brazil", "Canada", "Egypt" , "France", "Greece", "China", "Hungary", "Iceland", "India", "Italy", "Israel", "Ireland", "Japan", "South Korea", "North Korea", "Mexico", "Malaysia", "Pakistan", "Philippines", "Poland", "Portugal", "Russia", "Sweden", "Taiwan", "Turkey", "Ukraine", "United States", "Uzbekistan", "Vietnam", "Zimbabwe"};
	
	public String getRandomPostalCode() {
		String pc = "";
		for(int i=0; i<5; i++) {
			pc += getRandomNumber();
		}
		return pc;
	}
	
	public String getRandomCountry() {
		return country[randInt(country.length)];
	}
}
