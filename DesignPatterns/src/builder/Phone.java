package builder;

public class Phone {

	private String OS;
	private String ram;
	private String processor;
	private String battery;
	
	public Phone(String oS, String ram, String processor, String battery) {
		super();
		OS = oS;
		this.ram = ram;
		this.processor = processor;
		this.battery = battery;
	}
	
	@Override
	public String toString() {
		return "Phone [OS=" + OS + ", ram=" + ram + ", processor=" + processor + ", battery=" + battery + "]";
	}
	
}
