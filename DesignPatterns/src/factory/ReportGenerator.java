package factory;

public abstract class ReportGenerator {
	void readXml() {
		System.out.println("Reading the xml");
	}

	abstract void generateReport();
}
