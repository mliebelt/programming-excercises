package freshers.bmi;

public class NumberUtils {
	static long integer(final String value) {
		long number = 0;
		for (Character character : value.toCharArray()) {
			if (!Character.isDigit(character)) {
				break;
			} 
			number = 10 * number + (character - '0');
		}
		return number;
	}
}
