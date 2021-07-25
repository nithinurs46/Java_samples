
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

interface CharCheck {
	String compareString(String value);
}
//Pgm to check if 2nd char and last but one char in a string is same or not using Java 8
public class StringCharTest {

	public static void main(String[] args) {

		// Using Function, functional interface
		Function<String, String> func = new Function<String, String>() {
			@Override
			public String apply(String val) {
				char secChar = val.charAt(1);
				char lastButOneChar = val.charAt(val.length() - 2);
				int compareChar = Character.compare(secChar, lastButOneChar);
				if (compareChar == 0) {
					return "2nd and last but one char match, matching char is:- " + Character.toString(lastButOneChar)
							+ " *** Input String: " + val;
				}
				return "No, 2nd and last but one char dont match for input: " + val;
			}
		};

		List<String> temp = Arrays.asList("Defeat", "Meet", "Feet");
		temp.forEach(s -> System.out.println(func.apply(s)));

		System.out.println("\n");

		// Using custom functional interface.
		CharCheck check = (value) -> {
			char secChar = value.charAt(1);
			char lastButOneChar = value.charAt(value.length() - 2);
			int compareChar = Character.compare(secChar, lastButOneChar);
			if (compareChar == 0) {
				return "2nd and last but one char match, matching char is:- " + Character.toString(lastButOneChar)
						+ " *** Input String: " + value;
			}
			return "No, 2nd and last but one char dont match for input: " + value;
		};
		temp.forEach(s -> System.out.println(check.compareString(s)));
		
		List<String> matchingChars = temp.stream().filter(value -> value.charAt(1) == value.charAt(value.length() - 2))
				.collect(Collectors.toList());
		System.out.println(matchingChars);

	}

}
