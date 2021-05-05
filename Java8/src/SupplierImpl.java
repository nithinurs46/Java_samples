
import java.util.function.Supplier;

public class SupplierImpl implements Supplier<String> {

	public String testValue = null;

	public SupplierImpl(String testValue) {
		this.testValue = testValue;
	}

	@Override
	public String get() {
		return testValue;
	}

}
