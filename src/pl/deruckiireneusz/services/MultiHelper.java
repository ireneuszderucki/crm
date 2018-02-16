package pl.deruckiireneusz.services;

public class MultiHelper {
	
	static public boolean atLeastThreeChars(String string) {
		if (string.length()>2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	static public boolean checkEmail(String string) {
		if (string.length()>4 && string.contains("@")) {
			return true;
		}
		else {
			return false;
		}
	}

}
