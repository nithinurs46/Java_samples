
import java.util.Optional;
import java.util.function.Supplier;

public class OptionalTest {

	public static void main(String[] args) {
		String nullName = null;

		Supplier<String> s = new Supplier<String>() {
			@Override
			public String get() {
				return "supplier value";
			}
		};

		String name = Optional.ofNullable(nullName).orElseGet(s);
		System.out.println(name);

		String name1 = Optional.ofNullable(nullName).orElseGet(() -> "john");
		System.out.println(name1);

		Supplier<String> s1 = new SupplierImpl("Supplier 1");
		String name2 = Optional.ofNullable(nullName).orElseGet(s1);
		System.out.println(name2);

		OptionalTest test = new OptionalTest();
		test.testMethd();

		Optional<String> name3 = Optional.ofNullable("test");
		System.out.println(name3.get());
		// throw exception if null
		String name4 = Optional.ofNullable("test1").orElseThrow(IllegalArgumentException::new);
		System.out.println(name4);
		
		test.filterTest();

	}

	public void testMethd() {
		String text = "A";
		//default method does not get invoked even if text is present
		String defaultText = (String) Optional.ofNullable(text).orElseGet(this::getMyDefault);
		System.out.println(defaultText);

		System.out.println("**");

		//default method gets invoked even if text is present
		defaultText = (String) Optional.ofNullable(text).orElse(getMyDefault());
		System.out.println(defaultText);
	}

	public String getMyDefault() {
		System.out.println("Getting Default Value");
		return "Default Value";
	}

	public void filterTest() {
		Integer year = 2016;
		Optional<Integer> yearOptional = Optional.of(year);
		boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
		System.out.println(is2016);
		boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
		System.out.println(is2017);
		
		String data = "abd";
		//throws NPE if data is null
		Optional<String> strOptional = Optional.of(data);
		boolean isReqdData = strOptional.filter(s -> s.equals("abd")).isPresent();
		System.out.println(isReqdData);
		
		//does not throw NPE
		isReqdData = Optional.ofNullable(null).filter(s -> s.equals("abd")).isPresent();
		System.out.println(isReqdData);
	}
}
