package builder;

public class PhoneBuilder {

	private String OS;
	private String ram;
	private String processor;
	private String battery;

	public PhoneBuilder setOS(String OS) {
		this.OS = OS;
		return this;
	}

	public PhoneBuilder setRam(String ram) {
		this.ram = ram;
		return this;
	}

	public PhoneBuilder setProcessor(String processor) {
		this.processor = processor;
		return this;
	}

	public PhoneBuilder setBattery(String battery) {
		this.battery = battery;
		return this;
	}

	public Phone getPhone() {
		return new Phone(OS, ram, processor, battery);
	}
}
