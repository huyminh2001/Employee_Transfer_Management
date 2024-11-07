package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidateHelper {
	private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";

	private static final String STRING_REGEX = "^[a-zA-Z ]+$";
	
	private static final String USERNAME_REGEX = "^[a-zA-Z0-9]+$";

	public static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
	    Matcher matcher = pattern.matcher(email);
	    return matcher.matches();
	}
	
	public static boolean isUsername(String username) {
		Pattern pattern = Pattern.compile(USERNAME_REGEX);
	    Matcher matcher = pattern.matcher(username);
	    return matcher.matches();
	}
	
	public static boolean isText(String text) {
		Pattern pattern = Pattern.compile(STRING_REGEX);
		Matcher matcher = pattern.matcher(text);
		return matcher.matches();
	}
	
	public static boolean isNumber(String number) {
		try {
			Double.parseDouble(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
}
