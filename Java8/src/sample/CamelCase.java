package sample;

public class CamelCase {
	public static String CamelCaseTest(String str) {
		int length = str.length();
		char ch[] = str.toCharArray();
		for (int i = 0; i < length; i++) {
			if (ch[i] == ' ' || ch[i] == '-' || ch[i] == '%') {
				ch[i + 1] = Character.toUpperCase(ch[i + 1]);
				continue;
			}
		}
		str = String.valueOf(ch);
		str = str.replaceAll("[^a-zA-Z0-9]", " ");
	    str = str.replaceAll(" ", "");
		return str;
	}

	public static void main(String[] args) {
		// keep this function call here
		String s = "a b c d-e-f%g";
		System.out.print(CamelCaseTest(s));
	}
}
